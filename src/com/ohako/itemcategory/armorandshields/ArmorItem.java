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

public class ArmorItem extends ArmorOrShieldItem 
{
	private String itemName;
	private int itemPrice;
	private ArmorCategory armorCategory;
	
	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, ArmorItem>>> specificArmorMap;
	private static Map<Integer, Map<Integer, SpecialAbility>> specialAbilityMap;
	
	public enum ArmorCategory
	{
		LIGHT,
		MEDIUM,
		HEAVY
	}
	
	public ArmorItem(String itemName, int itemPrice, ArmorCategory armorCategory) 
	{
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.armorCategory = armorCategory;
	}
	
	@Override
	protected void populateItem(ArmorOrShieldItem baseArmorOrShield) 
	{
		super.populateItem(baseArmorOrShield);
		
		if (baseArmorOrShield.getItemDegree() != null)
		{
			populateSpecificArmor(baseArmorOrShield.getItemDegree(), baseArmorOrShield.getItemDegreeQualifier());
		}
		else
		{
			setPlus(baseArmorOrShield.getPlus());
			List<Integer> plusesToAddPrice = new ArrayList<Integer>();
			plusesToAddPrice.add(getPlus());
			if (baseArmorOrShield.getSpecialAbilities() != null &&
				!baseArmorOrShield.getSpecialAbilities().isEmpty())
			{
				plusesToAddPrice.addAll(populateArmorSpecialAbilities(baseArmorOrShield.getSpecialAbilities()));				
			}
			this.itemName = "+" + this.getPlus() + " " + this.itemName;
			this.itemPrice += addPlusesPrice(plusesToAddPrice);
		}
	}

