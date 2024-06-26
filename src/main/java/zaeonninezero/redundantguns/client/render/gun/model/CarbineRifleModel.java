package zaeonninezero.redundantguns.client.render.gun.model;

import java.lang.reflect.Method;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.guns.GunMod;
import com.mrcrayfish.guns.client.GunModel;
import com.mrcrayfish.guns.client.handler.GunRenderingHandler;
import com.mrcrayfish.guns.client.handler.ReloadHandler;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.GunAnimationHelper;
import com.mrcrayfish.guns.client.util.GunReloadAnimationHelper;
import com.mrcrayfish.guns.client.util.PropertyHelper;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.item.attachment.IAttachment;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import zaeonninezero.redundantguns.client.RedundantSpecialModels;

/**
 * Author: MrCrayfish
 * Modified by zaeonNineZero for Nine Zero's Gun Expansion
 * Attachment detection logic based off of code from Mo' Guns by Bomb787 and AlanorMiga (MigaMi)
 */
public class CarbineRifleModel implements IOverrideModel
{
	private boolean disableAnimations = false;
	private Method getReloadCycleProgress = null;
	private Method getAnimationTrans = null;
	
	@Override
	// This class renders a multi-part model depending on various NBT values and equipped attachments.
	
	// We start by declaring our render function that will handle rendering the core baked model (which is a non-moving part).
    public void render(float partialTicks, ItemTransforms.TransformType transformType, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
     // Select the Baked Model we'll be rendering, based on the value of the CustomModelData tag.
        BakedModel bakedModel = RedundantSpecialModels.CARBINE_RIFLE_BASE.getModel();
        if (getVariant(stack, "BaseVariant") == 1)
        bakedModel = RedundantSpecialModels.CARBINE_RIFLE_BASE_1.getModel();
        Minecraft.getInstance().getItemRenderer().render(stack, ItemTransforms.TransformType.NONE, false, poseStack, buffer, light, overlay, GunModel.wrap(bakedModel));
        
        // Render a selected model based on the "HandguardVariant" NBT tag.
    	BakedModel handguardModel = RedundantSpecialModels.CARBINE_RIFLE_HANDGUARD_0.getModel();
        if (getVariant(stack, "HandguardVariant") == 1)
        handguardModel = RedundantSpecialModels.CARBINE_RIFLE_HANDGUARD_1.getModel();
        RenderUtil.renderModel(handguardModel, transformType, null, stack, parent, poseStack, buffer, light, overlay);
        
        // Render the rear iron sight element, which is only present when a scope is not attached.
        // We have to grab the gun's scope attachment slot and check whether it is empty or not.
        // If the isEmpty function returns true, then we render the iron sights.
		ItemStack attachmentStack = Gun.getAttachment(IAttachment.Type.SCOPE, stack);
        if(attachmentStack.isEmpty())
		{
            // Render a selected model based on the "SightVariant" NBT tag.
        	BakedModel sightModel = RedundantSpecialModels.CARBINE_RIFLE_REARSIGHT.getModel();
            if (getVariant(stack, "SightVariant") == 1)
            sightModel = (getVariant(stack, "BaseVariant") == 1 ? RedundantSpecialModels.CARBINE_RIFLE_CARRYHANDLE_1.getModel() : RedundantSpecialModels.CARBINE_RIFLE_CARRYHANDLE.getModel());
            RenderUtil.renderModel(sightModel, transformType, null, stack, parent, poseStack, buffer, light, overlay);
		}

		// Special animated segment for compat with the CGM Expanded fork.
        // First, some variables for animation building
        boolean isPlayer = (entity != null && entity.equals(Minecraft.getInstance().player));
        boolean isFirstPerson = (transformType == ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND || transformType == ItemTransforms.TransformType.FIRST_PERSON_LEFT_HAND);
        
        Vec3 translations = Vec3.ZERO;
        Vec3 rotations = Vec3.ZERO;
        String animType = "none";
        
        if(isPlayer && isFirstPerson && !disableAnimations)
        {
        	try {
        			translations = GunAnimationHelper.getSmartAnimationTrans(stack, (Player) entity, partialTicks, "magazine");
        	        rotations = GunAnimationHelper.getSmartAnimationRot(stack, (Player) entity, partialTicks, "magazine");
        	        animType = GunAnimationHelper.getSmartAnimationType(stack, (Player) entity, partialTicks);
        		}
        		catch(Exception e) {
                	GunMod.LOGGER.error("Redundant Guns encountered an error trying to apply animations, disabling animation compat.");
                	e.printStackTrace();
                	disableAnimations = true;
        		}
        }
        
        poseStack.pushPose();
		// Now we apply our transformations.
		// All we need to do is move the model based on the cooldown variable.
        if(isPlayer && !disableAnimations)
        {
        	if(translations!=Vec3.ZERO)
        	poseStack.translate(translations.x*0.0625, translations.y*0.0625, translations.z*0.0625);
        	if(rotations!=Vec3.ZERO)
        	GunAnimationHelper.rotateAroundOffset(poseStack, rotations, animType, stack, "magazine");
    	}
		// Our transformations are done - now we can render the model.
        RenderUtil.renderModel(RedundantSpecialModels.CARBINE_RIFLE_MAGAZINE.getModel(), transformType, null, stack, parent, poseStack, buffer, light, overlay);
		// Pop pose to compile everything in the render matrix.
        poseStack.popPose();
    }
    
    //NBT fetch code for skin variants - ported from the "hasAmmo" function under common/Gun.java
    public static int getVariant(ItemStack gunStack, String tag_name)
    {
        CompoundTag tag = gunStack.getOrCreateTag();
        return tag.getInt(tag_name);
    }
}