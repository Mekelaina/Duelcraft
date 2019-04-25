package com.mekelaina.duelcraft.util.handlers;

import com.mekelaina.duelcraft.blocks.tileentities.TileEntityTest;
import com.mekelaina.duelcraft.container.ContainerBinder;
import com.mekelaina.duelcraft.container.ContainerDeckbox;
import com.mekelaina.duelcraft.container.ContainerTest;
import com.mekelaina.duelcraft.gui.GuiBinder;
import com.mekelaina.duelcraft.gui.GuiDeckbox;
import com.mekelaina.duelcraft.gui.GuiTest;
import com.mekelaina.duelcraft.items.ItemCardBinder;
import com.mekelaina.duelcraft.items.ItemDeckbox;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ModGuiHandler implements IGuiHandler 
{
	
	public static final int TEST = 0;
	public static final int DECKBOX = 1;
	public static final int BINDER = 2;

	@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(pos);
		ItemStack heldItemStack = player.inventory.getCurrentItem();
		
		switch(ID)
		{
			case TEST:
			{
				return new ContainerTest(player.inventory, (TileEntityTest)world.getTileEntity(new BlockPos(x,y,z)));
			}
			case DECKBOX:
			{
				if(heldItemStack != ItemStack.EMPTY && heldItemStack.getItem() instanceof ItemDeckbox)
				{
					IItemHandler deckboxInv = heldItemStack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
					
					if(deckboxInv != null)
					{
						return new ContainerDeckbox(player.inventory, deckboxInv, deckboxInv.getSlots());
					}
				}
			}
			case BINDER:
			{
				if(heldItemStack != ItemStack.EMPTY && heldItemStack.getItem() instanceof ItemCardBinder)
				{
					IItemHandler binderInv = heldItemStack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
					
					if(binderInv != null)
					{
						return new ContainerBinder(player.inventory, binderInv, binderInv.getSlots(), heldItemStack.getItem());
					}
				}
			}
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(pos);
		ItemStack heldItemStack = player.inventory.getCurrentItem();
		
		switch (ID)
		{
			case TEST:
				return new GuiTest(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
			case DECKBOX:
			{
				if(heldItemStack != ItemStack.EMPTY && heldItemStack.getItem() instanceof ItemDeckbox)
				{
					ItemStackHandler deckboxInv = (ItemStackHandler)heldItemStack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
					
					if(deckboxInv != null)
					{
						return new GuiDeckbox(player.inventory, deckboxInv, heldItemStack);
					}
				}
			}
			case BINDER:
			{
				if(heldItemStack != ItemStack.EMPTY && heldItemStack.getItem() instanceof ItemCardBinder)
				{
					ItemStackHandler binderInv = (ItemStackHandler) heldItemStack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
					
					if(binderInv != null)
					{
						return new GuiBinder(player.inventory, binderInv, heldItemStack.getItem());
					}
				}
			}

		default:
			return null;
		}
	}

}
