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

public class BlockCardPrinter extends BlockBase implements IHasModel
{

	private static final AxisAlignedBB MECHSOUTH1 = new AxisAlignedBB(0.358, 0.131, 0.506, 0.642, 0.188, 0.516);
	private static final AxisAlignedBB TRAYLIPWEST = new AxisAlignedBB(0.312, 0.094, 0.113, 0.359, 0.141, 0.281);
	private static final AxisAlignedBB MECHSOUTH2 = new AxisAlignedBB(0.359, 0.095, 0.468, 0.641, 0.142, 0.506);
	private static final AxisAlignedBB MECHWEST = new AxisAlignedBB(0.357, 0.095, 0.375, 0.359, 0.188, 0.506);
	private static final AxisAlignedBB MECHEAST = new AxisAlignedBB(0.642, 0.095, 0.375, 0.644, 0.188, 0.506);
	private static final AxisAlignedBB LIGHT = new AxisAlignedBB(0.734, 0.412, 0.365, 0.753, 0.431, 0.383);
	private static final AxisAlignedBB TRAYLIPEAST = new AxisAlignedBB(0.641, 0.094, 0.113, 0.688, 0.141, 0.281);
	private static final AxisAlignedBB TRAY = new AxisAlignedBB(0.359, 0, 0.094, 0.641, 0.094, 0.281);
	private static final AxisAlignedBB CASE = new AxisAlignedBB(0.406, 0.281, 0.75, 0.594, 0.375, 0.759);
	private static final AxisAlignedBB TOP4 = new AxisAlignedBB(0.641, 0.375, 0.562, 0.781, 0.469, 0.656);
	private static final AxisAlignedBB TOP3 = new AxisAlignedBB(0.219, 0.375, 0.562, 0.359, 0.469, 0.656);
	private static final AxisAlignedBB TOP2 = new AxisAlignedBB(0.219, 0.375, 0.656, 0.781, 0.469, 0.844);
	private static final AxisAlignedBB WEST2 = new AxisAlignedBB(0.219, 0.281, 0.375, 0.312, 0.375, 0.75);
	private static final AxisAlignedBB SOUTHWEST1 = new AxisAlignedBB(0.219, 0.094, 0.281, 0.359, 0.188, 0.375);
	private static final AxisAlignedBB EAST2 = new AxisAlignedBB(0.688, 0.281, 0.375, 0.781, 0.375, 0.75);
	private static final AxisAlignedBB SOUTHEAST2 = new AxisAlignedBB(0.594, 0.281, 0.75, 0.781, 0.375, 0.844);
	private static final AxisAlignedBB SOUTHWEST2 = new AxisAlignedBB(0.219, 0.281, 0.75, 0.406, 0.375, 0.844);
	private static final AxisAlignedBB TOP1 = new AxisAlignedBB(0.219, 0.375, 0.375, 0.781, 0.469, 0.562);
	private static final AxisAlignedBB NORTHRIDGE = new AxisAlignedBB(0.219, 0.281, 0.281, 0.781, 0.375, 0.375);
	private static final AxisAlignedBB EAST1 = new AxisAlignedBB(0.688, 0.094, 0.375, 0.781, 0.188, 0.75);
	private static final AxisAlignedBB WEST1 = new AxisAlignedBB(0.219, 0.094, 0.375, 0.312, 0.188, 0.75);
	private static final AxisAlignedBB NORTHEAST1 = new AxisAlignedBB(0.641, 0.094, 0.281, 0.781, 0.188, 0.375);
	private static final AxisAlignedBB MID = new AxisAlignedBB(0.219, 0.188, 0.281, 0.781, 0.281, 0.844);
	private static final AxisAlignedBB SOUTHEAST1 = new AxisAlignedBB(0.594, 0.094, 0.75, 0.781, 0.188, 0.844);
	private static final AxisAlignedBB SOUTHWEST3 = new AxisAlignedBB(0.219, 0.094, 0.75, 0.594, 0.188, 0.844);
	private static final AxisAlignedBB BASE = new AxisAlignedBB(0.219, 0, 0.281, 0.781, 0.094, 0.844);
	private static final AxisAlignedBB SHEET2 = new AxisAlignedBB(0.359, 0.094, 0.094, 0.641, 0.103, 0.469);
	// Skipped 'Sheet', as it has roatation
	private static final AxisAlignedBB INKC = new AxisAlignedBB(0.453, 0.281, 0.769, 0.5, 0.375, 0.863);
	private static final AxisAlignedBB INKM = new AxisAlignedBB(0.406, 0.281, 0.769, 0.453, 0.375, 0.863);
	private static final AxisAlignedBB INKY = new AxisAlignedBB(0.5, 0.281, 0.769, 0.547, 0.375, 0.863);
	private static final AxisAlignedBB INKB = new AxisAlignedBB(0.547, 0.281, 0.769, 0.594, 0.375, 0.863);
	/**
	* AxisAlignedBBs and methods getBoundingBox, collisionRayTrace, and collisionRayTrace generated using MrCrayfish's Model Creator <a href="https://mrcrayfish.com/tools?id=mc">https://mrcrayfish.com/tools?id=mc</a>
	*/
	private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(MECHSOUTH1, TRAYLIPWEST, MECHSOUTH2, MECHWEST, MECHEAST, LIGHT, TRAYLIPEAST, TRAY, CASE, TOP4, TOP3, TOP2, WEST2, SOUTHWEST1, EAST2, SOUTHEAST2, SOUTHWEST2, TOP1, NORTHRIDGE, EAST1, WEST1, NORTHEAST1, MID, SOUTHEAST1, SOUTHWEST1, BASE, SHEET2, INKC, INKM, INKY, INKB);
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.219, 0, 0.094, 0.781, 0.469, 0.863);
	public static final PropertyDirection FACING = BlockHorizontal.FACING;	
	
	
	public BlockCardPrinter(String name, Material materialIn)
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
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.SOLID;
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
