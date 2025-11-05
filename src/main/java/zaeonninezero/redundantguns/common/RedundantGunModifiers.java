package zaeonninezero.redundantguns.common;

import com.mrcrayfish.guns.interfaces.IGunModifier;
import net.minecraft.util.Mth;

/**
 * Author: MrCrayfish
 */
public class RedundantGunModifiers
{

    public static final IGunModifier LIGHT_MUZZLE_BRAKE_EFFECT = new IGunModifier()
    {
    	@Override
        public float recoilModifier()
        {
            return 0.94F;
        }

        @Override
        public float kickModifier()
        {
            return 0.94F;
        }

        @Override
        public double modifyMuzzleFlashScale(double scale)
        {
            return 1.10F;
        }
    };
	public static final IGunModifier SPECIALIZED_CARBINE_STOCK = new IGunModifier()
    {
        @Override
        public float recoilModifier()
        {
            return 0.35F;
        }

        @Override
        public float kickModifier()
        {
            return 0.4F;
        }

        @Override
        public float modifyProjectileSpread(float spread)
        {
            return spread * 0.45F;
        }

        @Override
        public double modifyAimDownSightSpeed(double speed)
        {
            return speed * 0.85F;
        }
    };
}