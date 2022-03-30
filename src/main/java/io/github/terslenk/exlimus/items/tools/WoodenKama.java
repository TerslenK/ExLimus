package io.github.terslenk.exlimus.items.tools;

import io.github.terslenk.exlimus.ExLimus;
import io.github.terslenk.exlimus.utils.Items;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ToolUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.ThreadLocalRandom;

import static io.github.terslenk.exlimus.utils.Items.WOODEN_KAMA;

public class WoodenKama extends SimpleSlimefunItem<ToolUseHandler> {
    private static final int WORM_CHANCE = ExLimus.getAddon().getConfig().getInt("options.worm-chance");

    @ParametersAreNonnullByDefault
    public WoodenKama(ItemGroup itemGroup) {
        super(itemGroup, WOODEN_KAMA, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                new ItemStack(Material.OAK_SLAB), new ItemStack(Material.STICK), null,
                null, new ItemStack(Material.STICK), null,
                null, new ItemStack(Material.STICK), null
        });
    }

    @Nonnull
    public ToolUseHandler getItemHandler() {
        return (e, tool, fortune, drops) -> {

            if (Tag.LEAVES.isTagged(e.getBlock().getType()) && ThreadLocalRandom.current().nextInt(100) < WORM_CHANCE) {
                SlimefunItemStack worm = Items.WORM;
                drops.add(worm);
            }
        };
    }
}