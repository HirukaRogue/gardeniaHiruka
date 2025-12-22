package com.studio.tamer.gardenia;

import com.studio.tamer.gardenia.blocks.ModdedBlocks;
import com.studio.tamer.gardenia.blocks.WateringCanPotBlock;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.util.Identifier;

import java.util.Map;

public class FabricGardeniaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        for (Map.Entry<ResourceLocation, Block> block : ModdedBlocks.getBlockListWithID()) {
            Block value = block.getValue();
            if (value instanceof FlowerBlock || value instanceof TallFlowerBlock || value instanceof FlowerPotBlock || value instanceof WateringCanPotBlock)
                BlockRenderLayerMapImpl.INSTANCE.putBlocks(RenderType.cutout(), value);
        }

        ModelLoadingPlugin.register(plugin -> {
            plugin.modifyModelOnLoad().register((model, context) -> {
                ResourceLocation id = (ResourceLocation) context.id();

                // Aplica no modelo principal do bloco
                if (id.getNamespace().equals(Constants.MOD_ID) &&
                        id.getPath().equals("block/mint_skylight")) {
                    return new FlowerEmissiveBakedModel(model);
                }

                // Opcional: também no item (inventory)
                if (id.getNamespace().equals(Constants.MOD_ID) &&
                        id.getPath().equals("item/mint_skylight")) {
                    return new FlowerEmissiveBakedModel(model);
                }

                return model;
            });
        });
    }
}
