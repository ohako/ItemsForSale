package com.ohako;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.ohako.itemcategory.ItemCategory;
import com.ohako.itemdegree.ItemDegree;

public class ItemsForSale 
{
	private static final Random rand = new Random(System.currentTimeMillis());
	private int numberOfItems = 0;
	private ItemDegree itemDegree = null;
	private int economyModifier = 0;
	private List<Item> items = new ArrayList<Item>();

	public ItemsForSale(int numberOfItems, ItemDegree itemDegree, int economyModifier) 
	{
		this.numberOfItems = numberOfItems;
		this.itemDegree = itemDegree;
		this.economyModifier = economyModifier;
	}

	public static void main(String[] args) 
	{
		String numberOfItemsStr = null;
		String itemDegreeStr = null;
		String economyModifierStr = null;
		int economyModifier = 0;
		if (args != null)
		{
			if (args.length > 0)
				numberOfItemsStr = args[0];
			if (args.length > 1)
				itemDegreeStr = args[1];
			if (args.length > 2)
				economyModifierStr = args[2];
		}
		if (numberOfItemsStr == null ||
				itemDegreeStr == null)
			inputError();
		int numberOfItems = calculateNumberOfItems(numberOfItemsStr);
		ItemDegree itemDegree = null;
		try
		{
			itemDegree = ItemDegree.valueOf(itemDegreeStr.toUpperCase());
		}
		catch (Exception e)
		{
			inputError();
		}
		if (economyModifierStr != null)
		{
			try
			{
				economyModifier = Integer.parseInt(economyModifierStr);			
			}
			catch (NumberFormatException nfe)
			{
				inputError();
			}
		}
		ItemsForSale itemsForSale = new ItemsForSale(numberOfItems, itemDegree, economyModifier);
		itemsForSale.generateItems();
		itemsForSale.outputItems();
	}

	private void outputItems() 
	{
		System.out.println("Item Name\tItem Price");
		if (items != null)
			for (Item item : items)
				item.outputItem();
	}

	private void generateItems() 
	{
		for (int i = 0; i < numberOfItems; i++)
			items.add(ItemCategory.generateItem(itemDegree, economyModifier));
	}

	private static int calculateNumberOfItems(String numberOfItemsStr) 
	{
		int numberOfItems = 0;
		int isThereAd = numberOfItemsStr.indexOf("d");
		if (isThereAd > -1)
		{
			int numberOfDice = 0;
			String numberOfDiceStr = numberOfItemsStr.substring(0, isThereAd);
			try
			{
				numberOfDice = Integer.parseInt(numberOfDiceStr);
			}
			catch (NumberFormatException nfe)
			{
				inputError();
			}
			String diceSidesStr = numberOfItemsStr.substring(isThereAd + 1);
			String diceModifierStr = null;
			int diceModifier = 0;
			int isThereAModifier = diceSidesStr.indexOf("+") > diceSidesStr.indexOf("-") ? diceSidesStr.indexOf("+") : diceSidesStr.indexOf("-");
			if (isThereAModifier > -1)
			{
				diceModifierStr = diceSidesStr.substring(isThereAModifier + 1);
				diceSidesStr = diceSidesStr.substring(0, isThereAModifier);
				try
				{
					diceModifier = Integer.parseInt(diceModifierStr);
				}
				catch (NumberFormatException nfe)
				{
					inputError();
				}
			}
			int diceSides = 0;
			try
			{
				diceSides = Integer.parseInt(diceSidesStr);
			}
			catch (NumberFormatException nfe)
			{
				inputError();
			}
			if (diceSides < 1 ||
				(numberOfDice < 1 &&
				diceModifier < 1))
				inputError();
			while (numberOfDice > 0)
			{
				numberOfItems += rand.nextInt(diceSides) + 1;
				numberOfDice--;
			}
			numberOfItems += diceModifier;
		}
		else
		{
			try
			{
				numberOfItems = Integer.parseInt(numberOfItemsStr);
			}
			catch (NumberFormatException nfe)
			{
				inputError();
			}
		}
		return numberOfItems;
	}

	private static void inputError() 
	{
		System.err.println("Usage: [number of items (ex: 3d4)] [degree of items (minor/medium/major)] [economy modifier (optional)]");
		System.exit(0);
	}
	
	public static <T> T getRandomThing(Map<Integer, T> thingMap)
	{
		return getRandomThing(thingMap, 0);
	}
	
	public static <T> T getRandomThing(Map<Integer, T> thingMap, int modifier)
	{
		List<Integer> mapKeys = new ArrayList<Integer>();
		mapKeys.addAll(thingMap.keySet());
		int maxRoll = mapKeys.get(mapKeys.size() - 1);
		int percentileRoll = rand.nextInt(maxRoll) + 1 + modifier;
		if (percentileRoll > maxRoll)
			percentileRoll = maxRoll;
		int searchIndex = Collections.binarySearch(mapKeys, percentileRoll);
		if (searchIndex < 0)
			searchIndex = (searchIndex + 1) * -1;
		Integer searchKey = mapKeys.get(searchIndex);
		return thingMap.get(searchKey);		
	}
}