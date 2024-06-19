package zaeonninezero.redundantguns.init;

import zaeonninezero.redundantguns.RedundantGuns;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class initSounds {
	/*
     * This creates a Deferred Register where all of the sounds will be registered
     * This is called and added to the event bus in the main mod file.
     */
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RedundantGuns.MOD_ID);

	public static final RegistryObject<SoundEvent> ITEM_COMBAT_PISTOL_FIRE = register("item.combat_pistol.fire");
	public static final RegistryObject<SoundEvent> ITEM_COMBAT_PISTOL_ENCHANTED_FIRE = register("item.combat_pistol.enchanted_fire");
	public static final RegistryObject<SoundEvent> ITEM_COMBAT_PISTOL_SILENCED_FIRE = register("item.combat_pistol.silenced_fire");

	public static final RegistryObject<SoundEvent> ITEM_CARBINE_RIFLE_FIRE = register("item.carbine_rifle.fire");
	public static final RegistryObject<SoundEvent> ITEM_CARBINE_RIFLE_ENCHANTED_FIRE = register("item.carbine_rifle.enchanted_fire");
	public static final RegistryObject<SoundEvent> ITEM_CARBINE_RIFLE_SILENCED_FIRE = register("item.carbine_rifle.silenced_fire");

	public static final RegistryObject<SoundEvent> ITEM_VINTAGE_BOLT_RIFLE_FIRE = register("item.vintage_bolt_rifle.fire");
	public static final RegistryObject<SoundEvent> ITEM_VINTAGE_BOLT_RIFLE_ENCHANTED_FIRE = register("item.vintage_bolt_rifle.enchanted_fire");
	public static final RegistryObject<SoundEvent> ITEM_VINTAGE_BOLT_RIFLE_SILENCED_FIRE = register("item.vintage_bolt_rifle.silenced_fire");
	
	//Method to help us register sounds
	private static RegistryObject<SoundEvent> register(String key) {
		return SOUNDS.register(key, () -> new SoundEvent(new ResourceLocation(RedundantGuns.MOD_ID, key)));
	}
}