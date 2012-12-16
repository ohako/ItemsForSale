package com.ohako.specialability;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.ItemsForSale;
import com.ohako.specialability.creaturetype.CreatureType;
import com.ohako.specialability.creaturetype.HumanoidCreatureType;
import com.ohako.specialability.creaturetype.ICreatureType;
import com.ohako.specialability.creaturetype.OutsiderCreatureType;

public class CreatureTypeSpecialAbility extends SpecialAbility implements ISpecialAbility
{
	private static Map<Integer, ICreatureType> creatureTypeMap;
	
	public CreatureTypeSpecialAbility(String abilityName, int abilityPrice,
			AbilityCategory abilityCategory) 
	{
		super(abilityName, abilityPrice, abilityCategory);
	}
	
	public CreatureTypeSpecialAbility(String abilityName, int abilityPrice) 
	{
		super(abilityName, abilityPrice);
	}
	
	public SpecialAbility copy() 
	{
		CreatureTypeSpecialAbility result = new CreatureTypeSpecialAbility(abilityName, abilityPrice, abilityCategory);
		getCreatureTypeMap();
		ICreatureType creatureType = ItemsForSale.getRandomThing(creatureTypeMap);
		result.abilityName = creatureType.format(result.abilityName);
		return result;
	}

	private static void populateCreatureTypeMap() 
	{
		creatureTypeMap.put(5, new CreatureType("aberration"));
		creatureTypeMap.put(9, new CreatureType("animal"));
		creatureTypeMap.put(16, new CreatureType("construct"));
		creatureTypeMap.put(22, new CreatureType("dragon"));
		creatureTypeMap.put(27, new CreatureType("fey"));
		creatureTypeMap.put(60, new HumanoidCreatureType("%s"));
		creatureTypeMap.put(65, new CreatureType("magical beast"));
		creatureTypeMap.put(70, new CreatureType("monstrous humanoid"));
		creatureTypeMap.put(72, new CreatureType("ooze"));
		creatureTypeMap.put(88, new OutsiderCreatureType("%s outsider"));
		creatureTypeMap.put(90, new CreatureType("plant"));
		creatureTypeMap.put(98, new CreatureType("undead"));
		creatureTypeMap.put(100, new CreatureType("vermin"));
	}

	public static Map<Integer, ICreatureType> getCreatureTypeMap() 
	{
		if (creatureTypeMap == null)
		{
			creatureTypeMap = new LinkedHashMap<Integer, ICreatureType>();
			populateCreatureTypeMap();
		}
		return creatureTypeMap;
	}	
}
