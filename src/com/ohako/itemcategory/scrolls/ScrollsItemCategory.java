package com.ohako.itemcategory.scrolls;

import java.util.Map;

import com.ohako.Item;
import com.ohako.itemcategory.ItemCategory;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class ScrollsItemCategory extends ItemCategory 
{
	public ScrollsItemCategory(ItemDegree itemDegree) 
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
						qualifiedDegreeItemMap.put(15, new ScrollItem(0));
						qualifiedDegreeItemMap.put(95, new ScrollItem(1));
						qualifiedDegreeItemMap.put(100, new ScrollItem(2));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(5, new ScrollItem(0));
						qualifiedDegreeItemMap.put(35, new ScrollItem(1));
						qualifiedDegreeItemMap.put(90, new ScrollItem(2));
						qualifiedDegreeItemMap.put(100, new ScrollItem(3));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(10, new ScrollItem(2));
						qualifiedDegreeItemMap.put(55, new ScrollItem(3));
						qualifiedDegreeItemMap.put(100, new ScrollItem(4));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(20, new ScrollItem(3));
						qualifiedDegreeItemMap.put(60, new ScrollItem(4));
						qualifiedDegreeItemMap.put(100, new ScrollItem(5));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(30, new ScrollItem(4));
						qualifiedDegreeItemMap.put(65, new ScrollItem(5));
						qualifiedDegreeItemMap.put(90, new ScrollItem(6));
						qualifiedDegreeItemMap.put(100, new ScrollItem(7));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(5, new ScrollItem(6));
						qualifiedDegreeItemMap.put(35, new ScrollItem(7));
						qualifiedDegreeItemMap.put(70, new ScrollItem(8));
						qualifiedDegreeItemMap.put(100, new ScrollItem(9));
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
