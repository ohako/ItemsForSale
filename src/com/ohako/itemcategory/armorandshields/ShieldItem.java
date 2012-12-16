package com.ohako.itemcategory.armorandshields;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;
import com.ohako.specialability.CreatureTypeSpecialAbility;
import com.ohako.specialability.EnergyTypeSpecialAbility;
import com.ohako.specialability.ISpecialAbility;
import com.ohako.specialability.SpecialAbility;
import com.ohako.specialability.SpecialAbility.AbilityCategory;

public class ShieldItem extends ArmorOrShieldItem 
{
	private String itemName;
	private int itemPrice;
	private ShieldCategory shieldCategory;
	
	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, ShieldItem>>> specificShieldMap;
	private static Map<Integer, Map<Integer, SpecialAbility>> specialAbilityMap;
	
	public enum ShieldCategory
	{
		BUCKLER,
		LIGHT,
		HEAVY,
		TOWER
	}
	
	public ShieldItem(String itemName, int itemPrice, ShieldCategory shieldCategory)
	{
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.shieldCategory = shieldCategory;
	}
	
	@Override
	protected void populateItem(ArmorOrShieldItem baseArmorOrShield) 
	{
		super.populateItem(baseArmorOrShield);
		
		if (baseArmorOrShield.getItemDegree() != null)
		{
			populateSpecificShield(baseArmorOrShield.getItemDegree(), baseArmorOrShield.getItemDegreeQualifier());
		}
		else
		{
			setPlus(baseArmorOrShield.getPlus());
			List<Integer> plusesToAddPrice = new ArrayList<Integer>();
			plusesToAddPrice.add(getPlus());
			if (baseArmorOrShield.getSpecialAbilities() != null &&
				!baseArmorOrShield.getSpecialAbilities().isEmpty())
			{
				plusesToAddPrice.addAll(populateShieldSpecialAbilities(baseArmorOrShield.getSpecialAbilities()));				
			}
			this.itemName = "+" + this.getPlus() + " " + this.itemName;
			this.itemPrice += addPlusesPrice(plusesToAddPrice);
		}
	}
	
	private List<Integer> populateShieldSpecialAbilities(List<Integer> specialAbilities) 
	{
		List<Integer> plusesToAddPrice = new ArrayList<Integer>();
		if (specialAbilityMap == null)
			specialAbilityMap = new HashMap<Integer, Map<Integer,SpecialAbility>>();
		List<ISpecialAbility> chosenSpecialAbilities = new ArrayList<ISpecialAbility>();
		for (Integer specialAbility : specialAbilities)
		{
			Map<Integer, SpecialAbility> specialAbilityShieldMapByPlus = specialAbilityMap.get(specialAbility);
			if (specialAbilityShieldMapByPlus == null)
			{
				specialAbilityShieldMapByPlus = new LinkedHashMap<Integer, SpecialAbility>();
				populateSpecialAbilityShieldMap(specialAbilityShieldMapByPlus, specialAbility);
				specialAbilityMap.put(specialAbility, specialAbilityShieldMapByPlus);
			}
			ISpecialAbility chosenSpecialAbility = null;
			//TODO: do a better job picking/forbidding specific exceptions (no light armor, adhesive/slick, etc)
			while (chosenSpecialAbility == null)
			{
				chosenSpecialAbility = ItemsForSale.getRandomThing(specialAbilityShieldMapByPlus);
				for (ISpecialAbility alreadyChosenSpecialAbility : chosenSpecialAbilities)
					if (alreadyChosenSpecialAbility.matches(chosenSpecialAbility))
					{
						chosenSpecialAbility = null;
						break;
					}
			}
			ISpecialAbility copiedAbility = chosenSpecialAbility.copy();
			chosenSpecialAbilities.add(copiedAbility);
			this.itemName = copiedAbility.getAbilityName() + " " + this.itemName;
			if (copiedAbility.getAbilityPrice() > 0)
				this.itemPrice += copiedAbility.getAbilityPrice();
			else
				plusesToAddPrice.add(specialAbility);
		}
		return plusesToAddPrice;
	}

