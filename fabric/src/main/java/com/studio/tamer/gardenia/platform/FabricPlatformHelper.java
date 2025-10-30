package com.studio.tamer.gardenia.platform;

import com.studio.tamer.gardenia.client.RenderLayerType;
import com.studio.tamer.gardenia.platform.services.IPlatformHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;
import java.util.function.Supplier;

public class FabricPlatformHelper implements IPlatformHelper {
    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public Supplier<CreativeModeTab> registerTab(ResourceLocation resourceLocation, Function<CreativeModeTab.Builder, CreativeModeTab> creativeTabOptions) {
        CreativeModeTab creativeModeTab = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, resourceLocation, creativeTabOptions.apply(FabricItemGroup.builder()));
        return ()-> creativeModeTab;
    }

    @Override
    public void setBlockRenderLayer(Block block, RenderLayerType layer) {
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            RenderType type = switch (layer) {
                case CUTOUT     -> RenderType.cutout();
                case TRANSLUCENT-> RenderType.translucent();
                case SOLID      -> RenderType.solid();
            };
            net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap.INSTANCE
                    .putBlock(block, type);
        }
    }
}
