package com.mekelaina.duelcraft.card;

import java.util.HashMap;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class CardImages 
{
	public static HashMap<String, ModelResourceLocation> CARD_MODELS 
		= new HashMap<String, ModelResourceLocation>(10100);
	
	/*public static final ModelResourceLocation model0 = new CardModelResourceLocation("duelcraft:0", "inventory");
	public static final ModelResourceLocation model27551 = new CardModelResourceLocation("duelcraft:27551", "inventory");
	public static final ModelResourceLocation model32864 = new CardModelResourceLocation("duelcraft:32864", "inventory");
	public static final ModelResourceLocation model41546 = new CardModelResourceLocation("duelcraft:41546", "inventory");
	public static final ModelResourceLocation model41777 = new CardModelResourceLocation("duelcraft:41777", "inventory");
	public static final ModelResourceLocation model50755 = new CardModelResourceLocation("duelcraft:50755", "inventory");
	public static final ModelResourceLocation model62121 = new CardModelResourceLocation("duelcraft:62121", "inventory");
	public static final ModelResourceLocation model98905 = new CardModelResourceLocation("duelcraft:98905", "inventory");
	public static final ModelResourceLocation model102380 = new CardModelResourceLocation("duelcraft:102380", "inventory");
	public static final ModelResourceLocation model111280 = new CardModelResourceLocation("duelcraft:111280", "inventory");
	public static final ModelResourceLocation model114932 = new CardModelResourceLocation("duelcraft:114932", "inventory");*/
	
	public static void init()
	{
		for(String cardID : CardCollection.CARD_LIST.keySet())
		{
			CARD_MODELS.put(cardID, new ModelResourceLocation("duelcraft:"+cardID,"inventory"));
			
		}
	}
	
	
}
