package com.geometrically.ConsoleMod.item;

import java.util.Map;

import com.geometrically.ConsoleMod.ConsoleCore;
import com.geometrically.ConsoleMod.Reference;
import com.geometrically.ConsoleMod.entity.EntityCT;
import com.geometrically.ConsoleMod.init.ConsoleItems;
import com.geometrically.ConsoleMod.util.enchantments.EnchantmentGaming;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class Controller extends ItemSpade {
    public Controller(ToolMaterial material) {
        super(material);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
            player.swingItem();
            world.playSoundAtEntity(player, Reference.MOD_ID + ":emp_gun.ogg", 0.5F, 1.0F);
            if (!world.isRemote)
            {
                world.spawnEntityInWorld(new EntityCT(world, player));
                //Gaming Prompt messages.
                if(hasEnchantment(itemStack, ConsoleCore.Gaming, 1, false)){
                	  player.addChatMessage(new ChatComponentText("§6Master Gamer:§rAhh, I have seen you have chosen to become a gamer."
                	  		+ " To start off, you must make a Playstation 3. Then, you can start your journey to become a Gamer."));
                	  //itemStack.addEnchantment(ConsoleCore.Gaming, 2);
                }
                if(hasEnchantment(itemStack, ConsoleCore.Gaming, 2, false)){
              	  player.addChatMessage(new ChatComponentText("§6Master Gamer:§rWell, I see that you have completed first task, now, turn on the PS3 while holding the controller"
              	  		+ "! You may see a GUI pop up. After entering a Unique ID, type in 5209 as your passcode. If you enter it right, you can play games."
              	  		+ "Then, you can unlock more games, and continue your journey."));
              	  	//itemStack.addEnchantment(ConsoleCore.Gaming, 3);
              	  
          		}
                //Computing Prompt Messages
                //TODO Need to add 3 & 4
                if(hasEnchantment(itemStack, ConsoleCore.Computing, 1, false)){
              	  player.addChatMessage(new ChatComponentText("§6Master Coder:§rTo Start off coding or becoming a Computer Scientist, craft a Desktop Moniter. Then, your coding career may begin!"));
                }
                if(hasEnchantment(itemStack, ConsoleCore.Computing, 2, false)){
                	  player.addChatMessage(new ChatComponentText("§6Master Coder:§rWell, you can almost start coding. Craft a Robot. When you place it, right click it"
                	  		+ "You can start programming your robot! A guide on TF Programming can be found here."));
                  }
            }
        return itemStack;
    }
    //hasEnchantment method, checks if item has certain enchantment, as seen above.
    @SuppressWarnings("unchecked")                                
    public static boolean hasEnchantment(ItemStack stack, Enchantment ench, int level, boolean strict)
    {
    Map<Integer, Integer> map = EnchantmentHelper.getEnchantments(stack);
    if (map.containsKey(new Integer(ench.effectId))) return strict ? map.get(new Integer(ench.effectId)) == level : map.get(new Integer(ench.effectId)) >= level;
    return false;
   }
	
}

