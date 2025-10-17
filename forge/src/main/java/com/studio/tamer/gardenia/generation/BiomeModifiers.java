package com.studio.tamer.gardenia.generation;

import com.studio.tamer.gardenia.Constants;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeModifiers {
    public static final ResourceKey<BiomeModifier> BLOOD_POPPY = registerKey("blood_poppy");
    public static final ResourceKey<BiomeModifier> DOOM_POPPY = registerKey("doom_poppy");
    public static final ResourceKey<BiomeModifier> FIRE_LILY = registerKey("fire_lily");
    public static final ResourceKey<BiomeModifier> MIDNIGHT_MOONBLOOM = registerKey("midnight_moonbloom");
    public static final ResourceKey<BiomeModifier> MINT_SKYLIGHT = registerKey("mint_skylight");
    public static final ResourceKey<BiomeModifier> ROSEATE_BLOOM = registerKey("roseate_bloom");
    public static final ResourceKey<BiomeModifier> WAX_FLOWER = registerKey("wax_flower");
    public static final ResourceKey<BiomeModifier> PINK_FIREWEED = registerKey("pink_fireweed");
    public static final ResourceKey<BiomeModifier> RED_FIREWEED = registerKey("red_fireweed");
    public static final ResourceKey<BiomeModifier> RED_ROSE = registerKey("red_rose");
    public static final ResourceKey<BiomeModifier> DREAM_ROSE = registerKey("dream_rose");
    public static final ResourceKey<BiomeModifier> SOULBULBS = registerKey("soulbulbs");
    public static final ResourceKey<BiomeModifier> SOULWEED = registerKey("soulweed");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(BLOOD_POPPY, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DARK_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.BLOOD_POPPY_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(DOOM_POPPY, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.FLOWER_FOREST), biomes.getOrThrow(Biomes.MEADOW)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.DOOM_POPPY_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(FIRE_LILY, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SPARSE_JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.FIRE_LILY_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(MIDNIGHT_MOONBLOOM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.TAIGA), biomes.getOrThrow(Biomes.OLD_GROWTH_PINE_TAIGA), biomes.getOrThrow(Biomes.OLD_GROWTH_SPRUCE_TAIGA)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.MIDNIGHT_MOONBLOOM_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(MINT_SKYLIGHT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.MINT_SKYLIGHT_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ROSEATE_BLOOM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.CHERRY_GROVE)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ROSEATE_BLOOM_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(WAX_FLOWER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.WAX_FLOWER_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(PINK_FIREWEED, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.BIRCH_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.PINK_FIREWEED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(RED_FIREWEED, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.BIRCH_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.RED_FIREWEED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(RED_ROSE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.FLOWER_FOREST), biomes.getOrThrow(Biomes.MEADOW), biomes.getOrThrow(Biomes.SUNFLOWER_PLAINS)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.RED_ROSE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(DREAM_ROSE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.FLOWER_FOREST), biomes.getOrThrow(Biomes.MEADOW), biomes.getOrThrow(Biomes.SUNFLOWER_PLAINS)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.DREAM_ROSE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(SOULBULBS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.SOULBULBS_KEY)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));
        context.register(SOULWEED, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.SOULWEED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));

        }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Constants.MOD_ID, name));
    }
}
