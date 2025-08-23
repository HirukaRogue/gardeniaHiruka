package com.studio.tamer.gardenia.generation;

import com.studio.tamer.gardenia.Constants;
import com.studio.tamer.gardenia.blocks.ModdedBlocks;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOOD_POPPY_KEY = registerKey("blood_poppy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FIRE_LILY_KEY = registerKey("fire_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MIDNIGHT_MOONBLOOM_KEY = registerKey("midnight_moonbloom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MINT_SKYLIGHT_KEY = registerKey("mint_skylight");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROSEATE_BLOOM_KEY = registerKey("roseate_bloom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WAX_FLOWER_KEY = registerKey("wax_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_FIREWEED_KEY = registerKey("pink_fireweed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_FIREWEED_KEY = registerKey("red_fireweed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOULBULBS_KEY = registerKey("soulbulbs");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOULWEED_KEY = registerKey("soulweed");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, BLOOD_POPPY_KEY, Feature.FLOWER, getFlowerConfiguration(64, 6, 2, ModdedBlocks.BLOOD_POPPY));
        FeatureUtils.register(context, FIRE_LILY_KEY, Feature.FLOWER, getFlowerConfiguration(64, 6, 2, ModdedBlocks.FIRE_LILY));
        FeatureUtils.register(context, MIDNIGHT_MOONBLOOM_KEY, Feature.FLOWER, getFlowerConfiguration(64, 6, 2, ModdedBlocks.MIDNIGHT_MOONBLOOM));
        FeatureUtils.register(context, MINT_SKYLIGHT_KEY, Feature.FLOWER, getFlowerConfiguration(64, 6, 2, ModdedBlocks.MINT_SKYLIGHT));
        FeatureUtils.register(context, ROSEATE_BLOOM_KEY, Feature.FLOWER, getFlowerConfiguration(128, 10, 2, ModdedBlocks.ROSEATE_BLOOM));
        FeatureUtils.register(context, WAX_FLOWER_KEY, Feature.FLOWER, getFlowerConfiguration(64, 6, 2, ModdedBlocks.WAX_FLOWER));
        FeatureUtils.register(context, SOULBULBS_KEY, Feature.RANDOM_PATCH, getFlowerConfiguration(128, 6, 6, ModdedBlocks.SOULBULBS));

        FeatureUtils.register(context, PINK_FIREWEED_KEY, Feature.SIMPLE_RANDOM_SELECTOR, getTallFlowerConfiguration(ModdedBlocks.PINK_FIREWEED));
        FeatureUtils.register(context, RED_FIREWEED_KEY, Feature.SIMPLE_RANDOM_SELECTOR, getTallFlowerConfiguration(ModdedBlocks.RED_FIREWEED));
        FeatureUtils.register(context, SOULWEED_KEY, Feature.RANDOM_PATCH, getFlowerConfiguration(128, 6, 6, ModdedBlocks.SOULWEED));
    }

    private static RandomPatchConfiguration getFlowerConfiguration(int tries, int xzSpread, int ySpread, Block block) {
        return new RandomPatchConfiguration(tries, xzSpread, ySpread, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block))));
    }
    private static SimpleRandomFeatureConfiguration getTallFlowerConfiguration(Block block) {
        return new SimpleRandomFeatureConfiguration(HolderSet.direct(PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(block))))));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Constants.MOD_ID, name));
    }
}
