package com.cifru.additionalblocks.vegetation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

public class LeafBlock extends LeavesBlock implements IConfigObject {
    private final Supplier<Boolean> enable;

    public LeafBlock(String registryName, Supplier<Boolean> configValue, Block.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = configValue;
    }

    public LeafBlock(String registryName, Block.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = () -> true;
    }

    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        return super.isSideInvisible(state, adjacentBlockState, side);
    }

    public static Boolean allowsSpawnOnLeaves(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }

    public static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isEnabled())
            super.fillItemGroup(group, items);
    }

    @Override
    public boolean isEnabled() {
        return this.enable.get();
    }

}
