package com.mekelaina.duelcraft.util.enums;

import net.minecraft.util.IStringSerializable;

/*public class EnumHandler
{*/
	public enum EnumGlassTypes implements IStringSerializable
	{
		
		WHITE("white", 0),
		ORANGE("orange", 1), 
		MAGENTA("magenta", 2),
		LIGHT_BLUE("light_blue", 3),
		YELLOW("yellow", 4),
		LIME("lime", 5), 
		PINK("pink", 6),
		GREY("grey", 7), 
		SILVER("silver", 8),
		CYAN("cyan", 9),
		PURPLE("purple", 10),
		BLUE("BLUE", 11), 
		BROWN("brown", 12),
		GREEN("green", 13), 
		RED("red", 14), 
		BLACK("black", 15),
		CLEAR("clear", 16);
		
		private final int meta;
		private final String name;
		
		
		@Override
		public String getName() 
		{
			return this.name;
		}
		
		public int getMetadata()
		{
			return meta;
		}
		
		@Override
		public String toString()
		{
			return getName();
		}
		
		
		
		private EnumGlassTypes(String name, int meta)
		{
			this.meta = meta;
			this.name = name;
		}
		
	}
	
	
//}
