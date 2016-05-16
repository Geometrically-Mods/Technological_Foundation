package com.geometrically.ConsoleMod.util;

import net.minecraft.entity.player.EntityPlayer;

public interface IPasswordProtected {
	
public void activate(EntityPlayer player);

public void activateGame(EntityPlayer player);
	
	
	public void openPasswordGUI(EntityPlayer player);
	
	public String getPassword();
	
	public void setPassword(String password);
	
}

