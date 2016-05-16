package com.geometrically.ConsoleMod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTelevision extends ModelBase {
    ModelRenderer BottomTV;
    ModelRenderer HolderPart;
    ModelRenderer Shape1;

    public ModelTelevision() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.BottomTV = new ModelRenderer(this, 0, 7);
        this.BottomTV.addBox(0.0F, 0.0F, 0.0F, 8, 1, 6);
        this.BottomTV.setRotationPoint(-4.0F, 23.0F, -3.0F);
        this.BottomTV.setTextureSize(64, 32);
        this.BottomTV.mirror = true;
        this.setRotation(this.BottomTV, 0.0F, 0.0F, 0.0F);
        this.HolderPart = new ModelRenderer(this, 32, 0);
        this.HolderPart.addBox(0.0F, 0.0F, 0.0F, 6, 5, 2);
        this.HolderPart.setRotationPoint(-3.0F, 19.0F, -1.0F);
        this.HolderPart.setTextureSize(64, 32);
        this.HolderPart.mirror = true;
        this.setRotation(this.HolderPart, 0.2974289F, 0.0F, 0.0F);
        this.Shape1 = new ModelRenderer(this, 0, 18);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 16, 8, 1);
        this.Shape1.setRotationPoint(-8.0F, 12.0F, -1.0F);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.BottomTV.render(f5);
        this.HolderPart.render(f5);
        this.Shape1.render(f5);
    }

    public void renderModel(float f) {
        this.BottomTV.render(f);
        this.HolderPart.render(f);
        this.Shape1.render(f);
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
