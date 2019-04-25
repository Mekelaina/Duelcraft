package com.mekelaina.duelcraft.gui;

import net.minecraft.util.ResourceLocation;

public class ModGuiElement 
{
	private ResourceLocation image;
	private int posx, texturex;
	private int posy, texturey;
	private int width;
	private int height;
	private boolean reuseable;
	
	public ModGuiElement(ResourceLocation image, int posx, int posy, int texturex, int texturey, int width, int height)
	{
		this.image = image;
		this.posx = posx;
		this.posy = posy;
		this.width = width;
		this.height = height;
		this.texturex = texturex;
		this.texturey = texturey;
		this.reuseable = false;
	}
	
	public ModGuiElement(ResourceLocation image, int texturex, int texturey, int width, int height)
	{
		this.image = image;
		this.posx = texturex;
		this.posy = texturey;
		this.width = width;
		this.height = height;
		this.texturex = texturex;
		this.texturey = texturey;
		this.reuseable = true;
	}

	public ResourceLocation getImage() 
	{
		return image;
	}

	public void setImage(ResourceLocation image) 
	{
		this.image = image;
	}

	public int getPosX() 
	{
		return posx;
	}

	public void setPosX(int x1) 
	{
		this.posx = x1;
	}

	public int getTextureX() 
	{
		return texturex;
	}

	public void setTextureX(int x2) 
	{
		this.texturex = x2;
	}

	public int getPosY() 
	{
		return posy;
	}

	public void setPosY(int y1) 
	{
		this.posy = y1;
	}

	public int getTextureY()
	{
		return texturey;
	}

	public void setTextureY(int y2) 
	{
		this.texturey = y2;
	}

	public int getWidth() 
	{
		return width;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
	
	
}
