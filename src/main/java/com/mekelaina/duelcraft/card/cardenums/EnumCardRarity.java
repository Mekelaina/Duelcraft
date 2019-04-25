package com.mekelaina.duelcraft.card.cardenums;

public enum EnumCardRarity 
{
	COMMON("common", 0), RARE("rare", 1), SUPER_RARE("super_rare", 2), ULTRA_RARE("ultra_rare", 3);
	
	private final int value;
	private final String name;
	
	private EnumCardRarity(String name, int value)
	{
		this.name = name;
		this.value = value;
	}
	
	public EnumCardRarity getRarityFromValue(int value)
	{
		for(EnumCardRarity rarity : values())
		{
			if(rarity.getValue() == value)
			{
				return rarity;
			}
		}
		
		return COMMON;
	}
	
	public EnumCardRarity getRarityFromName(String name)
	{
		for(EnumCardRarity rarity : values())
		{
			if(rarity.getName().equals(name)) 
			{
				return rarity;
			}
		}
		return COMMON;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
    public String getName()
    {
    	return this.name();
    }
}
