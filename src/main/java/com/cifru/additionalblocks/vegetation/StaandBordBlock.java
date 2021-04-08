package com.cifru.additionalblocks.vegetation;

import net.minecraft.block.AbstractSignBlock;
import net.minecraft.block.Block;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

public class StaandBordBlock extends StandingSignBlock implements IConfigObject {
    private final Supplier<Boolean> enable;
    private final Supplier<TileEntityType<?>> tileEntityType;

    public StaandBordBlock(String registryName, Supplier<Boolean> configValue, Block.Properties properties, Supplier<TileEntityType<?>> bordblock) {
        super(properties, WoodType.OAK);
        this.setRegistryName(registryName);
        this.enable = configValue;
        this.tileEntityType = bordblock;
    }

    public StaandBordBlock(String registryName, Block.Properties properties, Supplier<TileEntityType<?>> bordblock) {
        super(properties, WoodType.OAK);
        this.setRegistryName(registryName);
        this.enable = () -> true;
        this.tileEntityType = bordblock;
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

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new BordTileEntity(this.tileEntityType.get());
    }
}

