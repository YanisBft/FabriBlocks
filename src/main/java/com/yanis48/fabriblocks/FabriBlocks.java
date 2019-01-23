package com.yanis48.fabriblocks;

import com.yanis48.fabriblocks.init.ModBlocks;

import net.fabricmc.api.ModInitializer;

public class FabriBlocks implements ModInitializer {
	
	public static final String MOD_ID = "fabriblocks";
	public static final String VERSION = "1.0.2";
	public static final String NAME = "FabriBlocks";
	
	@Override
	public void onInitialize() {
		ModBlocks.init();
	}
}
