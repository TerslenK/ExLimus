package io.github.terslenk.exlimus.utils;

import io.github.terslenk.exlimus.ExLimus;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public class MCRecipes {
    private static final Plugin plugin = ExLimus.getPlugin(ExLimus.class);

    public static void setup(ExLimus el) {
        ShapedRecipe enchantedworkbench = new ShapedRecipe(new NamespacedKey(plugin,"enchanted_workbench"),EXItems.ENCHANTED_WORKBENCH.clone());

        enchantedworkbench.shape(" X ","XOX"," X ");
        enchantedworkbench.setIngredient('X', Material.OAK_LOG);
        enchantedworkbench.setIngredient('O', Material.CRAFTING_TABLE);

        el.getServer().addRecipe(enchantedworkbench);
    }
}
