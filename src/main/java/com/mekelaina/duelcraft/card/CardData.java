package com.mekelaina.duelcraft.card;

import com.mekelaina.duelcraft.card.cardenums.EnumCardAttribute;
import com.mekelaina.duelcraft.card.cardenums.EnumCardLinkmarker;
import com.mekelaina.duelcraft.card.cardenums.EnumCardRace;
import com.mekelaina.duelcraft.card.cardenums.EnumCardType;
import com.mekelaina.duelcraft.util.Reference;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.ResourceLocation;

public class CardData
{
	private int id;
    private String name;
    private String description;
    private int atk;
    private int def;
    private EnumCardType type;
    private int level;
    private EnumCardRace race;
    private EnumCardAttribute attribute;
    private int scale;
    private int linkVal;
    private EnumCardLinkmarker[] linkmarkers;
    private String archetype;
    private String set_tag;
    private String setcode;
    private boolean ExtraDeck;
    
    public static final EnumCardLinkmarker[] NONLINK_MARKERS = {EnumCardLinkmarker.NONE};
    
    public static final PropertyEnum<EnumCardAttribute> CARD_ATTRIBUTE =
    		PropertyEnum.<EnumCardAttribute>create("card_attribute", EnumCardAttribute.class);
    public static final PropertyEnum<EnumCardLinkmarker> CARD_LINKMARKERS =
    		PropertyEnum.<EnumCardLinkmarker>create("card_linkmarkers", EnumCardLinkmarker.class);
    public static final PropertyEnum<EnumCardRace> CARD_RACE = 
    		PropertyEnum.<EnumCardRace>create("card_race", EnumCardRace.class);
    public static final PropertyEnum<EnumCardType> CARD_TYPE = 
    		PropertyEnum.<EnumCardType>create("card_type", EnumCardType.class);
    
    private ResourceLocation cardFront;
    
    
    public CardData(String id, String name, String description, String atk, String def, String type, String level,
	    String race, String attribute, String scale, String linkval, String linkmarkers, String archetype, 
	    String set_tag, String setcode)
    {
    	this.id = Integer.parseInt(id);
		this.name = name;
		this.description = description;
		this.atk = (atk.equalsIgnoreCase("")) ? -1 : Integer.parseInt(atk);
		this.def = (def.equalsIgnoreCase("")) ? -1 : Integer.parseInt(def);
		this.type = EnumCardType.getEnumFromType(type);
		this.level = (level.equalsIgnoreCase("")) ? -1 : Integer.parseInt(level);
		this.race = EnumCardRace.getEnumFromType(race);
		this.attribute = EnumCardAttribute.getEnumFromType(attribute);
		this.scale = (scale.equalsIgnoreCase("")) ? -1 : Integer.parseInt(scale);
		this.linkVal = (linkval.equalsIgnoreCase("")) ? -1 : Integer.parseInt(linkval);
		this.archetype = archetype;
		this.setcode = setcode;
		this.set_tag = set_tag;
	
		this.ExtraDeck = evaluateDeckSpace(this.type);
		
		setLinkmarkers(linkmarkers);
	    
		cardFront = new ResourceLocation(Reference.MOD_ID+":assets/duelcraft/textures/cards/"+getId());
	}
	
	
	
    
    
    public CardData(int id, String name, String description, int atk, int def, EnumCardType type, int level, EnumCardRace race,
	    EnumCardAttribute attribute, int scale, int linkVal, String linkmarkers, String archtype, String set_tag, String setcode)
    {
	this.id = id;
	this.name = name;
	this.description = description;
	this.atk = atk;
	this.def = def;
	this.type = type;
	this.level = level;
	this.attribute = attribute;
	this.scale = scale;
	this.linkVal = linkVal;
	this.archetype = archtype;
	this.set_tag = set_tag;
	this.setcode = setcode;
	
	
	
    }
    
    public CardData()
    {
	id = 0;
	name = "";
	description = "";
	atk = 0;
	def = 0;
	type = EnumCardType.TOKEN;
	level = 0;
	race = EnumCardRace.NORMAL;
	attribute = EnumCardAttribute.NONE;
	scale = 0;
	linkVal = 0;
	linkmarkers = NONLINK_MARKERS;
	archetype = "null";
	set_tag = "";
	setcode = "";
    }

    public String toString()
    {
	String rtn = "id: " + this.id +
	"\nname: " + this.name +
	"\ndescription: " + this.description +
	"\natk: " + this.atk + 
	"\ndef: " + this.def + 
	"\ntype: " + this.type.getName() +
	"\nlevel: " + this.level + 
	"\nrace: " + this.race.getName() +
	"\nattribute: " + attribute.getName() +
	"\nscale: " + this.scale +
	"\nlinkValue: " + this.linkVal +
	"\nlinkmarkers: ";
		
	for(EnumCardLinkmarker link : linkmarkers)
	{
	    rtn += link.getName() + " ";
	}
	
	rtn +=	"\narchetype: " + this.archetype +
			"\nset_tag: " + this.set_tag +
			"\nsetcode: " + this.setcode;
		
	return rtn;
    }
    
