package com.geometrically.ConsoleMod.util.event;

import com.geometrically.ConsoleMod.init.Achievements;
import com.geometrically.ConsoleMod.init.ConsoleBlocks;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.ItemStack;

public class TFOnMineEvent {
	
	@SubscribeEvent
	public void onPickedUp(PlayerEvent.ItemPickupEvent e){
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ConsoleBlocks.SiliconOre))){
			e.player.addStat(Achievements.GettingS, 1);
		}
	}

}