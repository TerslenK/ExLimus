package io.github.terslenk.exlimus.utils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;



@UtilityClass
public final class Items {
    //TOOLS
    public static final SlimefunItemStack WOODEN_KAMA = new SlimefunItemStack("WOODEN_KAMA", Material.WOODEN_HOE, "&fWooden Kama","","&7A Tool that can be used for harvesting leaves");
    public static final SlimefunItemStack STONE_HAMMER = new SlimefunItemStack("STONE_HAMMER", Material.STONE_PICKAXE, "&fStone Hammer","","&7Chunky stone pickaxe that can be used for crushing");
    public static final SlimefunItemStack REINFORCED_HAMMER = new SlimefunItemStack("REINFORCED_HAMMER", Material.IRON_PICKAXE, "&fReinforced Hammer","","&7Reinforced verison of Stone Hammer");

    static {
        ItemMeta kamameta = WOODEN_KAMA.getItemMeta();
        kamameta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        WOODEN_KAMA.setItemMeta(kamameta);
        WOODEN_KAMA.addEnchantment(Enchantment.SILK_TOUCH, 1);

        ItemMeta hammer1meta = STONE_HAMMER.getItemMeta();
        hammer1meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        STONE_HAMMER.setItemMeta(hammer1meta);
        STONE_HAMMER.addEnchantment(Enchantment.DURABILITY, 1);

        ItemMeta hammer2meta = REINFORCED_HAMMER.getItemMeta();
        hammer2meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        REINFORCED_HAMMER.setItemMeta(hammer2meta);
        REINFORCED_HAMMER.addEnchantment(Enchantment.DURABILITY, 2);
    }

    //MISC
    public static final SlimefunItemStack DUST = new SlimefunItemStack("DUST", Material.CLAY, "&fDust", "","&7Crushed version of sand","&7Can be used for sifting");
    public static final SlimefunItemStack WORM = new SlimefunItemStack("WORM", Material.STRING, "&fWorm", "","&7A Creature that lives on leaves");
    public static final SlimefunItemStack COOKED_WORM = new SlimefunItemStack("COOKED_WORM", Material.STRING, "&fCooked Worm", "","&7Edible version of worm.","&7Yummy I guess?");
    public static final SlimefunItemStack COOKED_APPLE = new SlimefunItemStack("COOKED_APPLE",Material.APPLE,"&fCooked Apple","","&7Burned version of apple","&7Somehow better than normal one?");
    //MACHINES
}