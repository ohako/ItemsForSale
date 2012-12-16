package com.ohako.itemcategory.wondrousitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousHeadbandItem extends WondrousItem {

	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousHeadbandItem>>> specificHeadbandMap;

	public WondrousHeadbandItem(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		super(itemDegree, itemDegreeQualifier);
	}
	
	public WondrousHeadbandItem(String itemName, int itemPrice)
	{
		super(itemName, itemPrice);
	}

	@Override
	public void generateItem() {
		if (specificHeadbandMap == null)
			specificHeadbandMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousHeadbandItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, WondrousHeadbandItem>> specificHeadbandMapByDegree = specificHeadbandMap.get(itemDegree);
		if (specificHeadbandMapByDegree == null)
		{
			specificHeadbandMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,WondrousHeadbandItem>>();
			specificHeadbandMap.put(itemDegree, specificHeadbandMapByDegree);
		}
		Map<Integer, WondrousHeadbandItem> specificHeadbandMapByDegreeAndQualifier = specificHeadbandMapByDegree.get(itemDegreeQualifier);
		if (specificHeadbandMapByDegreeAndQualifier == null)
		{
			specificHeadbandMapByDegreeAndQualifier = new LinkedHashMap<Integer, WondrousHeadbandItem>();
			populateSpecificHeadbandMap(specificHeadbandMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificHeadbandMapByDegree.put(itemDegreeQualifier, specificHeadbandMapByDegreeAndQualifier);
		}
		WondrousHeadbandItem headbandItem = ItemsForSale.getRandomThing(specificHeadbandMapByDegreeAndQualifier);
		this.itemName = headbandItem.itemName();
		this.itemPrice = headbandItem.itemPrice();
		this.leafItem = true;
	}

	private void populateSpecificHeadbandMap(
			Map<Integer, WondrousHeadbandItem> headbandMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						headbandMap.put(60, new WondrousHeadbandItem("phylactery of faithfulness", 1000));
						headbandMap.put(100, new WondrousHeadbandItem("dead man's headband", 3600));
						break;
					case GREATER: //TODO: pick skill associated with intelligence headband
						//TODO: pick ability scores boosted by +stat items
						headbandMap.put(9, new WondrousHeadbandItem("headband of alluring charisma +2", 4000));
						headbandMap.put(18, new WondrousHeadbandItem("headband of inspired wisdom +2", 4000));
						headbandMap.put(27, new WondrousHeadbandItem("headband of vast intelligence +2", 4000));
						headbandMap.put(33, new WondrousHeadbandItem("headband of aerial agility +2", 4500));
						headbandMap.put(39, new WondrousHeadbandItem("shifter's headband", 4500));
						headbandMap.put(45, new WondrousHeadbandItem("headband of ponderous recollection", 5100));
						headbandMap.put(51, new WondrousHeadbandItem("headband of ki focus", 5400));
						headbandMap.put(58, new WondrousHeadbandItem("headband of unshakeable resolve", 5600));
						headbandMap.put(66, new WondrousHeadbandItem("hollywreath band", 5700));
						headbandMap.put(74, new WondrousHeadbandItem("headband of deathless devotion", 6400));
						headbandMap.put(82, new WondrousHeadbandItem("phylactery of the shepherd", 7000));
						headbandMap.put(91, new WondrousHeadbandItem("headband of intuition", 7000));
						headbandMap.put(100, new WondrousHeadbandItem("headband of fortune's favor", 7700));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						headbandMap.put(6, new WondrousHeadbandItem("headband of havoc", 8000));
						headbandMap.put(12, new WondrousHeadbandItem("serpent's band", 9000));
						headbandMap.put(20, new WondrousHeadbandItem("headband of mental prowess +2", 10000));
						headbandMap.put(26, new WondrousHeadbandItem("hunter's band", 11000));
						headbandMap.put(34, new WondrousHeadbandItem("phylactery of negative channeling", 11000));
						headbandMap.put(42, new WondrousHeadbandItem("phylactery of positive channeling", 11000));
						headbandMap.put(48, new WondrousHeadbandItem("veiled eye", 12000));
						headbandMap.put(54, new WondrousHeadbandItem("band of the stalwart warrior", 14000));
						headbandMap.put(60, new WondrousHeadbandItem("headband of ninjitsu", 15000));
						headbandMap.put(68, new WondrousHeadbandItem("headband of alluring charisma +4", 16000));
						headbandMap.put(76, new WondrousHeadbandItem("headband of inspired wisdom +4", 16000));
						headbandMap.put(85, new WondrousHeadbandItem("headband of mental superiority +2", 16000));
						headbandMap.put(93, new WondrousHeadbandItem("headband of vast intelligence +4", 16000));
						headbandMap.put(100, new WondrousHeadbandItem("shifter's headband +4", 17500));
						break;
					case GREATER:
						headbandMap.put(30, new WondrousHeadbandItem("headband of arcane energy", 20000));
						headbandMap.put(70, new WondrousHeadbandItem("headband of counterspelling", 20000));
						headbandMap.put(100, new WondrousHeadbandItem("headband of knucklebones", 27500));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						headbandMap.put(9, new WondrousHeadbandItem("soulbound eye", 30000));
						headbandMap.put(19, new WondrousHeadbandItem("winter wolf headband", 32000));
						headbandMap.put(32, new WondrousHeadbandItem("headband of alluring charisma +6", 36000));
						headbandMap.put(45, new WondrousHeadbandItem("headband of inspired wisdom +6", 36000));
						headbandMap.put(58, new WondrousHeadbandItem("headband of vast intelligence +6", 36000));
						headbandMap.put(66, new WondrousHeadbandItem("shifter's headband +6", 39000));
						headbandMap.put(81, new WondrousHeadbandItem("headband of mental prowess +4", 40000));
						headbandMap.put(90, new WondrousHeadbandItem("headband of seduction", 40000));
						headbandMap.put(100, new WondrousHeadbandItem("headband of aerial agility +4", 42000));
						break;
					case GREATER:
						headbandMap.put(20, new WondrousHeadbandItem("headband of mental resilience", 64000));
						headbandMap.put(50, new WondrousHeadbandItem("headband of mental superiority +4", 64000));
						headbandMap.put(65, new WondrousHeadbandItem("headband of aerial agility +6", 81000));
						headbandMap.put(85, new WondrousHeadbandItem("headband of mental prowess +6", 90000));
						headbandMap.put(100, new WondrousHeadbandItem("headband of mental superiority +6", 144000));
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
		WondrousHeadbandItem itemCopy = new WondrousHeadbandItem(itemDegree, itemDegreeQualifier);
		itemCopy.leafItem = leafItem;
		return itemCopy;
	}
}
