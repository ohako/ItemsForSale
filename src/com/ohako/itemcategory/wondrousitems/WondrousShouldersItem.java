package com.ohako.itemcategory.wondrousitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousShouldersItem extends WondrousItem {

	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousShouldersItem>>> specificShouldersMap;

	public WondrousShouldersItem(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		super(itemDegree, itemDegreeQualifier);
	}
	
	public WondrousShouldersItem(String itemName, int itemPrice)
	{
		super(itemName, itemPrice);
	}

	@Override
	public void generateItem() {
		if (specificShouldersMap == null)
			specificShouldersMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousShouldersItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, WondrousShouldersItem>> specificShouldersMapByDegree = specificShouldersMap.get(itemDegree);
		if (specificShouldersMapByDegree == null)
		{
			specificShouldersMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,WondrousShouldersItem>>();
			specificShouldersMap.put(itemDegree, specificShouldersMapByDegree);
		}
		Map<Integer, WondrousShouldersItem> specificShouldersMapByDegreeAndQualifier = specificShouldersMapByDegree.get(itemDegreeQualifier);
		if (specificShouldersMapByDegreeAndQualifier == null)
		{
			specificShouldersMapByDegreeAndQualifier = new LinkedHashMap<Integer, WondrousShouldersItem>();
			populateSpecificShouldersMap(specificShouldersMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificShouldersMapByDegree.put(itemDegreeQualifier, specificShouldersMapByDegreeAndQualifier);
		}
		WondrousShouldersItem shouldersItem = ItemsForSale.getRandomThing(specificShouldersMapByDegreeAndQualifier);
		this.itemName = shouldersItem.itemName();
		this.itemPrice = shouldersItem.itemPrice();
		this.leafItem = true;
	}

	private void populateSpecificShouldersMap(
			Map<Integer, WondrousShouldersItem> shouldersMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						shouldersMap.put(6, new WondrousShouldersItem("catching cape", 200));
						shouldersMap.put(10, new WondrousShouldersItem("cloak of human guise", 900));
						shouldersMap.put(30, new WondrousShouldersItem("cloak of resistance +1", 1000));
						shouldersMap.put(36, new WondrousShouldersItem("muleback cords", 1000));
						shouldersMap.put(38, new WondrousShouldersItem("shawl of life-keeping", 1000));
						shouldersMap.put(44, new WondrousShouldersItem("shield cloak", 1000));
						shouldersMap.put(50, new WondrousShouldersItem("quickchange cloak", 1500));
						shouldersMap.put(56, new WondrousShouldersItem("cowardly crouching cloak", 1800));
						shouldersMap.put(74, new WondrousShouldersItem("cloak of elvenkind", 2500));
						shouldersMap.put(80, new WondrousShouldersItem("cloak of the hedge wizard", 2500));
						shouldersMap.put(85, new WondrousShouldersItem("cloak of fiery vanishing", 2600));
						shouldersMap.put(94, new WondrousShouldersItem("cloak of fangs", 2800));
						shouldersMap.put(97, new WondrousShouldersItem("pauldrons of the serpent", 3000));
						shouldersMap.put(100, new WondrousShouldersItem("stonemist cloak", 3500));
						break;
					case GREATER: 
						shouldersMap.put(26, new WondrousShouldersItem("cloak of resistance +2", 4000));
						shouldersMap.put(38, new WondrousShouldersItem("cloak of the scuttling rat", 6000));
						shouldersMap.put(39, new WondrousShouldersItem("seafoam shawl", 6000));
						shouldersMap.put(52, new WondrousShouldersItem("treeform cloak", 6000));
						shouldersMap.put(74, new WondrousShouldersItem("eagle cape", 7000));
						shouldersMap.put(94, new WondrousShouldersItem("cloak of the manta ray", 7200));
						shouldersMap.put(100, new WondrousShouldersItem("hunter's cloak", 7500));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						shouldersMap.put(20, new WondrousShouldersItem("cloak of resistance +3", 9000));
						shouldersMap.put(22, new WondrousShouldersItem("cloak of the duskwalker", 10000));
						shouldersMap.put(25, new WondrousShouldersItem("cocoon cloak", 10000));
						shouldersMap.put(27, new WondrousShouldersItem("pauldrons of the bull", 10000));
						shouldersMap.put(32, new WondrousShouldersItem("minor stone cloak", 10000));
						shouldersMap.put(40, new WondrousShouldersItem("cape of the mountebank", 10800));
						shouldersMap.put(45, new WondrousShouldersItem("pauldrons of the watchful lion", 10800));
						shouldersMap.put(52, new WondrousShouldersItem("lion cloak", 12000));
						shouldersMap.put(54, new WondrousShouldersItem("mantle of spores", 13400));
						shouldersMap.put(59, new WondrousShouldersItem("cape of effulgent escape", 14000));
						shouldersMap.put(69, new WondrousShouldersItem("cloak of arachnida", 14000));
						shouldersMap.put(72, new WondrousShouldersItem("gunfighter's poncho", 14000));
						shouldersMap.put(74, new WondrousShouldersItem("tentacle cloak", 14000));
						shouldersMap.put(76, new WondrousShouldersItem("demonspike pauldrons", 14350));
						shouldersMap.put(78, new WondrousShouldersItem("comfort's cloak", 15600));
						shouldersMap.put(88, new WondrousShouldersItem("cloak of resistance +4", 16000));
						shouldersMap.put(91, new WondrousShouldersItem("shawl of the crone", 16000));
						shouldersMap.put(100, new WondrousShouldersItem("prestidigitator's cloak", 17200));
						break;
					case GREATER:
						shouldersMap.put(12, new WondrousShouldersItem("stole of justice", 18000));
						shouldersMap.put(24, new WondrousShouldersItem("jellyfish cape", 19200));
						shouldersMap.put(32, new WondrousShouldersItem("cloak of the diplomat", 20000));
						shouldersMap.put(44, new WondrousShouldersItem("slashing cloak", 20000));
						shouldersMap.put(56, new WondrousShouldersItem("major stone cloak", 20000));
						shouldersMap.put(68, new WondrousShouldersItem("minor cloak of displacement", 24000));
						shouldersMap.put(88, new WondrousShouldersItem("cloak of resistance +5", 25000));
						shouldersMap.put(100, new WondrousShouldersItem("cloak of the bat", 26000));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						shouldersMap.put(40, new WondrousShouldersItem("highwayman's cape", 32500));
						shouldersMap.put(60, new WondrousShouldersItem("juggernaut's pauldrons", 40000));
						shouldersMap.put(100, new WondrousShouldersItem("charlatan's cape", 45000));
						break;
					case GREATER:
						shouldersMap.put(15, new WondrousShouldersItem("major cloak of displcement", 50000));
						shouldersMap.put(35, new WondrousShouldersItem("wings of flying", 54000));
						shouldersMap.put(55, new WondrousShouldersItem("cloak of etherealness", 55000));
						shouldersMap.put(80, new WondrousShouldersItem("wings of the gargoyle", 72000));
						shouldersMap.put(100, new WondrousShouldersItem("wyvern's cloak", 78600));
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
		WondrousShouldersItem itemCopy = new WondrousShouldersItem(itemDegree, itemDegreeQualifier);
		itemCopy.leafItem = leafItem;
		return itemCopy;
	}
}
