package com.geometrically.ConsoleMod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPS3 extends ModelBase {
    ModelRenderer PS3Base;
    ModelRenderer PS3CDDISK;
    ModelRenderer PS3BODY;

    public ModelPS3() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.PS3Base = new ModelRenderer(this, 0, 0);
        this.PS3Base.addBox(0.0F, 0.0F, 0.0F, 16, 1, 9);
        this.PS3Base.setRotationPoint(-7.0F, 23.0F, -4.0F);
        this.PS3Base.setTextureSize(64, 64);
        this.PS3Base.mirror = true;
        this.setRotation(this.PS3Base, 0.0F, 0.0F, 0.0F);
        this.PS3CDDISK = new ModelRenderer(this, 0, 23);
        this.PS3CDDISK.addBox(0.0F, 0.0F, 0.0F, 5, 1, 8);
        this.PS3CDDISK.setRotationPoint(-7.0F, 22.0F, -4.0F);
        this.PS3CDDISK.setTextureSize(64, 64);
        this.PS3CDDISK.mirror = true;
        this.setRotation(this.PS3CDDISK, 0.0F, 0.0F, 0.0F);
        this.PS3BODY = new ModelRenderer(this, 0, 11);
        this.PS3BODY.addBox(0.0F, 0.0F, 0.0F, 11, 1, 9);
        this.PS3BODY.setRotationPoint(-2.0F, 22.0F, -4.0F);
        this.PS3BODY.setTextureSize(64, 64);
        this.PS3BODY.mirror = true;
        this.setRotation(this.PS3BODY, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.PS3Base.render(f5);
        this.PS3CDDISK.render(f5);
        this.PS3BODY.render(f5);
    }

    public void renderModel(float f) {
        this.PS3Base.render(f);
        this.PS3CDDISK.render(f);
        this.PS3BODY.render(f);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
