package com.ohako.specialability;

public class SpecialAbility implements ISpecialAbility
{
	protected String abilityName;
	protected int abilityPrice;
	protected AbilityCategory abilityCategory;
	
	public enum AbilityCategory
	{
		FORTIFICATION,
		SHADOW,
		VISCOSITY,
		SPELL_RESISTANCE,
		ENERGY_RESISTANCE,
		WYRMSBREATH, 
		ENERGY,
		ALIGNMENT
	}
	
	public SpecialAbility(String abilityName, int abilityPrice)
	{
		this.abilityName = abilityName;
		this.abilityPrice = abilityPrice;		
	}
	
	public SpecialAbility(String abilityName, int abilityPrice, AbilityCategory abilityCategory)
	{
		this.abilityName = abilityName;
		this.abilityPrice = abilityPrice;
		this.abilityCategory = abilityCategory;
	}
	
	public String getAbilityName()
	{
		return abilityName;
	}
	
	public int getAbilityPrice()
	{
		return abilityPrice;
	}

	public SpecialAbility copy() 
	{
		SpecialAbility result = new SpecialAbility(abilityName, abilityPrice, abilityCategory);
		return result;
	}

	public boolean matches(ISpecialAbility chosenSpecialAbility)
	{
		if (abilityName.equals(chosenSpecialAbility.getAbilityName()) ||
			(abilityCategory != null &&
			chosenSpecialAbility.getAbilityCategory() != null &&
			abilityCategory != chosenSpecialAbility.getAbilityCategory())
		   )
			return true;
		else
			return false;
	}

	@Override
	public AbilityCategory getAbilityCategory() 
	{
		return abilityCategory;
	}
}
