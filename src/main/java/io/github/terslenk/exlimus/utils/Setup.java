package io.github.terslenk.exlimus.utils;

import io.github.terslenk.exlimus.ExLimus;
import io.github.terslenk.exlimus.items.miscellaneous.CookedApple;
import io.github.terslenk.exlimus.items.miscellaneous.CookedWorm;
import io.github.terslenk.exlimus.items.miscellaneous.Dust;
import io.github.terslenk.exlimus.items.miscellaneous.Worm;
import io.github.terslenk.exlimus.items.tools.ReinforcedHammer;
import io.github.terslenk.exlimus.items.tools.WoodenKama;
import io.github.terslenk.exlimus.items.tools.StoneHammer;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.VanillaItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;


public class Setup {
    public static void SlimefunItems(ExLimus here) {
        Categories.EL_MAIN.register(here);
        //TOOLS
        new WoodenKama(Categories.EL_TOOLS).register(here);
        new StoneHammer(Categories.EL_TOOLS).register(here);
        new ReinforcedHammer(Categories.EL_TOOLS).register(here);
        //MISC
        new Dust(Categories.EL_MISC).register(here);
        new Worm(Categories.EL_MISC).register(here);
        new CookedWorm(Categories.EL_MISC).register(here);
        new CookedApple(Categories.EL_MISC).register(here);
        //MACHINES
    }

    public static void VanillaItems(ExLimus here) {
        new VanillaItem(Categories.EL_VANILLA, new ItemStack(Material.CLAY),"CLAY", RecipeType.FOOD_COMPOSTER, new ItemStack[]{
                null,null,null,
                null,Items.DUST,null,
                null,null,null
        }).register(here);

        new VanillaItem(Categories.EL_VANILLA, new ItemStack(Material.SAND),"SAND", RecipeTypes.HAMMER_BREAK, new ItemStack[]{
                null,null,null,
                null,new ItemStack(Material.GRAVEL),null,
                null,null,null
        }).register(here);

        new VanillaItem(Categories.EL_VANILLA, new ItemStack(Material.GRAVEL),"GRAVEL", RecipeTypes.HAMMER_BREAK, new ItemStack[]{
                null,null,null,
                null,new CustomItemStack(new ItemStack(Material.STONE),"&7Every Stone Variant"),null,
                null,null,null
        }).register(here);

        new VanillaItem(Categories.EL_VANILLA, new ItemStack(Material.STRING),"STRING", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                Items.WORM,null,null,
                null,null,null,
                null,null,null
        }).register(here);
    }
}
