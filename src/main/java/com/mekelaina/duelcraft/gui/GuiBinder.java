package com.mekelaina.duelcraft.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.mekelaina.duelcraft.container.ContainerBinder;
import com.mekelaina.duelcraft.util.Reference;
import com.mekelaina.duelcraft.util.handlers.ExpandableItemStackHandler;

import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.ItemStackHandler;

public class GuiBinder extends GuiContainer 
{

	private static ResourceLocation BINDER_GUI_1 = new ResourceLocation(Reference.MOD_ID, "textures/gui/binder_gui1.png");
	private static ResourceLocation BINDER_GUI_2 = new ResourceLocation(Reference.MOD_ID, "textures/gui/binder_gui2.png");
	private static ResourceLocation BINDER_GUI_3 = new ResourceLocation(Reference.MOD_ID, "textures/gui/binder_gui3.png");
	
	private static ModGuiElement MAIN_ON = new ModGuiElement(BINDER_GUI_1, 0, 0, 0, 0, 252, 198);
	private static ModGuiElement MAIN_OFF = new ModGuiElement(BINDER_GUI_2, 0, 0, 0, 0, 252, 198);
	private static ModGuiElement MAIN_FILTER = new ModGuiElement(BINDER_GUI_3, 0, 0, 0, 0, 252, 198);
	private static ModGuiElement BACK_40 = new ModGuiElement(BINDER_GUI_1, 148, 220, 18, 18);
	private static ModGuiElement BACK_60 = new ModGuiElement(BINDER_GUI_1, 166, 220, 18, 18);
	private static ModGuiElement BACK_EXTRA = new ModGuiElement(BINDER_GUI_1, 148, 238, 18, 18);
	private static ModGuiElement BACK_SIDE = new ModGuiElement(BINDER_GUI_1, 166, 238, 18, 18);
	private static ModGuiElement LOCKED_NORMAL = new ModGuiElement(BINDER_GUI_1, 216, 208, 16, 16);
	private static ModGuiElement LOCKED_HOVER = new ModGuiElement(BINDER_GUI_1, 200, 208, 16, 16);
	//private static ModGuiElement LOCKED_CLICK = new ModGuiElement(BINDER_GUI_1, 184, 208, 16, 16);
	//private static ModGuiElement UNLOCKED_CLICK = new ModGuiElement(BINDER_GUI_1, 184, 224, 16, 16);
	private static ModGuiElement UNLOCKED_HOVER = new ModGuiElement(BINDER_GUI_1, 200, 224, 16, 16);
	private static ModGuiElement UNLOCKED_NORMAL = new ModGuiElement(BINDER_GUI_1, 216, 224, 16, 16);
	//private static ModGuiElement FILTER_CLICK = new ModGuiElement(BINDER_GUI_1, 184, 240, 16, 16);
	private static ModGuiElement FILTER_HOVER = new ModGuiElement(BINDER_GUI_1, 200, 240, 16, 16);
	private static ModGuiElement FILTER_NORMAL = new ModGuiElement(BINDER_GUI_1, 216, 240, 16, 16);
	private static ModGuiElement SCROLL_NORMAL = new ModGuiElement(BINDER_GUI_1, 232, 241, 12, 15);
	private static ModGuiElement SCROLL_CLICK = new ModGuiElement(BINDER_GUI_1, 244, 241, 12, 15);
	private static GuiTextField searchBinder;
	
	private static final int FILTER_ID = 0;
	private static final int  LOCK_ID = 1;
	private static final int BINDER_SEARCH = 2;
	private int refX;
	private int refY;
	
	private ItemStackHandler binderInv;
	private ItemStackHandler deckboxInv;
	private Item binder;
	private InventoryPlayer player;
	private ContainerBinder container;
	
	private boolean deckboxInserted;
	private boolean locked;
	private boolean inFilter;
	private int deckboxScrollstate;
	
	
	public GuiBinder(InventoryPlayer player, ItemStackHandler binderInv, Item binder) 
	{
		super(new ContainerBinder(player, binderInv, binderInv.getSlots(), binder));
		this.player = player;
		this.binderInv = binderInv;
		this.binder = binder;
		this.deckboxInserted = false;
		this.locked = false;
		this.inFilter = false;
		this.container = (ContainerBinder) this.inventorySlots;
	}

	@Override
	public void initGui()
	{
		refX = (width - MAIN_ON.getWidth()) / 2;
		refY = (height - MAIN_ON.getHeight()) / 4;
		this.buttonList.add(new CustomButton(FILTER_ID, refX + 118, refY + 18, 
				FILTER_NORMAL.getWidth(), FILTER_NORMAL.getHeight(), FILTER_NORMAL.getImage(),
				FILTER_NORMAL.getTextureX(), FILTER_NORMAL.getTextureY(), FILTER_NORMAL.getTextureX() - 16,
				FILTER_NORMAL.getTextureY()));
		
		searchBinder = new GuiTextField(BINDER_SEARCH, mc.fontRenderer, refX + 156, refY + 5, 70, mc.fontRenderer.FONT_HEIGHT);
		//searchBinder.setEnableBackgroundDrawing(false);
		
		
		searchBinder.setEnabled(true);
		searchBinder.setFocused(true);
		searchBinder.setCanLoseFocus(true);
		
		Keyboard.enableRepeatEvents(true);
		
		this.container.setRefValues(refX, refY);
	}
	
	@Override
	public void onGuiClosed() 
	{
		Keyboard.enableRepeatEvents(false);
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException 
	{
		searchBinder.mouseClicked(mouseX, mouseY, mouseButton);
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		
		
		
		
		
		
	}
	
	@Override
	public void updateScreen() 
	{
		searchBinder.updateCursorCounter();
		
		super.updateScreen();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		GlStateManager.color(1, 1, 1, 1);
		
		if(inFilter)
		{
			mc.getTextureManager().bindTexture(MAIN_FILTER.getImage());
		}
		else
		{
			if(deckboxInserted)
			{
				mc.getTextureManager().bindTexture(MAIN_ON.getImage());
			}
			else
			{
				mc.getTextureManager().bindTexture(MAIN_OFF.getImage());
			}
		}
		
		xSize = MAIN_OFF.getWidth();
		ySize = MAIN_OFF.getHeight();
		int x = refX;
		int y = refY;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
	
		
		
		searchBinder.drawTextBox();
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException 
	{
		if(!searchBinder.textboxKeyTyped(typedChar, keyCode))
		{
			super.keyTyped(typedChar, keyCode);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		/*final int refX = (width - MAIN_ON.getWidth()) / 2;
		final int refY = (height - MAIN_ON.getHeight()) / 4;
		mc.getTextureManager().bindTexture(FILTER_NORMAL.getImage());
		xSize = FILTER_NORMAL.getWidth();
		ySize = FILTER_NORMAL.getHeight();
		int x = refX + FILTER_NORMAL.getX1();
		int y = refY + FILTER_NORMAL.getY1();*/
		
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		//drawTexturedModalRect(FILTER_NORMAL.getX1(), FILTER_NORMAL.getY1(), x, y, FILTER_NORMAL.getWidth(), FILTER_NORMAL.getHeight());
	}
	
	private void updateComponents()
	{
		
	}

}
