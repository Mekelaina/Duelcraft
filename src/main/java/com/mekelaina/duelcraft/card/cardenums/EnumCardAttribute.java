package com.mekelaina.duelcraft.card.cardenums;

import net.minecraft.util.IStringSerializable;

public enum EnumCardAttribute implements IStringSerializable
{
	 FIRE("FIRE"), WATER("WATTER"), EARTH("EARTH"), WIND("WIND"), 
	    LIGHT("LIGHT"), DARK("DARK"), DIVINE("DIVINE"), NONE("0");
	    
	    private final String name;
	    
	    private EnumCardAttribute(String name)
	    {
		this.name = name;
	    }
	    
	    public static String getTypeFromEnum(EnumCardAttribute attributeIn)
	    {	
		for(EnumCardAttribute attribute : values())
		{
		    if(attribute.equals(attributeIn))
		    {
			return attribute.name;
		    }
		}
		return "";
	    }
	    
	    public static EnumCardAttribute getEnumFromType(String name)
	    {
		for(EnumCardAttribute attribute : values())
		{
		    if(attribute.name.equals(name))
		    {
			return attribute;
		    }
		}
		return NONE;
	    }
	    
	    public String getName()
	    {
		return this.name();
	    }
}
