package io.github.terslenk.exlimus.utils;

import io.github.terslenk.exlimus.ExLimus;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.VanillaItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MCItems {
    public static void setup(ExLimus el) {
        new VanillaItem(EXCategory.EL_VANILLA, new ItemStack(Material.CLAY), "CLAY", RecipeType.FOOD_COMPOSTER, new ItemStack[]{
                null, null, null,
                null, EXItems.DUST, null,
                null, null, null
        }).register(el);

        new VanillaItem(EXCategory.EL_VANILLA, new ItemStack(Material.SAND), "SAND", EXRecipeTypes.HAMMER_BREAK, new ItemStack[]{
                null, null, null,
                null, new ItemStack(Material.GRAVEL), null,
                null, null, null
        }).register(el);

        new VanillaItem(EXCategory.EL_VANILLA, new ItemStack(Material.GRAVEL), "GRAVEL", EXRecipeTypes.HAMMER_BREAK, new ItemStack[]{
                null, null, null,
                null, new CustomItemStack(new ItemStack(Material.STONE), "&7Every Stone Variant"), null,
                null, null, null
        }).register(el);

        new VanillaItem(EXCategory.EL_VANILLA, new ItemStack(Material.STRING), "STRING", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                null, null, null,
                null, EXItems.WORM, null,
                null, null, null
        }).register(el);
    }
}