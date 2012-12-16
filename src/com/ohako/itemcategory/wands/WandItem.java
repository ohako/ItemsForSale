package com.ohako.itemcategory.wands;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;

public class WandItem extends Item 
{
	private int wandLevel;
	private String itemName;
	private int itemPrice;
	private WandRarity wandRarity;
		
	private static Map<Integer, WandRarity> wandRarityMap;
	private static Map<Integer, Map<WandRarity, Map<Integer, WandItem>>> wandMap;
	
	public enum WandRarity
	{
		COMMON,
		UNCOMMON
	}
	
	public WandItem(int wandLevel)
	{
		this.wandLevel = wandLevel;
	}	

	public WandItem(String itemName, int itemPrice)
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
		generateWandRarity();
		generateWandFromLevelAndRarity();	
		itemName = "wand of " + itemName;
		leafItem = true;
	}

	private void generateWandFromLevelAndRarity() 
	{
		if (wandMap == null)
			wandMap = new HashMap<Integer, Map<WandRarity,Map<Integer,WandItem>>>();
		Map<WandRarity, Map<Integer, WandItem>> wandByLevelMap = wandMap.get(wandLevel);
		if (wandByLevelMap == null)
		{
			wandByLevelMap = new HashMap<WandRarity, Map<Integer,WandItem>>();
			wandMap.put(wandLevel, wandByLevelMap);
		}
		Map<Integer, WandItem> wandByRarityMap = wandByLevelMap.get(wandRarity);
		if (wandByRarityMap == null)
		{
			wandByRarityMap = new LinkedHashMap<Integer, WandItem>();
			wandByLevelMap.put(wandRarity, wandByRarityMap);
			populateWandMap(wandByRarityMap, wandLevel, wandRarity);
		}
		WandItem wand = ItemsForSale.getRandomThing(wandByRarityMap);
		this.itemName = wand.itemName();
		this.itemPrice = wand.itemPrice();
	}

	private void populateWandMap(Map<Integer, WandItem> wandByRarityMap,
			int wandLevel, WandRarity wandRarity) 
	{
		switch (wandLevel)
		{
			case 0:
				switch (wandRarity)
				{
					case COMMON:
						wandByRarityMap.put(7, new WandItem("acid splash", 375));
						wandByRarityMap.put(14, new WandItem("create water", 375));
						wandByRarityMap.put(20, new WandItem("daze", 375));
						wandByRarityMap.put(28, new WandItem("detect magic", 375));
						wandByRarityMap.put(34, new WandItem("ghost sound", 375));
						wandByRarityMap.put(42, new WandItem("light", 375));
						wandByRarityMap.put(49, new WandItem("mage hand", 375));
						wandByRarityMap.put(55, new WandItem("mending", 375));
						wandByRarityMap.put(60, new WandItem("message", 375));
						wandByRarityMap.put(66, new WandItem("prestidigitation", 375));
						wandByRarityMap.put(73, new WandItem("purify food and drink", 375));
						wandByRarityMap.put(81, new WandItem("ray of frost", 375));
						wandByRarityMap.put(88, new WandItem("read magic", 375));
						wandByRarityMap.put(95, new WandItem("stabilize", 375));
						wandByRarityMap.put(100, new WandItem("touch of fatigue", 375));
						break;
					case UNCOMMON:
						wandByRarityMap.put(6, new WandItem("arcane mark", 375));
						wandByRarityMap.put(15, new WandItem("bleed", 375));
						wandByRarityMap.put(22, new WandItem("dancing lights", 375));
						wandByRarityMap.put(31, new WandItem("detect poison", 375));
						wandByRarityMap.put(40, new WandItem("disrut undead", 375));
						wandByRarityMap.put(48, new WandItem("flare", 375));
						wandByRarityMap.put(56, new WandItem("guidance", 375));
						wandByRarityMap.put(65, new WandItem("know direction", 375));
						wandByRarityMap.put(73, new WandItem("lullaby", 375));
						wandByRarityMap.put(79, new WandItem("open/close", 375));
						wandByRarityMap.put(86, new WandItem("resistance", 375));
						wandByRarityMap.put(94, new WandItem("spark", 375));
						wandByRarityMap.put(100, new WandItem("virtue", 375));
						break;
					default:
						break;
				}
				break;
			case 1:
				switch (wandRarity)
				{
					case COMMON:
						wandByRarityMap.put(2, new WandItem("alarm", 750));
						wandByRarityMap.put(3, new WandItem("animate rope", 750));
						wandByRarityMap.put(5, new WandItem("bane", 750));
						wandByRarityMap.put(11, new WandItem("bless", 750));
						wandByRarityMap.put(14, new WandItem("burning hands", 750));
						wandByRarityMap.put(17, new WandItem("cause fear", 750));
						wandByRarityMap.put(19, new WandItem("charm person", 750));
						wandByRarityMap.put(21, new WandItem("color spray", 750));
						wandByRarityMap.put(23, new WandItem("command", 750));
						wandByRarityMap.put(24, new WandItem("comprehend languages", 750));
						wandByRarityMap.put(31, new WandItem("cure light wounds", 750));
						wandByRarityMap.put(33, new WandItem("disguise self", 750));
						wandByRarityMap.put(37, new WandItem("divine favor", 750));
						wandByRarityMap.put(38, new WandItem("endure elements", 750));
						wandByRarityMap.put(41, new WandItem("enlarge person", 750));
						wandByRarityMap.put(43, new WandItem("entangle", 750));
						wandByRarityMap.put(45, new WandItem("expeditious retreat", 750));
						wandByRarityMap.put(46, new WandItem("feather fall", 750));
						wandByRarityMap.put(48, new WandItem("grease", 750));
						wandByRarityMap.put(50, new WandItem("identify", 750));
						wandByRarityMap.put(52, new WandItem("inflict light wounds", 750));
						wandByRarityMap.put(58, new WandItem("mage armor", 750));
						wandByRarityMap.put(60, new WandItem("magic fang", 750));
						wandByRarityMap.put(67, new WandItem("magic missile", 750));
						wandByRarityMap.put(68, new WandItem("magic stone", 750));
						wandByRarityMap.put(70, new WandItem("magic weapon", 750));
						wandByRarityMap.put(71, new WandItem("obscuring mist", 750));
						wandByRarityMap.put(73, new WandItem("produce flame", 750));
						wandByRarityMap.put(74, new WandItem("protection from chaos", 750));
						wandByRarityMap.put(75, new WandItem("protection from evil", 750));
						wandByRarityMap.put(76, new WandItem("protection from good", 750));
						wandByRarityMap.put(77, new WandItem("protection from law", 750));
						wandByRarityMap.put(79, new WandItem("ray of enfeeblement", 750));
						wandByRarityMap.put(81, new WandItem("remove fear", 750));
						wandByRarityMap.put(84, new WandItem("shield", 750));
						wandByRarityMap.put(86, new WandItem("shield of faith", 750));
						wandByRarityMap.put(87, new WandItem("shillelagh", 750));
						wandByRarityMap.put(89, new WandItem("shocking grasp", 750));
						wandByRarityMap.put(90, new WandItem("silent image", 750));
						wandByRarityMap.put(94, new WandItem("sleep", 750));
						wandByRarityMap.put(95, new WandItem("summon monster I", 750));
						wandByRarityMap.put(96, new WandItem("summon nature's ally I", 750));
						wandByRarityMap.put(99, new WandItem("true strike", 750));
						wandByRarityMap.put(100, new WandItem("unseen servant", 750));
						break;
					case UNCOMMON:
						wandByRarityMap.put(2, new WandItem("ant haul", 750));
						wandByRarityMap.put(5, new WandItem("aspect of the falcon", 750));
						wandByRarityMap.put(7, new WandItem("bless weapon", 750));
						wandByRarityMap.put(8, new WandItem("calm animals", 750));
						wandByRarityMap.put(10, new WandItem("charm animal", 750));
						wandByRarityMap.put(12, new WandItem("chill touch", 750));
						wandByRarityMap.put(14, new WandItem("compel hostility", 750));
						wandByRarityMap.put(17, new WandItem("lesser confusion", 750));
						wandByRarityMap.put(19, new WandItem("corrosive touch", 750));
						wandByRarityMap.put(21, new WandItem("deathwatch", 750));
						wandByRarityMap.put(22, new WandItem("detect animals or plants", 750));
						wandByRarityMap.put(23, new WandItem("detect chaos", 750));
						wandByRarityMap.put(24, new WandItem("detect evil", 750));
						wandByRarityMap.put(25, new WandItem("detect good", 750));
						wandByRarityMap.put(26, new WandItem("detect law", 750));
						wandByRarityMap.put(28, new WandItem("detect secret doors", 750));
						wandByRarityMap.put(29, new WandItem("detect snares and pits", 750));
						wandByRarityMap.put(31, new WandItem("detect undead", 750));
						wandByRarityMap.put(35, new WandItem("doom", 750));
						wandByRarityMap.put(37, new WandItem("entropic shield", 750));
						wandByRarityMap.put(38, new WandItem("erase", 750));
						wandByRarityMap.put(39, new WandItem("faerie fire", 750));
						wandByRarityMap.put(41, new WandItem("feather step", 750));
						wandByRarityMap.put(44, new WandItem("floating disk", 750));
						wandByRarityMap.put(47, new WandItem("goodberry", 750));
						wandByRarityMap.put(49, new WandItem("hide from animals", 750));
						wandByRarityMap.put(51, new WandItem("hide from undead", 750));
						wandByRarityMap.put(52, new WandItem("hideous laughter", 750));
						wandByRarityMap.put(54, new WandItem("hold portal", 750));
						wandByRarityMap.put(56, new WandItem("hypnotism", 750));
						wandByRarityMap.put(58, new WandItem("icicle dagger", 750));
						wandByRarityMap.put(60, new WandItem("ill omen", 750));
						wandByRarityMap.put(63, new WandItem("jump", 750));
						wandByRarityMap.put(65, new WandItem("longstrider", 750));
						wandByRarityMap.put(66, new WandItem("magic aura", 750));
						wandByRarityMap.put(68, new WandItem("mount", 750));
						wandByRarityMap.put(69, new WandItem("obscure object", 750));
						wandByRarityMap.put(71, new WandItem("pass without trace", 750));
						wandByRarityMap.put(72, new WandItem("ray of sickening", 750));
						wandByRarityMap.put(75, new WandItem("reduce person", 750));
						wandByRarityMap.put(78, new WandItem("sanctuary", 750));
						wandByRarityMap.put(80, new WandItem("shock shield", 750));
						wandByRarityMap.put(83, new WandItem("speak with animals", 750));
						wandByRarityMap.put(85, new WandItem("stone fist", 750));
						wandByRarityMap.put(87, new WandItem("stone shield", 750));
						wandByRarityMap.put(88, new WandItem("summon minor monster", 750));
						wandByRarityMap.put(89, new WandItem("undetectable alignment", 750));
						wandByRarityMap.put(92, new WandItem("urban grace", 750));
						wandByRarityMap.put(96, new WandItem("vanish", 750));
						wandByRarityMap.put(97, new WandItem("ventriloquism", 750));
						wandByRarityMap.put(98, new WandItem("magic mouth", 1250));
						wandByRarityMap.put(99, new WandItem("bless water", 2000));
						wandByRarityMap.put(100, new WandItem("curse water", 2000));
						break;
					default:
						break;
				}
				break;
			case 2:
				switch (wandRarity)
				{
					case COMMON:
						wandByRarityMap.put(2, new WandItem("acid arrow", 4500));
						wandByRarityMap.put(3, new WandItem("aid", 4500));
						wandByRarityMap.put(5, new WandItem("alter self", 4500));
						wandByRarityMap.put(7, new WandItem("barkskin", 4500));
						wandByRarityMap.put(10, new WandItem("bear's endurance", 4500));
						wandByRarityMap.put(11, new WandItem("blur", 4500));
						wandByRarityMap.put(14, new WandItem("bull's strength", 4500));
						wandByRarityMap.put(16, new WandItem("cat's grace", 4500));
						wandByRarityMap.put(22, new WandItem("cure moderate wounds", 4500));
						wandByRarityMap.put(25, new WandItem("darkness", 4500));
						wandByRarityMap.put(26, new WandItem("darkvision", 4500));
						wandByRarityMap.put(27, new WandItem("delay poison", 4500));
						wandByRarityMap.put(29, new WandItem("eagle's splendor", 4500));
						wandByRarityMap.put(30, new WandItem("false life", 4500));
						wandByRarityMap.put(31, new WandItem("find traps", 4500));
						wandByRarityMap.put(32, new WandItem("flame blade", 4500));
						wandByRarityMap.put(33, new WandItem("flaming sphere", 4500));
						wandByRarityMap.put(35, new WandItem("fog cloud", 4500));
						wandByRarityMap.put(37, new WandItem("fox's cunning", 4500));
						wandByRarityMap.put(38, new WandItem("glitterdust", 4500));
						wandByRarityMap.put(40, new WandItem("heat metal", 4500));
						wandByRarityMap.put(43, new WandItem("hold person", 4500));
						wandByRarityMap.put(46, new WandItem("inflict moderate wounds", 4500));
						wandByRarityMap.put(51, new WandItem("invisibility", 4500));
						wandByRarityMap.put(52, new WandItem("knock", 4500));
						wandByRarityMap.put(54, new WandItem("levitate", 4500));
						wandByRarityMap.put(55, new WandItem("minor image", 4500));
						wandByRarityMap.put(57, new WandItem("mirror image", 4500));
						wandByRarityMap.put(59, new WandItem("owl's wisdom", 4500));
						wandByRarityMap.put(60, new WandItem("pyrotechnics", 4500));
						wandByRarityMap.put(61, new WandItem("remove paralysis", 4500));
						wandByRarityMap.put(64, new WandItem("resist energy", 4500));
						wandByRarityMap.put(66, new WandItem("lesser restoration", 4500));
						wandByRarityMap.put(71, new WandItem("scorching ray", 4500));
						wandByRarityMap.put(73, new WandItem("see invisibility", 4500));
						wandByRarityMap.put(74, new WandItem("shatter", 4500));
						wandByRarityMap.put(76, new WandItem("shield other", 4500));
						wandByRarityMap.put(78, new WandItem("silence", 4500));
						wandByRarityMap.put(81, new WandItem("sound burst", 4500));
						wandByRarityMap.put(83, new WandItem("spider climb", 4500));
						wandByRarityMap.put(86, new WandItem("spiritual weapon", 4500));
						wandByRarityMap.put(88, new WandItem("summon monster II", 4500));
						wandByRarityMap.put(90, new WandItem("summon nature's ally II", 4500));
						wandByRarityMap.put(92, new WandItem("summon swarm", 4500));
						wandByRarityMap.put(96, new WandItem("web", 4500));
						wandByRarityMap.put(97, new WandItem("whispering wind", 4500));
						wandByRarityMap.put(99, new WandItem("augury", 5750));
						wandByRarityMap.put(100, new WandItem("fire trap", 5750));
						break;
					case UNCOMMON:
						wandByRarityMap.put(2, new WandItem("align weapon", 4500));
						wandByRarityMap.put(5, new WandItem("animal aspect", 4500));
						wandByRarityMap.put(6, new WandItem("animal messenger", 4500));
						wandByRarityMap.put(7, new WandItem("animal trance", 4500));
						wandByRarityMap.put(10, new WandItem("aspect of the bear", 4500));
						wandByRarityMap.put(13, new WandItem("bestow weapon proficiency", 4500));
						wandByRarityMap.put(15, new WandItem("blindness/deafness", 4500));
						wandByRarityMap.put(18, new WandItem("burning gaze", 4500));
						wandByRarityMap.put(21, new WandItem("calm emotions", 4500));
						wandByRarityMap.put(24, new WandItem("chill metal", 4500));
						wandByRarityMap.put(25, new WandItem("command undead", 4500));
						wandByRarityMap.put(27, new WandItem("daze monster", 4500));
						wandByRarityMap.put(29, new WandItem("death knell", 4500));
						wandByRarityMap.put(32, new WandItem("defensive shock", 4500));
						wandByRarityMap.put(33, new WandItem("delay pain", 4500));
						wandByRarityMap.put(35, new WandItem("detect thoughts", 4500));
						wandByRarityMap.put(39, new WandItem("disguise other", 4500));
						wandByRarityMap.put(42, new WandItem("effortless armor", 4500));
						wandByRarityMap.put(46, new WandItem("elemental touch", 4500));
						wandByRarityMap.put(48, new WandItem("enthrall", 4500));
						wandByRarityMap.put(50, new WandItem("gentle repose", 4500));
						wandByRarityMap.put(51, new WandItem("ghoul touch", 4500));
						wandByRarityMap.put(53, new WandItem("glide", 4500));
						wandByRarityMap.put(55, new WandItem("groundswell", 4500));
						wandByRarityMap.put(56, new WandItem("gust of wind", 4500));
						wandByRarityMap.put(57, new WandItem("hold animal", 4500));
						wandByRarityMap.put(59, new WandItem("hypnotic pattern", 4500));
						wandByRarityMap.put(60, new WandItem("locate object", 4500));
						wandByRarityMap.put(61, new WandItem("make whole", 4500));
						wandByRarityMap.put(63, new WandItem("misdirection", 4500));
						wandByRarityMap.put(65, new WandItem("oppresive boredom", 4500));
						wandByRarityMap.put(66, new WandItem("protection from arrows", 4500));
						wandByRarityMap.put(67, new WandItem("reduce animal", 4500));
						wandByRarityMap.put(69, new WandItem("rope trick", 4500));
						wandByRarityMap.put(72, new WandItem("scare", 4500));
						wandByRarityMap.put(74, new WandItem("share language", 4500));
						wandByRarityMap.put(76, new WandItem("soften earth and stone", 4500));
						wandByRarityMap.put(78, new WandItem("spectral hand", 4500));
						wandByRarityMap.put(80, new WandItem("status", 4500));
						wandByRarityMap.put(82, new WandItem("tongues", 4500));
						wandByRarityMap.put(84, new WandItem("touch of idiocy", 4500));
						wandByRarityMap.put(86, new WandItem("tree shape", 4500));
						wandByRarityMap.put(88, new WandItem("warp wood", 4500));
						wandByRarityMap.put(91, new WandItem("weapon of awe", 4500));
						wandByRarityMap.put(93, new WandItem("wood shape", 4500));
						wandByRarityMap.put(95, new WandItem("zone of truth", 4500));
						wandByRarityMap.put(96, new WandItem("arcane lock", 5750));
						wandByRarityMap.put(97, new WandItem("consecrate", 5750));
						wandByRarityMap.put(98, new WandItem("descrate", 5750));
						wandByRarityMap.put(99, new WandItem("continual flame", 7000));
						wandByRarityMap.put(100, new WandItem("phantom trap", 7000));
						break;
					default:
						break;
				}
				break;
			case 3:
				switch (wandRarity)
				{
					case COMMON:
						wandByRarityMap.put(2, new WandItem("beast shape I", 11250));
						wandByRarityMap.put(4, new WandItem("blink", 11250));
						wandByRarityMap.put(7, new WandItem("call lightning", 11250));
						wandByRarityMap.put(8, new WandItem("create food and water", 11250));
						wandByRarityMap.put(14, new WandItem("cure serious wounds", 11250));
						wandByRarityMap.put(16, new WandItem("daylight", 11250));
						wandByRarityMap.put(18, new WandItem("deep slumber", 11250));
						wandByRarityMap.put(20, new WandItem("deeper darkness", 11250));
						wandByRarityMap.put(25, new WandItem("dispel magic", 11250));
						wandByRarityMap.put(28, new WandItem("displacement", 11250));
						wandByRarityMap.put(34, new WandItem("fireball", 11250));
						wandByRarityMap.put(35, new WandItem("flame arrow", 11250));
						wandByRarityMap.put(37, new WandItem("fly", 11250));
						wandByRarityMap.put(38, new WandItem("gaseous form", 11250));
						wandByRarityMap.put(40, new WandItem("haste", 11250));
						wandByRarityMap.put(42, new WandItem("heroism", 11250));
						wandByRarityMap.put(45, new WandItem("inflict serious wounds", 11250));
						wandByRarityMap.put(47, new WandItem("invisibility purge", 11250));
						wandByRarityMap.put(48, new WandItem("invisibility sphere", 11250));
						wandByRarityMap.put(50, new WandItem("keen edge", 11250));
						wandByRarityMap.put(55, new WandItem("lightning bolt", 11250));
						wandByRarityMap.put(56, new WandItem("magic circle against chaos", 11250));
						wandByRarityMap.put(57, new WandItem("magic circle against evil", 11250));
						wandByRarityMap.put(58, new WandItem("magic circle against good", 11250));
						wandByRarityMap.put(59, new WandItem("magic circle against law", 11250));
						wandByRarityMap.put(60, new WandItem("greater magic fang", 11250));
						wandByRarityMap.put(62, new WandItem("magic vestment", 11250));
						wandByRarityMap.put(64, new WandItem("greater magic weapon", 11250));
						wandByRarityMap.put(66, new WandItem("major image", 11250));
						wandByRarityMap.put(70, new WandItem("prayer", 11250));
						wandByRarityMap.put(74, new WandItem("protection from energy", 11250));
						wandByRarityMap.put(75, new WandItem("remove blindness/deafness", 11250));
						wandByRarityMap.put(77, new WandItem("remove curse", 11250));
						wandByRarityMap.put(79, new WandItem("remove disease", 11250));
						wandByRarityMap.put(82, new WandItem("searing light", 11250));
						wandByRarityMap.put(83, new WandItem("sleet storm", 11250));
						wandByRarityMap.put(85, new WandItem("slow", 11250));
						wandByRarityMap.put(87, new WandItem("speak with dead", 11250));
						wandByRarityMap.put(89, new WandItem("stinking cloud", 11250));
						wandByRarityMap.put(90, new WandItem("stone shape", 11250));
						wandByRarityMap.put(92, new WandItem("suggestion", 11250));
						wandByRarityMap.put(93, new WandItem("summon monster III", 11250));
						wandByRarityMap.put(94, new WandItem("summon nature's ally III", 11250));
						wandByRarityMap.put(97, new WandItem("vampiric touch", 11250));
						wandByRarityMap.put(99, new WandItem("water breathing", 11250));
						wandByRarityMap.put(100, new WandItem("animate dead", 23750));
						break;
					case UNCOMMON:
						wandByRarityMap.put(4, new WandItem("greater animal aspect", 11250));
						wandByRarityMap.put(6, new WandItem("aqueous orb", 11250));
						wandByRarityMap.put(8, new WandItem("arcane sight", 11250));
						wandByRarityMap.put(11, new WandItem("archon's aura", 11250));
						wandByRarityMap.put(14, new WandItem("ash storm", 11250));
						wandByRarityMap.put(17, new WandItem("bestow curse", 11250));
						wandByRarityMap.put(20, new WandItem("clairaudience/clairvoyance", 11250));
						wandByRarityMap.put(22, new WandItem("contagion", 11250));
						wandByRarityMap.put(23, new WandItem("diminsh plants", 11250));
						wandByRarityMap.put(25, new WandItem("dominate animal", 11250));
						wandByRarityMap.put(29, new WandItem("elemental aura", 11250));
						wandByRarityMap.put(30, new WandItem("explosive runes", 11250));
						wandByRarityMap.put(34, new WandItem("force punch", 11250));
						wandByRarityMap.put(35, new WandItem("halt undead", 11250));
						wandByRarityMap.put(37, new WandItem("helping hand", 11250));
						wandByRarityMap.put(40, new WandItem("hostile levitation", 11250));
						wandByRarityMap.put(43, new WandItem("howling agony", 11250));
						wandByRarityMap.put(45, new WandItem("hydraulic torrent", 11250));
						wandByRarityMap.put(46, new WandItem("mad monkeys", 11250));
						wandByRarityMap.put(49, new WandItem("meld into stone", 11250));
						wandByRarityMap.put(52, new WandItem("neutralize poison", 11250));
						wandByRarityMap.put(54, new WandItem("pain strike", 11250));
						wandByRarityMap.put(55, new WandItem("phantom steed", 11250));
						wandByRarityMap.put(57, new WandItem("plant growth", 11250));
						wandByRarityMap.put(60, new WandItem("poison", 11250));
						wandByRarityMap.put(61, new WandItem("quench", 11250));
						wandByRarityMap.put(65, new WandItem("rage", 11250));
						wandByRarityMap.put(67, new WandItem("ray of exhaustion", 11250));
						wandByRarityMap.put(69, new WandItem("resinous skin", 11250));
						wandByRarityMap.put(70, new WandItem("secret page", 11250));
						wandByRarityMap.put(71, new WandItem("shrink item", 11250));
						wandByRarityMap.put(73, new WandItem("snare", 11250));
						wandByRarityMap.put(74, new WandItem("speak with plants", 11250));
						wandByRarityMap.put(76, new WandItem("spike growth", 11250));
						wandByRarityMap.put(77, new WandItem("tiny hut", 11250));
						wandByRarityMap.put(81, new WandItem("water walk", 11250));
						wandByRarityMap.put(84, new WandItem("wind wall", 11250));
						wandByRarityMap.put(86, new WandItem("wrathful mantle", 11250));
						wandByRarityMap.put(87, new WandItem("illusory script", 13750));
						wandByRarityMap.put(89, new WandItem("nondetection", 13750));
						wandByRarityMap.put(91, new WandItem("glibness", 15750));
						wandByRarityMap.put(95, new WandItem("good hope", 15750));
						wandByRarityMap.put(97, new WandItem("heal mount", 15750));
						wandByRarityMap.put(98, new WandItem("sculpt sound", 15750));
						wandByRarityMap.put(99, new WandItem("glyph of warding", 21250));
						wandByRarityMap.put(100, new WandItem("sepia snake sigil", 36250));
						break;
					default:
						break;
				}
				break;
			case 4:
				switch (wandRarity)
				{
					case COMMON:
						wandByRarityMap.put(2, new WandItem("air walk", 21000));
						wandByRarityMap.put(4, new WandItem("beast shape II", 21000));
						wandByRarityMap.put(7, new WandItem("black tentacles", 21000));
						wandByRarityMap.put(8, new WandItem("chaos hammer", 21000));
						wandByRarityMap.put(11, new WandItem("charm monster", 21000));
						wandByRarityMap.put(14, new WandItem("confusion", 21000));
						wandByRarityMap.put(16, new WandItem("crushing despair", 21000));
						wandByRarityMap.put(22, new WandItem("cure critical wounds", 21000));
						wandByRarityMap.put(24, new WandItem("death ward", 21000));
						wandByRarityMap.put(28, new WandItem("dimension door", 21000));
						wandByRarityMap.put(29, new WandItem("dimensional anchor", 21000));
						wandByRarityMap.put(30, new WandItem("dismissal", 21000));
						wandByRarityMap.put(33, new WandItem("divine power", 21000));
						wandByRarityMap.put(35, new WandItem("elemental body I", 21000));
						wandByRarityMap.put(37, new WandItem("enervation", 21000));
						wandByRarityMap.put(39, new WandItem("mass enlarge person", 21000));
						wandByRarityMap.put(42, new WandItem("fear", 21000));
						wandByRarityMap.put(44, new WandItem("fire shield", 21000));
						wandByRarityMap.put(48, new WandItem("flame strike", 21000));
						wandByRarityMap.put(51, new WandItem("freedom of movement", 21000));
						wandByRarityMap.put(53, new WandItem("lesser globe of invulnerability", 21000));
						wandByRarityMap.put(54, new WandItem("holy smite", 21000));
						wandByRarityMap.put(56, new WandItem("ice storm", 21000));
						wandByRarityMap.put(58, new WandItem("imbue with spell ability", 21000));
						wandByRarityMap.put(61, new WandItem("inflict critical wounds", 21000));
						wandByRarityMap.put(65, new WandItem("greater invisibility", 21000));
						wandByRarityMap.put(66, new WandItem("order's wrath", 21000));
						wandByRarityMap.put(69, new WandItem("phantasmal killer", 21000));
						wandByRarityMap.put(70, new WandItem("resilient sphere", 21000));
						wandByRarityMap.put(72, new WandItem("scrying", 21000));
						wandByRarityMap.put(73, new WandItem("sending", 21000));
						wandByRarityMap.put(74, new WandItem("shout", 21000));
						wandByRarityMap.put(76, new WandItem("solid fog", 21000));
						wandByRarityMap.put(79, new WandItem("spell immunity", 21000));
						wandByRarityMap.put(80, new WandItem("summon monstrer IV", 21000));
						wandByRarityMap.put(81, new WandItem("summon nature's ally IV", 21000));
						wandByRarityMap.put(82, new WandItem("unholy blight", 21000));
						wandByRarityMap.put(87, new WandItem("wall of fire", 21000));
						wandByRarityMap.put(91, new WandItem("wall of ice", 21000));
						wandByRarityMap.put(93, new WandItem("divination", 22250));
						wandByRarityMap.put(95, new WandItem("restoration", 26000));
						wandByRarityMap.put(96, new WandItem("break enchantment", 30000));
						wandByRarityMap.put(98, new WandItem("stoneskin", 33500));
						wandByRarityMap.put(99, new WandItem("lesser planar ally", 46000));
						wandByRarityMap.put(100, new WandItem("restoration (can dispel negative levels)", 71000));
						break;
					case UNCOMMON:
						wandByRarityMap.put(1, new WandItem("antiplant shell", 21000));
						wandByRarityMap.put(4, new WandItem("arcane eye", 21000));
						wandByRarityMap.put(7, new WandItem("aspect of the stag", 21000));
						wandByRarityMap.put(11, new WandItem("ball lightning", 21000));
						wandByRarityMap.put(12, new WandItem("blight", 21000));
						wandByRarityMap.put(13, new WandItem("command plants", 21000));
						wandByRarityMap.put(15, new WandItem("control water", 21000));
						wandByRarityMap.put(18, new WandItem("greater darkvision", 21000));
						wandByRarityMap.put(19, new WandItem("detect scrying", 21000));
						wandByRarityMap.put(20, new WandItem("discern lies", 21000));
						wandByRarityMap.put(24, new WandItem("dragon's breath", 21000));
						wandByRarityMap.put(28, new WandItem("greater false life", 21000));
						wandByRarityMap.put(30, new WandItem("lesser geas", 21000));
						wandByRarityMap.put(34, new WandItem("ghost wolf", 21000));
						wandByRarityMap.put(36, new WandItem("giant vermin", 21000));
						wandByRarityMap.put(37, new WandItem("hallucinatory terrain", 21000));
						wandByRarityMap.put(38, new WandItem("illusory wall", 21000));
						wandByRarityMap.put(40, new WandItem("locate creature", 21000));
						wandByRarityMap.put(42, new WandItem("minor creation", 21000));
						wandByRarityMap.put(43, new WandItem("mnemonic enhancer", 21000));
						wandByRarityMap.put(46, new WandItem("obsidian flow", 21000));
						wandByRarityMap.put(48, new WandItem("rainbow pattern", 21000));
						wandByRarityMap.put(50, new WandItem("mass reduce person", 21000));
						wandByRarityMap.put(53, new WandItem("reincarnate", 21000));
						wandByRarityMap.put(54, new WandItem("repel vermin", 21000));
						wandByRarityMap.put(56, new WandItem("ride the waves", 21000));
						wandByRarityMap.put(59, new WandItem("rusting grasp", 21000));
						wandByRarityMap.put(60, new WandItem("secure shelter", 21000));
						wandByRarityMap.put(63, new WandItem("shadow conjuration", 21000));
						wandByRarityMap.put(67, new WandItem("shadow step", 21000));
						wandByRarityMap.put(70, new WandItem("shocking image", 21000));
						wandByRarityMap.put(74, new WandItem("spike stones", 21000));
						wandByRarityMap.put(76, new WandItem("volcanic storm", 21000));
						wandByRarityMap.put(79, new WandItem("wandering star motes", 21000));
						wandByRarityMap.put(80, new WandItem("animal growth", 30000));
						wandByRarityMap.put(82, new WandItem("commune with nature", 30000));
						wandByRarityMap.put(83, new WandItem("dispel chaos", 30000));
						wandByRarityMap.put(84, new WandItem("dispel evil", 30000));
						wandByRarityMap.put(87, new WandItem("dominate person", 30000));
						wandByRarityMap.put(91, new WandItem("hold monster", 30000));
						wandByRarityMap.put(94, new WandItem("holy sword", 30000));
						wandByRarityMap.put(95, new WandItem("mark of justice", 30000));
						wandByRarityMap.put(97, new WandItem("modify memory", 30000));
						wandByRarityMap.put(98, new WandItem("tree stride", 30000));
						wandByRarityMap.put(99, new WandItem("zone of silence", 30000));
						wandByRarityMap.put(100, new WandItem("legend lore", 33500));
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}

	private void generateWandRarity() 
	{
		if (wandRarityMap == null)
		{
			wandRarityMap = new LinkedHashMap<Integer, WandRarity>();
			wandRarityMap.put(75, WandRarity.COMMON);
			wandRarityMap.put(100, WandRarity.UNCOMMON);
		}
		this.wandRarity = ItemsForSale.getRandomThing(wandRarityMap);
	}

	@Override
	public Item copyItem() 
	{
		WandItem itemCopy = new WandItem(this.wandLevel);
		return itemCopy;		
	}
}
