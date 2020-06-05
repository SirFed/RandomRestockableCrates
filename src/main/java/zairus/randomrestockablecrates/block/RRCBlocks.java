package zairus.randomrestockablecrates.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import zairus.randomrestockablecrates.tileentity.TileEntityCrate;

public class RRCBlocks
{
	public static BlockCrate CRATE = new BlockCrate(Material.WOOD, 0, "blockcrate1");
	public static  BlockCrate CRATE2 = new BlockCrate(Material.WOOD, 1, "blockcrate2");
	public static  BlockCrate CRATE3 = new BlockCrate(Material.ANVIL, 2, "blockcrate3");
	public static  BlockCrate CRATE4 = new BlockCrate(Material.ANVIL, 3, "blockcrate4");
	
	@SuppressWarnings("deprecation")
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				CRATE,
				CRATE2,
				CRATE3,
				CRATE4
		);
		GameRegistry.registerTileEntity(TileEntityCrate.class, "tileEntityCrate");
	}
	
	public static void registeritemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				CRATE.createItemBlock("blockcrate1"),
				CRATE2.createItemBlock("blockcrate2"),
				CRATE3.createItemBlock("blockcrate3"),
				CRATE4.createItemBlock("blockcrate4")
		);
	}
	
	public static void registerModels() {
		CRATE.registerItemModel(Item.getItemFromBlock(CRATE));
		CRATE2.registerItemModel(Item.getItemFromBlock(CRATE2));
		CRATE3.registerItemModel(Item.getItemFromBlock(CRATE3));
		CRATE4.registerItemModel(Item.getItemFromBlock(CRATE4));
	}
	
}
