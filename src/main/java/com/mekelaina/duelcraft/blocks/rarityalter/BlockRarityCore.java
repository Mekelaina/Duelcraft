package com.mekelaina.duelcraft.blocks.rarityalter;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.mekelaina.duelcraft.Duelcraft;
import com.mekelaina.duelcraft.blocks.BlockBase;
import com.mekelaina.duelcraft.util.interfaces.IHasModel;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRarityCore extends BlockBase implements IHasModel
{

	private static final AxisAlignedBB COREC = new AxisAlignedBB(0.469, 0.5, 0.469, 0.531, 0.562, 0.531);
	private static final AxisAlignedBB COREB = new AxisAlignedBB(0.469, 0.438, 0.469, 0.531, 0.5, 0.531);
	private static final AxisAlignedBB CORET = new AxisAlignedBB(0.469, 0.562, 0.469, 0.531, 0.625, 0.531);
	private static final AxisAlignedBB COREN = new AxisAlignedBB(0.469, 0.5, 0.406, 0.531, 0.562, 0.469);
	private static final AxisAlignedBB COREW = new AxisAlignedBB(0.406, 0.5, 0.469, 0.469, 0.562, 0.531);
	private static final AxisAlignedBB CORES = new AxisAlignedBB(0.469, 0.5, 0.531, 0.531, 0.562, 0.594);
	private static final AxisAlignedBB COREE = new AxisAlignedBB(0.531, 0.5, 0.469, 0.594, 0.562, 0.531);
	// Skipped 'NE', as it has roatation
	// Skipped 'SW', as it has roatation
	// Skipped 'NW', as it has roatation
	// Skipped 'SE', as it has roatation
	private static final AxisAlignedBB E1 = new AxisAlignedBB(0.741, 0.5, 0.366, 0.803, 0.562, 0.616);
	private static final AxisAlignedBB W1 = new AxisAlignedBB(0.198, 0.5, 0.366, 0.261, 0.562, 0.616);
	private static final AxisAlignedBB S1 = new AxisAlignedBB(0.377, 0.5, 0.73, 0.627, 0.562, 0.792);
	private static final AxisAlignedBB N1 = new AxisAlignedBB(0.375, 0.5, 0.188, 0.625, 0.562, 0.25);
	// Skipped 'SE', as it has roatation
	private static final AxisAlignedBB W2 = new AxisAlignedBB(0.198, 0.427, 0.469, 0.261, 0.677, 0.531);
	private static final AxisAlignedBB S2 = new AxisAlignedBB(0.375, 0.25, 0.469, 0.625, 0.312, 0.531);
	// Skipped 'SW', as it has roatation
	private static final AxisAlignedBB E2 = new AxisAlignedBB(0.74, 0.427, 0.469, 0.802, 0.677, 0.531);
	// Skipped 'NE', as it has roatation
	// Skipped 'NW', as it has roatation
	private static final AxisAlignedBB N2 = new AxisAlignedBB(0.375, 0.791, 0.469, 0.625, 0.853, 0.531);
	/**
	* AxisAlignedBBs and methods getBoundingBox, collisionRayTrace, and collisionRayTrace generated using MrCrayfish's Model Creator <a href="https://mrcrayfish.com/tools?id=mc">https://mrcrayfish.com/tools?id=mc</a>
	*/
	private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(COREC, COREB, CORET, COREN, COREW, CORES, COREE, E1, W1, S1, N1, W1, S1, E1, N1);
	
	//0.198, 0.25, 0.188, 0.803, 0.853, 0.792
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.198, 0.25, 0.188, 0.803, 0.853, 0.792);
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;	
	
	public BlockRarityCore(String name, Material materialIn)
	{
		super(name, materialIn);
		setSoundType(SoundType.GLASS);
		setHarvestLevel("pickaxe", 2);
		setHardness(.5f);
		
	}
	
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
	
	 public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	    {
	        this.setDefaultFacing(worldIn, pos, state);
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
