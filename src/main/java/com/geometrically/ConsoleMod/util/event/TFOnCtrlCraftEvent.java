package com.geometrically.ConsoleMod.util.event;

import com.geometrically.ConsoleMod.init.Achievements;
import com.geometrically.ConsoleMod.init.ConsoleItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class TFOnCtrlCraftEvent {
    public TFOnCtrlCraftEvent() {
    }

    @SubscribeEvent
    public void craftController(ItemCraftedEvent e) {
        if(e.crafting.getItem().equals(ConsoleItems.Controller)) {
            e.player.addStat(Achievements.CraftCtrl, 1);
        }

    }
}
