package com.yanis48.fabriblocks.init;

import com.yanis48.fabriblocks.blocks.FBBlock;
import com.yanis48.fabriblocks.blocks.FBBlockPillar;
import com.yanis48.fabriblocks.blocks.FBDoor;
import com.yanis48.fabriblocks.blocks.FBSlab;
import com.yanis48.fabriblocks.blocks.FBStairs;
import com.yanis48.fabriblocks.blocks.FBWall;

public class ModBlocks {
	
	public static FBBlock SCUTE_BLOCK;
	public static FBBlockPillar BAMBOO_BLOCK;
	public static FBBlock GRANITE_TILING;
	public static FBBlock DIORITE_TILING;
	public static FBBlock ANDESITE_TILING;
	public static FBBlock DECORATED_SANDSTONE;
	public static FBBlock MOSSY_BRICKS;
	public static FBBlock SNOW_BRICKS;
	public static FBStairs SNOW_BRICK_STAIRS;
	public static FBSlab SNOW_BRICK_SLAB;
	public static FBWall SNOW_BRICK_WALL;
	public static FBWall STONE_WALL;
	public static FBWall SMOOTH_STONE_WALL;
	public static FBWall SMOOTH_SANDSTONE_WALL;
	public static FBWall SMOOTH_RED_SANDSTONE_WALL;
	public static FBWall POLISHED_GRANITE_WALL;
	public static FBWall POLISHED_DIORITE_WALL;
	public static FBWall POLISHED_ANDESITE_WALL;
	public static FBWall QUARTZ_WALL;
	public static FBWall PRISMARINE_BRICK_WALL;
	public static FBWall DARK_PRISMARINE_WALL;
	public static FBWall PURPUR_WALL;
	public static FBDoor GLASS_DOOR;
	
	public static void init() {
		
		SCUTE_BLOCK = new FBBlock("scute_block", 1.0f, 5.0f);
		
		BAMBOO_BLOCK = new FBBlockPillar("bamboo_block", 0.5f, 2.5f);
		
		GRANITE_TILING = new FBBlock("granite_tiling", 1.5f, 6.0f);
		DIORITE_TILING = new FBBlock("diorite_tiling", 1.5f, 6.0f);
		ANDESITE_TILING = new FBBlock("andesite_tiling", 1.5f, 6.0f);
		DECORATED_SANDSTONE = new FBBlock("decorated_sandstone", 0.8f, 4.0f);
		MOSSY_BRICKS = new FBBlock("mossy_bricks", 2.0f, 6.0f);
		
		SNOW_BRICKS = new FBBlock("snow_bricks", 1.5f, 30.0f);
		SNOW_BRICK_STAIRS = new FBStairs(SNOW_BRICKS.getDefaultState(), "snow_brick_stairs", 1.5f, 30.0f);
		SNOW_BRICK_SLAB = new FBSlab("snow_brick_slab", 1.5f, 30.0f);
		SNOW_BRICK_WALL = new FBWall("snow_brick_wall", 1.5f, 30.0f);
		
		STONE_WALL = new FBWall("stone_wall", 1.5f, 30.0f);
		SMOOTH_STONE_WALL = new FBWall("smooth_stone_wall", 1.5f, 30.0f);
		SMOOTH_SANDSTONE_WALL = new FBWall("smooth_sandstone_wall", 0.8f, 4.0f);
		SMOOTH_RED_SANDSTONE_WALL = new FBWall("smooth_red_sandstone_wall", 0.8f, 4.0f);
		POLISHED_GRANITE_WALL = new FBWall("polished_granite_wall", 1.5f, 30.0f);
		POLISHED_DIORITE_WALL = new FBWall("polished_diorite_wall", 1.5f, 30.0f);
		POLISHED_ANDESITE_WALL = new FBWall("polished_andesite_wall", 1.5f, 30.0f);
		QUARTZ_WALL = new FBWall("quartz_wall", 0.8f, 4.0f);
		PRISMARINE_BRICK_WALL = new FBWall("prismarine_brick_wall", 1.5f, 30.0f);
		DARK_PRISMARINE_WALL = new FBWall("dark_prismarine_wall", 1.5f, 30.0f);
		PURPUR_WALL = new FBWall("purpur_wall", 1.5f, 30.0f);
		
		GLASS_DOOR = new FBDoor("glass_door", 0.3f, 1.5f);
		
	}

}
