package com.studio.tamer.gardenia;

import com.studio.tamer.gardenia.blocks.ModdedBlocks;
import com.studio.tamer.gardenia.blocks.glowingflower.models.EmissiveBakedModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.BakedModel;
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
            if (block.getValue() instanceof FlowerBlock || block.getValue() instanceof TallFlowerBlock || block.getValue() instanceof FlowerPotBlock)
                BlockRenderLayerMapImpl.INSTANCE.putBlocks(RenderType.cutout(), block.getValue());
        }

        ModelLoadingPlugin.register(plugin -> {
            plugin.modifyModelOnLoad().register((model, context) -> {
                ResourceLocation id = (ResourceLocation) context.id();

                // Aplica no modelo principal do bloco
                if (id.getNamespace().equals(Constants.MOD_ID) &&
                        id.getPath().equals("block/mint_skylight")) {
                    return new EmissiveBakedModel(model);
                }

                // Opcional: também no item (inventory)
                if (id.getNamespace().equals(Constants.MOD_ID) &&
                        id.getPath().equals("item/mint_skylight")) {
                    return new EmissiveBakedModel(model);
                }

                return model;
            });
        });
    }
}
