package com.geometrically.ConsoleMod.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.geometrically.ConsoleMod.ConsoleCore;
import com.geometrically.ConsoleMod.container.ContainerGeneric;
import com.geometrically.ConsoleMod.util.IPasswordProtected;
import com.geometrically.ConsoleMod.util.Utils;
import com.geometrically.ConsoleMod.util.packet.PacketSSetPassword;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiSetGameCode extends GuiContainer {

	private static final ResourceLocation field_110410_t = new ResourceLocation("tf:textures/gui/blank.png");
	private TileEntity tileEntity;
	private char[] allowedChars = {'0', '1', '2', '3', '4', '5', '6' ,'7' ,'8', '9', ''};
	private String blockName;
	
	private GuiTextField keycodeTextbox;
	private boolean flag = false;
	private GuiButton saveAndContinueButton;

	public GuiSetGameCode(InventoryPlayer inventoryPlayer, TileEntity tileEntity, Block block){
		super(new ContainerGeneric(inventoryPlayer, tileEntity));
		this.tileEntity = tileEntity;
		this.blockName = StatCollector.translateToLocal(block.getUnlocalizedName() + ".name");
	}

	public void initGui(){
		super.initGui();
		Keyboard.enableRepeatEvents(true);
		this.buttonList.add(this.saveAndContinueButton = new GuiButton(0, this.width / 2 - 48, this.height / 2 + 30 + 10, 100, 20, !this.flag ? StatCollector.translateToLocal("gui.keycardSetup.save") : StatCollector.translateToLocal("gui.password.invalidCode")));

		this.keycodeTextbox = new GuiTextField(this.fontRendererObj, this.width / 2 - 37, this.height / 2 - 47, 77, 12);

		this.keycodeTextbox.setTextColor(-1);
		this.keycodeTextbox.setDisabledTextColour(-1);
		this.keycodeTextbox.setEnableBackgroundDrawing(true);
		this.keycodeTextbox.setMaxStringLength(11);

		this.updateButtonText();
	}
	
	public void onGuiClosed(){
		super.onGuiClosed();
		this.flag = false;
		Keyboard.enableRepeatEvents(false);
	}
    
    public void drawScreen(int par1, int par2, float par3){
		super.drawScreen(par1, par2, par3);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.keycodeTextbox.drawTextBox();
		this.drawString(this.fontRendererObj, "CODE:", this.width / 2 - 67, this.height / 2 - 47 + 2, 4210752);		
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2){
    
    	if(this.fontRendererObj.getStringWidth(blockName + " " + StatCollector.translateToLocal("gui.password.setup")) >= 170){
            this.fontRendererObj.drawString(blockName, this.xSize / 2 - this.fontRendererObj.getStringWidth(blockName) / 2, 6, 4210752);
            this.fontRendererObj.drawString(StatCollector.translateToLocal("gui.password.setup"), this.xSize / 2 - this.fontRendererObj.getStringWidth(StatCollector.translateToLocal("gui.password.setup")) / 2, 16, 4210752);
    	}else{
            this.fontRendererObj.drawString(blockName + " " + StatCollector.translateToLocal("gui.password.setup"), this.xSize / 2 - this.fontRendererObj.getStringWidth(blockName + " " + StatCollector.translateToLocal("gui.password.setup")) / 2, 6, 4210752);
    	}
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3){
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(field_110410_t);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
    
    protected void keyTyped(char par1, int par2){
		if(this.keycodeTextbox.isFocused() && isValidChar(par1)){
			this.keycodeTextbox.textboxKeyTyped(par1, par2);
		}else{
			super.keyTyped(par1, par2);
		}
	}
    
    private boolean isValidChar(char par1) {
		for(int x = 1; x <= this.allowedChars.length; x++){
			if(par1 == this.allowedChars[x - 1]){
				return true;
			}else{
				continue;
			}
		}
		
		return false;
	}
    
    protected void mouseClicked(int par1, int par2, int par3){
		super.mouseClicked(par1, par2, par3);
		this.keycodeTextbox.mouseClicked(par1, par2, par3);
	}

    private void updateButtonText(){
    	this.saveAndContinueButton.displayString = !this.flag ? StatCollector.translateToLocal("gui.keycardSetup.save") : StatCollector.translateToLocal("gui.password.invalidCode");
    }

    protected void actionPerformed(GuiButton guibutton){
    	switch(guibutton.id){
    	case 0:
    		if(this.keycodeTextbox.getText().isEmpty()){
    			this.flag  = true;
    			this.updateButtonText();
    			return;
    		}
    		
    		((IPasswordProtected) tileEntity).setPassword(this.keycodeTextbox.getText());
    		ConsoleCore.network.sendToServer(new PacketSSetPassword(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, this.keycodeTextbox.getText()));    		

    		Utils.closePlayerScreen();
    		Minecraft.getMinecraft().thePlayer.openGui(ConsoleCore.instance, GuiHandler.GAMEINSERT, tileEntity.getWorldObj(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);	
    	}
    }	

}