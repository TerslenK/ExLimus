package io.github.terslenk.exlimus;


import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.terslenk.exlimus.utils.Setup;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bstats.bukkit.Metrics;


public final class ExLimus extends AbstractAddon implements SlimefunAddon {
    private static ExLimus addon;

    public ExLimus() {
        super("TerslenK","ExLimus","master","options.auto-update");
    }
    @Override
    public void enable() {
        addon = this;

        getLogger().info(">--------------------- Ex Limus ---------------------<");
        getLogger().info(" Version: " + getPluginVersion());
        getLogger().info(">-------------------- Information -------------------<");
        getLogger().info(" An Addon Created by TerslenK");
        getLogger().info(" With the help of lucasGithuber"); //credits ¯\_(ツ)_/¯
        getLogger().info(">-------------- Issue Information Link --------------<");
        getLogger().info(">-----------------Report issues here-----------------<");
        getLogger().info(" " + getBugTrackerLink());
        getLogger().info(">----------------------------------------------------<");

        Setup.setup(this);
        new Metrics(this, 14604);
    }

    @Override
    public void disable() {
        // Set instance to null
        addon = null;
    }

    public static ExLimus getAddon() {
        return addon;
    }
    public String getBugTrackerLink(){
        return "https://github.com/TerslenK/ExLimus/issues";
    }
}
