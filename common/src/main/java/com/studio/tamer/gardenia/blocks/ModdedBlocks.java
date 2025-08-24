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
    public static final Block FIRE_LILY = new FlowerBlock(MobEffects.POISON, 12, DEFAULT_FLOWER_PROPS);
    public static final Block FIRE_LILY_POT = new FlowerPotBlock(FIRE_LILY, DEFAULT_FLOWER_POT_PROPS);
    public static final Block MIDNIGHT_MOONBLOOM = new FlowerBlock(MobEffects.NIGHT_VISION, 12, DEFAULT_FLOWER_PROPS);
    public static final Block MIDNIGHT_MOONBLOOM_POT = new FlowerPotBlock(MIDNIGHT_MOONBLOOM, DEFAULT_FLOWER_POT_PROPS);
    public static final Block MINT_SKYLIGHT = new FlowerBlock(MobEffects.FIRE_RESISTANCE, 4, DEFAULT_FLOWER_PROPS);
    public static final Block MINT_SKYLIGHT_POT = new FlowerPotBlock(MINT_SKYLIGHT, DEFAULT_FLOWER_POT_PROPS);
    public static final Block ROSEATE_BLOOM = new FlowerBlock(MobEffects.WEAKNESS, 9, DEFAULT_FLOWER_PROPS);
    public static final Block ROSEATE_BLOOM_POT = new FlowerPotBlock(ROSEATE_BLOOM, DEFAULT_FLOWER_POT_PROPS);
    public static final Block WAX_FLOWER = new FlowerBlock(MobEffects.SATURATION, 7, DEFAULT_FLOWER_PROPS);
    public static final Block WAX_FLOWER_POT = new FlowerPotBlock(WAX_FLOWER, DEFAULT_FLOWER_POT_PROPS);
    public static final Block PINK_FIREWEED = new TallFlowerBlock(DEFAULT_FLOWER_PROPS);
    public static final Block RED_FIREWEED = new TallFlowerBlock(DEFAULT_FLOWER_PROPS);
    public static final Block SOULBULBS = new SoulSandFlower(MobEffects.INVISIBILITY, 5, DEFAULT_FLOWER_PROPS);
    public static final Block SOULBULBS_POT = new FlowerPotBlock(SOULBULBS, DEFAULT_FLOWER_POT_PROPS);
    public static final Block SOULWEED = new TallSoulSandFlower(DEFAULT_FLOWER_PROPS);

    public static List<BlockItem> blockItems = new ArrayList<>();
    private static Set<Map.Entry<ResourceLocation, Block>> blockListCache = null;

    public static Set<Map.Entry<ResourceLocation, Block>> getBlockListWithID() {
        if (blockListCache == null)
            blockListCache = Set.of(
                    Map.entry(getLoc("blood_poppy"), BLOOD_POPPY),
                    Map.entry(getLoc("blood_poppy_pot"), BLOOD_POPPY_POT),
                    Map.entry(getLoc("fire_lily"), FIRE_LILY),
                    Map.entry(getLoc("fire_lily_pot"), FIRE_LILY_POT),
                    Map.entry(getLoc("midnight_moonbloom"), MIDNIGHT_MOONBLOOM),
                    Map.entry(getLoc("midnight_moonbloom_pot"), MIDNIGHT_MOONBLOOM_POT),
                    Map.entry(getLoc("mint_skylight"), MINT_SKYLIGHT),
                    Map.entry(getLoc("mint_skylight_pot"), MINT_SKYLIGHT_POT),
                    Map.entry(getLoc("pink_fireweed"), PINK_FIREWEED),
                    Map.entry(getLoc("red_fireweed"), RED_FIREWEED),
                    Map.entry(getLoc("roseate_bloom"), ROSEATE_BLOOM),
                    Map.entry(getLoc("roseate_bloom_pot"), ROSEATE_BLOOM_POT),
                    Map.entry(getLoc("soulbulbs"), SOULBULBS),
                    Map.entry(getLoc("soulbulbs_pot"), SOULBULBS_POT),
                    Map.entry(getLoc("soulweed"), SOULWEED),
                    Map.entry(getLoc("wax_flower"), WAX_FLOWER),
                    Map.entry(getLoc("wax_flower_pot"), WAX_FLOWER_POT)
            );
        return blockListCache;
    }
    private static ResourceLocation getLoc(String id){
        return new ResourceLocation("gardenia", id);
    }
}
