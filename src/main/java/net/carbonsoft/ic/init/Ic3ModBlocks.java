
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.carbonsoft.ic.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.carbonsoft.ic.block.TinWireBlock;
import net.carbonsoft.ic.block.TinOreBlock;
import net.carbonsoft.ic.block.TinCable1Block;
import net.carbonsoft.ic.block.SolarPanelBlock;
import net.carbonsoft.ic.block.RubberWoodBlock;
import net.carbonsoft.ic.block.RubberWetWoodBlock;
import net.carbonsoft.ic.block.RubberTreeBlock;
import net.carbonsoft.ic.block.RubberLeavesBlock;
import net.carbonsoft.ic.block.RubberDryWoodBlock;
import net.carbonsoft.ic.block.MachineBlockBlock;
import net.carbonsoft.ic.block.IronFurnaceOnBlock;
import net.carbonsoft.ic.block.IronFurnaceBlock;
import net.carbonsoft.ic.block.GeneratorOnBlock;
import net.carbonsoft.ic.block.GeneratorBlock;
import net.carbonsoft.ic.block.FanBlockBlock;
import net.carbonsoft.ic.block.CopperWireBlock;
import net.carbonsoft.ic.block.CopperOreBlock;
import net.carbonsoft.ic.Ic3Mod;

public class Ic3ModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, Ic3Mod.MODID);
	public static final RegistryObject<Block> IRON_FURNACE = REGISTRY.register("iron_furnace", () -> new IronFurnaceBlock());
	public static final RegistryObject<Block> COPPER_WIRE = REGISTRY.register("copper_wire", () -> new CopperWireBlock());
	public static final RegistryObject<Block> FAN_BLOCK = REGISTRY.register("fan_block", () -> new FanBlockBlock());
	public static final RegistryObject<Block> GENERATOR = REGISTRY.register("generator", () -> new GeneratorBlock());
	public static final RegistryObject<Block> IRON_FURNACE_ON = REGISTRY.register("iron_furnace_on", () -> new IronFurnaceOnBlock());
	public static final RegistryObject<Block> GENERATOR_ON = REGISTRY.register("generator_on", () -> new GeneratorOnBlock());
	public static final RegistryObject<Block> TIN_ORE = REGISTRY.register("tin_ore", () -> new TinOreBlock());
	public static final RegistryObject<Block> TIN_WIRE = REGISTRY.register("tin_wire", () -> new TinWireBlock());
	public static final RegistryObject<Block> TIN_CABLE_1 = REGISTRY.register("tin_cable_1", () -> new TinCable1Block());
	public static final RegistryObject<Block> MACHINE_BLOCK = REGISTRY.register("machine_block", () -> new MachineBlockBlock());
	public static final RegistryObject<Block> RUBBER_WOOD = REGISTRY.register("rubber_wood", () -> new RubberWoodBlock());
	public static final RegistryObject<Block> RUBBER_WET_WOOD = REGISTRY.register("rubber_wet_wood", () -> new RubberWetWoodBlock());
	public static final RegistryObject<Block> RUBBER_LEAVES = REGISTRY.register("rubber_leaves", () -> new RubberLeavesBlock());
	public static final RegistryObject<Block> RUBBER_DRY_WOOD = REGISTRY.register("rubber_dry_wood", () -> new RubberDryWoodBlock());
	public static final RegistryObject<Block> RUBBER_TREE = REGISTRY.register("rubber_tree", () -> new RubberTreeBlock());
	public static final RegistryObject<Block> COPPER_ORE = REGISTRY.register("copper_ore", () -> new CopperOreBlock());
	public static final RegistryObject<Block> SOLAR_PANEL = REGISTRY.register("solar_panel", () -> new SolarPanelBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			RubberTreeBlock.registerRenderLayer();
		}
	}
}
