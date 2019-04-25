package com.mekelaina.duelcraft.init;

import java.util.ArrayList;
import java.util.List;



import com.mekelaina.duelcraft.items.ItemBase;
import com.mekelaina.duelcraft.items.ItemCard;
import com.mekelaina.duelcraft.items.ItemCardBinder;
import com.mekelaina.duelcraft.items.ItemCounter;
import com.mekelaina.duelcraft.items.ItemDeckbox;
import com.mekelaina.duelcraft.items.ItemKaibaliumIngot;
import com.mekelaina.duelcraft.items.ItemOre;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//public static final Item KAIBALIUM_INGOT = new ItemKaibaliumIngot("kaibalium_ingot");
	public static final ItemCard CARD = new ItemCard("card");
	//public static final Item COUNTER = new ItemCounter("counter");
	public static final Item DECK_BOX = new ItemDeckbox("deckbox");
	public static final Item KAIBA_CRYSTAL = new ItemOre("kaiba_crystal", "ingotKaibaCrystal");
	public static final Item BINDER = new ItemCardBinder("binder");
	
}
