package com.mekelaina.duelcraft.card.cardenums;

import net.minecraft.util.IStringSerializable;

public enum EnumCardRace implements IStringSerializable
{
	   AQUA("Aqua"), BEAST("Beast"), BEAST_WARRIOR("Beast-Warrior"), CYBERSE("Cyberse"), DINOSAUR("Dinosaur"), 
	    DEVINE_BEAST("Devine-Beast"), DRAGON("Dragon"), FAIRY("Fairy"), FIEND("Fiend"), FISH("Fish"), INSECT("Insect"),
	    MACHINE("Machine"), PLANT("Plant"), PSYCHIC("Psychic"), PYRO("Pyro"), REPTILE("Reptile"), ROCK("Rock"),
	    SEA_SERPANT("Sea-Serpant"), SPELLCASTER("Spellcaster"), THUNDER("Thunder"), WARRIOR("Warrior"), WINGED_BEAST("Winged-Beast"),
	    WYRM("Wyrm"), ZOMBIE("Zombie"), NORMAL("Normal"), QUICK_PLAY("Quick-Play"), CONTINUOUS("Continuous"), FIELD("Field"),
	    EQUIP("Equip"), RITUAL("Ritual"), COUNTER("Counter");
	    
	    private final String name;
	   
	    private EnumCardRace(String name)
	    {
	    	this.name = name;
	    }
	    
	    public static String getTypeFromEnum(EnumCardRace typeIn)
	    {	
	    	for(EnumCardRace type : values())
		{
		    if(type.equals(typeIn))
		    {
		    	return type.name;
		    }
		}
		return "";
	    }
	    
	    public static EnumCardRace getEnumFromType(String name)
	    {
		for(EnumCardRace type : values())
		{
		    if(type.name.equals(name))
		    {
		    	return type;
		    }
		}
			return NORMAL;
	    }
	    
	    public String getName()
	    {
	    	return this.name();
	    }
	    
}
