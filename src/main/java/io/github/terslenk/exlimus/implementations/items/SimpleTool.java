package io.github.terslenk.exlimus.implementations.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ToolUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class SimpleTool extends SimpleSlimefunItem<ToolUseHandler> {
    @ParametersAreNonnullByDefault
    public SimpleTool(ItemGroup group, SlimefunItemStack stack, RecipeType recipeType, ItemStack[] recipe) {
        super(group, stack, recipeType, recipe);
    }

    @Nonnull
    public ToolUseHandler getItemHandler() {
        return (e, tool, fortune, drops) -> {

        };
    }
}
