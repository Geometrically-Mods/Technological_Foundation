package com.geometrically.ConsoleMod.util;

import java.util.ArrayList;
import java.util.List;

import com.geometrically.ConsoleMod.block.PS3;
import com.geometrically.ConsoleMod.tileentity.SpecialTileEntity;
import com.geometrically.ConsoleMod.tileentity.TileEntityPS3;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Utils {
	
	  public static boolean isMetadataBetween(IBlockAccess world, int x, int y, int z, int min, int max) {
		return (world.getBlockMetadata(x, y, z) >= min && world.getBlockMetadata(x, y, z) <= max);
	}
	public static boolean checkForModule(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, EnumCustomModules module){
		TileEntity te = par1World.getTileEntity(par2, par3, par4);

		if(te == null || !(te instanceof TileEntity)){ return false; }

		if(te instanceof TileEntityPS3){
			if(module == EnumCustomModules.WHITELIST && getPlayersFromModule(par1World, par2, par3, par4, EnumCustomModules.WHITELIST).contains(par5EntityPlayer.getCommandSenderName().toLowerCase())){
				sendMessageToPlayer(par5EntityPlayer, StatCollector.translateToLocal("tile.keypad.name"), StatCollector.translateToLocal("messages.module.whitelisted"), EnumChatFormatting.GREEN);
				PS3.activate(par1World, par2, par3, par4);
				return true;
			}

			if(module == EnumCustomModules.BLACKLIST  && getPlayersFromModule(par1World, par2, par3, par4, EnumCustomModules.BLACKLIST).contains(par5EntityPlayer.getCommandSenderName().toLowerCase())){
				sendMessageToPlayer(par5EntityPlayer, StatCollector.translateToLocal("tile.keypad.name"), StatCollector.translateToLocal("messages.module.blacklisted"), EnumChatFormatting.RED);
				return true;
			}
		}

		return false;
	}
	public static List<String> getPlayersFromModule(World par1World, int par2, int par3, int par4, EnumCustomModules module) {
		List<String> list = new ArrayList<String>();

		SpecialTileEntity te = (SpecialTileEntity) par1World.getTileEntity(par2, par3, par4);

		if(te.hasModule(module)){
			ItemStack item = te.getModule(module);

			for(int i = 1; i <= 10; i++){
				if(item.stackTagCompound != null && item.stackTagCompound.getString("Player" + i) != null && !item.stackTagCompound.getString("Player" + i).isEmpty()){
					list.add(item.stackTagCompound.getString("Player" + i).toLowerCase());
				}
			}
		}

		return list;
	}
	public static void sendMessageToPlayer(EntityPlayer player, String prefix, String text, EnumChatFormatting color){
		player.addChatComponentMessage(new ChatComponentText("[" + color + prefix + EnumChatFormatting.WHITE + "] " + text));
	}
	@SideOnly(Side.CLIENT)
	public static void closePlayerScreen(){
		Minecraft.getMinecraft().displayGuiScreen((GuiScreen)null);
		Minecraft.getMinecraft().setIngameFocus();
	}
	public static String removeLastChar(String par1){
		if(par1 == null || par1.isEmpty()){ return ""; }
		
		return par1.substring(0, par1.length() - 1);
	}
	public static void sendPacManMsg(EntityPlayer player) {
		closePlayerScreen();
		  player.addChatMessage(new ChatComponentText("§6You can play Pac-Man here: http://worldsbiggestpacman.com/ "
		  		+ "§r§4§lWARNING:§l§cThis site was not made by me but is still fun to enjoy."));
		
	}
}

