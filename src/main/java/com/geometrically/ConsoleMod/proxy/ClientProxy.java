package com.geometrically.ConsoleMod.proxy;

import com.geometrically.ConsoleMod.init.ConsoleBlocks;
import com.geometrically.ConsoleMod.renderer.ItemRenderPS3;
import com.geometrically.ConsoleMod.renderer.ItemRenderTV;
import com.geometrically.ConsoleMod.renderer.RenderPS3;
import com.geometrically.ConsoleMod.renderer.RenderTV;
import com.geometrically.ConsoleMod.tileentity.TileEntityPS3;
import com.geometrically.ConsoleMod.tileentity.TileEntityTV;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    public ClientProxy() {
    }

    public void registerRenderThings() {
        RenderPS3 renderps3 = new RenderPS3();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPS3.class, renderps3);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ConsoleBlocks.PS3), new ItemRenderPS3(renderps3, new TileEntityPS3()));
        RenderTV rendertv = new RenderTV();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTV.class, rendertv);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ConsoleBlocks.TV), new ItemRenderTV(rendertv, new TileEntityTV()));
    }

    public void registerTileEntitySpecialRenderer() {
    }
}
