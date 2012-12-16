package com.ohako.itemcategory.rings;

import java.util.Map;

import com.ohako.Item;
import com.ohako.itemcategory.ItemCategory;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class RingsItemCategory extends ItemCategory 
{
	public RingsItemCategory(ItemDegree itemDegree) 
	{
		super(itemDegree);
	}

	@Override
	public void populateItemMap(Map<Integer, Item> qualifiedDegreeItemMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) 
	{
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(7, new RingItem("prisoner's dungeon ring", 250));
						qualifiedDegreeItemMap.put(16, new RingItem("ring of arcane signets", 1000));
						qualifiedDegreeItemMap.put(25, new RingItem("ring of spell knowledge I", 1500));
						qualifiedDegreeItemMap.put(40, new RingItem("ring of protection +1", 2000));
						qualifiedDegreeItemMap.put(47, new RingItem("ring of the grasping grave", 2000));
						qualifiedDegreeItemMap.put(57, new RingItem("ring of feather falling", 2200));
						qualifiedDegreeItemMap.put(66, new RingItem("ring of climbing", 2500));
						qualifiedDegreeItemMap.put(75, new RingItem("ring of jumping", 2500));
						qualifiedDegreeItemMap.put(84, new RingItem("ring of sustenance", 2500));
						qualifiedDegreeItemMap.put(93, new RingItem("ring of swimming", 2500));
						qualifiedDegreeItemMap.put(100, new RingItem("ring of ferocious action", 3000));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(15, new RingItem("ring of counterspells", 4000));
						qualifiedDegreeItemMap.put(25, new RingItem("ring of maniacal devices", 5000));
						qualifiedDegreeItemMap.put(35, new RingItem("ring of rat fangs", 5000));
						qualifiedDegreeItemMap.put(52, new RingItem("ring of sacred mistletoe", 6000));
						qualifiedDegreeItemMap.put(69, new RingItem("ring of spell knowledge II", 6000));
						qualifiedDegreeItemMap.put(86, new RingItem("ring of swarming stabs", 6000));
						qualifiedDegreeItemMap.put(100, new RingItem("ring of grit mastery", 6840));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(2, new RingItem("ring of forcefangs", 8000));
						qualifiedDegreeItemMap.put(6, new RingItem("ring of mind shielding", 8000));
						qualifiedDegreeItemMap.put(11, new RingItem("ring of protection +2", 8000));
						qualifiedDegreeItemMap.put(13, new RingItem("ring of strength sapping", 8000));
						qualifiedDegreeItemMap.put(17, new RingItem("ring of force shield", 8500));
						qualifiedDegreeItemMap.put(22, new RingItem("ring of the ram", 8600));
						qualifiedDegreeItemMap.put(24, new RingItem("scholar's ring", 8700));
						qualifiedDegreeItemMap.put(27, new RingItem("improved ring of climbing", 10000));
						qualifiedDegreeItemMap.put(29, new RingItem("ring of curing", 10000));
						qualifiedDegreeItemMap.put(31, new RingItem("ring of foe focus", 10000));
						qualifiedDegreeItemMap.put(35, new RingItem("improved ring of jumping", 10000));
						qualifiedDegreeItemMap.put(37, new RingItem("ring of ki mastery", 10000));
						//TODO add something that generates oracle revelations at random...ugh
						qualifiedDegreeItemMap.put(40, new RingItem("lesser ring of revelation", 10000));
						qualifiedDegreeItemMap.put(43, new RingItem("improved ring of swimming", 10000));
						qualifiedDegreeItemMap.put(46, new RingItem("ring of animal friendship", 10800));						
						qualifiedDegreeItemMap.put(48, new RingItem("ring of transposition", 10800));
						qualifiedDegreeItemMap.put(50, new RingItem("ring of tactical precision", 11000));
						qualifiedDegreeItemMap.put(52, new RingItem("ring of the sophisticate", 11000));
						qualifiedDegreeItemMap.put(55, new RingItem("decoy ring", 12000));
						qualifiedDegreeItemMap.put(58, new RingItem("ring of craft magic", 12000));
						qualifiedDegreeItemMap.put(61, new RingItem("ring of ectoplasmic invigoration", 12000));
						qualifiedDegreeItemMap.put(64, new EnergyTypeRingItem("minor ring of %s resistance", 12000));
						qualifiedDegreeItemMap.put(67, new RingItem("ring of the troglodyte", 12000));
						qualifiedDegreeItemMap.put(70, new RingItem("steelhand circle", 12000));
						qualifiedDegreeItemMap.put(76, new RingItem("ring of chameleon power", 12700));
						qualifiedDegreeItemMap.put(79, new RingItem("ring of spell knowledge III", 13500));
						qualifiedDegreeItemMap.put(82, new RingItem("ring of the sea strider", 14000));
						qualifiedDegreeItemMap.put(85, new RingItem("ring of retribution", 15000));
						qualifiedDegreeItemMap.put(89, new RingItem("ring of water walking", 15000));
						qualifiedDegreeItemMap.put(95, new RingItem("jailer's dungeon ring", 16000));
						qualifiedDegreeItemMap.put(100, new RingItem("greater ring of revelation", 16000));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(4, new RingItem("minor ring of inner fortitude", 18000));
						qualifiedDegreeItemMap.put(16, new RingItem("ring of protection +3", 18000));
						qualifiedDegreeItemMap.put(26, new RingItem("minor ring of spell storing", 18000));
						qualifiedDegreeItemMap.put(30, new EnergyTypeRingItem("ring of %s shroud", 19500));
						qualifiedDegreeItemMap.put(35, new RingItem("ring of arcane mastery", 20000));
						qualifiedDegreeItemMap.put(46, new RingItem("ring of invisibility", 20000));
						qualifiedDegreeItemMap.put(54, new RingItem("ring of wizardry I", 20000));
						qualifiedDegreeItemMap.put(60, new RingItem("superior ring of revelation", 24000));
						qualifiedDegreeItemMap.put(68, new RingItem("ring of spell knowledge IV", 24000));
						qualifiedDegreeItemMap.put(80, new RingItem("ring of evasion", 25000));
						qualifiedDegreeItemMap.put(88, new RingItem("ring of x-ray vision", 25000));
						qualifiedDegreeItemMap.put(100, new RingItem("ring of blinking", 27000));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						qualifiedDegreeItemMap.put(9, new EnergyTypeRingItem("major ring of %s resistance", 28000));
						qualifiedDegreeItemMap.put(16, new RingItem("ring of the ecclesiarch", 28500));
						qualifiedDegreeItemMap.put(33, new RingItem("ring of protection +4", 32000));
						qualifiedDegreeItemMap.put(39, new RingItem("ring of return", 33600));
						qualifiedDegreeItemMap.put(55, new RingItem("ring of freedom of movement", 40000));
						qualifiedDegreeItemMap.put(70, new RingItem("ring of wizardry II", 40000));
						qualifiedDegreeItemMap.put(75, new RingItem("major ring of inner fortitude", 42000));
						qualifiedDegreeItemMap.put(92, new EnergyTypeRingItem("greater ring of %s resistance", 44000));
						qualifiedDegreeItemMap.put(100, new RingItem("ring of delayed doom", 45000));
						break;
					case GREATER:
						qualifiedDegreeItemMap.put(6, new RingItem("ring of friend shield", 50000));
						qualifiedDegreeItemMap.put(18, new RingItem("ring of protection +5", 50000));
						qualifiedDegreeItemMap.put(27, new RingItem("ring of shooting stars", 50000));
						qualifiedDegreeItemMap.put(37, new RingItem("ring of spell storing", 50000));
						qualifiedDegreeItemMap.put(43, new RingItem("ring of continuation", 56000));
						qualifiedDegreeItemMap.put(48, new RingItem("greater ring of inner fortitude", 66000));
						qualifiedDegreeItemMap.put(57, new RingItem("ring of wizardry III", 70000));
						qualifiedDegreeItemMap.put(63, new RingItem("spiritualist rings", 70000));
						qualifiedDegreeItemMap.put(71, new RingItem("ring of telekinesis", 75000));
						qualifiedDegreeItemMap.put(76, new RingItem("ring of regeneration", 90000));
						qualifiedDegreeItemMap.put(82, new RingItem("ring of spell turning", 100000));
						qualifiedDegreeItemMap.put(86, new RingItem("ring of wizardry IV", 100000));
						qualifiedDegreeItemMap.put(90, new RingItem("ring of three wishes", 120000));
						qualifiedDegreeItemMap.put(93, new RingItem("ring of djinni calling", 125000));
						qualifiedDegreeItemMap.put(94, new RingItem("ring of air elemental command", 200000));						
						qualifiedDegreeItemMap.put(95, new RingItem("ring of earth elemental command", 200000));
						qualifiedDegreeItemMap.put(96, new RingItem("ring of fire elemental command", 200000));
						qualifiedDegreeItemMap.put(97, new RingItem("ring of water elemental command", 200000));						
						qualifiedDegreeItemMap.put(100, new RingItem("major ring of spell storing", 200000));
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
