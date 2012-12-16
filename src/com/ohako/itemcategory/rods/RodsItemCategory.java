package com.ohako.itemcategory.rods;

import java.util.Map;

import com.ohako.Item;
import com.ohako.itemcategory.ItemCategory;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class RodsItemCategory extends ItemCategory 
{
	public RodsItemCategory(ItemDegree itemDegree) 
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
						qualifiedDegreeItemMap.put(1, new RodItem("lesser merciful metamagic rod", 1500));
						qualifiedDegreeItemMap.put(34, new MetamagicRodItem("lesser %s metamagic rod", 3000, 1));
						qualifiedDegreeItemMap.put(49, new RodItem("immovable rod", 5000));
						qualifiedDegreeItemMap.put(59, new RodItem("rod of thunderous force", 5400));
						qualifiedDegreeItemMap.put(60, new RodItem("merciful metamagic rod", 5500));
						qualifiedDegreeItemMap.put(61, new RodItem("rod of ice", 8500));
						qualifiedDegreeItemMap.put(71, new MetamagicRodItem("lesser %s metamagic rod", 9000, 2));
						qualifiedDegreeItemMap.put(81, new RodItem("rod of metal and mineral detection", 10500));
						qualifiedDegreeItemMap.put(86, new MetamagicRodItem("%s metamagic rod", 11000, 1));
						qualifiedDegreeItemMap.put(100, new RodItem("rod of cancellation", 11000));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(3, new RodItem("conduit rod", 12000));
						qualifiedDegreeItemMap.put(6, new RodItem("grounding rod", 12000));
						qualifiedDegreeItemMap.put(10, new RodItem("rod of the wayang", 12000));
						qualifiedDegreeItemMap.put(18, new RodItem("rod of wonder", 12000));
						qualifiedDegreeItemMap.put(19, new RodItem("greater merciful metamagic rod", 12250));
						qualifiedDegreeItemMap.put(29, new RodItem("rod of the python", 13000));
						qualifiedDegreeItemMap.put(33, new RodItem("trap-stealer's rod", 13500));
						qualifiedDegreeItemMap.put(55, new MetamagicRodItem("lesser %s metamagic rod", 14000, 3));
						qualifiedDegreeItemMap.put(59, new RodItem("rod of balance", 15000));
						qualifiedDegreeItemMap.put(63, new RodItem("rod of escape", 15000));
						qualifiedDegreeItemMap.put(72, new RodItem("rod of flame extinguishing", 15000));
						qualifiedDegreeItemMap.put(76, new RodItem("rod of ruin", 16000));
						qualifiedDegreeItemMap.put(80, new RodItem("sapling rod", 16550));
						qualifiedDegreeItemMap.put(86, new RodItem("rod of beguiling", 18000));
						qualifiedDegreeItemMap.put(90, new RodItem("rod of nettles", 18000));
						qualifiedDegreeItemMap.put(100, new RodItem("rod of the viper", 19000));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(4, new RodItem("suzerain scepter", 20000));
						qualifiedDegreeItemMap.put(6, new RodItem("fiery nimbus rod", 22305));
						qualifiedDegreeItemMap.put(13, new RodItem("rod of enemy detection", 23500));
						qualifiedDegreeItemMap.put(27, new MetamagicRodItem("greater % metamagic rod", 24500, 1));
						qualifiedDegreeItemMap.put(36, new RodItem("rod of splendor", 25000));
						qualifiedDegreeItemMap.put(44, new RodItem("rod of withering", 25000));
						qualifiedDegreeItemMap.put(50, new RodItem("earthbind rod", 26500));
						qualifiedDegreeItemMap.put(56, new RodItem("rod of the aboleth", 29000));
						qualifiedDegreeItemMap.put(63, new RodItem("liberator's rod", 30000));
						qualifiedDegreeItemMap.put(70, new MetamagicRodItem("%s metamagic rod", 32500, 3));
						qualifiedDegreeItemMap.put(79, new RodItem("rod of thunder and lightning", 33000));
						qualifiedDegreeItemMap.put(83, new RodItem("lesser quicken metamagic rod", 35000));
						qualifiedDegreeItemMap.put(94, new RodItem("rod of negation", 37000));
						qualifiedDegreeItemMap.put(100, new RodItem("rod of steadfast resolve", 38305));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(8, new RodItem("rod of absorption", 50000));
						qualifiedDegreeItemMap.put(11, new RodItem("rod of flailing", 50000));
						qualifiedDegreeItemMap.put(26, new MetamagicRodItem("%s metamagic rod", 54000, 3));
						qualifiedDegreeItemMap.put(28, new RodItem("rod of rulership", 60000));
						qualifiedDegreeItemMap.put(30, new RodItem("rod of security", 61000));
						qualifiedDegreeItemMap.put(32, new RodItem("rod of shadows", 64305));
						qualifiedDegreeItemMap.put(34, new RodItem("rod of mind mastery", 67000));
						qualifiedDegreeItemMap.put(37, new RodItem("rod of lordly might", 70000));
						qualifiedDegreeItemMap.put(57, new MetamagicRodItem("greater %s metamagic rod", 73000, 2));
						qualifiedDegreeItemMap.put(58, new RodItem("scepter of heaven", 74000));
						qualifiedDegreeItemMap.put(68, new RodItem("quicken metamagic rod", 75500));
						qualifiedDegreeItemMap.put(70, new RodItem("rod of dwarven might", 80000));
						qualifiedDegreeItemMap.put(75, new RodItem("rod of alertness", 85000));
						qualifiedDegreeItemMap.put(95, new MetamagicRodItem("greater %s metamagic rod", 121500, 3));
						qualifiedDegreeItemMap.put(100, new RodItem("greater quicken metamagic rod", 170000));
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
