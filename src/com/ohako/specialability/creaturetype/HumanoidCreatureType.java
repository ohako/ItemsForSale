package com.ohako.specialability.creaturetype;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.ItemsForSale;

public class HumanoidCreatureType extends CreatureType implements ICreatureType
{
	private static Map<Integer, String> humanoidSubtypeMap; 
	
	public HumanoidCreatureType(String creatureType) 
	{
		super(creatureType);
	}
	
	public String format(String stringToFormat)
	{
		if (humanoidSubtypeMap == null)
		{
			humanoidSubtypeMap = new LinkedHashMap<Integer, String>();
			populateHumanoidSubtypeMap(humanoidSubtypeMap);
		}
		String creatureSubtype = ItemsForSale.getRandomThing(humanoidSubtypeMap);
		creatureType = String.format(creatureType, creatureSubtype);
		return String.format(stringToFormat, creatureType);
	}

	//where did this table come from?? you'll never guess... :)
	private void populateHumanoidSubtypeMap(Map<Integer, String> humanoidSubtypeMap) 
	{
		humanoidSubtypeMap.put(1, "bugbear");
		humanoidSubtypeMap.put(13, "dwarf");
		humanoidSubtypeMap.put(25, "elf");
		humanoidSubtypeMap.put(26, "gnoll");
		humanoidSubtypeMap.put(38, "gnome");
		humanoidSubtypeMap.put(42, "goblin");
//		humanoidSubtypeMap.put(52, "half-elf");
//		humanoidSubtypeMap.put(62, "half-orc");
		humanoidSubtypeMap.put(54, "halfling");
		humanoidSubtypeMap.put(69, "human");
		humanoidSubtypeMap.put(73, "kobold");
		humanoidSubtypeMap.put(74, "lizardfolk");
		humanoidSubtypeMap.put(78, "orc");
		humanoidSubtypeMap.put(79, "troglodyte");
	}
}