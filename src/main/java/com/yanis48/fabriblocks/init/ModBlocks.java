package com.yanis48.fabriblocks.init;

import com.yanis48.fabriblocks.block.FBBlock;
import com.yanis48.fabriblocks.block.FBBlockPillar;
import com.yanis48.fabriblocks.block.FBBookshelf;
import com.yanis48.fabriblocks.block.FBDoor;
import com.yanis48.fabriblocks.block.FBFence;
import com.yanis48.fabriblocks.block.FBLeafCarpet;
import com.yanis48.fabriblocks.block.FBLectern;
import com.yanis48.fabriblocks.block.FBSlab;
import com.yanis48.fabriblocks.block.FBStairs;
import com.yanis48.fabriblocks.block.FBWall;

public class ModBlocks {
	
	public static FBBlock SCUTE_BLOCK;
	public static FBBlockPillar BAMBOO_BLOCK;
	public static FBBlock GRANITE_TILING;
	public static FBBlock DIORITE_TILING;
	public static FBBlock ANDESITE_TILING;
	public static FBBlock GRANITE_DIORITE_TILING;
	public static FBBlock DIORITE_ANDESITE_TILING;
	public static FBBlock ANDESITE_GRANITE_TILING;
	public static FBBlock DECORATED_SANDSTONE;
	public static FBBookshelf SPRUCE_BOOKSHELF;
	public static FBBookshelf BIRCH_BOOKSHELF;
	public static FBBookshelf JUNGLE_BOOKSHELF;
	public static FBBookshelf ACACIA_BOOKSHELF;
	public static FBBookshelf DARK_OAK_BOOKSHELF;
	public static FBBlock MOSSY_BRICKS;
	public static FBStairs MOSSY_BRICK_STAIRS;
	public static FBSlab MOSSY_BRICK_SLAB;
	public static FBWall MOSSY_BRICK_WALL;
	public static FBBlock SNOW_BRICKS;
	public static FBStairs SNOW_BRICK_STAIRS;
	public static FBSlab SNOW_BRICK_SLAB;
	public static FBWall SNOW_BRICK_WALL;
	public static FBWall STONE_WALL;
	public static FBWall SMOOTH_STONE_WALL;
	public static FBWall SMOOTH_SANDSTONE_WALL;
	public static FBWall SMOOTH_RED_SANDSTONE_WALL;
	public static FBWall SMOOTH_QUARTZ_WALL;
	public static FBWall POLISHED_GRANITE_WALL;
	public static FBWall POLISHED_DIORITE_WALL;
	public static FBWall POLISHED_ANDESITE_WALL;
	public static FBWall QUARTZ_WALL;
	public static FBWall PRISMARINE_BRICK_WALL;
	public static FBWall DARK_PRISMARINE_WALL;
	public static FBWall PURPUR_WALL;
	public static FBLeafCarpet OAK_LEAF_CARPET;
	public static FBLeafCarpet SPRUCE_LEAF_CARPET;
	public static FBLeafCarpet BIRCH_LEAF_CARPET;
	public static FBLeafCarpet JUNGLE_LEAF_CARPET;
	public static FBLeafCarpet ACACIA_LEAF_CARPET;
	public static FBLeafCarpet DARK_OAK_LEAF_CARPET;
	public static FBFence RED_NETHER_BRICK_FENCE;
	public static FBLectern SPRUCE_LECTERN;
	public static FBLectern BIRCH_LECTERN;
	public static FBLectern JUNGLE_LECTERN;
	public static FBLectern ACACIA_LECTERN;
	public static FBLectern DARK_OAK_LECTERN;
	public static FBDoor GLASS_DOOR;
	
