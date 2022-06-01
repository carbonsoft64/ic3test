package net.carbonsoft.ic.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class TENeuSENDProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sendenergy = 0;
		double sending = 0;
		sendenergy = 10;
		sending = Math.min(new Object() {
			public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN)
							.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
				return _retval.get();
			}
		}.receiveEnergySimulate(world, new BlockPos(x, y + 1, z), (int) sendenergy), new Object() {
			public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos(x, y, z), (int) sendenergy));
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
			int _amount = (int) sending;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
		}
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y + 1, z));
			int _amount = (int) sending;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		sending = Math.min(new Object() {
			public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP)
							.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
				return _retval.get();
			}
		}.receiveEnergySimulate(world, new BlockPos(x, y - 1, z), (int) sendenergy), new Object() {
			public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos(x, y, z), (int) sendenergy));
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
			int _amount = (int) sending;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
		}
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y - 1, z));
			int _amount = (int) sending;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, Direction.UP).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		sending = Math.min(new Object() {
			public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.WEST)
							.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
				return _retval.get();
			}
		}.receiveEnergySimulate(world, new BlockPos(x + 1, y, z), (int) sendenergy), new Object() {
			public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos(x, y, z), (int) sendenergy));
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
			int _amount = (int) sending;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
		}
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x + 1, y, z));
			int _amount = (int) sending;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, Direction.WEST).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		sending = Math.min(new Object() {
			public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.EAST)
							.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
				return _retval.get();
			}
		}.receiveEnergySimulate(world, new BlockPos(x - 1, y, z), (int) sendenergy), new Object() {
			public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos(x, y, z), (int) sendenergy));
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
			int _amount = (int) sending;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
		}
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x - 1, y, z));
			int _amount = (int) sending;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, Direction.EAST).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		sending = Math.min(new Object() {
			public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.NORTH)
							.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
				return _retval.get();
			}
		}.receiveEnergySimulate(world, new BlockPos(x, y, z + 1), (int) sendenergy), new Object() {
			public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos(x, y, z), (int) sendenergy));
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
			int _amount = (int) sending;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
		}
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z + 1));
			int _amount = (int) sending;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, Direction.NORTH).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
		sending = Math.min(new Object() {
			public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH)
							.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
				return _retval.get();
			}
		}.receiveEnergySimulate(world, new BlockPos(x, y, z - 1), (int) sendenergy), new Object() {
			public int extractEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos(x, y, z), (int) sendenergy));
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
			int _amount = (int) sending;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
		}
		{
			BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z - 1));
			int _amount = (int) sending;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, Direction.SOUTH).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
	}
}
