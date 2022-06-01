
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.carbonsoft.ic.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.carbonsoft.ic.block.entity.IronFurnaceOnBlockEntity;
import net.carbonsoft.ic.block.entity.IronFurnaceBlockEntity;
import net.carbonsoft.ic.block.entity.GeneratorOnBlockEntity;
import net.carbonsoft.ic.block.entity.GeneratorBlockEntity;
import net.carbonsoft.ic.block.entity.FanBlockBlockEntity;
import net.carbonsoft.ic.block.entity.CopperWireBlockEntity;
import net.carbonsoft.ic.Ic3Mod;

public class Ic3ModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Ic3Mod.MODID);
	public static final RegistryObject<BlockEntityType<?>> IRON_FURNACE = register("iron_furnace", Ic3ModBlocks.IRON_FURNACE,
			IronFurnaceBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COPPER_WIRE = register("copper_wire", Ic3ModBlocks.COPPER_WIRE,
			CopperWireBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FAN_BLOCK = register("fan_block", Ic3ModBlocks.FAN_BLOCK, FanBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GENERATOR = register("generator", Ic3ModBlocks.GENERATOR, GeneratorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IRON_FURNACE_ON = register("iron_furnace_on", Ic3ModBlocks.IRON_FURNACE_ON,
			IronFurnaceOnBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GENERATOR_ON = register("generator_on", Ic3ModBlocks.GENERATOR_ON,
			GeneratorOnBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
