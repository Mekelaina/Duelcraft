package com.mekelaina.duelcraft.card;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.model.ModelLoader;

public class CardItemMesh implements ItemMeshDefinition
{

	public CardItemMesh()
	{
		CardImages.init();
		
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) 
	{
		ModelResourceLocation varient =  CardImages.CARD_MODELS.get("0");
		
		if(stack.hasTagCompound())
		{
			NBTTagCompound nbt = stack.getTagCompound();
			
			if(nbt.hasKey("Card_ID"))
			{
				varient = CardImages.CARD_MODELS.get(nbt.getTag("Card_ID"));
			}
		}
		
		return varient;
		
	}

}
