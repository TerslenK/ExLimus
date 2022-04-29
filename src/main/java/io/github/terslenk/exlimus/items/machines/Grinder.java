package io.github.terslenk.exlimus.items.machines;

import io.github.terslenk.exlimus.utils.Items;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;


public class Grinder extends AContainer implements RecipeDisplayItem {

    public Grinder(ItemGroup c, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {

        super(c, item, recipeType, recipe);

    }

    public void registerDefaultRecipes() {
        registerRecipe(4,
                new ItemStack[]{
                Items.COMPRESSED_COBBLE
                },
                new ItemStack[]{
                        Items.COMPRESSED_GRAVEL
                }
        );
    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> displayRecipes = new ArrayList<>(recipes.size() * 8);

        for (MachineRecipe recipe : recipes) {
            displayRecipes.add(recipe.getInput()[0]);

            for (ItemStack output : recipe.getOutput()) {
                displayRecipes.add(output);
                displayRecipes.add(new ItemStack(Material.AIR));
            }

            displayRecipes.add(new ItemStack(Material.AIR));
        }

        return displayRecipes;
    }
    @Override
    public ItemStack getProgressBar() {
        //change this for the material and name you want to progress bar
        return new CustomItemStack(Material.SCAFFOLDING, "Grinding");
    }
    @Nonnull
    @Override
    public String getMachineIdentifier() {
        return "EL_GRINDER";
    }
    @Override
    public String getInventoryTitle() {
        return "&aGrinder";
    }
    @Override
    public int getCapacity() {
        return 256;
    }

    @Override
    public int getEnergyConsumption() {
        return 128;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

}