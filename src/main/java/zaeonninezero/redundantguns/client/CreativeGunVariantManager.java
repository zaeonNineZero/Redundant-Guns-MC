package zaeonninezero.redundantguns.client;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import zaeonninezero.redundantguns.init.initItems;

public class CreativeGunVariantManager
{
	public static void addItemVariants(NonNullList<ItemStack> items)
    {
        // Combat Pistol, Variant 1
    	ItemStack combatpistol_1 = new ItemStack(initItems.COMBAT_PISTOL.get());
    	{
    		CompoundTag tag = combatpistol_1.getOrCreateTag();
        	tag.putInt("AmmoCount", initItems.COMBAT_PISTOL.get().getGun().getGeneral().getMaxAmmo());
    		tag.putInt("BaseVariant", 1);
    		tag.putInt("HammerVariant", 1);
    	}
    	items.add(combatpistol_1);
    	
    	
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
    		CompoundTag tag = carbinerrifle_2.getOrCreateTag();
        	tag.putInt("AmmoCount", initItems.CARBINE_RIFLE.get().getGun().getGeneral().getMaxAmmo());
    		tag.putInt("HandguardVariant", 2);
    		tag.putInt("BaseVariant", 1);
    	}
    	items.add(carbinerrifle_2);
    	

        // Tactical Carbine, Variant 1
    	ItemStack tacticalcarbine_1 = new ItemStack(initItems.TACTICAL_CARBINE.get());
    	{
    		CompoundTag tag = tacticalcarbine_1.getOrCreateTag();
        	tag.putInt("AmmoCount", initItems.TACTICAL_CARBINE.get().getGun().getGeneral().getMaxAmmo());
    		tag.putInt("HandguardVariant", 1);
    	}
    	items.add(tacticalcarbine_1);
        // Tactical Carbine, Variant 2
    	ItemStack tacticalcarbine_2 = new ItemStack(initItems.TACTICAL_CARBINE.get());
    	{
    		CompoundTag tag = tacticalcarbine_2.getOrCreateTag();
        	tag.putInt("AmmoCount", initItems.TACTICAL_CARBINE.get().getGun().getGeneral().getMaxAmmo());
    		tag.putInt("BaseVariant", 1);
    	}
    	items.add(tacticalcarbine_2);
        // Tactical Carbine, Variant 3
    	ItemStack tacticalcarbine_3 = new ItemStack(initItems.TACTICAL_CARBINE.get());
    	{
    		CompoundTag tag = tacticalcarbine_3.getOrCreateTag();
        	tag.putInt("AmmoCount", initItems.TACTICAL_CARBINE.get().getGun().getGeneral().getMaxAmmo());
    		tag.putInt("HandguardVariant", 2);
    		tag.putInt("SightVariant", 1);
    	}
    	items.add(tacticalcarbine_3);
    	
    	
        // Combat Assault Rifle, Variant 1
    	ItemStack combatrifle_1 = new ItemStack(initItems.COMBAT_ASSAULT_RIFLE.get());
    	{
    		CompoundTag tag = combatrifle_1.getOrCreateTag();
        	tag.putInt("AmmoCount", initItems.COMBAT_ASSAULT_RIFLE.get().getGun().getGeneral().getMaxAmmo());
    		tag.putInt("SightVariant", 1);
    	}
    	items.add(combatrifle_1);
    	
    	
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
    	
    	
    	// Mare's Leg Rifle, Variant 1
    	ItemStack maresleg_1 = new ItemStack(initItems.MARES_LEG_RIFLE.get());
    	{
    		CompoundTag tag = maresleg_1.getOrCreateTag();
        	tag.putInt("AmmoCount", initItems.MARES_LEG_RIFLE.get().getGun().getGeneral().getMaxAmmo());
    		tag.putInt("BaseVariant", 1);
    	}
    	items.add(maresleg_1);
    }
}