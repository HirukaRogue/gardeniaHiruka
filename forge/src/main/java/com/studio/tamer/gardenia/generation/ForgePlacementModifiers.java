package com.studio.tamer.gardenia.generation;

import com.mojang.serialization.Codec;
import com.studio.tamer.gardenia.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ForgePlacementModifiers {
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIER = DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, Constants.MOD_ID);


    public static void register(IEventBus eventBus) {
        BlockProximityCheckPlacementModifier.BLOCK_PROXIMITY_CHECK = register("block_proximity_check", BlockProximityCheckPlacementModifier.CODEC);
        PLACEMENT_MODIFIER.register(eventBus);
    }

    private static <P extends PlacementModifier> RegistryObject<PlacementModifierType<P>> register(String name, Codec<P> codec) {
        return PLACEMENT_MODIFIER.register(name, ()-> ()-> codec);
    }
}
