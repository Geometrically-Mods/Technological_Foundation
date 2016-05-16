package com.geometrically.ConsoleMod.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.geometrically.ConsoleMod.container.ContainerGeneric;
import com.geometrically.ConsoleMod.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiGameList extends GuiContainer{
	private TileEntity tileEntity;
	private String blockName;
	
	private static final ResourceLocation texture = new ResourceLocation("tf:textures/gui/gamelist.png");

	public GuiGameList(InventoryPlayer inventoryPlayer, TileEntity tileEntity, Block block){
        super(new ContainerGeneric(inventoryPlayer, tileEntity));
        this.tileEntity = tileEntity;   
		this.blockName = StatCollector.translateToLocal(block.getUnlocalizedName() + ".name");
    }

	@Override
	public void initGui(){
    	super.initGui();	
    	
    	this.buttonList.add(new GuiButton(0, this.width / 2 - 38, this.height / 2 - 50 + 10, 80, 20, "Pac-Man"));
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(texture);
	        int k = (this.width - this.xSize) / 2;
	        int l = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	    }	
	@Override
	protected void actionPerformed(GuiButton guibutton){
		switch(guibutton.id){
		case 0:
			Utils.closePlayerScreen();
			System.out.println("§6You can play Pac-Man here: http://worldsbiggestpacman.com/ "
			  		+ "§r§4§lWARNING:§l§cThis site was not made by me but is still fun to enjoy.");
			break;
		}
	}
}
