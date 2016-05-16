package com.geometrically.ConsoleMod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeHandler {
    public RecipeHandler() {
    }

    public static void init() {
        addCraftingRecipes();
    }

    private static void addCraftingRecipes() {
    	//Temporary Recipes,will change
        GameRegistry.addShapedRecipe(new ItemStack(ConsoleItems.Controller), new Object[]{"III", "III", "I I", Character.valueOf('I'), Items.iron_ingot});
        GameRegistry.addShapedRecipe(new ItemStack(ConsoleBlocks.PS3), new Object[]{"III", "III", "III", Character.valueOf('I'), Items.iron_ingot});
    }
}

