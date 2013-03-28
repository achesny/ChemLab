package mod.chemlab.common;

import mod.chemlab.client.ClientPacketHandler;
import mod.chemlab.client.ClientProxyChemLab;
import mod.chemlab.common.ServerPacketHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="ChemLab",name="Chem Lab",version="1.4.7")
@NetworkMod(clientSideRequired=true, serverSideRequired=false, clientPacketHandlerSpec=@SidedPacketHandler(channels = {"ChemLab"},packetHandler = ClientPacketHandler.class), serverPacketHandlerSpec=@SidedPacketHandler(channels = {"ChemLab"},packetHandler = ServerPacketHandler.class))
public class ChemLab {

	@Instance("ChemLab")
	public static ChemLab instance;

	//Items
	private static final int ELECTRON_ID = 2502;
	private static final int NUETRON_ID = 2501;
	private static final int PROTON_ID = 2500;
	private static final int HYDROGEN_ID = 2503;
	private static final int HELIUM_ID = 2504;
	private static final int LITHIUM_ID = 2505;
	private static final int BERYLLIUM_ID = 2506;
	private static final int BORON_ID = 2507;
	private static final int CARBON_ID = 2508;
	private static final int NITROGEN_ID = 2509;
	private static final int OXYGEN_ID = 2510;
	private static final int FLOURINE_ID = 2511;
	private static final int NEON_ID = 2512;
	private static final int SODIUM_ID = 2513;
	private static final int MAGNESIUM_ID = 2514;
	private static final int ALUMINIUM_ID = 2515;
	private static final int SILICON_ID = 2516;
	private static final int PHOSPHORUS_ID = 2517;
	private static final int SULFUR_ID = 2518;
	private static final int CHLORINE_ID = 2519;
	private static final int ARGON_ID = 2520;
	private static final int POTASSIUM_ID = 2521;
	private static final int CALCIUM_ID = 2522;
	private static final int SCANDIUM_ID = 2523;
	private static final int TITANIUM_ID = 2524;
	private static final int VANADIUM_ID = 2525;
	private static final int CHROMIUM_ID = 2526;
	private static final int MANGANESE_ID = 2527;
	private static final int IRON_ID = 2528;
	private static final int COBALT_ID = 2529;
	private static final int NICKEL_ID = 2530;
	private static final int COPPER_ID = 2531;
	private static final int ZINC_ID = 2532;
	private static final int GALLIUM_ID = 2533;
	private static final int GERMANIUM_ID = 2534;
	private static final int ARSENIC_ID = 2535;
	private static final int SELENIUM_ID = 2536;
	private static final int BROMINE_ID = 2537;
	private static final int KRYPTON_ID = 2538;
	private static final int RUBIDIUM_ID = 2539;
	private static final int STRONTIUM_ID = 2540;
	private static final int YTTRIUM_ID = 2541;
	private static final int ZIRCONIUM_ID = 2542;
	private static final int NIOBIUM_ID = 2543;
	private static final int MOLYBDENUM_ID = 2544;
	private static final int TECHNETIUM_ID = 2545;
	private static final int RUTHENIUM_ID = 2546;
	private static final int RHODIUM_ID = 2547;
	private static final int PALLADIUM_ID = 2548;
	private static final int SILVER_ID = 2549;
	private static final int CADMIUM_ID = 2550;
	private static final int INDIUM_ID = 2551;
	private static final int TIN_ID = 2552;
	private static final int ANTIMONY_ID = 2553;
	private static final int TELLURIUM_ID = 2554;
	private static final int IODINE_ID = 2555;
	private static final int XENON_ID = 2556;
	private static final int CAESIUM_ID = 2557;
	private static final int BARIUM_ID = 2558;
	private static final int LANTHANUM_ID = 2559;
	private static final int CERIUM_ID = 2560;
	private static final int PRASEODYMIUM_ID = 2561;
	private static final int NEODYMIUM_ID = 2562;
	private static final int PROMETHIUM_ID = 2563;
	private static final int SAMARIUM_ID = 2564;
	private static final int EUROPIUM_ID = 2565;
	private static final int GADOLINIUM_ID = 2566;
	private static final int TERBIUM_ID = 2567;
	private static final int DYSPROSIUM_ID = 2568;
	private static final int HOLMIUM_ID = 2569;
	private static final int ERBIUM_ID = 2570;
	private static final int THULIUM_ID = 2571;
	private static final int YTTERBIUM_ID = 2572;
	private static final int LUTETIUM_ID = 2573;
	private static final int HAFNIUM_ID = 2574;
	private static final int TANTALUM_ID = 2575;
	private static final int TUNGSTEN_ID = 2576;
	private static final int RHENIUM_ID = 2577;
	private static final int OSMIUM_ID = 2578;
	private static final int IRIDIUM_ID = 2579;
	private static final int PLATINUM_ID = 2580;
	private static final int GOLD_ID = 2581;
	private static final int MERCURY_ID = 2582;
	private static final int THALLIUM_ID = 2583;
	private static final int LEAD_ID = 2584;
	private static final int BISMUTH_ID = 2585;
	private static final int POLONIUM_ID = 2586;
	private static final int ASTATINE_ID = 2587;
	private static final int RADON_ID = 2588;
	private static final int FRANCIUM_ID = 2589;
	private static final int RADIUM_ID =2590;
	private static final int ACTINIUM_ID = 2591;
	private static final int THORIUM_ID = 2592;
	private static final int PROTACTINIUM_ID = 2593;
	private static final int URANIUM_ID = 2594;
	private static final int NEPTUNIUM_ID = 2595;
	private static final int PLUTONIUM_ID = 2596;
	private static final int AMERICIUM_ID = 2597;
	private static final int CURIUM_ID = 2598;
	private static final int BERKELIUM_ID = 2599;
	private static final int CALIFORNIUM_ID = 2600;
	private static final int EINSTEINIUM_ID = 2601;
	private static final int FERMIUM_ID = 2602;
	private static final int MENDELEVIUM_ID = 2603;
	private static final int NOBELIUM_ID = 2604;

