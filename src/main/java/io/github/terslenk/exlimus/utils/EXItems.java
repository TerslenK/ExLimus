package io.github.terslenk.exlimus.utils;

import io.github.terslenk.exlimus.ExLimus;
import io.github.terslenk.exlimus.items.tools.Hammer;
import io.github.terslenk.exlimus.items.tools.Kama;
import io.github.terslenk.exlimus.items.tools.Workbench;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EXItems {
    public static final SlimefunItemStack WOODEN_KAMA = new SlimefunItemStack(
            "EL_WOODEN_KAMA",
            Material.WOODEN_HOE,
            "&fWooden Kama",
            "",
            "&7A Tool that can be used for harvesting leaves"
    );
    public static final SlimefunItemStack STONE_KAMA = new SlimefunItemStack(
            "EL_STONE_KAMA",
            Material.STONE_HOE,
            "&fStone Kama",
            "",
            "&7A Tool that can be used for harvesting leaves"
    );
    public static final SlimefunItemStack IRON_KAMA = new SlimefunItemStack(
            "EL_IRON_KAMA",
            Material.IRON_HOE,
            "&fIron Kama",
            "",
            "&7A Tool that can be used for harvesting leaves"
    );
    public static final SlimefunItemStack STONE_HAMMER = new SlimefunItemStack(
            "EL_STONE_HAMMER",
            Material.STONE_PICKAXE,
            "&fStone Hammer",
            "",
            "&7Chunky stone pickaxe that can be used for crushing"
    );
    public static final SlimefunItemStack IRON_HAMMER = new SlimefunItemStack(
            "EL_REINFORCED_HAMMER",
            Material.IRON_PICKAXE,
            "&fIron Hammer",
            "",
            "&7Iron version of Stone Hammer"
    );

    static {
        ItemMeta wkamaMeta = WOODEN_KAMA.getItemMeta();
        wkamaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        WOODEN_KAMA.setItemMeta(wkamaMeta);
        WOODEN_KAMA.addEnchantment(Enchantment.SILK_TOUCH, 1);

        ItemMeta skamaMeta = STONE_KAMA.getItemMeta();
        skamaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        STONE_KAMA.setItemMeta(skamaMeta);
        STONE_KAMA.addEnchantment(Enchantment.SILK_TOUCH, 1);

        ItemMeta ikamaMeta = IRON_KAMA.getItemMeta();
        ikamaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        IRON_KAMA.setItemMeta(ikamaMeta);
        IRON_KAMA.addEnchantment(Enchantment.SILK_TOUCH, 1);

        ItemMeta stoneHammerMeta = STONE_HAMMER.getItemMeta();
        stoneHammerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        STONE_HAMMER.setItemMeta(stoneHammerMeta);
        STONE_HAMMER.addEnchantment(Enchantment.DURABILITY, 1);

        ItemMeta reinforcedHammerMeta = IRON_HAMMER.getItemMeta();
        reinforcedHammerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        IRON_HAMMER.setItemMeta(reinforcedHammerMeta);
        IRON_HAMMER.addEnchantment(Enchantment.DURABILITY, 2);
    }

    //MISC
    public static final SlimefunItemStack DUST = new SlimefunItemStack(
            "EL_DUST",
            Material.CLAY,
            "&fDust",
            "",
            "&7Crushed version of sand",
            "&7Can be used for sifting"
    );
    public static final SlimefunItemStack WORM = new SlimefunItemStack(
            "EL_WORM",
            Material.STRING,
            "&fWorm",
            "",
            "&7A Creature that lives on leaves"
    );
    public static final SlimefunItemStack COOKED_WORM = new SlimefunItemStack(
            "EL_COOKED_WORM",
            Material.STRING,
            "&fCooked Worm",
            "",
            "&7Edible version of worm.",
            "&7Yummy I guess?"
    );
    public static final SlimefunItemStack COOKED_APPLE = new SlimefunItemStack(
            "EL_COOKED_APPLE",
            Material.APPLE,
            "&fCooked Apple",
            "",
            "&7Burned version of apple",
            "&7Somehow better than normal one?"
    );
    //MACHINES
    public static final SlimefunItemStack ENCHANTED_WORKBENCH = new SlimefunItemStack(
            "EL_ENCHANTED_WORKBENCH",
            Material.CRAFTING_TABLE,
            "&fEnchanted Workbench"
    );
    public static void setup(ExLimus el){
        new Hammer(EXCategory.EL_TOOLS, STONE_HAMMER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                null,null,null,
                null,null,null,
                null,null,null
        },1,15).register(el);
        new Hammer(EXCategory.EL_TOOLS, IRON_HAMMER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                null,null,null,
                null,null,null,
                null,null,null
        },2,20).register(el);

        new Kama(EXCategory.EL_TOOLS, WOODEN_KAMA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                null,null,null,
                null,null,null,
                null,null,null
        },15).register(el);
        new Kama(EXCategory.EL_TOOLS, STONE_KAMA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                null,null,null,
                null,null,null,
                null,null,null
        },15).register(el);
        new Kama(EXCategory.EL_TOOLS, IRON_KAMA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                null,null,null,
                null,null,null,
                null,null,null
        },15).register(el);

        new Workbench(EXCategory.EL_MACHINES, ENCHANTED_WORKBENCH, EXRecipeTypes.GRINDER,new ItemStack[]{
                null,null,null,
                null,null,null,
                null,null,null
        }).register(el);
    }
}
