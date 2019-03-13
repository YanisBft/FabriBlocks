package com.yanis48.fabriblocks.init;

import com.yanis48.fabriblocks.FabriBlocks;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModBlockTags {
	
	public static final Tag<Block> LECTERNS = register("lecterns");
	
	public static Tag<Block> register(String id) {
		return TagRegistry.block(new Identifier(FabriBlocks.MOD_ID, id));
	}
}
