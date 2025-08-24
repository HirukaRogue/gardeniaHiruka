package com.studio.tamer.gardenia;

import com.studio.tamer.gardenia.blocks.ModdedBlocks;
import com.studio.tamer.gardenia.generation.ForgePlacementModifiers;
import com.studio.tamer.gardenia.items.ForgeModdedCreativeTab;
import com.studio.tamer.gardenia.items.ModdedItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.Map;

@Mod(Constants.MOD_ID)
public class ForgeGardenia {
    
    public ForgeGardenia() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.register(this);
        modEventBus.addListener(this::commonSetup);

        ForgeModdedCreativeTab.register(modEventBus);

        ForgePlacementModifiers.register(modEventBus);

        CommonGardenia.init();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            for (Map.Entry<ResourceLocation, Block> entry : ModdedBlocks.getBlockListWithID()) {
                if (entry.getValue() instanceof FlowerPotBlock flowerPotBlock) {
                    String path = entry.getKey().getPath();
                    ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(new ResourceLocation(Constants.MOD_ID, path.substring(0,path.length()-4)), () -> flowerPotBlock);
                }
            }
        });
    }

    @SubscribeEvent
    public void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.BLOCKS,
                helper -> {
                    for (Map.Entry<ResourceLocation, Block> blockEntry : ModdedBlocks.getBlockListWithID()) {
                        helper.register(blockEntry.getKey(), blockEntry.getValue());
                    }

                });
        event.register(ForgeRegistries.Keys.ITEMS,
                helper -> {
                    for (Map.Entry<ResourceLocation, Block> blockEntry : ModdedBlocks.getBlockListWithID()) {
                        BlockItem item = new BlockItem(blockEntry.getValue(), new Item.Properties());
                        ModdedBlocks.blockItems.add(item);
                        helper.register(blockEntry.getKey(), item);
                    }
                    for (Map.Entry<ResourceLocation, Item> itemEntry : ModdedItems.getItemListWithID()) {
                        ModdedItems.itemList.add(itemEntry.getValue());
                        helper.register(itemEntry.getKey(), itemEntry.getValue());
                    }
                    ModdedItems.itemList.remove(ModdedItems.MOD_ICON);
                });
    }
}