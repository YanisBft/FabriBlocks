package com.yanis48.fabriblocks.block;

import com.yanis48.fabriblocks.FabriBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FBButton extends StoneButtonBlock {

    public FBButton(String name) {
        super(FabricBlockSettings.of(Material.SUPPORTED).strength(0.5f, 2.5f).noCollision());
        Registry.register(Registry.BLOCK, new Identifier(FabriBlocks.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(FabriBlocks.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(ItemGroup.REDSTONE)));
    }
}
