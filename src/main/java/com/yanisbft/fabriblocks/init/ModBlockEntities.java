package com.yanisbft.fabriblocks.init;

import com.yanisbft.fabriblocks.FabriBlocks;
import com.yanisbft.fabriblocks.block.entity.FBLecternBlockEntity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
	
	public static final BlockEntityType<FBLecternBlockEntity> LECTERN = register("lectern", BlockEntityType.Builder.create(FBLecternBlockEntity::new, ModBlocks.SPRUCE_LECTERN, ModBlocks.BIRCH_LECTERN, ModBlocks.JUNGLE_LECTERN, ModBlocks.ACACIA_LECTERN, ModBlocks.DARK_OAK_LECTERN));
	
	private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType.Builder<T> builder) {
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(FabriBlocks.MOD_ID, name), builder.build(null));
	}
}
