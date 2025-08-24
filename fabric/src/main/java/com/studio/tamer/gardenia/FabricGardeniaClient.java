package com.studio.tamer.gardenia;

import com.studio.tamer.gardenia.blocks.ModdedBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.TallFlowerBlock;

import java.util.Map;

public class FabricGardeniaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        for (Map.Entry<ResourceLocation, Block> block : ModdedBlocks.getBlockListWithID()) {
            if (block.getValue() instanceof FlowerBlock || block.getValue() instanceof TallFlowerBlock || block.getValue() instanceof FlowerPotBlock)
                BlockRenderLayerMapImpl.INSTANCE.putBlocks(RenderType.cutout(), block.getValue());
        }
    }
}
