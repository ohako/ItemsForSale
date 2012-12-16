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

public class MeleeItem extends MeleeOrRangedItem {

	private String itemName;
	private int itemPrice;
	private MeleeCategory meleeCategory;
	
	private static Map<Integer, Map<Integer, SpecialAbility>> specialAbilityMap;

	public enum MeleeCategory
	{
		UNARMED,
		LIGHT,
		ONE_HANDED,
		TWO_HANDED
	}

	public MeleeItem(String itemName, int itemPrice, MeleeCategory meleeCategory) 
	{
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.meleeCategory = meleeCategory;
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
				plusesToAddPrice.addAll(populateMeleeSpecialAbilities(baseMeleeOrRanged.getSpecialAbilities()));				
			}
			this.itemName = "+" + this.getPlus() + " " + this.itemName;
			this.itemPrice += addPlusesPrice(plusesToAddPrice);
		}
	}

	private List<Integer> populateMeleeSpecialAbilities(List<Integer> specialAbilities) 
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
				populateSpecialAbilityMeleeMap(specialAbilityMeleeMapByPlus, specialAbility);
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

	private void populateSpecialAbilityMeleeMap(
			Map<Integer, SpecialAbility> plusedSpecialAbilityMap,
			Integer plus) {
		switch (plus)
		{
			case 1:
				plusedSpecialAbilityMap.put(1, new SpecialAbility("impervious", 3000));
				plusedSpecialAbilityMap.put(2, new SpecialAbility("glamered", 4000));
				plusedSpecialAbilityMap.put(3, new SpecialAbility("allying", 0));
				plusedSpecialAbilityMap.put(8, new CreatureTypeSpecialAbility("%s bane", 0));
				plusedSpecialAbilityMap.put(9, new SpecialAbility("benevolent", 0));
				plusedSpecialAbilityMap.put(10, new SpecialAbility("called", 0));
				plusedSpecialAbilityMap.put(12, new SpecialAbility("conductive", 0));
				plusedSpecialAbilityMap.put(16, new SpecialAbility("corrosive", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(17, new SpecialAbility("countering", 0));
				plusedSpecialAbilityMap.put(18, new SpecialAbility("courageous", 0));
				plusedSpecialAbilityMap.put(19, new SpecialAbility("cruel", 0));
				plusedSpecialAbilityMap.put(21, new SpecialAbility("cunning", 0));
				plusedSpecialAbilityMap.put(22, new SpecialAbility("deadly", 0));
				plusedSpecialAbilityMap.put(26, new SpecialAbility("defending", 0));
				plusedSpecialAbilityMap.put(27, new SpecialAbility("dispelling", 0));
				plusedSpecialAbilityMap.put(33, new SpecialAbility("flaming", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(39, new SpecialAbility("frost", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(41, new SpecialAbility("furious", 0));
				plusedSpecialAbilityMap.put(45, new SpecialAbility("ghost touch", 0));
				plusedSpecialAbilityMap.put(47, new SpecialAbility("grayflame", 0));
				plusedSpecialAbilityMap.put(48, new SpecialAbility("grounding", 0));
				plusedSpecialAbilityMap.put(49, new SpecialAbility("guardian", 0));
				plusedSpecialAbilityMap.put(50, new SpecialAbility("heartseeker", 0));
				plusedSpecialAbilityMap.put(52, new SpecialAbility("huntsman", 0));
				plusedSpecialAbilityMap.put(54, new SpecialAbility("jurist", 0));
				plusedSpecialAbilityMap.put(59, new SpecialAbility("keen", 0));
				plusedSpecialAbilityMap.put(61, new SpecialAbility("ki focus", 0));
				plusedSpecialAbilityMap.put(62, new SpecialAbility("limning", 0));
				plusedSpecialAbilityMap.put(64, new SpecialAbility("menacing", 0));
				plusedSpecialAbilityMap.put(65, new SpecialAbility("merciful", 0));
				plusedSpecialAbilityMap.put(68, new SpecialAbility("mighty cleaving", 0));
				plusedSpecialAbilityMap.put(69, new SpecialAbility("mimetic", 0));
				plusedSpecialAbilityMap.put(70, new SpecialAbility("neutralizing", 0));
				plusedSpecialAbilityMap.put(71, new SpecialAbility("ominous", 0));
				plusedSpecialAbilityMap.put(72, new SpecialAbility("planar", 0));
				plusedSpecialAbilityMap.put(73, new SpecialAbility("quenching", 0));
				plusedSpecialAbilityMap.put(74, new SpecialAbility("seaborne", 0));
				plusedSpecialAbilityMap.put(80, new SpecialAbility("shock", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(85, new SpecialAbility("spell storing", 0));
				plusedSpecialAbilityMap.put(86, new SpecialAbility("thawing", 0));
				plusedSpecialAbilityMap.put(91, new SpecialAbility("throwing", 0));
				plusedSpecialAbilityMap.put(96, new SpecialAbility("thundering", 0));
				plusedSpecialAbilityMap.put(97, new SpecialAbility("valiant", 0));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("vicious", 0));
				break;
			case 2:
				plusedSpecialAbilityMap.put(1, new SpecialAbility("advancing", 0));
				plusedSpecialAbilityMap.put(10, new SpecialAbility("anarchic", 0, AbilityCategory.ALIGNMENT));
				plusedSpecialAbilityMap.put(19, new SpecialAbility("anchoring", 0));
				plusedSpecialAbilityMap.put(20, new SpecialAbility("axiomatic", 0, AbilityCategory.ALIGNMENT));
				plusedSpecialAbilityMap.put(27, new SpecialAbility("corrosive burst", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(28, new SpecialAbility("defiant", 0));
				plusedSpecialAbilityMap.put(29, new SpecialAbility("dispelling burst", 0));
				plusedSpecialAbilityMap.put(38, new SpecialAbility("disruption", 0));
				plusedSpecialAbilityMap.put(47, new SpecialAbility("flaming burst", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(48, new SpecialAbility("furyborn", 0));
				plusedSpecialAbilityMap.put(49, new SpecialAbility("glorious", 0));
				plusedSpecialAbilityMap.put(58, new SpecialAbility("holy", 0, AbilityCategory.ALIGNMENT));
				plusedSpecialAbilityMap.put(67, new SpecialAbility("icy burst", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(68, new SpecialAbility("igniting", 0));
				plusedSpecialAbilityMap.put(69, new SpecialAbility("impact", 0));
				plusedSpecialAbilityMap.put(70, new SpecialAbility("invigorating", 0));
				plusedSpecialAbilityMap.put(71, new SpecialAbility("ki intensifying", 0));
				plusedSpecialAbilityMap.put(72, new SpecialAbility("lifesurge", 0));
				plusedSpecialAbilityMap.put(73, new SpecialAbility("negating", 0));
				plusedSpecialAbilityMap.put(74, new SpecialAbility("phase locking", 0));
				plusedSpecialAbilityMap.put(83, new SpecialAbility("shocking burst", 0, AbilityCategory.ENERGY));
				plusedSpecialAbilityMap.put(84, new SpecialAbility("stalking", 0));
				plusedSpecialAbilityMap.put(91, new SpecialAbility("unholy", 0, AbilityCategory.ALIGNMENT));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("wounding", 0));
				break;
			case 3:
				plusedSpecialAbilityMap.put(20, new SpecialAbility("nullifying", 0));
				plusedSpecialAbilityMap.put(40, new SpecialAbility("repositioning", 0));
				plusedSpecialAbilityMap.put(80, new SpecialAbility("speed", 0));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("spellstealing", 0));
				break;
			case 4:
			case 5:
				plusedSpecialAbilityMap.put(40, new SpecialAbility("brilliant energy", -4));
				plusedSpecialAbilityMap.put(80, new SpecialAbility("dancing", -4));
				plusedSpecialAbilityMap.put(90, new SpecialAbility("vorpal", -5));
				plusedSpecialAbilityMap.put(95, new SpecialAbility("transformative", 10000));
				plusedSpecialAbilityMap.put(100, new SpecialAbility("dueling", 14000));
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
		MeleeItem itemCopy = new MeleeItem(this.itemName, this.itemPrice, this.meleeCategory);
		return itemCopy;
	}	
}
