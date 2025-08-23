package com.studio.tamer.gardenia.generation;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.stream.Stream;

public class BlockProximityCheckPlacementModifier extends PlacementModifier {
    public static PlacementModifierType<BlockProximityCheckPlacementModifier> BLOCK_PROXIMITY_CHECK = null;
    private final BlockPredicate targetBlock;
    private final int range;

    public static final Codec<BlockProximityCheckPlacementModifier> CODEC = RecordCodecBuilder.create((builder) -> builder.group(
            BlockPredicate.CODEC.fieldOf("target_block").forGetter((placementModifier) -> placementModifier.targetBlock),
            Codec.intRange(1, 16).fieldOf("max_steps").forGetter((p_191652_) -> p_191652_.range))
            .apply(builder, BlockProximityCheckPlacementModifier::new));

    public BlockProximityCheckPlacementModifier(BlockPredicate targetBlock, int range) {
        this.targetBlock = targetBlock;
        this.range = range;
    }

    @Override
    public Stream<BlockPos> getPositions(PlacementContext context, RandomSource random, BlockPos inPos) {
        BlockPos startPos = inPos.offset(-range,-range,-range);
        BlockPos.MutableBlockPos pos = startPos.mutable();
        for (int x = 0; x < range*2; x++) {
            pos.setY(startPos.getY());
            pos.move(1,0,0);
            for (int y = 0; y < range*2; y++) {
                pos.setZ(startPos.getZ());
                pos.move(0,1,0);
                for (int z = 0; z < range*2; z++) {
                    pos.move(0,0,1);
                    if (targetBlock.test(context.getLevel(),pos))
                        return Stream.of(pos);
                }
            }
        }
        return Stream.empty();
    }

    @Override
    public PlacementModifierType<?> type() {
        return BLOCK_PROXIMITY_CHECK;
    }
}
