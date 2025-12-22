package com.studio.tamer.gardenia.datagen;

import com.studio.tamer.gardenia.Constants;
import com.studio.tamer.gardenia.blocks.ModdedBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

import static net.minecraft.data.models.BlockModelGenerators.createHorizontalFacingDispatch;

public class BlockStateGenerator extends FabricModelProvider {

    public BlockStateGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        // Minecraft flowers in watering cans:
        {
            createPlantWateringCan(blockStateModelGenerator, Blocks.OAK_SAPLING, ModdedBlocks.OAK_SAPLING_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.SPRUCE_SAPLING, ModdedBlocks.SPRUCE_SAPLING_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.BIRCH_SAPLING, ModdedBlocks.BIRCH_SAPLING_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.JUNGLE_SAPLING, ModdedBlocks.JUNGLE_SAPLING_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.ACACIA_SAPLING, ModdedBlocks.ACACIA_SAPLING_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.DARK_OAK_SAPLING, ModdedBlocks.DARK_OAK_SAPLING_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.MANGROVE_PROPAGULE, ModdedBlocks.MANGROVE_PROPAGULE_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.CHERRY_SAPLING, ModdedBlocks.CHERRY_SAPLING_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.BROWN_MUSHROOM, ModdedBlocks.BROWN_MUSHROOM_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.RED_MUSHROOM, ModdedBlocks.RED_MUSHROOM_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.CRIMSON_FUNGUS, ModdedBlocks.CRIMSON_FUNGUS_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.WARPED_FUNGUS, ModdedBlocks.WARPED_FUNGUS_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.FERN, ModdedBlocks.FERN_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.DEAD_BUSH, ModdedBlocks.DEAD_BUSH_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.DANDELION, ModdedBlocks.DANDELION_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.POPPY, ModdedBlocks.POPPY_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.BLUE_ORCHID, ModdedBlocks.BLUE_ORCHID_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.ALLIUM, ModdedBlocks.ALLIUM_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.WARPED_ROOTS, ModdedBlocks.WARPED_ROOTS_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.AZURE_BLUET, ModdedBlocks.AZURE_BLUET_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.RED_TULIP, ModdedBlocks.RED_TULIP_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.ORANGE_TULIP, ModdedBlocks.ORANGE_TULIP_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.PINK_TULIP, ModdedBlocks.PINK_TULIP_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.WHITE_TULIP, ModdedBlocks.WHITE_TULIP_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.OXEYE_DAISY, ModdedBlocks.OXEYE_DAISY_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.CORNFLOWER, ModdedBlocks.CORNFLOWER_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.LILY_OF_THE_VALLEY, ModdedBlocks.LILY_OF_THE_VALLEY_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.TORCHFLOWER, ModdedBlocks.TORCHFLOWER_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.WITHER_ROSE, ModdedBlocks.WITHER_ROSE_CAN);
            createPlantWateringCan(blockStateModelGenerator, Blocks.CRIMSON_ROOTS, ModdedBlocks.CRIMSON_ROOTS_CAN);
        }
    }

    public final void createPlantWateringCan(BlockModelGenerators generators, Block plantBlock, Block pottedPlantBlock) {
        TextureMapping textureMapping = TextureMapping.plant(plantBlock);
        ResourceLocation resourceLocation = createModelTemplate("watering_can_cross", TextureSlot.PLANT).create(pottedPlantBlock, textureMapping, generators.modelOutput);
        generators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(pottedPlantBlock, resourceLocation).with(createHorizontalFacingDispatch()));
    }

    private static ModelTemplate createModelTemplate(String blockModelLocation, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(new ResourceLocation(Constants.MOD_ID, "block/" + blockModelLocation)), Optional.empty(), requiredSlots);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }

    @Override
    public @NotNull String getName() {
        return "GardeniaModelProvider";
    }
}
