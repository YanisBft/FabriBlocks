package com.yanis48.fabriblocks.block;

import com.yanis48.fabriblocks.FabriBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FBBlock extends Block {

    public FBBlock(String name, float hardness, float resistance) {
        super(FabricBlockSettings.of(Material.STONE).strength(hardness, resistance));
        Registry.register(Registry.BLOCK, new Identifier(FabriBlocks.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(FabriBlocks.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(ItemGroup.BUILDING_BLOCKS)));
    }
}
