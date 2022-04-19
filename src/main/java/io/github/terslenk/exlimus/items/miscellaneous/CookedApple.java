package io.github.terslenk.exlimus.items.miscellaneous;

import io.github.terslenk.exlimus.ExLimus;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemConsumptionHandler;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class CookedApple extends SlimefunItem {
    public CookedApple(ItemGroup group, SlimefunItemStack stack, RecipeType recipeType, ItemStack[] recipe) {
        super(group, stack, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        ItemConsumptionHandler itemConsumptionHandler = this::onConsume;
        addItemHandler(itemConsumptionHandler);
    }

    private void onConsume(PlayerItemConsumeEvent e, Player p, ItemStack item) {
        int foodLevel = p.getFoodLevel();
        float saturationLevel = p.getSaturation();

        p.setFoodLevel(foodLevel + ExLimus.config().getInt("cooked-apple.food-restoration"));
        p.setSaturation(saturationLevel + ExLimus.config().getInt("cooked-apple.saturation"));
        p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT,1,1);
    }
}

