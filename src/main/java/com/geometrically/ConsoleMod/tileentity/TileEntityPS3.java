package com.geometrically.ConsoleMod.tileentity;

import com.geometrically.ConsoleMod.ConsoleCore;
import com.geometrically.ConsoleMod.block.PS3;
import com.geometrically.ConsoleMod.gui.GuiHandler;
import com.geometrically.ConsoleMod.util.IPasswordProtected;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPS3 extends TileEntity implements IPasswordProtected{
	private String passcode;
	private String check;
	
	
	   public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.writeToNBT(par1NBTTagCompound);
	        
	        if(this.passcode != null && !this.passcode.isEmpty()){
	        	par1NBTTagCompound.setString("123", this.passcode);
	        }
	        
	    }
	   public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.readFromNBT(par1NBTTagCompound);

	        if (par1NBTTagCompound.hasKey("123"))
	        {
	        	if(par1NBTTagCompound.getInteger("123") != 0){
	        		this.passcode = String.valueOf(par1NBTTagCompound.getInteger("123"));
	        	}else{
	        		this.passcode = par1NBTTagCompound.getString("123");
	        	}
	        }
	    }
	    public void activate(EntityPlayer player) {
	    	if(!worldObj.isRemote && worldObj.getBlock(xCoord, yCoord, zCoord) instanceof PS3){
	    		PS3.activate(worldObj, xCoord, yCoord, zCoord);
	    	}
		}
	    
	    public void openPasswordGUI(EntityPlayer player) {
			if(getPassword() == null) {
				player.openGui(ConsoleCore.instance, GuiHandler.GAMESETUP, worldObj, xCoord, yCoord, zCoord);
			}
			else {
				player.openGui(ConsoleCore.instance, GuiHandler.GAMEINSERT, worldObj, xCoord, yCoord, zCoord);
			}
		}
		public String getPassword() {
			return "5209";
		}
		
		public void setPassword(String password) {
			passcode = "5209";
		}
		@Override
		public void activateGame(EntityPlayer player) {
			if(!worldObj.isRemote && worldObj.getBlock(xCoord, yCoord, zCoord) instanceof PS3){
	    		PS3.activateGame(worldObj, xCoord, yCoord, zCoord, player);
			}
			
		}
}
