package com.cifru.additionalblocks.vegetation;

import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.function.Supplier;

public class DrukplaatBlock extends PressurePlateBlock implements IConfigObject {
    private final Supplier<Boolean> enable;

    public DrukplaatBlock(String registryName, Supplier<Boolean> configValue, Block.Properties properties) {
        super(Sensitivity.EVERYTHING, properties);
        this.setRegistryName(registryName);
        this.enable = configValue;
    }

    public DrukplaatBlock(String registryName, Block.Properties properties) {
        super(Sensitivity.EVERYTHING, properties);
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