	public static void init() {
		
		SCUTE_BLOCK = new FBBlock("scute_block", 1.0f, 5.0f);
		
		BAMBOO_BLOCK = new FBBlockPillar("bamboo_block", 0.5f, 2.5f);
		
		GRANITE_TILING = new FBBlock("granite_tiling", 1.5f, 6.0f);
		DIORITE_TILING = new FBBlock("diorite_tiling", 1.5f, 6.0f);
		ANDESITE_TILING = new FBBlock("andesite_tiling", 1.5f, 6.0f);
		GRANITE_DIORITE_TILING = new FBBlock("granite_diorite_tiling", 1.5f, 6.0f);
		DIORITE_ANDESITE_TILING = new FBBlock("diorite_andesite_tiling", 1.5f, 6.0f);
		ANDESITE_GRANITE_TILING = new FBBlock("andesite_granite_tiling", 1.5f, 6.0f);
		DECORATED_SANDSTONE = new FBBlock("decorated_sandstone", 0.8f, 4.0f);
		
		SPRUCE_BOOKSHELF = new FBBookshelf("spruce_bookshelf");
		BIRCH_BOOKSHELF = new FBBookshelf("birch_bookshelf");
		JUNGLE_BOOKSHELF = new FBBookshelf("jungle_bookshelf");
		ACACIA_BOOKSHELF = new FBBookshelf("acacia_bookshelf");
		DARK_OAK_BOOKSHELF = new FBBookshelf("dark_oak_bookshelf");
		
		MOSSY_BRICKS = new FBBlock("mossy_bricks", 2.0f, 6.0f);
		MOSSY_BRICK_STAIRS = new FBStairs(MOSSY_BRICKS.getDefaultState(), "mossy_brick_stairs", 2.0f, 6.0f);
		MOSSY_BRICK_SLAB = new FBSlab("mossy_brick_slab", 2.0f, 6.0f);
		MOSSY_BRICK_WALL = new FBWall("mossy_brick_wall", 2.0f, 6.0f);
		SNOW_BRICKS = new FBBlock("snow_bricks", 1.5f, 30.0f);
		SNOW_BRICK_STAIRS = new FBStairs(SNOW_BRICKS.getDefaultState(), "snow_brick_stairs", 1.5f, 30.0f);
		SNOW_BRICK_SLAB = new FBSlab("snow_brick_slab", 1.5f, 30.0f);
		SNOW_BRICK_WALL = new FBWall("snow_brick_wall", 1.5f, 30.0f);
		
		STONE_WALL = new FBWall("stone_wall", 1.5f, 30.0f);
		SMOOTH_STONE_WALL = new FBWall("smooth_stone_wall", 1.5f, 30.0f);
		SMOOTH_SANDSTONE_WALL = new FBWall("smooth_sandstone_wall", 0.8f, 4.0f);
		SMOOTH_RED_SANDSTONE_WALL = new FBWall("smooth_red_sandstone_wall", 0.8f, 4.0f);
		SMOOTH_QUARTZ_WALL = new FBWall("smooth_quartz_wall", 0.8f, 4.0f);
		POLISHED_GRANITE_WALL = new FBWall("polished_granite_wall", 1.5f, 30.0f);
		POLISHED_DIORITE_WALL = new FBWall("polished_diorite_wall", 1.5f, 30.0f);
		POLISHED_ANDESITE_WALL = new FBWall("polished_andesite_wall", 1.5f, 30.0f);
		QUARTZ_WALL = new FBWall("quartz_wall", 0.8f, 4.0f);
		PRISMARINE_BRICK_WALL = new FBWall("prismarine_brick_wall", 1.5f, 30.0f);
		DARK_PRISMARINE_WALL = new FBWall("dark_prismarine_wall", 1.5f, 30.0f);
		PURPUR_WALL = new FBWall("purpur_wall", 1.5f, 30.0f);
		
		OAK_LEAF_CARPET = new FBLeafCarpet("oak_leaf_carpet");
		SPRUCE_LEAF_CARPET = new FBLeafCarpet("spruce_leaf_carpet");
		BIRCH_LEAF_CARPET = new FBLeafCarpet("birch_leaf_carpet");
		JUNGLE_LEAF_CARPET = new FBLeafCarpet("jungle_leaf_carpet");
		ACACIA_LEAF_CARPET = new FBLeafCarpet("acacia_leaf_carpet");
		DARK_OAK_LEAF_CARPET = new FBLeafCarpet("dark_oak_leaf_carpet");
		
		RED_NETHER_BRICK_FENCE = new FBFence("red_nether_brick_fence", 2.0f, 6.0f);
		
		SPRUCE_LECTERN = new FBLectern("spruce_lectern");
		BIRCH_LECTERN = new FBLectern("birch_lectern");
		JUNGLE_LECTERN = new FBLectern("jungle_lectern");
		ACACIA_LECTERN = new FBLectern("acacia_lectern");
		DARK_OAK_LECTERN = new FBLectern("dark_oak_lectern");
		
		GLASS_DOOR = new FBDoor("glass_door", 0.3f, 1.5f);
	}

}
