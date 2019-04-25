package com.mekelaina.duelcraft.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.mekelaina.duelcraft.Duelcraft;
import com.mekelaina.duelcraft.util.enums.EnumGlassTypes;
import com.mekelaina.duelcraft.util.interfaces.IHasModel;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCardTable extends BlockBase implements IHasModel
{

	protected static final AxisAlignedBB BASE = new AxisAlignedBB(0.156, 0, 0.156, 0.844, 0.094, 0.844);
	protected static final AxisAlignedBB POLE = new AxisAlignedBB(0.403, 0.095, 0.403, 0.622, 0.907, 0.622);
	protected static final AxisAlignedBB RULER = new AxisAlignedBB(0, 0, 0, 0.062, 1, 0.062);
	protected static final AxisAlignedBB TOP = new AxisAlignedBB(0, 0.906, 0, 1, 0.994, 1);
	protected static final AxisAlignedBB ZONE1 = new AxisAlignedBB(0.078, 0.994, 0.781, 0.172, 0.994, 0.906);
	protected static final AxisAlignedBB ZONE2 = new AxisAlignedBB(0.203, 0.988, 0.781, 0.297, 0.994, 0.906);
	protected static final AxisAlignedBB ZONE3 = new AxisAlignedBB(0.328, 0.988, 0.781, 0.422, 0.994, 0.906);
	protected static final AxisAlignedBB ZONE4 = new AxisAlignedBB(0.453, 0.988, 0.781, 0.546, 0.994, 0.906);
	protected static final AxisAlignedBB ZONE5 = new AxisAlignedBB(0.578, 0.988, 0.781, 0.672, 0.994, 0.906);
	protected static final AxisAlignedBB ZONE6 = new AxisAlignedBB(0.703, 0.988, 0.781, 0.797, 0.994, 0.906);
	protected static final AxisAlignedBB ZONE7 = new AxisAlignedBB(0.828, 0.988, 0.781, 0.922, 0.994, 0.906);
	protected static final AxisAlignedBB ZONE8 = new AxisAlignedBB(0.828, 0.988, 0.094, 0.922, 0.994, 0.219);
	protected static final AxisAlignedBB ZONE9 = new AxisAlignedBB(0.703, 0.988, 0.094, 0.797, 0.994, 0.219);
	protected static final AxisAlignedBB ZONE10 = new AxisAlignedBB(0.578, 0.988, 0.094, 0.672, 0.994, 0.219);
	protected static final AxisAlignedBB ZONE11 = new AxisAlignedBB(0.453, 0.988, 0.094, 0.546, 0.994, 0.219);
	protected static final AxisAlignedBB ZONE12 = new AxisAlignedBB(0.328, 0.988, 0.094, 0.422, 0.994, 0.219);
	protected static final AxisAlignedBB ZONE13 = new AxisAlignedBB(0.203, 0.988, 0.094, 0.297, 0.994, 0.219);
	protected static final AxisAlignedBB ZONE14 = new AxisAlignedBB(0.078, 0.994, 0.094, 0.172, 0.994, 0.219);
	protected static final AxisAlignedBB ZONE15 = new AxisAlignedBB(0.078, 0.994, 0.25, 0.172, 0.994, 0.375);
	protected static final AxisAlignedBB ZONE16 = new AxisAlignedBB(0.828, 0.988, 0.25, 0.922, 0.994, 0.375);
	protected static final AxisAlignedBB ZONE17 = new AxisAlignedBB(0.703, 0.988, 0.25, 0.797, 0.994, 0.375);
	protected static final AxisAlignedBB ZONE18 = new AxisAlignedBB(0.578, 0.988, 0.25, 0.672, 0.994, 0.375);
	protected static final AxisAlignedBB ZONE19 = new AxisAlignedBB(0.453, 0.988, 0.25, 0.547, 0.994, 0.375);
	protected static final AxisAlignedBB ZONE20 = new AxisAlignedBB(0.328, 0.988, 0.25, 0.422, 0.994, 0.375);
	protected static final AxisAlignedBB ZONE21 = new AxisAlignedBB(0.203, 0.988, 0.25, 0.297, 0.994, 0.375);
	protected static final AxisAlignedBB ZONE22 = new AxisAlignedBB(0.203, 0.988, 0.625, 0.297, 0.994, 0.75);
	protected static final AxisAlignedBB ZONE23 = new AxisAlignedBB(0.078, 0.988, 0.625, 0.172, 0.994, 0.75);
	protected static final AxisAlignedBB ZONE24 = new AxisAlignedBB(0.328, 0.988, 0.625, 0.422, 0.994, 0.75);
	protected static final AxisAlignedBB ZONE25 = new AxisAlignedBB(0.453, 0.988, 0.625, 0.547, 0.994, 0.75);
	protected static final AxisAlignedBB ZONE26 = new AxisAlignedBB(0.578, 0.988, 0.625, 0.672, 0.994, 0.75);
	protected static final AxisAlignedBB ZONE27 = new AxisAlignedBB(0.703, 0.988, 0.625, 0.797, 0.994, 0.75);
	protected static final AxisAlignedBB ZONE28 = new AxisAlignedBB(0.828, 0.988, 0.625, 0.922, 0.994, 0.75);
	protected static final AxisAlignedBB ZONE29 = new AxisAlignedBB(0.578, 0.988, 0.438, 0.672, 0.994, 0.562);
	protected static final AxisAlignedBB ZONE30 = new AxisAlignedBB(0.328, 0.988, 0.438, 0.422, 0.994, 0.562);
	
	protected static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(BASE, POLE, RULER, TOP, ZONE1, ZONE2, ZONE3, ZONE4, ZONE5, ZONE6, ZONE7, ZONE8, ZONE9, ZONE10, ZONE11, ZONE12, ZONE13, ZONE14, ZONE15, ZONE16, ZONE17, ZONE18, ZONE19, ZONE20, ZONE21, ZONE22, ZONE23, ZONE24, ZONE25, ZONE26, ZONE27, ZONE28, ZONE29, ZONE30);
	protected static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 1, 1, 1 );
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;	
	public static final BlockRenderLayer RENDER_LAYER = BlockRenderLayer.TRANSLUCENT;
	
	//public static final PropertyEnum<EnumGlassTypes> GLASS_TYPE = PropertyEnum.<EnumGlassTypes>create("glass_type", EnumGlassTypes.class);
	
	public BlockCardTable(String name, Material materialIn, EnumGlassTypes glass_type)
	{
		super(name, materialIn);
		//setCreativeTab(CreativeTabs.DECORATIONS);
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		setSoundType(SoundType.STONE);
		
		setHardness(1f);
		
		
	/*	
		String s = glass_type.getUnlocalizedName();

        if (s.length() > 1)
        {
            String s1 = s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
            this.setUnlocalizedName("card_table_" + s1 + "_glass");
        }*/
        //setRegistryName(this.getUnlocalizedName());
		
		//canRenderInLayer(state, layer)
	}
	
	/*public int damageDropped(IBlockState state)
    {
        return ((EnumGlassTypes)state.getValue(GLASS_TYPES)).getMetadata();
    }*/
	
	/*public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (EnumGlassTypes enumglasstypes : EnumGlassTypes.values())
        {
            items.add(new ItemStack(this, 1, enumglasstypes.getMetadata()));
        }
    }*/
	
	@Override
	public void registerModels() 
	{
		Duelcraft.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
	    return BOUNDING_BOX;
	}

	@Override
	@Nullable
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState)
	{
	    entityBox = entityBox.offset(-pos.getX(), -pos.getY(), -pos.getZ());
	    for (AxisAlignedBB box : COLLISION_BOXES)
	    {
	        if (entityBox.intersects(box))
	            collidingBoxes.add(box.offset(pos));
	    }
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

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	//@Nullable
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
	
}
