package io.github.terslenk.exlimus.utils;

import io.github.terslenk.exlimus.ExLimus;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;



@UtilityClass
public class RecipeTypes {
    public static final RecipeType HAMMER_BREAK = new RecipeType(new NamespacedKey(ExLimus.getAddon(), "hammer_break"), new CustomItemStack(Material.DIAMOND_PICKAXE,"&6Digging with Stone Hammer","","&7Item can be gathered via breaking specific block"));
    public static final RecipeType KAMA_BREAK = new RecipeType(new NamespacedKey(ExLimus.getAddon(), "kama_break"),new CustomItemStack(Material.WOODEN_HOE,"&6Harvesting with Wooden Kama","","&7Item can be harvested via breaking specific block"));
}
