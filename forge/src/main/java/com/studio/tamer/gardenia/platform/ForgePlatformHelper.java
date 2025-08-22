package com.studio.tamer.gardenia.platform;

import com.studio.tamer.gardenia.platform.services.IPlatformHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import org.apache.commons.lang3.NotImplementedException;

import java.util.function.Function;

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
    public CreativeModeTab registerTab(ResourceLocation resourceLocation, Function<CreativeModeTab.Builder, CreativeModeTab> creativeTabOptions) {
        throw new NotImplementedException();
    }
}