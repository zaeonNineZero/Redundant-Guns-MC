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
	
	@Override
	// This class renders a model with support for NBT and attachment based part variations
	// and custom animations from CGM Expanded.
	
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
        boolean isPlayer = entity != null && entity.equals(Minecraft.getInstance().player);
        boolean isFirstPerson = (transformType.firstPerson());
        
        Vec3 magTranslations = Vec3.ZERO;
        Vec3 magRotations = Vec3.ZERO;
        Vec3 magRotOffset = Vec3.ZERO;
        
        if(isPlayer && isFirstPerson && !disableAnimations)
        {
        	try {
					Player player = (Player) entity;
					
        			magTranslations = GunAnimationHelper.getSmartAnimationTrans(stack, player, partialTicks, "magazine");
        	        magRotations = GunAnimationHelper.getSmartAnimationRot(stack, player, partialTicks, "magazine");
        	        magRotOffset = GunAnimationHelper.getSmartAnimationRotOffset(stack, player, partialTicks, "magazine");
        		}
        		catch(Exception e) {
                	GunMod.LOGGER.error("Redundant Guns encountered an error trying to apply animations.");
                	e.printStackTrace();
                	disableAnimations = true;
        		}
        }
        
        poseStack.pushPose();
		// Now we apply our transformations.
        if(isPlayer && !disableAnimations)
        {
        	if(magTranslations!=Vec3.ZERO)
        	poseStack.translate(magTranslations.x*0.0625, magTranslations.y*0.0625, magTranslations.z*0.0625);
        	if(magRotations!=Vec3.ZERO)
               GunAnimationHelper.rotateAroundOffset(poseStack, magRotations, magRotOffset);
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