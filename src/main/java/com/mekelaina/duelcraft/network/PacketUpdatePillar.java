package com.mekelaina.duelcraft.network;

import com.mekelaina.duelcraft.blocks.tileentities.TileEntityPillar;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketUpdatePillar implements IMessage 
{

	private BlockPos pos;
	private ItemStack stack;
	private long lastChangeTime;
	
	public PacketUpdatePillar(BlockPos pos, ItemStack stack, long lastChangeTime)
	{
		this.pos = pos;
		this.stack = stack;
		this.lastChangeTime = lastChangeTime;
	}
	
	public PacketUpdatePillar(TileEntityPillar te)
	{
		this(te.getPos(), te.inventory.getStackInSlot(0), te.lastChangeTime);
	}
	
	public PacketUpdatePillar() 
	{
		
	}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		pos = BlockPos.fromLong(buf.readLong());
		stack = ByteBufUtils.readItemStack(buf);
		lastChangeTime = buf.readLong();
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeLong(pos.toLong());
		ByteBufUtils.writeItemStack(buf, stack);
		buf.writeLong(lastChangeTime);
	}

	
	public static class Handler implements IMessageHandler<PacketUpdatePillar, IMessage>
	{
		@Override
		public IMessage onMessage(PacketUpdatePillar message, MessageContext ctx) 
		{
			Minecraft.getMinecraft().addScheduledTask(() -> {
				TileEntityPillar te = (TileEntityPillar)Minecraft.getMinecraft().world.getTileEntity(message.pos);
				te.inventory.setStackInSlot(0, message.stack);
				te.lastChangeTime = message.lastChangeTime;
			});
			return null;
		}
	}
}
