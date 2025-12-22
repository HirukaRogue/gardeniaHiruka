package com.studio.tamer.gardenia.blocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModdedBlocks {
    private static final BlockBehaviour.Properties DEFAULT_FLOWER_PROPS = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).ignitedByLava().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).noOcclusion();
    private static final BlockBehaviour.Properties DEFAULT_FLOWER_POT_PROPS = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
    public static final Block BLOOD_POPPY = new FlowerBlock(MobEffects.NIGHT_VISION, 5, DEFAULT_FLOWER_PROPS);
    public static final Block BLOOD_POPPY_POT = new FlowerPotBlock(BLOOD_POPPY, DEFAULT_FLOWER_POT_PROPS);
    public static final Block BLOOD_POPPY_CAN = new WateringCanPotBlock(BLOOD_POPPY);
    public static final Block DOOM_POPPY = new FlowerBlock(MobEffects.NIGHT_VISION, 5, DEFAULT_FLOWER_PROPS);
    public static final Block DOOM_POPPY_POT = new FlowerPotBlock(DOOM_POPPY, DEFAULT_FLOWER_POT_PROPS);
    public static final Block DOOM_POPPY_CAN = new WateringCanPotBlock(DOOM_POPPY);
    public static final Block FIRE_LILY = new FlowerBlock(MobEffects.POISON, 12, DEFAULT_FLOWER_PROPS);
    public static final Block FIRE_LILY_POT = new FlowerPotBlock(FIRE_LILY, DEFAULT_FLOWER_POT_PROPS);
    public static final Block FIRE_LILY_CAN = new WateringCanPotBlock(FIRE_LILY);
    public static final Block MIDNIGHT_MOONBLOOM = new FlowerBlock(MobEffects.NIGHT_VISION, 12, DEFAULT_FLOWER_PROPS);
    public static final Block MIDNIGHT_MOONBLOOM_POT = new FlowerPotBlock(MIDNIGHT_MOONBLOOM, DEFAULT_FLOWER_POT_PROPS);
    public static final Block MIDNIGHT_MOONBLOOM_CAN = new WateringCanPotBlock(MIDNIGHT_MOONBLOOM);
    public static final Block MINT_SKYLIGHT = new FlowerBlock(MobEffects.FIRE_RESISTANCE, 4, DEFAULT_FLOWER_PROPS);
    public static final Block MINT_SKYLIGHT_POT = new FlowerPotBlock(MINT_SKYLIGHT, DEFAULT_FLOWER_POT_PROPS);
    public static final Block MINT_SKYLIGHT_CAN = new WateringCanPotBlock(MINT_SKYLIGHT);
    public static final Block ROSEATE_BLOOM = new FlowerBlock(MobEffects.WEAKNESS, 9, DEFAULT_FLOWER_PROPS);
    public static final Block ROSEATE_BLOOM_POT = new FlowerPotBlock(ROSEATE_BLOOM, DEFAULT_FLOWER_POT_PROPS);
    public static final Block ROSEATE_BLOOM_CAN = new WateringCanPotBlock(ROSEATE_BLOOM);
    public static final Block WAX_FLOWER = new FlowerBlock(MobEffects.SATURATION, 7, DEFAULT_FLOWER_PROPS);
    public static final Block WAX_FLOWER_POT = new FlowerPotBlock(WAX_FLOWER, DEFAULT_FLOWER_POT_PROPS);
    public static final Block WAX_FLOWER_CAN = new WateringCanPotBlock(WAX_FLOWER);
    public static final Block PINK_FIREWEED = new TallFlowerBlock(DEFAULT_FLOWER_PROPS);
    public static final Block RED_FIREWEED = new TallFlowerBlock(DEFAULT_FLOWER_PROPS);
    public static final Block DREAM_ROSE = new FlowerBlock(MobEffects.BLINDNESS, 2, DEFAULT_FLOWER_PROPS);
    public static final Block DREAM_ROSE_POT = new FlowerPotBlock(DREAM_ROSE, DEFAULT_FLOWER_POT_PROPS);
    public static final Block DREAM_ROSE_CAN = new WateringCanPotBlock(DREAM_ROSE);
    public static final Block RED_ROSE = new FlowerBlock(MobEffects.BLINDNESS, 2, DEFAULT_FLOWER_PROPS);
    public static final Block RED_ROSE_POT = new FlowerPotBlock(RED_ROSE, DEFAULT_FLOWER_POT_PROPS);
    public static final Block RED_ROSE_CAN = new WateringCanPotBlock(RED_ROSE);
    public static final Block SOULBULBS = new SoulSandFlower(MobEffects.INVISIBILITY, 5, DEFAULT_FLOWER_PROPS.lightLevel((blockState) -> 4));
    public static final Block SOULBULBS_POT = new FlowerPotBlock(SOULBULBS, DEFAULT_FLOWER_POT_PROPS.lightLevel((blockState) -> 4));
    public static final Block SOULBULBS_CAN = new WateringCanPotBlock(SOULBULBS);
    public static final Block SOULWEED = new TallSoulSandFlower(DEFAULT_FLOWER_PROPS.lightLevel((blockState) -> 4));
    public static final Block WATERING_CAN = new WateringCanPotBlock(Blocks.AIR);

    // Minecraft flowers in watering cans:
    public static final Block OAK_SAPLING_CAN = new WateringCanPotBlock(Blocks.OAK_SAPLING);
    public static final Block SPRUCE_SAPLING_CAN = new WateringCanPotBlock(Blocks.SPRUCE_SAPLING);
    public static final Block BIRCH_SAPLING_CAN = new WateringCanPotBlock(Blocks.BIRCH_SAPLING);
    public static final Block JUNGLE_SAPLING_CAN = new WateringCanPotBlock(Blocks.JUNGLE_SAPLING);
    public static final Block ACACIA_SAPLING_CAN = new WateringCanPotBlock(Blocks.ACACIA_SAPLING);
    public static final Block DARK_OAK_SAPLING_CAN = new WateringCanPotBlock(Blocks.DARK_OAK_SAPLING);
    public static final Block MANGROVE_PROPAGULE_CAN = new WateringCanPotBlock(Blocks.MANGROVE_PROPAGULE);
    public static final Block CHERRY_SAPLING_CAN = new WateringCanPotBlock(Blocks.CHERRY_SAPLING);
    public static final Block BROWN_MUSHROOM_CAN = new WateringCanPotBlock(Blocks.BROWN_MUSHROOM);
    public static final Block RED_MUSHROOM_CAN = new WateringCanPotBlock(Blocks.RED_MUSHROOM);
    public static final Block CRIMSON_FUNGUS_CAN = new WateringCanPotBlock(Blocks.CRIMSON_FUNGUS);
    public static final Block WARPED_FUNGUS_CAN = new WateringCanPotBlock(Blocks.WARPED_FUNGUS);
    public static final Block FERN_CAN = new WateringCanPotBlock(Blocks.FERN);
    public static final Block DEAD_BUSH_CAN = new WateringCanPotBlock(Blocks.DEAD_BUSH);
    public static final Block DANDELION_CAN = new WateringCanPotBlock(Blocks.DANDELION);
    public static final Block POPPY_CAN = new WateringCanPotBlock(Blocks.POPPY);
    public static final Block BLUE_ORCHID_CAN = new WateringCanPotBlock(Blocks.BLUE_ORCHID);
    public static final Block ALLIUM_CAN = new WateringCanPotBlock(Blocks.ALLIUM);
    public static final Block WARPED_ROOTS_CAN = new WateringCanPotBlock(Blocks.WARPED_ROOTS);
    public static final Block AZURE_BLUET_CAN = new WateringCanPotBlock(Blocks.AZURE_BLUET);
    public static final Block RED_TULIP_CAN = new WateringCanPotBlock(Blocks.RED_TULIP);
    public static final Block ORANGE_TULIP_CAN = new WateringCanPotBlock(Blocks.ORANGE_TULIP);
    public static final Block PINK_TULIP_CAN = new WateringCanPotBlock(Blocks.PINK_TULIP);
    public static final Block WHITE_TULIP_CAN = new WateringCanPotBlock(Blocks.WHITE_TULIP);
    public static final Block OXEYE_DAISY_CAN = new WateringCanPotBlock(Blocks.OXEYE_DAISY);
    public static final Block CORNFLOWER_CAN = new WateringCanPotBlock(Blocks.CORNFLOWER);
    public static final Block LILY_OF_THE_VALLEY_CAN = new WateringCanPotBlock(Blocks.LILY_OF_THE_VALLEY);
    public static final Block TORCHFLOWER_CAN = new WateringCanPotBlock(Blocks.TORCHFLOWER);
    public static final Block WITHER_ROSE_CAN = new WateringCanPotBlock(Blocks.WITHER_ROSE);
    public static final Block CRIMSON_ROOTS_CAN = new WateringCanPotBlock(Blocks.CRIMSON_ROOTS);


    public static List<BlockItem> blockItems = new ArrayList<>();
    private static Set<Map.Entry<ResourceLocation, Block>> blockListCache = null;

    public static Set<Map.Entry<ResourceLocation, Block>> getBlockListWithID() {
        if (blockListCache == null)
            blockListCache = Set.of(
                    Map.entry(getLoc("blood_poppy"), BLOOD_POPPY),
                    Map.entry(getLoc("blood_poppy_pot"), BLOOD_POPPY_POT),
                    Map.entry(getLoc("blood_poppy_can"), BLOOD_POPPY_CAN),
                    Map.entry(getLoc("doom_poppy"), DOOM_POPPY),
                    Map.entry(getLoc("doom_poppy_pot"), DOOM_POPPY_POT),
                    Map.entry(getLoc("doom_poppy_can"), DOOM_POPPY_CAN),
                    Map.entry(getLoc("dream_rose"), DREAM_ROSE),
                    Map.entry(getLoc("dream_rose_pot"), DREAM_ROSE_POT),
                    Map.entry(getLoc("dream_rose_can"), DREAM_ROSE_CAN),
                    Map.entry(getLoc("fire_lily"), FIRE_LILY),
                    Map.entry(getLoc("fire_lily_pot"), FIRE_LILY_POT),
                    Map.entry(getLoc("fire_lily_can"), FIRE_LILY_CAN),
                    Map.entry(getLoc("midnight_moonbloom"), MIDNIGHT_MOONBLOOM),
                    Map.entry(getLoc("midnight_moonbloom_pot"), MIDNIGHT_MOONBLOOM_POT),
                    Map.entry(getLoc("midnight_moonbloom_can"), MIDNIGHT_MOONBLOOM_CAN),
                    Map.entry(getLoc("mint_skylight"), MINT_SKYLIGHT),
                    Map.entry(getLoc("mint_skylight_pot"), MINT_SKYLIGHT_POT),
                    Map.entry(getLoc("mint_skylight_can"), MINT_SKYLIGHT_CAN),
                    Map.entry(getLoc("pink_fireweed"), PINK_FIREWEED),
                    Map.entry(getLoc("red_fireweed"), RED_FIREWEED),
                    Map.entry(getLoc("red_rose"), RED_ROSE),
                    Map.entry(getLoc("red_rose_pot"), RED_ROSE_POT),
                    Map.entry(getLoc("red_rose_can"), RED_ROSE_CAN),
                    Map.entry(getLoc("roseate_bloom"), ROSEATE_BLOOM),
                    Map.entry(getLoc("roseate_bloom_pot"), ROSEATE_BLOOM_POT),
                    Map.entry(getLoc("roseate_bloom_can"), ROSEATE_BLOOM_CAN),
                    Map.entry(getLoc("soulbulbs"), SOULBULBS),
                    Map.entry(getLoc("soulbulbs_pot"), SOULBULBS_POT),
                    Map.entry(getLoc("soulbulbs_can"), SOULBULBS_CAN),
                    Map.entry(getLoc("soulweed"), SOULWEED),
                    Map.entry(getLoc("wax_flower"), WAX_FLOWER),
                    Map.entry(getLoc("wax_flower_pot"), WAX_FLOWER_POT),
                    Map.entry(getLoc("wax_flower_can"), WAX_FLOWER_CAN),
                    Map.entry(getLoc("watering_can"), WATERING_CAN),

                    // Minecraft flowers in watering cans:
                    Map.entry(getLoc("oak_sapling_can"), OAK_SAPLING_CAN),
                    Map.entry(getLoc("spruce_sapling_can"), SPRUCE_SAPLING_CAN),
                    Map.entry(getLoc("birch_sapling_can"), BIRCH_SAPLING_CAN),
                    Map.entry(getLoc("jungle_sapling_can"), JUNGLE_SAPLING_CAN),
                    Map.entry(getLoc("acacia_sapling_can"), ACACIA_SAPLING_CAN),
                    Map.entry(getLoc("dark_oak_sapling_can"), DARK_OAK_SAPLING_CAN),
                    Map.entry(getLoc("mangrove_propagule_can"), MANGROVE_PROPAGULE_CAN),
                    Map.entry(getLoc("cherry_sapling_can"), CHERRY_SAPLING_CAN),
                    Map.entry(getLoc("brown_mushroom_can"), BROWN_MUSHROOM_CAN),
                    Map.entry(getLoc("red_mushroom_sapling_can"), RED_MUSHROOM_CAN),
                    Map.entry(getLoc("crimson_fungus_can"), CRIMSON_FUNGUS_CAN),
                    Map.entry(getLoc("warped_fungus_can"), WARPED_FUNGUS_CAN),
                    Map.entry(getLoc("fern_can"), FERN_CAN),
                    Map.entry(getLoc("dead_bush_can"), DEAD_BUSH_CAN),
                    Map.entry(getLoc("dandelion_can"), DANDELION_CAN),
                    Map.entry(getLoc("poppy_can"), POPPY_CAN),
                    Map.entry(getLoc("blue_orchid_can"), BLUE_ORCHID_CAN),
                    Map.entry(getLoc("allium_can"), ALLIUM_CAN),
                    Map.entry(getLoc("warped_roots_can"), WARPED_ROOTS_CAN),
                    Map.entry(getLoc("azure_bluet_can"), AZURE_BLUET_CAN),
                    Map.entry(getLoc("red_tulip_can"), RED_TULIP_CAN),
                    Map.entry(getLoc("orange_tulip_can"), ORANGE_TULIP_CAN),
                    Map.entry(getLoc("pink_tulip_can"), PINK_TULIP_CAN),
                    Map.entry(getLoc("white_tulip_can"), WHITE_TULIP_CAN),
                    Map.entry(getLoc("oxeye_can"), OXEYE_DAISY_CAN),
                    Map.entry(getLoc("cornflower_can"), CORNFLOWER_CAN),
                    Map.entry(getLoc("lily_of_the_valley_can"), LILY_OF_THE_VALLEY_CAN),
                    Map.entry(getLoc("torchflower_can"), TORCHFLOWER_CAN),
                    Map.entry(getLoc("wither_rose_can"), WITHER_ROSE_CAN),
                    Map.entry(getLoc("crimson_roots_can"), CRIMSON_ROOTS_CAN)
            );
        return blockListCache;
    }
    private static ResourceLocation getLoc(String id){
        return new ResourceLocation("gardenia", id);
    }
}
