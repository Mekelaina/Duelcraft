package com.mekelaina.duelcraft.util;

import com.mekelaina.duelcraft.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class StuffTab extends CreativeTabs
{

	private ItemStack display;
	
	public StuffTab(String label, ItemStack display) 
	{
		super(label);
		this.display = display;
	}
	
	@Override
	public ItemStack getTabIconItem() 
	{
		return display;
	}
	
	@Override
	public boolean hasSearchBar()
	{
		return true;
	}

}
