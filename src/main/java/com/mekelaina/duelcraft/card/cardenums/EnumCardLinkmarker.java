package com.mekelaina.duelcraft.card.cardenums;

import net.minecraft.util.IStringSerializable;

public enum EnumCardLinkmarker implements IStringSerializable
{
    TOP("Top"), BOTTOM("Bottom"), LEFT("Left"), RIGHT("Right"),
    BOTTOM_LEFT("Bottom-Left"), BOTTOM_RIGHT("Bottom-Right"), TOP_LEFT("Top-Left"),
    TOP_RIGHT("Top-Right"), NONE("null");
    
    private final String name;
    
    private EnumCardLinkmarker(String name)
    {
    	this.name = name;
    }
    
    public static String getTypeFromEnum(EnumCardLinkmarker linkIn)
    {	
	for(EnumCardLinkmarker link : values())
	{
	    if(link.equals(linkIn))
	    {
	    	return link.name;
	    }
	}
		return "";
    }
    
    public static EnumCardLinkmarker getEnumFromType(String name)
    {
	for(EnumCardLinkmarker link : values())
	{
	    if(link.name.equals(name))
	    {
	    	return link;
	    }
	}
	return NONE;
    }
    
    public String getName()
    {
    	return this.name();
    }
}
