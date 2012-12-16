package com.ohako.itemcategory.rings;

import com.ohako.Item;

public class RingItem extends Item 
{
	private String itemName;
	private int itemPrice;
	
	public RingItem(String itemName, int itemPrice) 
	{
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	@Override
	public String itemName() 
	{
		return itemName;
	}

	@Override
	public int itemPrice() 
	{
		return itemPrice;
	}

	@Override
	public void generateItem() 
	{
		leafItem = true;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	@Override
	public Item copyItem() 
	{
		RingItem newItem = new RingItem(this.itemName, this.itemPrice);
		return newItem;
	}
}
