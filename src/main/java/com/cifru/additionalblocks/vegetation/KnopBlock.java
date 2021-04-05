package com.cifru.additionalblocks.vegetation;

import net.minecraft.block.Block;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.function.Supplier;

public class KnopBlock extends WoodButtonBlock implements IConfigObject{
    private final Supplier<Boolean> enable;

    public KnopBlock(String registryName, Supplier<Boolean> configValue, Block.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = configValue;
    }

    public KnopBlock(String registryName, Block.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = () -> true;
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
