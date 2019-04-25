
package com.mekelaina.duelcraft.blocks;

import com.mekelaina.duelcraft.Duelcraft;
import com.mekelaina.duelcraft.init.ModBlocks;
import com.mekelaina.duelcraft.init.ModItems;
import com.mekelaina.duelcraft.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{

	public BlockBase(String name, Material materialIn) 
	{
		super(materialIn);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Duelcraft.MAIN_TAB);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() 
	{
		Duelcraft.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}

}
