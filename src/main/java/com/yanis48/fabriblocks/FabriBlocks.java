package com.yanis48.fabriblocks;

import com.yanis48.fabriblocks.init.ModBlocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class FabriBlocks implements ModInitializer {
	
	public static final String MOD_ID = "fabriblocks";
	public static final String VERSION = "1.0.3";
	public static final String NAME = "FabriBlocks";
	
	@Override
	public void onInitialize() {
		ModBlocks.init();
		
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.OAK_LEAF_CARPET, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.SPRUCE_LEAF_CARPET, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.BIRCH_LEAF_CARPET, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.JUNGLE_LEAF_CARPET, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.ACACIA_LEAF_CARPET, 0.1f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.DARK_OAK_LEAF_CARPET, 0.1f);
	}
}
