
package net.carbonsoft.ic.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.carbonsoft.ic.init.Ic3ModTabs;

public class AccumulatorItem extends Item {
	public AccumulatorItem() {
		super(new Item.Properties().tab(Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3).durability(10000).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
