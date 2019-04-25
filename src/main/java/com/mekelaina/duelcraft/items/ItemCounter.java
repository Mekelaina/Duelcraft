package com.mekelaina.duelcraft.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemCounter extends ItemBase 
{

	//private static final String name = "counter";
	
	public ItemCounter(String name) 
	{
		super(name);
		setCreativeTab(CreativeTabs.TOOLS);
	}
	
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		ItemStack itemStackIn = playerIn.getHeldItem(handIn);
		NBTTagCompound nbtTagCompunt = itemStackIn.getTagCompound();
		if(!itemStackIn.hasTagCompound())
		{
			nbtTagCompunt = new NBTTagCompound();
		}
		
		if(nbtTagCompunt.hasKey("Uses"))
		{
			nbtTagCompunt.setInteger("Uses", nbtTagCompunt.getInteger("Uses") + 1);
		}
		else
		{
			nbtTagCompunt.setInteger("Uses", 1);
		}
		itemStackIn.setTagCompound(nbtTagCompunt);
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("Uses"))
		{
			tooltip.add(Integer.toString(stack.getTagCompound().getInteger("Uses")));
		}
	}

}
