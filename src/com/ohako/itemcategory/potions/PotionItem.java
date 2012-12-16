package com.ohako.itemcategory.potions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;

public class PotionItem extends Item 
{
	private int potionLevel;
	private String itemName;
	private int itemPrice;
	private PotionRarity potionRarity;
	
	private static Map<Integer, PotionRarity> potionRarityMap;
	private static Map<Integer, Map<PotionRarity, Map<Integer, PotionItem>>> potionMap;
	
	public enum PotionRarity
	{
		COMMON,
		UNCOMMON
	}	
	
	public PotionItem(int potionLevel)
	{
		this.potionLevel = potionLevel;
	}
	
	public PotionItem(String itemName, int itemPrice)
	{
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	@Override
	public String itemName() 
	{
		return itemName;
	}

	@Override
	public int itemPrice() 
	{
		return itemPrice;
	}

	@Override
	public void generateItem() 
	{
		generatePotionRarity();
		generatePotionFromLevelAndRarity();	
		itemName = "potion of " + itemName;
		leafItem = true;
	}

	private void generatePotionFromLevelAndRarity() 
	{
		if (potionMap == null)
			potionMap = new HashMap<Integer, Map<PotionRarity,Map<Integer,PotionItem>>>();
		Map<PotionRarity, Map<Integer, PotionItem>> potionByLevelMap = potionMap.get(potionLevel);
		if (potionByLevelMap == null)
		{
			potionByLevelMap = new HashMap<PotionRarity, Map<Integer,PotionItem>>();
			potionMap.put(potionLevel, potionByLevelMap);
		}
		Map<Integer, PotionItem> potionByRarityMap = potionByLevelMap.get(potionRarity);
		if (potionByRarityMap == null)
		{
			potionByRarityMap = new LinkedHashMap<Integer, PotionItem>();
			potionByLevelMap.put(potionRarity, potionByRarityMap);
			populatePotionMap(potionByRarityMap, potionLevel, potionRarity);
		}
		PotionItem potion = ItemsForSale.getRandomThing(potionByRarityMap);
		this.itemName = potion.itemName();
		this.itemPrice = potion.itemPrice();
	}

	private void populatePotionMap(Map<Integer, PotionItem> potionByRarityMap,
			int potionLevel, PotionRarity potionRarity) 
	{
		switch (potionLevel)
		{
			case 0:
				potionByRarityMap.put(14, new PotionItem("arcane mark", 25));
				potionByRarityMap.put(28, new PotionItem("guidance", 25));
				potionByRarityMap.put(44, new PotionItem("light", 25));
				potionByRarityMap.put(58, new PotionItem("purify food and drink", 25));
				potionByRarityMap.put(72, new PotionItem("resistance", 25));
				potionByRarityMap.put(86, new PotionItem("stabilize", 25));
				potionByRarityMap.put(100, new PotionItem("virtue", 25));
				break;
			case 1:
				switch (potionRarity)
				{
					case COMMON:
						potionByRarityMap.put(4, new PotionItem("bless weapon", 50));
						potionByRarityMap.put(14, new PotionItem("cure light wounds", 50));
						potionByRarityMap.put(19, new PotionItem("endure elements", 50));
						potionByRarityMap.put(27, new PotionItem("enlarge person", 50));
						potionByRarityMap.put(33, new PotionItem("jump", 50));
						potionByRarityMap.put(41, new PotionItem("mage armor", 50));
						potionByRarityMap.put(47, new PotionItem("magic fang", 50));
						potionByRarityMap.put(55, new PotionItem("magic weapon", 50));
						potionByRarityMap.put(60, new PotionItem("pass without trace", 50));
						potionByRarityMap.put(64, new PotionItem("protection from chaos", 50));
						potionByRarityMap.put(68, new PotionItem("protection from evil", 50));
						potionByRarityMap.put(72, new PotionItem("protection from good", 50));
						potionByRarityMap.put(76, new PotionItem("protection from law", 50));
						potionByRarityMap.put(81, new PotionItem("reduce person", 50));
						potionByRarityMap.put(87, new PotionItem("remove fear", 50));
						potionByRarityMap.put(92, new PotionItem("sanctuary", 50));
						potionByRarityMap.put(100, new PotionItem("shield of faith", 50));
						break;
					case UNCOMMON:
						potionByRarityMap.put(4, new PotionItem("animate rope", 50));
						potionByRarityMap.put(11, new PotionItem("ant haul", 50));
						potionByRarityMap.put(16, new PotionItem("cloak of the shade", 50));
						potionByRarityMap.put(20, new PotionItem("erase", 50));
						potionByRarityMap.put(26, new PotionItem("feather step", 50));
						potionByRarityMap.put(30, new PotionItem("goodberry", 50));
						potionByRarityMap.put(34, new PotionItem("grease", 50));
						potionByRarityMap.put(41, new PotionItem("hide from animals", 50));
						potionByRarityMap.put(49, new PotionItem("hide from undead", 50));
						potionByRarityMap.put(53, new PotionItem("hold portal", 50));
						potionByRarityMap.put(58, new PotionItem("invigorate", 50));
						potionByRarityMap.put(64, new PotionItem("keen senses", 50));
						potionByRarityMap.put(68, new PotionItem("magic stone", 50));
						potionByRarityMap.put(75, new PotionItem("remove sickness", 50));
						potionByRarityMap.put(80, new PotionItem("sanctify corpse", 50));
						potionByRarityMap.put(84, new PotionItem("shillelagh", 50));
						potionByRarityMap.put(92, new PotionItem("touch of the sea", 50));
						potionByRarityMap.put(100, new PotionItem("vanish", 50));
						break;
					default:
						break;
				}
				break;
			case 2:
				switch (potionRarity)
				{
					case COMMON:
						potionByRarityMap.put(4, new PotionItem("aid", 300));
						potionByRarityMap.put(7, new PotionItem("align weapon", 300));
						potionByRarityMap.put(11, new PotionItem("barkskin", 300));
						potionByRarityMap.put(16, new PotionItem("bear's endurance", 300));
						potionByRarityMap.put(20, new PotionItem("blur", 300));
						potionByRarityMap.put(25, new PotionItem("bull's strength", 300));
						potionByRarityMap.put(30, new PotionItem("cat's grace", 300));
						potionByRarityMap.put(37, new PotionItem("cure moderate wounds", 300));
						potionByRarityMap.put(41, new PotionItem("darkvision", 300));
						potionByRarityMap.put(44, new PotionItem("delay poison", 300));
						potionByRarityMap.put(49, new PotionItem("eagle's splendor", 300));
						potionByRarityMap.put(54, new PotionItem("fox's cunning", 300));
						potionByRarityMap.put(61, new PotionItem("invisibility", 300));
						potionByRarityMap.put(66, new PotionItem("levitate", 300));
						potionByRarityMap.put(71, new PotionItem("owl's wisdom", 300));
						potionByRarityMap.put(73, new PotionItem("protection from arrows", 300));
						potionByRarityMap.put(76, new PotionItem("remove paralysis", 300));
						potionByRarityMap.put(80, new PotionItem("resist acid energy", 300));
						potionByRarityMap.put(84, new PotionItem("resist cold energy", 300));
						potionByRarityMap.put(88, new PotionItem("resist electricity energy", 300));
						potionByRarityMap.put(92, new PotionItem("resist fire energy", 300));
						potionByRarityMap.put(94, new PotionItem("resist sonic energy", 300));
						potionByRarityMap.put(98, new PotionItem("spider climb", 300));
						potionByRarityMap.put(100, new PotionItem("undetectable alignment", 300));
						break;
					case UNCOMMON:
						potionByRarityMap.put(6, new PotionItem("ablative barrier", 300));
						potionByRarityMap.put(14, new PotionItem("acute senses", 300));
						potionByRarityMap.put(19, new PotionItem("arcane lock", 300));
						potionByRarityMap.put(24, new PotionItem("bullet shield", 300));
						potionByRarityMap.put(30, new PotionItem("certain grip", 300));
						potionByRarityMap.put(35, new PotionItem("continual flame", 350));
						potionByRarityMap.put(40, new PotionItem("corruption resistance", 300));
						potionByRarityMap.put(48, new PotionItem("disguise other", 300));
						potionByRarityMap.put(56, new PotionItem("gentle repose", 300));
						potionByRarityMap.put(61, new PotionItem("make whole", 300));
						potionByRarityMap.put(67, new PotionItem("obscure object", 300));
						potionByRarityMap.put(72, new PotionItem("reduce animal", 300));
						potionByRarityMap.put(76, new PotionItem("rope trick", 300));
						potionByRarityMap.put(82, new PotionItem("slipstream", 300));
						potionByRarityMap.put(90, new PotionItem("status", 300));
						potionByRarityMap.put(95, new PotionItem("warp wood", 300));
						potionByRarityMap.put(100, new PotionItem("wood shape", 300));
						break;
					default:
						break;
				}
				break;
			case 3:
				switch (potionRarity)
				{
					case COMMON:
						potionByRarityMap.put(6, new PotionItem("cure serious wounds", 750));
						potionByRarityMap.put(10, new PotionItem("dispel magic", 750));
						potionByRarityMap.put(14, new PotionItem("displacement", 750));
						potionByRarityMap.put(20, new PotionItem("fly", 750));
						potionByRarityMap.put(25, new PotionItem("gaseous form", 750));
						potionByRarityMap.put(29, new PotionItem("good hope", 750));
						potionByRarityMap.put(35, new PotionItem("haste", 750));
						potionByRarityMap.put(40, new PotionItem("heroism", 750));
						potionByRarityMap.put(44, new PotionItem("keen edge", 750));
						potionByRarityMap.put(48, new PotionItem("greater magic fang", 750));
						potionByRarityMap.put(52, new PotionItem("magic vestment", 750));
						potionByRarityMap.put(57, new PotionItem("neutralize poison", 750));
						potionByRarityMap.put(60, new PotionItem("protection from acid energy", 750));
						potionByRarityMap.put(63, new PotionItem("protection from cold energy", 750));
						potionByRarityMap.put(66, new PotionItem("protection from electricity energy", 750));
						potionByRarityMap.put(69, new PotionItem("protection from fire energy", 750));
						potionByRarityMap.put(71, new PotionItem("protection from sonic energy", 750));
						potionByRarityMap.put(74, new PotionItem("rage", 750));
						potionByRarityMap.put(77, new PotionItem("remove blindness/deafness", 750));
						potionByRarityMap.put(81, new PotionItem("remove curse", 750));
						potionByRarityMap.put(86, new PotionItem("remove disease", 750));
						potionByRarityMap.put(91, new PotionItem("tongues", 750));
						potionByRarityMap.put(96, new PotionItem("water breathing", 750));
						potionByRarityMap.put(100, new PotionItem("water walk", 750));
						break;
					case UNCOMMON:
						potionByRarityMap.put(12, new PotionItem("burrow", 750));
						potionByRarityMap.put(22, new PotionItem("countless eyes", 750));
						potionByRarityMap.put(34, new PotionItem("daylight", 750));
						potionByRarityMap.put(49, new PotionItem("draconic reservior", 750));
						potionByRarityMap.put(58, new PotionItem("flame arrow", 750));
						potionByRarityMap.put(67, new PotionItem("shrink item", 750));
						potionByRarityMap.put(77, new PotionItem("stone shape", 750));
						potionByRarityMap.put(87, new PotionItem("fire trap", 775));
						potionByRarityMap.put(100, new PotionItem("nondetection", 800));
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}

	private void generatePotionRarity() 
	{
		if (potionLevel == 0)
		{
			this.potionRarity = PotionRarity.COMMON;
			return;
		}
		if (potionRarityMap == null)
		{
			potionRarityMap = new LinkedHashMap<Integer, PotionRarity>();
			potionRarityMap.put(75, PotionRarity.COMMON);
			potionRarityMap.put(100, PotionRarity.UNCOMMON);
		}
		this.potionRarity = ItemsForSale.getRandomThing(potionRarityMap);
	}

	@Override
	public Item copyItem() 
	{
		PotionItem itemCopy = new PotionItem(this.potionLevel);
		return itemCopy;		
	}
}
