package com.yanisbft.fabriblocks.block;

import com.yanisbft.fabriblocks.FabriBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class FBLeafCarpet extends Block {
	public static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	
	public FBLeafCarpet(String name) {
		super(FabricBlockSettings.of(Material.SUPPORTED, MaterialColor.FOLIAGE).sounds(BlockSoundGroup.GRASS).strength(0.2f, 1.0f).noCollision().nonOpaque());
		Registry.register(Registry.BLOCK, new Identifier(FabriBlocks.MOD_ID, name), this);
		Registry.register(Registry.ITEM, new Identifier(FabriBlocks.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(ItemGroup.DECORATIONS)));
	}
	
	public VoxelShape getOutlineShape(BlockState state, BlockView blockView, BlockPos pos, ShapeContext shapeContext) {
		return SHAPE;
	}
	
	public BlockState getStateForNeighborUpdate(BlockState state_1, Direction direction, BlockState state_2, WorldAccess world, BlockPos pos_1, BlockPos pos_2) {
		return !state_1.canPlaceAt(world, pos_1) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state_1, direction, state_2, world, pos_1, pos_2);
	}

	public boolean canPlaceAt(BlockState state, WorldView worldView, BlockPos pos) {
		return !worldView.isAir(pos.down());
	}

	public boolean isFullBoundsCubeForCulling(BlockState state) {
		return false;
	}

	public int getOpacity(BlockState state, BlockView blockView, BlockPos pos) {
		return 1;
	}
}
