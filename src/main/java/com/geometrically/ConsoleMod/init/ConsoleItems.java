package com.geometrically.ConsoleMod.init;

import com.geometrically.ConsoleMod.ConsoleCore;
import com.geometrically.ConsoleMod.item.Controller;
import com.geometrically.ConsoleMod.item.tierController;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ConsoleItems {
    public static Item Controller;
    public static Item xController;
    public static Item CamoController;
    public static Item BlueController;
    public static Item RedController;
    public static Item xCamoController;
    public static Item xBlueController;
    public static Item xRedController;
    public static Item xGreenController;
    public static Item GreenController;
    public static ToolMaterial gamingToolMaterial = EnumHelper.addToolMaterial("gamingTM", 4, 2000, 10.0F, 4.0F, 20);

    public ConsoleItems() {
    }

    public static void init() {
        Controller = (new Controller(gamingToolMaterial)).setUnlocalizedName("Controller").setTextureName("tf:Controller").setCreativeTab(ConsoleCore.tabConsole);
        CamoController = (new Controller(gamingToolMaterial)).setUnlocalizedName("CamoController").setTextureName("tf:CamoController").setCreativeTab(ConsoleCore.tabConsole);
        BlueController = (new Controller(gamingToolMaterial)).setUnlocalizedName("BlueController").setTextureName("tf:BlueController").setCreativeTab(ConsoleCore.tabConsole);
        RedController = (new Controller(gamingToolMaterial)).setUnlocalizedName("RedController").setTextureName("tf:RedController").setCreativeTab(ConsoleCore.tabConsole);
        GreenController = (new Controller(gamingToolMaterial)).setUnlocalizedName("GreenController").setTextureName("tf:GreenController").setCreativeTab(ConsoleCore.tabConsole);
        xController = (new tierController(gamingToolMaterial)).setUnlocalizedName("xController").setTextureName("tf:xController").setCreativeTab(ConsoleCore.tabConsole);
        xCamoController = (new tierController(gamingToolMaterial)).setUnlocalizedName("xCamoController").setTextureName("tf:xCamoController").setCreativeTab(ConsoleCore.tabConsole);
        xBlueController = (new tierController(gamingToolMaterial)).setUnlocalizedName("xBlueController").setTextureName("tf:xBlueController").setCreativeTab(ConsoleCore.tabConsole);
        xRedController = (new tierController(gamingToolMaterial)).setUnlocalizedName("xRedController").setTextureName("tf:xRedController").setCreativeTab(ConsoleCore.tabConsole);
        xGreenController = (new tierController(gamingToolMaterial)).setUnlocalizedName("xGreenController").setTextureName("tf:xGreenController").setCreativeTab(ConsoleCore.tabConsole);
    }

    public static void registerItems() {
        GameRegistry.registerItem(Controller, Controller.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(CamoController, CamoController.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(BlueController, BlueController.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(RedController, RedController.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(GreenController, GreenController.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(xController, xController.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(xCamoController, xCamoController.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(xBlueController, xBlueController.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(xRedController, xRedController.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(xGreenController, xGreenController.getUnlocalizedName().substring(5));
    }
}