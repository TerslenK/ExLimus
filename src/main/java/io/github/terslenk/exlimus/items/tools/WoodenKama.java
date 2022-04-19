package io.github.terslenk.exlimus.items.tools;

import io.github.terslenk.exlimus.ExLimus;
import io.github.terslenk.exlimus.utils.Items;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ToolUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.ThreadLocalRandom;

public class WoodenKama extends SimpleSlimefunItem<ToolUseHandler> {
    private static final int WORM_CHANCE = ExLimus.config().getInt("kama.worm-chance");

    @ParametersAreNonnullByDefault
    public WoodenKama(ItemGroup group, SlimefunItemStack stack, RecipeType recipeType, ItemStack[] recipe) {
        super(group, stack, recipeType, recipe);
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