package com.geometrically.ConsoleMod.gui;

import com.geometrically.ConsoleMod.container.ContainerGeneric;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{
	public static final int GAMESETUP = 9;
	public static final int GAMEINSERT = 10;
	public static final int guiIDGameList = 11;
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);

		switch(ID)
		{
			case GAMESETUP:
				return new ContainerGeneric(player.inventory, tile_entity);
			case GAMEINSERT:
				return new ContainerGeneric(player.inventory, tile_entity);
			case guiIDGameList:
				return new ContainerGeneric(player.inventory, tile_entity);
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		
		switch(ID){
		case GAMESETUP:
			return new GuiSetGameCode(player.inventory, tile_entity, world.getBlock(x, y, z));
		case GAMEINSERT:
			return new GuiCheckGameCode(player.inventory, tile_entity, world.getBlock(x, y, z));
		case guiIDGameList:
			return new GuiGameList(player.inventory, tile_entity, world.getBlock(x, y, z));
		default:
			return null;
		}
	
	}

}
