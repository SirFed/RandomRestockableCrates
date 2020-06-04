package zairus.randomrestockablecrates.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import zairus.randomrestockablecrates.tileentity.TileEntityCrate;

public class RRCBlocks
{
	public static final BlockCrate CRATE;
	public static final BlockCrate CRATE2;
	public static final BlockCrate CRATE3;
	public static final BlockCrate CRATE4;
	
	static
	{
		CRATE = new BlockCrate(Material.WOOD, 0, "blockcrate1");
		CRATE2 = new BlockCrate(Material.WOOD, 1, "blockcrate2");
		CRATE3 = new BlockCrate(Material.ANVIL, 2, "blockcrate3");
		CRATE4 = new BlockCrate(Material.ANVIL, 3, "blockcrate4");
	}
	
	
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
				CRATE.createItemBlock(),
				CRATE2.createItemBlock(),
				CRATE3.createItemBlock(),
				CRATE4.createItemBlock()
		);
	}
	
	public static void registerModels() {
		CRATE.registerItemModel(Item.getItemFromBlock(CRATE));
		CRATE2.registerItemModel(Item.getItemFromBlock(CRATE2));
		CRATE3.registerItemModel(Item.getItemFromBlock(CRATE3));
		CRATE4.registerItemModel(Item.getItemFromBlock(CRATE4));
	}
	
}
