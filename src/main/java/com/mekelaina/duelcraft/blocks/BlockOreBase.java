package com.mekelaina.duelcraft.blocks;

import java.util.Random;

import com.mekelaina.duelcraft.Duelcraft;
import com.mekelaina.duelcraft.init.ModBlocks;
import com.mekelaina.duelcraft.init.ModItems;
import com.mekelaina.duelcraft.util.interfaces.IHasModel;

import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.item.Item.ToolMaterial;

public class BlockOreBase extends BlockOre implements IHasModel
{
	private static String oreName;
	
	public BlockOreBase(String name, String oreName) 
	{
		super();
		
		this.oreName = oreName;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Duelcraft.MAIN_TAB);
		setHarvestLevel("pickaxe", 0);
		setHardness(3f);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return ModItems.KAIBA_CRYSTAL;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		if(fortune > 0)
		{
			int j = random.nextInt(fortune + 2) - 1;
			
			if(j < 0)
			{
				j = 0;
			}
			
			return quantityDropped(random) * (j + 1);
		}
		else
		{
			return quantityDropped(random);
		}
	}
	
	public void initOreDict()
	{
		OreDictionary.registerOre(oreName, this);
	}
	
	@Override
	public void registerModels() 
	{
		Duelcraft.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
}
