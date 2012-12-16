package com.ohako.itemcategory.staves;

import com.ohako.Item;

public class StaffItem extends Item 
{
	protected String itemName;
	private int itemPrice;
	
	public StaffItem(String itemName, int itemPrice)
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
		StaffItem newItem = new StaffItem(itemName(), itemPrice());
		return newItem;
	}

	@Override
	public void generateItem() 
	{
		leafItem = true;
	}
}
