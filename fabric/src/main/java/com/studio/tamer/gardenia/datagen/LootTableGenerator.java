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
        dropPottedContents(ModdedBlocks.BLOOD_POPPY_POT);
        dropSelf(ModdedBlocks.FIRE_LILY);
        dropPottedContents(ModdedBlocks.FIRE_LILY_POT);
        dropSelf(ModdedBlocks.MIDNIGHT_MOONBLOOM);
        dropPottedContents(ModdedBlocks.MIDNIGHT_MOONBLOOM_POT);
        dropSelf(ModdedBlocks.MINT_SKYLIGHT);
        dropPottedContents(ModdedBlocks.MINT_SKYLIGHT_POT);
        dropSelf(ModdedBlocks.ROSEATE_BLOOM);
        dropPottedContents(ModdedBlocks.ROSEATE_BLOOM_POT);
        dropSelf(ModdedBlocks.WAX_FLOWER);
        dropPottedContents(ModdedBlocks.WAX_FLOWER_POT);
        dropSelf(ModdedBlocks.SOULBULBS);
        dropPottedContents(ModdedBlocks.SOULBULBS_POT);
        add(ModdedBlocks.PINK_FIREWEED, createSinglePropConditionTable(ModdedBlocks.PINK_FIREWEED, BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
        add(ModdedBlocks.RED_FIREWEED, createSinglePropConditionTable(ModdedBlocks.RED_FIREWEED, BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
        add(ModdedBlocks.SOULWEED, createSinglePropConditionTable(ModdedBlocks.SOULWEED, BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
    }
}
