package com.mekelaina.duelcraft.container;

import javax.annotation.Nonnull;

import com.mekelaina.duelcraft.card.CardCollection;
import com.mekelaina.duelcraft.items.ItemCard;
import com.mekelaina.duelcraft.items.ItemDeckbox;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerDeckbox extends CommonContainer
{
	//private final ItemDeckbox deckbox;
	private static final int NUM_ROWS = 6;
	private static final int X_START = -46;
	private static final int Y_START = -20;
	private static final int SLOT_WIDTH = 18;
	
	
	public ContainerDeckbox(InventoryPlayer playerInv, IItemHandler deckboxInv, int numSlots)
	{
		//this.deckbox = deckbox;
		super(numSlots);
		int numColumns = numSlots / NUM_ROWS;
		int yOff = 0;
		 for (int y = 0; y < NUM_ROWS; ++y)
	     {
			 
			 if(y > 3)
			 {
				 yOff += 2;
			 }
			 
			 for (int x = 0; x < numColumns; ++x)
	         {
			
				 int  index = x + (y * numColumns);
				 int xPosition = X_START + (x * SLOT_WIDTH);
				 int yPosition = Y_START + (y * SLOT_WIDTH);
				 
				if(y < 4)
				{
					index = x + (y * numColumns);
					 xPosition = X_START + (x * SLOT_WIDTH);
					 yPosition = Y_START + (y * SLOT_WIDTH);
					 this.addSlotToContainer(new SlotItemHandler(deckboxInv, index, xPosition, yPosition)
							 {
						 		@Override
						 		public boolean isItemValid(ItemStack stack)
						 		{
						 			
						 			
						 			if(stack.getItem() instanceof ItemCard && stack.hasTagCompound())
						 			{
						 				NBTTagCompound nbt = stack.getTagCompound();
						 				if(nbt.hasKey("Card_ID"))
						 				{
						 					String id = nbt.getString("Card_ID");
						 					return !CardCollection.CARD_LIST.get(id).isExtraDeck();
						 				}
						 			}
						 			
						 			return false;
						 		}
							 });
				}
				else if(y == 4)
				{
					index = x + (y * numColumns);
					 xPosition = X_START + (x * SLOT_WIDTH);
					 yPosition = Y_START + (y * SLOT_WIDTH) + 2;
					 
					 this.addSlotToContainer(new SlotItemHandler(deckboxInv, index, xPosition, yPosition)
					 {
				 		@Override
				 		public boolean isItemValid(ItemStack stack)
				 		{
				 			
				 			
				 			if(stack.getItem() instanceof ItemCard && stack.hasTagCompound())
				 			{
				 				NBTTagCompound nbt = stack.getTagCompound();
				 				if(nbt.hasKey("Card_ID"))
				 				{
				 					String id = nbt.getString("Card_ID");
				 					return CardCollection.CARD_LIST.get(id).isExtraDeck();
				 				}
				 			}
				 			
				 			return false;
				 		}
					 });
				}
				else if(y == 5)
				{
					index = x + (y * numColumns);
					 xPosition = X_START + (x * SLOT_WIDTH);
					 yPosition = Y_START + (y * SLOT_WIDTH) + 4;
					 
					 this.addSlotToContainer(new SlotItemHandler(deckboxInv, index, xPosition, yPosition)
					 {
				 		@Override
				 		public boolean isItemValid(ItemStack stack)
				 		{
				 			
				 			
				 			if(stack.getItem() instanceof ItemCard && stack.hasTagCompound())
				 			{
				 				NBTTagCompound nbt = stack.getTagCompound();
				 				if(nbt.hasKey("Card_ID"))
				 				{
				 					return true;
				 				}
				 			}
				 			
				 			return false;
				 		}
					 });
				}
					 
				

				 this.addSlotToContainer(new SlotItemHandler(deckboxInv, index, xPosition, yPosition));
				 
				 
	         }
	     }
		 
		 
		 
		 // Player inventory
	        for (int y = 0; y < 3; ++y)
	        {
	            for (int x = 0; x < 9; ++x)
	            {
	                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, (x * 18) + 8, 106 + y * 18));
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
	            this.addSlotToContainer(new Slot(playerInv, x, (x * 18) + 8, 164));
	        }
	    

	}
	
	

	
	

}
