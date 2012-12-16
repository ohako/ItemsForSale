package com.ohako.itemcategory.wondrousitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousChestItem extends WondrousItem {

	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousChestItem>>> specificChestMap;

	public WondrousChestItem(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		super(itemDegree, itemDegreeQualifier);
	}
	
	public WondrousChestItem(String itemName, int itemPrice)
	{
		super(itemName, itemPrice);
	}

	@Override
	public void generateItem() {
		if (specificChestMap == null)
			specificChestMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousChestItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, WondrousChestItem>> specificChestMapByDegree = specificChestMap.get(itemDegree);
		if (specificChestMapByDegree == null)
		{
			specificChestMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,WondrousChestItem>>();
			specificChestMap.put(itemDegree, specificChestMapByDegree);
		}
		Map<Integer, WondrousChestItem> specificChestMapByDegreeAndQualifier = specificChestMapByDegree.get(itemDegreeQualifier);
		if (specificChestMapByDegreeAndQualifier == null)
		{
			specificChestMapByDegreeAndQualifier = new LinkedHashMap<Integer, WondrousChestItem>();
			populateSpecificchestMap(specificChestMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificChestMapByDegree.put(itemDegreeQualifier, specificChestMapByDegreeAndQualifier);
		}
		WondrousChestItem chestItem = ItemsForSale.getRandomThing(specificChestMapByDegreeAndQualifier);
		this.itemName = chestItem.itemName();
		this.itemPrice = chestItem.itemPrice();
		this.leafItem = true;
	}

	private void populateSpecificchestMap(
			Map<Integer, WondrousChestItem> chestMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						chestMap.put(15, new WondrousChestItem("bandages of rapid recovery", 200));
						chestMap.put(30, new WondrousChestItem("quick runner's shirt", 1000));
						chestMap.put(50, new WondrousChestItem("endless bandolier", 1500));
						chestMap.put(75, new WondrousChestItem("all tools vest", 1800));
						chestMap.put(100, new WondrousChestItem("vest of surgery", 3000));
						break;
					case GREATER:
						chestMap.put(10, new WondrousChestItem("sash of the war champion", 4000));
						chestMap.put(20, new WondrousChestItem("sipping jacket", 5000));
						chestMap.put(31, new WondrousChestItem("tunic of careful casting", 5000));
						chestMap.put(42, new WondrousChestItem("vest of escape", 5200));
						chestMap.put(52, new WondrousChestItem("cackling hag's blouse", 6000));
						chestMap.put(62, new WondrousChestItem("deadshot vest", 6000));
						chestMap.put(70, new WondrousChestItem("prophet's pectoral", 6000));
						chestMap.put(79, new WondrousChestItem("tunic of deadly might", 6000));
						chestMap.put(90, new WondrousChestItem("vest of the vengeful tracker", 6000));
						chestMap.put(100, new WondrousChestItem("resplendent uniform coat", 7000));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						chestMap.put(13, new WondrousChestItem("shirt of immolation", 8000));
						chestMap.put(28, new WondrousChestItem("snakeskin tunic", 8000));
						chestMap.put(40, new WondrousChestItem("bane baldric", 10000));
						chestMap.put(60, new WondrousChestItem("unfettered shirt", 10000));
						chestMap.put(80, new WondrousChestItem("lesser poisoner's jacket", 12000));
						chestMap.put(100, new WondrousChestItem("vest of the cockroach", 16000));
						break;
					case GREATER:
						chestMap.put(50, new WondrousChestItem("vest of stable mutation", 20000));
						chestMap.put(100, new WondrousChestItem("spectral shroud", 26000));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						chestMap.put(60, new WondrousChestItem("mantle of immortality", 50000));
						chestMap.put(100, new WondrousChestItem("greater poisoner's jacket", 58000));
						break;
					case GREATER:
						chestMap.put(35, new WondrousChestItem("merciful baldric", 60000));
						chestMap.put(70, new WondrousChestItem("mantle of faith", 76000));
						chestMap.put(100, new WondrousChestItem("mantle of spell resistance", 90000));
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
		WondrousChestItem itemCopy = new WondrousChestItem(itemDegree, itemDegreeQualifier);
		itemCopy.leafItem = leafItem;
		return itemCopy;
	}
}
