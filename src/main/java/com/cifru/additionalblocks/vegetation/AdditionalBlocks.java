package com.cifru.additionalblocks.vegetation;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.item.crafting.ShapelessRecipe;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 7/7/2020 by SuperMartijn642
 */
@Mod("abvegedition")
public class AdditionalBlocks {

    public static final IRecipeSerializer<ShapedRecipe> SHAPED_RECIPE_SERIALIZER = new AdditionalBlocksRecipes.ShapedSerializer();
    public static final IRecipeSerializer<ShapelessRecipe> SHAPELESS_RECIPE_SERIALIZER = new AdditionalBlocksRecipes.ShapelessSerializer();
    public static final IRecipeSerializer<FurnaceRecipe> FURNACE_RECIPE_SERIALIZER = new AdditionalBlocksRecipes.FurnaceSerializer();

    private static final List<Block> blocks = new ArrayList<>();
    private static final List<Item> items = new ArrayList<>();

    public static BasicBlock aspen_log;
    public static BasicBlock aspen_wood;
    public static BasicBlock aspen_planks;
    public static Block aspen_leaves;
    public static BasicBlock stripped_aspen_log;
    public static BasicBlock stripped_aspen_wood;
    public static Block aspen_stairs;
    public static Block aspen_slab;
    public static BasicBlock blossom_log;
    public static BasicBlock blossom_wood;
    public static BasicBlock blossom_planks;
    public static Block blossom_leaves;
    public static BasicBlock stripped_blossom_log;
    public static BasicBlock stripped_blossom_wood;
    public static Block blossom_stairs;
    public static Block blossom_slab;
    public static BasicBlock baobab_log;
    public static BasicBlock baobab_wood;
    public static BasicBlock baobab_planks;
    public static Block baobab_leaves;
    public static BasicBlock stripped_baobab_log;
    public static BasicBlock stripped_baobab_wood;
    public static Block baobab_stairs;
    public static Block baobab_slab;


    public AdditionalBlocks() {
        AdditionalBlocksConfig.create();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> e) {

            aspen_log = registerBlock(e, new AxisRotationBlock("aspen_log",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            aspen_wood = registerBlock(e, new BasicBlock("aspen_wood",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            aspen_planks = registerBlock(e, new BasicBlock("aspen_planks",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            aspen_leaves = registerBlock(e, new LeafBlock("aspen_leaves",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.8f,0.8f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            aspen_slab = registerBlock(e, new SlabBlock(aspen_planks, "aspen_slab",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            aspen_stairs = registerBlock(e, new StairBlock(aspen_planks, "aspen_stairs",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            stripped_aspen_log = registerBlock(e, new AxisRotationBlock("stripped_aspen_log",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            stripped_aspen_wood = registerBlock(e, new AxisRotationBlock("stripped_aspen_wood",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            blossom_log = registerBlock(e, new AxisRotationBlock("blossom_log",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            blossom_wood = registerBlock(e, new BasicBlock("blossom_wood",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            blossom_planks = registerBlock(e, new BasicBlock("blossom_planks",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            blossom_leaves = registerBlock(e, new LeafBlock("blossom_leaves",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.8f,0.8f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            blossom_slab = registerBlock(e, new SlabBlock(blossom_planks, "blossom_slab",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            blossom_stairs = registerBlock(e, new StairBlock(blossom_planks, "blossom_stairs",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            stripped_blossom_log = registerBlock(e, new AxisRotationBlock("stripped_blossom_log",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            stripped_blossom_wood = registerBlock(e, new AxisRotationBlock("stripped_blossom_wood",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            baobab_log = registerBlock(e, new AxisRotationBlock("baobab_log",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            baobab_wood = registerBlock(e, new BasicBlock("baobab_wood",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            baobab_planks = registerBlock(e, new BasicBlock("baobab_planks",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            baobab_leaves = registerBlock(e, new LeafBlock("baobab_leaves",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.8f,0.8f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            baobab_slab = registerBlock(e, new SlabBlock(baobab_planks, "baobab_slab",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            baobab_stairs = registerBlock(e, new StairBlock(baobab_planks, "baobab_stairs",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            stripped_baobab_log = registerBlock(e, new AxisRotationBlock("stripped_baobab_log",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
            stripped_baobab_wood = registerBlock(e, new AxisRotationBlock("stripped_baobab_wood",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.8f,0.8f)));
        }

        @SubscribeEvent
        public static void onTileRegistry(final RegistryEvent.Register<TileEntityType<?>> e) {
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> e) {
            for (Block block : blocks)
                registerItem(e, new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
        }

        @SubscribeEvent
        public static void onFeatureRegistry(final RegistryEvent.Register<Feature<?>> e){
//            WorldGeneration.onFeatureRegistry(e);
        }

        @SubscribeEvent
        public static void onRecipeRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> e){
            e.getRegistry().register(SHAPED_RECIPE_SERIALIZER.setRegistryName(new ResourceLocation("abvegedition", "shaped")));
            e.getRegistry().register(SHAPELESS_RECIPE_SERIALIZER.setRegistryName(new ResourceLocation("abvegedition", "shapeless")));
            e.getRegistry().register(FURNACE_RECIPE_SERIALIZER.setRegistryName(new ResourceLocation("abvegedition", "furnace")));
        }
    }

    public static <T extends Block> T registerBlock(RegistryEvent.Register<Block> e, T block) {
        e.getRegistry().register(block);
        blocks.add(block);
        return block;
    }

    public static <T extends Item> T registerItem(RegistryEvent.Register<Item> e, T item) {
        e.getRegistry().register(item);
        items.add(item);
        return item;
    }

}
