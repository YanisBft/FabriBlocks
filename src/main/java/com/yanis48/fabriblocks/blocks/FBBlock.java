package com.yanis48.fabriblocks.blocks;

import com.yanis48.fabriblocks.FabriBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FBBlock extends Block {

	public FBBlock(String name, float hardness, float resistance) {
		super(Block.Settings.of(Material.STONE).strength(hardness, resistance));
		Registry.BLOCK.register(new Identifier(FabriBlocks.MOD_ID, name), this);
		Registry.ITEM.register(new Identifier(FabriBlocks.MOD_ID, name), new BlockItem(this, new Item.Settings().stackSize(64).itemGroup(ItemGroup.BUILDING_BLOCKS)));
	}
	
}
