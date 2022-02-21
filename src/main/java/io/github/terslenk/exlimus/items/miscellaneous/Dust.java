package io.github.terslenk.exlimus.items.miscellaneous;

import io.github.terslenk.exlimus.utils.RecipeTypes;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static io.github.terslenk.exlimus.utils.Items.DUST;


public class Dust extends SlimefunItem{
    public Dust(ItemGroup group) {
        super(group, DUST, RecipeTypes.HAMMER_BREAK, new ItemStack[]{
                null, null, null,
                null,new ItemStack(Material.SAND),null,
                null,null,null
        });
    }

    @Override
    public void preRegister() {
        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        event.cancel();
    }
}
