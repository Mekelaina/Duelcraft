package com.mekelaina.duelcraft.container;

import com.mekelaina.duelcraft.blocks.tileentities.TileEntityTest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerTest extends Container
{
	
	public ContainerTest(InventoryPlayer playerInv, final TileEntityTest test) 
	{
		IItemHandler inventory = test.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		addSlotToContainer(new SlotItemHandler(inventory, 0, 80, 35)
		{
			@Override
			public void onSlotChanged()
			{
				test.markDirty();
			}
		});
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(int k = 0; k < 9; k++)
		{
			addSlotToContainer(new Slot(playerInv, k, 8 + k * 18, 142));
		}
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slot = inventorySlots.get(index);
		
		if(slot != null && slot.getHasStack())
		{
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();
			int containerSlots = inventorySlots.size() - playerIn.inventory.mainInventory.size();
			
			if(index < containerSlots)
			{
				if(!this.mergeItemStack(itemStack1, containerSlots, inventorySlots.size(), true))
				{
					return ItemStack.EMPTY;
				}
			}
			else if(!this.mergeItemStack(itemStack1, 0, containerSlots, false))
			{
				return ItemStack.EMPTY;
			}
			
			if(itemStack1.getCount() == 0)
			{
				slot.putStack(ItemStack.EMPTY);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if(itemStack1.getCount() == itemStack.getCount())
			{
				return ItemStack.EMPTY;
			}
			
			slot.onTake(playerIn, itemStack1);
		}
		
		return itemStack;
	}

}
