package com.ohako.itemcategory.weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohako.ItemsForSale;
import com.ohako.specialability.CreatureTypeSpecialAbility;
import com.ohako.specialability.SpecialAbility;
import com.ohako.specialability.SpecialAbility.AbilityCategory;

public class RangedItem extends MeleeOrRangedItem 
{
	protected String itemName;
	protected int itemPrice;
	private static Map<Integer, Map<Integer, SpecialAbility>> specialAbilityMap;


	public RangedItem(String itemName, int itemPrice) 
	{
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	@Override
	protected void populateItem(MeleeOrRangedItem baseMeleeOrRanged) 
	{
		super.populateItem(baseMeleeOrRanged);
		
		if (baseMeleeOrRanged.getItemDegree() != null)
		{
			MeleeOrRangedItem randomItem = populateSpecificWeapon(baseMeleeOrRanged.getItemDegree(), baseMeleeOrRanged.getItemDegreeQualifier());
			this.itemName = randomItem.itemName();
			this.itemPrice = randomItem.itemPrice();
		}
		else
		{
			setPlus(baseMeleeOrRanged.getPlus());
			List<Integer> plusesToAddPrice = new ArrayList<Integer>();
			plusesToAddPrice.add(getPlus());
			if (baseMeleeOrRanged.getSpecialAbilities() != null &&
				!baseMeleeOrRanged.getSpecialAbilities().isEmpty())
			{
				plusesToAddPrice.addAll(populateRangedSpecialAbilities(baseMeleeOrRanged.getSpecialAbilities()));				
			}
			this.itemName = "+" + this.getPlus() + " " + this.itemName;
			this.itemPrice += addPlusesPrice(plusesToAddPrice);
		}
	}

	private List<Integer> populateRangedSpecialAbilities(List<Integer> specialAbilities) 
	{
		List<Integer> plusesToAddPrice = new ArrayList<Integer>();
		if (specialAbilityMap == null)
			specialAbilityMap = new HashMap<Integer, Map<Integer,SpecialAbility>>();
		List<SpecialAbility> chosenSpecialAbilities = new ArrayList<SpecialAbility>();
		for (Integer specialAbility : specialAbilities)
		{
			Map<Integer, SpecialAbility> specialAbilityMeleeMapByPlus = specialAbilityMap.get(specialAbility);
			if (specialAbilityMeleeMapByPlus == null)
			{
				specialAbilityMeleeMapByPlus = new LinkedHashMap<Integer, SpecialAbility>();
				populateSpecialAbilityRangedMap(specialAbilityMeleeMapByPlus, specialAbility);
				specialAbilityMap.put(specialAbility, specialAbilityMeleeMapByPlus);
			}
			SpecialAbility chosenSpecialAbility = null;
			//TODO: do a better job picking/forbidding specific exceptions (no light armor, adhesive/slick, etc)
			while (chosenSpecialAbility == null)
			{
				chosenSpecialAbility = ItemsForSale.getRandomThing(specialAbilityMeleeMapByPlus).copy();
				for (SpecialAbility alreadyChosenSpecialAbility : chosenSpecialAbilities)
					if (alreadyChosenSpecialAbility.matches(chosenSpecialAbility))
					{
						chosenSpecialAbility = null;
						break;
					}
			}
			chosenSpecialAbilities.add(chosenSpecialAbility);
			this.itemName = chosenSpecialAbility.getAbilityName() + " " + this.itemName;
			if (chosenSpecialAbility.getAbilityPrice() > 0)
				this.itemPrice += chosenSpecialAbility.getAbilityPrice();
			else if (chosenSpecialAbility.getAbilityPrice() < 0)
				plusesToAddPrice.add(chosenSpecialAbility.getAbilityPrice() * -1);
			else
				plusesToAddPrice.add(specialAbility);
		}
		return plusesToAddPrice;
	}

	private void populateSpecialAbilityRangedMap(
			Map<Integer, SpecialAbility> plusedSpecialAbilityMap,
			Integer plus) {
		switch (plus)
		{
			case 1:
				plusedSpecialAbilityMap.put(1, new SpecialAbility("adaptive", 1000));
				plusedSpecialAbilityMap.put(2, new SpecialAbility("impervious", 3000));
				plusedSpecialAbilityMap.put(3, new SpecialAbility("glamered", 4000));
				plusedSpecialAbilityMap.put(6, new SpecialAbility("allying", 0));
				plusedSpecialAbilityMap.put(15, new CreatureTypeSpecialAbility("%s bane", 0));
				plusedSpecialAbilityMap.put(16, new SpecialAbility("called", 0));
				plusedSpecialAbilityMap.put(19, new SpecialAbility("conductive", 0));
				plusedSpecialAbilityMap.put(20, new SpecialAbility("conserving", 0));
				plusedSpecialAbilityMap.put(24, new SpecialAbility("corrosive", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(25, new SpecialAbility("cruel", 0));
				plusedSpecialAbilityMap.put(28, new SpecialAbility("cunning", 0));
				plusedSpecialAbilityMap.put(36, new SpecialAbility("distance", 0));
				plusedSpecialAbilityMap.put(45, new SpecialAbility("flaming", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(54, new SpecialAbility("frost", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(58, new SpecialAbility("huntsman", 0));
				plusedSpecialAbilityMap.put(62, new SpecialAbility("jurist", 0));
				plusedSpecialAbilityMap.put(63, new SpecialAbility("limning", 0));
				plusedSpecialAbilityMap.put(64, new SpecialAbility("lucky", 0));
				plusedSpecialAbilityMap.put(66, new SpecialAbility("merciful", 0));
				plusedSpecialAbilityMap.put(67, new SpecialAbility("planar", 0));
				plusedSpecialAbilityMap.put(68, new SpecialAbility("reliable", 0));
				plusedSpecialAbilityMap.put(76, new SpecialAbility("returning", 0));
				plusedSpecialAbilityMap.put(84, new SpecialAbility("seeking", 0));
				plusedSpecialAbilityMap.put(92, new SpecialAbility("shock", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("thundering", 0));
				break;
			case 2:
				plusedSpecialAbilityMap.put(10, new SpecialAbility("anarchic", 0, AbilityCategory.ALIGNMENT));
				plusedSpecialAbilityMap.put(13, new SpecialAbility("anchoring", 0));
				plusedSpecialAbilityMap.put(23, new SpecialAbility("axiomatic", 0, AbilityCategory.ALIGNMENT));
				plusedSpecialAbilityMap.put(31, new SpecialAbility("corrosive burst", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(34, new SpecialAbility("lesser designating", 0));
				plusedSpecialAbilityMap.put(37, new SpecialAbility("endless ammunition", 0));
				plusedSpecialAbilityMap.put(48, new SpecialAbility("flaming burst", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(58, new SpecialAbility("holy", 0, AbilityCategory.ALIGNMENT));
				plusedSpecialAbilityMap.put(69, new SpecialAbility("icy burst", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(73, new SpecialAbility("igniting", 0));
				plusedSpecialAbilityMap.put(76, new SpecialAbility("phase locking", 0));
				plusedSpecialAbilityMap.put(86, new SpecialAbility("shocking burst", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(90, new SpecialAbility("stalking", 0));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("unholy", 0, AbilityCategory.ALIGNMENT));
				break;
			case 3:
			case 4:
			case 5:
				plusedSpecialAbilityMap.put(25, new SpecialAbility("greater lucky", -3));
				plusedSpecialAbilityMap.put(45, new SpecialAbility("greater reliable", -3));
				plusedSpecialAbilityMap.put(85, new SpecialAbility("speed", -3));
				plusedSpecialAbilityMap.put(94, new SpecialAbility("brilliant energy", -4));
				plusedSpecialAbilityMap.put(96, new SpecialAbility("greater designating", -4));
				plusedSpecialAbilityMap.put(98, new SpecialAbility("nimble shot", -4));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("second chance", -4));
				break;
			default:
				break;
		}
	}

	@Override
	public String itemName() {
		return itemName;
	}

	@Override
	public int itemPrice() {
		return itemPrice;
	}

	@Override
	public MeleeOrRangedItem copyItem() 
	{
		RangedItem itemCopy = new RangedItem(this.itemName, this.itemPrice);
		return itemCopy;
	}	
}