package com.yanisbft.fabriblocks.block;

import com.yanisbft.fabriblocks.FabriBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class FBTrapdoor extends TrapdoorBlock {
	
	public FBTrapdoor(String name, Material material, BlockSoundGroup soundGroup, float hardness, float resistance) {
		super(FabricBlockSettings.of(material).sounds(soundGroup).strength(hardness, resistance).nonOpaque());
		Registry.register(Registry.BLOCK, new Identifier(FabriBlocks.MOD_ID, name), this);
		Registry.register(Registry.ITEM, new Identifier(FabriBlocks.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(ItemGroup.REDSTONE)));
	}
	
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
		state = state.cycle(OPEN);
		world.setBlockState(pos, state, 10);
		if (state.get(WATERLOGGED)) {
			world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		}
		world.playSound(player, pos, state.get(OPEN) ? SoundEvents.BLOCK_BAMBOO_BREAK : SoundEvents.BLOCK_BAMBOO_PLACE, SoundCategory.BLOCKS, 1.0F, world.random.nextFloat() * 0.1F + 0.9F);
		return ActionResult.SUCCESS;
	}
}
