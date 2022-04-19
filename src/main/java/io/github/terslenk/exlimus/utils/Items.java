package io.github.terslenk.exlimus.utils;

import io.github.terslenk.exlimus.ExLimus;
import io.github.terslenk.exlimus.items.miscellaneous.CookedApple;
import io.github.terslenk.exlimus.items.miscellaneous.CookedWorm;
import io.github.terslenk.exlimus.items.tools.ReinforcedHammer;
import io.github.terslenk.exlimus.items.tools.StoneHammer;
import io.github.terslenk.exlimus.items.tools.WoodenKama;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



@UtilityClass
public final class Items {
    //TOOLS
    public static final SlimefunItemStack WOODEN_KAMA = new SlimefunItemStack(
            "WOODEN_KAMA",
            Material.WOODEN_HOE,
            "&fWooden Kama",
            "",
            "&7A Tool that can be used for harvesting leaves"
    );
    public static final SlimefunItemStack STONE_HAMMER = new SlimefunItemStack(
            "STONE_HAMMER",
            Material.STONE_PICKAXE,
            "&fStone Hammer",
            "",
            "&7Chunky stone pickaxe that can be used for crushing"
    );
    public static final SlimefunItemStack REINFORCED_HAMMER = new SlimefunItemStack(
            "REINFORCED_HAMMER",
            Material.IRON_PICKAXE,
            "&fReinforced Hammer",
            "",
            "&7Reinforced verison of Stone Hammer"
    );

    static {
        ItemMeta kamaMeta = WOODEN_KAMA.getItemMeta();
        kamaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        WOODEN_KAMA.setItemMeta(kamaMeta);
        WOODEN_KAMA.addEnchantment(Enchantment.SILK_TOUCH, 1);

        ItemMeta stoneHammerMeta = STONE_HAMMER.getItemMeta();
        stoneHammerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        STONE_HAMMER.setItemMeta(stoneHammerMeta);
        STONE_HAMMER.addEnchantment(Enchantment.DURABILITY, 1);

        ItemMeta reinforcedHammerMeta = REINFORCED_HAMMER.getItemMeta();
        reinforcedHammerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        REINFORCED_HAMMER.setItemMeta(reinforcedHammerMeta);
        REINFORCED_HAMMER.addEnchantment(Enchantment.DURABILITY, 2);
    }

    //MISC
    public static final SlimefunItemStack DUST = new SlimefunItemStack(
            "DUST",
            Material.CLAY,
            "&fDust",
            "",
            "&7Crushed version of sand",
            "&7Can be used for sifting"
    );
    public static final SlimefunItemStack WORM = new SlimefunItemStack(
            "WORM",
            Material.STRING,
            "&fWorm",
            "",
            "&7A Creature that lives on leaves"
    );
    public static final SlimefunItemStack COOKED_WORM = new SlimefunItemStack(
            "COOKED_WORM",
            Material.STRING,
            "&fCooked Worm",
            "",
            "&7Edible version of worm.",
            "&7Yummy I guess?"
    );
    public static final SlimefunItemStack COOKED_APPLE = new SlimefunItemStack(
            "COOKED_APPLE",
            Material.APPLE,
            "&fCooked Apple",
            "",
            "&7Burned version of apple",
            "&7Somehow better than normal one?"
    );
    //MACHINES

    public static void setup(ExLimus el){
        //TOOLS
        new StoneHammer(Categories.EL_TOOLS, STONE_HAMMER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE),
                null, new ItemStack(Material.STICK), new ItemStack(Material.STONE),
                new ItemStack(Material.STICK), null, new ItemStack(Material.STONE)}).register(el);

        new ReinforcedHammer(Categories.EL_TOOLS, REINFORCED_HAMMER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE),
                null, new ItemStack(Material.STICK), new ItemStack(Material.STONE),
                new ItemStack(Material.STICK), null, new ItemStack(Material.STONE)}).register(el);

        new WoodenKama(Categories.EL_TOOLS, WOODEN_KAMA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                new ItemStack(Material.OAK_SLAB), new ItemStack(Material.STICK), null,
                null, new ItemStack(Material.STICK), null,
                null, new ItemStack(Material.STICK), null
        }).register(el);

        //MISC

        new CookedApple(Categories.EL_MISC, COOKED_APPLE, RecipeType.SMELTERY, new ItemStack[]{
                new ItemStack(Material.APPLE), null, null,
                null, null, null,
                null, null, null
        }).register(el);

        new CookedWorm(Categories.EL_MISC, COOKED_WORM, RecipeType.SMELTERY, new ItemStack[]{
                WORM, null, null,
                null,null,null,
                null,null,null
        }).register(el);

        new UnplaceableBlock(Categories.EL_MISC, WORM, RecipeTypes.KAMA_BREAK, new ItemStack[]{
                null, null, null,
                null,new CustomItemStack(Material.OAK_LEAVES,"&fEvery Leaf Variant"),null,
                null,null,null
        }).register(el);

        new UnplaceableBlock(Categories.EL_MISC, DUST, RecipeTypes.HAMMER_BREAK, new ItemStack[]{
                null, null, null,
                null,new ItemStack(Material.SAND),null,
                null,null,null
        }).register(el);

    }
}