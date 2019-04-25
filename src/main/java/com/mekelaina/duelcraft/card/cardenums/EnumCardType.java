package com.mekelaina.duelcraft.card.cardenums;

import net.minecraft.util.IStringSerializable;

public enum EnumCardType implements IStringSerializable
{
	TRAP("Trap Card"), SPELL("Spell Card"), NORMAL_MONSTER("Normal Monster"), EFFECT_MONSTER("Effect Monster"), 
    FLIP_MONSTER("Flip Effect Monster"), TOON_MONSTER("Toon Monster"), SPIRIT_MONSTER("Spirit Monster"), GEMINI_MONSTER("Gemini Monster"),
    TUNER_MONSTER("Tuner Monster"), RITUAL_MONSTER("Ritual Monster"), FUSION_MONSTER("Fusion Monster"),
    SYNCHRO_MONSTER("Synchro Monster"), XYZ_MONSTER("XYZ Monster"), PENDULUM_NORMAL_MONSTER("Pendulum Normal Monster"),
    PENDULUM_EFFECT_MONSTER("Pendulum Effect Monster"), PENDULUM_EFFECT_FUSION_MONSTER("Pendelum Effect Fusion Monster"),
    XYZ_PENDULUM_EFFECT_MONSTER("XYZ Pendulum Effect Monster"), SYNCHRO_PENDULUM_EFFECT_MONSTER("Synchro Pendulum Effect Monster"),
    LINK_MONSTER("Link Monster"), TOKEN("Token");
    
    
    private final String name;
   
    private EnumCardType(String name)
    {
    	this.name = name;
    }
    
    public static String getTypeFromEnum(EnumCardType typeIn)
    {	
	for(EnumCardType type : values())
	{
	    if(type.equals(typeIn))
	    {
	    	return type.name;
	    }
	}
		return "";
    }
    
    public static EnumCardType getEnumFromType(String name)
    {
	for(EnumCardType type : values())
	{
	    if(type.name.equals(name))
	    {
	    	return type;
	    }
	}
		return TOKEN;
    }
    
    public String getName()
    {
    	return this.name();
    }
}
