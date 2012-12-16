package com.ohako.itemcategory.wands;

import java.util.Map;

import com.ohako.Item;
import com.ohako.itemcategory.ItemCategory;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WandsItemCategory extends ItemCategory 
{
	public WandsItemCategory(ItemDegree itemDegree) 
	{
		super(itemDegree);
	}

	@Override
	public void populateItemMap(Map<Integer, Item> qualifiedDegreeItemMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) 
	{
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(40, new WandItem(0));
						qualifiedDegreeItemMap.put(100, new WandItem(1));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(80, new WandItem(1));
						qualifiedDegreeItemMap.put(100, new WandItem(2));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(75, new WandItem(2));
						qualifiedDegreeItemMap.put(100, new WandItem(3));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(20, new WandItem(2));
						qualifiedDegreeItemMap.put(80, new WandItem(3)); //wha??
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(60, new WandItem(3));
						qualifiedDegreeItemMap.put(100, new WandItem(4));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(30, new WandItem(3));
						qualifiedDegreeItemMap.put(100, new WandItem(4));
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}
}
