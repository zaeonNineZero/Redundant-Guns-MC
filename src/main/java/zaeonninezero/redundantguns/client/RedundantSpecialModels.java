package zaeonninezero.redundantguns.client;

import zaeonninezero.redundantguns.RedundantGuns;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// Copy of SpecialModels to handle all model parts that are used together with existing NZGE model parts.

@Mod.EventBusSubscriber(modid = RedundantGuns.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public enum RedundantSpecialModels
{
    TACTICAL_INFANTRY_RIFLE_BASE("tactical_infantry_rifle_base"),
	
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