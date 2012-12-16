package com.ohako.itemcategory.wondrousitems;

import com.ohako.Item;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public abstract class WondrousItem extends Item {
	
	protected ItemDegree itemDegree;
	protected ItemDegreeQualifier itemDegreeQualifier;
	protected String itemName;
	protected int itemPrice;

	public WondrousItem(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		this.itemDegree = itemDegree;
		this.itemDegreeQualifier = itemDegreeQualifier;
	}
	
	public WondrousItem(String itemName, int itemPrice)
	{
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	@Override
	public String itemName() {
		return itemName;
	}

	@Override
	public int itemPrice() {
		return itemPrice;
	}
}
