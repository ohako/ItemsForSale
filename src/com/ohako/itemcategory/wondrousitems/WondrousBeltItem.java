package com.ohako.itemcategory.wondrousitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousBeltItem extends WondrousItem {

	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousBeltItem>>> specificBeltMap;

	public WondrousBeltItem(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		super(itemDegree, itemDegreeQualifier);
	}
	
	public WondrousBeltItem(String itemName, int itemPrice)
	{
		super(itemName, itemPrice);
	}

	@Override
	public void generateItem() {
		if (specificBeltMap == null)
			specificBeltMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousBeltItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, WondrousBeltItem>> specificBeltMapByDegree = specificBeltMap.get(itemDegree);
		if (specificBeltMapByDegree == null)
		{
			specificBeltMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,WondrousBeltItem>>();
			specificBeltMap.put(itemDegree, specificBeltMapByDegree);
		}
		Map<Integer, WondrousBeltItem> specificBeltMapByDegreeAndQualifier = specificBeltMapByDegree.get(itemDegreeQualifier);
		if (specificBeltMapByDegreeAndQualifier == null)
		{
			specificBeltMapByDegreeAndQualifier = new LinkedHashMap<Integer, WondrousBeltItem>();
			populateSpecificBeltMap(specificBeltMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificBeltMapByDegree.put(itemDegreeQualifier, specificBeltMapByDegreeAndQualifier);
		}
		WondrousBeltItem beltItem = ItemsForSale.getRandomThing(specificBeltMapByDegreeAndQualifier);
		this.itemName = beltItem.itemName();
		this.itemPrice = beltItem.itemPrice();
		this.leafItem = true;
	}

	private void populateSpecificBeltMap(
			Map<Integer, WondrousBeltItem> beltMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						beltMap.put(16, new WondrousBeltItem("belt of tumbling", 800));
						beltMap.put(28, new WondrousBeltItem("beneficial bandolier", 1000));
						beltMap.put(40, new WondrousBeltItem("meridian belt", 1000));
						beltMap.put(54, new WondrousBeltItem("bladed belt", 2000));
						beltMap.put(70, new WondrousBeltItem("heavyload belt", 2000));
						beltMap.put(84, new WondrousBeltItem("aquatic cummerbund", 2600));
						beltMap.put(100, new WondrousBeltItem("equestrian belt", 3200));
						break;
					case GREATER: //TODO pick abilities boosted by multiple +stat items
						beltMap.put(18, new WondrousBeltItem("belt of giant strength +2", 4000));
						beltMap.put(36, new WondrousBeltItem("belt of incredible dexterity +2", 4000));
						beltMap.put(54, new WondrousBeltItem("belt of mighty constitution +2", 4000));
						beltMap.put(62, new WondrousBeltItem("belt of teeth", 4000));
						beltMap.put(74, new WondrousBeltItem("blinkback belt", 5000));
						beltMap.put(84, new WondrousBeltItem("plague rat belt", 5200));
						beltMap.put(100, new WondrousBeltItem("belt of foraging", 6000));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						beltMap.put(4, new WondrousBeltItem("serpent belt", 9000));
						beltMap.put(8, new WondrousBeltItem("monkey belt", 9400));
						beltMap.put(16, new WondrousBeltItem("belt of physical might +2", 10000));
						beltMap.put(22, new WondrousBeltItem("belt of the weasel", 10000));
						beltMap.put(27, new WondrousBeltItem("belt of thunderous charging", 10000));
						beltMap.put(32, new WondrousBeltItem("minotaur belt", 11000));
						beltMap.put(36, new WondrousBeltItem("greater plague rat belt", 11200));
						beltMap.put(41, new WondrousBeltItem("belt of equilibrium", 12000));
						beltMap.put(46, new WondrousBeltItem("security belt", 12500));
						beltMap.put(51, new WondrousBeltItem("lesser belt of mighty hurling", 14000));
						beltMap.put(57, new WondrousBeltItem("belt of dwarvenkind", 14900));
						beltMap.put(61, new WondrousBeltItem("cord of stubborn resolve", 15000));
						beltMap.put(71, new WondrousBeltItem("belt of giant strength +4", 16000));
						beltMap.put(80, new WondrousBeltItem("belt of physical perfection +2", 16000));
						beltMap.put(90, new WondrousBeltItem("belt of incredible dexterity +4", 16000));
						beltMap.put(100, new WondrousBeltItem("belt of mighty constitution +4", 16000));
						break;
					case GREATER:
						beltMap.put(12, new WondrousBeltItem("greater monkey belt", 18000));
						beltMap.put(26, new WondrousBeltItem("anaconda's coils", 18500));
						beltMap.put(38, new WondrousBeltItem("greater serpent belt", 20000));
						beltMap.put(53, new WondrousBeltItem("belt of fallen heroes", 21000));
						beltMap.put(67, new WondrousBeltItem("gorgon belt", 23000));
						beltMap.put(84, new WondrousBeltItem("elemental earth belt", 24000));
						beltMap.put(100, new WondrousBeltItem("sash of flowing water", 25000));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						beltMap.put(12, new WondrousBeltItem("merform belt", 32000));
						beltMap.put(30, new WondrousBeltItem("belt of giant strength +6", 36000));
						beltMap.put(48, new WondrousBeltItem("belt of incredible dexterity +6", 36000));
						beltMap.put(66, new WondrousBeltItem("belt of mighty constitution +6", 36000));
						beltMap.put(88, new WondrousBeltItem("belt of physical might +4", 40000));
						beltMap.put(100, new WondrousBeltItem("greater belt of mighty hurling", 42000));
						break;
					case GREATER:
						beltMap.put(25, new WondrousBeltItem("belt of stoneskin", 60000));
						beltMap.put(55, new WondrousBeltItem("belt of physical perfection +4", 64000));
						beltMap.put(75, new WondrousBeltItem("belt of physical might +6", 90000));
						beltMap.put(90, new WondrousBeltItem("shadowform belt", 110000));
						beltMap.put(100, new WondrousBeltItem("belt of physical perfection +6", 144000));
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
		WondrousBeltItem itemCopy = new WondrousBeltItem(itemDegree, itemDegreeQualifier);
		itemCopy.leafItem = leafItem;
		return itemCopy;
	}
}
