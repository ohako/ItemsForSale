package com.ohako.itemcategory.rods;

import com.ohako.Item;

public class RodItem extends Item 
{
	protected String itemName;
	private int itemPrice;
	
	public RodItem(String itemName, int itemPrice)
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
	public Item copyItem() 
	{
		RodItem newItem = new RodItem(itemName(), itemPrice());
		return newItem;
	}

	@Override
	public void generateItem() 
	{
		leafItem = true;
	}
}
