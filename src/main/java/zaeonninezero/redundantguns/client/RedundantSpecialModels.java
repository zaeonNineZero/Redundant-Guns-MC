package zaeonninezero.redundantguns.client;

import zaeonninezero.redundantguns.RedundantGuns;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// Renamed from just SpecialModels to allow usage with existing NZGE model parts.

@Mod.EventBusSubscriber(modid = RedundantGuns.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public enum RedundantSpecialModels
{
	COMBAT_PISTOL_BASE("gun/combat_pistol/combat_pistol_base"),
    COMBAT_PISTOL_SLIDE("gun/combat_pistol/combat_pistol_slide"),
    COMBAT_PISTOL_RAILMOUNT("gun/combat_pistol/combat_pistol_railmount"),
    COMBAT_PISTOL_MAGAZINE("gun/combat_pistol/combat_pistol_magazine"),
    COMBAT_PISTOL_EXTENDED_MAG("gun/combat_pistol/combat_pistol_extended_mag"),
    
	SIDEARM_PISTOL_BASE("gun/sidearm_pistol/sidearm_pistol_base"),
	SIDEARM_PISTOL_SLIDE("gun/sidearm_pistol/sidearm_pistol_slide"),
	SIDEARM_PISTOL_RAILMOUNT("gun/sidearm_pistol/sidearm_pistol_railmount"),
    SIDEARM_PISTOL_MAGAZINE("gun/sidearm_pistol/sidearm_pistol_magazine"),
    SIDEARM_PISTOL_EXTENDED_MAG("gun/sidearm_pistol/sidearm_pistol_extended_mag"),
    
	CARBINE_RIFLE_BASE("gun/carbine_rifle/carbine_rifle_base"),
	CARBINE_RIFLE_BASE_1("gun/carbine_rifle/carbine_rifle_base_1"),
	CARBINE_RIFLE_HANDGUARD_0("gun/carbine_rifle/carbine_rifle_handguard_0"),
	CARBINE_RIFLE_HANDGUARD_1("gun/carbine_rifle/carbine_rifle_handguard_1"),
	CARBINE_RIFLE_HANDGUARD_COVERS("gun/carbine_rifle/carbine_rifle_handguard_covers"),
    CARBINE_RIFLE_REARSIGHT("gun/carbine_rifle/carbine_rifle_rearsight"),
    CARBINE_RIFLE_REARSIGHT_FOLDED("gun/carbine_rifle/carbine_rifle_rearsight_folded"),
    CARBINE_RIFLE_REARSIGHT_A2("gun/carbine_rifle/carbine_rifle_rearsight_a2"),
    CARBINE_RIFLE_REARSIGHT_3("gun/carbine_rifle/carbine_rifle_rearsight_3"),
    CARBINE_RIFLE_CARRYHANDLE("gun/carbine_rifle/carbine_rifle_carryhandle"),
    CARBINE_RIFLE_CARRYHANDLE_1("gun/carbine_rifle/carbine_rifle_carryhandle_1"),
    CARBINE_RIFLE_MAGAZINE("gun/carbine_rifle/carbine_rifle_magazine"),
    CARBINE_RIFLE_LIGHT_MAG("gun/carbine_rifle/carbine_rifle_light_mag"),
    CARBINE_RIFLE_EXTENDED_MAG("gun/carbine_rifle/carbine_rifle_extended_mag"),
    CARBINE_RIFLE_PMAG("gun/carbine_rifle/carbine_rifle_pmag"),
    CARBINE_RIFLE_LIGHT_PMAG("gun/carbine_rifle/carbine_rifle_light_pmag"),
    
	TACTICAL_CARBINE_BASE("gun/tactical_carbine/tactical_carbine_base"),
	TACTICAL_CARBINE_BASE_1("gun/tactical_carbine/tactical_carbine_base_1"),
	TACTICAL_CARBINE_HANDGUARD_0("gun/tactical_carbine/tactical_carbine_handguard_0"),
	TACTICAL_CARBINE_HANDGUARD_1("gun/tactical_carbine/tactical_carbine_handguard_1"),
	TACTICAL_CARBINE_HANDGUARD_2("gun/tactical_carbine/tactical_carbine_handguard_2"),
	TACTICAL_CARBINE_SIGHTS("gun/tactical_carbine/tactical_carbine_sights"),
	TACTICAL_CARBINE_SIGHTS_FOLDED("gun/tactical_carbine/tactical_carbine_sights_folded"),
	TACTICAL_CARBINE_SIGHTS_1("gun/tactical_carbine/tactical_carbine_sights_1"),

    RANGER_AR_BASE("gun/ranger_assault_rifle/ranger_ar_base"),
    RANGER_AR_BASE_1("gun/ranger_assault_rifle/ranger_ar_base_1"),
    RANGER_AR_MAGAZINE("gun/ranger_assault_rifle/ranger_ar_magazine"),
    RANGER_AR_LIGHT_MAG("gun/ranger_assault_rifle/ranger_ar_light_mag"),
    RANGER_AR_EXTENDED_MAG("gun/ranger_assault_rifle/ranger_ar_extended_mag"),

    COMBAT_ASSAULT_RIFLE_BASE("gun/combat_assault_rifle/combat_assault_rifle_base"),
    COMBAT_ASSAULT_RIFLE_SIGHTS("gun/combat_assault_rifle/combat_assault_rifle_sights"),
    COMBAT_ASSAULT_RIFLE_SIGHTS_1("gun/combat_assault_rifle/combat_assault_rifle_sights_1"),
    COMBAT_ASSAULT_RIFLE_SIGHTS_FOLDED("gun/combat_assault_rifle/combat_assault_rifle_sights_folded"),
    COMBAT_ASSAULT_RIFLE_SIGHTS_1_FOLDED("gun/combat_assault_rifle/combat_assault_rifle_sights_1_folded"),
    COMBAT_ASSAULT_RIFLE_MAGAZINE("gun/combat_assault_rifle/combat_assault_rifle_magazine"),
    COMBAT_ASSAULT_RIFLE_LIGHT_MAG("gun/combat_assault_rifle/combat_assault_rifle_light_mag"),
    COMBAT_ASSAULT_RIFLE_EXTENDED_MAG("gun/combat_assault_rifle/combat_assault_rifle_extended_mag"),
	
    PRECISION_BATTLE_RIFLE_BASE("gun/precision_battle_rifle/precision_battle_rifle_base"),
    PRECISION_BATTLE_RIFLE_BASE_1("gun/precision_battle_rifle/precision_battle_rifle_base_1"),
    PRECISION_BATTLE_RIFLE_HANDGUARD("gun/precision_battle_rifle/precision_battle_rifle_handguard"),
    PRECISION_BATTLE_RIFLE_HANDGUARD_1("gun/precision_battle_rifle/precision_battle_rifle_handguard_1"),
    PRECISION_BATTLE_RIFLE_TOP_RAIL("gun/precision_battle_rifle/precision_battle_rifle_top_rail"),
    PRECISION_BATTLE_RIFLE_BOTTOM_RAIL("gun/precision_battle_rifle/precision_battle_rifle_bottom_rail"),
    PRECISION_BATTLE_RIFLE_EXTENDED_MAG("gun/precision_battle_rifle/precision_battle_rifle_extended_mag"),
    PRECISION_BATTLE_RIFLE_BOLT_FOLDED("gun/precision_battle_rifle/precision_battle_rifle_bolt_folded"),
	
	MARES_LEG_RIFLE_BASE("gun/mares_leg_rifle/mares_leg_rifle_base"),
	MARES_LEG_RIFLE_BASE_1("gun/mares_leg_rifle/mares_leg_rifle_base_1"),
	
	TACTICAL_INFANTRY_RIFLE_BASE("gun/tactical_infantry_rifle/tactical_infantry_rifle_base"),

    COMBAT_MARKSMAN_RIFLE_BASE("gun/combat_marksman_rifle/combat_marksman_rifle_base"),
	
    VINTAGE_BOLT_RIFLE_BASE("gun/vintage_bolt_rifle/vintage_bolt_rifle_base"),
    VINTAGE_BOLT_RIFLE_CLIP("gun/vintage_bolt_rifle/vintage_bolt_rifle_clip"),
	
    TACTICAL_SNIPER_RIFLE_BASE("gun/tactical_sniper_rifle/tactical_sniper_rifle_base"),
    TACTICAL_SNIPER_RIFLE_SIGHTS("gun/tactical_sniper_rifle/tactical_sniper_rifle_sights");

    /**
     * The location of an item model in the [MOD_ID]/models/special/[NAME] folder
     */
    private final ResourceLocation modelLocation;

    /**
     * Cached model
     */
    private BakedModel cachedModel;

    /**
     * Sets the model's location
     *
     * @param modelName name of the model file
     */
    RedundantSpecialModels(String modelName)
    {
        this.modelLocation = new ResourceLocation(RedundantGuns.MOD_ID, "special/" + modelName);
    }

    /**
     * Gets the model
     *
     * @return isolated model
     */
    public BakedModel getModel()
    {
        if(this.cachedModel == null)
        {
            this.cachedModel = Minecraft.getInstance().getModelManager().getModel(this.modelLocation);
        }
        return this.cachedModel;
    }

    /**
     * Registers the special models into the Forge Model Bakery. This is only called once on the
     * load of the game.
     */
    @SubscribeEvent
    public static void registerAdditional(ModelEvent.RegisterAdditional event)
    {
        for(RedundantSpecialModels model : values())
        {
            event.register(model.modelLocation);
        }
    }

    /**
     * Clears the cached BakedModel since it's been rebuilt. This is needed since the models may
     * have changed when a resource pack was applied, or if resources are reloaded.
     */
    @SubscribeEvent
    public static void onBake(ModelEvent.BakingCompleted event)
    {
        for(RedundantSpecialModels model : values())
        {
            model.cachedModel = null;
        }
    }
}