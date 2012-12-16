package com.ohako.itemdegree;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.itemcategory.ItemCategory;
import com.ohako.itemcategory.armorandshields.ArmorAndShieldsItemCategory;
import com.ohako.itemcategory.potions.PotionsItemCategory;
import com.ohako.itemcategory.rings.RingsItemCategory;
import com.ohako.itemcategory.rods.RodsItemCategory;
import com.ohako.itemcategory.scrolls.ScrollsItemCategory;
import com.ohako.itemcategory.staves.StavesItemCategory;
import com.ohako.itemcategory.wands.WandsItemCategory;
import com.ohako.itemcategory.weapons.WeaponsItemCategory;
import com.ohako.itemcategory.wondrousitems.WondrousItemCategory;

public enum ItemDegree 
{
	MINOR(1), 
	MEDIUM(2),
	MAJOR(3);

	private Map<Integer, ItemCategory> itemCategoryMap = null;
	
	private ItemDegree(int itemDegreeInt)
	{
		itemCategoryMap = new LinkedHashMap<Integer, ItemCategory>();
		switch (itemDegreeInt)
		{
			case 1:
				itemCategoryMap.put(4, new ArmorAndShieldsItemCategory(this));
				itemCategoryMap.put(9, new WeaponsItemCategory(this));
				itemCategoryMap.put(44, new PotionsItemCategory(this));
				itemCategoryMap.put(46, new RingsItemCategory(this));
				itemCategoryMap.put(81, new ScrollsItemCategory(this));
				itemCategoryMap.put(91, new WandsItemCategory(this));
				itemCategoryMap.put(100, new WondrousItemCategory(this));
				break;
			case 2:
				itemCategoryMap.put(10, new ArmorAndShieldsItemCategory(this));
				itemCategoryMap.put(20, new WeaponsItemCategory(this));
				itemCategoryMap.put(30, new PotionsItemCategory(this));
				itemCategoryMap.put(40, new RingsItemCategory(this));
				itemCategoryMap.put(50, new RodsItemCategory(this));
				itemCategoryMap.put(65, new ScrollsItemCategory(this));
				itemCategoryMap.put(68, new StavesItemCategory(this));
				itemCategoryMap.put(83, new WandsItemCategory(this));
				itemCategoryMap.put(100, new WondrousItemCategory(this));
				break;
			case 3:
				itemCategoryMap.put(10, new ArmorAndShieldsItemCategory(this));
				itemCategoryMap.put(20, new WeaponsItemCategory(this));
				itemCategoryMap.put(25, new PotionsItemCategory(this));
				itemCategoryMap.put(35, new RingsItemCategory(this));
				itemCategoryMap.put(45, new RodsItemCategory(this));
				itemCategoryMap.put(55, new ScrollsItemCategory(this));
				itemCategoryMap.put(75, new StavesItemCategory(this));
				itemCategoryMap.put(80, new WandsItemCategory(this));
				itemCategoryMap.put(100, new WondrousItemCategory(this));
				break;
		}
	}
	
	public Map<Integer, ItemCategory> getItemCategoryMap() 
	{
		return itemCategoryMap;
	}
}
