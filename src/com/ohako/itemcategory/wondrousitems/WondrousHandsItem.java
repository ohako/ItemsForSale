package com.ohako.itemcategory.wondrousitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousHandsItem extends WondrousItem {

	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousHandsItem>>> specificHandsMap;

	public WondrousHandsItem(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		super(itemDegree, itemDegreeQualifier);
	}
	
	public WondrousHandsItem(String itemName, int itemPrice)
	{
		super(itemName, itemPrice);
	}

	@Override
	public void generateItem() {
		if (specificHandsMap == null)
			specificHandsMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousHandsItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, WondrousHandsItem>> specificHandsMapByDegree = specificHandsMap.get(itemDegree);
		if (specificHandsMapByDegree == null)
		{
			specificHandsMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,WondrousHandsItem>>();
			specificHandsMap.put(itemDegree, specificHandsMapByDegree);
		}
		Map<Integer, WondrousHandsItem> specificHandsMapByDegreeAndQualifier = specificHandsMapByDegree.get(itemDegreeQualifier);
		if (specificHandsMapByDegreeAndQualifier == null)
		{
			specificHandsMapByDegreeAndQualifier = new LinkedHashMap<Integer, WondrousHandsItem>();
			populateSpecificHandsMap(specificHandsMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificHandsMapByDegree.put(itemDegreeQualifier, specificHandsMapByDegreeAndQualifier);
		}
		WondrousHandsItem handsItem = ItemsForSale.getRandomThing(specificHandsMapByDegreeAndQualifier);
		this.itemName = handsItem.itemName();
		this.itemPrice = handsItem.itemPrice();
		this.leafItem = true;
	}

	private void populateSpecificHandsMap(
			Map<Integer, WondrousHandsItem> handsMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						handsMap.put(13, new WondrousHandsItem("assisting gloves", 180));
						handsMap.put(22, new WondrousHandsItem("claws of the ice bear", 1300));
						handsMap.put(34, new WondrousHandsItem("gloves of reconnaissance", 2000));
						handsMap.put(46, new WondrousHandsItem("glowing glove", 2000));
						handsMap.put(58, new WondrousHandsItem("apprentice's cheating gloves", 2200));
						handsMap.put(70, new WondrousHandsItem("challenger's gloves", 2200));
						handsMap.put(80, new WondrousHandsItem("gloves of larceny", 2500));
						handsMap.put(90, new WondrousHandsItem("healer's gloves", 2500));
						handsMap.put(100, new WondrousHandsItem("engineer's workgloves", 3000));
						break;
					case GREATER: //TODO make a way to choose a manuever for the gauntlets
						handsMap.put(12, new WondrousHandsItem("gauntlets of the skilled manuever", 4000));
						handsMap.put(21, new WondrousHandsItem("ghostvision gloves", 4000));
						handsMap.put(33, new WondrousHandsItem("gloves of arrow snaring", 4000));
						handsMap.put(43, new WondrousHandsItem("trapspringer's gloves", 4000));
						handsMap.put(55, new WondrousHandsItem("gloves of arcane striking", 5000));
						handsMap.put(65, new WondrousHandsItem("poisoner's gloves", 5000));
						handsMap.put(75, new WondrousHandsItem("magnetist's gloves", 6000));
						handsMap.put(100, new WondrousHandsItem("gloves of swimming and climbing", 6250));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						handsMap.put(2, new WondrousHandsItem("deliquescent gloves", 8000));
						handsMap.put(5, new WondrousHandsItem("form-fixing gauntlets", 8000));
						handsMap.put(8, new WondrousHandsItem("iron cobra gauntlet", 8000));
						handsMap.put(16, new WondrousHandsItem("shadow falconer's gloves", 8000));
						handsMap.put(20, new WondrousHandsItem("spellstrike gloves", 8000));
						handsMap.put(28, new WondrousHandsItem("glyphbane gloves", 9000));
						handsMap.put(40, new WondrousHandsItem("glove of storing", 10000));
						handsMap.put(46, new WondrousHandsItem("gloves of shaping", 10000));
						handsMap.put(54, new WondrousHandsItem("pliant gloves", 10000));
						handsMap.put(76, new WondrousHandsItem("gauntlet of rust", 11500));
						handsMap.put(100, new WondrousHandsItem("gloves of dueling", 15000));
						break;
					case GREATER:
						handsMap.put(30, new WondrousHandsItem("vampiric gloves", 18000));
						handsMap.put(65, new WondrousHandsItem("giant fist gauntlets", 20000));
						handsMap.put(100, new WondrousHandsItem("gloves of the shortened path", 27000));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						handsMap.put(40, new WondrousHandsItem("gloves of the commanding connjurer", 40000));
						handsMap.put(100, new WondrousHandsItem("greater gauntlet of rust", 34500));
						break;
					case GREATER:
						handsMap.put(60, new WondrousHandsItem("talons of Leng", 67000));
						handsMap.put(100, new WondrousHandsItem("gauntlets of the weaponmaster", 110000));
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
		WondrousHandsItem itemCopy = new WondrousHandsItem(itemDegree, itemDegreeQualifier);
		itemCopy.leafItem = leafItem;
		return itemCopy;
	}
}
