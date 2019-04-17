package com.yanis48.fabriblocks;

import com.yanis48.fabriblocks.init.ModBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.block.BlockColorMapper;
import net.minecraft.client.render.item.ItemColorMapper;

public class FabriBlocksClient implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		
		registerBlockColor(ModBlocks.OAK_LEAF_CARPET, Blocks.OAK_LEAVES);
		registerBlockColor(ModBlocks.SPRUCE_LEAF_CARPET, Blocks.SPRUCE_LEAVES);
		registerBlockColor(ModBlocks.BIRCH_LEAF_CARPET, Blocks.BIRCH_LEAVES);
		registerBlockColor(ModBlocks.JUNGLE_LEAF_CARPET, Blocks.JUNGLE_LEAVES);
		registerBlockColor(ModBlocks.ACACIA_LEAF_CARPET, Blocks.ACACIA_LEAVES);
		registerBlockColor(ModBlocks.DARK_OAK_LEAF_CARPET, Blocks.DARK_OAK_LEAVES);
		
	}
	
	public void registerBlockColor(Block block, Block templateBlock) {
		ColorProviderRegistry.BLOCK.register((block1, pos, world, layer) -> {
			BlockColorMapper provider = ColorProviderRegistry.BLOCK.get(templateBlock);
			return provider == null ? -1 : provider.getColor(block1, pos, world, layer);
		}, block);

		ColorProviderRegistry.ITEM.register((item, layer) -> {
			ItemColorMapper provider = ColorProviderRegistry.ITEM.get(templateBlock);
			return provider == null ? -1 : provider.getColor(item, layer);
		}, block.getItem());
	}

}
