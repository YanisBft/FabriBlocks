package com.yanis48.fabriblocks;

import com.yanis48.fabriblocks.block.entity.FBLecternBlockEntityRenderer;
import com.yanis48.fabriblocks.init.ModBlockEntities;
import com.yanis48.fabriblocks.init.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.render.RenderLayer;

public class FabriBlocksClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OAK_LEAF_CARPET, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPRUCE_LEAF_CARPET, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BIRCH_LEAF_CARPET, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNGLE_LEAF_CARPET, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACACIA_LEAF_CARPET, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_OAK_LEAF_CARPET, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_DOOR, RenderLayer.getCutout());

        registerBlockColor(ModBlocks.OAK_LEAF_CARPET, Blocks.OAK_LEAVES);
        registerBlockColor(ModBlocks.SPRUCE_LEAF_CARPET, Blocks.SPRUCE_LEAVES);
        registerBlockColor(ModBlocks.BIRCH_LEAF_CARPET, Blocks.BIRCH_LEAVES);
        registerBlockColor(ModBlocks.JUNGLE_LEAF_CARPET, Blocks.JUNGLE_LEAVES);
        registerBlockColor(ModBlocks.ACACIA_LEAF_CARPET, Blocks.ACACIA_LEAVES);
        registerBlockColor(ModBlocks.DARK_OAK_LEAF_CARPET, Blocks.DARK_OAK_LEAVES);

        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntities.LECTERN, FBLecternBlockEntityRenderer::new);
    }

    public void registerBlockColor(Block block, Block templateBlock) {
        ColorProviderRegistry.BLOCK.register((block1, pos, world, layer) -> {
            BlockColorProvider provider = ColorProviderRegistry.BLOCK.get(templateBlock);
            return provider == null ? -1 : provider.getColor(block1, pos, world, layer);
        }, block);

        ColorProviderRegistry.ITEM.register((item, layer) -> {
            ItemColorProvider provider = ColorProviderRegistry.ITEM.get(templateBlock);
            return provider == null ? -1 : provider.getColor(item, layer);
        }, block.asItem());
    }
}
