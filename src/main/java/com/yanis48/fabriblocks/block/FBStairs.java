package com.yanis48.fabriblocks.block;

import com.yanis48.fabriblocks.FabriBlocks;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FBStairs extends StairsBlock {

	public FBStairs(BlockState state, String name, float hardness, float resistance) {
		super(state, FabricBlockSettings.of(Material.STONE).strength(hardness, resistance).build());
		Registry.BLOCK.register(new Identifier(FabriBlocks.MOD_ID, name), this);
		Registry.ITEM.register(new Identifier(FabriBlocks.MOD_ID, name), new BlockItem(this, new Item.Settings().stackSize(64).itemGroup(ItemGroup.BUILDING_BLOCKS)));
	}

}
