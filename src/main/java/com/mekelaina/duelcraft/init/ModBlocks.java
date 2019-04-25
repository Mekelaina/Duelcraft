package com.mekelaina.duelcraft.init;

import java.util.ArrayList;
import java.util.List;

import com.mekelaina.duelcraft.blocks.BlockBase;
import com.mekelaina.duelcraft.blocks.BlockCardCase;
import com.mekelaina.duelcraft.blocks.BlockCardPrinter;
import com.mekelaina.duelcraft.blocks.BlockCardTable;
import com.mekelaina.duelcraft.blocks.BlockKaibalium;
import com.mekelaina.duelcraft.blocks.BlockOreBase;
import com.mekelaina.duelcraft.blocks.rarityalter.BlockRarityCore;
import com.mekelaina.duelcraft.blocks.rarityalter.BlockRarityPillar;
import com.mekelaina.duelcraft.util.enums.EnumGlassTypes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final List<TileEntity> TILE_ENTITIES = new ArrayList<TileEntity>();
	
	public static final Block KAIBALIUM_BLOCK = new BlockKaibalium("kaibalium_block", Material.IRON);
	public static final Block CARD_TABLE_CLEAR_GLASS = new BlockCardTable("card_table_clear_glass", Material.WOOD, EnumGlassTypes.CLEAR);	
	public static final Block CARD_TABLE_WHITE_GLASS = new BlockCardTable("card_table_white_glass", Material.WOOD, EnumGlassTypes.WHITE);
	public static final Block CARD_TABLE_ORANGE_GLASS = new BlockCardTable("card_table_orange_glass", Material.WOOD, EnumGlassTypes.ORANGE);
	public static final Block CARD_TABLE_MAGENTA_GLASS = new BlockCardTable("card_table_magenta_glass", Material.WOOD, EnumGlassTypes.MAGENTA);
	public static final Block CARD_TABLE_LIGHT_BLUE_GLASS = new BlockCardTable("card_table_light_blue_glass", Material.WOOD, EnumGlassTypes.LIGHT_BLUE);
	public static final Block CARD_TABLE_YELLOW_GLASS = new BlockCardTable("card_table_yellow_glass", Material.WOOD, EnumGlassTypes.YELLOW);
	public static final Block CARD_TABLE_LIME_GLASS = new BlockCardTable("card_table_lime_glass", Material.WOOD, EnumGlassTypes.LIME);
	public static final Block CARD_TABLE_PINK_GLASS = new BlockCardTable("card_table_pink_glass", Material.WOOD, EnumGlassTypes.PINK);
	public static final Block CARD_TABLE_GREY_GLASS = new BlockCardTable("card_table_grey_glass", Material.WOOD, EnumGlassTypes.GREY);
	public static final Block CARD_TABLE_SILVER_GLASS = new BlockCardTable("card_table_silver_glass", Material.WOOD, EnumGlassTypes.SILVER);
	public static final Block CARD_TABLE_CYAN_GLASS = new BlockCardTable("card_table_cyan_glass", Material.WOOD, EnumGlassTypes.CYAN);
	public static final Block CARD_TABLE_PURPLE_GLASS = new BlockCardTable("card_table_purple_glass", Material.WOOD, EnumGlassTypes.PURPLE);
	public static final Block CARD_TABLE_BLUE_GLASS = new BlockCardTable("card_table_blue_glass", Material.WOOD, EnumGlassTypes.BLUE);
	public static final Block CARD_TABLE_BROWN_GLASS = new BlockCardTable("card_table_brown_glass", Material.WOOD, EnumGlassTypes.BROWN);
	public static final Block CARD_TABLE_GREEN_GLASS = new BlockCardTable("card_table_green_glass", Material.WOOD, EnumGlassTypes.GREEN);
	public static final Block CARD_TABLE_RED_GLASS = new BlockCardTable("card_table_red_glass", Material.WOOD, EnumGlassTypes.RED);
	public static final Block CARD_TABLE_BLACK_GLASS = new BlockCardTable("card_table_black_glass", Material.WOOD, EnumGlassTypes.BLACK);
	
	public static final BlockOre KAIBA_CRYSTAL_ORE = new BlockOreBase("kaiba_crystal_ore", "oreKaibaCrystal");
	
	public static final Block RARITY_PILLAR = new BlockRarityPillar("rarity_pillar", Material.ROCK);
	public static final Block RARITY_CORE = new BlockRarityCore("rarity_core", Material.ROCK);
	public static final Block CARD_CASE = new BlockCardCase("card_case", Material.ROCK);
	public static final Block CARD_PRINTER = new BlockCardPrinter("card_printer", Material.IRON);
}
