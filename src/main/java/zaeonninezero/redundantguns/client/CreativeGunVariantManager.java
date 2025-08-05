package zaeonninezero.redundantguns.client;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import zaeonninezero.redundantguns.init.initItems;

public class CreativeGunVariantManager
{
	public static void addItemVariants(NonNullList<ItemStack> items)
    {
        // Ranger Assault Rifle, Variant 1
    	ItemStack rangerar_1 = new ItemStack(initItems.RANGER_ASSAULT_RIFLE.get());
    	{
    		CompoundTag tag = rangerar_1.getOrCreateTag();
        	tag.putInt("AmmoCount", initItems.RANGER_ASSAULT_RIFLE.get().getGun().getGeneral().getMaxAmmo());
    		tag.putInt("BaseVariant", 1);
    	}
    	items.add(rangerar_1);
    	
    	
        // Carbine Rifle, Variant 1
    	ItemStack carbinerrifle_1 = new ItemStack(initItems.CARBINE_RIFLE.get());
    	{
    		CompoundTag tag = carbinerrifle_1.getOrCreateTag();
        	tag.putInt("AmmoCount", initItems.CARBINE_RIFLE.get().getGun().getGeneral().getMaxAmmo());
    		tag.putInt("HandguardVariant", 1);
    		tag.putInt("SightVariant", 1);
    		tag.putInt("BaseVariant", 1);
    	}
    	items.add(carbinerrifle_1);
        // Carbine Rifle, Variant 2
    	ItemStack carbinerrifle_2 = new ItemStack(initItems.CARBINE_RIFLE.get());
    	{
    		CompoundTag tag = carbinerrifle_1.getOrCreateTag();
        	tag.putInt("AmmoCount", initItems.CARBINE_RIFLE.get().getGun().getGeneral().getMaxAmmo());
    		tag.putInt("HandguardVariant", 2);
    		tag.putInt("BaseVariant", 1);
    	}
    	items.add(carbinerrifle_2);
    	
    	
    	// Precision Battle Rifle, Variant 1
    	ItemStack precisionbr_1 = new ItemStack(initItems.PRECISION_BATTLE_RIFLE.get());
    	{
    		CompoundTag tag = precisionbr_1.getOrCreateTag();
        	tag.putInt("AmmoCount", initItems.PRECISION_BATTLE_RIFLE.get().getGun().getGeneral().getMaxAmmo());
    		tag.putInt("BaseVariant", 1);
    	}
    	items.add(precisionbr_1);
    	// Automatic Sniper Rifle, Variant 2
    	ItemStack precisionbr_2 = new ItemStack(initItems.PRECISION_BATTLE_RIFLE.get());
    	{
    		CompoundTag tag = precisionbr_2.getOrCreateTag();
        	tag.putInt("AmmoCount", initItems.PRECISION_BATTLE_RIFLE.get().getGun().getGeneral().getMaxAmmo());
    		tag.putInt("BaseVariant", 1);
    		tag.putInt("HandguardVariant", 1);
    	}
    	items.add(precisionbr_2);
    }
}