package io.github.terslenk.exlimus.utils;

import io.github.mooy1.infinitylib.groups.MultiGroup;
import io.github.mooy1.infinitylib.groups.SubGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;

@UtilityClass
public class Categories {
    public static final ItemGroup EL_TOOLS = new SubGroup(
            "el_tools",
            new CustomItemStack(Material.DIAMOND_PICKAXE,
                    "&9Tools")
    );

    public static final ItemGroup EL_MISC = new SubGroup(
            "el_misc",
            new CustomItemStack(SlimefunItems.TIN_CAN,
                    "&aMiscellaneous")
    );

    public static final ItemGroup EL_VANILLA = new SubGroup(
            "el_vanilla",
            new CustomItemStack(Material.GRASS_BLOCK,
                    "&fVanilla Items"));

    public static final ItemGroup EL_MAIN = new MultiGroup(
            "el_main",
            new CustomItemStack(Material.BARREL,
                    "&6Ex Limus"),
            EL_TOOLS,EL_MISC,EL_VANILLA
    );
}
