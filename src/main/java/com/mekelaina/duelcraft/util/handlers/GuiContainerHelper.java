package com.mekelaina.duelcraft.util.handlers;

public class GuiContainerHelper 
{
	private int refX;
	private int refY;
	
	public GuiContainerHelper(int refX, int refY)
	{
		this.refX = refX;
		this.refY = refY;
	}

	public int getRefX() 
	{
		return refX;
	}

	public void setRefX(int refX)
	{
		this.refX = refX;
	}

	public int getRefY() 
	{
		return refY;
	}

	public void setRefY(int refY)
	{
		this.refY = refY;
	}
	
	
}
