package com.ohako.itemcategory.armorandshields;

import java.util.Map;

import com.ohako.Item;
import com.ohako.itemcategory.ItemCategory;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class ArmorAndShieldsItemCategory extends ItemCategory 
{

	public ArmorAndShieldsItemCategory(ItemDegree itemDegree) 
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
						qualifiedDegreeItemMap.put(80, new ArmorOrShieldItem(1));
						qualifiedDegreeItemMap.put(100, new ArmorOrShieldItem(itemDegree, itemDegreeQualifier));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(26, new ArmorOrShieldItem(1));
						qualifiedDegreeItemMap.put(53, new ArmorOrShieldItem(2));
						qualifiedDegreeItemMap.put(80, new ArmorOrShieldItem(1, 1));
						qualifiedDegreeItemMap.put(100, new ArmorOrShieldItem(itemDegree, itemDegreeQualifier));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(10, new ArmorOrShieldItem(1));
						qualifiedDegreeItemMap.put(20, new ArmorOrShieldItem(2));
						qualifiedDegreeItemMap.put(32, new ArmorOrShieldItem(3));
						qualifiedDegreeItemMap.put(44, new ArmorOrShieldItem(1, 1));
						qualifiedDegreeItemMap.put(56, new ArmorOrShieldItem(1, 1, 1));						
						qualifiedDegreeItemMap.put(68, new ArmorOrShieldItem(1, 2));
						qualifiedDegreeItemMap.put(80, new ArmorOrShieldItem(2, 1));
						qualifiedDegreeItemMap.put(100, new ArmorOrShieldItem(itemDegree, itemDegreeQualifier));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(10, new ArmorOrShieldItem(2));
						qualifiedDegreeItemMap.put(22, new ArmorOrShieldItem(3));
						qualifiedDegreeItemMap.put(32, new ArmorOrShieldItem(1, 1));
						qualifiedDegreeItemMap.put(44, new ArmorOrShieldItem(1, 2));
						qualifiedDegreeItemMap.put(56, new ArmorOrShieldItem(2, 1));
						qualifiedDegreeItemMap.put(68, new ArmorOrShieldItem(2, 2));
						qualifiedDegreeItemMap.put(80, new ArmorOrShieldItem(3, 1));
						qualifiedDegreeItemMap.put(100, new ArmorOrShieldItem(itemDegree, itemDegreeQualifier));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(10, new ArmorOrShieldItem(3));
						qualifiedDegreeItemMap.put(22, new ArmorOrShieldItem(4));
						qualifiedDegreeItemMap.put(32, new ArmorOrShieldItem(1, 2));
						qualifiedDegreeItemMap.put(44, new ArmorOrShieldItem(1, 3));
						qualifiedDegreeItemMap.put(56, new ArmorOrShieldItem(2, 2));
						qualifiedDegreeItemMap.put(68, new ArmorOrShieldItem(3, 1));
						qualifiedDegreeItemMap.put(80, new ArmorOrShieldItem(1, 1));
						qualifiedDegreeItemMap.put(100, new ArmorOrShieldItem(itemDegree, itemDegreeQualifier));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(10, new ArmorOrShieldItem(4));
						qualifiedDegreeItemMap.put(20, new ArmorOrShieldItem(5));
						qualifiedDegreeItemMap.put(30, new ArmorOrShieldItem(4, 1));
						qualifiedDegreeItemMap.put(38, new ArmorOrShieldItem(4, 2));
						qualifiedDegreeItemMap.put(46, new ArmorOrShieldItem(4, 3));
						qualifiedDegreeItemMap.put(51, new ArmorOrShieldItem(4, 4));
						qualifiedDegreeItemMap.put(59, new ArmorOrShieldItem(5, 1));
						qualifiedDegreeItemMap.put(67, new ArmorOrShieldItem(5, 2));
						qualifiedDegreeItemMap.put(71, new ArmorOrShieldItem(5, 3));
						qualifiedDegreeItemMap.put(74, new ArmorOrShieldItem(5, 2, 2));
						qualifiedDegreeItemMap.put(77, new ArmorOrShieldItem(5, 4));
						qualifiedDegreeItemMap.put(80, new ArmorOrShieldItem(5, 5));
						qualifiedDegreeItemMap.put(100, new ArmorOrShieldItem(itemDegree, itemDegreeQualifier));
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
