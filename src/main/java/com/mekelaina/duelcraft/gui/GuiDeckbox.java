package com.mekelaina.duelcraft.gui;

import com.mekelaina.duelcraft.container.ContainerDeckbox;
import com.mekelaina.duelcraft.init.ModItems;
import com.mekelaina.duelcraft.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.ItemStackHandler;

public class GuiDeckbox extends GuiContainer
{
	private InventoryPlayer playerInv;
	private final ItemStackHandler deckboxInv;
	//private static final ResourceLocation BG_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/deckbox.png");
	private static final ResourceLocation BG_1 = new ResourceLocation(Reference.MOD_ID, "textures/gui/deckbox_gui1.png");
	private static final ResourceLocation BG_2 = new ResourceLocation(Reference.MOD_ID, "textures/gui/deckbox_gui2.png");
	
	private ItemStack deckbox;
	private int x1, x2, y1, y2, xTotal;
	
	public GuiDeckbox(InventoryPlayer playerInv, ItemStackHandler deckboxInv, ItemStack deckbox) 
	{
		super(new ContainerDeckbox(playerInv, deckboxInv, deckboxInv.getSlots()));
		x1 = 242;
		y1 = 225;
		x2 = 44;
		y2 = 225;
		xTotal = 286;
		/*this.xSize = 256;
		this.ySize = 214;*/
		this.playerInv = playerInv;
		this.deckboxInv = deckboxInv;
		this.deckbox = deckbox;
		
	}


	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(BG_1);
		xSize = x1;
		ySize = y1;
		int x = (width - xTotal) / 2;
		int y = (height - ySize) / 4;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
		mc.getTextureManager().bindTexture(BG_2);
		xSize = x2;
		ySize = y2;
		x += x1;
		
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		ySize = y1;
		xSize = x1;
		String name = I18n.format(deckbox.getDisplayName());
		fontRenderer.drawString(name, xTotal / 4 - fontRenderer.getStringWidth(name) / 4 , (int)(height - 1.5*ySize)/5 - 15, 0x404040);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), (int)(width - 1.5*xTotal) / 7 - 55, ySize - 130, 0x404040);
	}
}
