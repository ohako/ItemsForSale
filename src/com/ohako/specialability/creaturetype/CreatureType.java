package com.ohako.specialability.creaturetype;

public class CreatureType implements ICreatureType
{
	protected String creatureType;
	
	public CreatureType(String creatureType) 
	{
		this.creatureType = creatureType;
	}

	public String format(String stringToFormat) 
	{
		return String.format(stringToFormat, creatureType);
	}
}