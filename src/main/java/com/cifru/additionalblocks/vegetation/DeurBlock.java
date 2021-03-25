package com.cifru.additionalblocks.vegetation;

import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.function.Supplier;

public class DeurBlock extends DoorBlock implements IConfigObject {
    private final Supplier<Boolean> enable;

    public DeurBlock(String registryName, Supplier<Boolean> configValue, Block.Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = configValue;
    }

    public DeurBlock(String registryName, Block.Properties properties) {
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
