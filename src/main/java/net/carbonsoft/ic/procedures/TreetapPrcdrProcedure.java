package net.carbonsoft.ic.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.carbonsoft.ic.init.Ic3ModItems;
import net.carbonsoft.ic.init.Ic3ModBlocks;

import java.util.Random;

public class TreetapPrcdrProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		Direction blockdirection = Direction.NORTH;
		blockdirection = new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				property = _bs.getBlock().getStateDefinition().getProperty("axis");
				if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
					return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(new BlockPos(x, y, z));
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Ic3ModBlocks.RUBBER_DRY_WOOD.get()) {
			if (Mth.nextInt(new Random(), 1, 100) <= 16) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Ic3ModItems.STICKY_RESIN.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (Mth.nextInt(new Random(), 1, 100) <= 20) {
				world.setBlock(new BlockPos(x, y, z), Ic3ModBlocks.RUBBER_WOOD.get().defaultBlockState(), 3);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Ic3ModBlocks.RUBBER_WET_WOOD.get()) {
			world.setBlock(new BlockPos(x, y, z), Ic3ModBlocks.RUBBER_DRY_WOOD.get().defaultBlockState(), 3);
			{
				Direction _dir = blockdirection;
				BlockPos _pos = new BlockPos(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
					world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
				} else {
					_property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
				}
			}
			for (int index0 = 0; index0 < (int) (Mth.nextInt(new Random(), 2, 4)); index0++) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Ic3ModItems.STICKY_RESIN.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		}
	}
}
