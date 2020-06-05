package zairus.randomrestockablecrates.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.client.model.ModelLoader;
import zairus.randomrestockablecrates.RRCConstants;
import zairus.randomrestockablecrates.client.renderer.tileentity.TileEntityCrateRenderer;
import zairus.randomrestockablecrates.tileentity.TileEntityCrate;

public class ClientProxy extends CommonProxy
{
	public static final Minecraft mc = Minecraft.getMinecraft();
	
	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		;
	}
	
	@Override
	public void init(FMLInitializationEvent e)
	{
		;
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e)
	{
		;
	}
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(RRCConstants.MODID + ":" + id, "inventory"));
	}
	
	@Override
	public void initTESR()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrate.class, new TileEntityCrateRenderer());
	}
}
