package com.mekelaina.duelcraft.proxy;


import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentTranslation;


public class CommonProxy
{
	public void registerItemRenderer(Item item, int meta, String id)
	{
		
	}
	
	public String localize(String unlocalized, Object...  args)
	{
		TextComponentTranslation txt = new TextComponentTranslation(unlocalized, args);
		return txt.getFormattedText();
	}
	
	public void registerRenderers()
	{
		
	}
}
