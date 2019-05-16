package com.yanis48.fabriblocks.init;

import com.yanis48.fabriblocks.block.FBBlock;
import com.yanis48.fabriblocks.block.FBBlockPillar;
import com.yanis48.fabriblocks.block.FBBookshelf;
import com.yanis48.fabriblocks.block.FBButton;
import com.yanis48.fabriblocks.block.FBDoor;
import com.yanis48.fabriblocks.block.FBFence;
import com.yanis48.fabriblocks.block.FBLeafCarpet;
import com.yanis48.fabriblocks.block.FBLectern;
import com.yanis48.fabriblocks.block.FBPressurePlate;
import com.yanis48.fabriblocks.block.FBSlab;
import com.yanis48.fabriblocks.block.FBStairs;
import com.yanis48.fabriblocks.block.FBTrapdoor;
import com.yanis48.fabriblocks.block.FBWall;

import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {
	
	public static final FBBlock SCUTE_BLOCK = new FBBlock("scute_block", 1.0f, 5.0f);
	
	public static final FBBlockPillar BAMBOO_BLOCK = new FBBlockPillar("bamboo_block", Material.BAMBOO, BlockSoundGroup.BAMBOO_SAPLING, 0.5f, 2.5f);
	
	public static final FBBlock GRANITE_TILING = new FBBlock("granite_tiling", 1.5f, 6.0f);
	public static final FBBlock DIORITE_TILING = new FBBlock("diorite_tiling", 1.5f, 6.0f);
	public static final FBBlock ANDESITE_TILING = new FBBlock("andesite_tiling", 1.5f, 6.0f);
	public static final FBBlock GRANITE_DIORITE_TILING = new FBBlock("granite_diorite_tiling", 1.5f, 6.0f);
	public static final FBBlock DIORITE_ANDESITE_TILING = new FBBlock("diorite_andesite_tiling", 1.5f, 6.0f);
	public static final FBBlock ANDESITE_GRANITE_TILING = new FBBlock("andesite_granite_tiling", 1.5f, 6.0f);
	public static final FBBlock DECORATED_SANDSTONE = new FBBlock("decorated_sandstone", 0.8f, 4.0f);
	public static final FBBlockPillar NETHER_BRICK_PILLAR = new FBBlockPillar("nether_brick_pillar", Material.STONE, BlockSoundGroup.STONE, 2.0f, 6.0f);
	public static final FBBlockPillar RED_NETHER_BRICK_PILLAR = new FBBlockPillar("red_nether_brick_pillar", Material.STONE, BlockSoundGroup.STONE, 2.0f, 6.0f);
	
	public static final FBBookshelf SPRUCE_BOOKSHELF = new FBBookshelf("spruce_bookshelf");
	public static final FBBookshelf BIRCH_BOOKSHELF = new FBBookshelf("birch_bookshelf");
	public static final FBBookshelf JUNGLE_BOOKSHELF = new FBBookshelf("jungle_bookshelf");
	public static final FBBookshelf ACACIA_BOOKSHELF = new FBBookshelf("acacia_bookshelf");
	public static final FBBookshelf DARK_OAK_BOOKSHELF = new FBBookshelf("dark_oak_bookshelf");
	
	public static final FBBlock MOSSY_BRICKS = new FBBlock("mossy_bricks", 2.0f, 6.0f);
	public static final FBStairs MOSSY_BRICK_STAIRS = new FBStairs(MOSSY_BRICKS.getDefaultState(), "mossy_brick_stairs", 2.0f, 6.0f);
	public static final FBSlab MOSSY_BRICK_SLAB = new FBSlab("mossy_brick_slab", 2.0f, 6.0f);
	public static final FBBlock SNOW_BRICKS = new FBBlock("snow_bricks", 1.5f, 30.0f);
	public static final FBStairs SNOW_BRICK_STAIRS = new FBStairs(SNOW_BRICKS.getDefaultState(), "snow_brick_stairs", 1.5f, 30.0f);
	public static final FBSlab SNOW_BRICK_SLAB = new FBSlab("snow_brick_slab", 1.5f, 30.0f);
	public static final FBStairs SMOOTH_STONE_STAIRS = new FBStairs(Blocks.SMOOTH_STONE.getDefaultState(), "smooth_stone_stairs", 1.5f, 30.0f);
	public static final FBStairs CUT_SANDSTONE_STAIRS = new FBStairs(Blocks.CUT_SANDSTONE.getDefaultState(), "cut_sandstone_stairs", 0.8f, 4.0f);
	public static final FBStairs CUT_RED_SANDSTONE_STAIRS = new FBStairs(Blocks.CUT_RED_SANDSTONE.getDefaultState(), "cut_red_sandstone_stairs", 0.8f, 4.0f);
	public static final FBStairs CRACKED_STONE_BRICK_STAIRS = new FBStairs(Blocks.CRACKED_STONE_BRICKS.getDefaultState(), "cracked_stone_brick_stairs", 1.5f, 30.0f);
	public static final FBSlab CRACKED_STONE_BRICK_SLAB = new FBSlab("cracked_stone_brick_slab", 1.5f, 30.0f);
	
	public static final FBLeafCarpet OAK_LEAF_CARPET = new FBLeafCarpet("oak_leaf_carpet");
	public static final FBLeafCarpet SPRUCE_LEAF_CARPET = new FBLeafCarpet("spruce_leaf_carpet");
	public static final FBLeafCarpet BIRCH_LEAF_CARPET = new FBLeafCarpet("birch_leaf_carpet");
	public static final FBLeafCarpet JUNGLE_LEAF_CARPET = new FBLeafCarpet("jungle_leaf_carpet");
	public static final FBLeafCarpet ACACIA_LEAF_CARPET = new FBLeafCarpet("acacia_leaf_carpet");
	public static final FBLeafCarpet DARK_OAK_LEAF_CARPET = new FBLeafCarpet("dark_oak_leaf_carpet");
	
	public static final FBFence RED_NETHER_BRICK_FENCE = new FBFence("red_nether_brick_fence", 2.0f, 6.0f);
	
	public static final FBWall STONE_WALL = new FBWall("stone_wall", 1.5f, 30.0f);
	public static final FBWall SMOOTH_STONE_WALL = new FBWall("smooth_stone_wall", 1.5f, 30.0f);
	public static final FBWall SMOOTH_SANDSTONE_WALL = new FBWall("smooth_sandstone_wall", 0.8f, 4.0f);
	public static final FBWall SMOOTH_RED_SANDSTONE_WALL = new FBWall("smooth_red_sandstone_wall", 0.8f, 4.0f);
	public static final FBWall SMOOTH_QUARTZ_WALL = new FBWall("smooth_quartz_wall", 0.8f, 4.0f);
	public static final FBWall POLISHED_GRANITE_WALL = new FBWall("polished_granite_wall", 1.5f, 30.0f);
	public static final FBWall POLISHED_DIORITE_WALL = new FBWall("polished_diorite_wall", 1.5f, 30.0f);
	public static final FBWall POLISHED_ANDESITE_WALL = new FBWall("polished_andesite_wall", 1.5f, 30.0f);
	public static final FBWall CRACKED_STONE_BRICK_WALL = new FBWall("cracked_stone_brick_wall", 1.5f, 30.0f);
	public static final FBWall QUARTZ_WALL = new FBWall("quartz_wall", 0.8f, 4.0f);
	public static final FBWall PRISMARINE_BRICK_WALL = new FBWall("prismarine_brick_wall", 1.5f, 30.0f);
	public static final FBWall DARK_PRISMARINE_WALL = new FBWall("dark_prismarine_wall", 1.5f, 30.0f);
	public static final FBWall PURPUR_WALL = new FBWall("purpur_wall", 1.5f, 30.0f);
	public static final FBWall MOSSY_BRICK_WALL = new FBWall("mossy_brick_wall", 2.0f, 6.0f);
	public static final FBWall SNOW_BRICK_WALL = new FBWall("snow_brick_wall", 1.5f, 30.0f);
	
	public static final FBLectern SPRUCE_LECTERN = new FBLectern("spruce_lectern");
	public static final FBLectern BIRCH_LECTERN = new FBLectern("birch_lectern");
	public static final FBLectern JUNGLE_LECTERN = new FBLectern("jungle_lectern");
	public static final FBLectern ACACIA_LECTERN = new FBLectern("acacia_lectern");
	public static final FBLectern DARK_OAK_LECTERN = new FBLectern("dark_oak_lectern");
	
	public static final FBPressurePlate GRANITE_PRESSURE_PLATE = new FBPressurePlate("granite_pressure_plate");
	public static final FBPressurePlate DIORITE_PRESSURE_PLATE = new FBPressurePlate("diorite_pressure_plate");
	public static final FBPressurePlate ANDESITE_PRESSURE_PLATE = new FBPressurePlate("andesite_pressure_plate");
	public static final FBButton GRANITE_BUTTON = new FBButton("granite_button");
	public static final FBButton DIORITE_BUTTON = new FBButton("diorite_button");
	public static final FBButton ANDESITE_BUTTON = new FBButton("andesite_button");
	
	public static final FBTrapdoor BAMBOO_TRAPDOOR = new FBTrapdoor("bamboo_trapdoor", Material.BAMBOO, BlockSoundGroup.BAMBOO_SAPLING, 0.5f, 2.5f);
	public static final FBDoor BAMBOO_DOOR = new FBDoor("bamboo_door", Material.BAMBOO, BlockSoundGroup.BAMBOO_SAPLING, 0.5f, 2.5f);
	public static final FBDoor GLASS_DOOR = new FBDoor("glass_door", Material.GLASS, BlockSoundGroup.GLASS, 0.3f, 1.5f);
}
