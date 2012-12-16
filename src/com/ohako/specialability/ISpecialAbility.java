package com.ohako.specialability;

import com.ohako.specialability.SpecialAbility.AbilityCategory;

public interface ISpecialAbility 
{
	public ISpecialAbility copy();
	public boolean matches(ISpecialAbility specialAbility);
	public String getAbilityName();
	public int getAbilityPrice();
	public AbilityCategory getAbilityCategory();
}
