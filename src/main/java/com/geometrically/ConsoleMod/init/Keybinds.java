package com.geometrically.ConsoleMod.init;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class Keybinds {
    public static KeyBinding Shoot;
    public static KeyBinding pong;

    public Keybinds() {
    }

    public static void init() {
        Shoot = new KeyBinding("key.shoot", 19, "key.categories.ConsoleMod");
        pong = new KeyBinding("key.pong", 25, "key.categories.mymod");
        ClientRegistry.registerKeyBinding(Shoot);
        ClientRegistry.registerKeyBinding(pong);
    }
}
