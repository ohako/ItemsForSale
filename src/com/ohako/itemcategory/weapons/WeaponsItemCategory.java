package com.ohako.itemcategory.weapons;

import java.util.Map;

import com.ohako.Item;
import com.ohako.itemcategory.ItemCategory;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WeaponsItemCategory extends ItemCategory 
{
	public WeaponsItemCategory(ItemDegree itemDegree) 
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
						qualifiedDegreeItemMap.put(80, new MeleeOrRangedItem(1));
						qualifiedDegreeItemMap.put(100, new MeleeOrRangedItem(itemDegree, itemDegreeQualifier));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(26, new MeleeOrRangedItem(1));
						qualifiedDegreeItemMap.put(53, new MeleeOrRangedItem(2));
						qualifiedDegreeItemMap.put(80, new MeleeOrRangedItem(1, 1));
						qualifiedDegreeItemMap.put(100, new MeleeOrRangedItem(itemDegree, itemDegreeQualifier));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(10, new MeleeOrRangedItem(1));
						qualifiedDegreeItemMap.put(20, new MeleeOrRangedItem(2));
						qualifiedDegreeItemMap.put(32, new MeleeOrRangedItem(3));
						qualifiedDegreeItemMap.put(44, new MeleeOrRangedItem(1, 1));
						qualifiedDegreeItemMap.put(56, new MeleeOrRangedItem(1, 1, 1));
						qualifiedDegreeItemMap.put(68, new MeleeOrRangedItem(1, 2));
						qualifiedDegreeItemMap.put(80, new MeleeOrRangedItem(2, 1));
						qualifiedDegreeItemMap.put(100, new MeleeOrRangedItem(itemDegree, itemDegreeQualifier));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(10, new MeleeOrRangedItem(2));
						qualifiedDegreeItemMap.put(20, new MeleeOrRangedItem(3));
						qualifiedDegreeItemMap.put(32, new MeleeOrRangedItem(1, 1));
						qualifiedDegreeItemMap.put(44, new MeleeOrRangedItem(1, 2));
						qualifiedDegreeItemMap.put(56, new MeleeOrRangedItem(2, 1));
						qualifiedDegreeItemMap.put(68, new MeleeOrRangedItem(2, 2));
						qualifiedDegreeItemMap.put(80, new MeleeOrRangedItem(3, 1));
						qualifiedDegreeItemMap.put(100, new MeleeOrRangedItem(itemDegree, itemDegreeQualifier));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(10, new MeleeOrRangedItem(3));
						qualifiedDegreeItemMap.put(20, new MeleeOrRangedItem(4));
						qualifiedDegreeItemMap.put(32, new MeleeOrRangedItem(1, 2));
						qualifiedDegreeItemMap.put(44, new MeleeOrRangedItem(1, 3));
						qualifiedDegreeItemMap.put(56, new MeleeOrRangedItem(2, 2));
						qualifiedDegreeItemMap.put(68, new MeleeOrRangedItem(3, 1));
						qualifiedDegreeItemMap.put(80, new MeleeOrRangedItem(4, 1));
						qualifiedDegreeItemMap.put(100, new MeleeOrRangedItem(itemDegree, itemDegreeQualifier));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(10, new MeleeOrRangedItem(4));
						qualifiedDegreeItemMap.put(20, new MeleeOrRangedItem(5));
						qualifiedDegreeItemMap.put(30, new MeleeOrRangedItem(4, 1));
						qualifiedDegreeItemMap.put(38, new MeleeOrRangedItem(4, 2));
						qualifiedDegreeItemMap.put(46, new MeleeOrRangedItem(4, 3));
						qualifiedDegreeItemMap.put(51, new MeleeOrRangedItem(4, 4));
						qualifiedDegreeItemMap.put(59, new MeleeOrRangedItem(5, 1));
						qualifiedDegreeItemMap.put(67, new MeleeOrRangedItem(5, 2));
						qualifiedDegreeItemMap.put(71, new MeleeOrRangedItem(5, 3));
						qualifiedDegreeItemMap.put(74, new MeleeOrRangedItem(5, 4));
						qualifiedDegreeItemMap.put(77, new MeleeOrRangedItem(5, 4, 1));
						qualifiedDegreeItemMap.put(80, new MeleeOrRangedItem(5, 3, 2));
						qualifiedDegreeItemMap.put(100, new MeleeOrRangedItem(itemDegree, itemDegreeQualifier));
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
