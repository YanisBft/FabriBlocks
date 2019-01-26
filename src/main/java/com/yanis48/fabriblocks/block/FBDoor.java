package com.yanis48.fabriblocks.block;

import com.yanis48.fabriblocks.FabriBlocks;

import net.fabricmc.fabric.block.FabricBlockSettings;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.block.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FBDoor extends DoorBlock {
	
	public FBDoor(String name, float hardness, float resistance) {
		super(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).strength(hardness, resistance).build());
		Registry.BLOCK.register(new Identifier(FabriBlocks.MOD_ID, name), this);
		Registry.ITEM.register(new Identifier(FabriBlocks.MOD_ID, name), new BlockItem(this, new Item.Settings().stackSize(64).itemGroup(ItemGroup.REDSTONE)));
	}

}
