package com.mekelaina.duelcraft.blocks.rarityalter;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.mekelaina.duelcraft.Duelcraft;
import com.mekelaina.duelcraft.blocks.tileentities.BlockTileEntity;
import com.mekelaina.duelcraft.blocks.tileentities.TileEntityPillar;
import com.mekelaina.duelcraft.util.interfaces.IHasModel;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockRarityPillar extends BlockTileEntity<TileEntityPillar> implements IHasModel
{
	
	private static final AxisAlignedBB BASE = new AxisAlignedBB(0.109, 0, 0.109, 0.891, 0.312, 0.891);
	private static final AxisAlignedBB WBASELIP = new AxisAlignedBB(0.062, 0, 0.109, 0.109, 0.047, 0.891);
	private static final AxisAlignedBB EBASELIP = new AxisAlignedBB(0.891, 0, 0.109, 0.938, 0.047, 0.891);
	private static final AxisAlignedBB SBASELIP = new AxisAlignedBB(0.109, 0, 0.891, 0.891, 0.047, 0.938);
	private static final AxisAlignedBB NBASELIP = new AxisAlignedBB(0.109, 0, 0.062, 0.891, 0.047, 0.109);
	private static final AxisAlignedBB MID = new AxisAlignedBB(0.228, 0.312, 0.236, 0.759, 0.625, 0.767);
	// Skipped 'SpikeShaftBase', as it has roatation
	// Skipped 'SpikeLeg', as it has roatation
	// Skipped 'SpikeShaftTop', as it has roatation
	// Skipped 'SpikeLeg', as it has roatation
	// Skipped 'SpikeShaftTop', as it has roatation
	// Skipped 'SpikeShaftBase', as it has roatation
	// Skipped 'SpikeShaftBase', as it has roatation
	// Skipped 'SpikeLeg', as it has roatation
	// Skipped 'SpikeShaftTop', as it has roatation
	// Skipped 'SpikeLeg', as it has roatation
	// Skipped 'SpikeShaftTop', as it has roatation
	// Skipped 'SpikeShaftBase', as it has roatation
	private static final AxisAlignedBB TOP = new AxisAlignedBB(0.336, 0.625, 0.345, 0.617, 0.875, 0.627);

	public BlockRarityPillar(String name, Material materialIn)
	{
		super(name, materialIn);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 1);
		setHardness(2f);
	}
	
	/**
	* AxisAlignedBBs and methods getBoundingBox, collisionRayTrace, and collisionRayTrace generated using MrCrayfish's Model Creator <a href="https://mrcrayfish.com/tools?id=mc">https://mrcrayfish.com/tools?id=mc</a>
	*/
	private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(BASE, WBASELIP, EBASELIP, SBASELIP, NBASELIP, MID, TOP);
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.062, 0, 0.062, 0.938, 0.875, 0.938);

	@Override
	public void registerModels() 
	{
		Duelcraft.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return Item.getItemFromBlock(this);
	}
	    
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
	    return BOUNDING_BOX;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState)
	{
	    entityBox = entityBox.offset(-pos.getX(), -pos.getY(), -pos.getZ());
	    for (AxisAlignedBB box : COLLISION_BOXES)
	    {
	        if (entityBox.intersects(box))
	            collidingBoxes.add(box.offset(pos));
	    }
	}

	@Override
	@Nullable
	public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end)
	{
	    double distanceSq;
	    double distanceSqShortest = Double.POSITIVE_INFINITY;
	    RayTraceResult resultClosest = null;
	    RayTraceResult result;
	    start = start.subtract(pos.getX(), pos.getY(), pos.getZ());
	    end = end.subtract(pos.getX(), pos.getY(), pos.getZ());
	    for (AxisAlignedBB box : COLLISION_BOXES)
	    {
	        result = box.calculateIntercept(start, end);
	        if (result == null)
	            continue;

	        distanceSq = result.hitVec.squareDistanceTo(start);
	        if (distanceSq < distanceSqShortest)
	        {
	            distanceSqShortest = distanceSq;
	            resultClosest = result;
	        }
	    }
	    return resultClosest == null ? null : new RayTraceResult(RayTraceResult.Type.BLOCK, resultClosest.hitVec.addVector(pos.getX(), pos.getY(), pos.getZ()), resultClosest.sideHit, pos);
	}
	
	
	@Override
	public Class<TileEntityPillar> getTileEntityClass()
	{
		return TileEntityPillar.class;
	}
	
	@Override
	public TileEntityPillar createTileEntity(World world, IBlockState state)
	{
		return new TileEntityPillar();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.isRemote)
		{
			TileEntityPillar tile = getTileEntity(worldIn, pos);
			IItemHandler itemHandeler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing);
			
			if(!facing.equals(EnumFacing.DOWN))
			{
				if(!playerIn.isSneaking() )
				{
					ItemStack heldItem = playerIn.getHeldItem(hand);
					if(heldItem.isEmpty())
					{
						playerIn.setHeldItem(hand, itemHandeler.extractItem(0, 64, false));
					}
					else
					{
						playerIn.setHeldItem(hand, itemHandeler.insertItem(0, heldItem, false));
					}
					tile.markDirty();
				}
				else
				{
					ItemStack stack = itemHandeler.getStackInSlot(0);
					if(!stack.isEmpty())
					{
						String localized = Duelcraft.proxy.localize(stack.getUnlocalizedName() + ".name");
						playerIn.sendMessage(new TextComponentString(stack.getCount() + "x " + localized));
					}
					else
					{
						playerIn.sendMessage(new TextComponentString("Empty"));
					}
				}
			}
		}
		return true;
		
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		TileEntityPillar tile = getTileEntity(worldIn, pos);
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
