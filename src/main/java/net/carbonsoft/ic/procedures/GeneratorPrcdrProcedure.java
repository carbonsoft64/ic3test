package net.carbonsoft.ic.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.carbonsoft.ic.init.Ic3ModBlocks;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;

public class GeneratorPrcdrProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double energytosend = 0;
		double energytoblock = 0;
		if (new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(world, new BlockPos(x, y, z)) < 4000) {
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, new BlockPos(x, y, z), 0)).getItem() == Items.COAL) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(x, y, z), "fuel") == 0) {
					if (!world.isClientSide()) {
						BlockPos _bp = new BlockPos(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getTileData().putDouble("fuel", 4000);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
						if (_ent != null) {
							final int _slotid = 0;
							final int _amount = 1;
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									ItemStack _stk = capability.getStackInSlot(_slotid).copy();
									_stk.shrink(_amount);
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
								}
							});
						}
					}
				}
			}
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "fuel") > 0
				&& (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Ic3ModBlocks.GENERATOR.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = Ic3ModBlocks.GENERATOR_ON.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				BlockEntity _be = world.getBlockEntity(_bp);
				CompoundTag _bnbt = null;
				if (_be != null) {
					_bnbt = _be.saveWithFullMetadata();
					_be.setRemoved();
				}
				world.setBlock(_bp, _bs, 3);
				if (_bnbt != null) {
					_be = world.getBlockEntity(_bp);
					if (_be != null) {
						try {
							_be.load(_bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
		} else if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "fuel") <= 0
				&& (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Ic3ModBlocks.GENERATOR_ON.get()) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = Ic3ModBlocks.GENERATOR.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				BlockEntity _be = world.getBlockEntity(_bp);
				CompoundTag _bnbt = null;
				if (_be != null) {
					_bnbt = _be.saveWithFullMetadata();
					_be.setRemoved();
				}
				world.setBlock(_bp, _bs, 3);
				if (_bnbt != null) {
					_be = world.getBlockEntity(_bp);
					if (_be != null) {
						try {
							_be.load(_bnbt);
						} catch (Exception ignored) {
						}
					}
				}
			}
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "fuel") >= 10) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putDouble("fuel", ((new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos(x, y, z), "fuel")) - 10));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			energytosend = new Object() {
				public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null)
								.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
					return _retval.get();
				}
			}.receiveEnergySimulate(world, new BlockPos(x, y, z), 10);
		} else {
			energytosend = new Object() {
				public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null)
								.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
					return _retval.get();
				}
			}.receiveEnergySimulate(world, new BlockPos(x, y, z), (int) (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "fuel")));
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getTileData().putDouble("fuel", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
			int _amount = (int) energytosend;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		if (new Object() {
			public boolean canReceiveEnergy(LevelAccessor level, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos(x, y + 1, z))) {
			if (new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, new BlockPos(x, y, z)) >= 10) {
				energytoblock = new Object() {
					public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN)
									.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
						return _retval.get();
					}
				}.receiveEnergySimulate(world, new BlockPos(x, y + 1, z), 10);
			} else {
				energytoblock = new Object() {
					public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN)
									.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
						return _retval.get();
					}
				}.receiveEnergySimulate(world, new BlockPos(x, y + 1, z), new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, new BlockPos(x, y, z)));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y + 1, z));
				int _amount = (int) energytoblock;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				int _amount = (int) energytoblock;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
		}
		if (new Object() {
			public boolean canReceiveEnergy(LevelAccessor level, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos(x, y - 1, z))) {
			if (new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, new BlockPos(x, y, z)) >= 10) {
				energytoblock = new Object() {
					public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP)
									.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
						return _retval.get();
					}
				}.receiveEnergySimulate(world, new BlockPos(x, y - 1, z), 10);
			} else {
				energytoblock = new Object() {
					public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP)
									.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
						return _retval.get();
					}
				}.receiveEnergySimulate(world, new BlockPos(x, y - 1, z), new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, new BlockPos(x, y, z)));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y - 1, z));
				int _amount = (int) energytoblock;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				int _amount = (int) energytoblock;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
		}
		if (new Object() {
			public boolean canReceiveEnergy(LevelAccessor level, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.WEST).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos(x + 1, y, z))) {
			if (new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, new BlockPos(x, y, z)) >= 10) {
				energytoblock = new Object() {
					public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, Direction.WEST)
									.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
						return _retval.get();
					}
				}.receiveEnergySimulate(world, new BlockPos(x + 1, y, z), 10);
			} else {
				energytoblock = new Object() {
					public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, Direction.WEST)
									.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
						return _retval.get();
					}
				}.receiveEnergySimulate(world, new BlockPos(x + 1, y, z), new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, new BlockPos(x, y, z)));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x + 1, y, z));
				int _amount = (int) energytoblock;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.WEST).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				int _amount = (int) energytoblock;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
		}
		if (new Object() {
			public boolean canReceiveEnergy(LevelAccessor level, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.EAST).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos(x - 1, y, z))) {
			if (new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, new BlockPos(x, y, z)) >= 10) {
				energytoblock = new Object() {
					public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, Direction.EAST)
									.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
						return _retval.get();
					}
				}.receiveEnergySimulate(world, new BlockPos(x - 1, y, z), 10);
			} else {
				energytoblock = new Object() {
					public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, Direction.EAST)
									.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
						return _retval.get();
					}
				}.receiveEnergySimulate(world, new BlockPos(x - 1, y, z), new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, new BlockPos(x, y, z)));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x - 1, y, z));
				int _amount = (int) energytoblock;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.EAST).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				int _amount = (int) energytoblock;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
		}
		if (new Object() {
			public boolean canReceiveEnergy(LevelAccessor level, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.NORTH).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos(x, y, z + 1))) {
			if (new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, new BlockPos(x, y, z)) >= 10) {
				energytoblock = new Object() {
					public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, Direction.NORTH)
									.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
						return _retval.get();
					}
				}.receiveEnergySimulate(world, new BlockPos(x, y, z + 1), 10);
			} else {
				energytoblock = new Object() {
					public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, Direction.NORTH)
									.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
						return _retval.get();
					}
				}.receiveEnergySimulate(world, new BlockPos(x, y, z + 1), new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, new BlockPos(x, y, z)));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z + 1));
				int _amount = (int) energytoblock;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.NORTH).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				int _amount = (int) energytoblock;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
		}
		if (new Object() {
			public boolean canReceiveEnergy(LevelAccessor level, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos(x, y, z - 1))) {
			if (new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, new BlockPos(x, y, z)) >= 10) {
				energytoblock = new Object() {
					public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH)
									.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
						return _retval.get();
					}
				}.receiveEnergySimulate(world, new BlockPos(x, y, z - 1), 10);
			} else {
				energytoblock = new Object() {
					public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH)
									.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
						return _retval.get();
					}
				}.receiveEnergySimulate(world, new BlockPos(x, y, z - 1), new Object() {
					public int getEnergyStored(LevelAccessor level, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = level.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, new BlockPos(x, y, z)));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z - 1));
				int _amount = (int) energytoblock;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				int _amount = (int) energytoblock;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
		}
	}
}
