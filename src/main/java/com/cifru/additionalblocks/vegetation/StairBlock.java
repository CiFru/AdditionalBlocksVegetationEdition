package com.cifru.additionalblocks.vegetation;

import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * Created 1/17/2021 by SuperMartijn642
 */
public class StairBlock extends StairsBlock implements IConfigObject {

    private final BasicBlock block;

    public StairBlock(BasicBlock block, Properties properties) {
        super(block::getDefaultState, properties);
        this.setRegistryName(block.getRegistryName().getPath() + "_stairs");
        this.block = block;
    }

    public StairBlock(BasicBlock block, String registryName, Properties properties) {
        super(block::getDefaultState, properties);
        this.setRegistryName(registryName);
        this.block = block;
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isEnabled())
            super.fillItemGroup(group, items);
    }

    @Override
    public boolean isEnabled() {
        return this.block.isEnabled();
    }
}
