package com.ohako.itemcategory.wondrousitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousWristItem extends WondrousItem {

	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousWristItem>>> specificWristMap;

	public WondrousWristItem(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		super(itemDegree, itemDegreeQualifier);
	}
	
	public WondrousWristItem(String itemName, int itemPrice)
	{
		super(itemName, itemPrice);
	}

	@Override
	public void generateItem() {
		if (specificWristMap == null)
			specificWristMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousWristItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, WondrousWristItem>> specificWristMapByDegree = specificWristMap.get(itemDegree);
		if (specificWristMapByDegree == null)
		{
			specificWristMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,WondrousWristItem>>();
			specificWristMap.put(itemDegree, specificWristMapByDegree);
		}
		Map<Integer, WondrousWristItem> specificWristMapByDegreeAndQualifier = specificWristMapByDegree.get(itemDegreeQualifier);
		if (specificWristMapByDegreeAndQualifier == null)
		{
			specificWristMapByDegreeAndQualifier = new LinkedHashMap<Integer, WondrousWristItem>();
			populateSpecificWristMap(specificWristMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificWristMapByDegree.put(itemDegreeQualifier, specificWristMapByDegreeAndQualifier);
		}
		WondrousWristItem wristItem = ItemsForSale.getRandomThing(specificWristMapByDegreeAndQualifier);
		this.itemName = wristItem.itemName();
		this.itemPrice = wristItem.itemPrice();
		this.leafItem = true;
	}

	private void populateSpecificWristMap(
			Map<Integer, WondrousWristItem> wristMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						wristMap.put(10, new WondrousWristItem("sleeves of many garments", 200));
						wristMap.put(20, new WondrousWristItem("armbands of the brawler", 500));
						wristMap.put(48, new WondrousWristItem("bracers of armor +1", 1000));
						wristMap.put(63, new WondrousWristItem("burglar's bracers", 1000));
						wristMap.put(91, new WondrousWristItem("bracers of steadiness", 2000));
						wristMap.put(96, new WondrousWristItem("manacles of cooperation", 2000));
						wristMap.put(100, new WondrousWristItem("shackles of compliance", 3280));
						break;
					case GREATER: 
						wristMap.put(27, new WondrousWristItem("bracers of armor +2", 4000));
						wristMap.put(28, new WondrousWristItem("bracers of falcon's aim", 4000));
						wristMap.put(38, new WondrousWristItem("inquisitor's bastion vambraces", 4000));
						wristMap.put(65, new WondrousWristItem("lesser bracers of archery", 5000));
						wristMap.put(68, new WondrousWristItem("spellguard bracers", 5000));
						wristMap.put(71, new WondrousWristItem("bonebreaker gauntlets", 6000));
						wristMap.put(81, new WondrousWristItem("vambraces of defense", 6000));
						wristMap.put(98, new WondrousWristItem("verdant vine", 6000));
						wristMap.put(99, new WondrousWristItem("longarm bracers", 7200));
						wristMap.put(100, new WondrousWristItem("bracers of the glib entertainer", 7900));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						wristMap.put(4, new WondrousWristItem("charm bracelet", 8000));
						wristMap.put(8, new WondrousWristItem("duelist's vambraces", 8000));
						wristMap.put(13, new WondrousWristItem("merciful vambraces", 8000));
						wristMap.put(18, new WondrousWristItem("vambraces of the tactician", 8000));
						wristMap.put(43, new WondrousWristItem("bracers of armor +3", 9000));
						wristMap.put(53, new WondrousWristItem("seducer's bane", 9900));
						wristMap.put(58, new WondrousWristItem("bracers of the avenging knight", 11500));
						wristMap.put(63, new WondrousWristItem("arrowmaster's bracers", 13900));
						wristMap.put(73, new WondrousWristItem("vambraces of the efreeti", 14400));
						wristMap.put(78, new WondrousWristItem("bracelet of bargaining", 14500));
						wristMap.put(82, new WondrousWristItem("bracelet of mercy", 15000));
						wristMap.put(86, new WondrousWristItem("bracers of the merciful knight", 15600));
						wristMap.put(90, new WondrousWristItem("bracelet of second chances", 15750));
						wristMap.put(99, new WondrousWristItem("bracers of armor +4", 16000));
						wristMap.put(100, new WondrousWristItem("shackles of durance vile", 16200));
						break;
					case GREATER:
						wristMap.put(10, new WondrousWristItem("vambraces of the djinni", 18900));
						wristMap.put(20, new WondrousWristItem("vambraces of the marid", 18900));
						wristMap.put(30, new WondrousWristItem("vambraces of the shaitan", 18900));
						wristMap.put(50, new WondrousWristItem("bracelet of friends", 19000));
						wristMap.put(70, new WondrousWristItem("greater bracers of archery", 25000));
						wristMap.put(90, new WondrousWristItem("bracers of armor +5", 25000));
						wristMap.put(100, new WondrousWristItem("bracers of swarm vengeance", 25000));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						wristMap.put(30, new WondrousWristItem("dimensional shackles", 28000));
						wristMap.put(45, new WondrousWristItem("gauntlets of skill at arms", 30000));
						wristMap.put(100, new WondrousWristItem("bracers of armor +6", 36000));
						break;
					case GREATER:
						wristMap.put(60, new WondrousWristItem("bracers of armor +7", 49000));
						wristMap.put(100, new WondrousWristItem("bracers of armor +8", 64000));
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
		WondrousWristItem itemCopy = new WondrousWristItem(itemDegree, itemDegreeQualifier);
		itemCopy.leafItem = leafItem;
		return itemCopy;
	}
}
