package com.geometrically.ConsoleMod;

import com.geometrically.ConsoleMod.init.ConsoleItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabConsole extends CreativeTabs {
    public TabConsole(String label) {
        super(label);
    }

    public Item getTabIconItem() {
        return ConsoleItems.Controller;
    }
}
