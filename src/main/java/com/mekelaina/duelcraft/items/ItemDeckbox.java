package com.mekelaina.duelcraft.items;

import com.mekelaina.duelcraft.Duelcraft;
import com.mekelaina.duelcraft.inventory.ModItemInventoryProvider;
import com.mekelaina.duelcraft.util.Reference;
import com.mekelaina.duelcraft.util.handlers.ModGuiHandler;
import com.mekelaina.duelcraft.util.interfaces.IItemWithMeshDefinition;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ItemDeckbox extends ItemBase implements IItemWithMeshDefinition
{

	private PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class);
	private final static int INV_SIZE = 90;
	private ModItemInventoryProvider inventory;
	
	
	public ItemDeckbox(String name)
	{
		super(name);
		this.hasSubtypes = true;
		this.setMaxStackSize(1);
		
	}
	
	@Override
	public void registerModels() 
	{
		ItemMeshDefinition mesh = getMeshDefinition();
		
		ModelLoader.setCustomMeshDefinition(this, mesh);
		NonNullList<ItemStack> subItems = NonNullList.create();
		this.getSubItems(Duelcraft.MAIN_TAB, subItems);
		for(ItemStack stack : subItems)
		{
			ModelBakery.registerItemVariants(this, mesh.getModelLocation(stack));
		}
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
	{
		if(!this.isInCreativeTab(tab))
		{
			return;
		}
		
		for(EnumDyeColor color : EnumDyeColor.values())
		{
			String colorName = color.getUnlocalizedName();
			ItemStack stack = new ItemStack(this);
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("Deckbox_Color", colorName);
			stack.setTagCompound(nbt);
			String colorNameCapital = colorName.substring(0, 1).toUpperCase() + colorName.substring(1);
			stack.setStackDisplayName(colorNameCapital + " Deckbox"  );
			
			items.add(stack);
		}
		
	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt)
	{
		this.inventory = new ModItemInventoryProvider(INV_SIZE);
		return inventory;
	}

	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		
			playerIn.openGui(Duelcraft.instance, ModGuiHandler.DECKBOX, worldIn, 0, 0, 0);
			
			
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public ItemMeshDefinition getMeshDefinition() 
	{
		return new ItemMeshDefinition()
		{
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) 
			{
				if(stack.hasTagCompound())
				{
					NBTTagCompound nbt = stack.getTagCompound();
					String deckboxColor = nbt.getString("Deckbox_Color");
					ResourceLocation loc = new ResourceLocation(Reference.MOD_ID, deckboxColor + "_deckbox");
					ModelResourceLocation fullModelLocation = new ModelResourceLocation(loc, "inventory");
					return fullModelLocation;
				}
				return new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, "white_deckbox"), "inventory");
			}
		};
	}
	
	public static int getInvSize()
	{
		return INV_SIZE;
	}
}
