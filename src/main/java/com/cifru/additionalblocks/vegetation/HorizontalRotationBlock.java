package com.cifru.additionalblocks.vegetation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

import java.util.function.Supplier;

/**
 * Created 1/15/2021 by SuperMartijn642
 */
public class HorizontalRotationBlock extends BasicBlock {

    private final boolean reversePlacement;

    public HorizontalRotationBlock(String registryName, Supplier<Boolean> configValue, boolean reversePlacement, Properties properties){
        super(registryName, configValue, properties);
        this.reversePlacement = reversePlacement;
        this.setDefaultState(this.getDefaultState().with(BlockProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
        Direction facing = context.getPlacementHorizontalFacing();
        return this.getDefaultState().with(BlockProperties.HORIZONTAL_FACING, this.reversePlacement ? facing.getOpposite() : facing);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block,BlockState> builder){
        builder.add(BlockProperties.HORIZONTAL_FACING);
    }
}
