package io.github.terslenk.exlimus;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.terslenk.exlimus.utils.Setup;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;

public class ExLimus extends AbstractAddon implements SlimefunAddon {
    private static ExLimus addon;

    public ExLimus() {
        super("TerslenK","ExLimus","master","options.auto-update");
    }

    @Override
    public void enable() {
        addon = this;

        getLogger().info("---------------------- Ex Limus ----------------------");
        getLogger().info("Version: v" + getPluginVersion());
        getLogger().info("--------------------- Information --------------------");
        getLogger().info("An Addon Created  by TerslenK");
        getLogger().info("--------------- Issue Information Link ---------------");
        getLogger().info(getBugTrackerURL());
        getLogger().info("------------------------------------------------------");

        Setup.slimefunitems(this);
        Setup.vanillaitems(this);
    }

    @Override
    public void disable() {
        addon = null;
    }

    public static ExLimus getAddon() {
        return addon;
    }
}