	private static final String PROTON_NAME = "Proton";
	private static final String NUETRON_NAME = "Nuetron";
	private static final String ELECTRON_NAME = "Electron";
	private static final String HYDROGEN_NAME = "Hydrogen";
	private static final String HELIUM_NAME = "Helium";
	private static final String LITHIUM_NAME = "Lithium";
	private static final String BERYLLIUM_NAME = "Beryllium";
	private static final String BORON_NAME = "Boron";
	private static final String CARBON_NAME = "Carbon";
	private static final String NITROGEN_NAME = "Nitrogen";
	private static final String OXYGEN_NAME = "Oxygen";
	private static final String FLOURINE_NAME = "Flourine";
	private static final String NEON_NAME = "Neon";
	private static final String SODIUM_NAME = "Sodium";
	private static final String MAGNESIUM_NAME = "Magnesium";
	private static final String ALUMINIUM_NAME = "Aluminium";
	private static final String SILICON_NAME = "Silicon";
	private static final String PHOSPHORUS_NAME = "Phosphorus";
	private static final String SULFUR_NAME = "Sulfur";
	private static final String CHLORINE_NAME = "Chlorine";
	private static final String ARGON_NAME = "Argon";
	private static final String POTASSIUM_NAME = "Potassium";
	private static final String CALCIUM_NAME = "Calcium";
	private static final String SCANDIUM_NAME = "Scandium";
	private static final String TITANIUM_NAME = "Titanium";
	private static final String VANADIUM_NAME = "Vandium";
	private static final String CHROMIUM_NAME = "Chromium";
	private static final String MANGANESE_NAME = "Manganese";
	private static final String IRON_NAME = "Iron";
	private static final String COBALT_NAME = "Cobalt";
	private static final String NICKEL_NAME = "Nickel";
	private static final String COPPER_NAME = "Copper";
	private static final String ZINC_NAME = "Zinc";
	private static final String GALLIUM_NAME = "Gallium";
	private static final String GERMANIUM_NAME = "Germanium";
	private static final String ARSENIC_NAME = "Arsenic";
	private static final String SELENIUM_NAME = "Selenium";
	private static final String BROMINE_NAME = "Bromine";
	private static final String KRYPTON_NAME = "Krypton";
	private static final String RUBIDIUM_NAME = "Rubidium";
	private static final String STRONTIUM_NAME = "Strontium";
	private static final String YTTRIUM_NAME = "Yttrium";
	private static final String ZIRCONIUM_NAME = "Zirconium";
	private static final String NIOBIUM_NAME = "Niobium";
	private static final String MOLYBDENUM_NAME = "Molybdenum";
	private static final String TECHNETIUM_NAME = "Technetium";
	private static final String RUTHENIUM_NAME = "Ruthenium";
	private static final String RHODIUM_NAME = "Rhodium";
	private static final String PALLADIUM_NAME = "Palladium";
	private static final String SILVER_NAME = "Silver";
	private static final String CADMIUM_NAME = "Cadmium";
	private static final String INDIUM_NAME = "Indium";
	private static final String TIN_NAME = "Tin";
	private static final String ANTIMONY_NAME = "Antimony";
	private static final String TELLURIUM_NAME = "Tellurium";
	private static final String IODINE_NAME = "Iodine";
	private static final String XENON_NAME = "Xenon";
	private static final String CAESIUM_NAME = "Caesium";
	private static final String BARIUM_NAME = "Barium";
	private static final String LANTHANUM_NAME = "Lanthanum";
	private static final String CERIUM_NAME = "Cerium";
	private static final String PRASEODYMIUM_NAME = "Praseodymium";
	private static final String NEODYMIUM_NAME = "Neodymium";
	private static final String PROMETHIUM_NAME = "Promethium";
	private static final String SAMARIUM_NAME = "Samarium";
	private static final String EUROPIUM_NAME = "Europium";
	private static final String GADOLINIUM_NAME = "Gadolinium";
	private static final String TERBIUM_NAME = "Terbium";
	private static final String DYSPROSIUM_NAME = "Dysprosium";
	private static final String HOLMIUM_NAME = "Holmium";
	private static final String ERBIUM_NAME = "Erbium";
	private static final String THULIUM_NAME = "Thulium";
	private static final String YTTERBIUM_NAME = "Ytterbium";
	private static final String LUTETIUM_NAME = "Lutetium";
	private static final String HAFNIUM_NAME = "Hafnium";
	private static final String TANTALUM_NAME = "Tantalum";
	private static final String TUNGSTEN_NAME = "Tungsten";
	private static final String RHENIUM_NAME = "Rhenium";
	private static final String OSMIUM_NAME = "Osmium";
	private static final String IRIDIUM_NAME = "Iridium";
	private static final String PLATINUM_NAME = "Platinum";
	private static final String GOLD_NAME = "Gold";
	private static final String MERCURY_NAME = "Mercury";
	private static final String THALLIUM_NAME = "Thallium";
	private static final String LEAD_NAME = "Lead";
	private static final String BISMUTH_NAME = "Bismuth";
	private static final String POLONIUM_NAME = "Polonium";
	private static final String ASTATINE_NAME = "Astatine";
	private static final String RADON_NAME = "Radon";
	private static final String FRANCIUM_NAME = "Francium";
	private static final String RADIUM_NAME = "Radium";
	private static final String ACTINIUM_NAME = "Actinium";
	private static final String THORIUM_NAME = "Thorium";
	private static final String PROTACTINIUM_NAME = "Protactinium";
	private static final String URANIUM_NAME = "Uranium";
	private static final String NEPTUNIUM_NAME = "Neptunium";
	private static final String PLUTONIUM_NAME = "Plutonium";
	private static final String AMERICIUM_NAME = "Americium";
	private static final String CURIUM_NAME = "Curium";
	private static final String BERKELIUM_NAME = "Berkelium";
	private static final String CALIFORNIUM_NAME = "Californium";
	private static final String EINSTEINIUM_NAME = "Einsteinium";
	private static final String FERMIUM_NAME = "Fermium";
	private static final String MENDELEVIUM_NAME = "Mendelevium";
	private static final String NOBELIUM_NAME = "Nobelium";
	
