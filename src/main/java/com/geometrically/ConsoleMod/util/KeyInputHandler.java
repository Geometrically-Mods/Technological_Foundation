package com.geometrically.ConsoleMod.util;

import com.geometrically.ConsoleMod.init.Keybinds;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyInputHandler {
    public KeyInputHandler() {
    }

    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event) {
        if(Keybinds.Shoot.isPressed()) {
            System.out.println("ping");
        }

        if(Keybinds.pong.isPressed()) {
            System.out.println("pong");
        }

    }
}