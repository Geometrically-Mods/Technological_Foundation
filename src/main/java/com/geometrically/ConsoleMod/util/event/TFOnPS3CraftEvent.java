package com.geometrically.ConsoleMod.util.event;

import com.geometrically.ConsoleMod.ConsoleCore;
import com.geometrically.ConsoleMod.init.Achievements;
import com.geometrically.ConsoleMod.init.ConsoleBlocks;
import com.geometrically.ConsoleMod.init.ConsoleItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

public class TFOnPS3CraftEvent {

	 @SubscribeEvent
	    public void craftController(ItemCraftedEvent e, ItemStack stack) {
	        if(e.crafting.getItem().equals(ConsoleBlocks.PS3)) {
	            //e.player.addStat(Achievements.CraftCtrl, 1);
	            stack.addEnchantment(ConsoleCore.Gaming, 2);
	        }
	 }
}
