package com.ohako.specialability.creaturetype;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.ItemsForSale;

public class OutsiderCreatureType extends CreatureType implements ICreatureType
{
	private static Map<Integer, String> outsiderSubtypeMap; 
	
	public OutsiderCreatureType(String creatureType) 
	{
		super(creatureType);
	}
	
	public String format(String stringToFormat)
	{
		if (outsiderSubtypeMap == null)
		{
			outsiderSubtypeMap = new LinkedHashMap<Integer, String>();
			populateOutsiderSubtypeMap(outsiderSubtypeMap);
		}
		String creatureSubtype = ItemsForSale.getRandomThing(outsiderSubtypeMap);
		creatureType = String.format(creatureType, creatureSubtype);
		return String.format(stringToFormat, creatureType);
	}

	private void populateOutsiderSubtypeMap(Map<Integer, String> outsiderSubtypeMap) 
	{
		outsiderSubtypeMap.put(125, "air");
		outsiderSubtypeMap.put(250, "chaos");
		outsiderSubtypeMap.put(375, "earth");
		outsiderSubtypeMap.put(500, "evil");
		outsiderSubtypeMap.put(625, "fire");
		outsiderSubtypeMap.put(750, "good");
		outsiderSubtypeMap.put(875, "law");
		outsiderSubtypeMap.put(1000, "water");
	}
}