package com.geometrically.ConsoleMod.init;

import com.geometrically.ConsoleMod.ConsoleCore;
import com.geometrically.ConsoleMod.block.PS3;
import com.geometrically.ConsoleMod.block.SiliconOre;
import com.geometrically.ConsoleMod.block.TV;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ConsoleBlocks {
    public static Block PS3;
    public static Block TV;
    public static Block SiliconOre;

    public ConsoleBlocks() {
    }

    public static void init() {
        PS3 = (new PS3(Material.rock)).setBlockName("PS3");
        TV = (new TV(Material.rock)).setBlockName("TV");
        SiliconOre = (new SiliconOre(Material.rock)).setBlockName("SiliconOre").setBlockTextureName("tf:SiliconOre").setCreativeTab(ConsoleCore.tabConsole);
    }

    public static void register() {
        GameRegistry.registerBlock(PS3, "PS3");
        GameRegistry.registerBlock(TV, "TV");
        GameRegistry.registerBlock(SiliconOre, "SiliconOre");
    }
}
