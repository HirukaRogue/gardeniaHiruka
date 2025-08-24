package com.studio.tamer.gardenia.items;

import com.studio.tamer.gardenia.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ForgeModdedCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
