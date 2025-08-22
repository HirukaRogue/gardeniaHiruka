package com.studio.tamer.gardenia.blocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModdedBlocks {
    private static final BlockBehaviour.Properties DEFAULT_FLOWER_PROPS = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).ignitedByLava().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY);
    public static final Block BLOOD_POPPY = new FlowerBlock(MobEffects.NIGHT_VISION, 5, DEFAULT_FLOWER_PROPS);
    public static final Block FIRE_LILY = new FlowerBlock(MobEffects.POISON, 12, DEFAULT_FLOWER_PROPS);
    public static final Block MIDNIGHT_MOONBLOOM = new FlowerBlock(MobEffects.NIGHT_VISION, 12, DEFAULT_FLOWER_PROPS);
    public static final Block MINT_SKYLIGHT = new FlowerBlock(MobEffects.FIRE_RESISTANCE, 4, DEFAULT_FLOWER_PROPS);
    public static final Block PINK_FIREWEED = new TallFlowerBlock(DEFAULT_FLOWER_PROPS);
    public static final Block RED_FIREWEED = new TallFlowerBlock(DEFAULT_FLOWER_PROPS);
    public static final Block ROSEATE_BLOOM = new FlowerBlock(MobEffects.WEAKNESS, 9, DEFAULT_FLOWER_PROPS);
    public static final Block SOULBULBS = new FlowerBlock(MobEffects.INVISIBILITY, 5, DEFAULT_FLOWER_PROPS);
    public static final Block SOULWEED = new TallFlowerBlock(DEFAULT_FLOWER_PROPS);
    public static final Block WAX_FLOWER = new FlowerBlock(MobEffects.SATURATION, 7,DEFAULT_FLOWER_PROPS);

    public static List<BlockItem> blockItems = new ArrayList<>();
    private static Set<Map.Entry<ResourceLocation, Block>> blocksListCache = null;

    public static Set<Map.Entry<ResourceLocation, Block>> getBlockListWithID() {
        if (blocksListCache == null)
            blocksListCache = Set.of(
                    Map.entry(getLoc("blood_poppy"), BLOOD_POPPY),
                    Map.entry(getLoc("fire_lily"), FIRE_LILY),
                    Map.entry(getLoc("midnight_moonbloom"), MIDNIGHT_MOONBLOOM),
                    Map.entry(getLoc("mint_skylight"), MINT_SKYLIGHT),
                    Map.entry(getLoc("pink_fireweed"), PINK_FIREWEED),
                    Map.entry(getLoc("red_fireweed"), RED_FIREWEED),
                    Map.entry(getLoc("roseate_bloom"), ROSEATE_BLOOM),
                    Map.entry(getLoc("soulbulbs"), SOULBULBS),
                    Map.entry(getLoc("soulweed"), SOULWEED),
                    Map.entry(getLoc("wax_flower"), WAX_FLOWER)
            );
        return blocksListCache;
    }
    private static ResourceLocation getLoc(String id){
        return new ResourceLocation("gardenia", id);
    }
}
