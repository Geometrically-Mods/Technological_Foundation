package com.geometrically.ConsoleMod.tileentity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTV extends TileEntity {
    private ItemStack field_145858_a;
    private static final String __OBFID = "CL_00000261";

    public TileEntityTV() {
    }

    public void readFromNBT(NBTTagCompound p_145839_1_) {
        super.readFromNBT(p_145839_1_);
        if(p_145839_1_.hasKey("RecordItem", 10)) {
            this.func_145857_a(ItemStack.loadItemStackFromNBT(p_145839_1_.getCompoundTag("RecordItem")));
        } else if(p_145839_1_.getInteger("Record") > 0) {
            this.func_145857_a(new ItemStack(Item.getItemById(p_145839_1_.getInteger("Record")), 1, 0));
        }

    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if(this.func_145856_a() != null) {
            nbt.setTag("RecordItem", this.func_145856_a().writeToNBT(new NBTTagCompound()));
            nbt.setInteger("Record", Item.getIdFromItem(this.func_145856_a().getItem()));
        }

    }

    public ItemStack func_145856_a() {
        return this.field_145858_a;
    }

    public void func_145857_a(ItemStack p_145857_1_) {
        this.field_145858_a = p_145857_1_;
        this.markDirty();
    }
}