	//Blocks
    private static final int ATOM_SPLITTER_ID = 2500;
    private static final int ATOM_FUSER_ID = 2501;

    private static final String ATOM_SPLITTER_NAME = "Atom Splitter";
	private static final String ATOM_FUSER_NAME = "Atom Fuser";


	@SidedProxy(clientSide="mod.chemlab.client.ClientProxyChemLab",serverSide="mod.chemlab.common.CommonProxyChemLab")
	public static ClientProxyChemLab proxy;
	
	static Item proton;
	static Item nuetron;
	static Item electron;
	static Item hydrogen;
	static Item helium;
	static Item nobelium;
	
	Block atomSplitter;
	Block atomFuser;

	private static FuserRecipes fuserRecipes;

	public static FuserRecipes getFuserRecipes() {
		return fuserRecipes;
	}

	@Init
	public void load(FMLInitializationEvent event) {
		proton = new ItemProton(PROTON_ID).setUnlocalizedName(PROTON_NAME);
		nuetron = new ItemNuetron(NUETRON_ID).setUnlocalizedName(NUETRON_NAME);
		electron = new ItemElectron(ELECTRON_ID).setUnlocalizedName(ELECTRON_NAME);
		hydrogen = new ItemAtom(HYDROGEN_ID).setUnlocalizedName(HYDROGEN_NAME);
		helium = new ItemAtom(HELIUM_ID).setUnlocalizedName(HELIUM_NAME);
		nobelium = new ItemAtom(NOBELIUM_ID).setUnlocalizedName(NOBELIUM_NAME);
		
		atomSplitter = new BlockAtomSplitter(ATOM_SPLITTER_ID).setUnlocalizedName(ATOM_SPLITTER_NAME).setHardness(0.5F).setStepSound(Block.soundGravelFootstep);
		atomFuser = new BlockAtomFuser(ATOM_FUSER_ID).setUnlocalizedName(ATOM_FUSER_NAME).setHardness(0.5F).setStepSound(Block.soundGravelFootstep);
	
		gameRegisters();
		languageRegisters();
		shapedRecipeRegisters();
		shapelessRecipeRegisters();
		addFuserRecipes();
		
		proxy.registerRenderThings();
	}

