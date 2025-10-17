package com.studio.tamer.gardenia.generation;

import com.studio.tamer.gardenia.Constants;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ClampedInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class PlacedFeatures {
    public static final ResourceKey<PlacedFeature> BLOOD_POPPY_KEY = registerKey("blood_poppy");
    public static final ResourceKey<PlacedFeature> DOOM_POPPY_KEY = registerKey("doom_poppy");
    public static final ResourceKey<PlacedFeature> FIRE_LILY_KEY = registerKey("fire_lily");
    public static final ResourceKey<PlacedFeature> MIDNIGHT_MOONBLOOM_KEY = registerKey("midnight_moonbloom");
    public static final ResourceKey<PlacedFeature> MINT_SKYLIGHT_KEY = registerKey("mint_skylight");
    public static final ResourceKey<PlacedFeature> ROSEATE_BLOOM_KEY = registerKey("roseate_bloom");
    public static final ResourceKey<PlacedFeature> WAX_FLOWER_KEY = registerKey("wax_flower");
    public static final ResourceKey<PlacedFeature> PINK_FIREWEED_KEY = registerKey("pink_fireweed");
    public static final ResourceKey<PlacedFeature> RED_FIREWEED_KEY = registerKey("red_fireweed");
    public static final ResourceKey<PlacedFeature> RED_ROSE = registerKey("red_rose");
    public static final ResourceKey<PlacedFeature> DREAM_ROSE = registerKey("dream_rose");
    public static final ResourceKey<PlacedFeature> SOULBULBS_KEY = registerKey("soulbulbs");
    public static final ResourceKey<PlacedFeature> SOULWEED_KEY = registerKey("soulweed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(BLOOD_POPPY_KEY, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.BLOOD_POPPY_KEY), List.of(
                RarityFilter.onAverageOnceEvery(3),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                RarityFilter.onAverageOnceEvery(4))));
        context.register(DOOM_POPPY_KEY, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.DOOM_POPPY_KEY), List.of(
                BiomeFilter.biome(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                new BlockProximityCheckPlacementModifier(BlockPredicate.matchesBlocks(Blocks.POPPY),3),
                RandomOffsetPlacement.horizontal(UniformInt.of(-3,3)),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE)));
        context.register(FIRE_LILY_KEY, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.FIRE_LILY_KEY), List.of(
                RarityFilter.onAverageOnceEvery(8),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                CountPlacement.of(ClampedInt.of(UniformInt.of(-1, 3), 0, 2)))));
        context.register(MIDNIGHT_MOONBLOOM_KEY, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.MIDNIGHT_MOONBLOOM_KEY), List.of(
                RarityFilter.onAverageOnceEvery(5),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(4),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE)));
        context.register(MINT_SKYLIGHT_KEY, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.MINT_SKYLIGHT_KEY), List.of(
                RarityFilter.onAverageOnceEvery(5),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(2),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE)));
        context.register(ROSEATE_BLOOM_KEY, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.ROSEATE_BLOOM_KEY), List.of(
                RarityFilter.onAverageOnceEvery(6),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(2),
                PlacementUtils.HEIGHTMAP)));
        context.register(WAX_FLOWER_KEY, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.WAX_FLOWER_KEY), List.of(
                BiomeFilter.biome(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                new BlockProximityCheckPlacementModifier(BlockPredicate.matchesTag(BlockTags.BEEHIVES),8),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                RarityFilter.onAverageOnceEvery(2))));
        context.register(PINK_FIREWEED_KEY, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.PINK_FIREWEED_KEY), List.of(
                RarityFilter.onAverageOnceEvery(12),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(2),
                PlacementUtils.HEIGHTMAP)));
        context.register(RED_FIREWEED_KEY, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.RED_FIREWEED_KEY), List.of(
                RarityFilter.onAverageOnceEvery(12),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(2),
                PlacementUtils.HEIGHTMAP)));
        context.register(RED_ROSE, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.RED_ROSE_KEY), List.of(
                RarityFilter.onAverageOnceEvery(12),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(3),
                PlacementUtils.HEIGHTMAP)));
        context.register(DREAM_ROSE, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.DREAM_ROSE_KEY), List.of(
                RarityFilter.onAverageOnceEvery(25),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(3),
                PlacementUtils.HEIGHTMAP)));
        context.register(SOULBULBS_KEY, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.SOULBULBS_KEY), List.of(
                RarityFilter.onAverageOnceEvery(2),
                BiomeFilter.biome(),
                PlacementUtils.FULL_RANGE)));
        context.register(SOULWEED_KEY, new PlacedFeature(configuredFeatures.getOrThrow(ConfiguredFeatures.SOULWEED_KEY), List.of(
                RarityFilter.onAverageOnceEvery(2),
                BiomeFilter.biome(),
                PlacementUtils.FULL_RANGE)));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Constants.MOD_ID, name));
    }
}
