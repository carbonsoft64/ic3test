
package net.carbonsoft.ic.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.carbonsoft.ic.procedures.TreetapPrcdrProcedure;
import net.carbonsoft.ic.init.Ic3ModTabs;

public class TreetapItem extends Item {
	public TreetapItem() {
		super(new Item.Properties().tab(Ic3ModTabs.TAB_INDUSTRIAL_CRAFT_3).durability(15).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		TreetapPrcdrProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ(), context.getItemInHand());
		return retval;
	}
}
