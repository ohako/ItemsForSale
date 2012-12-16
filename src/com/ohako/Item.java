package com.ohako;

public abstract class Item 
{
	public abstract String itemName();
	public abstract int itemPrice();
	protected boolean leafItem;
	public abstract void generateItem();
	public abstract Item copyItem();
	
	public boolean isLeafItem()
	{
		return leafItem;
	}
	
	public void setLeafItem(boolean leafItem)
	{
		this.leafItem = leafItem;
	}
	
	public void outputItem() 
	{
		System.out.println(itemName() + "\t" + itemPrice());
	}
}
