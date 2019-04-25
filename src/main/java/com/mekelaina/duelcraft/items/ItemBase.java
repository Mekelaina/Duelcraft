package com.mekelaina.duelcraft.items;

import com.mekelaina.duelcraft.Duelcraft;
import com.mekelaina.duelcraft.init.ModItems;
import com.mekelaina.duelcraft.util.interfaces.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Duelcraft.MAIN_TAB);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Duelcraft.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
