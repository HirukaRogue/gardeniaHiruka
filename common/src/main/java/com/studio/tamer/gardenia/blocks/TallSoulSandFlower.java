package com.studio.tamer.gardenia.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class TallSoulSandFlower extends TallFlowerBlock {
    public TallSoulSandFlower(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(Blocks.SOUL_SAND) || state.is(Blocks.SOUL_SOIL);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos below = pos.below();
        BlockState belowState = level.getBlockState(below);
        return this.mayPlaceOn(belowState, level, below) ||
                (state.getValue(HALF) == DoubleBlockHalf.UPPER && belowState.is(this) && belowState.getValue(HALF) == DoubleBlockHalf.LOWER);
    }
}
