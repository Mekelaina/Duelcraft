package com.mekelaina.duelcraft.container;

import com.mekelaina.duelcraft.items.ItemCard;
import com.mekelaina.duelcraft.items.ItemCardBinder;
import com.mekelaina.duelcraft.items.ItemDeckbox;
import com.mekelaina.duelcraft.util.Reference;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBinder extends CommonContainer
{
	
	private int refX;
	private int refY;
	private InventoryPlayer playerInv;
	IItemHandler binderInv;
	
	//private GuiBinder GuiInstance;
	
	private static final int SLOT_WIDTH = 18;
	private static final int XSTART_DECKBOX = 140;
	private static final int YSTART_DECKBOX = 32;
	private static final int XSTART_BINDER = XSTART_DECKBOX + 112;
	private static final int YSTART_BINDER = YSTART_DECKBOX;
	private static final int XSTART_MID = XSTART_DECKBOX + 42;
	private static final int YSTART_MID = YSTART_DECKBOX + 13;
	//private static final int numRows = 5;
	
	private ItemCardBinder binderItem;
	
	public ContainerBinder(InventoryPlayer playerInv, IItemHandler binderInv, int numSlots, Item ItemIn) 
	{
		super(numSlots);
		this.playerInv = playerInv;
		this.binderInv = binderInv;
		this.binderItem = (ItemCardBinder) ItemIn;
		
		IItemHandler deckboxInv = new ItemStackHandler(90);
		
	//	this.getSlotFromInventory(inv, slotIn)
		
		int numRows = 5;
		int numColumns = 5;
		
		/*for(int y = 0; y < numRows; ++y)
		{
			for(int x = 0; x < numColumns; ++x)
			{
				int index = x + (y * numColumns);
				int xPos = XSTART_BINDER + (x * SLOT_WIDTH);
				int yPos = YSTART_BINDER + (y * SLOT_WIDTH);
				
				this.addSlotToContainer(new SlotItemHandler(binderInv, index, xPos, yPos)
				{
					@Override
					public boolean isItemValid(ItemStack stack)
					{
						if(stack.getItem() instanceof ItemCard && stack.hasTagCompound())
						{
							return true;
						}
						return false;
					}
				});
			}
		}*/
		
		/*this.addSlotToContainer(new SlotItemHandler(binderInv, 26, 117, 41)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				if(stack.getItem() instanceof ItemDeckbox)
				{
					return true;
				}
				return false;
			}
			
			@Override
			public int getSlotStackLimit() 
			{
				return 1;
			}
		});*/
		
		
    
		/*if(binderItem.hasDeckbox())
		{*/
			/*for(int y = 0; y < numRows; ++y)
			{
				for(int x = 0; x < numColumns; ++x)
				{
					int index = x + (y * numColumns);
					int xPos = XSTART_DECKBOX + (x * SLOT_WIDTH);
					int yPos = YSTART_DECKBOX + (y * SLOT_WIDTH);
					
					this.addSlotToContainer(new SlotItemHandler(deckboxInv, index, xPos, yPos)
					{
						@Override
						public boolean isItemValid(ItemStack stack)
						{
							if(stack.getItem() instanceof ItemCard && stack.hasTagCompound())
							{
								return true;
							}
							return false;
						}
						
						@Override
						public boolean isEnabled()
						{
							if(binderItem.hasDeckbox())
							{
								return true;
							}
							return false;
						}
					});
				}
			}*/
		//}
			
			 for (int y = 0; y < 3; ++y)
		        {
		            for (int x = 0; x < 9; ++x)
		            {
		                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, (x * 18) + 128, 106 + y * 18));
		                // x + y * 9 + 9
		                // 0 + 0 * 9 + 9 = 9
		                // 1 + 0 * 9 + 9 = 10
		                // 2 + 0 * 9 + 9 = 11
		                // 3 + 0 * 9 + 9 = 12
		                // 4 + 0 * 9 + 9 = 13
		                // 5 + 0 * 9 + 9 = 14
		                // 6 + 0 * 9 + 9 = 15
		                // 7 + 0 * 9 + 9 = 16
		                // 8 + 0 * 9 + 9 = 17
		                // 0 + 1 * 9 + 9 = 18
		                // 1 + 1 * 9 + 9 = 19
		                // 2 + 1 * 9 + 9 = 20
		                // 3 + 1 * 9 + 9 = 21
		                // 4 + 1 * 9 + 9 = 22
		                // 5 + 1 * 9 + 9 = 23
		                // 6 + 1 * 9 + 9 = 24
		                // 7 + 1 * 9 + 9 = 25
		                // 8 + 1 * 9 + 9 = 26
		                // ...
		            }
		        }

		        // Hot bar
		        for (int x = 0; x < 9; ++x)
		        {
		            this.addSlotToContainer(new Slot(playerInv, x, (x * 18) + 128, 164));
		        }
		
		
		        System.out.println("Debug: Slots = " + this.inventorySlots.size());
		        
		        
	}
	

	
	public void setRefValues(int x, int y)
	{
		refX = x;
		refY = y;
	}
	
	public void setDeckboxStatus(ItemStack stack)
	{
		
	}
	
	
	
	
}