	private void shapelessRecipeRegisters() {
	}

	private void shapedRecipeRegisters() {
		GameRegistry.addRecipe(
				new ItemStack(atomSplitter,1), 
				new Object[]{"CGC","GAG","CCC",
					'C',new ItemStack(Block.cobblestone,1),
					'G',new ItemStack(Block.glass,1),
					'A',new ItemStack(Item.axeStone,1)
		});
		GameRegistry.addRecipe(
				new ItemStack(atomFuser,1), 
				new Object[]{"CGC","GFG","CCC",
					'C',new ItemStack(Block.cobblestone,1),
					'G',new ItemStack(Block.glass,1),
					'F',new ItemStack(Item.flintAndSteel,1)
		});
	}

	private void languageRegisters() {
		LanguageRegistry.addName(proton, PROTON_NAME);
		LanguageRegistry.addName(nuetron, NUETRON_NAME);
		LanguageRegistry.addName(electron, ELECTRON_NAME);
		LanguageRegistry.addName(hydrogen, HYDROGEN_NAME);
		LanguageRegistry.addName(helium, HELIUM_NAME);
		LanguageRegistry.addName(nobelium, NOBELIUM_NAME);

		LanguageRegistry.addName(atomSplitter, ATOM_SPLITTER_NAME);
		LanguageRegistry.addName(atomFuser, ATOM_FUSER_NAME);
	}

	private void gameRegisters() {
		GameRegistry.registerBlock(atomSplitter, ATOM_SPLITTER_NAME);
		GameRegistry.registerBlock(atomFuser, ATOM_FUSER_NAME);
		
		GameRegistry.registerTileEntity(TileEntityAtomFuser.class, ATOM_FUSER_NAME);
		GameRegistry.registerTileEntity(TileEntityAtomSplitter.class, ATOM_SPLITTER_NAME);

		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
	}

	private void addFuserRecipes() {
		fuserRecipes = new FuserRecipes();
		fuserRecipes.addRecipe(HYDROGEN_ID, new AtomRecipe(hydrogen, 1, 0, new Integer[] {1}));
		fuserRecipes.addRecipe(HELIUM_ID, new AtomRecipe(helium, 2, 1, new Integer[] {2}));
		fuserRecipes.addRecipe(NOBELIUM_ID, new AtomRecipe(nobelium,102,157,new Integer[] {2,8,18,32,32,8,2}));
	}
}