    private boolean evaluateDeckSpace(EnumCardType type)
    {
    	EnumCardType[] extra = {EnumCardType.FUSION_MONSTER, EnumCardType.LINK_MONSTER, EnumCardType.SYNCHRO_MONSTER,
    			EnumCardType.XYZ_MONSTER, EnumCardType.PENDULUM_EFFECT_FUSION_MONSTER,
    			EnumCardType.SYNCHRO_PENDULUM_EFFECT_MONSTER, EnumCardType.XYZ_PENDULUM_EFFECT_MONSTER};
    	for(EnumCardType t : extra)
    	{
    		if(t.equals(type))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    private int countBreaksInString(String s)
    {
	int count  = 0;
	for(int i = 0; i < s.length(); i++)
	{
	    if(s.charAt(i) == ',')
	    {
		count++;
	    }
	}
	return count;
    }
    
    public void clearData()
    {
    	id = 0;
    	name = "";
    	description = "";
    	atk = 0;
    	def = 0;
    	type = EnumCardType.TOKEN;
    	level = 0;
    	race = EnumCardRace.NORMAL;
    	attribute = EnumCardAttribute.NONE;
    	scale = 0;
    	linkVal = 0;
    	linkmarkers = NONLINK_MARKERS;
    	archetype = "null";
    	set_tag = "";
    	setcode = "";
        
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(String id)
    {
       this.id = Integer.parseInt(id);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public int getAtk() 
    {
        return atk;
    }

    public void setAtk(String atk) 
    {
    	this.atk = (atk.equalsIgnoreCase("")) ? -1 : Integer.parseInt(atk);
    }

    public int getDef()
    {
        return def;
    }

    public void setDef(String def)
    {
    	this.def = (def.equalsIgnoreCase("")) ? -1 : Integer.parseInt(def);
    }

    public EnumCardType getType() 
    {
        return type;
    }

    public void setType(String type)
    {
    	this.type = EnumCardType.getEnumFromType(type);
    }

    public int getLevel() 
    {
        return level;
    }

    public void setLevel(String level) 
    {
    	this.level = (level.equalsIgnoreCase("")) ? -1 : Integer.parseInt(level);
    }

    public EnumCardRace getRace() 
    {
        return race;
    }

    public void setRace(String race) 
    {
    	this.race = EnumCardRace.getEnumFromType(race);
    }

    public EnumCardAttribute getAttribute() 
    {
        return attribute;
    }

    public void setAttribute(String attribute) 
    {
    	this.attribute = EnumCardAttribute.getEnumFromType(attribute);
    }

    public int getScale() 
    {
        return scale;
    }

    public void setScale(String scale) 
    {
    	this.scale = (scale.equalsIgnoreCase("")) ? -1 : Integer.parseInt(scale);
    	
    }
    
    public int getLinkVal()
    {
        return linkVal;
    }

    public void setLinkVal(String linkVal) 
    {
    	this.linkVal = (linkVal.equalsIgnoreCase("")) ? -1 : Integer.parseInt(linkVal);
    
    }

    public EnumCardLinkmarker[] getLinkmarkers() 
    {
        return linkmarkers;
    }

    public void setLinkmarkers(String linkmarkers) 
    {
    	if(linkmarkers.equalsIgnoreCase(""))
    	{
    	    this.linkmarkers = NONLINK_MARKERS;
    	}
    	else
    	{
    	    int markers = countBreaksInString(linkmarkers);
    	    EnumCardLinkmarker[] toPut = new EnumCardLinkmarker[8];
    	    for(int i = 0; i < markers+1; i++)
    	    {
    		int links = linkmarkers.indexOf(",");
    		String sub = (links > 0) ? linkmarkers.substring(0, links) : linkmarkers;
    		
    		if(links > 0)
    		{
    		    linkmarkers = linkmarkers.substring(links+1);
    		}
    		
    		toPut[i] = EnumCardLinkmarker.getEnumFromType(sub);
    	    }
    	    
    	    if(markers < toPut.length)
    	    {
    		for(int j = markers; j < toPut.length; j++)
    		{
    		    toPut[j] = EnumCardLinkmarker.NONE;
    		}
    	    }
    	    
    	    this.linkmarkers = toPut;
    	}
    }

    public String getArchtype() 
    {
        return archetype;
    }

    public void setArchtype(String archetype) 
    {
    	this.archetype = archetype;
    	
    }
    

    public String getSet_tag() 
    {
        return set_tag;
    }

    public void setSet_tag(String set_tag) 
    {
    	
    	this.set_tag = set_tag;
    }

    public String getSetcode()
    {
        return setcode;
    }

    public void setSetcode(String setcode) 
    {
    	this.setcode = setcode;
    }

	public boolean isExtraDeck() 
	{
		return ExtraDeck;
	}
    
    
}
