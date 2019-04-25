package com.mekelaina.duelcraft.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.mekelaina.duelcraft.Duelcraft;
import com.mekelaina.duelcraft.util.interfaces.IHasModel;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCardCase extends BlockBase implements IHasModel 
{

	private static final AxisAlignedBB ELEMENT = new AxisAlignedBB(0, 0, 0, 1, 0.688, 1);
	private static final AxisAlignedBB STAND1 = new AxisAlignedBB(0.094, 0.688, 0.094, 0.281, 0.831, 0.156);
	// Skipped 'Card', as it has roatation
	private static final AxisAlignedBB STAND2 = new AxisAlignedBB(0.406, 0.688, 0.094, 0.594, 0.831, 0.156);
	// Skipped 'Card', as it has roatation
	private static final AxisAlignedBB STAND3 = new AxisAlignedBB(0.719, 0.688, 0.094, 0.906, 0.831, 0.156);
	// Skipped 'Card', as it has roatation
	private static final AxisAlignedBB STAND4 = new AxisAlignedBB(0.719, 0.688, 0.531, 0.906, 0.831, 0.594);
	// Skipped 'Card', as it has roatation
	private static final AxisAlignedBB STAND5 = new AxisAlignedBB(0.406, 0.688, 0.531, 0.594, 0.831, 0.594);
	// Skipped 'Card', as it has roatation
	private static final AxisAlignedBB STAND6 = new AxisAlignedBB(0.094, 0.688, 0.531, 0.281, 0.831, 0.594);
	// Skipped 'Card', as it has roatation
	private static final AxisAlignedBB WEST = new AxisAlignedBB(0, 0.688, 0.062, 0.062, 1.125, 0.938);
	private static final AxisAlignedBB EAST = new AxisAlignedBB(0.938, 0.688, 0.062, 1, 1.125, 0.938);
	private static final AxisAlignedBB SOUTH = new AxisAlignedBB(0.062, 0.688, 0.938, 0.938, 1.125, 1);
	private static final AxisAlignedBB NORTH = new AxisAlignedBB(0.062, 0.688, 0, 0.938, 1.125, 0.062);
	private static final AxisAlignedBB TOP = new AxisAlignedBB(0.062, 1.125, 0.062, 0.938, 1.188, 0.938);
	private static final AxisAlignedBB SW = new AxisAlignedBB(0, 0.688, 0.938, 0.062, 1.188, 1);
	private static final AxisAlignedBB NW = new AxisAlignedBB(0, 0.688, 0, 0.062, 1.188, 0.062);
	private static final AxisAlignedBB NE = new AxisAlignedBB(0.938, 0.688, 0, 1, 1.188, 0.062);
	private static final AxisAlignedBB SE = new AxisAlignedBB(0.938, 0.688, 0.938, 1, 1.188, 1);
	private static final AxisAlignedBB TW = new AxisAlignedBB(0, 1.125, 0.062, 0.062, 1.188, 0.938);
	private static final AxisAlignedBB TE = new AxisAlignedBB(0.938, 1.125, 0.062, 1, 1.188, 0.938);
	private static final AxisAlignedBB TN = new AxisAlignedBB(0.062, 1.125, 0, 0.938, 1.188, 0.062);
	private static final AxisAlignedBB TS = new AxisAlignedBB(0.062, 1.125, 0.938, 0.938, 1.188, 1);
	/**
	* AxisAlignedBBs and methods getBoundingBox, collisionRayTrace, and collisionRayTrace generated using MrCrayfish's Model Creator <a href="https://mrcrayfish.com/tools?id=mc">https://mrcrayfish.com/tools?id=mc</a>
	*/
	private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(ELEMENT, STAND1, STAND2, STAND3, STAND4, STAND5, STAND6, WEST, EAST, SOUTH, NORTH, TOP, SW, NW, NE, SE, TW, TE, TN, TS);
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 1, 1, 1);
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final BlockRenderLayer RENDER_LAYER = BlockRenderLayer.TRANSLUCENT;
	
	public BlockCardCase(String name, Material materialIn) 
	{
		super(name, materialIn);
	}

	@Override
	public void registerModels() 
	{
		Duelcraft.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(worldIn, pos, state);
    }

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING/*, GLASS_TYPES*/});
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
	    return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override 
	public IBlockState getStateFromMeta(int meta)
	{ 
		EnumFacing enumfacing = EnumFacing.getFront(meta); 
		
		if (enumfacing.getAxis() == EnumFacing.Axis.Y) 
		{
			enumfacing = EnumFacing.NORTH;
		}
		
		return this.getDefaultState().withProperty(FACING, enumfacing);
	}
	

	    /**
	     * Convert the BlockState into the correct metadata value
	     */
	    public int getMetaFromState(IBlockState state)
	    {
	        return ((EnumFacing)state.getValue(FACING)).getIndex();
	    }
	
    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
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

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.TRANSLUCENT;
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
	}


