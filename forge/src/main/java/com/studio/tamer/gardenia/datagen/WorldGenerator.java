package com.studio.tamer.gardenia.datagen;

import com.studio.tamer.gardenia.Constants;
import com.studio.tamer.gardenia.generation.BiomeModifiers;
import com.studio.tamer.gardenia.generation.ConfiguredFeatures;
import com.studio.tamer.gardenia.generation.PlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class WorldGenerator extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, PlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifiers::bootstrap);

    public WorldGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Constants.MOD_ID));
    }

}
