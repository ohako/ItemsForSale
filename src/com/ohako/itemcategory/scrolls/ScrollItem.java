package com.ohako.itemcategory.scrolls;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;

public class ScrollItem extends Item 
{
	private int scrollLevel;
	private String itemName;
	private int itemPrice;
	private ScrollRarity scrollRarity;

	private static Map<Integer, ScrollRarity> scrollRarityMap;
	private static Map<Integer, Map<ScrollRarity, Map<Integer, ScrollItem>>> scrollMap;

	public enum ScrollRarity
	{
		COMMON_ARCANE,
		UNCOMMON_ARCANE,
		COMMON_DIVINE,
		UNCOMMON_DIVINE
	}
	
	public ScrollItem(int scrollLevel)
	{
		this.scrollLevel = scrollLevel;
	}	

	public ScrollItem(String itemName, int itemPrice)
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
		generateScrollRarity();
		generateScrollFromLevelAndRarity();	
		itemName = "scroll of " + itemName;
		leafItem = true;
	}

	private void generateScrollFromLevelAndRarity() 
	{
		if (scrollMap == null)
			scrollMap = new HashMap<Integer, Map<ScrollRarity,Map<Integer,ScrollItem>>>();
		Map<ScrollRarity, Map<Integer, ScrollItem>> scrollByLevelMap = scrollMap.get(scrollLevel);
		if (scrollByLevelMap == null)
		{
			scrollByLevelMap = new HashMap<ScrollRarity, Map<Integer,ScrollItem>>();
			scrollMap.put(scrollLevel, scrollByLevelMap);
		}
		Map<Integer, ScrollItem> scrollByRarityMap = scrollByLevelMap.get(scrollRarity);
		if (scrollByRarityMap == null)
		{
			scrollByRarityMap = new LinkedHashMap<Integer, ScrollItem>();
			scrollByLevelMap.put(scrollRarity, scrollByRarityMap);
			populateScrollMap(scrollByRarityMap, scrollLevel, scrollRarity);
		}
		ScrollItem scroll = ItemsForSale.getRandomThing(scrollByRarityMap);
		this.itemName = scroll.itemName();
		this.itemPrice = scroll.itemPrice();
	}

	private void populateScrollMap(Map<Integer, ScrollItem> scrollByRarityMap,
			int scrollLevel, ScrollRarity scrollRarity) 
	{
		switch (scrollLevel)
		{
			case 0:
				switch (scrollRarity)
				{
					case COMMON_ARCANE:
						//TODO so, prices are ints of gold pieces. I am too lazy to charge 
						//someone 12.5 gold for a 0-level scroll
						scrollByRarityMap.put(9, new ScrollItem("acid splash", 13));
						scrollByRarityMap.put(17, new ScrollItem("daze", 13));
						scrollByRarityMap.put(27, new ScrollItem("detect magic", 13));
						scrollByRarityMap.put(35, new ScrollItem("flare", 13));
						scrollByRarityMap.put(45, new ScrollItem("light", 13));
						scrollByRarityMap.put(55, new ScrollItem("mage hand", 13));
						scrollByRarityMap.put(63, new ScrollItem("mending", 13));
						scrollByRarityMap.put(72, new ScrollItem("prestidigitation", 13));
						scrollByRarityMap.put(81, new ScrollItem("ray of frost", 13));
						scrollByRarityMap.put(91, new ScrollItem("read magic", 13));
						scrollByRarityMap.put(100, new ScrollItem("touch of fatigue", 13));
						break;
					case UNCOMMON_ARCANE:
						scrollByRarityMap.put(7, new ScrollItem("arcane mark", 13));
						scrollByRarityMap.put(17, new ScrollItem("bleed", 13));
						scrollByRarityMap.put(25, new ScrollItem("dancing lights", 13));
						scrollByRarityMap.put(35, new ScrollItem("detect poison", 13));
						scrollByRarityMap.put(42, new ScrollItem("disrupt undead", 13));
						scrollByRarityMap.put(51, new ScrollItem("ghost sound", 13));
						scrollByRarityMap.put(61, new ScrollItem("message", 13));
						scrollByRarityMap.put(68, new ScrollItem("open/close", 13));
						scrollByRarityMap.put(75, new ScrollItem("resistance", 13));
						scrollByRarityMap.put(83, new ScrollItem("sift", 13));
						scrollByRarityMap.put(92, new ScrollItem("spark", 13));
						scrollByRarityMap.put(100, new ScrollItem("unwitting ally", 13));
						break;
					case COMMON_DIVINE:
						scrollByRarityMap.put(11, new ScrollItem("bleed", 13));
						scrollByRarityMap.put(21, new ScrollItem("create water", 13));
						scrollByRarityMap.put(34, new ScrollItem("detect magic", 13));
						scrollByRarityMap.put(44, new ScrollItem("know direction", 13));
						scrollByRarityMap.put(55, new ScrollItem("light", 13));
						scrollByRarityMap.put(65, new ScrollItem("mending", 13));
						scrollByRarityMap.put(75, new ScrollItem("purify food and drink", 13));
						scrollByRarityMap.put(88, new ScrollItem("read magic", 13));
						scrollByRarityMap.put(100, new ScrollItem("stabilize", 13));
						break;
					case UNCOMMON_DIVINE:
						scrollByRarityMap.put(15, new ScrollItem("detect poison", 13));
						scrollByRarityMap.put(33, new ScrollItem("flare", 13));
						scrollByRarityMap.put(50, new ScrollItem("guidance", 13));
						scrollByRarityMap.put(68, new ScrollItem("resistance", 13));
						scrollByRarityMap.put(85, new ScrollItem("spark", 13));
						scrollByRarityMap.put(100, new ScrollItem("virtue", 13));
						break;
					default:
						break;
				}
				break;
			case 1:
				switch (scrollRarity)
				{
					case COMMON_ARCANE:
						scrollByRarityMap.put(5, new ScrollItem("burning hands", 25));
						scrollByRarityMap.put(9, new ScrollItem("cause fear", 25));
						scrollByRarityMap.put(14, new ScrollItem("charm person", 25));
						scrollByRarityMap.put(17, new ScrollItem("chill touch", 25));
						scrollByRarityMap.put(21, new ScrollItem("disguise self", 25));
						scrollByRarityMap.put(24, new ScrollItem("endure elements", 25));
						scrollByRarityMap.put(28, new ScrollItem("enlarge person", 25));
						scrollByRarityMap.put(32, new ScrollItem("expeditious retreat", 25));
						scrollByRarityMap.put(36, new ScrollItem("grease", 25));
						scrollByRarityMap.put(39, new ScrollItem("hypnotism", 25));
						scrollByRarityMap.put(42, new ScrollItem("identify", 25));
						scrollByRarityMap.put(48, new ScrollItem("mage armor", 25));
						scrollByRarityMap.put(54, new ScrollItem("magic missile", 25));
						scrollByRarityMap.put(58, new ScrollItem("magic weapon", 25));
						scrollByRarityMap.put(62, new ScrollItem("obscuring mist", 25));
						scrollByRarityMap.put(64, new ScrollItem("protection from chaos", 25));
						scrollByRarityMap.put(67, new ScrollItem("protection from evil", 25));
						scrollByRarityMap.put(69, new ScrollItem("protection from good", 25));
						scrollByRarityMap.put(71, new ScrollItem("protection from law", 25));
						scrollByRarityMap.put(75, new ScrollItem("ray of enfeeblement", 25));
						scrollByRarityMap.put(80, new ScrollItem("shield", 25));
						scrollByRarityMap.put(84, new ScrollItem("shocking grasp", 25));
						scrollByRarityMap.put(88, new ScrollItem("silent image", 25));
						scrollByRarityMap.put(93, new ScrollItem("sleep", 25));
						scrollByRarityMap.put(96, new ScrollItem("summon monster I", 25));
						scrollByRarityMap.put(100, new ScrollItem("true strike", 25));
						break;
					case UNCOMMON_ARCANE:
						scrollByRarityMap.put(2, new ScrollItem("air bubble", 25));
						scrollByRarityMap.put(6, new ScrollItem("alarm", 25));
						scrollByRarityMap.put(8, new ScrollItem("animate rope", 25));
						scrollByRarityMap.put(12, new ScrollItem("ant haul", 25));
						scrollByRarityMap.put(15, new ScrollItem("blend", 25));
						scrollByRarityMap.put(18, new ScrollItem("break", 25));
						scrollByRarityMap.put(23, new ScrollItem("color spray", 25));
						scrollByRarityMap.put(26, new ScrollItem("comprehend languages", 25));
						scrollByRarityMap.put(30, new ScrollItem("corrosive touch", 25));
						scrollByRarityMap.put(33, new ScrollItem("detect secret doors", 25));
						scrollByRarityMap.put(36, new ScrollItem("detect undead", 25));
						scrollByRarityMap.put(38, new ScrollItem("erase", 25));
						scrollByRarityMap.put(40, new ScrollItem("flare burst", 25));
						scrollByRarityMap.put(43, new ScrollItem("floating disk", 25));
						scrollByRarityMap.put(46, new ScrollItem("hold portal", 25));
						scrollByRarityMap.put(48, new ScrollItem("hydraulic push", 25));
						scrollByRarityMap.put(51, new ScrollItem("icicle dagger", 25));
						scrollByRarityMap.put(54, new ScrollItem("illusion of calm", 25));
						scrollByRarityMap.put(58, new ScrollItem("jump", 25));
						scrollByRarityMap.put(60, new ScrollItem("magic aura", 25));
						scrollByRarityMap.put(63, new ScrollItem("mirror strike", 25));
						scrollByRarityMap.put(66, new ScrollItem("mount", 25));
						scrollByRarityMap.put(69, new ScrollItem("ray of sickening", 25));
						scrollByRarityMap.put(71, new ScrollItem("reduce person", 25));
						scrollByRarityMap.put(74, new ScrollItem("shadow weapon", 25));
						scrollByRarityMap.put(77, new ScrollItem("shock shield", 25));
						scrollByRarityMap.put(80, new ScrollItem("stone fist", 25));
						scrollByRarityMap.put(84, new ScrollItem("touch of the sea", 25));
						scrollByRarityMap.put(88, new ScrollItem("unseen servant", 25));
						scrollByRarityMap.put(91, new ScrollItem("urban grace", 25));
						scrollByRarityMap.put(96, new ScrollItem("vanish", 25));
						scrollByRarityMap.put(98, new ScrollItem("ventriloquism", 25));
						scrollByRarityMap.put(100, new ScrollItem("voice alteration", 25));
						break;
					case COMMON_DIVINE:
						scrollByRarityMap.put(4, new ScrollItem("bane", 25));
						scrollByRarityMap.put(10, new ScrollItem("bless", 25));
						scrollByRarityMap.put(15, new ScrollItem("cause fear", 25));
						scrollByRarityMap.put(19, new ScrollItem("command", 25));
						scrollByRarityMap.put(22, new ScrollItem("comprehend languages", 25));
						scrollByRarityMap.put(28, new ScrollItem("cure light wounds", 25));
						scrollByRarityMap.put(30, new ScrollItem("detect chaos", 25));
						scrollByRarityMap.put(32, new ScrollItem("detect evil", 25));
						scrollByRarityMap.put(34, new ScrollItem("detect good", 25));
						scrollByRarityMap.put(36, new ScrollItem("detect law", 25));
						scrollByRarityMap.put(39, new ScrollItem("detect undead", 25));
						scrollByRarityMap.put(45, new ScrollItem("divine favor", 25));
						scrollByRarityMap.put(48, new ScrollItem("doom", 25));
						scrollByRarityMap.put(52, new ScrollItem("entangle", 25));
						scrollByRarityMap.put(57, new ScrollItem("inflict light wounds", 25));
						scrollByRarityMap.put(61, new ScrollItem("magic fang", 25));
						scrollByRarityMap.put(65, new ScrollItem("obscuring mist", 25));
						scrollByRarityMap.put(68, new ScrollItem("produce flame", 25));
						scrollByRarityMap.put(71, new ScrollItem("protection from chaos", 25));
						scrollByRarityMap.put(74, new ScrollItem("protection from evil", 25));
						scrollByRarityMap.put(77, new ScrollItem("protection from good", 25));
						scrollByRarityMap.put(80, new ScrollItem("protection from law", 25));
						scrollByRarityMap.put(84, new ScrollItem("remove fear", 25));
						scrollByRarityMap.put(88, new ScrollItem("sanctuary", 25));
						scrollByRarityMap.put(94, new ScrollItem("shield of faith", 25));
						scrollByRarityMap.put(97, new ScrollItem("summon monster I", 25));
						scrollByRarityMap.put(100, new ScrollItem("summon nature's ally I", 25));
						break;
					case UNCOMMON_DIVINE:
						scrollByRarityMap.put(4, new ScrollItem("ant haul", 25));
						scrollByRarityMap.put(7, new ScrollItem("aspect of the falcon", 25));
						scrollByRarityMap.put(9, new ScrollItem("calm animals", 25));
						scrollByRarityMap.put(12, new ScrollItem("charm animal", 25));
						scrollByRarityMap.put(15, new ScrollItem("compel hostility", 25));
						scrollByRarityMap.put(17, new ScrollItem("deathwatch", 25));
						scrollByRarityMap.put(18, new ScrollItem("detect animals or plants", 25));
						scrollByRarityMap.put(20, new ScrollItem("detect snares and pits", 25));
						scrollByRarityMap.put(23, new ScrollItem("diagnose disease", 25));
						scrollByRarityMap.put(27, new ScrollItem("endure elements", 25));
						scrollByRarityMap.put(30, new ScrollItem("entropic shield", 25));
						scrollByRarityMap.put(33, new ScrollItem("faerie fire", 25));
						scrollByRarityMap.put(36, new ScrollItem("feather step", 25));
						scrollByRarityMap.put(39, new ScrollItem("forbid action", 25));
						scrollByRarityMap.put(42, new ScrollItem("frostbite", 25));
						scrollByRarityMap.put(46, new ScrollItem("goodberry", 25));
						scrollByRarityMap.put(47, new ScrollItem("hide from animals", 25));
						scrollByRarityMap.put(49, new ScrollItem("hide from undead", 25));
						scrollByRarityMap.put(52, new ScrollItem("hydraulic push", 25));
						scrollByRarityMap.put(55, new ScrollItem("jump", 25));
						scrollByRarityMap.put(59, new ScrollItem("keen senses", 25));
						scrollByRarityMap.put(62, new ScrollItem("liberating command", 25));
						scrollByRarityMap.put(65, new ScrollItem("longstrider", 25));
						scrollByRarityMap.put(68, new ScrollItem("magic stone", 25));
						scrollByRarityMap.put(72, new ScrollItem("pass without trace", 25));
						scrollByRarityMap.put(74, new ScrollItem("remove sickness", 25));
						scrollByRarityMap.put(75, new ScrollItem("sancitfy corpse", 25));
						scrollByRarityMap.put(78, new ScrollItem("shillelagh", 25));
						scrollByRarityMap.put(81, new ScrollItem("speak with animals", 25));
						scrollByRarityMap.put(85, new ScrollItem("stone fist", 25));
						scrollByRarityMap.put(88, new ScrollItem("stone shield", 25));
						scrollByRarityMap.put(91, new ScrollItem("sun metal", 25));
						scrollByRarityMap.put(95, new ScrollItem("touch of the sea", 25));
						scrollByRarityMap.put(98, new ScrollItem("bless water", 50));
						scrollByRarityMap.put(100, new ScrollItem("curse water", 50));
						break;
					default:
						break;
				}
				break;
			case 2:
				switch (scrollRarity)
				{
					case COMMON_ARCANE:
						scrollByRarityMap.put(4, new ScrollItem("acid arrow", 150));
						scrollByRarityMap.put(7, new ScrollItem("alter self", 150));
						scrollByRarityMap.put(12, new ScrollItem("bear's endurance", 150));
						scrollByRarityMap.put(15, new ScrollItem("blur", 150));
						scrollByRarityMap.put(20, new ScrollItem("bull's strength", 150));
						scrollByRarityMap.put(24, new ScrollItem("cat's grace", 150));
						scrollByRarityMap.put(27, new ScrollItem("darkness", 150));
						scrollByRarityMap.put(30, new ScrollItem("darkvision", 150));
						scrollByRarityMap.put(34, new ScrollItem("eagle's splendor", 150));
						scrollByRarityMap.put(37, new ScrollItem("false life", 150));
						scrollByRarityMap.put(40, new ScrollItem("flaming sphere", 150));
						scrollByRarityMap.put(44, new ScrollItem("fox's cunning", 150));
						scrollByRarityMap.put(47, new ScrollItem("glitterdust", 150));
						scrollByRarityMap.put(52, new ScrollItem("invisibility", 150));
						scrollByRarityMap.put(54, new ScrollItem("knock", 150));
						scrollByRarityMap.put(58, new ScrollItem("levitate", 150));
						scrollByRarityMap.put(61, new ScrollItem("minor image", 150));
						scrollByRarityMap.put(65, new ScrollItem("mirror image", 150));
						scrollByRarityMap.put(69, new ScrollItem("owl's wisdom", 150));
						scrollByRarityMap.put(73, new ScrollItem("resist energy", 150));
						scrollByRarityMap.put(75, new ScrollItem("rope trick", 150));
						scrollByRarityMap.put(80, new ScrollItem("scorching ray", 150));
						scrollByRarityMap.put(83, new ScrollItem("see invisibility", 150));
						scrollByRarityMap.put(85, new ScrollItem("shatter", 150));
						scrollByRarityMap.put(88, new ScrollItem("spider climb", 150));
						scrollByRarityMap.put(91, new ScrollItem("summon monster II", 150));
						scrollByRarityMap.put(93, new ScrollItem("summon swarm", 150));
						scrollByRarityMap.put(98, new ScrollItem("web", 150));
						scrollByRarityMap.put(100, new ScrollItem("whispering wind", 150));
						break;
					case UNCOMMON_ARCANE:
						scrollByRarityMap.put(3, new ScrollItem("bestow weapon proficiency", 150));
						scrollByRarityMap.put(6, new ScrollItem("blindness/deafness", 150));
						scrollByRarityMap.put(9, new ScrollItem("burning gaze", 150));
						scrollByRarityMap.put(12, new ScrollItem("certain grip", 150));
						scrollByRarityMap.put(14, new ScrollItem("command undead", 150));
						scrollByRarityMap.put(16, new ScrollItem("create pit", 150));
						scrollByRarityMap.put(20, new ScrollItem("daze monster", 150));
						scrollByRarityMap.put(23, new ScrollItem("detect thoughts", 150));
						scrollByRarityMap.put(27, new ScrollItem("disguise other", 150));
						scrollByRarityMap.put(31, new ScrollItem("elemental touch", 150));
						scrollByRarityMap.put(34, new ScrollItem("fire breath", 150));
						scrollByRarityMap.put(38, new ScrollItem("fog cloud", 150));
						scrollByRarityMap.put(40, new ScrollItem("ghoul touch", 150));
						scrollByRarityMap.put(41, new ScrollItem("glide", 150));
						scrollByRarityMap.put(44, new ScrollItem("gust of wind", 150));
						scrollByRarityMap.put(47, new ScrollItem("haunting mists", 150));
						scrollByRarityMap.put(51, new ScrollItem("hideous laughter", 150));
						scrollByRarityMap.put(54, new ScrollItem("hypnotic pattern", 150));
						scrollByRarityMap.put(57, new ScrollItem("locate object", 150));
						scrollByRarityMap.put(60, new ScrollItem("make whole", 150));
						scrollByRarityMap.put(62, new ScrollItem("misdirection", 150));
						scrollByRarityMap.put(63, new ScrollItem("obscure object", 150));
						scrollByRarityMap.put(65, new ScrollItem("pernicious poison", 150));
						scrollByRarityMap.put(67, new ScrollItem("protection from arrows", 150));
						scrollByRarityMap.put(70, new ScrollItem("pyrotechnics", 150));
						scrollByRarityMap.put(73, new ScrollItem("returning weapon", 150));
						scrollByRarityMap.put(77, new ScrollItem("scare", 150));
						scrollByRarityMap.put(80, new ScrollItem("shadow anchor", 150));
						scrollByRarityMap.put(83, new ScrollItem("share memory", 150));
						scrollByRarityMap.put(85, new ScrollItem("slipstream", 150));
						scrollByRarityMap.put(88, new ScrollItem("spectral hand", 150));
						scrollByRarityMap.put(90, new ScrollItem("spontaneous immolation", 150));
						scrollByRarityMap.put(93, new ScrollItem("touch of idiocy", 150));
						scrollByRarityMap.put(94, new ScrollItem("unshakable chill", 150));
						scrollByRarityMap.put(96, new ScrollItem("magic mouth", 160));
						scrollByRarityMap.put(97, new ScrollItem("arcane lock", 175));
						scrollByRarityMap.put(99, new ScrollItem("continual flame", 200));
						scrollByRarityMap.put(100, new ScrollItem("phantom trap", 200));
						break;
					case COMMON_DIVINE:
						scrollByRarityMap.put(4, new ScrollItem("aid", 150));
						scrollByRarityMap.put(6, new ScrollItem("align weapon", 150));
						scrollByRarityMap.put(8, new ScrollItem("animal messenger", 150));
						scrollByRarityMap.put(13, new ScrollItem("barkskin", 150));
						scrollByRarityMap.put(16, new ScrollItem("bear's endurance", 150));
						scrollByRarityMap.put(19, new ScrollItem("bull's strength", 150));
						scrollByRarityMap.put(22, new ScrollItem("cat's grace", 150));
						scrollByRarityMap.put(24, new ScrollItem("chill metal", 150));
						scrollByRarityMap.put(30, new ScrollItem("cure moderate wounds", 150));
						scrollByRarityMap.put(33, new ScrollItem("darkness", 150));
						scrollByRarityMap.put(36, new ScrollItem("delay poison", 150));
						scrollByRarityMap.put(39, new ScrollItem("eagle's splendor", 150));
						scrollByRarityMap.put(41, new ScrollItem("find traps", 150));
						scrollByRarityMap.put(44, new ScrollItem("flame blade", 150));
						scrollByRarityMap.put(46, new ScrollItem("fog cloud", 150));
						scrollByRarityMap.put(50, new ScrollItem("heat metal", 150));
						scrollByRarityMap.put(52, new ScrollItem("hold animal", 150));
						scrollByRarityMap.put(56, new ScrollItem("hold person", 150));
						scrollByRarityMap.put(60, new ScrollItem("inflict moderate wounds", 150));
						scrollByRarityMap.put(63, new ScrollItem("owl's wisdom", 150));
						scrollByRarityMap.put(65, new ScrollItem("remove paralysis", 150));
						scrollByRarityMap.put(68, new ScrollItem("resist energy", 150));
						scrollByRarityMap.put(73, new ScrollItem("lesser restoration", 150));
						scrollByRarityMap.put(77, new ScrollItem("shield other", 150));
						scrollByRarityMap.put(81, new ScrollItem("silence", 150));
						scrollByRarityMap.put(85, new ScrollItem("sound burst", 150));
						scrollByRarityMap.put(89, new ScrollItem("spiritual weapon", 150));
						scrollByRarityMap.put(91, new ScrollItem("summon monster II", 150));
						scrollByRarityMap.put(93, new ScrollItem("summon nature's ally II", 150));
						scrollByRarityMap.put(95, new ScrollItem("summon swarm", 150));
						scrollByRarityMap.put(97, new ScrollItem("zone of truth", 150));
						scrollByRarityMap.put(100, new ScrollItem("augury", 175));
						break;
					case UNCOMMON_DIVINE:
						scrollByRarityMap.put(4, new ScrollItem("animal aspect", 150));
						scrollByRarityMap.put(6, new ScrollItem("animal trance", 150));
						scrollByRarityMap.put(10, new ScrollItem("lesser animate dead", 150));
						scrollByRarityMap.put(13, new ScrollItem("arrow of law", 150));
						scrollByRarityMap.put(17, new ScrollItem("aspect of the bear", 150));
						scrollByRarityMap.put(20, new ScrollItem("blessing of courage and life", 150));
						scrollByRarityMap.put(24, new ScrollItem("calm emotions", 150));
						scrollByRarityMap.put(27, new ScrollItem("death knell", 150));
						scrollByRarityMap.put(30, new ScrollItem("dread bolt", 150));
						scrollByRarityMap.put(34, new ScrollItem("effortless armor", 150));
						scrollByRarityMap.put(37, new ScrollItem("enthrall", 150));
						scrollByRarityMap.put(41, new ScrollItem("flaming sphere", 150));
						scrollByRarityMap.put(43, new ScrollItem("gentle repose", 150));
						scrollByRarityMap.put(46, new ScrollItem("grace", 150));
						scrollByRarityMap.put(48, new ScrollItem("groundswell", 150));
						scrollByRarityMap.put(51, new ScrollItem("gust of wind", 150));
						scrollByRarityMap.put(53, new ScrollItem("instant armor", 150));
						scrollByRarityMap.put(55, new ScrollItem("instrument of agony", 150));
						scrollByRarityMap.put(58, new ScrollItem("make whole", 150));
						scrollByRarityMap.put(60, new ScrollItem("reduce animal", 150));
						scrollByRarityMap.put(62, new ScrollItem("scent trail", 150));
						scrollByRarityMap.put(65, new ScrollItem("shard of chaos", 150));
						scrollByRarityMap.put(68, new ScrollItem("share language", 150));
						scrollByRarityMap.put(70, new ScrollItem("shatter", 150));
						scrollByRarityMap.put(73, new ScrollItem("soften earth and stone", 150));
						scrollByRarityMap.put(76, new ScrollItem("spear of purity", 150));
						scrollByRarityMap.put(79, new ScrollItem("spider climb", 150));
						scrollByRarityMap.put(82, new ScrollItem("status", 150));
						scrollByRarityMap.put(84, new ScrollItem("tree shape", 150));
						scrollByRarityMap.put(85, new ScrollItem("undetectable alignment", 150));
						scrollByRarityMap.put(88, new ScrollItem("warp wood", 150));
						scrollByRarityMap.put(91, new ScrollItem("weapon of awe", 150));
						scrollByRarityMap.put(93, new ScrollItem("wood shape", 150));
						scrollByRarityMap.put(95, new ScrollItem("consecrate", 175));
						scrollByRarityMap.put(97, new ScrollItem("desecrate", 175));
						scrollByRarityMap.put(99, new ScrollItem("fire trap", 175));
						scrollByRarityMap.put(100, new ScrollItem("masterwork transformation", 450));
						break;
					default:
						break;
				}
				break;
			case 3:
				switch (scrollRarity)
				{
					case COMMON_ARCANE:
						scrollByRarityMap.put(3, new ScrollItem("beast shape I", 375));
						scrollByRarityMap.put(7, new ScrollItem("blink", 375));
						scrollByRarityMap.put(12, new ScrollItem("dispel magic", 375));
						scrollByRarityMap.put(16, new ScrollItem("displacement", 375));
						scrollByRarityMap.put(21, new ScrollItem("fireball", 375));
						scrollByRarityMap.put(24, new ScrollItem("flame arrow", 375));
						scrollByRarityMap.put(29, new ScrollItem("fly", 375));
						scrollByRarityMap.put(32, new ScrollItem("gaseous form", 375));
						scrollByRarityMap.put(37, new ScrollItem("haste", 375));
						scrollByRarityMap.put(40, new ScrollItem("heroism", 375));
						scrollByRarityMap.put(43, new ScrollItem("hold person", 375));
						scrollByRarityMap.put(46, new ScrollItem("invisibility sphere", 375));
						scrollByRarityMap.put(51, new ScrollItem("lightning bolt", 375));
						scrollByRarityMap.put(54, new ScrollItem("magic circle against chaos", 375));
						scrollByRarityMap.put(57, new ScrollItem("magic circle against evil", 375));
						scrollByRarityMap.put(60, new ScrollItem("magic circle against good", 375));
						scrollByRarityMap.put(63, new ScrollItem("magic circle against law", 375));
						scrollByRarityMap.put(66, new ScrollItem("major image", 375));
						scrollByRarityMap.put(70, new ScrollItem("phantom steed", 375));
						scrollByRarityMap.put(74, new ScrollItem("protection from energy", 375));
						scrollByRarityMap.put(78, new ScrollItem("slow", 375));
						scrollByRarityMap.put(81, new ScrollItem("stinking cloud", 375));
						scrollByRarityMap.put(84, new ScrollItem("suggestion", 375));
						scrollByRarityMap.put(87, new ScrollItem("summon monster III", 375));
						scrollByRarityMap.put(90, new ScrollItem("tiny hut", 375));
						scrollByRarityMap.put(94, new ScrollItem("tongues", 375));
						scrollByRarityMap.put(97, new ScrollItem("vampiric touch", 375));
						scrollByRarityMap.put(100, new ScrollItem("water breathing", 375));
						break;
					case UNCOMMON_ARCANE:
						scrollByRarityMap.put(3, new ScrollItem("lesser animate dead", 375));
						scrollByRarityMap.put(6, new ScrollItem("aqueous orb", 375));
						scrollByRarityMap.put(8, new ScrollItem("arcane sight", 375));
						scrollByRarityMap.put(12, new ScrollItem("beast shape", 375)); //?? huh ??
						scrollByRarityMap.put(15, new ScrollItem("clairaudience/clairvoyance", 375));
						scrollByRarityMap.put(17, new ScrollItem("cloak of winds", 375));
						scrollByRarityMap.put(20, new ScrollItem("daylight", 375));
						scrollByRarityMap.put(24, new ScrollItem("deep slumber", 375));
						scrollByRarityMap.put(27, new ScrollItem("distracting cacophony", 375));
						scrollByRarityMap.put(30, new ScrollItem("draconic reservoir", 375));
						scrollByRarityMap.put(35, new ScrollItem("elemental aura", 375));
						scrollByRarityMap.put(38, new ScrollItem("explosive runes", 375));
						scrollByRarityMap.put(43, new ScrollItem("force punch", 375));
						scrollByRarityMap.put(45, new ScrollItem("gentle repose", 375));
						scrollByRarityMap.put(47, new ScrollItem("halt undead", 375));
						scrollByRarityMap.put(49, new ScrollItem("healing thief", 375));
						scrollByRarityMap.put(51, new ScrollItem("hydraulic torrent", 375));
						scrollByRarityMap.put(56, new ScrollItem("keen edge", 375));
						scrollByRarityMap.put(61, new ScrollItem("greater magic weapon", 375));
						scrollByRarityMap.put(65, new ScrollItem("monstrous physique I", 375));
						scrollByRarityMap.put(68, new ScrollItem("rage", 375));
						scrollByRarityMap.put(70, new ScrollItem("ray of exhaustrion", 375));
						scrollByRarityMap.put(73, new ScrollItem("resinous skin", 375));
						scrollByRarityMap.put(75, new ScrollItem("communal resist energy", 375));
						scrollByRarityMap.put(78, new ScrollItem("secret page", 375));
						scrollByRarityMap.put(80, new ScrollItem("shrink item", 375));
						scrollByRarityMap.put(83, new ScrollItem("sleet storm", 375));
						scrollByRarityMap.put(86, new ScrollItem("spiked pit", 375));
						scrollByRarityMap.put(90, new ScrollItem("undead anatomy I", 375));
						scrollByRarityMap.put(92, new ScrollItem("versatile weapon", 375));
						scrollByRarityMap.put(95, new ScrollItem("wind wall", 375));
						scrollByRarityMap.put(96, new ScrollItem("illusory script", 425));
						scrollByRarityMap.put(99, new ScrollItem("nondetection", 425));
						scrollByRarityMap.put(100, new ScrollItem("sepia snake sigil", 875));
						break;
					case COMMON_DIVINE:
						scrollByRarityMap.put(3, new ScrollItem("bestow curse", 375));
						scrollByRarityMap.put(8, new ScrollItem("call lightning", 375));
						scrollByRarityMap.put(15, new ScrollItem("cure serious wounds", 375));
						scrollByRarityMap.put(19, new ScrollItem("daylight", 375));
						scrollByRarityMap.put(23, new ScrollItem("deeper darkness", 375));
						scrollByRarityMap.put(28, new ScrollItem("dispel magic", 375));
						scrollByRarityMap.put(33, new ScrollItem("inflict serious wounds", 375));
						scrollByRarityMap.put(37, new ScrollItem("invisibility purge", 375));
						scrollByRarityMap.put(40, new ScrollItem("locate object", 375));
						scrollByRarityMap.put(42, new ScrollItem("magic circle against chaos", 375));
						scrollByRarityMap.put(44, new ScrollItem("magic circle against evil", 375));
						scrollByRarityMap.put(46, new ScrollItem("magic circle against good", 375));
						scrollByRarityMap.put(48, new ScrollItem("magic circle against law", 375));
						scrollByRarityMap.put(52, new ScrollItem("greater magic fang", 375));
						scrollByRarityMap.put(57, new ScrollItem("magic vestment", 375));
						scrollByRarityMap.put(59, new ScrollItem("poison", 375));
						scrollByRarityMap.put(65, new ScrollItem("prayer", 375));
						scrollByRarityMap.put(68, new ScrollItem("protection from energy", 375));
						scrollByRarityMap.put(70, new ScrollItem("remove blindness/deafness", 375));
						scrollByRarityMap.put(73, new ScrollItem("remove curse", 375));
						scrollByRarityMap.put(76, new ScrollItem("remove disease", 375));
						scrollByRarityMap.put(79, new ScrollItem("searing light", 375));
						scrollByRarityMap.put(81, new ScrollItem("sleet storm", 375));
						scrollByRarityMap.put(85, new ScrollItem("speak with dead", 375));
						scrollByRarityMap.put(87, new ScrollItem("stone shape", 375));
						scrollByRarityMap.put(89, new ScrollItem("summon monster III", 375));
						scrollByRarityMap.put(91, new ScrollItem("summon nature's ally III", 375));
						scrollByRarityMap.put(95, new ScrollItem("water breathing", 375));
						scrollByRarityMap.put(97, new ScrollItem("water walk", 375));
						scrollByRarityMap.put(100, new ScrollItem("animate dead", 625));
						break;
					case UNCOMMON_DIVINE:
						scrollByRarityMap.put(4, new ScrollItem("aqueous orb", 375));
						scrollByRarityMap.put(8, new ScrollItem("archon's aura", 375));
						scrollByRarityMap.put(12, new ScrollItem("bestow insight", 375));
						scrollByRarityMap.put(16, new ScrollItem("blindness/deafness", 375));
						scrollByRarityMap.put(19, new ScrollItem("burst of nettles", 375));
						scrollByRarityMap.put(22, new ScrollItem("chain of perdition", 375));
						scrollByRarityMap.put(26, new ScrollItem("contagion", 375));
						scrollByRarityMap.put(30, new ScrollItem("create food and water", 375));
						scrollByRarityMap.put(34, new ScrollItem("daybreak arrow", 375));
						scrollByRarityMap.put(36, new ScrollItem("diminish plants", 375));
						scrollByRarityMap.put(40, new ScrollItem("discovery torch", 375));
						scrollByRarityMap.put(45, new ScrollItem("dominate animal", 375));
						scrollByRarityMap.put(48, new ScrollItem("guiding star", 375));
						scrollByRarityMap.put(51, new ScrollItem("helping hand", 375));
						scrollByRarityMap.put(56, new ScrollItem("meld into stone", 375));
						scrollByRarityMap.put(58, new ScrollItem("obscure object", 375));
						scrollByRarityMap.put(61, new ScrollItem("plant growth", 375));
						scrollByRarityMap.put(64, new ScrollItem("quench", 375));
						scrollByRarityMap.put(67, new ScrollItem("shifting sands", 375));
						scrollByRarityMap.put(72, new ScrollItem("snare", 375));
						scrollByRarityMap.put(75, new ScrollItem("speak with plants", 375));
						scrollByRarityMap.put(80, new ScrollItem("spike growth", 375));
						scrollByRarityMap.put(83, new ScrollItem("vision of hell", 375));
						scrollByRarityMap.put(87, new ScrollItem("wind wall", 375));
						scrollByRarityMap.put(90, new ScrollItem("wrathful mantle", 375));
						scrollByRarityMap.put(93, new ScrollItem("continual flame", 425));
						scrollByRarityMap.put(96, new ScrollItem("nap stack", 475));
						scrollByRarityMap.put(98, new ScrollItem("glyph of warding", 575));
						scrollByRarityMap.put(100, new ScrollItem("symbol of healing", 875));
						break;
					default:
						break;
				}
				break;
			case 4:
				switch (scrollRarity)
				{
					case COMMON_ARCANE:
						scrollByRarityMap.put(3, new ScrollItem("beast shape II", 700));
						scrollByRarityMap.put(5, new ScrollItem("bestow curse", 700));
						scrollByRarityMap.put(9, new ScrollItem("black tentacles", 700));
						scrollByRarityMap.put(14, new ScrollItem("charm monster", 700));
						scrollByRarityMap.put(18, new ScrollItem("confusion", 700));
						scrollByRarityMap.put(21, new ScrollItem("crushing despair", 700));
						scrollByRarityMap.put(26, new ScrollItem("dimension door", 700));
						scrollByRarityMap.put(29, new ScrollItem("dimensional anchor", 700));
						scrollByRarityMap.put(32, new ScrollItem("elemental body I", 700));
						scrollByRarityMap.put(36, new ScrollItem("enervation", 700));
						scrollByRarityMap.put(38, new ScrollItem("mass enlarge person", 700));
						scrollByRarityMap.put(43, new ScrollItem("fear", 700));
						scrollByRarityMap.put(47, new ScrollItem("fire shield", 700));
						scrollByRarityMap.put(50, new ScrollItem("lesser globe of invulnerability", 700));
						scrollByRarityMap.put(54, new ScrollItem("ice storm", 700));
						scrollByRarityMap.put(59, new ScrollItem("greater invisibility", 700));
						scrollByRarityMap.put(64, new ScrollItem("phantasmal killer", 700));
						scrollByRarityMap.put(67, new ScrollItem("resilient sphere", 700));
						scrollByRarityMap.put(71, new ScrollItem("scrying", 700));
						scrollByRarityMap.put(74, new ScrollItem("shadow conjuration", 700));
						scrollByRarityMap.put(76, new ScrollItem("shout", 700));
						scrollByRarityMap.put(78, new ScrollItem("solid fog", 700));
						scrollByRarityMap.put(80, new ScrollItem("stone shape", 700));
						scrollByRarityMap.put(83, new ScrollItem("summon monster IV", 700));
						scrollByRarityMap.put(88, new ScrollItem("wall of fire", 700));
						scrollByRarityMap.put(92, new ScrollItem("wall of ice", 700));
						scrollByRarityMap.put(97, new ScrollItem("stoneskin", 950));
						scrollByRarityMap.put(100, new ScrollItem("animate dead", 1050));
						break;
					case UNCOMMON_ARCANE:
						scrollByRarityMap.put(2, new ScrollItem("acid pit", 700));
						scrollByRarityMap.put(6, new ScrollItem("arcane eye", 700));
						scrollByRarityMap.put(10, new ScrollItem("ball lightning", 700));
						scrollByRarityMap.put(13, new ScrollItem("contagion", 700));
						scrollByRarityMap.put(17, new ScrollItem("greater darkvision", 700));
						scrollByRarityMap.put(19, new ScrollItem("detect scrying", 700));
						scrollByRarityMap.put(23, new ScrollItem("dragon's breath", 700));
						scrollByRarityMap.put(28, new ScrollItem("greater false life", 700));
						scrollByRarityMap.put(32, new ScrollItem("firefall", 700));
						scrollByRarityMap.put(35, new ScrollItem("lesser geas", 700));
						scrollByRarityMap.put(39, new ScrollItem("ghost wolf", 700));
						scrollByRarityMap.put(41, new ScrollItem("hallucinatory terrain", 700));
						scrollByRarityMap.put(43, new ScrollItem("illusory wall", 700));
						scrollByRarityMap.put(46, new ScrollItem("locate creature", 700));
						scrollByRarityMap.put(50, new ScrollItem("minor creation", 700));
						scrollByRarityMap.put(54, new ScrollItem("monstrous physique II", 700));
						scrollByRarityMap.put(57, new ScrollItem("obsidian flow", 700));
						scrollByRarityMap.put(59, new ScrollItem("phantom chariot", 700));
						scrollByRarityMap.put(62, new ScrollItem("rainbow pattern", 700));
						scrollByRarityMap.put(64, new ScrollItem("mass reduce person", 700));
						scrollByRarityMap.put(68, new ScrollItem("remove curse", 700));
						scrollByRarityMap.put(71, new ScrollItem("secure shelter", 700));
						scrollByRarityMap.put(74, new ScrollItem("shadow projection", 700));
						scrollByRarityMap.put(79, new ScrollItem("shocking image", 700));
						scrollByRarityMap.put(83, new ScrollItem("telekinetic charge", 700));
						scrollByRarityMap.put(85, new ScrollItem("true form", 700));
						scrollByRarityMap.put(89, new ScrollItem("vermin shape I", 700));
						scrollByRarityMap.put(94, new ScrollItem("volcanic storm", 700));
						scrollByRarityMap.put(97, new ScrollItem("wandering star motes", 700));
						scrollByRarityMap.put(99, new ScrollItem("fire trap", 725));
						scrollByRarityMap.put(100, new ScrollItem("mnemoic enchancer", 750));
						break;
					case COMMON_DIVINE:
						scrollByRarityMap.put(4, new ScrollItem("air walk", 700));
						scrollByRarityMap.put(7, new ScrollItem("chaos hammer", 700));
						scrollByRarityMap.put(15, new ScrollItem("cure critical wounds", 700));
						scrollByRarityMap.put(19, new ScrollItem("death ward", 700));
						scrollByRarityMap.put(22, new ScrollItem("dimensional anchor", 700));
						scrollByRarityMap.put(25, new ScrollItem("discern lies", 700));
						scrollByRarityMap.put(28, new ScrollItem("dismissal", 700));
						scrollByRarityMap.put(33, new ScrollItem("divine power", 700));
						scrollByRarityMap.put(39, new ScrollItem("flame strike", 700));
						scrollByRarityMap.put(43, new ScrollItem("freedom of movement", 700));
						scrollByRarityMap.put(46, new ScrollItem("holy smite", 700));
						scrollByRarityMap.put(51, new ScrollItem("inflict critical wounds", 700));
						scrollByRarityMap.put(56, new ScrollItem("greater magic weapon", 700));
						scrollByRarityMap.put(61, new ScrollItem("neutralize poison", 700));
						scrollByRarityMap.put(64, new ScrollItem("order's wrath", 700));
						scrollByRarityMap.put(68, new ScrollItem("poison", 700));
						scrollByRarityMap.put(73, new ScrollItem("spell immunity", 700));
						scrollByRarityMap.put(77, new ScrollItem("spike stones", 700));
						scrollByRarityMap.put(80, new ScrollItem("summon monster IV", 700));
						scrollByRarityMap.put(83, new ScrollItem("summon nature's ally IV", 700));
						scrollByRarityMap.put(86, new ScrollItem("tongues", 700));
						scrollByRarityMap.put(89, new ScrollItem("unholy blight", 700));
						scrollByRarityMap.put(93, new ScrollItem("divination", 725));
						scrollByRarityMap.put(96, new ScrollItem("lesser planar ally", 1200));
						scrollByRarityMap.put(100, new ScrollItem("restoration", 1700));
						break;
					case UNCOMMON_DIVINE:
						scrollByRarityMap.put(4, new ScrollItem("absorb toxicity", 700));
						scrollByRarityMap.put(6, new ScrollItem("antiplant shell", 700));
						scrollByRarityMap.put(11, new ScrollItem("aspect of the stag", 700));
						scrollByRarityMap.put(15, new ScrollItem("aura of doom", 700));
						scrollByRarityMap.put(21, new ScrollItem("ball lightning", 700));
						scrollByRarityMap.put(25, new ScrollItem("blessing of fervor", 700));
						scrollByRarityMap.put(28, new ScrollItem("blight", 700));
						scrollByRarityMap.put(31, new ScrollItem("command plants", 700));
						scrollByRarityMap.put(35, new ScrollItem("control water", 700));
						scrollByRarityMap.put(39, new ScrollItem("debilitating portent", 700));
						scrollByRarityMap.put(43, new ScrollItem("giant vermin", 700));
						scrollByRarityMap.put(49, new ScrollItem("ice storm", 700));
						scrollByRarityMap.put(55, new ScrollItem("imbue with spell ability", 700));
						scrollByRarityMap.put(59, new ScrollItem("plague carrier", 700));
						scrollByRarityMap.put(63, new ScrollItem("planar adaptation", 700));
						scrollByRarityMap.put(67, new ScrollItem("communal protection from energy", 700));
						scrollByRarityMap.put(72, new ScrollItem("reincarnate", 700)); //??huh??
						scrollByRarityMap.put(75, new ScrollItem("repel vermin", 700));
						scrollByRarityMap.put(78, new ScrollItem("rusting grasp", 700));
						scrollByRarityMap.put(83, new ScrollItem("scrying", 700));
						scrollByRarityMap.put(87, new ScrollItem("sending", 700));
						scrollByRarityMap.put(90, new ScrollItem("spiritual ally", 700));
						scrollByRarityMap.put(93, new ScrollItem("thorn body", 700));
						scrollByRarityMap.put(98, new ScrollItem("volcanic storm", 700));
						scrollByRarityMap.put(100, new ScrollItem("symbol of slowing", 1700));
						break;
					default:
						break;
				}
				break;
			case 5:
				switch (scrollRarity)
				{
					case COMMON_ARCANE:
						scrollByRarityMap.put(3, new ScrollItem("baleful polymorph", 1125));
						scrollByRarityMap.put(7, new ScrollItem("beast shape III", 1125));
						scrollByRarityMap.put(10, new ScrollItem("break enchantment", 1125));
						scrollByRarityMap.put(15, new ScrollItem("cloudkill", 1125));
						scrollByRarityMap.put(21, new ScrollItem("cone of cold", 1125));
						scrollByRarityMap.put(23, new ScrollItem("contact other plane", 1125));
						scrollByRarityMap.put(26, new ScrollItem("dismissal", 1125));
						scrollByRarityMap.put(31, new ScrollItem("dominate person", 1125));
						scrollByRarityMap.put(35, new ScrollItem("feeblemind", 1125));
						scrollByRarityMap.put(40, new ScrollItem("hold monster", 1125));
						scrollByRarityMap.put(43, new ScrollItem("magic jar", 1125));
						scrollByRarityMap.put(46, new ScrollItem("mind fog", 1125));
						scrollByRarityMap.put(51, new ScrollItem("overland flight", 1125));
						scrollByRarityMap.put(54, new ScrollItem("passwall", 1125));
						scrollByRarityMap.put(56, new ScrollItem("permanency", 1125));
						scrollByRarityMap.put(58, new ScrollItem("lesser planar binding", 1125));
						scrollByRarityMap.put(62, new ScrollItem("polymorph", 1125));
						scrollByRarityMap.put(65, new ScrollItem("sending", 1125));
						scrollByRarityMap.put(69, new ScrollItem("shadow evocation", 1125));
						scrollByRarityMap.put(73, new ScrollItem("summon monster V", 1125));
						scrollByRarityMap.put(76, new ScrollItem("telekinesis", 1125));
						scrollByRarityMap.put(82, new ScrollItem("teleport", 1125));
						scrollByRarityMap.put(88, new ScrollItem("wall of force", 1125));
						scrollByRarityMap.put(92, new ScrollItem("wall of stone", 1125));
						scrollByRarityMap.put(95, new ScrollItem("waves of fatigue", 1125));
						scrollByRarityMap.put(97, new ScrollItem("symbol of pain", 2125));
						scrollByRarityMap.put(100, new ScrollItem("symbol of sleep", 2125));
						break;
					case UNCOMMON_ARCANE:
						scrollByRarityMap.put(2, new ScrollItem("absorb toxicity", 1125));
						scrollByRarityMap.put(4, new ScrollItem("animal growth", 1125));
						scrollByRarityMap.put(6, new ScrollItem("blight", 1125));
						scrollByRarityMap.put(9, new ScrollItem("dream", 1125));
						scrollByRarityMap.put(13, new ScrollItem("elemental body II", 1125));
						scrollByRarityMap.put(15, new ScrollItem("fabricate", 1125));
						scrollByRarityMap.put(19, new ScrollItem("fire snake", 1125));
						scrollByRarityMap.put(22, new ScrollItem("hostile juxtaposition", 1125));
						scrollByRarityMap.put(25, new ScrollItem("hungry pit", 1125));
						scrollByRarityMap.put(29, new ScrollItem("icy prison", 1125));
						scrollByRarityMap.put(33, new ScrollItem("interposing hand", 1125));
						scrollByRarityMap.put(36, new ScrollItem("life bubble", 1125));
						scrollByRarityMap.put(38, new ScrollItem("mage's faithful hound", 1125));
						scrollByRarityMap.put(40, new ScrollItem("mage's private sanctum", 1125));
						scrollByRarityMap.put(43, new ScrollItem("major creation", 1125));
						scrollByRarityMap.put(46, new ScrollItem("mirage arcana", 1125));
						scrollByRarityMap.put(50, new ScrollItem("monstrous physique III", 1125));
						scrollByRarityMap.put(54, new ScrollItem("nightmare", 1125));
						scrollByRarityMap.put(56, new ScrollItem("persistent image", 1125));
						scrollByRarityMap.put(60, new ScrollItem("planar adaptation", 1125));
						scrollByRarityMap.put(64, new ScrollItem("plant shape I", 1125));
						scrollByRarityMap.put(68, new ScrollItem("prying eyes", 1125));
						scrollByRarityMap.put(70, new ScrollItem("secret chest", 1125));
						scrollByRarityMap.put(73, new ScrollItem("seeming", 1125));
						scrollByRarityMap.put(76, new ScrollItem("sonic thrust", 1125));
						scrollByRarityMap.put(79, new ScrollItem("suffocation", 1125));
						scrollByRarityMap.put(82, new ScrollItem("telepathic bond", 1125));
						scrollByRarityMap.put(84, new ScrollItem("transmute mud to rock", 1125));
						scrollByRarityMap.put(86, new ScrollItem("transmute rock to mud", 1125));
						scrollByRarityMap.put(90, new ScrollItem("undead anatomy II", 1125));
						scrollByRarityMap.put(94, new ScrollItem("vermin form II", 1125));
						scrollByRarityMap.put(98, new ScrollItem("wind blades", 1125));
						scrollByRarityMap.put(100, new ScrollItem("false vision", 1375));
						break;
					case COMMON_DIVINE:
						scrollByRarityMap.put(2, new ScrollItem("animal growth", 1125));
						scrollByRarityMap.put(4, new ScrollItem("atonement", 1125)); //??huh??
						scrollByRarityMap.put(7, new ScrollItem("baleful polymorph", 1125));
						scrollByRarityMap.put(11, new ScrollItem("break enchantment", 1125));
						scrollByRarityMap.put(16, new ScrollItem("breath of life", 1125));
						scrollByRarityMap.put(21, new ScrollItem("call lightning storm", 1125));
						scrollByRarityMap.put(25, new ScrollItem("greater command", 1125));
						scrollByRarityMap.put(30, new ScrollItem("mass cure light wounds", 1125));
						scrollByRarityMap.put(34, new ScrollItem("death ward", 1125));
						scrollByRarityMap.put(37, new ScrollItem("disrupting weapon", 1125));
						scrollByRarityMap.put(42, new ScrollItem("mass inflict light wounds", 1125));
						scrollByRarityMap.put(47, new ScrollItem("plane shift", 1125));
						scrollByRarityMap.put(53, new ScrollItem("righteous might", 1125));
						scrollByRarityMap.put(57, new ScrollItem("scrying", 1125)); //wrong, I think
						scrollByRarityMap.put(62, new ScrollItem("slay living", 1125));
						scrollByRarityMap.put(67, new ScrollItem("spell resistance", 1125));
						scrollByRarityMap.put(70, new ScrollItem("summon monster V", 1125));
						scrollByRarityMap.put(73, new ScrollItem("summon nature's ally V", 1125));
						scrollByRarityMap.put(75, new ScrollItem("tree stride", 1125));
						scrollByRarityMap.put(77, new ScrollItem("wall of fire", 1125));
						scrollByRarityMap.put(80, new ScrollItem("wall of stone", 1125));
						scrollByRarityMap.put(82, new ScrollItem("wall of thorns", 1125));
						scrollByRarityMap.put(87, new ScrollItem("true seeing", 1375));
						scrollByRarityMap.put(91, new ScrollItem("commune", 1625));
						scrollByRarityMap.put(94, new ScrollItem("awaken", 3125));
						scrollByRarityMap.put(100, new ScrollItem("raise dead", 6125));
						break;
					case UNCOMMON_DIVINE:
						scrollByRarityMap.put(3, new ScrollItem("communal air walk", 1125));
						scrollByRarityMap.put(8, new ScrollItem("aspect of the wolf", 1125)); //??huh??
						scrollByRarityMap.put(11, new ScrollItem("blessing of the salamander", 1125));
						scrollByRarityMap.put(15, new ScrollItem("cleanse", 1125));
						scrollByRarityMap.put(21, new ScrollItem("commune with nature", 1125));
						scrollByRarityMap.put(24, new ScrollItem("greater contagion", 1125));
						scrollByRarityMap.put(28, new ScrollItem("control winds", 1125));
						scrollByRarityMap.put(31, new ScrollItem("dispel chaos", 1125));
						scrollByRarityMap.put(34, new ScrollItem("dispel evil", 1125));
						scrollByRarityMap.put(37, new ScrollItem("dispel good", 1125));
						scrollByRarityMap.put(40, new ScrollItem("dispel law", 1125));
						scrollByRarityMap.put(43, new ScrollItem("fickle winds", 1125));
						scrollByRarityMap.put(46, new ScrollItem("greater forbid action", 1125));
						scrollByRarityMap.put(52, new ScrollItem("insect plague", 1125)); 
						scrollByRarityMap.put(55, new ScrollItem("life bubble", 1125));
						scrollByRarityMap.put(58, new ScrollItem("mark of justice", 1125));
						scrollByRarityMap.put(63, new ScrollItem("pillar of life", 1125));
						scrollByRarityMap.put(66, new ScrollItem("serenity", 1125));
						scrollByRarityMap.put(72, new ScrollItem("snake staff", 1125));
						scrollByRarityMap.put(76, new ScrollItem("communal spell immunity", 1125));
						scrollByRarityMap.put(79, new ScrollItem("transmute mud to rock", 1125));
						scrollByRarityMap.put(82, new ScrollItem("transmute rock to mud", 1125));
						scrollByRarityMap.put(86, new ScrollItem("wind blades", 1125));
						scrollByRarityMap.put(90, new ScrollItem("stoneskin", 1375));
						scrollByRarityMap.put(92, new ScrollItem("hallow", 2125));
						scrollByRarityMap.put(94, new ScrollItem("symbol of pain", 2125));
						scrollByRarityMap.put(96, new ScrollItem("symbol of sleep", 2175));
						scrollByRarityMap.put(98, new ScrollItem("unhallow", 2125));
						//TODO: come up with a way to tag a hallow with another legal spell
						scrollByRarityMap.put(99, new ScrollItem("hallow (w/4th lvl rider)", 6125));
						scrollByRarityMap.put(100, new ScrollItem("unhallow (w/4th lvl rider)", 6125));
						break;
					default:
						break;
				}
				break;
			case 6:
				switch (scrollRarity)
				{
					case COMMON_ARCANE:
						scrollByRarityMap.put(3, new ScrollItem("acid fog", 1650));
						scrollByRarityMap.put(7, new ScrollItem("antimagic field", 1650));
						scrollByRarityMap.put(10, new ScrollItem("mass bear's endurance", 1650));
						scrollByRarityMap.put(13, new ScrollItem("beast shape IV", 1650));
						scrollByRarityMap.put(16, new ScrollItem("mass bull's strength", 1650));
						scrollByRarityMap.put(19, new ScrollItem("mass cat's grace", 1650));
						scrollByRarityMap.put(25, new ScrollItem("chain lightning", 1650));
						scrollByRarityMap.put(31, new ScrollItem("disintigrate", 1650));
						scrollByRarityMap.put(37, new ScrollItem("greater dispel magic", 1650));
						scrollByRarityMap.put(40, new ScrollItem("mass eagle's splendor", 1650));
						scrollByRarityMap.put(42, new ScrollItem("eyebite", 1650));
						scrollByRarityMap.put(47, new ScrollItem("flesh to stone", 1650));
						scrollByRarityMap.put(50, new ScrollItem("form of the dragon I", 1650));
						scrollByRarityMap.put(53, new ScrollItem("mass fox's cunning", 1650));
						scrollByRarityMap.put(56, new ScrollItem("globe of invulnerability", 1650));
						scrollByRarityMap.put(59, new ScrollItem("greater heroism", 1650));
						scrollByRarityMap.put(62, new ScrollItem("mislead", 1650));
						scrollByRarityMap.put(65, new ScrollItem("mass owl's wisdom", 1650));
						scrollByRarityMap.put(67, new ScrollItem("planar binding", 1650));
						scrollByRarityMap.put(70, new ScrollItem("shadow walk", 1650));
						scrollByRarityMap.put(72, new ScrollItem("stone to flesh", 1650));
						scrollByRarityMap.put(76, new ScrollItem("mass suggestion", 1650));
						scrollByRarityMap.put(79, new ScrollItem("summon monster VI", 1650));
						scrollByRarityMap.put(82, new ScrollItem("transformation", 1650));
						scrollByRarityMap.put(84, new ScrollItem("veil", 1650));
						scrollByRarityMap.put(87, new ScrollItem("wall of iron", 1700));
						scrollByRarityMap.put(89, new ScrollItem("create undead", 1750));
						scrollByRarityMap.put(92, new ScrollItem("legend lore", 1900));
						scrollByRarityMap.put(96, new ScrollItem("true seeing", 1900));
						scrollByRarityMap.put(98, new ScrollItem("circle of death", 2150));
						scrollByRarityMap.put(100, new ScrollItem("symbol of fear", 2650));
						break;
					case UNCOMMON_ARCANE:
						scrollByRarityMap.put(4, new ScrollItem("analyze dweomer", 1650));
						scrollByRarityMap.put(8, new ScrollItem("battlemind link", 1650));
						scrollByRarityMap.put(12, new ScrollItem("cloak of dreams", 1650));
						scrollByRarityMap.put(15, new ScrollItem("greater contagion", 1650));
						scrollByRarityMap.put(20, new ScrollItem("contagious flame", 1650));
						scrollByRarityMap.put(26, new ScrollItem("contingency", 1650));
						scrollByRarityMap.put(30, new ScrollItem("control water", 1650));
						scrollByRarityMap.put(35, new ScrollItem("elemental body III", 1650));
						scrollByRarityMap.put(39, new ScrollItem("fluid form", 1650));
						scrollByRarityMap.put(45, new ScrollItem("forceful hand", 1650));
						scrollByRarityMap.put(48, new ScrollItem("freezing sphere", 1650));
						scrollByRarityMap.put(53, new ScrollItem("geas/quest", 1650));
						scrollByRarityMap.put(57, new ScrollItem("getaway", 1650));
						scrollByRarityMap.put(59, new ScrollItem("guards and wards", 1650));
						scrollByRarityMap.put(61, new ScrollItem("mage's lucubration", 1650));
						scrollByRarityMap.put(66, new ScrollItem("monstrous physique IV", 1650));
						scrollByRarityMap.put(68, new ScrollItem("move earth", 1650));
						scrollByRarityMap.put(71, new ScrollItem("permanent image", 1650));
						scrollByRarityMap.put(76, new ScrollItem("plant shape II", 1650));
						scrollByRarityMap.put(80, new ScrollItem("repulsion", 1650));
						scrollByRarityMap.put(84, new ScrollItem("sirocco", 1650));
						scrollByRarityMap.put(87, new ScrollItem("tar pool", 1650));
						scrollByRarityMap.put(92, new ScrollItem("undead anatomy III", 1650));
						scrollByRarityMap.put(95, new ScrollItem("programmed image", 1675));
						scrollByRarityMap.put(98, new ScrollItem("undeath to death", 2150));
						scrollByRarityMap.put(100, new ScrollItem("symbol of persuasion", 6650));
						break;
					case COMMON_DIVINE:
						scrollByRarityMap.put(5, new ScrollItem("mass bear's endurance", 1650));
						scrollByRarityMap.put(11, new ScrollItem("blade barrier", 1650));
						scrollByRarityMap.put(16, new ScrollItem("mass bull's strength", 1650));
						scrollByRarityMap.put(21, new ScrollItem("mass cat's grace", 1650));
						scrollByRarityMap.put(27, new ScrollItem("mass cure moderate wounds", 1650));
						scrollByRarityMap.put(32, new ScrollItem("greater dispel magic", 1650));
						scrollByRarityMap.put(37, new ScrollItem("mass eagle's splendor", 1650));
						scrollByRarityMap.put(43, new ScrollItem("find the path", 1650));
						scrollByRarityMap.put(47, new ScrollItem("fire seeds", 1650));
						scrollByRarityMap.put(55, new ScrollItem("harm", 1650));
						scrollByRarityMap.put(63, new ScrollItem("heal", 1650));
						scrollByRarityMap.put(69, new ScrollItem("heroes' feast", 1650));
						scrollByRarityMap.put(74, new ScrollItem("mass inflict moderate wounds", 1650));
						scrollByRarityMap.put(78, new ScrollItem("liveoak", 1650));
						scrollByRarityMap.put(83, new ScrollItem("mass owl's wisdom", 1650));
						scrollByRarityMap.put(87, new ScrollItem("summon monster VI", 1650));
						scrollByRarityMap.put(91, new ScrollItem("summon nature's ally VI", 1650));
						scrollByRarityMap.put(96, new ScrollItem("word of recall", 1650));
						scrollByRarityMap.put(100, new ScrollItem("planar ally", 2900));
						break;
					case UNCOMMON_DIVINE:
						scrollByRarityMap.put(5, new ScrollItem("animate objects", 1650));
						scrollByRarityMap.put(9, new ScrollItem("antilife shell", 1650));
						scrollByRarityMap.put(15, new ScrollItem("banishment", 1650));
						scrollByRarityMap.put(19, new ScrollItem("cold ice strike", 1650));
						scrollByRarityMap.put(23, new ScrollItem("dust form", 1650));
						scrollByRarityMap.put(29, new ScrollItem("geas/quest", 1650));
						scrollByRarityMap.put(33, new ScrollItem("ironwood", 1650));
						scrollByRarityMap.put(37, new ScrollItem("joyful rapture", 1650));
						scrollByRarityMap.put(42, new ScrollItem("move earth", 1650));
						scrollByRarityMap.put(46, new ScrollItem("plague storm", 1650));
						scrollByRarityMap.put(51, new ScrollItem("mass planar adaptation", 1650));
						scrollByRarityMap.put(54, new ScrollItem("repel wood", 1650));
						scrollByRarityMap.put(59, new ScrollItem("sirocco", 1650));
						scrollByRarityMap.put(63, new ScrollItem("spellstaff", 1650));
						scrollByRarityMap.put(67, new ScrollItem("stone tell", 1650));
						scrollByRarityMap.put(70, new ScrollItem("swarm skin", 1650));
						scrollByRarityMap.put(74, new ScrollItem("tar pool", 1650));
						scrollByRarityMap.put(77, new ScrollItem("transport via plants", 1650));
						scrollByRarityMap.put(83, new ScrollItem("wind walk", 1650));
						scrollByRarityMap.put(86, new ScrollItem("create undead", 1750));
						scrollByRarityMap.put(90, new ScrollItem("greater glyph of warding", 2050));
						scrollByRarityMap.put(92, new ScrollItem("undeath to death", 2150));
						scrollByRarityMap.put(95, new ScrollItem("symbol of fear", 2650));
						scrollByRarityMap.put(98, new ScrollItem("forbiddance", 4650));
						scrollByRarityMap.put(100, new ScrollItem("symbol of persuasion", 6650));
						break;
					default:
						break;
				}
				break;
			case 7:
				switch (scrollRarity)
				{
					case COMMON_ARCANE:
						scrollByRarityMap.put(4, new ScrollItem("greater arcane sight", 2275));
						scrollByRarityMap.put(7, new ScrollItem("banishment", 2275));
						scrollByRarityMap.put(13, new ScrollItem("delayed blast fireball", 2275));
						scrollByRarityMap.put(17, new ScrollItem("ethereal jaunt", 2275));
						scrollByRarityMap.put(22, new ScrollItem("finger of death", 2275));
						scrollByRarityMap.put(27, new ScrollItem("form of the dragon II", 2275));
						scrollByRarityMap.put(30, new ScrollItem("mass hold person", 2275));
						scrollByRarityMap.put(35, new ScrollItem("mass invisibility", 2275));
						scrollByRarityMap.put(39, new ScrollItem("mage's sword", 2275));
						scrollByRarityMap.put(42, new ScrollItem("phase door", 2275));
						scrollByRarityMap.put(48, new ScrollItem("plane shift", 2275));
						scrollByRarityMap.put(53, new ScrollItem("greater polymorph", 2275));
						scrollByRarityMap.put(57, new ScrollItem("power word blind", 2275));
						scrollByRarityMap.put(62, new ScrollItem("prismatic spray", 2275));
						scrollByRarityMap.put(66, new ScrollItem("reverse gravity", 2275));
						scrollByRarityMap.put(70, new ScrollItem("greater scrying", 2275));
						scrollByRarityMap.put(73, new ScrollItem("greater shadow conjuration", 2275));
						scrollByRarityMap.put(78, new ScrollItem("spell turning", 2275));
						scrollByRarityMap.put(81, new ScrollItem("summon monster VII", 2275));
						scrollByRarityMap.put(87, new ScrollItem("greater teleport", 2275));
						scrollByRarityMap.put(90, new ScrollItem("waves of exhaustion", 2275));
						scrollByRarityMap.put(93, new ScrollItem("project image", 2280));
						scrollByRarityMap.put(97, new ScrollItem("forcecage", 2775));
						scrollByRarityMap.put(100, new ScrollItem("limited wish", 3775));
						break;
					case UNCOMMON_ARCANE:
						scrollByRarityMap.put(3, new ScrollItem("control undead", 2275));
						scrollByRarityMap.put(7, new ScrollItem("control weather", 2275));
						scrollByRarityMap.put(10, new ScrollItem("lesser create demiplane", 2275));
						scrollByRarityMap.put(14, new ScrollItem("deflection", 2275));
						scrollByRarityMap.put(19, new ScrollItem("elemental body IV", 2275));
						scrollByRarityMap.put(23, new ScrollItem("firebrand", 2275));
						scrollByRarityMap.put(29, new ScrollItem("mass fly", 2275));
						scrollByRarityMap.put(34, new ScrollItem("giant form I", 2275));
						scrollByRarityMap.put(40, new ScrollItem("grasping hand", 2275));
						scrollByRarityMap.put(44, new ScrollItem("greater hostile juxtaposition", 2275));
						scrollByRarityMap.put(49, new ScrollItem("ice body", 2275));
						scrollByRarityMap.put(53, new ScrollItem("insanity", 2275));
						scrollByRarityMap.put(56, new ScrollItem("mage's magnificent mansion", 2275));
						scrollByRarityMap.put(61, new ScrollItem("phantasmal revenge", 2275));
						scrollByRarityMap.put(65, new ScrollItem("plague storm", 2275));
						scrollByRarityMap.put(70, new ScrollItem("plant shape III", 2275));
						scrollByRarityMap.put(74, new ScrollItem("resonating word", 2275));
						scrollByRarityMap.put(78, new ScrollItem("sequester", 2275));
						scrollByRarityMap.put(81, new ScrollItem("statue", 2275));
						scrollByRarityMap.put(84, new ScrollItem("teleport object", 2275));
						scrollByRarityMap.put(88, new ScrollItem("walk through space", 2275));
						scrollByRarityMap.put(91, new ScrollItem("vision", 2525));
						scrollByRarityMap.put(93, new ScrollItem("instant summons", 3275));
						scrollByRarityMap.put(96, new ScrollItem("symbol of stunning", 7275));
						scrollByRarityMap.put(98, new ScrollItem("symbol of weakness", 7275));
						scrollByRarityMap.put(100, new ScrollItem("simulacrum", 8775));
						break;
					case COMMON_DIVINE:
						scrollByRarityMap.put(4, new ScrollItem("blasphemy", 2275));
						scrollByRarityMap.put(10, new ScrollItem("control weather", 2275));
						scrollByRarityMap.put(17, new ScrollItem("creeping doom", 2275));
						scrollByRarityMap.put(24, new ScrollItem("mass cure serious wounds", 2275));
						scrollByRarityMap.put(28, new ScrollItem("dictum", 2275));
						scrollByRarityMap.put(33, new ScrollItem("ethereal jaunt", 2275));
						scrollByRarityMap.put(40, new ScrollItem("fire storm", 2275));
						scrollByRarityMap.put(44, new ScrollItem("holy word", 2275));
						scrollByRarityMap.put(50, new ScrollItem("mass inflict serious wounds", 2275));
						scrollByRarityMap.put(55, new ScrollItem("regenerate", 2275));
						scrollByRarityMap.put(60, new ScrollItem("repulsion", 2275));
						scrollByRarityMap.put(65, new ScrollItem("greater scrying", 2275));
						scrollByRarityMap.put(69, new ScrollItem("summon monster VII", 2275));
						scrollByRarityMap.put(73, new ScrollItem("summon nature's ally VII", 2275));
						scrollByRarityMap.put(78, new ScrollItem("sunbeam", 2275));
						scrollByRarityMap.put(82, new ScrollItem("word of chaos", 2275));
						scrollByRarityMap.put(89, new ScrollItem("destruction", 2775));
						scrollByRarityMap.put(94, new ScrollItem("greater restoration", 7275));
						scrollByRarityMap.put(100, new ScrollItem("resurrection", 12275));
						break;
					case UNCOMMON_DIVINE:
						scrollByRarityMap.put(8, new ScrollItem("animate plants", 2275));
						scrollByRarityMap.put(17, new ScrollItem("changestaff", 2275));
						scrollByRarityMap.put(24, new ScrollItem("circle of clarity", 2275));
						scrollByRarityMap.put(30, new ScrollItem("lesser create demiplane", 2275));
						scrollByRarityMap.put(38, new ScrollItem("jolting portent", 2275));
						scrollByRarityMap.put(45, new ScrollItem("rampart", 2275));
						scrollByRarityMap.put(53, new ScrollItem("scouring winds", 2275));
						scrollByRarityMap.put(60, new ScrollItem("siege of trees", 2275));
						scrollByRarityMap.put(67, new ScrollItem("transmute metal to wood", 2275));
						scrollByRarityMap.put(76, new ScrollItem("vortex", 2275));
						scrollByRarityMap.put(83, new ScrollItem("waves of ecstasy", 2275));
						scrollByRarityMap.put(89, new ScrollItem("refuge", 3775));
						scrollByRarityMap.put(95, new ScrollItem("symbol of stunning", 7275));
						scrollByRarityMap.put(100, new ScrollItem("symbol of weakness", 7275));
						break;
					default:
						break;
				}
				break;
			case 8:
				switch (scrollRarity)
				{
					case COMMON_ARCANE:
						scrollByRarityMap.put(5, new ScrollItem("mass charm monster", 3000));
						scrollByRarityMap.put(9, new ScrollItem("demand", 3000));
						scrollByRarityMap.put(13, new ScrollItem("dimensional lock", 3000));
						scrollByRarityMap.put(18, new ScrollItem("form of the dragon III", 3000));
						scrollByRarityMap.put(23, new ScrollItem("horrid wilting", 3000));
						scrollByRarityMap.put(28, new ScrollItem("incendiary cloud", 3000));
						scrollByRarityMap.put(33, new ScrollItem("irresistible dance", 3000));
						scrollByRarityMap.put(40, new ScrollItem("maze", 3000));
						scrollByRarityMap.put(45, new ScrollItem("mind blank", 3000));
						scrollByRarityMap.put(49, new ScrollItem("greater planar binding", 3000));
						scrollByRarityMap.put(55, new ScrollItem("polar ray", 3000));
						scrollByRarityMap.put(59, new ScrollItem("polymorph any object", 3000));
						scrollByRarityMap.put(66, new ScrollItem("power word stun", 3000));
						scrollByRarityMap.put(72, new ScrollItem("prismatic wall", 3000));
						scrollByRarityMap.put(76, new ScrollItem("scintillating pattern", 3000));
						scrollByRarityMap.put(80, new ScrollItem("summon monster VIII", 3000));
						scrollByRarityMap.put(85, new ScrollItem("telekinetic sphere", 3000));
						scrollByRarityMap.put(90, new ScrollItem("protection from spells", 3500));
						scrollByRarityMap.put(94, new ScrollItem("symbol of death", 8000));
						scrollByRarityMap.put(97, new ScrollItem("temporal stasis", 8000));
						scrollByRarityMap.put(100, new ScrollItem("trap the soul", 23000));
						break;
					case UNCOMMON_ARCANE:
						scrollByRarityMap.put(4, new ScrollItem("antipathy", 3000));
						scrollByRarityMap.put(10, new ScrollItem("clenched fist", 3000));
						scrollByRarityMap.put(12, new ScrollItem("clone", 3000));
						scrollByRarityMap.put(15, new ScrollItem("create demiplane", 3000));
						scrollByRarityMap.put(19, new ScrollItem("discern location", 3000));
						scrollByRarityMap.put(24, new ScrollItem("euphoric tranquility", 3000));
						scrollByRarityMap.put(29, new ScrollItem("frightful aspect", 3000));
						scrollByRarityMap.put(34, new ScrollItem("giant form II", 3000));
						scrollByRarityMap.put(38, new ScrollItem("iron body", 3000));
						scrollByRarityMap.put(43, new ScrollItem("moment of prescience", 3000));
						scrollByRarityMap.put(47, new ScrollItem("orb of the void", 3000));
						scrollByRarityMap.put(52, new ScrollItem("greater prying eyes", 3000));
						scrollByRarityMap.put(56, new ScrollItem("screen", 3000));
						scrollByRarityMap.put(62, new ScrollItem("greater shadow evocation", 3000));
						scrollByRarityMap.put(66, new ScrollItem("greater shout", 3000));
						scrollByRarityMap.put(72, new ScrollItem("stormbolts", 3000));
						scrollByRarityMap.put(76, new ScrollItem("sunburst", 3000));
						scrollByRarityMap.put(81, new ScrollItem("undead anatomy IV", 3000));
						scrollByRarityMap.put(87, new ScrollItem("wall of lava", 3000));
						scrollByRarityMap.put(91, new ScrollItem("create greater undead", 3150));
						scrollByRarityMap.put(95, new ScrollItem("sympathy", 4500));
						scrollByRarityMap.put(98, new ScrollItem("symbol of insanity", 8000));
						scrollByRarityMap.put(100, new ScrollItem("binding (chaining)", 13000));
						break;
					case COMMON_DIVINE:
						scrollByRarityMap.put(8, new ScrollItem("antimagic field", 3000));
						scrollByRarityMap.put(14, new ScrollItem("cloak of chaos", 3000));
						scrollByRarityMap.put(23, new ScrollItem("mass cure critical wounds", 3000));
						scrollByRarityMap.put(31, new ScrollItem("earthquake", 3000));
						scrollByRarityMap.put(38, new ScrollItem("finger of death", 3000));
						scrollByRarityMap.put(44, new ScrollItem("holy aura", 3000));
						scrollByRarityMap.put(51, new ScrollItem("mass inflict critical wounds", 3000));
						scrollByRarityMap.put(59, new ScrollItem("reverse gravity", 3000));
						scrollByRarityMap.put(65, new ScrollItem("shield of law", 3000));
						scrollByRarityMap.put(73, new ScrollItem("greater spell immunity", 3000));
						scrollByRarityMap.put(78, new ScrollItem("summon monster VIII", 3000));
						scrollByRarityMap.put(83, new ScrollItem("summon nature's ally VIII", 3000));
						scrollByRarityMap.put(89, new ScrollItem("sunburst", 3000));
						scrollByRarityMap.put(95, new ScrollItem("unholy aura", 3000));
						scrollByRarityMap.put(100, new ScrollItem("greater planar ally", 5500));
						break;
					case UNCOMMON_DIVINE:
						scrollByRarityMap.put(7, new ScrollItem("animal shapes", 3000));
						scrollByRarityMap.put(13, new ScrollItem("blood mist", 3000));
						scrollByRarityMap.put(18, new ScrollItem("control plants", 3000));
						scrollByRarityMap.put(24, new ScrollItem("create demiplane", 3000));
						scrollByRarityMap.put(31, new ScrollItem("dimensional lock", 3000));
						scrollByRarityMap.put(37, new ScrollItem("discern location", 3000));
						scrollByRarityMap.put(42, new ScrollItem("euphoric tranquility", 3000));
						scrollByRarityMap.put(49, new ScrollItem("frightful aspect", 3000));
						scrollByRarityMap.put(56, new ScrollItem("orb of the void", 3000));
						scrollByRarityMap.put(61, new ScrollItem("repel metal or stone", 3000));
						scrollByRarityMap.put(68, new ScrollItem("seamantle", 3000));
						scrollByRarityMap.put(75, new ScrollItem("storm bolts", 3000));
						scrollByRarityMap.put(83, new ScrollItem("whirlwind", 3000));
						scrollByRarityMap.put(88, new ScrollItem("create greater undead", 3150));
						scrollByRarityMap.put(95, new ScrollItem("symbol of death", 8000));
						scrollByRarityMap.put(100, new ScrollItem("symbol of insanity", 8000));
						break;
					default:
						break;
				}
				break;
			case 9:
				switch (scrollRarity)
				{
					case COMMON_ARCANE:
						scrollByRarityMap.put(6, new ScrollItem("dominate monster", 3825));
						scrollByRarityMap.put(11, new ScrollItem("energy drain", 3825));
						scrollByRarityMap.put(16, new ScrollItem("freedom", 3825));
						scrollByRarityMap.put(23, new ScrollItem("gate", 3825));
						scrollByRarityMap.put(28, new ScrollItem("mass hold monster", 3825));
						scrollByRarityMap.put(33, new ScrollItem("imprisonment", 3825));
						scrollByRarityMap.put(39, new ScrollItem("mage's disjunction", 3825));
						scrollByRarityMap.put(47, new ScrollItem("meteor swarm", 3825));
						scrollByRarityMap.put(55, new ScrollItem("power word kill", 3825));
						scrollByRarityMap.put(61, new ScrollItem("prismatic sphere", 3825));
						scrollByRarityMap.put(66, new ScrollItem("shapechange", 3825));
						scrollByRarityMap.put(71, new ScrollItem("summon monster IX", 3825));
						scrollByRarityMap.put(79, new ScrollItem("time stop", 3825));
						scrollByRarityMap.put(85, new ScrollItem("weird", 3825));
						scrollByRarityMap.put(90, new ScrollItem("astral projection", 4825));
						scrollByRarityMap.put(96, new ScrollItem("teleportation circle", 4825));
						scrollByRarityMap.put(100, new ScrollItem("wish", 28825));
						break;
					case UNCOMMON_ARCANE:
						scrollByRarityMap.put(6, new ScrollItem("greater create demiplane", 3825));
						scrollByRarityMap.put(15, new ScrollItem("crushing hand", 3825));
						scrollByRarityMap.put(23, new ScrollItem("etherealness", 3825));
						scrollByRarityMap.put(31, new ScrollItem("fiery body", 3825));
						scrollByRarityMap.put(38, new ScrollItem("foresight", 3825));
						scrollByRarityMap.put(44, new ScrollItem("heroic invocation", 3825));
						scrollByRarityMap.put(50, new ScrollItem("mass icy prison", 3825));
						scrollByRarityMap.put(57, new ScrollItem("ride the lightning", 3825));
						scrollByRarityMap.put(65, new ScrollItem("shades", 3825));
						scrollByRarityMap.put(72, new ScrollItem("soul bind", 3825));
						scrollByRarityMap.put(79, new ScrollItem("tsunami", 3825));
						scrollByRarityMap.put(88, new ScrollItem("wail of the banshee", 3825));
						scrollByRarityMap.put(95, new ScrollItem("winds of vengeance", 3825));
						scrollByRarityMap.put(100, new ScrollItem("refuge", 4325));
						break;
					case COMMON_DIVINE:
						scrollByRarityMap.put(7, new ScrollItem("elemental swarm", 3825));
						scrollByRarityMap.put(15, new ScrollItem("energy drain", 3825));
						scrollByRarityMap.put(22, new ScrollItem("etherealness", 3825));
						scrollByRarityMap.put(30, new ScrollItem("gate", 3825));
						scrollByRarityMap.put(40, new ScrollItem("mass heal", 3825));
						scrollByRarityMap.put(48, new ScrollItem("implosion", 3825));
						scrollByRarityMap.put(58, new ScrollItem("miracle", 3825));
						scrollByRarityMap.put(65, new ScrollItem("shambler", 3825));
						scrollByRarityMap.put(73, new ScrollItem("shapechange", 3825));
						scrollByRarityMap.put(81, new ScrollItem("storm of vengeance", 3825));
						scrollByRarityMap.put(87, new ScrollItem("summon monster IX", 3825));
						scrollByRarityMap.put(93, new ScrollItem("summon nature's ally IX", 3825));
						scrollByRarityMap.put(100, new ScrollItem("true resurrection", 28825));
						break;
					case UNCOMMON_DIVINE:
						scrollByRarityMap.put(8, new ScrollItem("antipathy", 3825));
						scrollByRarityMap.put(15, new ScrollItem("clashing rocks", 3825));
						scrollByRarityMap.put(22, new ScrollItem("greater create demiplane", 3825));
						scrollByRarityMap.put(31, new ScrollItem("foresight", 3825));
						scrollByRarityMap.put(39, new ScrollItem("overwhelming presence", 3825));
						scrollByRarityMap.put(47, new ScrollItem("polar midnight", 3825));
						scrollByRarityMap.put(56, new ScrollItem("soul bind", 3825));
						scrollByRarityMap.put(64, new ScrollItem("communal greater spell immunity", 3825));
						scrollByRarityMap.put(71, new ScrollItem("summon froghemoth", 3825));
						scrollByRarityMap.put(80, new ScrollItem("winds of vengeance", 3825));
						scrollByRarityMap.put(87, new ScrollItem("world wave", 3825));
						scrollByRarityMap.put(94, new ScrollItem("astral projection", 4825));
						scrollByRarityMap.put(100, new ScrollItem("sympathy", 5325));
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}

	private void generateScrollRarity() 
	{
		if (scrollRarityMap == null)
		{
			scrollRarityMap = new LinkedHashMap<Integer, ScrollRarity>();
			scrollRarityMap.put(45, ScrollRarity.COMMON_ARCANE);
			scrollRarityMap.put(60, ScrollRarity.UNCOMMON_ARCANE);
			scrollRarityMap.put(90, ScrollRarity.COMMON_DIVINE);
			scrollRarityMap.put(100, ScrollRarity.UNCOMMON_DIVINE);
		}
		this.scrollRarity = ItemsForSale.getRandomThing(scrollRarityMap);
	}

	@Override
	public Item copyItem() 
	{
		ScrollItem itemCopy = new ScrollItem(this.scrollLevel);
		return itemCopy;		
	}
}
