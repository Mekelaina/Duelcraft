package com.mekelaina.duelcraft.blocks;

import com.mekelaina.duelcraft.Duelcraft;
import com.mekelaina.duelcraft.blocks.tileentities.BlockTileEntity;
import com.mekelaina.duelcraft.blocks.tileentities.TileEntityTest;
import com.mekelaina.duelcraft.util.handlers.ModGuiHandler;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockKaibalium extends BlockTileEntity<TileEntityTest>
{

	public BlockKaibalium(String name, Material materialIn) 
	{
		super(name, materialIn);
		setCreativeTab(Duelcraft.MAIN_TAB);
	}

	@Override
	public Class<TileEntityTest> getTileEntityClass()
	{
		return TileEntityTest.class;
	}

	@Override
	public TileEntityTest createTileEntity(World world, IBlockState state)
	{
		return new TileEntityTest();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote)
		{
			TileEntityTest tile = getTileEntity(worldIn, pos);
			IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing);
			ItemStack heldItem = playerIn.getHeldItem(hand);
			
			if(!playerIn.isSneaking())
			{
				if(heldItem.isEmpty())
				{
					playerIn.setHeldItem(hand, itemHandler.extractItem(0, 64, false));
				}
				else
				{
					playerIn.setHeldItem(hand, itemHandler.insertItem(0, heldItem, false));
				}
				tile.markDirty();
			}
			else
			{
				playerIn.openGui(Duelcraft.instance, ModGuiHandler.TEST, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
		}
		
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		TileEntityTest tile = getTileEntity(worldIn, pos);
		IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		ItemStack stack = itemHandler.getStackInSlot(0);
		
		if(!stack.isEmpty())
		{
			EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
			worldIn.spawnEntity(item);
		}
		
		super.breakBlock(worldIn, pos, state);
		
	}

}
