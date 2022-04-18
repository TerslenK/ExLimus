package io.github.terslenk.exlimus.items.tools;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ToolUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

import static io.github.terslenk.exlimus.utils.Items.DUST;

public class StoneHammer extends SimpleSlimefunItem<ToolUseHandler> {
    public StoneHammer(ItemGroup group, SlimefunItemStack stack, RecipeType recipeType, ItemStack[] recipe) {
        super(group, stack, recipeType, recipe);
    }

    @Nonnull
    @Override
    public ToolUseHandler getItemHandler() {
        return (e, tool, fortune, drops) -> {
            if (Slimefun.getPermissionsService().hasPermission(e.getPlayer(), StoneHammer.this)) {

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
            case STONE: case COBBLESTONE: case DIORITE: case ANDESITE: case GRANITE: case DEEPSLATE: case COBBLED_DEEPSLATE:{
                return new ItemStack(Material.GRAVEL);
            }
            case GRAVEL: {
                return new ItemStack(Material.SAND);
            }
            case SAND: {
                return DUST;
            }

            case IRON_ORE: case DEEPSLATE_IRON_ORE: {
                return SlimefunItems.IRON_DUST;
            }
            case GOLD_ORE: case DEEPSLATE_GOLD_ORE: {
                return SlimefunItems.GOLD_DUST;
            }
            case COPPER_ORE: case DEEPSLATE_COPPER_ORE: {
                return SlimefunItems.COPPER_DUST;
            }
        }

        return null;
    }
}
