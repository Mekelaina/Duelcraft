package com.mekelaina.duelcraft.items;

import com.mekelaina.duelcraft.Duelcraft;
import com.mekelaina.duelcraft.card.CardCollection;
import com.mekelaina.duelcraft.card.CardData;
import com.mekelaina.duelcraft.card.CardImages;
import com.mekelaina.duelcraft.card.CardItemMesh;
import com.mekelaina.duelcraft.util.Reference;
import com.mekelaina.duelcraft.util.interfaces.IHasModel;
import com.mekelaina.duelcraft.util.interfaces.IItemWithMeshDefinition;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCard extends ItemBase implements IHasModel, IItemWithMeshDefinition
{

	ModelResourceLocation dummy = new ModelResourceLocation("dummy");
	
	ModelResourceLocation model = 
			new ModelResourceLocation("duelcraft:27551", "inventory");
	
	public ItemCard(String name)
	{
		super(name);
		setCreativeTab(Duelcraft.CARD_TAB);
		hasSubtypes = true;
		setMaxStackSize(1);
	}
	
	
	public void registerModels()
	{
		//System.out.println("wdjlmnojvn");
		
			ItemMeshDefinition mesh = getMeshDefinition();
			
			ModelLoader.setCustomMeshDefinition(this, mesh);
			NonNullList<ItemStack> subItems = NonNullList.create();
			this.getSubItems(Duelcraft.CARD_TAB, subItems);
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
		
		for(String cardid : CardCollection.CARD_LIST.keySet())
		{
			ItemStack stack = new ItemStack(this);
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("Card_ID", cardid);
			nbt.setInteger("Card_Rarity", 0);
			stack.setTagCompound(nbt);
			
			stack.setStackDisplayName(CardCollection.CARD_LIST.get(cardid).getName());
			
			
			items.add(stack);
		}
	}
	
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer playerIn, EnumHand hand)
	{
		String msg = "";
		ItemStack stack = playerIn.getHeldItem(hand);
		if(!world.isRemote)
		{
			
			NBTTagCompound nbt = stack.getTagCompound();
			if(nbt.hasKey("Card_ID"))
			{
				msg = "ID: " + nbt.getString("Card_ID");
				msg += ", name: " + CardCollection.CARD_LIST.get(nbt.getString("Card_ID")).getName();
			}
			playerIn.sendMessage(new TextComponentString(msg));
		}
		return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
	}


	@Override
	@SideOnly(Side.CLIENT)
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
					String Card_ID = nbt.getString("Card_ID");
					ResourceLocation loc = new ResourceLocation(Reference.MOD_ID, Card_ID);
					ModelResourceLocation fullModelLocation = new ModelResourceLocation(loc, "inventory");
					return fullModelLocation;
					
				}
				return new ModelResourceLocation(new ResourceLocation("duelcraft", "0"), "inventory");
			}
		};
	}

}
