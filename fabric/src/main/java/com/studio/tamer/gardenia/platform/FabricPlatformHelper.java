package com.studio.tamer.gardenia.platform;

import com.studio.tamer.gardenia.platform.services.IPlatformHelper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

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
}
