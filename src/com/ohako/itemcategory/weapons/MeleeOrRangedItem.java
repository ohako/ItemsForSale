package com.ohako.itemcategory.weapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemcategory.weapons.MeleeItem.MeleeCategory;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class MeleeOrRangedItem extends Item {
	
	protected static Map<Integer, MeleeOrRangedItem> meleeOrRangedMap;
	protected static Map<Integer, MeleeOrRangedItem> randomMeleeOrRangedMap;
	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, MeleeOrRangedItem>>> specificWeaponMap;

	private int plus = 0;
	private List<Integer> specialAbilities;
	private ItemDegree itemDegree;
	private ItemDegreeQualifier itemDegreeQualifier;
	private String finalItemName;
	private int finalItemPrice;

	protected MeleeOrRangedItem()
	{		
	}
	
	public MeleeOrRangedItem(int plus, int... specialAbilities)
	{
		this.leafItem = false;
		this.plus = plus;
		this.specialAbilities = new ArrayList<Integer>();
		for (int speciaiAbility : specialAbilities)
			this.specialAbilities.add(speciaiAbility);
	}
	
	public MeleeOrRangedItem(ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier)
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
		MeleeOrRangedItem meleeOrRanged = chooseMeleeOrRanged();
		meleeOrRanged.populateItem(this);
		this.finalItemName = meleeOrRanged.itemName();
		this.finalItemPrice = meleeOrRanged.itemPrice();
		leafItem = true;
	}
	
	protected void populateItem(MeleeOrRangedItem baseMeleeOrRanged) {};

	private MeleeOrRangedItem chooseMeleeOrRanged() 
	{
		if (randomMeleeOrRangedMap == null)
			populateRandomMeleeOrRangedMap();
		MeleeOrRangedItem item = ItemsForSale.getRandomThing(randomMeleeOrRangedMap);
		if (item instanceof MeleeItem)
			return ((MeleeItem) item).copyItem();
		else
			return ((RangedItem) item).copyItem();
	}

	private void populateRandomMeleeOrRangedMap() {
		randomMeleeOrRangedMap = new LinkedHashMap<Integer, MeleeOrRangedItem>();
		randomMeleeOrRangedMap.put(1, new MeleeItem("bastard sword", 35, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(5, new MeleeItem("battleaxe", 10, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(6, new RangedItem("bolas", 5));
		randomMeleeOrRangedMap.put(8, new MeleeItem("club", 0, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(10, new RangedItem("composite longbow", 100));
		randomMeleeOrRangedMap.put(12, new RangedItem("composite shortbow", 75));
		randomMeleeOrRangedMap.put(16, new MeleeItem("dagger", 2, MeleeCategory.LIGHT));
		randomMeleeOrRangedMap.put(17, new RangedItem("dart", 1)); //TODO: really 0.5 gp, meh
		randomMeleeOrRangedMap.put(18, new MeleeItem("dwarven waraxe", 30, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(19, new MeleeItem("falchion", 75, MeleeCategory.TWO_HANDED));
		randomMeleeOrRangedMap.put(20, new MeleeItem("gauntlet", 2, MeleeCategory.UNARMED));
		randomMeleeOrRangedMap.put(21, new MeleeItem("glaive", 8, MeleeCategory.TWO_HANDED));
		randomMeleeOrRangedMap.put(24, new MeleeItem("greataxe", 20, MeleeCategory.TWO_HANDED));
		randomMeleeOrRangedMap.put(25, new MeleeItem("greatclub", 5, MeleeCategory.TWO_HANDED));
		randomMeleeOrRangedMap.put(28, new MeleeItem("greatsword", 50, MeleeCategory.TWO_HANDED));
		randomMeleeOrRangedMap.put(29, new MeleeItem("halberd", 10, MeleeCategory.TWO_HANDED));
		randomMeleeOrRangedMap.put(30, new MeleeItem("handaxe", 6, MeleeCategory.LIGHT));
		randomMeleeOrRangedMap.put(33, new RangedItem("heavy crossbow", 50));
		randomMeleeOrRangedMap.put(34, new MeleeItem("heavy flail", 15, MeleeCategory.TWO_HANDED));
		randomMeleeOrRangedMap.put(35, new MeleeItem("heavy mace", 12, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(37, new MeleeItem("lance", 10, MeleeCategory.TWO_HANDED));
		randomMeleeOrRangedMap.put(40, new RangedItem("light crossbow", 35));
		randomMeleeOrRangedMap.put(41, new MeleeItem("flail", 8, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(42, new MeleeItem("light hammer", 1, MeleeCategory.LIGHT));
		randomMeleeOrRangedMap.put(44, new MeleeItem("light mace", 5, MeleeCategory.LIGHT));
		randomMeleeOrRangedMap.put(45, new MeleeItem("light pick", 4, MeleeCategory.LIGHT));
		randomMeleeOrRangedMap.put(49, new RangedItem("longbow", 75));
		randomMeleeOrRangedMap.put(51, new MeleeItem("longspear", 5, MeleeCategory.TWO_HANDED));
		randomMeleeOrRangedMap.put(58, new MeleeItem("longsword", 15, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(60, new MeleeItem("morningstar", 8, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(61, new MeleeItem("nunchaku", 2, MeleeCategory.LIGHT));
		randomMeleeOrRangedMap.put(63, new MeleeItem("quarterstaff", 0, MeleeCategory.TWO_HANDED)); //the only double weapon
		randomMeleeOrRangedMap.put(65, new MeleeItem("rapier", 20, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(66, new MeleeItem("sai", 1, MeleeCategory.LIGHT));
		randomMeleeOrRangedMap.put(67, new MeleeItem("sap", 1, MeleeCategory.LIGHT));
		randomMeleeOrRangedMap.put(69, new MeleeItem("scythe", 18, MeleeCategory.TWO_HANDED));
		randomMeleeOrRangedMap.put(73, new RangedItem("shortbow", 30));
		randomMeleeOrRangedMap.put(75, new MeleeItem("shortspear", 1, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(80, new MeleeItem("short sword", 10, MeleeCategory.LIGHT));
		randomMeleeOrRangedMap.put(81, new RangedItem("shuriken", 1));
		randomMeleeOrRangedMap.put(82, new MeleeItem("sickle", 6, MeleeCategory.LIGHT));
		randomMeleeOrRangedMap.put(84, new RangedItem("sling", 0));
		randomMeleeOrRangedMap.put(87, new MeleeItem("spear", 2, MeleeCategory.TWO_HANDED));
		randomMeleeOrRangedMap.put(88, new MeleeItem("trident", 15, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(91, new MeleeItem("warhammer", 12, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(92, new MeleeItem("whip", 1, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(94, new MeleeItem("other light weapon", 0, MeleeCategory.LIGHT));
		randomMeleeOrRangedMap.put(96, new MeleeItem("other one-handed weapon", 0, MeleeCategory.ONE_HANDED));
		randomMeleeOrRangedMap.put(98, new MeleeItem("other two-handed weapon", 0, MeleeCategory.TWO_HANDED));
		randomMeleeOrRangedMap.put(100, new RangedItem("other ranged weapon", 0));
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
				priceToAdd = 2300;
				break;
			case 2:
				priceToAdd = 8300;
				break;
			case 3:
				priceToAdd = 18300;
				break;
			case 4:
				priceToAdd = 32300;
				break;
			case 5:
				priceToAdd = 50300;
				break;
			case 6:
				priceToAdd = 72300;
				break;
			case 7:
				priceToAdd = 98300;
				break;
			case 8:
				priceToAdd = 128300;
				break;
			case 9:
				priceToAdd = 162300;
				break;
			case 10:
				priceToAdd = 200300;
				break;
			default:
				break;
		}
		return priceToAdd;		
	}

	@Override
	public MeleeOrRangedItem copyItem() 
	{
		MeleeOrRangedItem itemCopy = new MeleeOrRangedItem();
		itemCopy.itemDegree = this.itemDegree;
		itemCopy.itemDegreeQualifier = this.itemDegreeQualifier;
		itemCopy.leafItem = this.leafItem;
		itemCopy.plus = this.plus;
		itemCopy.specialAbilities = this.specialAbilities;
		return itemCopy;
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
	
	protected MeleeOrRangedItem populateSpecificWeapon(ItemDegree itemDegree,
			ItemDegreeQualifier itemDegreeQualifier) {
		if (specificWeaponMap == null)
			specificWeaponMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, MeleeOrRangedItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, MeleeOrRangedItem>> specificWeaponMapByDegree = specificWeaponMap.get(itemDegree);
		if (specificWeaponMapByDegree == null)
		{
			specificWeaponMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,MeleeOrRangedItem>>();
			specificWeaponMap.put(itemDegree, specificWeaponMapByDegree);
		}
		Map<Integer, MeleeOrRangedItem> specificWeaponMapByDegreeAndQualifier = specificWeaponMapByDegree.get(itemDegreeQualifier);
		if (specificWeaponMapByDegreeAndQualifier == null)
		{
			specificWeaponMapByDegreeAndQualifier = new LinkedHashMap<Integer, MeleeOrRangedItem>();
			populateSpecificWeaponMap(specificWeaponMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificWeaponMapByDegree.put(itemDegreeQualifier, specificWeaponMapByDegreeAndQualifier);
		}
		return ItemsForSale.getRandomThing(specificWeaponMapByDegreeAndQualifier).copyItem();		
	}

	private void populateSpecificWeaponMap(
			Map<Integer, MeleeOrRangedItem> specificWeaponMapByDegreeAndQualifier,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						specificWeaponMapByDegreeAndQualifier.put(2, new RangedItem("tracer bullet", 100));
						specificWeaponMapByDegreeAndQualifier.put(8, new RangedItem("sleep arrow", 132));
						specificWeaponMapByDegreeAndQualifier.put(10, new RangedItem("dustburst bullet", 196));
						specificWeaponMapByDegreeAndQualifier.put(16, new RangedItem("tangle bolt", 226));
						specificWeaponMapByDegreeAndQualifier.put(22, new RangedItem("screaming bolt", 267));
						specificWeaponMapByDegreeAndQualifier.put(32, new MeleeItem("masterwork silver dagger", 322, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(34, new RangedItem("alchemist's bullet", 330));
						specificWeaponMapByDegreeAndQualifier.put(44, new MeleeItem("cold iron masterwork longsword", 330, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(50, new RangedItem("hushing arrow", 547));
						specificWeaponMapByDegreeAndQualifier.put(56, new RangedItem("greater hushing arrow", 1047));
						specificWeaponMapByDegreeAndQualifier.put(66, new RangedItem("javelin of lightning", 1500));
						specificWeaponMapByDegreeAndQualifier.put(74, new RangedItem("searing arrow", 1516));
						specificWeaponMapByDegreeAndQualifier.put(82, new RangedItem("sizzling arrow", 1516));
						specificWeaponMapByDegreeAndQualifier.put(84, new RangedItem("lesser burrowing bolt", 1722));
						specificWeaponMapByDegreeAndQualifier.put(92, new RangedItem("dust bolt", 1730));
						specificWeaponMapByDegreeAndQualifier.put(100, new CreatureTypeRangedItem("%s slaying arrow", 2282));
						break;
					case GREATER:
						specificWeaponMapByDegreeAndQualifier.put(20, new MeleeItem("adamantine dagger", 3002, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(40, new MeleeItem("adamantine battleaxe", 3010, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(50, new RangedItem("greater burrowing bullet", 3447));
						specificWeaponMapByDegreeAndQualifier.put(70, new CreatureTypeRangedItem("greater %s slaying arrow", 4057));
						specificWeaponMapByDegreeAndQualifier.put(80, new MeleeItem("lance of jousting", 4310, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(100, new MeleeItem("shatterspike", 4315, MeleeCategory.ONE_HANDED));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						specificWeaponMapByDegreeAndQualifier.put(3, new MeleeItem("bloodletting kukri", 6308, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(9, new MeleeItem("boulderhead mace", 6812, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(14, new MeleeItem("beaststrike club", 7300, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(20, new MeleeItem("fighter's fork", 7315, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(23, new MeleeItem("everflowing aspergillium", 7805, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(28, new MeleeItem("hurricane quarterstaff", 7840, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(34, new MeleeItem("dagger of venom", 8302, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(39, new MeleeItem("gloom blade", 8810, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(44, new RangedItem("frostbite sling", 9380));
						specificWeaponMapByDegreeAndQualifier.put(49, new MeleeItem("trident of stability", 9815, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(54, new MeleeItem("trident of warning", 10115, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(60, new MeleeItem("assassin's dagger", 10302, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(66, new MeleeItem("dagger of doubling", 10302, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(71, new MeleeItem("earthenflail", 11315, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(79, new MeleeItem("swift obsidian greataxe", 11320, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(85, new MeleeItem("polarity hammer", 12310, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(93, new MeleeItem("blade of binding", 12350, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(100, new MeleeItem("shifter's sorrow", 12780, MeleeCategory.TWO_HANDED));
						break;
					case GREATER:
						specificWeaponMapByDegreeAndQualifier.put(7, new MeleeItem("dragoncatch guisarme", 13308, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(15, new MeleeItem("ten-ring sword", 14315, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(21, new MeleeItem("triton's trident", 15065, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(29, new MeleeItem("lesser mace of smiting", 16012, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(37, new MeleeItem("disarming blade", 17820, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(42, new MeleeItem("lash of the howler", 18305, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(47, new MeleeItem("shieldsplitter lance", 18310, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(53, new MeleeItem("trident of fish command", 18650, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(59, new MeleeItem("quarterstaff of vaulting", 19100, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(65, new RangedItem("firedrake pistol", 20300));
						specificWeaponMapByDegreeAndQualifier.put(71, new MeleeItem("ricochet hammer", 20301, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(77, new MeleeItem("flame tongue", 20715, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(85, new MeleeItem("sparkwake starknife", 21324, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(90, new MeleeItem("luck blade (0 wishes)", 22060, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(95, new MeleeItem("sword of subtlety", 22310, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(100, new MeleeItem("sword of the planes", 22315, MeleeCategory.ONE_HANDED));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						specificWeaponMapByDegreeAndQualifier.put(12, new MeleeItem("nine lives stealer", 23057, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(26, new MeleeItem("undercutting axe", 23310, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(40, new MeleeItem("spirit caller", 25302, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(55, new MeleeItem("dwarfbond hammer", 25312, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(70, new RangedItem("oathbow", 25600));
						specificWeaponMapByDegreeAndQualifier.put(85, new MeleeItem("sword of life stealing", 25715, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(100, new MeleeItem("cutthroat's apprentice", 33910, MeleeCategory.LIGHT));
						break;
					case GREATER:
						specificWeaponMapByDegreeAndQualifier.put(2, new MeleeItem("ghoul's lament", 35312, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(5, new MeleeItem("mace of terror", 38552, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(7, new MeleeItem("scorpion whip", 39305, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(9, new MeleeItem("dragon's doom", 40310, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(13, new MeleeItem("life-drinker", 40320, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(16, new MeleeItem("valor's minion", 41335, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(18, new MeleeItem("summoner's sorrow", 42816, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(21, new MeleeItem("sylvan scimitar", 47315, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(23, new MeleeItem("spirit blade", 48502, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(26, new MeleeItem("heartswood spear", 50302, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(29, new MeleeItem("rapier of puncturing", 50320, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(32, new MeleeItem("sun blade", 50335, MeleeCategory.ONE_HANDED)); //priced like an enchanted bastard sword
						specificWeaponMapByDegreeAndQualifier.put(37, new MeleeItem("blade of the rising sun", 51850, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(40, new MeleeItem("frost brand", 54475, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(45, new MeleeItem("dwarven thrower", 60312, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(50, new MeleeItem("bloodthirst dagger", 60802, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(53, new MeleeItem("warbringer", 61375, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(57, new MeleeItem("luck blade (1 wish)", 62360, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(61, new MeleeItem("guarding blade", 65310, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(64, new RangedItem("pistol of the infinite sky", 73300));
						specificWeaponMapByDegreeAndQualifier.put(69, new MeleeItem("mace of smiting", 75312, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(73, new MeleeItem("blade of the sword-saint", 75350, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(76, new MeleeItem("scimitar of the spellthief", 75815, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(79, new MeleeItem("spider's fang", 79102, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(82, new MeleeItem("demonsorrow curve blade", 90469, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(85, new MeleeItem("void scythe", 95318, MeleeCategory.TWO_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(89, new MeleeItem("luck blade (2 wishes)", 102660, MeleeCategory.LIGHT));
						specificWeaponMapByDegreeAndQualifier.put(92, new MeleeItem("holy avenger", 120630, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(96, new MeleeItem("bastard's sting", 123035, MeleeCategory.ONE_HANDED));
						specificWeaponMapByDegreeAndQualifier.put(100, new MeleeItem("luck blade (3 wishes)", 142960, MeleeCategory.LIGHT));
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