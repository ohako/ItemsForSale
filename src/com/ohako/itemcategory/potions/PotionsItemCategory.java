package com.ohako.itemcategory.potions;

import java.util.Map;

import com.ohako.Item;
import com.ohako.itemcategory.ItemCategory;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class PotionsItemCategory extends ItemCategory 
{
	public PotionsItemCategory(ItemDegree itemDegree) 
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
						qualifiedDegreeItemMap.put(40, new PotionItem(0));
						qualifiedDegreeItemMap.put(100, new PotionItem(1));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(10, new PotionItem(0));
						qualifiedDegreeItemMap.put(60, new PotionItem(1));
						qualifiedDegreeItemMap.put(100, new PotionItem(2));						
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(25, new PotionItem(1));
						qualifiedDegreeItemMap.put(85, new PotionItem(2));
						qualifiedDegreeItemMap.put(100, new PotionItem(3));						
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(10, new PotionItem(1));
						qualifiedDegreeItemMap.put(50, new PotionItem(2));
						qualifiedDegreeItemMap.put(100, new PotionItem(3));						
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(35, new PotionItem(2));
						qualifiedDegreeItemMap.put(100, new PotionItem(3));						
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(10, new PotionItem(2));
						qualifiedDegreeItemMap.put(100, new PotionItem(3));						
						break;
					default:
						break;
				}
				break;
		}
	}
}
