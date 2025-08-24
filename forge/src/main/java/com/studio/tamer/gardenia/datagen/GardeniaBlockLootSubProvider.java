package com.studio.tamer.gardenia.datagen;

import com.studio.tamer.gardenia.blocks.ModdedBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.Map;
import java.util.Set;

public class GardeniaBlockLootSubProvider extends BlockLootSubProvider {
    protected GardeniaBlockLootSubProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModdedBlocks.BLOOD_POPPY);
        dropSelf(ModdedBlocks.FIRE_LILY);
        dropSelf(ModdedBlocks.MIDNIGHT_MOONBLOOM);
        dropSelf(ModdedBlocks.MINT_SKYLIGHT);
        dropSelf(ModdedBlocks.ROSEATE_BLOOM);
        dropSelf(ModdedBlocks.WAX_FLOWER);
        dropSelf(ModdedBlocks.SOULBULBS);
        add(ModdedBlocks.PINK_FIREWEED, createSinglePropConditionTable(ModdedBlocks.PINK_FIREWEED, BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
        add(ModdedBlocks.RED_FIREWEED, createSinglePropConditionTable(ModdedBlocks.RED_FIREWEED, BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
        add(ModdedBlocks.SOULWEED, createSinglePropConditionTable(ModdedBlocks.SOULWEED, BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModdedBlocks.getBlockListWithID().stream().map(Map.Entry::getValue)::iterator;
    }
}
