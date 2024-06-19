package zaeonninezero.redundantguns.init;

import com.mrcrayfish.guns.GunMod;
import com.mrcrayfish.guns.item.GunItem;
import zaeonninezero.redundantguns.RedundantGuns;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class initItems {
	/*
     * Create a Deferred Register to register the items to our mod.
     * This is called in the main mod file, where we will add it to the event bus.
     */
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RedundantGuns.MOD_ID);

    /*
     * Register a new instance of GunItem into the Deferred Register above.
     * We can just create a new instance of the Gun Item as the API allows us to edit the properties in the JSON data file.
     * In that JSON we can add and remove fields to suit our needs, take a look at the existing guns if you would like to see them
     *      https://github.com/MrCrayfish/MrCrayfishGunMod/tree/1.16.X/src/main/resources/data/cgm/guns
     * I would say, if you wanted to add something to this then make sure you know what you're doing :P
     */
	 
	//Guns
    public static final RegistryObject<GunItem> COMBAT_PISTOL = ITEMS.register("combat_pistol", () -> new GunItem(new Item.Properties().stacksTo(1).tab(RedundantGuns.GROUP)));
    public static final RegistryObject<GunItem> CARBINE_RIFLE = ITEMS.register("carbine_rifle", () -> new GunItem(new Item.Properties().stacksTo(1).tab(RedundantGuns.GROUP)));
	public static final RegistryObject<GunItem> TACTICAL_INFANTRY_RIFLE = ITEMS.register("tactical_infantry_rifle", () -> new GunItem(new Item.Properties().stacksTo(1).tab(RedundantGuns.GROUP)));
	public static final RegistryObject<GunItem> VINTAGE_BOLT_RIFLE = ITEMS.register("vintage_bolt_rifle", () -> new GunItem(new Item.Properties().stacksTo(1).tab(RedundantGuns.GROUP)));
	public static final RegistryObject<GunItem> TACTICAL_SNIPER_RIFLE = ITEMS.register("tactical_sniper_rifle", () -> new GunItem(new Item.Properties().stacksTo(1).tab(RedundantGuns.GROUP)));
}