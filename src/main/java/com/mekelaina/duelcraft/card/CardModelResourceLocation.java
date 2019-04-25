package com.mekelaina.duelcraft.card;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class CardModelResourceLocation extends ModelResourceLocation 
{
	public String cardID;

	public CardModelResourceLocation(String location, String variantIn) 
	{
		super(location, variantIn);
		addToList(location);
	}

	private void addToList(String location)
	{
		cardID = location.substring(location.indexOf(":"));
		CardImages.CARD_MODELS.put(cardID, this);
	}
	
}
