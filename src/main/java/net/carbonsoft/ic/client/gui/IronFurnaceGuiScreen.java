
package net.carbonsoft.ic.client.gui;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import net.carbonsoft.ic.world.inventory.IronFurnaceGuiMenu;
import net.carbonsoft.ic.procedures.Melt9Procedure;
import net.carbonsoft.ic.procedures.Melt8Procedure;
import net.carbonsoft.ic.procedures.Melt7Procedure;
import net.carbonsoft.ic.procedures.Melt6Procedure;
import net.carbonsoft.ic.procedures.Melt5Procedure;
import net.carbonsoft.ic.procedures.Melt4Procedure;
import net.carbonsoft.ic.procedures.Melt3Procedure;
import net.carbonsoft.ic.procedures.Melt2Procedure;
import net.carbonsoft.ic.procedures.Melt22Procedure;
import net.carbonsoft.ic.procedures.Melt21Procedure;
import net.carbonsoft.ic.procedures.Melt20Procedure;
import net.carbonsoft.ic.procedures.Melt1Procedure;
import net.carbonsoft.ic.procedures.Melt19Procedure;
import net.carbonsoft.ic.procedures.Melt18Procedure;
import net.carbonsoft.ic.procedures.Melt17Procedure;
import net.carbonsoft.ic.procedures.Melt16Procedure;
import net.carbonsoft.ic.procedures.Melt15Procedure;
import net.carbonsoft.ic.procedures.Melt14Procedure;
import net.carbonsoft.ic.procedures.Melt13Procedure;
import net.carbonsoft.ic.procedures.Melt12Procedure;
import net.carbonsoft.ic.procedures.Melt11Procedure;
import net.carbonsoft.ic.procedures.Melt10Procedure;
import net.carbonsoft.ic.procedures.Fuel9Procedure;
import net.carbonsoft.ic.procedures.Fuel8Procedure;
import net.carbonsoft.ic.procedures.Fuel6Procedure;
import net.carbonsoft.ic.procedures.Fuel5Procedure;
import net.carbonsoft.ic.procedures.Fuel4Procedure;
import net.carbonsoft.ic.procedures.Fuel3Procedure;
import net.carbonsoft.ic.procedures.Fuel2Procedure;
import net.carbonsoft.ic.procedures.Fuel1Procedure;
import net.carbonsoft.ic.procedures.Fuel13Procedure;
import net.carbonsoft.ic.procedures.Fuel12Procedure;
import net.carbonsoft.ic.procedures.Fuel10Procedure;
import net.carbonsoft.ic.procedures.Energy7Procedure;
import net.carbonsoft.ic.procedures.Energy11Procedure;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class IronFurnaceGuiScreen extends AbstractContainerScreen<IronFurnaceGuiMenu> {
	private final static HashMap<String, Object> guistate = IronFurnaceGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public IronFurnaceGuiScreen(IronFurnaceGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ic3:textures/iron_furnace_gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire0.png"));
		this.blit(ms, this.leftPos + 44, this.topPos + 36, 0, 0, 13, 14, 13, 14);

		if (Fuel1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire1.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 49, 0, 0, 13, 2, 13, 2);
		}
		if (Fuel2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire2.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 48, 0, 0, 13, 3, 13, 3);
		}
		if (Fuel3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire3.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 47, 0, 0, 13, 4, 13, 4);
		}
		if (Fuel4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire4.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 46, 0, 0, 13, 5, 13, 5);
		}
		if (Fuel5Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire5.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 45, 0, 0, 13, 6, 13, 6);
		}
		if (Fuel6Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire6.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 44, 0, 0, 13, 7, 13, 7);
		}
		if (Energy7Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire7.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 43, 0, 0, 13, 8, 13, 8);
		}
		if (Fuel8Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire8.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 42, 0, 0, 13, 9, 13, 9);
		}
		if (Fuel9Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire9.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 41, 0, 0, 13, 10, 13, 10);
		}
		if (Fuel10Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire10.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 40, 0, 0, 13, 11, 13, 11);
		}
		if (Energy11Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire11.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 39, 0, 0, 13, 12, 13, 12);
		}
		if (Fuel12Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire12.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 38, 0, 0, 13, 13, 13, 13);
		}
		if (Fuel13Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/fire13.png"));
			this.blit(ms, this.leftPos + 44, this.topPos + 37, 0, 0, 13, 14, 13, 14);
		}

		RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt0.png"));
		this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 22, 15, 22, 15);

		if (Melt1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt1.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 1, 15, 1, 15);
		}
		if (Melt2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt2.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 2, 15, 2, 15);
		}
		if (Melt3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt3.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 3, 15, 3, 15);
		}
		if (Melt4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt4.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 4, 15, 4, 15);
		}
		if (Melt5Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt5.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 5, 15, 5, 15);
		}
		if (Melt6Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt6.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 6, 15, 6, 15);
		}
		if (Melt7Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt7.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 7, 15, 7, 15);
		}
		if (Melt8Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt8.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 8, 15, 8, 15);
		}
		if (Melt9Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt9.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 9, 15, 9, 15);
		}
		if (Melt10Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt10.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 10, 15, 10, 15);
		}
		if (Melt11Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt11.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 11, 15, 11, 15);
		}
		if (Melt12Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt12.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 12, 15, 12, 15);
		}
		if (Melt13Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt13.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 13, 15, 13, 15);
		}
		if (Melt14Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt14.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 14, 15, 14, 15);
		}
		if (Melt15Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt15.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 15, 15, 15, 15);
		}
		if (Melt16Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt16.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 16, 15, 16, 15);
		}
		if (Melt17Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt17.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 17, 15, 17, 15);
		}
		if (Melt18Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt18.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 18, 15, 18, 15);
		}
		if (Melt19Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt19.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 19, 15, 19, 15);
		}
		if (Melt20Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt20.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 20, 15, 20, 15);
		}
		if (Melt21Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt21.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 21, 15, 21, 15);
		}
		if (Melt22Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("ic3:textures/melt22.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 34, 0, 0, 22, 15, 22, 15);
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
		this.font.draw(poseStack, "Fuel: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "fuel")) + "", 69, 16, -12829636);
		this.font.draw(poseStack, "Process: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "melting")) + "%", 69, 61, -12829636);
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
