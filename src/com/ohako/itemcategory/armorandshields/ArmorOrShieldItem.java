package com.ohako.itemcategory.armorandshields;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemcategory.armorandshields.ArmorItem.ArmorCategory;
import com.ohako.itemcategory.armorandshields.ShieldItem.ShieldCategory;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class ArmorOrShieldItem extends Item 
{
	protected static Map<Integer, ArmorOrShieldItem> armorOrShieldMap;
	protected static Map<Integer, ArmorOrShieldItem> randomArmorOrShieldMap;
	private int plus = 0;
	private List<Integer> specialAbilities;
	private ItemDegree itemDegree;
	private ItemDegreeQualifier itemDegreeQualifier;
	private String finalItemName;
	private int finalItemPrice;
	
	protected ArmorOrShieldItem()
	{		
	}
	
	public ArmorOrShieldItem(int plus, int... specialAbilities)
	{
		this.leafItem = false;
		this.plus = plus;
		this.specialAbilities = new ArrayList<Integer>();
		for (int speciaiAbility : specialAbilities)
			this.specialAbilities.add(speciaiAbility);
	}
	
	public ArmorOrShieldItem(ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier)
	{
		this.leafItem = false;
		this.itemDegree = itemDegree;
		this.itemDegreeQualifier = itemDegreeQualifier;
	}
	
	@Override
	public String itemName() 
	{
		return finalItemName;
	}
	@Override
	public int itemPrice() 
	{
		return finalItemPrice;
	}

	@Override
	public void generateItem() 
	{
		ArmorOrShieldItem armorOrShield = chooseArmorOrShield();
		armorOrShield.populateItem(this);
		this.finalItemName = armorOrShield.itemName();
		this.finalItemPrice = armorOrShield.itemPrice();
		leafItem = true;
	}
	
	protected void populateItem(ArmorOrShieldItem baseArmorOrShield) {};

	private ArmorOrShieldItem chooseArmorOrShield() 
	{
		if (randomArmorOrShieldMap == null)
			populateRandomArmorOrShieldMap();
		ArmorOrShieldItem item = ItemsForSale.getRandomThing(randomArmorOrShieldMap);
		if (item instanceof ArmorItem)
			return ((ArmorItem) item).copyItem();
		else
			return ((ShieldItem) item).copyItem();
	}

	private void populateRandomArmorOrShieldMap() 
	{
		randomArmorOrShieldMap = new LinkedHashMap<Integer, ArmorOrShieldItem>();
		randomArmorOrShieldMap.put(4, new ArmorItem("banded mail", 250, ArmorCategory.HEAVY));
		randomArmorOrShieldMap.put(11, new ArmorItem("breastplate", 200, ArmorCategory.MEDIUM));		
		randomArmorOrShieldMap.put(14, new ShieldItem("buckler", 5, ShieldCategory.BUCKLER));
		randomArmorOrShieldMap.put(21, new ArmorItem("chain shirt", 100, ArmorCategory.LIGHT));
		randomArmorOrShieldMap.put(27, new ArmorItem("chainmail", 150, ArmorCategory.MEDIUM));
		randomArmorOrShieldMap.put(34, new ArmorItem("full plate", 1500, ArmorCategory.HEAVY));
		randomArmorOrShieldMap.put(39, new ArmorItem("half-plate", 600, ArmorCategory.HEAVY));
		randomArmorOrShieldMap.put(45, new ShieldItem("heavy steel shield", 20, ShieldCategory.HEAVY));
		randomArmorOrShieldMap.put(51, new ShieldItem("heavy wooden shield", 7, ShieldCategory.HEAVY));
		randomArmorOrShieldMap.put(55, new ArmorItem("hide", 15, ArmorCategory.MEDIUM));
		randomArmorOrShieldMap.put(61, new ArmorItem("leather armor", 10, ArmorCategory.LIGHT));
		randomArmorOrShieldMap.put(65, new ShieldItem("light steel shield", 9, ShieldCategory.LIGHT));
		randomArmorOrShieldMap.put(69, new ShieldItem("light wooden shield", 3, ShieldCategory.LIGHT));
		randomArmorOrShieldMap.put(72, new ArmorItem("padded armor", 5, ArmorCategory.LIGHT));
		randomArmorOrShieldMap.put(77, new ArmorItem("scale mail", 50, ArmorCategory.MEDIUM));
		randomArmorOrShieldMap.put(81, new ArmorItem("splint mail", 200, ArmorCategory.HEAVY));
		randomArmorOrShieldMap.put(87, new ArmorItem("studded leather armor", 25, ArmorCategory.LIGHT));
		randomArmorOrShieldMap.put(90, new ShieldItem("tower shield", 30, ShieldCategory.TOWER));
		randomArmorOrShieldMap.put(93, new ArmorItem("other light", 0, ArmorCategory.LIGHT));
		randomArmorOrShieldMap.put(95, new ArmorItem("other medium", 0, ArmorCategory.MEDIUM));
		randomArmorOrShieldMap.put(98, new ArmorItem("other heavy", 0, ArmorCategory.HEAVY));
		randomArmorOrShieldMap.put(99, new ShieldItem("other shield", 0, ShieldCategory.LIGHT));		
		randomArmorOrShieldMap.put(100, new ShieldItem("other shield", 0, ShieldCategory.HEAVY));		
	}

	protected int addPlusesPrice(List<Integer> plusesToAddPrice) 
	{
		int totalPlus = 0;
		int priceToAdd = 0;
		for (Integer plus : plusesToAddPrice)
			totalPlus += plus;
		switch (totalPlus)
		{
			case 1:
				priceToAdd = 1150;
				break;
			case 2:
				priceToAdd = 4150;
				break;
			case 3:
				priceToAdd = 9150;
				break;
			case 4:
				priceToAdd = 16150;
				break;
			case 5:
				priceToAdd = 25150;
				break;
			case 6:
				priceToAdd = 36150;
				break;
			case 7:
				priceToAdd = 49150;
				break;
			case 8:
				priceToAdd = 64150;
				break;
			case 9:
				priceToAdd = 81150;
				break;
			case 10:
				priceToAdd = 100150;
				break;
			default:
				break;
		}
		return priceToAdd;
	}	
	
	public ItemDegree getItemDegree()
	{
		return itemDegree;
	}
	public ItemDegreeQualifier getItemDegreeQualifier()
	{
		return itemDegreeQualifier;
	}
	public void setPlus(int plus)
	{
		this.plus = plus;
	}
	public int getPlus()
	{
		return plus;
	}
	public List<Integer> getSpecialAbilities()
	{
		return specialAbilities;
	}

	@Override
	public Item copyItem() 
	{
		ArmorOrShieldItem itemCopy = new ArmorOrShieldItem();
		itemCopy.itemDegree = this.itemDegree;
		itemCopy.itemDegreeQualifier = this.itemDegreeQualifier;
		itemCopy.leafItem = this.leafItem;
		itemCopy.plus = this.plus;
		itemCopy.specialAbilities = this.specialAbilities;
		return itemCopy;
	}
}