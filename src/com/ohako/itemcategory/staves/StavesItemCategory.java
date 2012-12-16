package com.ohako.itemcategory.staves;

import java.util.Map;

import com.ohako.Item;
import com.ohako.itemcategory.ItemCategory;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class StavesItemCategory extends ItemCategory 
{
	public StavesItemCategory(ItemDegree itemDegree) 
	{
		super(itemDegree);
	}

	@Override
	public void populateItemMap(Map<Integer, Item> qualifiedDegreeItemMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) 
	{
		switch (itemDegree)
		{
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(10, new StaffItem("staff of blessed relief", 7200));
						qualifiedDegreeItemMap.put(20, new StaffItem("staff of minor arcana", 8000));
						qualifiedDegreeItemMap.put(30, new StaffItem("staff of tricks", 8800));
						qualifiedDegreeItemMap.put(44, new StaffItem("staff of the scout", 9600));
						qualifiedDegreeItemMap.put(54, new StaffItem("staff of eidolons", 14400));
						qualifiedDegreeItemMap.put(67, new StaffItem("staff of accompaniment", 14800));
						qualifiedDegreeItemMap.put(84, new StaffItem("staff of understanding", 16000));
						qualifiedDegreeItemMap.put(100, new StaffItem("staff of charming", 17600));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(11, new StaffItem("staff of fire", 18950));
						qualifiedDegreeItemMap.put(21, new StaffItem("staff of courage", 19200));
						qualifiedDegreeItemMap.put(29, new StaffItem("staff of belittling", 20000));
						qualifiedDegreeItemMap.put(38, new StaffItem("staff of feast and famine", 20800));
						qualifiedDegreeItemMap.put(49, new StaffItem("staff of rigor", 20800));
						qualifiedDegreeItemMap.put(60, new StaffItem("staff of swarming insects", 22800));
						qualifiedDegreeItemMap.put(68, new StaffItem("staff of authority", 23000));
						qualifiedDegreeItemMap.put(81, new StaffItem("staff of radiance", 23200));
						qualifiedDegreeItemMap.put(92, new StaffItem("staff of size alteration", 26150));
						qualifiedDegreeItemMap.put(100, new StaffItem("staff of journeys", 27200));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(4, new StaffItem("staff of acid", 28600));
						qualifiedDegreeItemMap.put(8, new StaffItem("staff of shrieking", 28800));
						qualifiedDegreeItemMap.put(11, new StaffItem("chaotic staff", 29600));
						qualifiedDegreeItemMap.put(14, new StaffItem("holy staff", 29600));
						qualifiedDegreeItemMap.put(17, new StaffItem("lawful staff", 29600));
						qualifiedDegreeItemMap.put(21, new StaffItem("staff of healing", 29600));
						qualifiedDegreeItemMap.put(24, new StaffItem("unholy staff", 29600));
						qualifiedDegreeItemMap.put(28, new StaffItem("staff of the master", 30000));
						qualifiedDegreeItemMap.put(32, new StaffItem("staff of spiders", 30200));
						qualifiedDegreeItemMap.put(36, new StaffItem("staff of electricity", 31900));
						qualifiedDegreeItemMap.put(39, new StaffItem("heretic's bane", 32000));
						qualifiedDegreeItemMap.put(42, new StaffItem("musical staff", 32000));
						qualifiedDegreeItemMap.put(46, new StaffItem("staff of souls", 32800));
						qualifiedDegreeItemMap.put(50, new StaffItem("staff of toxins", 34200));
						qualifiedDegreeItemMap.put(54, new StaffItem("staff of stealth", 36800));
						qualifiedDegreeItemMap.put(58, new StaffItem("staff of the avenger", 37310));
						qualifiedDegreeItemMap.put(62, new StaffItem("staff of aspects", 37600));
						qualifiedDegreeItemMap.put(66, new StaffItem("staff of speaking", 39600));
						qualifiedDegreeItemMap.put(70, new StaffItem("staff of frost", 41400));
						qualifiedDegreeItemMap.put(74, new StaffItem("staff of bolstering", 41600));
						qualifiedDegreeItemMap.put(78, new StaffItem("staff of curses", 43500));
						qualifiedDegreeItemMap.put(85, new StaffItem("staff of dark flame", 47000));
						qualifiedDegreeItemMap.put(89, new StaffItem("staff of cackling wrath", 47200));
						qualifiedDegreeItemMap.put(93, new StaffItem("staff of performance", 48800));
						qualifiedDegreeItemMap.put(97, new StaffItem("animate staff", 49800));
						qualifiedDegreeItemMap.put(100, new StaffItem("staff of revelations", 51008));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(4, new StaffItem("staff of illumination", 51500));
						qualifiedDegreeItemMap.put(7, new StaffItem("staff of obstacles", 51600));
						qualifiedDegreeItemMap.put(10, new StaffItem("staff of heaven and earth", 54000));
						qualifiedDegreeItemMap.put(13, new StaffItem("staff of travel", 54400));
						qualifiedDegreeItemMap.put(16, new StaffItem("staff of hoarding", 55866));
						qualifiedDegreeItemMap.put(19, new StaffItem("staff of traps", 56925));
						qualifiedDegreeItemMap.put(22, new StaffItem("staff of many rays", 57200));
						qualifiedDegreeItemMap.put(25, new StaffItem("staff of mithral might", 58000));
						qualifiedDegreeItemMap.put(29, new StaffItem("staff of defense", 62000));
						qualifiedDegreeItemMap.put(32, new StaffItem("staff of the planes", 63960));
						qualifiedDegreeItemMap.put(35, new StaffItem("staff of hungry shadows", 69300));
						//TODO: figure out how to choose color of dragon staff
						qualifiedDegreeItemMap.put(38, new StaffItem("dragon staff", 81000));
						qualifiedDegreeItemMap.put(41, new StaffItem("staff of slumber", 81766));
						qualifiedDegreeItemMap.put(46, new StaffItem("staff of abjuration", 82000));
						qualifiedDegreeItemMap.put(51, new StaffItem("staff of conjuration", 82000));
						qualifiedDegreeItemMap.put(56, new StaffItem("staff of divination", 82000));
						qualifiedDegreeItemMap.put(61, new StaffItem("staff of enchantment", 82000));
						qualifiedDegreeItemMap.put(66, new StaffItem("staff of evocation", 82000));
						qualifiedDegreeItemMap.put(71, new StaffItem("staff of illusion", 82000));
						qualifiedDegreeItemMap.put(76, new StaffItem("staff of necromancy", 82000));
						qualifiedDegreeItemMap.put(81, new StaffItem("staff of transmutation", 82000));
						qualifiedDegreeItemMap.put(83, new StaffItem("staff of weather", 84066));
						qualifiedDegreeItemMap.put(86, new StaffItem("staff of earth and stone", 85800));
						qualifiedDegreeItemMap.put(88, new StaffItem("staff of vision", 86666));
						qualifiedDegreeItemMap.put(91, new StaffItem("staff of the woodlands", 100400));
						qualifiedDegreeItemMap.put(94, new StaffItem("staff of life", 109400));
						qualifiedDegreeItemMap.put(95, new StaffItem("staff of one hundred hands", 180200));
						qualifiedDegreeItemMap.put(98, new StaffItem("staff of passage", 206900));
						qualifiedDegreeItemMap.put(99, new StaffItem("staff of the hierophant", 220000));
						qualifiedDegreeItemMap.put(100, new StaffItem("staff of power", 235000));
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}
}
