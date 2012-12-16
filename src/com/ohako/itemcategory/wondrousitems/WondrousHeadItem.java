package com.ohako.itemcategory.wondrousitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousHeadItem extends WondrousItem {

	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousHeadItem>>> specificHeadMap;

	public WondrousHeadItem(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		super(itemDegree, itemDegreeQualifier);
	}
	
	public WondrousHeadItem(String itemName, int itemPrice)
	{
		super(itemName, itemPrice);
	}

	@Override
	public void generateItem() {
		if (specificHeadMap == null)
			specificHeadMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousHeadItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, WondrousHeadItem>> specificHeadMapByDegree = specificHeadMap.get(itemDegree);
		if (specificHeadMapByDegree == null)
		{
			specificHeadMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,WondrousHeadItem>>();
			specificHeadMap.put(itemDegree, specificHeadMapByDegree);
		}
		Map<Integer, WondrousHeadItem> specificHeadMapByDegreeAndQualifier = specificHeadMapByDegree.get(itemDegreeQualifier);
		if (specificHeadMapByDegreeAndQualifier == null)
		{
			specificHeadMapByDegreeAndQualifier = new LinkedHashMap<Integer, WondrousHeadItem>();
			populateSpecificHeadMap(specificHeadMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificHeadMapByDegree.put(itemDegreeQualifier, specificHeadMapByDegreeAndQualifier);
		}
		WondrousHeadItem headItem = ItemsForSale.getRandomThing(specificHeadMapByDegreeAndQualifier);
		this.itemName = headItem.itemName();
		this.itemPrice = headItem.itemPrice();
		this.leafItem = true;
	}

	private void populateSpecificHeadMap(
			Map<Integer, WondrousHeadItem> headMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						headMap.put(10, new WondrousHeadItem("mask of stony demeanor", 500));
						headMap.put(22, new WondrousHeadItem("cap of human guise", 800));
						headMap.put(36, new WondrousHeadItem("cap of light", 900));
						headMap.put(56, new WondrousHeadItem("hat of disguise", 1800));
						headMap.put(71, new WondrousHeadItem("buffering cap", 2000));
						headMap.put(85, new WondrousHeadItem("miser's mask", 3000));
						headMap.put(100, new WondrousHeadItem("stalker's mask", 3500));
						break;
					case GREATER:
						headMap.put(12, new WondrousHeadItem("circlet of persuasion", 4500));
						headMap.put(21, new WondrousHeadItem("grappler's mask", 5000));
						headMap.put(31, new WondrousHeadItem("helm of fearsome mien", 5000));
						headMap.put(40, new WondrousHeadItem("jingasa of the fortunate soldier", 5000));
						headMap.put(54, new WondrousHeadItem("helm of comprehend languages and read magic", 5200));
						headMap.put(67, new WondrousHeadItem("crown of swords", 6000));
						headMap.put(87, new WondrousHeadItem("minor crown of blasting", 6480));
						headMap.put(100, new WondrousHeadItem("mask of the krenshar", 7200));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						headMap.put(16, new WondrousHeadItem("helm of the mammoth lord", 8500));
						headMap.put(30, new WondrousHeadItem("veil of fleeting glances", 9000));
						headMap.put(46, new WondrousHeadItem("mask of a thousand tomes", 10000));
						headMap.put(63, new WondrousHeadItem("medusa mask", 10000));
						headMap.put(80, new WondrousHeadItem("cap of the free thinker", 12000));
						headMap.put(100, new WondrousHeadItem("halo of inner calm", 16000));
						break;
					case GREATER:
						headMap.put(6, new WondrousHeadItem("cat's eye crown", 18000));
						headMap.put(12, new WondrousHeadItem("maw of the wyrm", 18000));
						headMap.put(19, new WondrousHeadItem("mitre of the hierophant", 18000));
						headMap.put(27, new WondrousHeadItem("magician's hat", 20000));
						headMap.put(34, new WondrousHeadItem("circlet of mindsight", 22000));
						headMap.put(42, new WondrousHeadItem("mask of the skull", 22000));
						headMap.put(50, new WondrousHeadItem("howling helm", 22600));
						headMap.put(62, new WondrousHeadItem("major crown of blasting", 23760));
						headMap.put(72, new WondrousHeadItem("helm of underwater action", 24000));
						headMap.put(79, new WondrousHeadItem("crown of conquest", 24600));
						headMap.put(85, new WondrousHeadItem("batrachian helm", 26000));
						headMap.put(94, new WondrousHeadItem("helm of telepathy", 27000));
						headMap.put(100, new WondrousHeadItem("plague mask", 27000));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						headMap.put(14, new WondrousHeadItem("iron circlet of guarded souls", 30000));
						headMap.put(29, new WondrousHeadItem("laurel of command", 30000));
						headMap.put(45, new WondrousHeadItem("lesser mask of giants", 30000));
						headMap.put(61, new WondrousHeadItem("steel-mind cap", 33600));
						headMap.put(78, new WondrousHeadItem("stormlord's helm", 35000));
						headMap.put(100, new WondrousHeadItem("lesser helm of brilliance", 36000));
						break;
					case GREATER:
						headMap.put(14, new WondrousHeadItem("judge's wig", 59200));
						headMap.put(39, new WondrousHeadItem("helm of teleportation", 73500));
						headMap.put(55, new WondrousHeadItem("halo of menace", 84000));
						headMap.put(68, new WondrousHeadItem("greater mask of giants", 90000));
						headMap.put(83, new WondrousHeadItem("helm of brilliance", 125000));
						headMap.put(92, new WondrousHeadItem("helm of electric radiance", 125000));
						headMap.put(100, new WondrousHeadItem("crown of heaven", 150000));
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
		WondrousHeadItem itemCopy = new WondrousHeadItem(itemDegree, itemDegreeQualifier);
		itemCopy.leafItem = leafItem;
		return itemCopy;
	}
}
