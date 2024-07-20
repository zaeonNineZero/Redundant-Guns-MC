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
	COMBAT_PISTOL_BASE("combat_pistol_base"),
    COMBAT_PISTOL_SLIDE("combat_pistol_slide"),
    COMBAT_PISTOL_RAILMOUNT("combat_pistol_railmount"),
    
	CARBINE_RIFLE_BASE("carbine_rifle_base"),
	CARBINE_RIFLE_BASE_1("carbine_rifle_base_1"),
	CARBINE_RIFLE_HANDGUARD_0("carbine_rifle_handguard_0"),
	CARBINE_RIFLE_HANDGUARD_1("carbine_rifle_handguard_1"),
    CARBINE_RIFLE_REARSIGHT("carbine_rifle_rearsight"),
    CARBINE_RIFLE_CARRYHANDLE("carbine_rifle_carryhandle"),
    CARBINE_RIFLE_CARRYHANDLE_1("carbine_rifle_carryhandle_1"),
    CARBINE_RIFLE_MAGAZINE("carbine_rifle_magazine"),
	
	TACTICAL_INFANTRY_RIFLE_BASE("tactical_infantry_rifle_base"),
	
    VINTAGE_BOLT_RIFLE_BASE("vintage_bolt_rifle_base"),
	
    TACTICAL_SNIPER_RIFLE_BASE("tactical_sniper_rifle_base");

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