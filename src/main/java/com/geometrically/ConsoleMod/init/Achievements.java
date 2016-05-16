package com.geometrically.ConsoleMod.init;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class Achievements {
    public static Achievement GettingS;
    public static Achievement CraftCtrl;

    public Achievements() {
    }

    public static void init() {

     	GettingS = new Achievement("mineOre", "mineOre", 0, 0, new ItemStack(ConsoleBlocks.SiliconOre), (Achievement)null).initIndependentStat().registerStat();
    	CraftCtrl = new Achievement("craftCTRL", "craftCTRL", 2, 1, ConsoleItems.Controller, GettingS).registerStat();
        AchievementPage.registerAchievementPage(new AchievementPage("TF Achievments", new Achievement[]{GettingS, CraftCtrl}));
    }
}
