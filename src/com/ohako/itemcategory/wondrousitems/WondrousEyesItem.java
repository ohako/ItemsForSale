package com.ohako.itemcategory.wondrousitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousEyesItem extends WondrousItem {

	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousEyesItem>>> specificEyesMap;

	public WondrousEyesItem(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		super(itemDegree, itemDegreeQualifier);
	}
	
	public WondrousEyesItem(String itemName, int itemPrice)
	{
		super(itemName, itemPrice);
	}

	@Override
	public void generateItem() {
		if (specificEyesMap == null)
			specificEyesMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousEyesItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, WondrousEyesItem>> specificEyesMapByDegree = specificEyesMap.get(itemDegree);
		if (specificEyesMapByDegree == null)
		{
			specificEyesMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,WondrousEyesItem>>();
			specificEyesMap.put(itemDegree, specificEyesMapByDegree);
		}
		Map<Integer, WondrousEyesItem> specificEyesMapByDegreeAndQualifier = specificEyesMapByDegree.get(itemDegreeQualifier);
		if (specificEyesMapByDegreeAndQualifier == null)
		{
			specificEyesMapByDegreeAndQualifier = new LinkedHashMap<Integer, WondrousEyesItem>();
			populateSpecificEyesMap(specificEyesMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificEyesMapByDegree.put(itemDegreeQualifier, specificEyesMapByDegreeAndQualifier);
		}
		WondrousEyesItem eyesItem = ItemsForSale.getRandomThing(specificEyesMapByDegreeAndQualifier);
		this.itemName = eyesItem.itemName();
		this.itemPrice = eyesItem.itemPrice();
		this.leafItem = true;
	}

	private void populateSpecificEyesMap(
			Map<Integer, WondrousEyesItem> eyesMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						eyesMap.put(18, new WondrousEyesItem("deathwatch eyes", 2000));
						eyesMap.put(38, new WondrousEyesItem("eyes of the eagle", 2500));
						eyesMap.put(58, new WondrousEyesItem("goggles of minute seeing", 2500));
						eyesMap.put(72, new WondrousEyesItem("pirate's eye patch", 2600));
						eyesMap.put(87, new WondrousEyesItem("spectacles of understanding", 3000));
						eyesMap.put(100, new WondrousEyesItem("lenses of detection", 3500));
						break;
					case GREATER:
						eyesMap.put(20, new WondrousEyesItem("eyes of the owl", 4000));
						eyesMap.put(44, new WondrousEyesItem("eyes of keen sight", 6000));
						eyesMap.put(66, new WondrousEyesItem("treasure hunter's goggles", 6400));
						eyesMap.put(84, new WondrousEyesItem("inquisitor's monocle", 6800));
						eyesMap.put(100, new WondrousEyesItem("kinsight goggles", 7500));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						eyesMap.put(16, new WondrousEyesItem("goggles of elvenkind", 8500));
						eyesMap.put(31, new WondrousEyesItem("goggles of brilliant light", 8800));
						eyesMap.put(48, new WondrousEyesItem("blind man's fold", 12000));
						eyesMap.put(67, new WondrousEyesItem("goggles of night", 12000));
						eyesMap.put(82, new WondrousEyesItem("lenses of figment piercing", 12000));
						eyesMap.put(100, new WondrousEyesItem("arachnid goggles", 15000));
						break;
					case GREATER:
						eyesMap.put(21, new WondrousEyesItem("darklands goggles", 20000));
						eyesMap.put(40, new WondrousEyesItem("sniper goggles", 20000));
						eyesMap.put(58, new WondrousEyesItem("rainbow lenses", 21000));
						eyesMap.put(77, new WondrousEyesItem("annihilation spectacles", 25000));
						eyesMap.put(100, new WondrousEyesItem("eyes of doom", 25000));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						eyesMap.put(60, new WondrousEyesItem("eyes of eyebite", 30000));
						eyesMap.put(100, new WondrousEyesItem("greater sniper goggles", 50000));
						break;
					case GREATER:
						eyesMap.put(18, new WondrousEyesItem("eyes of charming", 56000));
						eyesMap.put(34, new WondrousEyesItem("monocle of the investigator", 66000));
						eyesMap.put(48, new WondrousEyesItem("sea tyrant's patch", 70000));
						eyesMap.put(63, new WondrousEyesItem("swordmaster's blindfold", 80000));
						eyesMap.put(77, new WondrousEyesItem("mindmaster's eyes", 95000));
						eyesMap.put(90, new WondrousEyesItem("eyes of the dragon", 110000));
						eyesMap.put(100, new WondrousEyesItem("truesight goggles", 184800));
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}

	@Override
	public Item copyItem() {
		WondrousEyesItem itemCopy = new WondrousEyesItem(itemDegree, itemDegreeQualifier);
		itemCopy.leafItem = leafItem;
		return itemCopy;
	}
}
