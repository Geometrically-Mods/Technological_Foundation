package com.geometrically.ConsoleMod.item;

import java.util.List;

import com.geometrically.ConsoleMod.ConsoleCore;
import com.geometrically.ConsoleMod.util.EnumCustomModules;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemModule extends Item{
	
	private final EnumCustomModules module;
	private final boolean nbtCanBeModified;
	
	public ItemModule(EnumCustomModules module, boolean nbtCanBeModified){
		this.module = module;
		this.nbtCanBeModified = nbtCanBeModified;
		
		this.setMaxStackSize(1);
		this.setCreativeTab(ConsoleCore.tabConsole);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if(nbtCanBeModified){
			par3List.add(StatCollector.translateToLocal("tooltip.module.modifiable"));
			par3List.add(StatCollector.translateToLocal("tooltip.module.usage"));
		}else{
			par3List.add(StatCollector.translateToLocal("tooltip.module.notModifiable"));
		}
				
		if(module == EnumCustomModules.WHITELIST || module == EnumCustomModules.BLACKLIST){
			par3List.add(" ");
			par3List.add(StatCollector.translateToLocal("tooltip.module.players") + ":");
			
			if(par1ItemStack.stackTagCompound != null){
				for(int i = 1; i <= 10; i++){
					if(!par1ItemStack.stackTagCompound.getString("Player" + i).isEmpty()){
						par3List.add(par1ItemStack.stackTagCompound.getString("Player" + i));
					}
				}
			}
		}
	}

	public EnumCustomModules getModule() {
		return module;
	}
	
	public boolean canBeModified(){
		return this.nbtCanBeModified;
	}

}