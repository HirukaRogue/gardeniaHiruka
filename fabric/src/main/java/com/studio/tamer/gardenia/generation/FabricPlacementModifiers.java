package com.studio.tamer.gardenia.generation;

import com.mojang.serialization.Codec;
import com.studio.tamer.gardenia.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.function.Supplier;

public class FabricPlacementModifiers {
    public static void regPlacementModifiers(){
        BlockProximityCheckPlacementModifier.BLOCK_PROXIMITY_CHECK = new ConstValueSupplier<>(register("block_proximity_check", BlockProximityCheckPlacementModifier.CODEC));
    }

    private static <P extends PlacementModifier> PlacementModifierType<P> register(String name, Codec<P> codec) {
        return Registry.register(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, new ResourceLocation(Constants.MOD_ID,name), () -> codec);
    }

    static class ConstValueSupplier<T> implements Supplier<T> {
        private final T value;

        public ConstValueSupplier(T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return value;
        }
    }
}
