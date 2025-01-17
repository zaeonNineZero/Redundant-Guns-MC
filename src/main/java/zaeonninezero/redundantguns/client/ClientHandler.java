package zaeonninezero.redundantguns.client;

import com.mrcrayfish.guns.client.render.gun.ModelOverrides;
import com.mrcrayfish.guns.client.render.gun.model.SimpleModel;
import zaeonninezero.redundantguns.client.render.gun.model.*;
import zaeonninezero.redundantguns.RedundantGuns;
import zaeonninezero.redundantguns.init.initItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RedundantGuns.MOD_ID, value = Dist.CLIENT)
public class ClientHandler
{
    public static void setup()
    {
        registerModelOverrides();
    }
	
	private static void registerModelOverrides()
    {
        ModelOverrides.register(initItems.COMBAT_PISTOL.get(), new CombatPistolModel());
        ModelOverrides.register(initItems.SIDEARM_PISTOL.get(), new SidearmPistolModel());
        ModelOverrides.register(initItems.CARBINE_RIFLE.get(), new CarbineRifleModel());
        ModelOverrides.register(initItems.RANGER_ASSAULT_RIFLE.get(), new RangerAssaultRifleModel());
        ModelOverrides.register(initItems.COMBAT_ASSAULT_RIFLE.get(), new CombatAssaultRifleModel());
        ModelOverrides.register(initItems.TACTICAL_INFANTRY_RIFLE.get(), new TacticalInfantryRifleModel());
        ModelOverrides.register(initItems.TACTICAL_SNIPER_RIFLE.get(), new TacticalSniperRifleModel());
        ModelOverrides.register(initItems.VINTAGE_BOLT_RIFLE.get(), new VintageBoltRifleModel());
    }
}