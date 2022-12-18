package io.github.terslenk.exlimus.utils.config;

import io.github.terslenk.exlimus.ExLimus;

public class RecipesConfig extends AddonConfig {

    public static final String PATH = "resources/recipes.yml";
    public static final boolean REPLACE = false;
    public static final boolean UPDATE = true;

    public RecipesConfig(ExLimus plugin) {
        super(plugin, PATH, REPLACE, UPDATE);
    }
}
