package com.yanis48.fabriblocks.init;

import com.yanis48.fabriblocks.FabriBlocks;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModItemTags {
	
	public static final Tag<Item> BOOKSHELVES = register("bookshelves");
	public static final Tag<Item> LECTERNS = register("lecterns");
	
	public static Tag<Item> register(String id) {
		return TagRegistry.item(new Identifier(FabriBlocks.MOD_ID, id));
	}
}
