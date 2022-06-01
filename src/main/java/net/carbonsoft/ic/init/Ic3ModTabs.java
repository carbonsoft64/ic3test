
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.carbonsoft.ic.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class Ic3ModTabs {
	public static CreativeModeTab TAB_INDUSTRIAL_CRAFT_3;

	public static void load() {
		TAB_INDUSTRIAL_CRAFT_3 = new CreativeModeTab("tabindustrial_craft_3") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Blocks.BLACK_GLAZED_TERRACOTTA);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
