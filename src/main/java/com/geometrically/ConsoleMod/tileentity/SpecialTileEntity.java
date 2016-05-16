package com.geometrically.ConsoleMod.tileentity;

import java.util.ArrayList;

import com.geometrically.ConsoleMod.item.ItemModule;
import com.geometrically.ConsoleMod.util.EnumCustomModules;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public abstract class SpecialTileEntity extends TileEntity{
	public ItemStack[] itemStacks = new ItemStack[getNumberOfCustomizableOptions()];
	

	public ItemStack getModule(EnumCustomModules module){
		for(int i = 0; i < this.itemStacks.length; i++){
			if(this.itemStacks[i] != null && this.itemStacks[i].getItem() instanceof ItemModule && ((ItemModule) this.itemStacks[i].getItem()).getModule() == module){
				return this.itemStacks[i];
			}
		}
		
		return null;
	}

	public boolean hasModule(EnumCustomModules module){
		if(module == null){
			for(int i = 0; i < this.itemStacks.length; i++){
				if(this.itemStacks[i] == null){
					return true;
				}
			}
		}else{
			for(int i = 0; i < this.itemStacks.length; i++){
				if(this.itemStacks[i] != null && this.itemStacks[i].getItem() instanceof ItemModule && ((ItemModule) this.itemStacks[i].getItem()).getModule() == module){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public int getNumberOfCustomizableOptions(){
		return this.acceptedModules().length;
	}
	
	public ArrayList<EnumCustomModules> getAcceptedModules(){
		ArrayList<EnumCustomModules> list = new ArrayList<EnumCustomModules>();
		
		for(EnumCustomModules module : acceptedModules()){
			list.add(module);
		}
		
		return list;
	}
	
	
	
	
	public abstract EnumCustomModules[] acceptedModules();
	
}