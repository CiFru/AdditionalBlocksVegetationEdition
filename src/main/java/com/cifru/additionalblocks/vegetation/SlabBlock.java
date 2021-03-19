package com.cifru.additionalblocks.vegetation;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * Created 1/17/2021 by SuperMartijn642
 */
public class SlabBlock extends net.minecraft.block.SlabBlock implements IConfigObject {

    private final BasicBlock block;

    public SlabBlock(BasicBlock block, Properties properties) {
        super(properties);
        this.setRegistryName(block.getRegistryName().getPath() + "_slab");
        this.block = block;
    }

    public SlabBlock(BasicBlock block, String registryName, Properties properties) {
        super(properties);
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
