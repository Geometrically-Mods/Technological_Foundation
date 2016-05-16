package com.geometrically.ConsoleMod.util;

import com.geometrically.ConsoleMod.ConsoleCore;
import com.geometrically.ConsoleMod.item.ItemModule;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

//author @Gforce
public enum EnumCustomModules {
	WHITELIST(ConsoleCore.whitelistModule, "whitelistModule", "Whitelist module"),
	BLACKLIST(ConsoleCore.blacklistModule, "blacklistModule", "Blacklist module");
	
	private ItemModule module;
	private String moduleUnlocalizedName;
	private String moduleLocalizedName;

	private EnumCustomModules(ItemModule moduleItem, String unlocalizedName, String localizedName){
		this.module = moduleItem;
		this.moduleUnlocalizedName = unlocalizedName;
		this.moduleLocalizedName = localizedName;
	}
	
	public ItemModule getItem() {
		return this.module;
	}
	
	public String getUnlocalizedName() {
		return this.moduleUnlocalizedName;
	}
	
	public String getName() {
		return this.moduleLocalizedName;
	}
	
	public static EnumCustomModules getModuleFromStack(ItemStack item) {
		if(item == null || item.getItem() == null) return null;
		
		for(EnumCustomModules module : values()) {
			if(module.getItem() == item.getItem()) {
				return module;
			}
		}
		
		return null;
	}
	
	public static void refresh() {
		for(EnumCustomModules module : values()) {
			module.module = (ItemModule) GameRegistry.findItem("securitycraft", module.getUnlocalizedName());
		}
	}

}

