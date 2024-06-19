package zaeonninezero.redundantguns.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.client.GunModel;
import zaeonninezero.nzgmaddon.client.SpecialModels;
import zaeonninezero.redundantguns.client.RedundantSpecialModels;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.item.GunItem;
import com.mrcrayfish.guns.item.attachment.IAttachment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Author: MrCrayfish
 * Modified by zaeonNineZero for Nine Zero's Gun Expansion
 * Attachment detection logic based off of code from Mo' Guns by Bomb787 and AlanorMiga (MigaMi)
 */
public class CarbineRifleModel implements IOverrideModel
{
    @Override
	// This class renders a multi-part model depending on various NBT values and equipped attachments.
	
	// We start by declaring our render function that will handle rendering the core baked model (which is a non-moving part).
    public void render(float partialTicks, ItemTransforms.TransformType transformType, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
		// Render the item's BakedModel, which will serve as the core of our custom model.
        BakedModel bakedModel = RedundantSpecialModels.CARBINE_RIFLE_BASE.getModel();
        Minecraft.getInstance().getItemRenderer().render(stack, ItemTransforms.TransformType.NONE, false, poseStack, buffer, light, overlay, GunModel.wrap(bakedModel));
        
        // Render a selected model based on the "HandguardVariant" NBT tag.
    	BakedModel handguardModel = RedundantSpecialModels.CARBINE_RIFLE_HANDGUARD_0.getModel();
        if (getVariant(stack, "handguard_variant") == 1)
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
            if (getVariant(stack, "sight_variant") == 1)
            sightModel = RedundantSpecialModels.CARBINE_RIFLE_CARRYHANDLE.getModel();
            RenderUtil.renderModel(sightModel, transformType, null, stack, parent, poseStack, buffer, light, overlay);
		}

		// Since this model doesn't have animations, our code can end here.
    }
    
    //NBT fetch code for skin variants - ported from the "hasAmmo" function under common/Gun.java
    public static int getVariant(ItemStack gunStack, String tag_name)
    {
        CompoundTag tag = gunStack.getOrCreateTag();
        return tag.getInt(tag_name);
    }
}