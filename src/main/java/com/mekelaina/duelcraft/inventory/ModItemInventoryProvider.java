package com.mekelaina.duelcraft.inventory;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ModItemInventoryProvider implements ICapabilitySerializable
{

	private final ItemStackHandler inventory;
	
	public ModItemInventoryProvider(int numSlots)
	{
		inventory = new ItemStackHandler(numSlots);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : null;
	}

	@Override
	public NBTBase serializeNBT() 
	{
		return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.getStorage()
				.writeNBT(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, inventory, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) 
	{
		CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.getStorage()
		.readNBT(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, inventory, null, nbt);
	}

	public ItemStackHandler getInventory() 
	{
		return inventory;
	}

	
	
}
