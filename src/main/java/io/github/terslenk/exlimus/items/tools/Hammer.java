package io.github.terslenk.exlimus.items.tools;

import io.github.terslenk.exlimus.utils.EXItems;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ToolUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.concurrent.ThreadLocalRandom;

public class Hammer extends SimpleSlimefunItem<ToolUseHandler> {
    private final int NUGGET_CHANCE;
    private final int MULTIPLIER;

    public Hammer(ItemGroup group, SlimefunItemStack stack, RecipeType recipeType, ItemStack[] recipe, int multiplier, int chance) {
        super(group, stack, recipeType, recipe);

        MULTIPLIER = multiplier;
        NUGGET_CHANCE = chance;
    }

    @Nonnull
    @Override
    public ToolUseHandler getItemHandler() {
        return (e, tool, fortune, drops) -> {
            if (Slimefun.getPermissionsService().hasPermission(e.getPlayer(), Hammer.this)) {

                Block block = e.getBlock();
                ItemStack customdrops = customDrops(block);

                block.getLocation().getWorld().dropItemNaturally(block.getLocation(), customdrops);
                e.setDropItems(false);
            }
        };
    }

    public ItemStack customDrops(Block block) {
        Material type = block.getType();

        switch (type) {
            case STONE, COBBLESTONE, DIORITE, ANDESITE, GRANITE, DEEPSLATE, COBBLED_DEEPSLATE -> {
                return new ItemStack(Material.GRAVEL);
            }
            case GRAVEL -> {
                if (ThreadLocalRandom.current().nextInt(100) < NUGGET_CHANCE) {
                    return new ItemStack(Material.IRON_NUGGET, 3 * MULTIPLIER);
                } else {
                    return new ItemStack(Material.SAND);
                }
            }
            case SAND -> {
                return EXItems.DUST;
            }
            case IRON_ORE, DEEPSLATE_IRON_ORE -> {
                return new CustomItemStack(SlimefunItems.IRON_DUST, MULTIPLIER);
            }
            case GOLD_ORE, DEEPSLATE_GOLD_ORE -> {
                return new CustomItemStack(SlimefunItems.GOLD_DUST, MULTIPLIER);
            }
            case COPPER_ORE, DEEPSLATE_COPPER_ORE -> {
                return new CustomItemStack(SlimefunItems.COPPER_DUST, MULTIPLIER);
            }
        }
        return null;
    }
}
