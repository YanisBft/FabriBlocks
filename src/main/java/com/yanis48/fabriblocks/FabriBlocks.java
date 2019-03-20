package com.yanis48.fabriblocks;

import com.yanis48.fabriblocks.init.ModBlockTags;
import com.yanis48.fabriblocks.init.ModBlocks;
import com.yanis48.fabriblocks.init.ModItemTags;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class FabriBlocks implements ModInitializer {
	
	public static final String MOD_ID = "fabriblocks";
	
	@Override
	public void onInitialize() {
		ModBlocks.init();
		
		FuelRegistry.INSTANCE.add(ModItemTags.BOOKSHELVES, 300);
		FuelRegistry.INSTANCE.add(ModItemTags.LECTERNS, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.BAMBOO_BLOCK, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.BAMBOO_TRAPDOOR, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.BAMBOO_DOOR, 200);
		
		FlammableBlockRegistry.getDefaultInstance().add(ModBlockTags.LEAF_CARPETS, 60, 100);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlockTags.BOOKSHELVES, 30, 20);
		
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.OAK_LEAF_CARPET, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.SPRUCE_LEAF_CARPET, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.BIRCH_LEAF_CARPET, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.JUNGLE_LEAF_CARPET, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.ACACIA_LEAF_CARPET, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.DARK_OAK_LEAF_CARPET, 0.1f);
	}
}