	private void populateSpecialAbilityShieldMap(
			Map<Integer, SpecialAbility> plusedSpecialAbilityMap,
			Integer plus) 
	{
		switch (plus)
		{
			case 1:
				plusedSpecialAbilityMap.put(10, new SpecialAbility("poison-resistant", 2250, null));
				plusedSpecialAbilityMap.put(19, new SpecialAbility("arrow catching", 0, null));
				plusedSpecialAbilityMap.put(28, new SpecialAbility("bashing", 0, null));
				plusedSpecialAbilityMap.put(37, new SpecialAbility("blinding", 0, null));
				plusedSpecialAbilityMap.put(46, new SpecialAbility("clangorous", 0, null));
				plusedSpecialAbilityMap.put(55, new CreatureTypeSpecialAbility("%s defiant", 0, null));
				plusedSpecialAbilityMap.put(64, new SpecialAbility("light fortification", 0, AbilityCategory.FORTIFICATION));
				plusedSpecialAbilityMap.put(73, new SpecialAbility("grinding", 0, null));
				plusedSpecialAbilityMap.put(82, new SpecialAbility("impervious", 0, null));
				plusedSpecialAbilityMap.put(91, new SpecialAbility("mirrored", 0, null));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("ramming", 0, null));
				break;
			case 2:
				plusedSpecialAbilityMap.put(15, new SpecialAbility("rallying", 5000, null));
				plusedSpecialAbilityMap.put(30, new EnergyTypeSpecialAbility("wyrmsbreath", 5000, AbilityCategory.WYRMSBREATH));
				plusedSpecialAbilityMap.put(50, new SpecialAbility("animated", 0, null));
				plusedSpecialAbilityMap.put(67, new SpecialAbility("arrow deflection", 0, null));
				plusedSpecialAbilityMap.put(82, new SpecialAbility("merging", 0, null));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("least spell resistance", 0, AbilityCategory.SPELL_RESISTANCE));
				break;
			case 3:
				plusedSpecialAbilityMap.put(15, new SpecialAbility("hosteling", 7000, null));
				plusedSpecialAbilityMap.put(32, new SpecialAbility("radiant", 7500, null));
				plusedSpecialAbilityMap.put(49, new SpecialAbility("moderate fortification", 0, AbilityCategory.FORTIFICATION));
				plusedSpecialAbilityMap.put(66, new SpecialAbility("ghost touch", 0, null));
				plusedSpecialAbilityMap.put(83, new SpecialAbility("lesser spell resistance", 0, null));
				plusedSpecialAbilityMap.put(98, new SpecialAbility("wild", 0, null));
				break;
			case 4:
				plusedSpecialAbilityMap.put(50, new EnergyTypeSpecialAbility("%s resistance", 18000, AbilityCategory.ENERGY_RESISTANCE));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("greater spell resistance", 0, AbilityCategory.SPELL_RESISTANCE));
				break;
			case 5:
				plusedSpecialAbilityMap.put(11, new SpecialAbility("determination", 30000, null));
				plusedSpecialAbilityMap.put(27, new EnergyTypeSpecialAbility("improved %s resistance", 42000, AbilityCategory.ENERGY_RESISTANCE));
				plusedSpecialAbilityMap.put(38, new SpecialAbility("undead controlling", 49000, null));
				plusedSpecialAbilityMap.put(55, new EnergyTypeSpecialAbility("greater %s resistance", 66000, AbilityCategory.ENERGY_RESISTANCE));				
				plusedSpecialAbilityMap.put(70, new SpecialAbility("heavy fortification", 0, AbilityCategory.FORTIFICATION));
				plusedSpecialAbilityMap.put(85, new SpecialAbility("reflecting", 0, null));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("superior spell resistance", 0, AbilityCategory.SPELL_RESISTANCE));
				break;
			default:
				break;
		}
	}

	private void populateSpecificShield(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) 
	{
		if (specificShieldMap == null)
			specificShieldMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, ShieldItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, ShieldItem>> specificShieldMapByDegree = specificShieldMap.get(itemDegree);
		if (specificShieldMapByDegree == null)
		{
			specificShieldMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer, ShieldItem>>();
			specificShieldMap.put(itemDegree, specificShieldMapByDegree);
		}
		Map<Integer, ShieldItem> specificShieldMapByDegreeAndQualifier = specificShieldMapByDegree.get(itemDegreeQualifier);
		if (specificShieldMapByDegreeAndQualifier == null)
		{
			specificShieldMapByDegreeAndQualifier = new LinkedHashMap<Integer, ShieldItem>();
			populateSpecificShieldMap(specificShieldMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificShieldMapByDegree.put(itemDegreeQualifier, specificShieldMapByDegreeAndQualifier);
		}
		ShieldItem specificShieldItem = ItemsForSale.getRandomThing(specificShieldMapByDegreeAndQualifier);
		this.itemName = String.format(specificShieldItem.itemName(), this.itemName);
		if (specificShieldItem.itemPrice < 0)
			this.itemPrice = this.itemPrice + (-1 * specificShieldItem.itemPrice);
		else
			this.itemPrice = specificShieldItem.itemPrice;
		if (specificShieldItem.shieldCategory != null)
			this.shieldCategory = specificShieldItem.shieldCategory;
	}
	
	private void populateSpecificShieldMap(
			Map<Integer, ShieldItem> qualifiedShieldMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) 
	{
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedShieldMap.put(20, new ShieldItem("living steel heavy shield", 120, ShieldCategory.HEAVY));
						qualifiedShieldMap.put(45, new ShieldItem("darkwood buckler", 203, ShieldCategory.LIGHT));
						qualifiedShieldMap.put(70, new ShieldItem("darkwood shield", 257, ShieldCategory.HEAVY));
						qualifiedShieldMap.put(100, new ShieldItem("mithral heavy shield", 1020, ShieldCategory.HEAVY));
						break;
					case GREATER:
						qualifiedShieldMap.put(30, new ShieldItem("zombie skin shield", 2159, ShieldCategory.LIGHT));
						//TODO: generate possible random scroll on caster's shield
						qualifiedShieldMap.put(75, new ShieldItem("caster's shield", 3153, ShieldCategory.LIGHT));
						qualifiedShieldMap.put(100, new ShieldItem("burglar's buckler", 4655, ShieldCategory.BUCKLER));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedShieldMap.put(35, new ShieldItem("spined shield", 5580, ShieldCategory.HEAVY));
						qualifiedShieldMap.put(50, new ShieldItem("dragonslayer's shield", 7170, ShieldCategory.HEAVY));
						qualifiedShieldMap.put(65, new ShieldItem("collapsible tower", 8170, ShieldCategory.HEAVY));
						qualifiedShieldMap.put(100, new ShieldItem("lion's shield", 8170, ShieldCategory.HEAVY));
						break;
					case GREATER:
						qualifiedShieldMap.put(20, new ShieldItem("greater caster's shield", 10153, ShieldCategory.LIGHT));
						qualifiedShieldMap.put(40, new ShieldItem("celestial shield", 13170, ShieldCategory.HEAVY));
						qualifiedShieldMap.put(60, new ShieldItem("maelstrom shield", 15170, ShieldCategory.HEAVY));
						qualifiedShieldMap.put(80, new ShieldItem("volcanic shield", 15170, ShieldCategory.HEAVY));
						qualifiedShieldMap.put(100, new ShieldItem("tempest shield", 15170, ShieldCategory.HEAVY));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedShieldMap.put(20, new ShieldItem("battlement shield", 16180, ShieldCategory.TOWER));
						qualifiedShieldMap.put(40, new ShieldItem("winged shield", 17257, ShieldCategory.HEAVY));
						qualifiedShieldMap.put(60, new ShieldItem("avalanche shield", 19170, ShieldCategory.HEAVY));
						qualifiedShieldMap.put(80, new ShieldItem("fortress shield", 19180, ShieldCategory.TOWER));
						qualifiedShieldMap.put(100, new ShieldItem("wyrmslayer's shield", 20170, ShieldCategory.HEAVY));
						break;
					case GREATER:
						qualifiedShieldMap.put(20, new ShieldItem("spell ward tower shield", 25180, ShieldCategory.TOWER));
						qualifiedShieldMap.put(35, new ShieldItem("quick block buckler", 36155, ShieldCategory.BUCKLER));
						qualifiedShieldMap.put(50, new ShieldItem("belligerent shield", 36170, ShieldCategory.HEAVY));
						qualifiedShieldMap.put(65, new ShieldItem("force tower", 46030, ShieldCategory.TOWER));
						qualifiedShieldMap.put(85, new ShieldItem("absorbing shield", 50170, ShieldCategory.HEAVY));
						qualifiedShieldMap.put(100, new ShieldItem("elysian shield", 52620, ShieldCategory.TOWER));
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}

	public String itemName()
	{
		return itemName;
	}
	public int itemPrice()
	{
		return itemPrice;
	}
	
	@Override
	public ArmorOrShieldItem copyItem() 
	{
		ShieldItem itemCopy = new ShieldItem(this.itemName, this.itemPrice, this.shieldCategory);
		return itemCopy;
	}	
}
