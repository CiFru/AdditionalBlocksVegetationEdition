package com.cifru.additionalblocks.vegetation;

import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

import java.util.function.Supplier;

public class BordTileEntity extends SignTileEntity {
    private final Supplier<TileEntityType<?>> tileEntityType;

    public BordTileEntity(Supplier<TileEntityType<?>> tileEntityType) {
        super();
        this.tileEntityType = tileEntityType;
    }

    @Override
    public TileEntityType<?> getType() {
        return this.tileEntityType.get();
    }
}
