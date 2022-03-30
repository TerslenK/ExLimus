package io.github.terslenk.exlimus.items.miscellaneous;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


import static io.github.terslenk.exlimus.utils.Items.COOKED_WORM;
import static io.github.terslenk.exlimus.utils.Items.WORM;

public class CookedWorm extends SlimefunItem implements NotPlaceable {
    public CookedWorm(ItemGroup group) {
        super(group, COOKED_WORM, RecipeType.SMELTERY, new ItemStack[]{
                WORM, null, null,
                null,null,null,
                null,null,null
        });
    }

    @Override
    public void preRegister() {
        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        ItemStack playerMainhand = event.getPlayer().getInventory().getItemInMainHand();
        int foodLevel = event.getPlayer().getFoodLevel();
        Player player = event.getPlayer();

        if (foodLevel < 20) {
            playerMainhand.setAmount(playerMainhand.getAmount() - 1);

            player.setFoodLevel(foodLevel + 2);
            player.setSaturation(player.getSaturation() + 4);
            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EAT,1,1);
        }
        event.cancel();
    }
}
