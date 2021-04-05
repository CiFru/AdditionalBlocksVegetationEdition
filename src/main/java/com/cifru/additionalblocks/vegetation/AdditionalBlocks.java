package com.cifru.additionalblocks.vegetation;

import net.minecraft.block.*;
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
    public static Block aspen_door;
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
    public static BasicBlock maple_log;
    public static BasicBlock maple_wood;
    public static BasicBlock maple_planks;
    public static Block maple_leaves;
    public static BasicBlock stripped_maple_log;
    public static BasicBlock stripped_maple_wood;
    public static Block maple_stairs;
    public static Block maple_slab;
    public static BasicBlock palm_log;
    public static BasicBlock palm_wood;
    public static BasicBlock palm_planks;
    public static Block palm_leaves;
    public static BasicBlock stripped_palm_log;
    public static BasicBlock stripped_palm_wood;
    public static Block palm_stairs;
    public static Block palm_slab;
    public static BasicBlock rosewood_log;
    public static BasicBlock rosewood_wood;
    public static BasicBlock rosewood_planks;
    public static Block rosewood_leaves;
    public static BasicBlock stripped_rosewood_log;
    public static BasicBlock stripped_rosewood_wood;
    public static Block rosewood_stairs;
    public static Block rosewood_slab;
    public static Block baobab_door;
    public static Block blossom_door;
    public static Block maple_door;
    public static Block palm_door;
    public static Block rosewood_door;
    public static Block aspen_fence;
    public static Block baobab_fence;
    public static Block blossom_fence;
    public static Block maple_fence;
    public static Block palm_fence;
    public static Block rosewood_fence;


    public AdditionalBlocks() {
        AdditionalBlocksConfig.create();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> e) {

            aspen_log = registerBlock(e, new AxisRotationBlock("aspen_log",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            aspen_wood = registerBlock(e, new BasicBlock("aspen_wood",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            aspen_planks = registerBlock(e, new BasicBlock("aspen_planks",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            aspen_leaves = registerBlock(e, new LeafBlock("aspen_leaves",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.2f,0.2f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            aspen_door = registerBlock(e, new DeurBlock("aspen_door",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, Blocks.OAK_PLANKS.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            aspen_slab = registerBlock(e, new SlabBlock(aspen_planks, "aspen_slab",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            aspen_stairs = registerBlock(e, new StairBlock(aspen_planks, "aspen_stairs",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            stripped_aspen_log = registerBlock(e, new AxisRotationBlock("stripped_aspen_log",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            stripped_aspen_wood = registerBlock(e, new AxisRotationBlock("stripped_aspen_wood",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            blossom_log = registerBlock(e, new AxisRotationBlock("blossom_log",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            blossom_wood = registerBlock(e, new BasicBlock("blossom_wood",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            blossom_planks = registerBlock(e, new BasicBlock("blossom_planks",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            blossom_leaves = registerBlock(e, new LeafBlock("blossom_leaves",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.2f,0.2f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            blossom_slab = registerBlock(e, new SlabBlock(blossom_planks, "blossom_slab",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            blossom_stairs = registerBlock(e, new StairBlock(blossom_planks, "blossom_stairs",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            stripped_blossom_log = registerBlock(e, new AxisRotationBlock("stripped_blossom_log",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            stripped_blossom_wood = registerBlock(e, new AxisRotationBlock("stripped_blossom_wood",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            baobab_log = registerBlock(e, new AxisRotationBlock("baobab_log",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            baobab_wood = registerBlock(e, new BasicBlock("baobab_wood",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            baobab_planks = registerBlock(e, new BasicBlock("baobab_planks",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            baobab_leaves = registerBlock(e, new LeafBlock("baobab_leaves",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.2f,0.2f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            baobab_slab = registerBlock(e, new SlabBlock(baobab_planks, "baobab_slab",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            baobab_stairs = registerBlock(e, new StairBlock(baobab_planks, "baobab_stairs",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            stripped_baobab_log = registerBlock(e, new AxisRotationBlock("stripped_baobab_log",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            stripped_baobab_wood = registerBlock(e, new AxisRotationBlock("stripped_baobab_wood",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            maple_log = registerBlock(e, new AxisRotationBlock("maple_log",AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            maple_wood = registerBlock(e, new BasicBlock("maple_wood",AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            maple_planks = registerBlock(e, new BasicBlock("maple_planks",AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            maple_leaves = registerBlock(e, new LeafBlock("maple_leaves",AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.2f,0.2f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            maple_slab = registerBlock(e, new SlabBlock(maple_planks, "maple_slab",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            maple_stairs = registerBlock(e, new StairBlock(maple_planks, "maple_stairs",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            stripped_maple_log = registerBlock(e, new AxisRotationBlock("stripped_maple_log",AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            stripped_maple_wood = registerBlock(e, new AxisRotationBlock("stripped_maple_wood",AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            palm_log = registerBlock(e, new AxisRotationBlock("palm_log",AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            palm_wood = registerBlock(e, new BasicBlock("palm_wood",AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            palm_planks = registerBlock(e, new BasicBlock("palm_planks",AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            palm_leaves = registerBlock(e, new RotatingLeafBlock("palm_leaves",AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.2f,0.2f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            palm_slab = registerBlock(e, new SlabBlock(palm_planks, "palm_slab",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            palm_stairs = registerBlock(e, new StairBlock(palm_planks, "palm_stairs",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            stripped_palm_log = registerBlock(e, new AxisRotationBlock("stripped_palm_log",AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            stripped_palm_wood = registerBlock(e, new AxisRotationBlock("stripped_palm_wood",AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            rosewood_log = registerBlock(e, new AxisRotationBlock("rosewood_log",AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            rosewood_wood = registerBlock(e, new BasicBlock("rosewood_wood",AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            rosewood_planks = registerBlock(e, new BasicBlock("rosewood_planks",AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            rosewood_leaves = registerBlock(e, new LeafBlock("rosewood_leaves",AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.2f,0.2f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            rosewood_slab = registerBlock(e, new SlabBlock(rosewood_planks, "rosewood_slab",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            rosewood_stairs = registerBlock(e, new StairBlock(rosewood_planks, "rosewood_stairs",AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            stripped_rosewood_log = registerBlock(e, new AxisRotationBlock("stripped_rosewood_log",AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            stripped_rosewood_wood = registerBlock(e, new AxisRotationBlock("stripped_rosewood_wood",AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f,2.0f)));
            baobab_door = registerBlock(e, new DeurBlock("baobab_door",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, Blocks.OAK_PLANKS.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            blossom_door = registerBlock(e, new DeurBlock("blossom_door",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, Blocks.OAK_PLANKS.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            maple_door = registerBlock(e, new DeurBlock("maple_door",AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, Blocks.OAK_PLANKS.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            palm_door = registerBlock(e, new DeurBlock("palm_door",AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, Blocks.OAK_PLANKS.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            rosewood_door = registerBlock(e, new DeurBlock("rosewood_door",AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, Blocks.OAK_PLANKS.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            aspen_fence = registerBlock(e, new HekBlock("aspen_fence",AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, Blocks.OAK_PLANKS.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            baobab_fence = registerBlock(e, new HekBlock("baobab_fence",AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, Blocks.OAK_PLANKS.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            blossom_fence = registerBlock(e, new HekBlock("blossom_fence",AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, Blocks.OAK_PLANKS.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            maple_fence = registerBlock(e, new HekBlock("maple_fence",AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, Blocks.OAK_PLANKS.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            palm_fence = registerBlock(e, new HekBlock("palm_fence",AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, Blocks.OAK_PLANKS.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            rosewood_fence = registerBlock(e, new HekBlock("rosewood_fence",AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, Blocks.OAK_PLANKS.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
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
