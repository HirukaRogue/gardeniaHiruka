package com.studio.tamer.gardenia.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashMap;
import java.util.Map;

public class WateringCanPotBlock extends FlowerPotBlock {
    public static final DirectionProperty FACING;
    protected static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);
    private static final Map<Block, Block> POTTED_BY_CONTENT = new HashMap<>();

    public WateringCanPotBlock(Block flower) {
        super(flower, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
        registerFlowerPot(flower, this);
    }

    private static void registerFlowerPot(Block flower, Block flowerPot) {
        POTTED_BY_CONTENT.put(flower, flowerPot);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        BlockState blockstate = (item instanceof BlockItem ? POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
        boolean pottedFlowerBlockStateExists = !blockstate.is(Blocks.AIR);
        if (pottedFlowerBlockStateExists)
            blockstate = blockstate.setValue(FACING, state.getValue(FACING));
        boolean potWasEmpty = this.isEmpty();
        if (pottedFlowerBlockStateExists == potWasEmpty) {
            if (potWasEmpty) {
                level.setBlock(pos, blockstate, 3);
                player.awardStat(Stats.POT_FLOWER);
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
            } else {
                ItemStack itemstack1 = new ItemStack(this.getContent());
                if (itemstack.isEmpty()) {
                    player.setItemInHand(hand, itemstack1);
                } else if (!player.addItem(itemstack1)) {
                    player.drop(itemstack1, false);
                }

                level.setBlock(pos, Blocks.FLOWER_POT.defaultBlockState(), 3);
            }

            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.CONSUME;
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    private boolean isEmpty() {
        return this.getContent() == Blocks.AIR;
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
    }
}
