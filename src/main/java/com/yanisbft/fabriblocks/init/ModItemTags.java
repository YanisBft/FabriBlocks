package com.yanisbft.fabriblocks.init;

import com.yanisbft.fabriblocks.FabriBlocks;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModItemTags {
	
	public static final Tag<Item> LEAF_CARPETS = register("leaf_carpets");
	public static final Tag<Item> BOOKSHELVES = register("bookshelves");
	public static final Tag<Item> LECTERNS = register("lecterns");
	
	public static Tag<Item> register(String id) {
		return TagRegistry.item(new Identifier(FabriBlocks.MOD_ID, id));
	}
}
