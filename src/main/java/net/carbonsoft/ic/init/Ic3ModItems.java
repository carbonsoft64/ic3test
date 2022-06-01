
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.carbonsoft.ic.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.carbonsoft.ic.item.TreetapItem;
import net.carbonsoft.ic.item.TinPlateItem;
import net.carbonsoft.ic.item.TinItemCasingItem;
import net.carbonsoft.ic.item.TinIngotItem;
import net.carbonsoft.ic.item.StickyResinItem;
import net.carbonsoft.ic.item.RubberItem;
import net.carbonsoft.ic.item.MultimeterItem;
import net.carbonsoft.ic.item.IronPlateItem;
import net.carbonsoft.ic.item.HammerItem;
import net.carbonsoft.ic.item.CutterItem;
import net.carbonsoft.ic.item.CopperPlateItem;
import net.carbonsoft.ic.item.CopperItemCasingItem;
import net.carbonsoft.ic.item.CopperIngotItem;
import net.carbonsoft.ic.item.AccumulatorItem;
import net.carbonsoft.ic.Ic3Mod;

public class Ic3ModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, Ic3Mod.MODID);
	public static final RegistryObject<Item> HAMMER = REGISTRY.register("hammer", () -> new HammerItem());
	public static final RegistryObject<Item> IRON_PLATE = REGISTRY.register("iron_plate", () -> new IronPlateItem());
	public static final RegistryObject<Item> IRON_FURNACE = block(Ic3ModBlocks.IRON_FURNACE, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> COPPER_WIRE = block(Ic3ModBlocks.COPPER_WIRE, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> FAN_BLOCK = block(Ic3ModBlocks.FAN_BLOCK, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> GENERATOR = block(Ic3ModBlocks.GENERATOR, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> MULTIMETER = REGISTRY.register("multimeter", () -> new MultimeterItem());
	public static final RegistryObject<Item> IRON_FURNACE_ON = block(Ic3ModBlocks.IRON_FURNACE_ON, null);
	public static final RegistryObject<Item> GENERATOR_ON = block(Ic3ModBlocks.GENERATOR_ON, null);
	public static final RegistryObject<Item> TIN_ORE = block(Ic3ModBlocks.TIN_ORE, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> TIN_INGOT = REGISTRY.register("tin_ingot", () -> new TinIngotItem());
	public static final RegistryObject<Item> TIN_ITEM_CASING = REGISTRY.register("tin_item_casing", () -> new TinItemCasingItem());
	public static final RegistryObject<Item> TIN_PLATE = REGISTRY.register("tin_plate", () -> new TinPlateItem());
	public static final RegistryObject<Item> TIN_WIRE = block(Ic3ModBlocks.TIN_WIRE, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> CUTTER = REGISTRY.register("cutter", () -> new CutterItem());
	public static final RegistryObject<Item> STICKY_RESIN = REGISTRY.register("sticky_resin", () -> new StickyResinItem());
	public static final RegistryObject<Item> RUBBER = REGISTRY.register("rubber", () -> new RubberItem());
	public static final RegistryObject<Item> TIN_CABLE_1 = block(Ic3ModBlocks.TIN_CABLE_1, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> ACCUMULATOR = REGISTRY.register("accumulator", () -> new AccumulatorItem());
	public static final RegistryObject<Item> MACHINE_BLOCK = block(Ic3ModBlocks.MACHINE_BLOCK, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> RUBBER_WOOD = block(Ic3ModBlocks.RUBBER_WOOD, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> RUBBER_WET_WOOD = block(Ic3ModBlocks.RUBBER_WET_WOOD, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> RUBBER_LEAVES = block(Ic3ModBlocks.RUBBER_LEAVES, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> TREETAP = REGISTRY.register("treetap", () -> new TreetapItem());
	public static final RegistryObject<Item> RUBBER_DRY_WOOD = block(Ic3ModBlocks.RUBBER_DRY_WOOD, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> RUBBER_TREE = block(Ic3ModBlocks.RUBBER_TREE, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> COPPER_ORE = block(Ic3ModBlocks.COPPER_ORE, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);
	public static final RegistryObject<Item> COPPER_INGOT = REGISTRY.register("copper_ingot", () -> new CopperIngotItem());
	public static final RegistryObject<Item> COPPER_ITEM_CASING = REGISTRY.register("copper_item_casing", () -> new CopperItemCasingItem());
	public static final RegistryObject<Item> COPPER_PLATE = REGISTRY.register("copper_plate", () -> new CopperPlateItem());
	public static final RegistryObject<Item> SOLAR_PANEL = block(Ic3ModBlocks.SOLAR_PANEL, Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
