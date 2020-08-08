package com.yanis48.fabriblocks.block;

import com.yanis48.fabriblocks.FabriBlocks;
import com.yanis48.fabriblocks.block.entity.FBLecternBlockEntity;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.LecternBlock;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.tag.ItemTags;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class FBLectern extends LecternBlock {

	public FBLectern(String name) {
		super(FabricBlockSettings.of(Material.WOOD).strength(2.5f, 1.0f));
		Registry.register(Registry.BLOCK, new Identifier(FabriBlocks.MOD_ID, name), this);
		Registry.register(Registry.ITEM, new Identifier(FabriBlocks.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(ItemGroup.REDSTONE)));
	}
	
	@Override
	public BlockEntity createBlockEntity(BlockView blockView) {
		return new FBLecternBlockEntity();
	}
	
	public static boolean putBookIfAbsent(World world, BlockPos pos, BlockState state, ItemStack stack) {
		if (!state.get(HAS_BOOK)) {
			if (!world.isClient) {
				putBook(world, pos, state, stack);
			}
			return true;
		} else {
			return false;
		}
	}
	
	private static void putBook(World world, BlockPos pos, BlockState state, ItemStack stack) {
		BlockEntity be = world.getBlockEntity(pos);
		if (be instanceof FBLecternBlockEntity) {
			FBLecternBlockEntity lecternBe = (FBLecternBlockEntity)be;
			lecternBe.setBook(stack.split(1));
			setHasBook(world, pos, state, true);
			world.playSound(null, pos, SoundEvents.ITEM_BOOK_PUT, SoundCategory.BLOCKS, 1.0F, 1.0F);
		}
	}
	
	@Override
	public void onStateReplaced(BlockState state_1, World world, BlockPos pos, BlockState state_2, boolean boolean_1) {
		if (state_1.getBlock() != state_2.getBlock()) {
			if (state_1.get(HAS_BOOK)) {
				this.dropBook(state_1, world, pos);
			}
			if (state_1.get(POWERED)) {
				world.updateNeighborsAlways(pos.down(), this);
			}
			super.onStateReplaced(state_1, world, pos, state_2, boolean_1);
		}
	}
	
	private void dropBook(BlockState state, World world, BlockPos pos) {
		BlockEntity be = world.getBlockEntity(pos);
		if (be instanceof FBLecternBlockEntity) {
			FBLecternBlockEntity lecternBe = (FBLecternBlockEntity)be;
			Direction direction_1 = state.get(FACING);
			ItemStack stack = lecternBe.getBook().copy();
			float float_1 = 0.25F * (float)direction_1.getOffsetX();
			float float_2 = 0.25F * (float)direction_1.getOffsetZ();
			ItemEntity itemEntity_1 = new ItemEntity(world, (double)pos.getX() + 0.5D + (double)float_1, (double)(pos.getY() + 1), (double)pos.getZ() + 0.5D + (double)float_2, stack);
			itemEntity_1.setToDefaultPickupDelay();
			world.spawnEntity(itemEntity_1);
			lecternBe.clear();
		}
	}
	
	public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
		if (state.get(HAS_BOOK)) {
			BlockEntity be = world.getBlockEntity(pos);
			if (be instanceof FBLecternBlockEntity) {
				return ((FBLecternBlockEntity)be).getComparatorOutput();
			}
		}
		return 0;
	}
	
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
		if (state.get(HAS_BOOK)) {
			if (!world.isClient) {
				this.openContainer(world, pos, player);
			}
			return ActionResult.SUCCESS;
		} else {
			ItemStack stack = player.getStackInHand(hand);
			return !stack.isEmpty() && !stack.getItem().isIn(ItemTags.LECTERN_BOOKS) ? ActionResult.CONSUME : ActionResult.PASS;
		}
	}
	
	private void openContainer(World world, BlockPos pos, PlayerEntity player) {
		BlockEntity be = world.getBlockEntity(pos);
		if (be instanceof FBLecternBlockEntity) {
			player.openHandledScreen((FBLecternBlockEntity)be);
			player.incrementStat(Stats.INTERACT_WITH_LECTERN);
		}
	}
}
