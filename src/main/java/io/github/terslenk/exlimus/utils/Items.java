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
    public static final SlimefunItemStack WOODEN_KAMA = new SlimefunItemStack("WOODEN_KAMA",Material.WOODEN_HOE,"&8Item: &fWooden Kama");
    public static final SlimefunItemStack STONE_HAMMER = new SlimefunItemStack("STONE_HAMMER",Material.STONE_PICKAXE,"&8Item: &fStone Hammer");
    static {
        ItemMeta kamameta =WOODEN_KAMA.getItemMeta();
        kamameta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        WOODEN_KAMA.setItemMeta(kamameta);
        WOODEN_KAMA.addEnchantment(Enchantment.SILK_TOUCH,1);

        ItemMeta hammermeta =STONE_HAMMER.getItemMeta();
        hammermeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        STONE_HAMMER.setItemMeta(hammermeta);
        STONE_HAMMER.addEnchantment(Enchantment.SILK_TOUCH,1);
    }
    public static final SlimefunItemStack DUST = new SlimefunItemStack("DUST",Material.CLAY,"&8Item: &fDust");
    public static final SlimefunItemStack WORM = new SlimefunItemStack("WORM",Material.STRING,"&8Item: &fWorm");

}