package com.ohako.itemcategory.wondrousitems;

import java.util.Map;

import com.ohako.Item;
import com.ohako.itemcategory.ItemCategory;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousItemCategory extends ItemCategory 
{
	public WondrousItemCategory(ItemDegree itemDegree) 
	{
		super(itemDegree);
	}

	@Override
	public void populateItemMap(Map<Integer, Item> qualifiedDegreeItemMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		qualifiedDegreeItemMap.put(6, new WondrousBeltItem(itemDegree, itemDegreeQualifier));
		qualifiedDegreeItemMap.put(12, new WondrousBodyItem(itemDegree, itemDegreeQualifier));
		qualifiedDegreeItemMap.put(17, new WondrousChestItem(itemDegree, itemDegreeQualifier));
		qualifiedDegreeItemMap.put(22, new WondrousEyesItem(itemDegree, itemDegreeQualifier));
		qualifiedDegreeItemMap.put(28, new WondrousFeetItem(itemDegree, itemDegreeQualifier));
		qualifiedDegreeItemMap.put(34, new WondrousHandsItem(itemDegree, itemDegreeQualifier));
		qualifiedDegreeItemMap.put(41, new WondrousHeadItem(itemDegree, itemDegreeQualifier));
		qualifiedDegreeItemMap.put(47, new WondrousHeadbandItem(itemDegree, itemDegreeQualifier));
		qualifiedDegreeItemMap.put(54, new WondrousNeckItem(itemDegree, itemDegreeQualifier));
		qualifiedDegreeItemMap.put(61, new WondrousShouldersItem(itemDegree, itemDegreeQualifier));
		qualifiedDegreeItemMap.put(67, new WondrousWristItem(itemDegree, itemDegreeQualifier));
		qualifiedDegreeItemMap.put(100, new WondrousSlotlessItem(itemDegree)); 
	}
}
