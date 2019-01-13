package com.yanis48.fabriblocks;

import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class FabriBlocks implements ModInitializer {
	
	public static final String MOD_ID = "fabriblocks";
	public static final String VERSION = "1.0";
	public static final String NAME = "FabriBlocks";
	public static Logger logger;
	
	@Override
	public void onInitialize() {
		ModBlocks.init();
	}
}
