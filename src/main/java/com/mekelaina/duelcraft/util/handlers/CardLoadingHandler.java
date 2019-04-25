package com.mekelaina.duelcraft.util.handlers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mekelaina.duelcraft.Duelcraft;
import com.mekelaina.duelcraft.card.CardCollection;
import com.mekelaina.duelcraft.card.CardData;

public class CardLoadingHandler
{
	public static Gson gson = new Gson();
	
	//private static final CardData currentCard = new CardData();
	
	public static void loadCardInfo()
	{
		String file = Duelcraft.config_dir + "/card_data/cardinfo3.json";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			JsonElement je = gson.fromJson(br, JsonElement.class);
			JsonObject jo = je.getAsJsonObject();
			je = jo.get("item");
			JsonArray ja = je.getAsJsonArray();
			
			for(int i = 0; i < ja.size(); i++)
			{
				je = ja.get(i);
				jo = je.getAsJsonObject();
				
				/*currentCard.setId(jo.get("id").getAsString());
				currentCard.setName(jo.get("name").getAsString());
				currentCard.setDescription(jo.get("desc").getAsString());
				currentCard.setAtk(jo.get("atk").getAsString());
				currentCard.setDef(jo.get("def").getAsString());
				currentCard.setType(jo.get("type").getAsString());
				currentCard.setLevel(jo.get("level").getAsString());
				currentCard.setRace(jo.get("race").getAsString());
				currentCard.setAttribute(jo.get("attribute").getAsString());
				currentCard.setScale(jo.get("scale").getAsString());
				currentCard.setLinkVal(jo.get("linkval").getAsString());
				currentCard.setLinkmarkers(jo.get("linkmarkers").getAsString());
				currentCard.setArchtype(jo.get("archetype").getAsString());
				currentCard.setSet_tag(jo.get("set_tag").getAsString());
				currentCard.setSetcode(jo.get("setcode").getAsString());*/
				
				CardCollection.CARD_LIST.put(jo.get("id").getAsString(), 
						new CardData(jo.get("id").getAsString(),jo.get("name").getAsString(),
								jo.get("desc").getAsString(), jo.get("atk").getAsString(),
								jo.get("def").getAsString(),jo.get("type").getAsString(),
								jo.get("level").getAsString(),jo.get("race").getAsString(),
								jo.get("attribute").getAsString(), jo.get("scale").getAsString(),
								jo.get("linkval").getAsString(),jo.get("linkmarkers").getAsString(),
								jo.get("archetype").getAsString(), jo.get("set_tag").getAsString(),
								jo.get("setcode").getAsString()));
				//currentCard.clearData();
			}
			
			System.out.println("Loaded data successfully");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("BRUH######################");
		}
	}
}
