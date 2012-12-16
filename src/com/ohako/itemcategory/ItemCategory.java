package com.ohako.itemcategory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemcategory.wondrousitems.WondrousSlotlessItem;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public abstract class ItemCategory 
{
	protected ItemDegree itemDegree;
	protected Map<Integer, ItemDegreeQualifier> itemDegreeQualifierMap;
	protected Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, Item>>> itemMap;
		
	public ItemCategory(ItemDegree itemDegree)
	{
		this.itemDegree = itemDegree;
	}
	
	public static Item generateItem(ItemDegree itemDegree, int economyModifier) 
	{
		Map<Integer, ItemCategory> itemCategoryMap = itemDegree.getItemCategoryMap();
		ItemCategory itemCategory = ItemsForSale.getRandomThing(itemCategoryMap);
		return itemCategory.generateItem(economyModifier);
	}
	
	public Map<Integer, Item> getQualifiedDegreeItemMap(ItemDegreeQualifier itemDegreeQualifier)
	{
		if (itemMap == null)
		{
			itemMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, Item>>>();
		}
		Map<ItemDegreeQualifier, Map<Integer, Item>> degreeItemMap = itemMap.get(itemDegree);
		if (degreeItemMap == null)
		{
			degreeItemMap = new HashMap<ItemDegreeQualifier, Map<Integer,Item>>();
			itemMap.put(itemDegree, degreeItemMap);
		}
		Map<Integer, Item> qualifiedDegreeItemMap = degreeItemMap.get(itemDegreeQualifier);
		if (qualifiedDegreeItemMap == null)
		{
			qualifiedDegreeItemMap = new LinkedHashMap<Integer, Item>();
			degreeItemMap.put(itemDegreeQualifier, qualifiedDegreeItemMap);
		}
		return qualifiedDegreeItemMap;
	}
	
	//good for everything except for slotless wondrous items
	public ItemDegreeQualifier getItemDegreeQualifier(int economyModifier) 
	{
		if (itemDegreeQualifierMap == null)
		{
			itemDegreeQualifierMap = new LinkedHashMap<Integer, ItemDegreeQualifier>();
			itemDegreeQualifierMap.put(50, ItemDegreeQualifier.LESSER);
			itemDegreeQualifierMap.put(100, ItemDegreeQualifier.GREATER);
		}
		return ItemsForSale.getRandomThing(itemDegreeQualifierMap, economyModifier);
	}
	
	public Item generateItem(int economyModifier)
	{
		ItemDegreeQualifier itemDegreeQualifier = getItemDegreeQualifier(economyModifier);
		Map<Integer, Item> qualifiedDegreeItemMap = getQualifiedDegreeItemMap(itemDegreeQualifier);
		if (qualifiedDegreeItemMap.isEmpty())
			populateItemMap(qualifiedDegreeItemMap, itemDegree, itemDegreeQualifier);
		Item item = ItemsForSale.getRandomThing(qualifiedDegreeItemMap);
		Item itemCopy = item.copyItem();
		if (itemCopy instanceof WondrousSlotlessItem)
			((WondrousSlotlessItem) itemCopy).setEconomyModifier(economyModifier);
		while (!itemCopy.isLeafItem())
			itemCopy.generateItem();
		return itemCopy;		
	}
	
	public abstract void populateItemMap(Map<Integer, Item> qualifiedDegreeItemMap, ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier);
}
