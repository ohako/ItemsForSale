package com.ohako.itemcategory.wondrousitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousFeetItem extends WondrousItem {

	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousFeetItem>>> specificFeetMap;

	public WondrousFeetItem(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		super(itemDegree, itemDegreeQualifier);
	}
	
	public WondrousFeetItem(String itemName, int itemPrice)
	{
		super(itemName, itemPrice);
	}

	@Override
	public void generateItem() {
		if (specificFeetMap == null)
			specificFeetMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousFeetItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, WondrousFeetItem>> specificFeetMapByDegree = specificFeetMap.get(itemDegree);
		if (specificFeetMapByDegree == null)
		{
			specificFeetMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,WondrousFeetItem>>();
			specificFeetMap.put(itemDegree, specificFeetMapByDegree);
		}
		Map<Integer, WondrousFeetItem> specificFeetMapByDegreeAndQualifier = specificFeetMapByDegree.get(itemDegreeQualifier);
		if (specificFeetMapByDegreeAndQualifier == null)
		{
			specificFeetMapByDegreeAndQualifier = new LinkedHashMap<Integer, WondrousFeetItem>();
			populateSpecificFeetMap(specificFeetMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificFeetMapByDegree.put(itemDegreeQualifier, specificFeetMapByDegreeAndQualifier);
		}
		WondrousFeetItem feetItem = ItemsForSale.getRandomThing(specificFeetMapByDegreeAndQualifier);
		this.itemName = feetItem.itemName();
		this.itemPrice = feetItem.itemPrice();
		this.leafItem = true;
	}

	private void populateSpecificFeetMap(
			Map<Integer, WondrousFeetItem> feetMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						feetMap.put(11, new WondrousFeetItem("boots of the cat", 1000));
						feetMap.put(22, new WondrousFeetItem("daredevil boots", 1400));
						feetMap.put(31, new WondrousFeetItem("boots of the enduring march", 1500));
						feetMap.put(41, new WondrousFeetItem("feather step slippers", 2000));
						feetMap.put(50, new WondrousFeetItem("boots of the friendly terrain", 2400));
						feetMap.put(60, new WondrousFeetItem("boots of the winterlands", 2500));
						feetMap.put(76, new WondrousFeetItem("boots of elvenkind", 2500));
						feetMap.put(85, new WondrousFeetItem("acrobat slippers", 3000));
						feetMap.put(92, new WondrousFeetItem("horseshoes of speed", 3000));
						feetMap.put(100, new WondrousFeetItem("boots of the mire", 3500));
						break;
					case GREATER:
						feetMap.put(7, new WondrousFeetItem("minor burglar boots", 4000));
						feetMap.put(13, new WondrousFeetItem("horseshoes of crushing blows +1", 4000));
						feetMap.put(19, new WondrousFeetItem("sandals of quick reaction", 4000));
						feetMap.put(26, new WondrousFeetItem("slippers of cloudwalking", 4400));
						feetMap.put(40, new WondrousFeetItem("slippers of spider climbing", 4800));
						feetMap.put(46, new WondrousFeetItem("sandals of the lightest step", 5000));
						feetMap.put(60, new WondrousFeetItem("boots of striding and springing", 5500));
						feetMap.put(68, new WondrousFeetItem("horseshoes of a zephyr", 6000));
						feetMap.put(75, new WondrousFeetItem("haunted shoes", 6480));
						feetMap.put(82, new WondrousFeetItem("jaunt boots", 7200));
						feetMap.put(100, new WondrousFeetItem("boots of levitation", 7500));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						feetMap.put(8, new WondrousFeetItem("boots of escape", 8000));
						feetMap.put(14, new WondrousFeetItem("earth root boots", 8000));
						feetMap.put(21, new WondrousFeetItem("nightmare boots", 8500));
						feetMap.put(26, new WondrousFeetItem("nightmare horseshoes", 9000));
						feetMap.put(32, new WondrousFeetItem("caltrop boots", 10000));
						feetMap.put(39, new WondrousFeetItem("tremor boots", 10000));
						feetMap.put(47, new WondrousFeetItem("boots of the mastodon", 10500));
						feetMap.put(54, new WondrousFeetItem("shoes of the lightning leaper", 10500));
						feetMap.put(70, new WondrousFeetItem("boots of speed", 12000));
						feetMap.put(77, new WondrousFeetItem("verdant boots", 12000));
						feetMap.put(84, new WondrousFeetItem("horseshoes of crushing blows +2", 16000));
						feetMap.put(100, new WondrousFeetItem("winged boots", 16000));
						break;
					case GREATER:
						feetMap.put(38, new WondrousFeetItem("shoes of the firewalker", 21000));
						feetMap.put(72, new WondrousFeetItem("dryad sandals", 24000));
						feetMap.put(38, new WondrousFeetItem("horseshoes of the mist", 27000));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						feetMap.put(20, new WondrousFeetItem("getaway boots", 30000));
						feetMap.put(35, new WondrousFeetItem("horseshoes of crushing blows +3", 36000));
						feetMap.put(55, new WondrousFeetItem("horseshoes of glory", 39600));
						feetMap.put(75, new WondrousFeetItem("major burglar boots", 46000));
						feetMap.put(100, new WondrousFeetItem("boots of teleportation", 49000));
						break;
					case GREATER:
						feetMap.put(40, new WondrousFeetItem("slippers of the triton", 56000));
						feetMap.put(70, new WondrousFeetItem("horseshoes of crushing blows +4", 64000));
						feetMap.put(100, new WondrousFeetItem("horseshoes of crushing blows +5", 100000));
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
		WondrousFeetItem itemCopy = new WondrousFeetItem(itemDegree, itemDegreeQualifier);
		itemCopy.leafItem = leafItem;
		return itemCopy;
	}
}
