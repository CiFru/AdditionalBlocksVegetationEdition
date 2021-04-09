package com.cifru.additionalblocks.vegetation;

import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Created 7/11/2020 by SuperMartijn642
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientProxy {

    @SubscribeEvent
    public static void setup(FMLClientSetupEvent e){
        RenderTypeLookup.setRenderLayer(AdditionalBlocks.baobab_door,RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(AdditionalBlocks.baobab_trapdoor,RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(AdditionalBlocks.palm_door,RenderType.getCutout());
        ClientRegistry.bindTileEntityRenderer(AdditionalBlocks.aspen_sign_tile_entity, BordTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AdditionalBlocks.baobab_sign_tile_entity, BordTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AdditionalBlocks.blossom_sign_tile_entity, BordTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AdditionalBlocks.maple_sign_tile_entity, BordTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AdditionalBlocks.palm_sign_tile_entity, BordTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(AdditionalBlocks.rosewood_sign_tile_entity, BordTileEntityRenderer::new);

    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre e){
        if(e.getMap().getTextureLocation().equals(Atlases.SIGN_ATLAS)){
            e.addSprite(new ResourceLocation("abvegedition:aspen_sign"));
            e.addSprite(new ResourceLocation("abvegedition:baobab_sign"));
            e.addSprite(new ResourceLocation("abvegedition:blossom_sign"));
            e.addSprite(new ResourceLocation("abvegedition:maple_sign"));
            e.addSprite(new ResourceLocation("abvegedition:palm_sign"));
            e.addSprite(new ResourceLocation("abvegedition:rosewood_sign"));

        }
    }
}
