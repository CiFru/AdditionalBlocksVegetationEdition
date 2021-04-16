package com.cifru.additionalblocks.vegetation.boat;

import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.ResourceLocation;

/**
 * Created 4/16/2021 by SuperMartijn642
 */
public class VBoatEntityRenderer extends BoatRenderer {

    public VBoatEntityRenderer(EntityRendererManager renderManagerIn){
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(BoatEntity entity){
        return ((VBoatEntity)entity).getVBoatType().getTexture();
    }
}
