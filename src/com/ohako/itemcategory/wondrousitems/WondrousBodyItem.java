package com.ohako.itemcategory.wondrousitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousBodyItem extends WondrousItem {

	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousBodyItem>>> specificBodyMap;

	public WondrousBodyItem(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		super(itemDegree, itemDegreeQualifier);
	}
	
	public WondrousBodyItem(String itemName, int itemPrice)
	{
		super(itemName, itemPrice);
	}

	@Override
	public void generateItem() {
		if (specificBodyMap == null)
			specificBodyMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousBodyItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, WondrousBodyItem>> specificBodyMapByDegree = specificBodyMap.get(itemDegree);
		if (specificBodyMapByDegree == null)
		{
			specificBodyMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,WondrousBodyItem>>();
			specificBodyMap.put(itemDegree, specificBodyMapByDegree);
		}
		Map<Integer, WondrousBodyItem> specificBodyMapByDegreeAndQualifier = specificBodyMapByDegree.get(itemDegreeQualifier);
		if (specificBodyMapByDegreeAndQualifier == null)
		{
			specificBodyMapByDegreeAndQualifier = new LinkedHashMap<Integer, WondrousBodyItem>();
			populateSpecificBodyMap(specificBodyMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificBodyMapByDegree.put(itemDegreeQualifier, specificBodyMapByDegreeAndQualifier);
		}
		WondrousBodyItem bodyItem = ItemsForSale.getRandomThing(specificBodyMapByDegreeAndQualifier);
		this.itemName = bodyItem.itemName();
		this.itemPrice = bodyItem.itemPrice();
		this.leafItem = true;
	}

	private void populateSpecificBodyMap(
			Map<Integer, WondrousBodyItem> bodyMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER: //TODO: figure out a way of 'weaponifying' the body wrap of mighty strikes
						bodyMap.put(20, new WondrousBodyItem("robe of infinite twine", 1000));
						bodyMap.put(35, new WondrousBodyItem("robe of needles", 1000));
						bodyMap.put(60, new WondrousBodyItem("robe of bones", 2400));
						bodyMap.put(70, new WondrousBodyItem("bodywrap of mighty strikes +1", 3000));
						bodyMap.put(80, new WondrousBodyItem("corset of the vishkanya", 3000));
						bodyMap.put(100, new WondrousBodyItem("druid's vestment", 3750));
						break;
					case GREATER:
						bodyMap.put(15, new WondrousBodyItem("cassock of the clergy", 4600));
						bodyMap.put(30, new WondrousBodyItem("mnemonic vestments", 5000));
						bodyMap.put(45, new WondrousBodyItem("robe of components", 5000));
						bodyMap.put(60, new WondrousBodyItem("sorcerer's robe", 5000));
						bodyMap.put(75, new WondrousBodyItem("eidolon anchoring harness", 6000));
						bodyMap.put(100, new WondrousBodyItem("robe of useful items", 7000));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						bodyMap.put(15, new WondrousBodyItem("robe of blending", 8400));
						bodyMap.put(26, new WondrousBodyItem("blazing robes", 11000));
						bodyMap.put(37, new WondrousBodyItem("shocking robe", 11000));
						bodyMap.put(48, new WondrousBodyItem("voidfrost robes", 11000));
						bodyMap.put(59, new WondrousBodyItem("bodywrap of mighty strikes +2", 12000));
						bodyMap.put(75, new WondrousBodyItem("monk's robe", 13000));
						bodyMap.put(100, new WondrousBodyItem("robe of arcane heritage", 16000));
						break;
					case GREATER:
						bodyMap.put(25, new WondrousBodyItem("xorn robe", 20000));
						bodyMap.put(52, new WondrousBodyItem("corset of dire witchcraft", 22000));
						bodyMap.put(76, new WondrousBodyItem("bodywrap of mighty strikes +3", 27000));
						bodyMap.put(100, new WondrousBodyItem("robe of scintillating colors", 27000));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						bodyMap.put(40, new WondrousBodyItem("gunman's duster", 36000));
						bodyMap.put(80, new WondrousBodyItem("bodywrap of mighty strikes +4", 48000));
						bodyMap.put(100, new WondrousBodyItem("smuggler's collapsible robe", 48000));
						break;
					case GREATER:
						bodyMap.put(10, new WondrousBodyItem("robe of stars", 58000));
						bodyMap.put(15, new WondrousBodyItem("robe of gates", 64000));
						bodyMap.put(20, new WondrousBodyItem("otherworldly kimono", 67000));
						bodyMap.put(40, new WondrousBodyItem("bodywrap of mighty strikes +5", 75000));
						bodyMap.put(51, new WondrousBodyItem("resplendent robe of the thespian", 75000));
						bodyMap.put(67, new WondrousBodyItem("robe of the archmagi", 75000));
						bodyMap.put(77, new WondrousBodyItem("bodywrap of mighty strikes +6", 108000));
						bodyMap.put(97, new WondrousBodyItem("robe of eyes", 120000));
						bodyMap.put(100, new WondrousBodyItem("bodywrap of mighty strikes", 147000));
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
		WondrousBodyItem itemCopy = new WondrousBodyItem(itemDegree, itemDegreeQualifier);
		itemCopy.leafItem = leafItem;
		return itemCopy;
	}
}
