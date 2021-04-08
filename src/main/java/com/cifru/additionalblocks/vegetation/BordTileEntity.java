package com.cifru.additionalblocks.vegetation;

import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class BordTileEntity extends SignTileEntity {
    private final TileEntityType<?> tileEntityType;

    public BordTileEntity(TileEntityType<?> tileEntityType) {
        super();
        this.tileEntityType = tileEntityType;
    }

    @Override
    public TileEntityType<?> getType() {
        return this.tileEntityType;
    }
}
