package com.geometrically.ConsoleMod.item;

import com.geometrically.ConsoleMod.entity.tierEntityCT;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class tierController extends ItemSpade {
    public tierController(ToolMaterial material) {
        super(material);
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        player.swingItem();
        world.playSoundAtEntity(player, "tf:emp_sound", 0.5F, 1.0F);
        if(!world.isRemote) {
            world.spawnEntityInWorld(new tierEntityCT(world, player));
        }

        return itemStack;
    }
}
