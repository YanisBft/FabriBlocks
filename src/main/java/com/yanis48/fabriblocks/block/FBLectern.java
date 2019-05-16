package com.yanis48.fabriblocks.block;

import java.util.Random;

import com.yanis48.fabriblocks.FabriBlocks;
import com.yanis48.fabriblocks.block.entity.FBLecternBlockEntity;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlacementEnvironment;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.container.NameableContainerProvider;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.item.BlockItem;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class FBLectern extends BlockWithEntity {
	public static final DirectionProperty FACING;
	public static final BooleanProperty POWERED;
	public static final BooleanProperty HAS_BOOK;
	public static final VoxelShape BOTTOM_SHAPE;
	public static final VoxelShape MIDDLE_SHAPE;
	public static final VoxelShape BASE_SHAPE;
	public static final VoxelShape COLLISION_SHAPE_TOP;
	public static final VoxelShape COLLISION_SHAPE;
	public static final VoxelShape WEST_SHAPE;
	public static final VoxelShape NORTH_SHAPE;
	public static final VoxelShape EAST_SHAPE;
	public static final VoxelShape SOUTH_SHAPE;

	public FBLectern(String name) {
		super(FabricBlockSettings.of(Material.WOOD).strength(2.5f, 1.0f).build());
		this.setDefaultState(this.stateFactory.getDefaultState().with(FACING, Direction.NORTH).with(POWERED, false).with(HAS_BOOK, false));
		Registry.register(Registry.BLOCK, new Identifier(FabriBlocks.MOD_ID, name), this);
		Registry.register(Registry.ITEM, new Identifier(FabriBlocks.MOD_ID, name), new BlockItem(this, new Item.Settings().stackSize(64).itemGroup(ItemGroup.REDSTONE)));
	}
	
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	public VoxelShape method_9571(BlockState state, BlockView blockView, BlockPos pos) {
		return BASE_SHAPE;
	}
	
	public boolean hasSidedTransparency(BlockState state) {
		return true;
	}
	
	public BlockState getPlacementState(ItemPlacementContext context) {
		return this.getDefaultState().with(FACING, context.getPlayerHorizontalFacing().getOpposite());
	}
	
	public VoxelShape getCollisionShape(BlockState state, BlockView blockView, BlockPos pos, EntityContext context) {
		return COLLISION_SHAPE;
	}
	
	public VoxelShape getOutlineShape(BlockState state, BlockView blockView, BlockPos pos, EntityContext context) {
		switch(state.get(FACING)) {
		case NORTH:
			return NORTH_SHAPE;
		case SOUTH:
			return SOUTH_SHAPE;
		case EAST:
			return EAST_SHAPE;
		case WEST:
			return WEST_SHAPE;
		default:
			return BASE_SHAPE;
		}
	}
	
	public BlockState rotate(BlockState state, BlockRotation rotation) {
		return state.with(FACING, rotation.rotate(state.get(FACING)));
	}
	
	public BlockState mirror(BlockState state, BlockMirror mirror) {
		return state.rotate(mirror.getRotation(state.get(FACING)));
	}
	
	protected void appendProperties(StateFactory.Builder<Block, BlockState> builder) {
		builder.add(FACING, POWERED, HAS_BOOK);
	}
	
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
	
	public static void setHasBook(World world, BlockPos pos, BlockState state, boolean boolean_1) {
		world.setBlockState(pos, state.with(POWERED, false).with(HAS_BOOK, boolean_1), 3);
		updateNeighborAlways(world, pos, state);
	}
	
	public static void setPowered(World world, BlockPos pos, BlockState state) {
		setPowered(world, pos, state, true);
		world.getBlockTickScheduler().schedule(pos, state.getBlock(), 2);
		world.playLevelEvent(1043, pos, 0);
	}
	
	private static void setPowered(World world, BlockPos pos, BlockState state, boolean boolean_1) {
		world.setBlockState(pos, state.with(POWERED, boolean_1), 3);
		updateNeighborAlways(world, pos, state);
	}
	
	private static void updateNeighborAlways(World world, BlockPos pos, BlockState state) {
		world.updateNeighborsAlways(pos.down(), state.getBlock());
	}
	
	public void onScheduledTick(BlockState state, World world, BlockPos pos, Random random_1) {
		if (!world.isClient) {
			setPowered(world, pos, state, false);
		}
	}
	
	public void onBlockRemoved(BlockState state1, World world, BlockPos pos, BlockState state2, boolean boolean_1) {
		if (state1.getBlock() != state2.getBlock()) {
			if (state1.get(HAS_BOOK)) {
				this.dropBook(state1, world, pos);
			}
			if (state1.get(POWERED)) {
				world.updateNeighborsAlways(pos.down(), this);
			}
			super.onBlockRemoved(state1, world, pos, state2, boolean_1);
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
	
	public boolean emitsRedstonePower(BlockState state) {
		return true;
	}
	
	public int getWeakRedstonePower(BlockState state, BlockView blockView, BlockPos pos, Direction direction) {
		return state.get(POWERED) ? 15 : 0;
	}
	
	public int getStrongRedstonePower(BlockState state, BlockView blockView, BlockPos pos, Direction direction) {
		return direction == Direction.UP && state.get(POWERED) ? 15 : 0;
	}
	
	public boolean hasComparatorOutput(BlockState state) {
		return true;
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
	
	public boolean activate(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
		if (state.get(HAS_BOOK)) {
			if (!world.isClient) {
				this.openContainer(world, pos, player);
			}
			return true;
		} else {
			return false;
		}
	}
	
	public NameableContainerProvider createContainerProvider(BlockState state, World world, BlockPos pos) {
		return !state.get(HAS_BOOK) ? null : super.createContainerProvider(state, world, pos);
	}
	
	private void openContainer(World world, BlockPos pos, PlayerEntity player) {
		BlockEntity be = world.getBlockEntity(pos);
		if (be instanceof FBLecternBlockEntity) {
			player.openContainer((FBLecternBlockEntity)be);
			player.incrementStat(Stats.INTERACT_WITH_LECTERN);
		}
	}
	
	public boolean canPlaceAtSide(BlockState state, BlockView blockView, BlockPos pos, BlockPlacementEnvironment placementEnvironment) {
		return false;
	}
	
	static {
		FACING = HorizontalFacingBlock.FACING;
		POWERED = Properties.POWERED;
		HAS_BOOK = Properties.HAS_BOOK;
		BOTTOM_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
		MIDDLE_SHAPE = Block.createCuboidShape(4.0D, 2.0D, 4.0D, 12.0D, 14.0D, 12.0D);
		BASE_SHAPE = VoxelShapes.union(BOTTOM_SHAPE, MIDDLE_SHAPE);
		COLLISION_SHAPE_TOP = Block.createCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 15.0D, 16.0D);
		COLLISION_SHAPE = VoxelShapes.union(BASE_SHAPE, COLLISION_SHAPE_TOP);
		WEST_SHAPE = VoxelShapes.union(Block.createCuboidShape(1.0D, 10.0D, 0.0D, 5.333333D, 14.0D, 16.0D), Block.createCuboidShape(5.333333D, 12.0D, 0.0D, 9.666667D, 16.0D, 16.0D), Block.createCuboidShape(9.666667D, 14.0D, 0.0D, 14.0D, 18.0D, 16.0D), BASE_SHAPE);
		NORTH_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 10.0D, 1.0D, 16.0D, 14.0D, 5.333333D), Block.createCuboidShape(0.0D, 12.0D, 5.333333D, 16.0D, 16.0D, 9.666667D), Block.createCuboidShape(0.0D, 14.0D, 9.666667D, 16.0D, 18.0D, 14.0D), BASE_SHAPE);
		EAST_SHAPE = VoxelShapes.union(Block.createCuboidShape(15.0D, 10.0D, 0.0D, 10.666667D, 14.0D, 16.0D), Block.createCuboidShape(10.666667D, 12.0D, 0.0D, 6.333333D, 16.0D, 16.0D), Block.createCuboidShape(6.333333D, 14.0D, 0.0D, 2.0D, 18.0D, 16.0D), BASE_SHAPE);
		SOUTH_SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0D, 10.0D, 15.0D, 16.0D, 14.0D, 10.666667D), Block.createCuboidShape(0.0D, 12.0D, 10.666667D, 16.0D, 16.0D, 6.333333D), Block.createCuboidShape(0.0D, 14.0D, 6.333333D, 16.0D, 18.0D, 2.0D), BASE_SHAPE);
	}
}
