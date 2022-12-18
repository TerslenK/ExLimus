package io.github.terslenk.exlimus.utils.config;

import io.github.terslenk.exlimus.ExLimus;
import io.github.terslenk.exlimus.utils.config.AddonConfig;

public class ToolsConfig extends AddonConfig {

    public static final String PATH = "resources/tools/items.yml";
    public static final boolean REPLACE = false;
    public static final boolean UPDATE = true;

    public ToolsConfig(ExLimus plugin) {
        super(plugin, PATH, REPLACE, UPDATE);
    }
}