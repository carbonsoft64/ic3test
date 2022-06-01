
package net.carbonsoft.ic.client.gui;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import net.carbonsoft.ic.world.inventory.GeneratorGuiMenu;
import net.carbonsoft.ic.procedures.Fuel9Procedure;
import net.carbonsoft.ic.procedures.Fuel8Procedure;
import net.carbonsoft.ic.procedures.Fuel7Procedure;
import net.carbonsoft.ic.procedures.Fuel6Procedure;
import net.carbonsoft.ic.procedures.Fuel5Procedure;
import net.carbonsoft.ic.procedures.Fuel4Procedure;
import net.carbonsoft.ic.procedures.Fuel3Procedure;
import net.carbonsoft.ic.procedures.Fuel2Procedure;
import net.carbonsoft.ic.procedures.Fuel1Procedure;
import net.carbonsoft.ic.procedures.Fuel13Procedure;
import net.carbonsoft.ic.procedures.Fuel12Procedure;
import net.carbonsoft.ic.procedures.Fuel11Procedure;
import net.carbonsoft.ic.procedures.Fuel10Procedure;
import net.carbonsoft.ic.procedures.Energy9Procedure;
import net.carbonsoft.ic.procedures.Energy8Procedure;
import net.carbonsoft.ic.procedures.Energy7Procedure;
import net.carbonsoft.ic.procedures.Energy6Procedure;
import net.carbonsoft.ic.procedures.Energy5Procedure;
import net.carbonsoft.ic.procedures.Energy4Procedure;
import net.carbonsoft.ic.procedures.Energy3Procedure;
import net.carbonsoft.ic.procedures.Energy2Procedure;
import net.carbonsoft.ic.procedures.Energy24Procedure;
import net.carbonsoft.ic.procedures.Energy23Procedure;
import net.carbonsoft.ic.procedures.Energy22Procedure;
import net.carbonsoft.ic.procedures.Energy21Procedure;
import net.carbonsoft.ic.procedures.Energy20Procedure;
import net.carbonsoft.ic.procedures.Energy1Procedure;
import net.carbonsoft.ic.procedures.Energy19Procedure;
import net.carbonsoft.ic.procedures.Energy18Procedure;
import net.carbonsoft.ic.procedures.Energy17Procedure;
import net.carbonsoft.ic.procedures.Energy16Procedure;
import net.carbonsoft.ic.procedures.Energy15Procedure;
import net.carbonsoft.ic.procedures.Energy14Procedure;
import net.carbonsoft.ic.procedures.Energy13Procedure;
import net.carbonsoft.ic.procedures.Energy12Procedure;
import net.carbonsoft.ic.procedures.Energy11Procedure;
import net.carbonsoft.ic.procedures.Energy10Procedure;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class GeneratorGuiScreen extends AbstractContainerScreen<GeneratorGuiMenu> {
	private final static HashMap<String, Object> guistate = GeneratorGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public GeneratorGuiScreen(GeneratorGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ic3:textures/generator_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy0.png"));
		this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 32, 17, 32, 17);

		if (Energy1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy1.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 5, 17, 5, 17);
		}
		if (Energy2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy2.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 6, 17, 6, 17);
		}
		if (Energy3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy3.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 7, 17, 7, 17);
		}
		if (Energy4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy4.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 8, 17, 8, 17);
		}
		if (Energy5Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy5.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 9, 17, 9, 17);
		}
		if (Energy6Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy6.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 10, 17, 10, 17);
		}
		if (Energy7Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy7.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 11, 17, 11, 17);
		}
		if (Energy8Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy8.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 12, 17, 12, 17);
		}
		if (Energy9Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy9.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 13, 17, 13, 17);
		}
		if (Energy10Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy10.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 14, 17, 14, 17);
		}
		if (Energy11Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy11.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 15, 17, 15, 17);
		}
		if (Energy12Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy12.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 16, 17, 16, 17);
		}
		if (Energy13Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy13.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 17, 17, 17, 17);
		}
		if (Energy14Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy14.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 18, 17, 18, 17);
		}
		if (Energy15Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy15.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 19, 17, 19, 17);
		}
		if (Energy16Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy16.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 20, 17, 20, 17);
		}
		if (Energy17Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy17.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 21, 17, 21, 17);
		}
		if (Energy18Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy18.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 22, 17, 22, 17);
		}
		if (Energy19Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy19.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 23, 17, 23, 17);
		}
		if (Energy20Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy20.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 24, 17, 24, 17);
		}
		if (Energy21Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy21.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 25, 17, 25, 17);
		}
		if (Energy22Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy22.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 26, 17, 26, 17);
		}
		if (Energy23Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy23.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 27, 17, 27, 17);
		}
		if (Energy24Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/energy24.png"));
			this.blit(ms, this.leftPos + 105, this.topPos + 34, 0, 0, 28, 17, 28, 17);
		}

		RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire0.png"));
		this.blit(ms, this.leftPos + 61, this.topPos + 36, 0, 0, 13, 14, 13, 14);

		if (Fuel1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire1.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 49, 0, 0, 13, 2, 13, 2);
		}
		if (Fuel2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire2.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 49, 0, 0, 13, 3, 13, 3);
		}
		if (Fuel3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire3.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 48, 0, 0, 13, 4, 13, 4);
		}
		if (Fuel4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire4.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 47, 0, 0, 13, 5, 13, 5);
		}
		if (Fuel5Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire5.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 46, 0, 0, 13, 6, 13, 6);
		}
		if (Fuel6Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire6.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 45, 0, 0, 13, 7, 13, 7);
		}
		if (Fuel7Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire7.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 44, 0, 0, 13, 8, 13, 8);
		}
		if (Fuel8Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire8.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 43, 0, 0, 13, 9, 13, 9);
		}
		if (Fuel9Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire9.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 42, 0, 0, 13, 10, 13, 10);
		}
		if (Fuel10Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire10.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 41, 0, 0, 13, 11, 13, 11);
		}
		if (Fuel11Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire11.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 40, 0, 0, 13, 12, 13, 12);
		}
		if (Fuel12Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire12.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 39, 0, 0, 13, 13, 13, 13);
		}
		if (Fuel13Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire13.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 38, 0, 0, 13, 14, 13, 14);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Energy: " + (new Object() {
			public int getEnergyStored(BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) + "/4000", 6, 7, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
	}
}
