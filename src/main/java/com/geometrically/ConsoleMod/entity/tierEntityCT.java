package com.geometrically.ConsoleMod.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class tierEntityCT extends EntityThrowable {
    public static final float explosionPower = 1.25F;
    public static final int empRadius = 4;

    public tierEntityCT(World world) {
        super(world);
    }

    public tierEntityCT(World world, EntityLivingBase entity) {
        super(world, entity);
    }

    private void explode() {
        int bx = (int)this.posX;
        int by = (int)this.posY;
        int bz = (int)this.posZ;
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2.0F, true);

        for(int x = bx - 4; x <= 4; ++x) {
            for(int y = by - 4; y <= by + 4; ++y) {
                for(int z = bz - 4; z <= bz + 4; ++z) {
                    Block block = this.worldObj.getBlock(x, y, z);
                    if(block == Blocks.redstone_wire || block instanceof BlockRedstoneDiode) {
                        block.dropBlockAsItem(this.worldObj, x, y, z, this.worldObj.getBlockMetadata(x, y, z), 0);
                        this.worldObj.setBlockToAir(x, y, z);
                    }

                    if(block == Blocks.redstone_block) {
                        this.worldObj.setBlock(x, y, z, Blocks.stone);
                    }
                }
            }
        }

        this.setDead();
    }

    public void onUpdate() {
        super.onUpdate();
        if(this.ticksExisted > 20) {
            this.explode();
        }

        for(int i = 0; i < 10; ++i) {
            double x = (double)(this.rand.nextInt(10) - 5) / 8.0D;
            double y = (double)(this.rand.nextInt(10) - 5) / 8.0D;
            double z = (double)(this.rand.nextInt(10) - 5) / 8.0D;
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY, this.posZ, x, y, z);
        }

    }

    protected float getGravityVelocity() {
        return 0.005F;
    }

    public void onImpact(MovingObjectPosition movingObjectPosition) {
        this.explode();
    }
}
