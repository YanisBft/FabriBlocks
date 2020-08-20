package com.yanisbft.fabriblocks.block;

import com.yanisbft.fabriblocks.FabriBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FBSlab extends SlabBlock {
	
	public FBSlab(String name, float hardness, float resistance) {
		super(FabricBlockSettings.of(Material.STONE).strength(hardness, resistance));
		Registry.register(Registry.BLOCK, new Identifier(FabriBlocks.MOD_ID, name), this);
		Registry.register(Registry.ITEM, new Identifier(FabriBlocks.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(ItemGroup.BUILDING_BLOCKS)));
	}
}
