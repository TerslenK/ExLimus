package io.github.terslenk.exlimus.utils.config;

import io.github.terslenk.exlimus.ExLimus;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class AddonConfig extends FileBuilder {

    private static Collection<AddonConfig> configList = new ArrayList<>();
    private boolean renamed;

    private final String path;
    private final ExLimus plugin;
    private final boolean renameOldVersions;
    private FileConfiguration config;

    public AddonConfig(ExLimus plugin, String path, boolean replace, boolean renameOldVersions) {
        super(plugin, path, replace);
        this.plugin = plugin;
        this.path = path;
        this.renameOldVersions = renameOldVersions;
        createConfig();

        configList.add(this);
    }

    public void createConfig() {
        config = new YamlConfiguration(); // create a temporary empty config

        // catch and print any exceptions while loading config
        try {
            // load the file into the config
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            // print any exceptions that are thrown
            e.printStackTrace();
        }

        if (renameOldVersions && !renamed) {
            renameOldConfig();
        }
    }

    private void renameOldConfig() {
        String currentVersion = "";
        String latestVersion = plugin.getDescription().getVersion();
        renamed = true;

        if (config.contains("ConfigId")) {
            currentVersion = config.getString("ConfigId");
        }

        if (currentVersion.compareTo(latestVersion) < 0) {
            int num = 0;

            String newPath = path.replace(".yml", "_Old_Version_" + num + ".yml");

            while(new File(plugin.getDataFolder(), newPath).exists()) {
                num++;
                newPath = newPath.replace("_Old_Version_" + (num - 1), "_Old_Version_" + num);
            }

            file.renameTo(new File(plugin.getDataFolder(), newPath));

            createFile(path);
            createConfig();
        }

    }

    /**
     * Gets the config
     * @return The config
     */
    public FileConfiguration getConfig() {
        return config;
    }

    /**
     * Assigns the current config to a new one
     * @param config The new config which the current config should be set to
     */
    public void setConfig(FileConfiguration config) {
        this.config = config;
    }

    /**
     * Reloads the config to use the most recent values
     */
    public void reloadConfig() {
        setConfig(YamlConfiguration.loadConfiguration(file));
    }

    public static Collection<AddonConfig> getConfigList() {
        return configList;
    }
}
