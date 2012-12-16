package com.ohako.itemcategory.rings;

import com.ohako.Item;
import com.ohako.specialability.EnergyTypeSpecialAbility;
import com.ohako.specialability.SpecialAbility;
import com.ohako.specialability.SpecialAbility.AbilityCategory;

public class EnergyTypeRingItem extends RingItem 
{
	public EnergyTypeRingItem(String itemName, int itemPrice) 
	{
		super(itemName, itemPrice);
	}
	
	@Override
	public Item copyItem() 
	{
		RingItem newItem = new RingItem(this.itemName(), this.itemPrice());
		EnergyTypeSpecialAbility specAbility = new EnergyTypeSpecialAbility(newItem.itemName(), newItem.itemPrice(), AbilityCategory.ENERGY_RESISTANCE);
		SpecialAbility copy = specAbility.copy();
		newItem.setItemName(copy.getAbilityName());
		newItem.setLeafItem(false);
		return newItem;
	}	
}
