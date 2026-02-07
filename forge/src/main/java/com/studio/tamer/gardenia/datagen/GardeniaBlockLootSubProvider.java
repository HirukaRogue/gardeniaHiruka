package com.studio.tamer.gardenia.datagen;

import com.studio.tamer.gardenia.blocks.ModdedBlocks;
import com.studio.tamer.gardenia.blocks.WateringCanPotBlock;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Map;
import java.util.Set;

public class GardeniaBlockLootSubProvider extends BlockLootSubProvider {
    protected GardeniaBlockLootSubProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModdedBlocks.BLOOD_POPPY);
        dropPottedContents(ModdedBlocks.BLOOD_POPPY_POT);
        dropSelf(ModdedBlocks.DOOM_POPPY);
        dropPottedContents(ModdedBlocks.DOOM_POPPY_POT);
        dropSelf(ModdedBlocks.FIRE_LILY);
        dropPottedContents(ModdedBlocks.FIRE_LILY_POT);
        dropSelf(ModdedBlocks.MIDNIGHT_MOONBLOOM);
        dropPottedContents(ModdedBlocks.MIDNIGHT_MOONBLOOM_POT);
        dropSelf(ModdedBlocks.MINT_SKYLIGHT);
        dropPottedContents(ModdedBlocks.MINT_SKYLIGHT_POT);
        dropSelf(ModdedBlocks.ROSEATE_BLOOM);
        dropPottedContents(ModdedBlocks.ROSEATE_BLOOM_POT);
        dropSelf(ModdedBlocks.DREAM_ROSE);
        dropPottedContents(ModdedBlocks.DREAM_ROSE_POT);
        dropSelf(ModdedBlocks.RED_ROSE);
        dropPottedContents(ModdedBlocks.RED_ROSE_POT);
        dropSelf(ModdedBlocks.WAX_FLOWER);
        dropPottedContents(ModdedBlocks.WAX_FLOWER_POT);
        dropSelf(ModdedBlocks.SOULBULBS);
        dropPottedContents(ModdedBlocks.SOULBULBS_POT);
        for (Map.Entry<ResourceLocation, Block> blockEntry : ModdedBlocks.getBlockListWithID()) {
            if (blockEntry.getValue() instanceof WateringCanPotBlock wateringCanPotBlock) {
                if (wateringCanPotBlock.getContent() == Blocks.AIR)
                    dropSelf(wateringCanPotBlock);
                else
                    dropWateringCanContents(wateringCanPotBlock);
            }
        }
        add(ModdedBlocks.PINK_FIREWEED, createSinglePropConditionTable(ModdedBlocks.PINK_FIREWEED, BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
        add(ModdedBlocks.RED_FIREWEED, createSinglePropConditionTable(ModdedBlocks.RED_FIREWEED, BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
        add(ModdedBlocks.SOULWEED, createSinglePropConditionTable(ModdedBlocks.SOULWEED, BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModdedBlocks.getBlockListWithID().stream().map(Map.Entry::getValue)::iterator;
    }

    public void dropWateringCanContents(WateringCanPotBlock can) {
        this.add(can, (block) -> createWateringCanItemTable(can.getContent()));
    }

    public LootTable.Builder createWateringCanItemTable(ItemLike item) {
        return LootTable.lootTable().withPool(this.applyExplosionCondition(ModdedBlocks.WATERING_CAN, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(ModdedBlocks.WATERING_CAN)))).withPool(this.applyExplosionCondition(item, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(item))));
    }
}
