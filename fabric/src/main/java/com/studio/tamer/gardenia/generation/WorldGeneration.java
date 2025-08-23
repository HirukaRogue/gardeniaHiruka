package com.studio.tamer.gardenia.generation;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class WorldGeneration {
    public static void generateModWorldGen() {
        BiomeModifications.addFeature(context -> context.getBiomeKey() == Biomes.DARK_FOREST,
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BLOOD_POPPY_KEY);
        BiomeModifications.addFeature(context -> context.getBiomeKey() == Biomes.SPARSE_JUNGLE,
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FIRE_LILY_KEY);
        BiomeModifications.addFeature(context -> context.getBiomeKey() == Biomes.TAIGA || context.getBiomeKey() == Biomes.OLD_GROWTH_PINE_TAIGA || context.getBiomeKey() == Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MIDNIGHT_MOONBLOOM_KEY);
        BiomeModifications.addFeature(context -> context.getBiomeKey() == Biomes.JUNGLE,
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MINT_SKYLIGHT_KEY);
        BiomeModifications.addFeature(context -> context.getBiomeKey() == Biomes.CHERRY_GROVE,
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ROSEATE_BLOOM_KEY);
        BiomeModifications.addFeature(context -> context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.WAX_FLOWER_KEY);
        BiomeModifications.addFeature(context -> context.getBiomeKey() == Biomes.FOREST || context.getBiomeKey() == Biomes.BIRCH_FOREST,
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PINK_FIREWEED_KEY);
        BiomeModifications.addFeature(context -> context.getBiomeKey() == Biomes.FOREST || context.getBiomeKey() == Biomes.BIRCH_FOREST,
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RED_FIREWEED_KEY);

        BiomeModifications.addFeature(context -> context.getBiomeKey() == Biomes.SOUL_SAND_VALLEY,
                GenerationStep.Decoration.UNDERGROUND_DECORATION, PlacedFeatures.SOULBULBS_KEY);
        BiomeModifications.addFeature(context -> context.getBiomeKey() == Biomes.SOUL_SAND_VALLEY,
                GenerationStep.Decoration.UNDERGROUND_DECORATION, PlacedFeatures.SOULWEED_KEY);
    }
}
