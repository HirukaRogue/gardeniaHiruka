package com.studio.tamer.gardenia.generation;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.function.Predicate;

public class WorldGeneration {
    public static void generateModWorldGen() {
        BiomeModifications.addFeature(biomeSelectorFromBiomes(Biomes.DARK_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BLOOD_POPPY_KEY);
        BiomeModifications.addFeature(biomeSelectorFromBiomes(Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.FLOWER_FOREST, Biomes.MEADOW),
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.DOOM_POPPY_KEY);
        BiomeModifications.addFeature(biomeSelectorFromBiomes(Biomes.SPARSE_JUNGLE),
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FIRE_LILY_KEY);
        BiomeModifications.addFeature(biomeSelectorFromBiomes(Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA),
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MIDNIGHT_MOONBLOOM_KEY);
        BiomeModifications.addFeature(biomeSelectorFromBiomes(Biomes.JUNGLE),
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.MINT_SKYLIGHT_KEY);
        BiomeModifications.addFeature(biomeSelectorFromBiomes(Biomes.CHERRY_GROVE),
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ROSEATE_BLOOM_KEY);
        BiomeModifications.addFeature(context -> context.hasTag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.WAX_FLOWER_KEY);
        BiomeModifications.addFeature(biomeSelectorFromBiomes(Biomes.FOREST, Biomes.BIRCH_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PINK_FIREWEED_KEY);
        BiomeModifications.addFeature(biomeSelectorFromBiomes(Biomes.FOREST, Biomes.BIRCH_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RED_FIREWEED_KEY);
        BiomeModifications.addFeature(biomeSelectorFromBiomes(Biomes.PLAINS, Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.MEADOW, Biomes.SUNFLOWER_PLAINS),
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RED_ROSE);
        BiomeModifications.addFeature(biomeSelectorFromBiomes(Biomes.PLAINS, Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.MEADOW, Biomes.SUNFLOWER_PLAINS),
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.DREAM_ROSE);

        BiomeModifications.addFeature(biomeSelectorFromBiomes(Biomes.SOUL_SAND_VALLEY),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, PlacedFeatures.SOULBULBS_KEY);
        BiomeModifications.addFeature(biomeSelectorFromBiomes(Biomes.SOUL_SAND_VALLEY),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, PlacedFeatures.SOULWEED_KEY);
    }

    private static Predicate<BiomeSelectionContext> biomeSelectorFromBiomes(ResourceKey<Biome>... biomes){
        return ((selectionContext) -> {
            for (ResourceKey<Biome> key : biomes) {
                if (selectionContext.getBiomeKey() == key)
                    return true;
            }
            return false;
        });
    }
}
