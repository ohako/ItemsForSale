package com.ohako.itemcategory.wondrousitems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ohako.Item;
import com.ohako.ItemsForSale;
import com.ohako.itemdegree.ItemDegree;
import com.ohako.itemdegree.ItemDegreeQualifier;

public class WondrousSlotlessItem extends WondrousItem {

	private static Map<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousSlotlessItem>>> specificSlotlessMap;
	private static Map<ItemDegree, Map<Integer, ItemDegreeQualifier>> degreeQualifierMap;

	public WondrousSlotlessItem(ItemDegree itemDegree) {
		super(itemDegree, null);
	}
	
	public WondrousSlotlessItem(String itemName, int itemPrice)
	{
		super(itemName, itemPrice);
	}

	@Override
	public void generateItem() {
		if (specificSlotlessMap == null)
			specificSlotlessMap = new HashMap<ItemDegree, Map<ItemDegreeQualifier, Map<Integer, WondrousSlotlessItem>>>();
		Map<ItemDegreeQualifier, Map<Integer, WondrousSlotlessItem>> specificSlotlessMapByDegree = specificSlotlessMap.get(itemDegree);
		if (specificSlotlessMapByDegree == null)
		{
			specificSlotlessMapByDegree = new HashMap<ItemDegreeQualifier, Map<Integer,WondrousSlotlessItem>>();
			specificSlotlessMap.put(itemDegree, specificSlotlessMapByDegree);
		}
		Map<Integer, WondrousSlotlessItem> specificSlotlessMapByDegreeAndQualifier = specificSlotlessMapByDegree.get(itemDegreeQualifier);
		if (specificSlotlessMapByDegreeAndQualifier == null)
		{
			specificSlotlessMapByDegreeAndQualifier = new LinkedHashMap<Integer, WondrousSlotlessItem>();
			populateSpecificSlotlessMap(specificSlotlessMapByDegreeAndQualifier, itemDegree, itemDegreeQualifier);
			specificSlotlessMapByDegree.put(itemDegreeQualifier, specificSlotlessMapByDegreeAndQualifier);
		}
		WondrousSlotlessItem slotlessItem = ItemsForSale.getRandomThing(specificSlotlessMapByDegreeAndQualifier);
		this.itemName = slotlessItem.itemName();
		this.itemPrice = slotlessItem.itemPrice();
		this.leafItem = true;
	}

