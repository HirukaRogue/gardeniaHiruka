package com.studio.tamer.gardenia.datagen;

import com.studio.tamer.gardenia.blocks.ModdedBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class LootTableGenerator extends FabricBlockLootTableProvider {
    public LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
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
}
