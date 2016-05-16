package com.geometrically.ConsoleMod;

import com.geometrically.ConsoleMod.entity.EntityCT;
import com.geometrically.ConsoleMod.gui.GuiHandler;
import com.geometrically.ConsoleMod.init.Achievements;
import com.geometrically.ConsoleMod.init.ConsoleBlocks;
import com.geometrically.ConsoleMod.init.ConsoleItems;
import com.geometrically.ConsoleMod.init.Keybinds;
import com.geometrically.ConsoleMod.init.RecipeHandler;
import com.geometrically.ConsoleMod.item.ItemModule;
import com.geometrically.ConsoleMod.proxy.CommonProxy;
import com.geometrically.ConsoleMod.util.KeyInputHandler;
import com.geometrically.ConsoleMod.util.enchantments.EnchantmentComputing;
import com.geometrically.ConsoleMod.util.enchantments.EnchantmentGaming;
import com.geometrically.ConsoleMod.util.event.TFOnCtrlCraftEvent;
import com.geometrically.ConsoleMod.util.event.TFOnMineEvent;
import com.geometrically.ConsoleMod.util.packet.PacketSCheckPassword;
import com.geometrically.ConsoleMod.util.packet.PacketSSetPassword;
import com.geometrically.ConsoleMod.worldgen.WorldGen;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.enchantment.Enchantment;

@Mod(modid = "tf", name = "Technological Foundation", version = "1.0", acceptedMinecraftVersions = "[1.7.10]")
	public class ConsoleCore {
	    @Instance("tf")
	    public static ConsoleCore instance;
	    @SidedProxy(
	        clientSide = "com.geometrically.ConsoleMod.proxy.ClientProxy",
	        serverSide = "com.geometrically.ConsoleMod.proxy.CommonProxy"
	    )
	    public static CommonProxy proxy;
	    
	    private GuiHandler GuiHandler = new GuiHandler();
	 
	    public static final TabConsole tabConsole = new TabConsole("tabConsole");
	    
	    public static SimpleNetworkWrapper network;
	    
	    public static final Enchantment Gaming = new EnchantmentGaming(90, 3);
	    public static final Enchantment Computing = new EnchantmentComputing(91, 3);
	    public static ItemModule whitelistModule;
	    public static ItemModule blacklistModule;

	    public ConsoleCore() {
	    }

	    @EventHandler
	    public void preInit(FMLPreInitializationEvent event) {
	        ConsoleBlocks.init();
	        ConsoleItems.init();
	        
	        ConsoleBlocks.register();
	        ConsoleItems.registerItems();
	        
	        RecipeHandler.init();
	        
	        GameRegistry.registerWorldGenerator(new WorldGen(), 0);

			NetworkRegistry.INSTANCE.registerGuiHandler(this, GuiHandler);
			network = NetworkRegistry.INSTANCE.newSimpleChannel("ChannelTF");
			 network.registerMessage(PacketSSetPassword.Handler.class, PacketSSetPassword.class, 0, Side.SERVER);
		     network.registerMessage(PacketSCheckPassword.Handler.class, PacketSCheckPassword.class, 1, Side.SERVER);
	        proxy.registerRenderThings();
	    	
	    }

	    @EventHandler
	    public void Init(FMLInitializationEvent event) {
	        Achievements.init();
	      
	        FMLCommonHandler.instance().bus().register(new TFOnCtrlCraftEvent());
	    	FMLCommonHandler.instance().bus().register(new TFOnMineEvent());
	    	
	        EntityRegistry.registerModEntity(EntityCT.class, "EMP", 0, this, 64, 10, true);
	    }

	    @EventHandler
	    public void PostInit(FMLPostInitializationEvent event) {
	        FMLCommonHandler.instance().bus().register(new KeyInputHandler());
	        Keybinds.init();
	    }
	}