	private void populateSpecificSlotlessMap(
			Map<Integer, WondrousSlotlessItem> slotlessMap,
			ItemDegree itemDegree, ItemDegreeQualifier itemDegreeQualifier) {
		switch (itemDegree)
		{
			case MINOR:
				switch (itemDegreeQualifier)
				{
					case LEAST:
						slotlessMap.put(1, new WondrousSlotlessItem("feather token (anchor)", 50));
						slotlessMap.put(2, new WondrousSlotlessItem("universal solvent", 50));
						slotlessMap.put(4, new WondrousSlotlessItem("ioun torch", 75));
						slotlessMap.put(5, new WondrousSlotlessItem("stubborn nail", 100));
						slotlessMap.put(6, new WondrousSlotlessItem("war paint of the terrible visage", 100));
						slotlessMap.put(7, new WondrousSlotlessItem("elixir of love", 150));
						slotlessMap.put(8, new WondrousSlotlessItem("unguent of timelessness", 150));
						slotlessMap.put(9, new WondrousSlotlessItem("feather token (fan)", 200));
						slotlessMap.put(10, new WondrousSlotlessItem("formula alembic", 200));
						slotlessMap.put(11, new WondrousSlotlessItem("hybridization funnel", 200));
						slotlessMap.put(12, new WondrousSlotlessItem("soul soap", 200));
						slotlessMap.put(13, new WondrousSlotlessItem("dust of tracelessness", 250));
						slotlessMap.put(16, new WondrousSlotlessItem("elixir of hiding", 250));
						slotlessMap.put(19, new WondrousSlotlessItem("elixir of swimming", 250));
						slotlessMap.put(22, new WondrousSlotlessItem("elixir of tumbling", 250));
						slotlessMap.put(25, new WondrousSlotlessItem("elixir of vision", 250));
						slotlessMap.put(27, new WondrousSlotlessItem("nightdrops", 250));
						slotlessMap.put(28, new WondrousSlotlessItem("oil of silence", 250));
						slotlessMap.put(31, new WondrousSlotlessItem("silversheen", 250));
						slotlessMap.put(32, new WondrousSlotlessItem("traveler's any-tool", 250));
						slotlessMap.put(34, new WondrousSlotlessItem("bottle of messages", 300));
						slotlessMap.put(36, new WondrousSlotlessItem("feather token (bird)", 300));
						slotlessMap.put(37, new WondrousSlotlessItem("origami swarm", 300));
						slotlessMap.put(38, new WondrousSlotlessItem("alluring golden apple", 400));
						slotlessMap.put(39, new WondrousSlotlessItem("feather token (tree)", 400));
						slotlessMap.put(40, new WondrousSlotlessItem("key of lock jamming", 400));
						slotlessMap.put(42, new WondrousSlotlessItem("feather token (swan boat)", 450));
						slotlessMap.put(43, new WondrousSlotlessItem("animated portrait", 500));
						slotlessMap.put(44, new WondrousSlotlessItem("bottled misfortune", 500));
						slotlessMap.put(46, new WondrousSlotlessItem("elixir of truth", 500));
						slotlessMap.put(48, new WondrousSlotlessItem("feather token (whip)", 500));
						slotlessMap.put(51, new WondrousSlotlessItem("scabbard of honing", 500));
						slotlessMap.put(53, new WondrousSlotlessItem("seer's tea", 550));
						slotlessMap.put(57, new WondrousSlotlessItem("abjurant salt", 600));
						slotlessMap.put(61, new WondrousSlotlessItem("arrow magnet", 600));
						slotlessMap.put(63, new WondrousSlotlessItem("dust of darkness", 600));
						slotlessMap.put(69, new WondrousSlotlessItem("campfire bead", 720));
						slotlessMap.put(72, new WondrousSlotlessItem("archon's torch", 750));
						slotlessMap.put(75, new WondrousSlotlessItem("lesser book of extended summoning", 750));
						slotlessMap.put(79, new WondrousSlotlessItem("iron rope", 750));
						slotlessMap.put(83, new WondrousSlotlessItem("snapleaf", 750));
						slotlessMap.put(86, new WondrousSlotlessItem("bottled yeti fur", 800));
						slotlessMap.put(89, new WondrousSlotlessItem("defoliant polish", 800));
						slotlessMap.put(92, new WondrousSlotlessItem("dust of emulation", 800));
						slotlessMap.put(97, new WondrousSlotlessItem("steadfast gut-stone", 800));
						slotlessMap.put(100, new WondrousSlotlessItem("dust of dryness", 850));
						break;
					case LESSER: //TODO what the FF!! roll on the least minor table!?
						slotlessMap.put(3, new WondrousSlotlessItem("some least minor item", 0));
						slotlessMap.put(4, new WondrousSlotlessItem("anatomy doll", 1000));
						slotlessMap.put(5, new WondrousSlotlessItem("bead of newt prevention", 1000));
						slotlessMap.put(6, new WondrousSlotlessItem("beast-bond brand", 1000));
						slotlessMap.put(7, new WondrousSlotlessItem("bookplate of recall", 1000));
						slotlessMap.put(9, new WondrousSlotlessItem("boro bead (1st)", 1000));
						slotlessMap.put(10, new WondrousSlotlessItem("concealing pocket", 1000));
						slotlessMap.put(11, new WondrousSlotlessItem("dowsing syrup", 1000));
						slotlessMap.put(12, new WondrousSlotlessItem("incense of transcendence", 1000));
						slotlessMap.put(14, new WondrousSlotlessItem("page of spell knowledge (1st)", 1000));
						slotlessMap.put(17, new WondrousSlotlessItem("pearl of power (1st)", 1000));
						slotlessMap.put(18, new WondrousSlotlessItem("preserving flask (1st)", 1000));
						slotlessMap.put(20, new WondrousSlotlessItem("pyres of redirected focus", 1000));
						slotlessMap.put(22, new WondrousSlotlessItem("salve of slipperiness", 1000));
						slotlessMap.put(23, new WondrousSlotlessItem("wasp nest of swarming", 1000));
						slotlessMap.put(26, new WondrousSlotlessItem("elixir of fire breath", 1100));
						slotlessMap.put(27, new WondrousSlotlessItem("grave salt", 1100));
						slotlessMap.put(29, new WondrousSlotlessItem("pipes of the sewers", 1150));
						slotlessMap.put(31, new WondrousSlotlessItem("dust of illusion", 1200));
						slotlessMap.put(33, new WondrousSlotlessItem("goblin skull bomb", 1200));
						slotlessMap.put(35, new WondrousSlotlessItem("elixir of dragon breath", 1400));
						slotlessMap.put(36, new WondrousSlotlessItem("bookmark of deception", 1500));
						slotlessMap.put(37, new WondrousSlotlessItem("word bottle", 1500));
						slotlessMap.put(38, new WondrousSlotlessItem("dust of acid consumption", 1600));
						slotlessMap.put(40, new WondrousSlotlessItem("dust of appearance", 1800));
						slotlessMap.put(42, new WondrousSlotlessItem("efficient quiver", 1800));
						slotlessMap.put(43, new WondrousSlotlessItem("pipes of sounding", 1800));
						slotlessMap.put(44, new WondrousSlotlessItem("scabbard of vigor", 1800));
						slotlessMap.put(45, new WondrousSlotlessItem("agile aplenstock", 2000));
						slotlessMap.put(46, new WondrousSlotlessItem("blood reservoir of physical prowess", 2000));
						slotlessMap.put(47, new WondrousSlotlessItem("clamor box", 2000));
						slotlessMap.put(48, new WondrousSlotlessItem("dry load powder horn", 2000));
						slotlessMap.put(49, new WondrousSlotlessItem("normal goblin fire drum", 2000));
						slotlessMap.put(51, new WondrousSlotlessItem("handy haversack", 2000));
						slotlessMap.put(53, new WondrousSlotlessItem("horn of fog", 2000));
						slotlessMap.put(54, new WondrousSlotlessItem("iron spike of safe passage", 2000));
						slotlessMap.put(55, new WondrousSlotlessItem("knight's pennon of honor", 2200));
						slotlessMap.put(59, new WondrousSlotlessItem("volatile vaporizer (1st)", 2200));
						slotlessMap.put(62, new WondrousSlotlessItem("elemental gem", 2250));
						slotlessMap.put(64, new WondrousSlotlessItem("flying ointment", 2250));
						slotlessMap.put(65, new WondrousSlotlessItem("sovereign glue", 2400));
						slotlessMap.put(66, new WondrousSlotlessItem("apple of eternal sleep", 2500));
						slotlessMap.put(68, new WondrousSlotlessItem("bag of holding (type I)", 2500));
						slotlessMap.put(69, new WondrousSlotlessItem("candle of truth", 2500));
						slotlessMap.put(70, new WondrousSlotlessItem("hexing doll", 2500));
						slotlessMap.put(72, new WondrousSlotlessItem("stone of alarm", 2700));
						slotlessMap.put(73, new WondrousSlotlessItem("standard book of extended summoning", 2750));
						slotlessMap.put(77, new WondrousSlotlessItem("bead of force", 3000));
						slotlessMap.put(78, new WondrousSlotlessItem("cauldron of brewing", 3000));
						slotlessMap.put(80, new WondrousSlotlessItem("chime of opening", 3000));
						slotlessMap.put(81, new WondrousSlotlessItem("philter of love", 3000));
						slotlessMap.put(86, new WondrousSlotlessItem("rope of climbing", 3000));
						slotlessMap.put(88, new WondrousSlotlessItem("volatile vaporizer (2nd)", 3000));
						slotlessMap.put(89, new WondrousSlotlessItem("shroud of disintegration", 3300));
						slotlessMap.put(92, new WondrousSlotlessItem("gray bag of tricks", 3400));
						slotlessMap.put(95, new WondrousSlotlessItem("dust of disappearance", 3500));
						slotlessMap.put(96, new WondrousSlotlessItem("dust of weighty burdens", 3600));
						slotlessMap.put(97, new WondrousSlotlessItem("noble's vigilant pillbox", 3600));
						slotlessMap.put(99, new WondrousSlotlessItem("figurine of wondrous power (silver raven)", 3800));
						slotlessMap.put(100, new WondrousSlotlessItem("volatile vaporizer (3rd)", 3800));
						break;
					case GREATER: 
						slotlessMap.put(1, new WondrousSlotlessItem("boro bead (2nd)", 4000));
						slotlessMap.put(2, new WondrousSlotlessItem("cautionary creance", 4000));
						slotlessMap.put(3, new WondrousSlotlessItem("escape ladder", 4000));
						slotlessMap.put(4, new WondrousSlotlessItem("far-reaching sight", 4000));
						slotlessMap.put(6, new WondrousSlotlessItem("clear spindle ioun stone", 4000));
						slotlessMap.put(7, new WondrousSlotlessItem("marvelous pigments", 4000));
						slotlessMap.put(15, new WondrousSlotlessItem("page of spell knowledge (2nd)", 4000));
						slotlessMap.put(25, new WondrousSlotlessItem("pearl of power (2nd)", 4000));
						slotlessMap.put(26, new WondrousSlotlessItem("preserving flask (2nd)", 4000));
						slotlessMap.put(27, new WondrousSlotlessItem("restorative ointment", 4000));
						slotlessMap.put(30, new WondrousSlotlessItem("stone salve", 4000));
						slotlessMap.put(31, new WondrousSlotlessItem("wind-caller compass", 4400));
						slotlessMap.put(32, new WondrousSlotlessItem("greater goblin fire drum", 4500));
						slotlessMap.put(33, new WondrousSlotlessItem("knight's pennon of battle", 4500));
						slotlessMap.put(34, new WondrousSlotlessItem("knight's pennon of parley", 4500));
						slotlessMap.put(35, new WondrousSlotlessItem("void dust", 4500));
						slotlessMap.put(36, new WondrousSlotlessItem("incense of meditation", 4900));
						slotlessMap.put(37, new WondrousSlotlessItem("admixture vial", 5000));
						slotlessMap.put(51, new WondrousSlotlessItem("bag of holding (type II)", 5000));
						slotlessMap.put(52, new WondrousSlotlessItem("bone razor", 5000));
						slotlessMap.put(53, new WondrousSlotlessItem("horn of the huntmaster", 5000));
						slotlessMap.put(54, new WondrousSlotlessItem("insistent doorknocker", 5000));
						slotlessMap.put(56, new WondrousSlotlessItem("dusty rose prism ioun stone", 5000));
						slotlessMap.put(57, new WondrousSlotlessItem("mallet of building", 5000));
						slotlessMap.put(58, new WondrousSlotlessItem("polymorphic pouch", 5000));
						slotlessMap.put(59, new WondrousSlotlessItem("scabbard of stanching", 5000));
						slotlessMap.put(60, new WondrousSlotlessItem("school of eyes", 5000));
						slotlessMap.put(61, new WondrousSlotlessItem("sheath of bladestealth", 5000));
						slotlessMap.put(62, new WondrousSlotlessItem("stone of alliance", 5000));
						slotlessMap.put(63, new WondrousSlotlessItem("summoning shackle", 5000));
						slotlessMap.put(64, new WondrousSlotlessItem("eversmoking bottle", 5400));
						slotlessMap.put(65, new WondrousSlotlessItem("sustaining spoon", 5400));
						slotlessMap.put(66, new WondrousSlotlessItem("wind fan", 5500));
						slotlessMap.put(67, new WondrousSlotlessItem("grim lantern", 5800));
						slotlessMap.put(68, new WondrousSlotlessItem("coin of the untrodden road", 6000));
						slotlessMap.put(69, new WondrousSlotlessItem("horn of battle clarity", 6000));
						slotlessMap.put(70, new WondrousSlotlessItem("life link badge", 6000));
						slotlessMap.put(71, new WondrousSlotlessItem("martyr's tear", 6000));
						slotlessMap.put(72, new WondrousSlotlessItem("pipes of haunting", 6000));
						slotlessMap.put(73, new WondrousSlotlessItem("rope of knots", 6000));
						slotlessMap.put(74, new WondrousSlotlessItem("singing bell of striking", 6000));
						slotlessMap.put(75, new WondrousSlotlessItem("stone familiar", 6000));
						slotlessMap.put(76, new WondrousSlotlessItem("greater book of extended summoning", 6126));
						slotlessMap.put(77, new WondrousSlotlessItem("dragonbone divination sticks", 6400));
						slotlessMap.put(79, new WondrousSlotlessItem("horn of goodness/evil", 6500));
						slotlessMap.put(79, new WondrousSlotlessItem("naga-scale bindi", 6600));
						slotlessMap.put(80, new WondrousSlotlessItem("bottle of shadows", 7000));
						slotlessMap.put(81, new WondrousSlotlessItem("cape of bravado", 7000));
						slotlessMap.put(83, new WondrousSlotlessItem("instant bridge", 7000));
						slotlessMap.put(84, new WondrousSlotlessItem("mirror of guarding reflections", 7000));
						slotlessMap.put(85, new WondrousSlotlessItem("folding boat", 7200));
						slotlessMap.put(87, new WondrousSlotlessItem("bottle of air", 7250));
						slotlessMap.put(94, new WondrousSlotlessItem("bag of holding (type III)", 7400));
						slotlessMap.put(95, new WondrousSlotlessItem("balm of impish grace", 7500));
						slotlessMap.put(96, new WondrousSlotlessItem("candle of clean air", 7500));
						slotlessMap.put(97, new WondrousSlotlessItem("harp of charming", 7500));
						slotlessMap.put(100, new WondrousSlotlessItem("manual of war", 7500));
						break;
					default:
						break;
				}
				break;
			case MEDIUM:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						slotlessMap.put(1, new WondrousSlotlessItem("chalice of poison weeping", 8000));
						slotlessMap.put(2, new WondrousSlotlessItem("exorcist's aspergillum", 8000));
						slotlessMap.put(3, new WondrousSlotlessItem("flesh golem manual", 8000));
						slotlessMap.put(4, new WondrousSlotlessItem("harp of shattering", 8000));
						slotlessMap.put(5, new WondrousSlotlessItem("insignia of valor", 8000));
						slotlessMap.put(6, new WondrousSlotlessItem("deep red sphere ioun stone", 8000));
						slotlessMap.put(7, new WondrousSlotlessItem("incandescent blue sphere ioun stone", 8000));
						slotlessMap.put(8, new WondrousSlotlessItem("pale blue rhomboid ioun stone", 8000));
						slotlessMap.put(9, new WondrousSlotlessItem("pink and green sphere ioun stone", 8000));
						slotlessMap.put(10, new WondrousSlotlessItem("pink rhomboid ioun stone", 8000));
						slotlessMap.put(11, new WondrousSlotlessItem("scarlet and blue sphere ioun stone", 8000));
						slotlessMap.put(12, new WondrousSlotlessItem("needles of fleshgraving", 8000));
						slotlessMap.put(13, new WondrousSlotlessItem("restless lockpicks", 8000));
						slotlessMap.put(14, new WondrousSlotlessItem("werewhistle", 8000));
						slotlessMap.put(16, new WondrousSlotlessItem("deck of illusions", 8100));
						slotlessMap.put(17, new WondrousSlotlessItem("candle of invocation", 8400));
						slotlessMap.put(19, new WondrousSlotlessItem("rust bag of tricks", 8500));
						slotlessMap.put(20, new WondrousSlotlessItem("boro bead (3rd)", 9000));
						slotlessMap.put(21, new WondrousSlotlessItem("decanter of endless water", 9000));
						slotlessMap.put(22, new WondrousSlotlessItem("loathsome mirror", 9000));
						slotlessMap.put(25, new WondrousSlotlessItem("page of spell knowledge (3rd)", 9000));
						slotlessMap.put(31, new WondrousSlotlessItem("pearl of power (3rd)", 9000));
						slotlessMap.put(32, new WondrousSlotlessItem("preserving flask (3rd)", 9000));
						slotlessMap.put(33, new WondrousSlotlessItem("figurine of wondrous power (serpentine owl)", 9100));
						slotlessMap.put(34, new WondrousSlotlessItem("lesser strand of prayer beads", 9600));
						slotlessMap.put(38, new WondrousSlotlessItem("bag of holding (type IV)", 10000));
						slotlessMap.put(39, new WondrousSlotlessItem("boundary chalk", 10000));
						slotlessMap.put(40, new WondrousSlotlessItem("chime of resounding silence", 10000));
						slotlessMap.put(41, new WondrousSlotlessItem("construct channel brick", 10000));
						slotlessMap.put(42, new WondrousSlotlessItem("doomharp", 10000));
						slotlessMap.put(43, new WondrousSlotlessItem("drum of advance and retreat", 10000));
						slotlessMap.put(44, new WondrousSlotlessItem("embalming thread", 10000));
						slotlessMap.put(45, new WondrousSlotlessItem("eye of the void", 10000));
						slotlessMap.put(46, new WondrousSlotlessItem("figurine of wondrous power (bronze griffon)", 10000));
						slotlessMap.put(47, new WondrousSlotlessItem("figurine of wondrous power (ebony fly)", 10000));
						slotlessMap.put(48, new WondrousSlotlessItem("figurine of wondrous power (slate spider)", 10000));
						slotlessMap.put(49, new WondrousSlotlessItem("hourglass of last chances", 10000));
						slotlessMap.put(51, new WondrousSlotlessItem("dark blue rhomboid ioun stone", 10000));
						slotlessMap.put(52, new WondrousSlotlessItem("ki mat", 10000));
						slotlessMap.put(53, new WondrousSlotlessItem("lord's banner of swiftness", 10000));
						slotlessMap.put(54, new WondrousSlotlessItem("malleable symbol", 10000));
						slotlessMap.put(55, new WondrousSlotlessItem("migrus locker", 10000));
						slotlessMap.put(56, new WondrousSlotlessItem("ornament of healing light", 10000));
						slotlessMap.put(57, new WondrousSlotlessItem("prayer wheel of ethical strength", 10000));
						slotlessMap.put(58, new WondrousSlotlessItem("stone horse (courser)", 10000));
						slotlessMap.put(59, new WondrousSlotlessItem("summon-slave crystal", 10000));
						slotlessMap.put(60, new WondrousSlotlessItem("treasurer's seal", 10000));
						slotlessMap.put(61, new WondrousSlotlessItem("black soul shard", 12000));
						slotlessMap.put(62, new WondrousSlotlessItem("clay golem manual", 12000));
						slotlessMap.put(63, new WondrousSlotlessItem("horsemaster's saddle", 12000));
						slotlessMap.put(64, new WondrousSlotlessItem("pipes of dissolution", 12000));
						slotlessMap.put(65, new WondrousSlotlessItem("pipes of pain", 12000));
						slotlessMap.put(66, new WondrousSlotlessItem("seeker's sight", 12000));
						slotlessMap.put(67, new WondrousSlotlessItem("blessed book", 12500));
						slotlessMap.put(68, new WondrousSlotlessItem("waters of transfiguration", 12500));
						slotlessMap.put(69, new WondrousSlotlessItem("gem of brightness", 13000));
						slotlessMap.put(70, new WondrousSlotlessItem("harp of contagion", 13000));
						slotlessMap.put(71, new WondrousSlotlessItem("lyre of building", 13000));
						slotlessMap.put(72, new WondrousSlotlessItem("void pennant", 14000));
						slotlessMap.put(73, new WondrousSlotlessItem("stone horse (destrier)", 14800));
						slotlessMap.put(74, new WondrousSlotlessItem("book of the loremaster", 15000));
						slotlessMap.put(75, new WondrousSlotlessItem("cauldron of plenty", 15000));
						slotlessMap.put(76, new WondrousSlotlessItem("horn of judgement", 15000));
						slotlessMap.put(77, new WondrousSlotlessItem("belt of the weasel", 10000));
						slotlessMap.put(78, new WondrousSlotlessItem("belt of thunderous charging", 10000));
						slotlessMap.put(79, new WondrousSlotlessItem("minotaur belt", 11000));
						slotlessMap.put(81, new WondrousSlotlessItem("greater plague rat belt", 11200));
						slotlessMap.put(82, new WondrousSlotlessItem("belt of equilibrium", 12000));
						slotlessMap.put(83, new WondrousSlotlessItem("security belt", 12500));
						slotlessMap.put(87, new WondrousSlotlessItem("lesser belt of mighty hurling", 14000));
						slotlessMap.put(88, new WondrousSlotlessItem("belt of thunderous charging", 10000));
						slotlessMap.put(91, new WondrousSlotlessItem("minotaur belt", 11000));
						slotlessMap.put(93, new WondrousSlotlessItem("greater plague rat belt", 11200));
						slotlessMap.put(95, new WondrousSlotlessItem("belt of equilibrium", 12000));
						slotlessMap.put(99, new WondrousSlotlessItem("security belt", 12500));
						slotlessMap.put(100, new WondrousSlotlessItem("lesser belt of mighty hurling", 14000));
						break;
					case GREATER:
						slotlessMap.put(3, new WondrousSlotlessItem("iridescent spindle ioun stone", 18000));
						slotlessMap.put(4, new WondrousSlotlessItem("orb of foul Abaddon", 18000));
						slotlessMap.put(8, new WondrousSlotlessItem("carpet of flying (5 ft. by 5 ft.)", 20000));
						slotlessMap.put(9, new WondrousSlotlessItem("horn of antagonism", 20000));
						slotlessMap.put(13, new WondrousSlotlessItem("horn of blasting", 20000));
						slotlessMap.put(17, new WondrousSlotlessItem("pale lavendar ellipsoid ioun stone", 20000));
						slotlessMap.put(21, new WondrousSlotlessItem("pearly white spindle ioun stone", 20000));
						slotlessMap.put(24, new WondrousSlotlessItem("master's perfect golden bell", 20000));
						slotlessMap.put(27, new WondrousSlotlessItem("necromancer's athame", 20000));
						slotlessMap.put(31, new WondrousSlotlessItem("portable hole", 20000));
						slotlessMap.put(35, new WondrousSlotlessItem("stone of good luck", 20000));
						slotlessMap.put(37, new WondrousSlotlessItem("figurine of wondrous power (ivory goats)", 21000));
						slotlessMap.put(40, new WondrousSlotlessItem("rope of entanglement", 21000));
						slotlessMap.put(42, new WondrousSlotlessItem("stone golem manual", 22000));
						slotlessMap.put(43, new WondrousSlotlessItem("orb of golden heaven", 22000));
						slotlessMap.put(45, new WondrousSlotlessItem("mattock of the titans", 23348));
						slotlessMap.put(48, new WondrousSlotlessItem("drinking horn of bottomless valor", 24000));
						slotlessMap.put(51, new WondrousSlotlessItem("boro bead (5th)", 25000));
						slotlessMap.put(53, new WondrousSlotlessItem("chaos emerald", 25000));
						slotlessMap.put(57, new WondrousSlotlessItem("page of spell knowledge (5th)", 25000));
						slotlessMap.put(64, new WondrousSlotlessItem("pearl of pwoer (5th)", 25000));
						slotlessMap.put(67, new WondrousSlotlessItem("preserving flask (5th)", 25000));
						slotlessMap.put(69, new WondrousSlotlessItem("maul of the titans", 25305));
						slotlessMap.put(73, new WondrousSlotlessItem("iron bands of binding", 26000));
						slotlessMap.put(76, new WondrousSlotlessItem("cube of frost resistance", 27000));
						slotlessMap.put(80, new WondrousSlotlessItem("manual of bodily health +1", 27500));
						slotlessMap.put(84, new WondrousSlotlessItem("manual of gainful exercise +1", 27500));
						slotlessMap.put(88, new WondrousSlotlessItem("manual of quickness of action +1", 27500));
						slotlessMap.put(92, new WondrousSlotlessItem("tome of clear thought +1", 27500));
						slotlessMap.put(96, new WondrousSlotlessItem("tome of leadership and influence +1", 27500));
						slotlessMap.put(100, new WondrousSlotlessItem("tome of understanding +1", 27500));
						break;
					default:
						break;
				}
				break;
			case MAJOR:
				switch (itemDegreeQualifier)
				{
					case LESSER:
						slotlessMap.put(4, new WondrousSlotlessItem("figurine of wondrous power (obsidian steed)", 28500));
						slotlessMap.put(7, new WondrousSlotlessItem("cauldron of the dead", 30000));
						slotlessMap.put(11, new WondrousSlotlessItem("drums of panic", 30000));
						slotlessMap.put(15, new WondrousSlotlessItem("orange prism ioun stone", 30000));
						slotlessMap.put(19, new WondrousSlotlessItem("pale green prism ioun stone", 30000));
						slotlessMap.put(23, new WondrousSlotlessItem("lantern of revealing", 30000));
						slotlessMap.put(27, new WondrousSlotlessItem("racing broom of flying", 30000));
						slotlessMap.put(31, new WondrousSlotlessItem("cauldron of resurrection", 33000));
						slotlessMap.put(36, new WondrousSlotlessItem("carpet of flying (5 ft. by 10 ft.)", 35000));
						slotlessMap.put(38, new WondrousSlotlessItem("iron golem manual", 35000));
						slotlessMap.put(40, new WondrousSlotlessItem("boro bead (6th)", 36000));
						slotlessMap.put(44, new WondrousSlotlessItem("vibrant purple prism ioun stone", 36000));
						slotlessMap.put(48, new WondrousSlotlessItem("orb of utter chaos", 36000));
						slotlessMap.put(50, new WondrousSlotlessItem("page of spell knowledge (6th)", 36000));
						slotlessMap.put(58, new WondrousSlotlessItem("pearl of power (6th)", 36000));
						slotlessMap.put(60, new WondrousSlotlessItem("preserving flask (6th)", 36000));
						slotlessMap.put(64, new WondrousSlotlessItem("cauldron of flying", 40000));
						slotlessMap.put(66, new WondrousSlotlessItem("enmity fetish", 40000));
						slotlessMap.put(69, new WondrousSlotlessItem("lavender and green ellipsoid ioun stone", 40000));
						slotlessMap.put(73, new WondrousSlotlessItem("ring gates", 40000));
						slotlessMap.put(77, new WondrousSlotlessItem("cauldron of seeing", 42000));
						slotlessMap.put(81, new WondrousSlotlessItem("crystal ball", 42000));
						slotlessMap.put(83, new WondrousSlotlessItem("stone guardian golem manual", 44000));
						slotlessMap.put(87, new WondrousSlotlessItem("drums of haste", 45000));
						slotlessMap.put(91, new WondrousSlotlessItem("standard strand of prayer beads", 45800));
						slotlessMap.put(94, new WondrousSlotlessItem("orb of storms", 48000));
						slotlessMap.put(96, new WondrousSlotlessItem("page of spell knowledge (7th)", 49000));
						slotlessMap.put(100, new WondrousSlotlessItem("pearl of power (7th)", 49000));
						break;
					case GREATER:
						slotlessMap.put(3, new WondrousSlotlessItem("crystal ball with see invisibility", 50000));
						slotlessMap.put(5, new WondrousSlotlessItem("horn of Valhalla", 50000));
						slotlessMap.put(8, new WondrousSlotlessItem("crystal ball with detect thoughts", 51000));
						slotlessMap.put(9, new WondrousSlotlessItem("last leaves of the autumn dryad", 52000));
						slotlessMap.put(11, new WondrousSlotlessItem("instant fortress", 55000));
						slotlessMap.put(15, new WondrousSlotlessItem("manual of bodily health +2", 55000));
						slotlessMap.put(19, new WondrousSlotlessItem("manual of gainful exercise +2", 55000));
						slotlessMap.put(23, new WondrousSlotlessItem("manual of quickness of action +2", 55000));
						slotlessMap.put(27, new WondrousSlotlessItem("tome of clear thought +2", 55000));
						slotlessMap.put(31, new WondrousSlotlessItem("tome of leadership and influence +2", 55000));
						slotlessMap.put(35, new WondrousSlotlessItem("tome of understanding +2", 55000));
						slotlessMap.put(36, new WondrousSlotlessItem("lord's banner of terror", 56000));
						slotlessMap.put(37, new WondrousSlotlessItem("carpet of flying (10 ft. by 10 ft.)", 60000));
						slotlessMap.put(39, new WondrousSlotlessItem("darkskull", 60000));
						slotlessMap.put(40, new WondrousSlotlessItem("orb of pure law", 60000));
						slotlessMap.put(41, new WondrousSlotlessItem("cube of force", 62000));
						slotlessMap.put(43, new WondrousSlotlessItem("page of spell knowledge (8th)", 64000));
						slotlessMap.put(49, new WondrousSlotlessItem("pearl of power (8th)", 64000));
						slotlessMap.put(50, new WondrousSlotlessItem("crystal ball of telepathy", 70000));
						slotlessMap.put(51, new WondrousSlotlessItem("greater horn of blasting", 70000));
						slotlessMap.put(54, new WondrousSlotlessItem("pearl of power (two spells)", 70000));
						slotlessMap.put(55, new WondrousSlotlessItem("gem of seeing", 75000));
						slotlessMap.put(56, new WondrousSlotlessItem("lord's banner of victory", 75000));
						slotlessMap.put(57, new WondrousSlotlessItem("crystal ball of true seeing", 80000));
						slotlessMap.put(59, new WondrousSlotlessItem("page of spell knowledge (9th)", 81000));
						slotlessMap.put(62, new WondrousSlotlessItem("pearl of power (9th)", 81000));
						slotlessMap.put(63, new WondrousSlotlessItem("well of many worlds", 82000));
						slotlessMap.put(65, new WondrousSlotlessItem("manual of bodily health +3", 82500));
						slotlessMap.put(67, new WondrousSlotlessItem("manual of gainful exercise +3", 82500));
						slotlessMap.put(69, new WondrousSlotlessItem("manual of quickness of action +3", 82500));
						slotlessMap.put(71, new WondrousSlotlessItem("tome of clear thought +3", 82500));
						slotlessMap.put(73, new WondrousSlotlessItem("tome of leadership and influence +3", 82500));
						slotlessMap.put(75, new WondrousSlotlessItem("tome of understanding +3", 82500));
						slotlessMap.put(76, new WondrousSlotlessItem("apparatus of the crab", 90000));
						slotlessMap.put(77, new WondrousSlotlessItem("bowl of conjuring water elementals", 90000));
						slotlessMap.put(78, new WondrousSlotlessItem("brazier of conjuring fire elementals", 90000));
						slotlessMap.put(79, new WondrousSlotlessItem("censuring of conjuring air elementals", 90000));
						slotlessMap.put(80, new WondrousSlotlessItem("stone of conjuring earth elementals", 90000));
						slotlessMap.put(81, new WondrousSlotlessItem("mirror of opposition", 92000));
						slotlessMap.put(82, new WondrousSlotlessItem("greater strand of prayer beads", 95800));
						slotlessMap.put(83, new WondrousSlotlessItem("lord's banner of crusades", 100000));
						slotlessMap.put(84, new WondrousSlotlessItem("manual of bodily health +4", 110000));
						slotlessMap.put(85, new WondrousSlotlessItem("manual of gainful exercise +4", 110000));
						slotlessMap.put(86, new WondrousSlotlessItem("manual of quickness of action +4", 110000));
						slotlessMap.put(87, new WondrousSlotlessItem("tome of clear thought +4", 110000));
						slotlessMap.put(88, new WondrousSlotlessItem("tome of leadership and influence +4", 110000));
						slotlessMap.put(89, new WondrousSlotlessItem("tome of understanding +4", 110000));
						slotlessMap.put(90, new WondrousSlotlessItem("manual of bodily health +5", 137500));
						slotlessMap.put(91, new WondrousSlotlessItem("manual of gainful exercise +5", 137500));
						slotlessMap.put(92, new WondrousSlotlessItem("manual of quickness of action +5", 137500));
						slotlessMap.put(93, new WondrousSlotlessItem("tome of clear thought +5", 137500));
						slotlessMap.put(94, new WondrousSlotlessItem("tome of leadership and influence +5", 137500));
						slotlessMap.put(95, new WondrousSlotlessItem("tome of understanding +5", 137500));
						slotlessMap.put(96, new WondrousSlotlessItem("efreeti bottle", 145000));
						slotlessMap.put(97, new WondrousSlotlessItem("cubic gate", 164000));
						slotlessMap.put(98, new WondrousSlotlessItem("iron flask", 170000));
						slotlessMap.put(99, new WondrousSlotlessItem("mirror of mental prowess", 175000));
						slotlessMap.put(100, new WondrousSlotlessItem("mirror of life trapping", 200000));
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}

	@Override
	public Item copyItem() {
		WondrousSlotlessItem itemCopy = new WondrousSlotlessItem(itemDegree);
		itemCopy.leafItem = leafItem;
		return itemCopy;
	}

	public void setEconomyModifier(int economyModifier) 
	{
		if (degreeQualifierMap == null)
			degreeQualifierMap = new HashMap<ItemDegree, Map<Integer, ItemDegreeQualifier>>();
		Map<Integer, ItemDegreeQualifier> qualifierMap = degreeQualifierMap.get(itemDegree);
		if (qualifierMap == null)
		{
			qualifierMap = new LinkedHashMap<Integer, ItemDegreeQualifier>();
			populateQualifierMap(qualifierMap, itemDegree);
			degreeQualifierMap.put(itemDegree, qualifierMap);
		}
		itemDegreeQualifier = ItemsForSale.getRandomThing(qualifierMap, economyModifier);
	}

	private void populateQualifierMap(
			Map<Integer, ItemDegreeQualifier> qualifierMap,
			ItemDegree itemDegree) 
	{
		switch (itemDegree)
		{
			case MINOR:
				qualifierMap.put(33, ItemDegreeQualifier.LEAST);
				qualifierMap.put(66, ItemDegreeQualifier.LESSER);
				qualifierMap.put(99, ItemDegreeQualifier.GREATER);
				break;
			default:
				qualifierMap.put(50, ItemDegreeQualifier.LESSER);
				qualifierMap.put(100, ItemDegreeQualifier.GREATER);
				break;
		}
	}
}