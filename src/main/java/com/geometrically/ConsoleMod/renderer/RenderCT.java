package com.geometrically.ConsoleMod.renderer;

import org.lwjgl.opengl.GL11;

import com.geometrically.ConsoleMod.model.ModelCT;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCT extends Render {
    private static final ResourceLocation texture = new ResourceLocation("tf", "textures/entity/emp.png");
    private ModelBase model = new ModelCT();

    public RenderCT() {
    }

    public ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }

    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTick) {
        GL11.glPushMatrix();
        this.bindTexture(texture);
        GL11.glTranslated(x, y - 1.25D, z);
        this.model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }
}
