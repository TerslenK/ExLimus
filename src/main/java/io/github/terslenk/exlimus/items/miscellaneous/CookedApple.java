package io.github.terslenk.exlimus.items.miscellaneous;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemConsumptionHandler;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import static io.github.terslenk.exlimus.utils.Items.COOKED_APPLE;

public class CookedApple extends SlimefunItem {
    public CookedApple(ItemGroup group) {
        super(group, COOKED_APPLE, RecipeType.SMELTERY, new ItemStack[]{
                new ItemStack(Material.APPLE), null, null,
                null, null, null,
                null, null, null
        });
    }

    @Override
    public void preRegister() {
        ItemConsumptionHandler itemConsumptionHandler = this::onConsume;
        addItemHandler(itemConsumptionHandler);
    }

    private void onConsume(PlayerItemConsumeEvent e, Player p, ItemStack item) {
        int foodLevel = p.getFoodLevel();
        float saturationLevel = p.getSaturation();

        p.setFoodLevel(foodLevel + 15);
        p.setSaturation(saturationLevel + 10);
        p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT,1,1);
    }
}

