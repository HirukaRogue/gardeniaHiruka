package com.studio.tamer.gardenia;

import com.studio.tamer.gardenia.blocks.ModdedBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeGardeniaClient {

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event){
        event.getBlockColors().register(
                        (blockState, blockAndTintGetter, blockPos, i) ->
                                blockAndTintGetter != null && blockPos != null ?
                                        BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos) :
                                        GrassColor.getDefaultColor(),
                ModdedBlocks.FERN_CAN);
    }
}