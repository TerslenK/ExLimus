package io.github.terslenk.exlimus;


import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.terslenk.exlimus.utils.EXItems;
import io.github.terslenk.exlimus.utils.EXCategory;
import io.github.terslenk.exlimus.utils.MCItems;
import io.github.terslenk.exlimus.utils.MCRecipes;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import net.md_5.bungee.api.ChatColor;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;


public final class ExLimus extends AbstractAddon implements SlimefunAddon {
    private static ExLimus addon;

    public ExLimus() {
        super("TerslenK","ExLimus","master","options.auto-update");
    }
    @Override
    public void enable() {
        addon = this;
        CommandSender sender = Bukkit.getConsoleSender();

        sender.sendMessage("");
        sender.sendMessage(ChatColor.GOLD + ">--------------------- Ex Limus ---------------------<");
        sender.sendMessage(ChatColor.GREEN + " Version: " + ChatColor.BOLD + ChatColor.GRAY + getPluginVersion());
        sender.sendMessage(ChatColor.GOLD + ">-------------------- Information -------------------<");
        sender.sendMessage(ChatColor.WHITE + " An Addon Created by TerslenK");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.WHITE + " Special Thanks to lucasGithuber");
        sender.sendMessage(ChatColor.GOLD + ">-------------- Issue Information Link --------------<");
        sender.sendMessage(ChatColor.RED + " " + getBugTrackerLink());
        sender.sendMessage(ChatColor.GOLD + ">----------------------------------------------------<");
        sender.sendMessage("");

        new Metrics(this, 14604);

        MCRecipes.setup(this);
        EXItems.setup(this);
        EXCategory.setup(this);
        MCItems.setup(this);
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
