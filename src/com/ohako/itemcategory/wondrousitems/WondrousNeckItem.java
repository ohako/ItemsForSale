package com.ohako.itemcategory.wondrousitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousNeckItem extends WondrousItem {

	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousNeckItem>>> specificNeckMap;

	public WondrousNeckItem(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		super(itemDegree, itemDegreeQualifier);
	}
	
	public WondrousNeckItem(String itemName, int itemPrice)
	{
		super(itemName, itemPrice);
	}

	@Override
	public void generateItem() {
		if (specificNeckMap == null)
			specificNeckMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousNeckItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, WondrousNeckItem>> specificNeckMapByDegree = specificNeckMap.get(itemDegree);
		if (specificNeckMapByDegree == null)
		{
			specificNeckMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,WondrousNeckItem>>();
			specificNeckMap.put(itemDegree, specificNeckMapByDegree);
		}
		Map<Integer, WondrousNeckItem> specificNeckMapByDegreeAndQualifier = specificNeckMapByDegree.get(itemDegreeQualifier);
		if (specificNeckMapByDegreeAndQualifier == null)
		{
			specificNeckMapByDegreeAndQualifier = new LinkedHashMap<Integer, WondrousNeckItem>();
			populateSpecificNeckMap(specificNeckMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificNeckMapByDegree.put(itemDegreeQualifier, specificNeckMapByDegreeAndQualifier);
		}
		WondrousNeckItem neckItem = ItemsForSale.getRandomThing(specificNeckMapByDegreeAndQualifier);
		this.itemName = neckItem.itemName();
		this.itemPrice = neckItem.itemPrice();
		this.leafItem = true;
	}

	private void populateSpecificNeckMap(
			Map<Integer, WondrousNeckItem> neckMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						neckMap.put(10, new WondrousNeckItem("hand of the mage", 900));
						neckMap.put(18, new WondrousNeckItem("aegis of recovery", 1500));
						neckMap.put(25, new WondrousNeckItem("amulet of bullet protection +1", 1500));
						neckMap.put(37, new WondrousNeckItem("brooch of shielding", 1500));
						neckMap.put(49, new WondrousNeckItem("necklace of fireballs (type I)", 1650));
						neckMap.put(63, new WondrousNeckItem("amulet of natural armor +1", 2000));
						neckMap.put(72, new WondrousNeckItem("golembane scarab", 2500));
						neckMap.put(82, new WondrousNeckItem("necklace of fireballs (type II)", 2700));
						neckMap.put(89, new WondrousNeckItem("swarmbane clasp", 3000));
						neckMap.put(95, new WondrousNeckItem("mind sentinel medallion", 3500));
						neckMap.put(100, new WondrousNeckItem("mummer's ruff", 3500));
						break;
					case GREATER: //TODO figure out how to weaponize amulet of mighty fists
						neckMap.put(8, new WondrousNeckItem("amulet of elemental strife", 4000));
						neckMap.put(15, new WondrousNeckItem("righteous fist amulet", 4000));
						neckMap.put(26, new WondrousNeckItem("necklace of fireballs (type III)", 4350));
						neckMap.put(36, new WondrousNeckItem("amulet of mighty fists +1", 4000)); //errata
						neckMap.put(47, new WondrousNeckItem("necklace of fireballs (type IV)", 5400));
						neckMap.put(55, new WondrousNeckItem("stormlure", 5400));
						neckMap.put(66, new WondrousNeckItem("necklace of fireballs (type V)", 5850));
						neckMap.put(73, new WondrousNeckItem("amulet of bullet protection +2", 6000));
						neckMap.put(81, new WondrousNeckItem("feychild necklace", 6000));
						neckMap.put(89, new WondrousNeckItem("carcanet of detention", 7200));
						neckMap.put(100, new WondrousNeckItem("periapt of health", 7500));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						neckMap.put(8, new WondrousNeckItem("amulet of natural armor +2", 8000));
						neckMap.put(12, new WondrousNeckItem("amulet of proof against petrification", 8000));
						neckMap.put(15, new WondrousNeckItem("everwake amulet", 8000));
						neckMap.put(18, new WondrousNeckItem("gravewatch pendant", 8000));
						neckMap.put(23, new WondrousNeckItem("hand of glory", 8000));
						neckMap.put(26, new WondrousNeckItem("torc of lionheart fury", 8000));
						neckMap.put(33, new WondrousNeckItem("necklace of fireballs (type VI)", 8100));
						neckMap.put(40, new WondrousNeckItem("necklace of fireballs (type VII)", 8700));
						neckMap.put(43, new WondrousNeckItem("amulet of hidden strength", 9000));
						neckMap.put(47, new WondrousNeckItem("necklace of adaptation", 9000));
						neckMap.put(51, new WondrousNeckItem("amulet of spell cunning", 10000));
						neckMap.put(54, new WondrousNeckItem("collar of the true companion", 10000));
						neckMap.put(58, new WondrousNeckItem("frost fist amulet", 10000));
						neckMap.put(63, new WondrousNeckItem("crystal of healing hands", 12000));
						neckMap.put(66, new WondrousNeckItem("guardian gorget", 12000));
						neckMap.put(73, new WondrousNeckItem("medallion of thoughts", 12000));
						neckMap.put(77, new WondrousNeckItem("periapt of protection from curses", 12000));
						neckMap.put(81, new WondrousNeckItem("forge fist amulet", 13000));
						neckMap.put(85, new WondrousNeckItem("amulet of bullet protection +3", 13500));
						neckMap.put(92, new WondrousNeckItem("periapt of wound closure", 15000));
						neckMap.put(95, new WondrousNeckItem("necklace of ki serenity", 16000));
						neckMap.put(98, new WondrousNeckItem("brooch of amber sparks", 16800));
						neckMap.put(100, new WondrousNeckItem("symbol of sanguine protection", 17500));
						break;
					case GREATER:
						neckMap.put(15, new WondrousNeckItem("amulet of natural armor +3", 18000));
						neckMap.put(24, new WondrousNeckItem("ampoule of false blood", 20000));
						neckMap.put(35, new WondrousNeckItem("amulet of magecraft", 20000));
						neckMap.put(50, new WondrousNeckItem("amulet of mighty fists +2", 16000)); //errata
						neckMap.put(62, new WondrousNeckItem("dragonfoe amulet", 20000));
						neckMap.put(67, new WondrousNeckItem("amulet of spell mastery", 22000));
						neckMap.put(72, new WondrousNeckItem("amulet of bullet protection +4", 24000));
						neckMap.put(85, new WondrousNeckItem("hand of stone", 27000));
						neckMap.put(100, new WondrousNeckItem("periapt of proof against poison", 27000));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						neckMap.put(18, new WondrousNeckItem("amulet of natural armor +4", 32000));
						neckMap.put(35, new WondrousNeckItem("amulet of proof against detection and location", 35000));
						neckMap.put(49, new WondrousNeckItem("amulet of bullet protection +5", 37500));
						neckMap.put(67, new WondrousNeckItem("scarab of protection", 38000));
						neckMap.put(82, new WondrousNeckItem("necklace of netted stars", 42000));
						neckMap.put(100, new WondrousNeckItem("amulet of mighty fists +3", 36000)); //errata
						break;
					case GREATER:
						neckMap.put(35, new WondrousNeckItem("amulet of natural armor +5", 50000));
						neckMap.put(60, new WondrousNeckItem("amulet of mighty fists +4", 64000)); //errata
						neckMap.put(85, new WondrousNeckItem("amulet of the planes", 120000));
						neckMap.put(100, new WondrousNeckItem("amulet of mighty fists +5", 100000)); //errata
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
		WondrousNeckItem itemCopy = new WondrousNeckItem(itemDegree, itemDegreeQualifier);
		itemCopy.leafItem = leafItem;
		return itemCopy;
	}
}
