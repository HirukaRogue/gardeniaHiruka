package com.studio.tamer.gardenia.platform;

import com.studio.tamer.gardenia.platform.services.IPlatformHelper;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLLoader;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.studio.tamer.gardenia.items.ForgeModdedCreativeTab.CREATIVE_MODE_TABS;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public Supplier<CreativeModeTab> registerTab(ResourceLocation resourceLocation, Function<CreativeModeTab.Builder, CreativeModeTab> creativeTabOptions) {
        return CREATIVE_MODE_TABS.register(resourceLocation.getPath(), () -> creativeTabOptions.apply(CreativeModeTab.builder()));
    }
}