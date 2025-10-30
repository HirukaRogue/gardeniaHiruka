package com.studio.tamer.gardenia.client;

import com.studio.tamer.gardenia.Constants;
import com.studio.tamer.gardenia.blocks.ModdedBlocks;
import com.studio.tamer.gardenia.blocks.glowingflower.models.EmissiveBakedModel;
import com.studio.tamer.gardenia.client.model.EmissiveBakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeGardeniaClient {

    @SubscribeEvent
    public static void onModelBake(ModelEvent.RegisterAdditional event) {
        // Registra modelo adicional (glow)
        event.register(new ModelResourceLocation(
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "mint_skylight_emissive"), "inventory"
        ));
    }

    @SubscribeEvent
    public static void onModelBake(ModelEvent.BakingCompleted event) {
        var modelLoc = ModelResourceLocation.standalone(
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "mint_skylight")
        );
        var original = event.getModels().get(modelLoc);
        if (original != null) {
            event.getModels().put(modelLoc, new EmissiveBakedModel(original));
        }
    }
}