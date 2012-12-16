package com.ohako.specialability;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.ItemsForSale;

public class EnergyTypeSpecialAbility extends SpecialAbility implements ISpecialAbility
{
	private static Map<Integer, String> energyTypeMap;

	public EnergyTypeSpecialAbility(String abilityName, int abilityPrice,
			AbilityCategory abilityCategory) 
	{
		super(abilityName, abilityPrice, abilityCategory);
	}
	
	public SpecialAbility copy() 
	{
		EnergyTypeSpecialAbility result = new EnergyTypeSpecialAbility(abilityName, abilityPrice, abilityCategory);
		if (energyTypeMap == null)
		{
			energyTypeMap = new LinkedHashMap<Integer, String>();
			populateEnergyTypeMap();
		}
		String energyType = ItemsForSale.getRandomThing(energyTypeMap);
		result.abilityName = String.format(result.abilityName, energyType);
		return result;
	}

	private void populateEnergyTypeMap() 
	{
		energyTypeMap.put(20, "acid");
		energyTypeMap.put(40, "cold");
		energyTypeMap.put(60, "electricity");
		energyTypeMap.put(80, "fire");
		energyTypeMap.put(100, "sonic");		
	}	
}
