package com.mekelaina.duelcraft.items;

import com.mekelaina.duelcraft.Duelcraft;
import com.mekelaina.duelcraft.inventory.ModItemInventoryProvider;
import com.mekelaina.duelcraft.util.Reference;
import com.mekelaina.duelcraft.util.handlers.ModGuiHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.ItemStackHandler;

public class ItemCardBinder extends ItemBase 
{

	private ModItemInventoryProvider inventory;
	private boolean hasDeckbox;
	
	//private int INV_SIZE = ;
	
	public ItemCardBinder(String name) 
	{
		super(name);
		hasDeckbox = false;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		
			if(!playerIn.isSneaking())
			{
				playerIn.openGui(Duelcraft.instance, ModGuiHandler.BINDER, worldIn, 0, 0, 0);
			}
			else
			{
				this.hasDeckbox = !this.hasDeckbox;
			}
			
			
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt)
	{
		this.inventory = new ModItemInventoryProvider(88);
		return inventory;
	}

	public boolean hasDeckbox() 
	{
		return hasDeckbox;
	}

	public void setHasDeckbox(boolean hasDeckbox) 
	{
		this.hasDeckbox = hasDeckbox;
	}
	
	public ItemStackHandler getInventory()
	{
		return inventory.getInventory();
	}
	
}