	private List<Integer> populateArmorSpecialAbilities(List<Integer> specialAbilities) 
	{
		List<Integer> plusesToAddPrice = new ArrayList<Integer>();
		if (specialAbilityMap == null)
			specialAbilityMap = new HashMap<Integer, Map<Integer,SpecialAbility>>();
		List<ISpecialAbility> chosenSpecialAbilities = new ArrayList<ISpecialAbility>();
		for (Integer specialAbility : specialAbilities)
		{
			Map<Integer, SpecialAbility> specialAbilityArmorMapByPlus = specialAbilityMap.get(specialAbility);
			if (specialAbilityArmorMapByPlus == null)
			{
				specialAbilityArmorMapByPlus = new LinkedHashMap<Integer, SpecialAbility>();
				populateSpecialAbilityArmorMap(specialAbilityArmorMapByPlus, specialAbility);
				specialAbilityMap.put(specialAbility, specialAbilityArmorMapByPlus);
			}
			ISpecialAbility chosenSpecialAbility = null;
			//TODO: do a better job picking/forbidding specific exceptions (no light armor, adhesive/slick, etc)
			while (chosenSpecialAbility == null)
			{
				chosenSpecialAbility = ItemsForSale.getRandomThing(specialAbilityArmorMapByPlus);
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

	private void populateSpecialAbilityArmorMap(
			Map<Integer, SpecialAbility> plusedSpecialAbilityMap,
			Integer plus) 
	{
		switch (plus)
		{
			case 1:
				plusedSpecialAbilityMap.put(6, new SpecialAbility("benevolent", 2000, null));
				plusedSpecialAbilityMap.put(12, new SpecialAbility("poison-resistant", 2250, null));
				plusedSpecialAbilityMap.put(18, new SpecialAbility("balanced", 0, null));
				plusedSpecialAbilityMap.put(24, new SpecialAbility("bitter", 0, null));
				plusedSpecialAbilityMap.put(30, new SpecialAbility("bolstering", 0, null));
				plusedSpecialAbilityMap.put(36, new SpecialAbility("brawling", 0, null));
				plusedSpecialAbilityMap.put(42, new SpecialAbility("champion", 0, null));
				plusedSpecialAbilityMap.put(48, new SpecialAbility("dastard", 0, null));
				plusedSpecialAbilityMap.put(54, new SpecialAbility("deathless", 0, null));
				plusedSpecialAbilityMap.put(60, new CreatureTypeSpecialAbility("%s defiant", 0, null));
				plusedSpecialAbilityMap.put(66, new SpecialAbility("light fortification", 0, AbilityCategory.FORTIFICATION));
				plusedSpecialAbilityMap.put(71, new SpecialAbility("grinding", 0, null));
				plusedSpecialAbilityMap.put(76, new SpecialAbility("impervious", 0, null));
				plusedSpecialAbilityMap.put(82, new SpecialAbility("mirrored", 0, null));
				plusedSpecialAbilityMap.put(88, new SpecialAbility("spell storing", 0, null));
				plusedSpecialAbilityMap.put(94, new SpecialAbility("stanching", 0, null));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("warding", 0, null));
				break;
			case 2:
				plusedSpecialAbilityMap.put(12, new SpecialAbility("glamered", 2700, null));
				plusedSpecialAbilityMap.put(24, new SpecialAbility("jousting", 3750, null));
				plusedSpecialAbilityMap.put(38, new SpecialAbility("shadow", 3750, AbilityCategory.SHADOW));
				plusedSpecialAbilityMap.put(52, new SpecialAbility("slick", 3750, AbilityCategory.VISCOSITY));
				plusedSpecialAbilityMap.put(64, new SpecialAbility("expeditious", 4000, null));
				plusedSpecialAbilityMap.put(76, new SpecialAbility("creeping", 5000, null));
				plusedSpecialAbilityMap.put(88, new SpecialAbility("rallying", 5000, null));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("least spell resistance", 0, AbilityCategory.SPELL_RESISTANCE));
				break;
			case 3:
				plusedSpecialAbilityMap.put(8, new SpecialAbility("adhesive", 7000, AbilityCategory.VISCOSITY));
				plusedSpecialAbilityMap.put(17, new SpecialAbility("hosteling", 7500, null));
				plusedSpecialAbilityMap.put(26, new SpecialAbility("radiant", 7500, null));
				plusedSpecialAbilityMap.put(36, new SpecialAbility("delving", 10000, null));
				plusedSpecialAbilityMap.put(45, new SpecialAbility("putrid", 10000, null));
				plusedSpecialAbilityMap.put(55, new SpecialAbility("moderate fortification", 0, AbilityCategory.FORTIFICATION));
				plusedSpecialAbilityMap.put(65, new SpecialAbility("ghost touch", 0, null));
				plusedSpecialAbilityMap.put(74, new SpecialAbility("invulnerability", 0, null));
				plusedSpecialAbilityMap.put(84, new SpecialAbility("lesser spell resistance", 0, AbilityCategory.SPELL_RESISTANCE));
				plusedSpecialAbilityMap.put(92, new SpecialAbility("titanic", 0, null));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("wild", 0, null));
				break;
			case 4:
				plusedSpecialAbilityMap.put(16, new SpecialAbility("harmonizing", 15000, null));
				plusedSpecialAbilityMap.put(33, new SpecialAbility("improved shadow", 15000, AbilityCategory.SHADOW));
				plusedSpecialAbilityMap.put(50, new SpecialAbility("improved slick", 15000, AbilityCategory.VISCOSITY));
				plusedSpecialAbilityMap.put(67, new EnergyTypeSpecialAbility("%s resistance", 18000, AbilityCategory.ENERGY_RESISTANCE));
				plusedSpecialAbilityMap.put(83, new SpecialAbility("martyring", 18000, null));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("greater spell resistance", 0, AbilityCategory.SPELL_RESISTANCE));
				break;
			case 5:
				plusedSpecialAbilityMap.put(8, new SpecialAbility("righteous", 27000, null));
				plusedSpecialAbilityMap.put(15, new SpecialAbility("unbound", 27000, null));
				plusedSpecialAbilityMap.put(23, new SpecialAbility("unrighteous", 27000, null));
				plusedSpecialAbilityMap.put(30, new SpecialAbility("vigilant", 27000, null));				
				plusedSpecialAbilityMap.put(37, new SpecialAbility("determination", 30000, null));
				plusedSpecialAbilityMap.put(45, new SpecialAbility("greater shadow", 33750, AbilityCategory.SHADOW));
				plusedSpecialAbilityMap.put(53, new SpecialAbility("greater slick", 33750, AbilityCategory.VISCOSITY));
				plusedSpecialAbilityMap.put(61, new EnergyTypeSpecialAbility("improved %s resistance", 42000, AbilityCategory.ENERGY_RESISTANCE));
				plusedSpecialAbilityMap.put(69, new SpecialAbility("etherealness", 49000, null));
				plusedSpecialAbilityMap.put(76, new SpecialAbility("undead controlling", 49000, null));
				plusedSpecialAbilityMap.put(85, new EnergyTypeSpecialAbility("greater %s resistance", 66000, AbilityCategory.ENERGY_RESISTANCE));
				plusedSpecialAbilityMap.put(92, new SpecialAbility("heavy fortification", 0, AbilityCategory.FORTIFICATION));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("superior spell resistance", 0, AbilityCategory.SPELL_RESISTANCE));
				break;
			default:
				break;
		}
	}

	private void populateSpecificArmor(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) 
	{
		if (specificArmorMap == null)
			specificArmorMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, ArmorItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, ArmorItem>> specificArmorMapByDegree = specificArmorMap.get(itemDegree);
		if (specificArmorMapByDegree == null)
		{
			specificArmorMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,ArmorItem>>();
			specificArmorMap.put(itemDegree, specificArmorMapByDegree);
		}
		Map<Integer, ArmorItem> specificArmorMapByDegreeAndQualifier = specificArmorMapByDegree.get(itemDegreeQualifier);
		if (specificArmorMapByDegreeAndQualifier == null)
		{
			specificArmorMapByDegreeAndQualifier = new LinkedHashMap<Integer, ArmorItem>();
			populateSpecificArmorMap(specificArmorMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificArmorMapByDegree.put(itemDegreeQualifier, specificArmorMapByDegreeAndQualifier);
		}
		ArmorItem specificArmorItem = ItemsForSale.getRandomThing(specificArmorMapByDegreeAndQualifier);
		this.itemName = String.format(specificArmorItem.itemName(), this.itemName);
		if (specificArmorItem.itemPrice < 0)
			this.itemPrice = this.itemPrice + (-1 * specificArmorItem.itemPrice);
		else
			this.itemPrice = specificArmorItem.itemPrice;
		if (specificArmorItem.armorCategory != null)
			this.armorCategory = specificArmorItem.armorCategory;
	}
	
	private void populateSpecificArmorMap(
			Map<Integer, ArmorItem> qualifiedArmorMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) 
	{
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedArmorMap.put(50, new ArmorItem("mithral shirt", 	1100, ArmorCategory.LIGHT));
						qualifiedArmorMap.put(100, new ArmorItem("masterwork %s", 	-150, null));						
						break;
					case GREATER:
						qualifiedArmorMap.put(33, new ArmorItem("mistmail", 		2250, ArmorCategory.LIGHT));
						qualifiedArmorMap.put(66, new ArmorItem("otyugh hide", 		2565, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(100, new ArmorItem("dragonide plate", 3300, ArmorCategory.HEAVY));						
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedArmorMap.put(33, new ArmorItem("elven chain", 		5150, ArmorCategory.LIGHT));
						qualifiedArmorMap.put(66, new ArmorItem("rhino hide", 		5165, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(100, new ArmorItem("morlock hide", 	8910, ArmorCategory.LIGHT));						
						break;
					case GREATER:
						qualifiedArmorMap.put(15, new ArmorItem("adamantine breastplate", 	10200, ArmorCategory.MEDIUM));
						qualifiedArmorMap.put(25, new ArmorItem("soothsayer's rainment", 	10300, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(38, new ArmorItem("equestrian plate", 		10650, ArmorCategory.HEAVY));						
						qualifiedArmorMap.put(50, new ArmorItem("enchanted eelskin", 		11160, ArmorCategory.LIGHT));
						qualifiedArmorMap.put(62, new ArmorItem("boneless leather", 		12160, ArmorCategory.LIGHT));						
						qualifiedArmorMap.put(72, new ArmorItem("murderer's blackcloth", 	12405, ArmorCategory.LIGHT));						
						qualifiedArmorMap.put(86, new ArmorItem("folding plate", 			12650, ArmorCategory.HEAVY));						
						qualifiedArmorMap.put(100, new ArmorItem("breastplate of vanishing", 15200, ArmorCategory.MEDIUM));						
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedArmorMap.put(13, new ArmorItem("armor of insults", 		16175, ArmorCategory.LIGHT));
						qualifiedArmorMap.put(29, new ArmorItem("dwarven plate", 			16500, ArmorCategory.HEAVY));						
						qualifiedArmorMap.put(45, new ArmorItem("banded mail of luck", 		18900, ArmorCategory.HEAVY));						
						qualifiedArmorMap.put(58, new ArmorItem("catskin leather", 			18910, ArmorCategory.LIGHT));
						qualifiedArmorMap.put(71, new ArmorItem("celestial armor", 			22400, ArmorCategory.LIGHT));						
						qualifiedArmorMap.put(84, new ArmorItem("buccaneer's breastplate", 	23850, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(100, new ArmorItem("plate armor of the deep", 24650, ArmorCategory.HEAVY));						
						break;
					case GREATER:
						qualifiedArmorMap.put(10, new ArmorItem("breastplate of command", 		25400, ArmorCategory.MEDIUM));
						qualifiedArmorMap.put(14, new ArmorItem("forsaken banded mail", 		25400, ArmorCategory.HEAVY));						
						qualifiedArmorMap.put(24, new ArmorItem("mithral full plate of speed", 	26500, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(28, new ArmorItem("warden of the woods", 			29350, ArmorCategory.MEDIUM));
						qualifiedArmorMap.put(32, new ArmorItem("scarab breastplate", 			32350, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(38, new ArmorItem("ogre-hide armor", 				39165, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(42, new ArmorItem("hamatula hide", 				44215, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(48, new ArmorItem("hill giant-hide armor", 		46665, ArmorCategory.MEDIUM));
						qualifiedArmorMap.put(52, new ArmorItem("demon armor", 					52260, ArmorCategory.HEAVY));						
						qualifiedArmorMap.put(54, new ArmorItem("stone giant-hide armor", 		54165, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(56, new ArmorItem("fire giant-hide armor", 		54165, ArmorCategory.MEDIUM));
						qualifiedArmorMap.put(58, new ArmorItem("frost giant-hide armor", 		54165, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(64, new ArmorItem("troll-hide armor", 			59165, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(70, new ArmorItem("mail of malevolence", 			61300, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(76, new ArmorItem("cloud giant-hide armor", 		69165, ArmorCategory.MEDIUM));						
						qualifiedArmorMap.put(82, new ArmorItem("storm giant-hide armor", 		76665, ArmorCategory.MEDIUM));
						qualifiedArmorMap.put(88, new ArmorItem("daystar half-plate", 			81250, ArmorCategory.HEAVY));						
						qualifiedArmorMap.put(96, new ArmorItem("invincible armor", 			137650, ArmorCategory.HEAVY));						
						qualifiedArmorMap.put(100, new ArmorItem("prismatic plate", 			160650, ArmorCategory.HEAVY));						
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
		ArmorItem itemCopy = new ArmorItem(this.itemName, this.itemPrice, this.armorCategory);
		return itemCopy;
	}	
}
