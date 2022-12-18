package io.github.terslenk.exlimus.utils.config;

import io.github.terslenk.exlimus.ExLimus;

import java.io.File;

public class FileBuilder {
    protected File file;
    private boolean REPLACE;

    private final ExLimus plugin;

    public FileBuilder(ExLimus plugin, String path, boolean REPLACE) {
        this.plugin = plugin;
        this.REPLACE = REPLACE;

        createFile(path);
    }

    public void createFile(String path) {
        file = new File(plugin.getDataFolder(), path); // look for a file with the given path

        // if the file doesn't exist in the plugins folder
        if (!file.exists()) {
            // create a new yaml file
            file.getParentFile().mkdirs();
            // save the yaml file to the plugin resources
            plugin.saveResource(path, REPLACE);
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
