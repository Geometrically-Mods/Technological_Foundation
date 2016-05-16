package com.geometrically.ConsoleMod.util.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentComputing extends Enchantment {
    public EnchantmentComputing(int id, int rarity) {
        super(id, rarity, EnumEnchantmentType.digger);
        this.setName("Computing");
    }

    public int getMinEnchantability(int par1) {
        return 5 + (par1 - 1) * 10;
    }

    public int getMaxEnchantability(int par1) {
        return this.getMinEnchantability(par1) + 20;
    }

    public int getMaxLevel() {
        return 4;
    }
}
