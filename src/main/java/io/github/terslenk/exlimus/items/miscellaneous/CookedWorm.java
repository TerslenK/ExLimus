package io.github.terslenk.exlimus.items.miscellaneous;

import io.github.terslenk.exlimus.ExLimus;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CookedWorm extends SlimefunItem implements NotPlaceable {
    public CookedWorm(ItemGroup group, SlimefunItemStack stack, RecipeType recipeType, ItemStack[] recipe) {
        super(group, stack, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        ItemUseHandler itemUseHandler = this::onItemRightClick;
        addItemHandler(itemUseHandler);
    }

    private void onItemRightClick(PlayerRightClickEvent event) {
        ItemStack playerMainHand = event.getPlayer().getInventory().getItemInMainHand();
        int foodLevel = event.getPlayer().getFoodLevel();
        Player player = event.getPlayer();

        if (foodLevel < 20) {
            playerMainHand.setAmount(playerMainHand.getAmount() - 1);

            player.setFoodLevel(foodLevel + ExLimus.config().getInt("cooked-worm.food-restoration"));
            player.setSaturation(player.getSaturation() + ExLimus.config().getInt("cooked-worm.saturation"));
            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EAT,1,1);
        }
        event.cancel();
    }
}
