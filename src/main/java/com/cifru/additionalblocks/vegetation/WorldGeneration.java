package com.cifru.additionalblocks.vegetation;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Created 1/20/2021 by SuperMartijn642
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldGeneration {

    public static ConfiguredFeature<?,?> blossom_tree;

    public static void onFeatureRegistry(final RegistryEvent.Register<Feature<?>> e){
        blossom_tree = Feature.TREE.withConfiguration(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(AdditionalBlocks.blossom_log.getDefaultState()), new SimpleBlockStateProvider(AdditionalBlocks.blossom_leaves.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1)).setIgnoreVines().build());
        blossom_tree = blossom_tree.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1f, 1)));
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
            new ResourceLocation("abvegedition", "blossom_tree"),
            blossom_tree
        );
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onBiomeLoad(BiomeLoadingEvent e){
        RegistryKey<Biome> biomeKey = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, e.getName());

        e.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, blossom_tree);

        // all overworld biomes
        if(BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(biomeKey)){

        }

        // all nether biomes
        if(BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER).contains(biomeKey)){

        }

        // all end biomes
        if(BiomeDictionary.getBiomes(BiomeDictionary.Type.OVERWORLD).contains(biomeKey)){

        }
    }

}
