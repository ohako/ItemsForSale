package com.ohako.itemcategory.weapons;

import java.util.Map;

import com.ohako.ItemsForSale;
import com.ohako.specialability.CreatureTypeSpecialAbility;
import com.ohako.specialability.creaturetype.ICreatureType;

public class CreatureTypeRangedItem extends RangedItem 
{
	public CreatureTypeRangedItem(String itemName, int itemPrice) 
	{
		super(itemName, itemPrice);
	}

	@Override
	public MeleeOrRangedItem copyItem() 
	{
		Map<Integer, ICreatureType> creatureTypeMap = CreatureTypeSpecialAbility.getCreatureTypeMap();
		ICreatureType creatureType = ItemsForSale.getRandomThing(creatureTypeMap);
		RangedItem itemCopy = new RangedItem(creatureType.format(this.itemName), this.itemPrice);
		return itemCopy;
	}
}
