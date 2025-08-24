package com.studio.tamer.gardenia;

import com.studio.tamer.gardenia.blocks.ModdedBlocks;
import com.studio.tamer.gardenia.generation.FabricPlacementModifiers;
import com.studio.tamer.gardenia.generation.WorldGeneration;
import com.studio.tamer.gardenia.items.ModdedItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public class FabricGardenia implements ModInitializer {
    
    @Override
    public void onInitialize() {
        CommonGardenia.init();

        for (Map.Entry<ResourceLocation, Block> blockEntry : ModdedBlocks.getBlockListWithID()) {
            Registry.register(BuiltInRegistries.BLOCK,blockEntry.getKey(),blockEntry.getValue());
            ModdedBlocks.blockItems.add(Registry.register(BuiltInRegistries.ITEM,blockEntry.getKey(), new BlockItem(blockEntry.getValue(), new Item.Properties())));
        }

        for (Map.Entry<ResourceLocation, Item> itemEntry : ModdedItems.getItemListWithID()) {
            ModdedItems.itemList.add(Registry.register(BuiltInRegistries.ITEM,itemEntry.getKey(),itemEntry.getValue()));
        }
        ModdedItems.itemList.remove(ModdedItems.MOD_ICON);

        FabricPlacementModifiers.regPlacementModifiers();
        WorldGeneration.generateModWorldGen();
    }
}
