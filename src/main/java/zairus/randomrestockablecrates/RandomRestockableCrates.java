package zairus.randomrestockablecrates;

import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import zairus.randomrestockablecrates.block.RRCBlocks;
import zairus.randomrestockablecrates.event.RRCEventHandler;
import zairus.randomrestockablecrates.gui.GuiHandler;
import zairus.randomrestockablecrates.network.PacketPipeline;
import zairus.randomrestockablecrates.proxy.CommonProxy;

@Mod(modid = RRCConstants.MODID, name = RRCConstants.NAME, version = RRCConstants.VERSION)
public class RandomRestockableCrates
{
	private static Logger logger;
	
	@SidedProxy(clientSide = RRCConstants.MOD_CLIENT_PROXY, serverSide = RRCConstants.MOD_COMMON_PROXY)
	public static CommonProxy proxy;
	
	@Mod.Instance(RRCConstants.MODID)
	public static RandomRestockableCrates instance;
	
	public static final PacketPipeline packetPipeline = new PacketPipeline();
	
	public static CreativeTabs tabCrates = new CreativeTabs("RandomCrates") {
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(RRCBlocks.CRATE);
		}
	};
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		//proxy.initTESR();
		RRCConfig.init(event.getSuggestedConfigurationFile());
		
		RandomRestockableCrates.proxy.preInit(event);
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		RRCEventHandler eventHandler = new RRCEventHandler();
		
		RandomRestockableCrates.proxy.init(event);
		packetPipeline.initalise();
		
		//RRCBlocks.initModels();
		
		MinecraftForge.EVENT_BUS.register(eventHandler);
		MinecraftForge.TERRAIN_GEN_BUS.register(eventHandler);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(RandomRestockableCrates.instance, new GuiHandler());
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		RandomRestockableCrates.proxy.postInit(event);
		packetPipeline.postInitialise();
	}
	
	public static void log(String message)
	{
		logger.info(message);
	}
	
	@Mod.EventBusSubscriber 
	public static class RegistrationHandler{
		
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			RRCBlocks.register(event.getRegistry());
		}
		
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			RRCBlocks.registeritemBlocks(event.getRegistry());
		}
		
		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			RRCBlocks.registerModels();
		}
		
	}
}
