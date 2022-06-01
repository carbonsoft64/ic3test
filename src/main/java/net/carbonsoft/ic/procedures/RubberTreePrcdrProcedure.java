package net.carbonsoft.ic.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.carbonsoft.ic.init.Ic3ModBlocks;

import java.util.Random;

public class RubberTreePrcdrProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double rand = 0;
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Ic3ModBlocks.RUBBER_TREE.get()) {
			if (Mth.nextInt(new Random(), 1, 20) <= 1 && (world.getBlockState(new BlockPos(x, y + 8, z))).getBlock() == Blocks.AIR) {
				rand = Mth.nextInt(new Random(), 1, 2);
				if (rand == 1) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("ic3", "rubbertree1"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(x, y, z), new BlockPos(x, y, z),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				} else if (rand == 2) {
					if (world instanceof ServerLevel _serverworld) {
						StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("ic3", "rubbertree2"));
						if (template != null) {
							template.placeInWorld(_serverworld, new BlockPos(x, y, z), new BlockPos(x, y, z),
									new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
									_serverworld.random, 3);
						}
					}
				}
			}
		}
	}
}
