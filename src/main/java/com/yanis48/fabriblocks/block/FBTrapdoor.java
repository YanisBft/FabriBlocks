package com.yanis48.fabriblocks.block;

import com.yanis48.fabriblocks.FabriBlocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.block.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class FBTrapdoor extends TrapdoorBlock {
	
	public FBTrapdoor(String name, Material material, BlockSoundGroup soundGroup, float hardness, float resistance) {
		super(FabricBlockSettings.of(material).sounds(soundGroup).strength(hardness, resistance).build());
		Registry.register(Registry.BLOCK, new Identifier(FabriBlocks.MOD_ID, name), this);
		Registry.register(Registry.ITEM, new Identifier(FabriBlocks.MOD_ID, name), new BlockItem(this, new Item.Settings().stackSize(64).itemGroup(ItemGroup.REDSTONE)));
	}
	
	@Override
	public boolean activate(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult blockHitResult) {
		blockState = blockState.method_11572(OPEN);
		world.setBlockState(blockPos, blockState, 10);
		world.playSound(playerEntity, blockPos, blockState.get(OPEN) ? SoundEvents.BLOCK_BAMBOO_BREAK : SoundEvents.BLOCK_BAMBOO_PLACE, SoundCategory.BLOCKS, 1.0F, world.random.nextFloat() * 0.1F + 0.9F);
		return true;
	}
}
