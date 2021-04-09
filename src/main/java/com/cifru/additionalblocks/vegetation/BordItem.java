package com.cifru.additionalblocks.vegetation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class BordItem extends SignItem implements IConfigObject {
    private final Supplier<Boolean> enable;

    public BordItem(String registryName, Supplier<Boolean> configValue, Properties propertiesIn, Block floorBlockIn, Block wallBlockIn) {
        super(propertiesIn, floorBlockIn, wallBlockIn);
        this.setRegistryName(registryName);
        this.enable = configValue;
    }

    protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
        boolean flag = super.onBlockPlaced(pos, worldIn, player, stack, state);
        if (!worldIn.isRemote && !flag && player != null) {
            Minecraft.getInstance().displayGuiScreen(new EditVegSignScreen((SignTileEntity) worldIn.getTileEntity(pos)));
        }

        return flag;
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
