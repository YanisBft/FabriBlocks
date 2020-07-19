package com.yanis48.fabriblocks.init;

import com.yanis48.fabriblocks.FabriBlocks;
import com.yanis48.fabriblocks.block.entity.FBLecternBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {

    public static final BlockEntityType<FBLecternBlockEntity> LECTERN = register(BlockEntityType.Builder.create(FBLecternBlockEntity::new, ModBlocks.SPRUCE_LECTERN, ModBlocks.BIRCH_LECTERN, ModBlocks.JUNGLE_LECTERN, ModBlocks.ACACIA_LECTERN, ModBlocks.DARK_OAK_LECTERN));

    private static <T extends BlockEntity> BlockEntityType<T> register(BlockEntityType.Builder<T> builder) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(FabriBlocks.MOD_ID, "lectern"), builder.build(null));
    }
}
