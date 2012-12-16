package com.ohako.itemcategory.rods;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;

public class MetamagicRodItem extends RodItem 
{
	private int plus;
	
	private static Map<Integer, Map<Integer, String>> metamagicMap;
	
	public MetamagicRodItem(String itemName, int itemPrice, int plus) 
	{
		super(itemName, itemPrice);
		this.plus = plus;
	}

	@Override
	public void generateItem() 
	{
		if (metamagicMap == null)
			metamagicMap = new HashMap<Integer, Map<Integer, String>>();
		Map<Integer, String> plusedMetamagicMap = metamagicMap.get(plus);
		if (plusedMetamagicMap == null)
		{
			plusedMetamagicMap = new LinkedHashMap<Integer, String>();
			populateMetaMagicMap(plusedMetamagicMap, plus);
			metamagicMap.put(plus, plusedMetamagicMap);
		}
		itemName = String.format(itemName, ItemsForSale.getRandomThing(plusedMetamagicMap));
		leafItem = true;
	}

	private void populateMetaMagicMap(Map<Integer, String> plusedMetamagicMap, int plus) 
	{
		switch (plus)
		{
			case 1:
				plusedMetamagicMap.put(4, "bouncing");
				plusedMetamagicMap.put(9, "disruptive");
				plusedMetamagicMap.put(14, "ectoplasmic");
				//TODO come up with elegant way to choose between 4 elements rather than 5 here
				plusedMetamagicMap.put(19, "elemental");
				plusedMetamagicMap.put(31, "enlarge");
				plusedMetamagicMap.put(43, "extend");
				plusedMetamagicMap.put(48, "flaring");
				plusedMetamagicMap.put(53, "focused");
				plusedMetamagicMap.put(58, "intensified");
				plusedMetamagicMap.put(63, "lingering");
				plusedMetamagicMap.put(68, "piercing");
				plusedMetamagicMap.put(73, "reach");
				plusedMetamagicMap.put(78, "rime");
				plusedMetamagicMap.put(83, "selective");
				plusedMetamagicMap.put(95, "silent");
				plusedMetamagicMap.put(100, "toppling");
				break;
			case 2:
				plusedMetamagicMap.put(11, "burning");
				plusedMetamagicMap.put(22, "concussive");
				plusedMetamagicMap.put(40, "empower");
				plusedMetamagicMap.put(51, "persistent");
				plusedMetamagicMap.put(62, "sickening");
				plusedMetamagicMap.put(75, "thanatopic");
				plusedMetamagicMap.put(88, "threnodic");
				plusedMetamagicMap.put(100, "thundering");
				break;
			case 3:
				plusedMetamagicMap.put(20, "dazing");
				plusedMetamagicMap.put(40, "echoing");
				plusedMetamagicMap.put(70, "maximize");
				plusedMetamagicMap.put(100, "widen");
				break;
			default:
				break;
		}
	}

	@Override
	public Item copyItem() 
	{
		Item item = super.copyItem();
		item.setLeafItem(false);
		return item;
	}	
}
