package com.geometrically.ConsoleMod.renderer;

import org.lwjgl.opengl.GL11;

import com.geometrically.ConsoleMod.model.ModelPS3;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderPS3 extends TileEntitySpecialRenderer {
    private static final ResourceLocation texture = new ResourceLocation("tf:textures/model/PS3.png");
    private ModelPS3 model = new ModelPS3();

    public RenderPS3() {
    }

    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
        int i;
        if(tileentity.getWorldObj() == null) {
            i = 0;
        } else {
            Block j = tileentity.getBlockType();
            i = tileentity.getBlockMetadata();
            if(j != null && i == 0) {
                i = tileentity.getBlockMetadata();
            }
        }

        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        short j1 = 0;
        if(i == 3) {
            j1 = 270;
        }

        if(i == 2) {
            j1 = 180;
        }

        if(i == 1) {
            j1 = 90;
        }

        if(i == 0) {
            j1 = 360;
        }

        GL11.glRotatef((float)j1, 0.0F, 1.0F, 0.0F);
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
