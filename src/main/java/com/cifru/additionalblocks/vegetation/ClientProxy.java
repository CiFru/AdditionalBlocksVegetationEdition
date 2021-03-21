package com.cifru.additionalblocks.vegetation;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Created 7/11/2020 by SuperMartijn642
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientProxy {

    @SubscribeEvent
    public static void setup(FMLClientSetupEvent e){
        RenderTypeLookup.setRenderLayer(AdditionalBlocks.aspen_leaves, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(AdditionalBlocks.blossom_leaves, RenderType.getCutout());
    }

}
