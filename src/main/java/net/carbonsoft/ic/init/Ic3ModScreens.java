
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.carbonsoft.ic.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.carbonsoft.ic.client.gui.IronFurnaceGuiScreen;
import net.carbonsoft.ic.client.gui.GeneratorGuiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Ic3ModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(Ic3ModMenus.IRON_FURNACE_GUI, IronFurnaceGuiScreen::new);
			MenuScreens.register(Ic3ModMenus.GENERATOR_GUI, GeneratorGuiScreen::new);
		});
	}
}
