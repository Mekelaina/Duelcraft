package com.mekelaina.duelcraft.network;

import com.mekelaina.duelcraft.blocks.tileentities.TileEntityPillar;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRequestUpdatePillar implements IMessage
{
	private BlockPos pos;
	private int dimension;
	
	public PacketRequestUpdatePillar(BlockPos pos, int dimension)
	{
		this.pos = pos;
		this.dimension = dimension;
	}
	
	public PacketRequestUpdatePillar(TileEntityPillar te) 
	{
		this(te.getPos(), te.getWorld().provider.getDimension());
	}
	
	public PacketRequestUpdatePillar() 
	{
		
	}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		pos = BlockPos.fromLong(buf.readLong());
		dimension = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeLong(pos.toLong());
		buf.writeInt(dimension);
	}
	
	public static class Handler implements IMessageHandler<PacketRequestUpdatePillar, IMessage>
	{
		@Override
		public IMessage onMessage(PacketRequestUpdatePillar message, MessageContext ctx)
		{
			World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(message.dimension);
			TileEntityPillar te = (TileEntityPillar)world.getTileEntity(message.pos);
			if(te != null)
			{
				return new PacketUpdatePillar(te);
			}
			else
			{
				return null;
			}
		}
	}

}
