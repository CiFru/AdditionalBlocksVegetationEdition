package com.cifru.additionalblocks.vegetation;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
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
import net.minecraftforge.registries.ObjectHolder;

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
    private static final List<Block> blocksWithItems = new ArrayList<>();
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
    public static Block aspen_button;
    public static Block baobab_button;
    public static Block blossom_button;
    public static Block maple_button;
    public static Block palm_button;
    public static Block rosewood_button;
    public static Block aspen_pressure_plate;
    public static Block baobab_pressure_plate;
    public static Block blossom_pressure_plate;
    public static Block maple_pressure_plate;
    public static Block palm_pressure_plate;
    public static Block rosewood_pressure_plate;
    public static Block aspen_fence_gate;
    public static Block baobab_fence_gate;
    public static Block blossom_fence_gate;
    public static Block maple_fence_gate;
    public static Block palm_fence_gate;
    public static Block rosewood_fence_gate;
    public static Block aspen_trapdoor;
    public static Block baobab_trapdoor;
    public static Block blossom_trapdoor;
    public static Block maple_trapdoor;
    public static Block palm_trapdoor;
    public static Block rosewood_trapdoor;
    public static Block aspen_sign_standing;
    public static Block aspen_sign;
    public static Block baobab_sign_standing;
    public static Block baobab_sign;
    public static Block blossom_sign_standing;
    public static Block blossom_sign;
    public static Block maple_sign_standing;
    public static Block maple_sign;
    public static Block palm_sign_standing;
    public static Block palm_sign;
    public static Block rosewood_sign_standing;
    public static Block rosewood_sign;

    @ObjectHolder("abvegedition:aspen_sign_tile_entity")
    public static TileEntityType<BordTileEntity> aspen_sign_tile_entity;
    @ObjectHolder("abvegedition:baobab_sign_tile_entity")
    public static TileEntityType<BordTileEntity> baobab_sign_tile_entity;
    @ObjectHolder("abvegedition:blossom_sign_tile_entity")
    public static TileEntityType<BordTileEntity> blossom_sign_tile_entity;
    @ObjectHolder("abvegedition:maple_sign_tile_entity")
    public static TileEntityType<BordTileEntity> maple_sign_tile_entity;
    @ObjectHolder("abvegedition:palm_sign_tile_entity")
    public static TileEntityType<BordTileEntity> palm_sign_tile_entity;
    @ObjectHolder("abvegedition:rosewood_sign_tile_entity")
    public static TileEntityType<BordTileEntity> rosewood_sign_tile_entity;

    public AdditionalBlocks() {
        AdditionalBlocksConfig.create();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlockRegistry(final RegistryEvent.Register<Block> e) {

            aspen_log = registerBlockWithItem(e, new AxisRotationBlock("aspen_log", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            aspen_wood = registerBlockWithItem(e, new BasicBlock("aspen_wood", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            aspen_planks = registerBlockWithItem(e, new BasicBlock("aspen_planks", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            aspen_leaves = registerBlockWithItem(e, new LeafBlock("aspen_leaves", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.2f, 0.2f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            aspen_door = registerBlockWithItem(e, new DeurBlock("aspen_door", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, aspen_planks.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            aspen_slab = registerBlockWithItem(e, new SlabBlock(aspen_planks, "aspen_slab", AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            aspen_stairs = registerBlockWithItem(e, new StairBlock(aspen_planks, "aspen_stairs", AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            stripped_aspen_log = registerBlockWithItem(e, new AxisRotationBlock("stripped_aspen_log", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            stripped_aspen_wood = registerBlockWithItem(e, new AxisRotationBlock("stripped_aspen_wood", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            blossom_log = registerBlockWithItem(e, new AxisRotationBlock("blossom_log", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            blossom_wood = registerBlockWithItem(e, new BasicBlock("blossom_wood", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            blossom_planks = registerBlockWithItem(e, new BasicBlock("blossom_planks", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            blossom_leaves = registerBlockWithItem(e, new LeafBlock("blossom_leaves", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.2f, 0.2f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            blossom_slab = registerBlockWithItem(e, new SlabBlock(blossom_planks, "blossom_slab", AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            blossom_stairs = registerBlockWithItem(e, new StairBlock(blossom_planks, "blossom_stairs", AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            stripped_blossom_log = registerBlockWithItem(e, new AxisRotationBlock("stripped_blossom_log", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            stripped_blossom_wood = registerBlockWithItem(e, new AxisRotationBlock("stripped_blossom_wood", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            baobab_log = registerBlockWithItem(e, new AxisRotationBlock("baobab_log", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            baobab_wood = registerBlockWithItem(e, new BasicBlock("baobab_wood", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            baobab_planks = registerBlockWithItem(e, new BasicBlock("baobab_planks", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            baobab_leaves = registerBlockWithItem(e, new LeafBlock("baobab_leaves", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.2f, 0.2f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            baobab_slab = registerBlockWithItem(e, new SlabBlock(baobab_planks, "baobab_slab", AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            baobab_stairs = registerBlockWithItem(e, new StairBlock(baobab_planks, "baobab_stairs", AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            stripped_baobab_log = registerBlockWithItem(e, new AxisRotationBlock("stripped_baobab_log", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            stripped_baobab_wood = registerBlockWithItem(e, new AxisRotationBlock("stripped_baobab_wood", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            maple_log = registerBlockWithItem(e, new AxisRotationBlock("maple_log", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            maple_wood = registerBlockWithItem(e, new BasicBlock("maple_wood", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            maple_planks = registerBlockWithItem(e, new BasicBlock("maple_planks", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            maple_leaves = registerBlockWithItem(e, new LeafBlock("maple_leaves", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.2f, 0.2f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            maple_slab = registerBlockWithItem(e, new SlabBlock(maple_planks, "maple_slab", AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            maple_stairs = registerBlockWithItem(e, new StairBlock(maple_planks, "maple_stairs", AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            stripped_maple_log = registerBlockWithItem(e, new AxisRotationBlock("stripped_maple_log", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            stripped_maple_wood = registerBlockWithItem(e, new AxisRotationBlock("stripped_maple_wood", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            palm_log = registerBlockWithItem(e, new AxisRotationBlock("palm_log", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            palm_wood = registerBlockWithItem(e, new BasicBlock("palm_wood", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            palm_planks = registerBlockWithItem(e, new BasicBlock("palm_planks", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            palm_leaves = registerBlockWithItem(e, new RotatingLeafBlock("palm_leaves", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.2f, 0.2f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            palm_slab = registerBlockWithItem(e, new SlabBlock(palm_planks, "palm_slab", AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            palm_stairs = registerBlockWithItem(e, new StairBlock(palm_planks, "palm_stairs", AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            stripped_palm_log = registerBlockWithItem(e, new AxisRotationBlock("stripped_palm_log", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            stripped_palm_wood = registerBlockWithItem(e, new AxisRotationBlock("stripped_palm_wood", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            rosewood_log = registerBlockWithItem(e, new AxisRotationBlock("rosewood_log", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            rosewood_wood = registerBlockWithItem(e, new BasicBlock("rosewood_wood", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            rosewood_planks = registerBlockWithItem(e, new BasicBlock("rosewood_planks", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            rosewood_leaves = registerBlockWithItem(e, new LeafBlock("rosewood_leaves", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.PLANT).hardnessAndResistance(0.2f, 0.2f).tickRandomly().notSolid().setAllowsSpawn(LeafBlock::allowsSpawnOnLeaves).setSuffocates(LeafBlock::isntSolid).setBlocksVision(LeafBlock::isntSolid)));
            rosewood_slab = registerBlockWithItem(e, new SlabBlock(rosewood_planks, "rosewood_slab", AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            rosewood_stairs = registerBlockWithItem(e, new StairBlock(rosewood_planks, "rosewood_stairs", AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            stripped_rosewood_log = registerBlockWithItem(e, new AxisRotationBlock("stripped_rosewood_log", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            stripped_rosewood_wood = registerBlockWithItem(e, new AxisRotationBlock("stripped_rosewood_wood", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0f, 2.0f)));
            baobab_door = registerBlockWithItem(e, new DeurBlock("baobab_door", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, baobab_planks.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            blossom_door = registerBlockWithItem(e, new DeurBlock("blossom_door", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, blossom_planks.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            maple_door = registerBlockWithItem(e, new DeurBlock("maple_door", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, maple_planks.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            palm_door = registerBlockWithItem(e, new DeurBlock("palm_door", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, palm_planks.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            rosewood_door = registerBlockWithItem(e, new DeurBlock("rosewood_door", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, rosewood_planks.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            aspen_fence = registerBlockWithItem(e, new HekBlock("aspen_fence", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, aspen_planks.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            baobab_fence = registerBlockWithItem(e, new HekBlock("baobab_fence", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, baobab_planks.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            blossom_fence = registerBlockWithItem(e, new HekBlock("blossom_fence", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, blossom_planks.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            maple_fence = registerBlockWithItem(e, new HekBlock("maple_fence", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, maple_planks.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            palm_fence = registerBlockWithItem(e, new HekBlock("palm_fence", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, palm_planks.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            rosewood_fence = registerBlockWithItem(e, new HekBlock("rosewood_fence", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, rosewood_planks.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            aspen_button = registerBlockWithItem(e, new KnopBlock("aspen_button", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
            baobab_button = registerBlockWithItem(e, new KnopBlock("baobab_button", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
            blossom_button = registerBlockWithItem(e, new KnopBlock("blossom_button", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
            maple_button = registerBlockWithItem(e, new KnopBlock("maple_button", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
            palm_button = registerBlockWithItem(e, new KnopBlock("palm_button", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
            rosewood_button = registerBlockWithItem(e, new KnopBlock("rosewood_button", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
            aspen_pressure_plate = registerBlockWithItem(e, new DrukplaatBlock("aspen_pressure_plate", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, aspen_planks.getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
            baobab_pressure_plate = registerBlockWithItem(e, new DrukplaatBlock("baobab_pressure_plate", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, baobab_planks.getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
            blossom_pressure_plate = registerBlockWithItem(e, new DrukplaatBlock("blossom_pressure_plate", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, blossom_planks.getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
            maple_pressure_plate = registerBlockWithItem(e, new DrukplaatBlock("maple_pressure_plate", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, maple_planks.getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
            palm_pressure_plate = registerBlockWithItem(e, new DrukplaatBlock("palm_pressure_plate", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, palm_planks.getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
            rosewood_pressure_plate = registerBlockWithItem(e, new DrukplaatBlock("rosewood_pressure_plate", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, rosewood_planks.getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
            aspen_fence_gate = registerBlockWithItem(e, new PoortBlock("aspen_fence_gate", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, aspen_planks.getMaterialColor()).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
            baobab_fence_gate = registerBlockWithItem(e, new PoortBlock("baobab_fence_gate", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, baobab_planks.getMaterialColor()).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
            blossom_fence_gate = registerBlockWithItem(e, new PoortBlock("blossom_fence_gate", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, blossom_planks.getMaterialColor()).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
            maple_fence_gate = registerBlockWithItem(e, new PoortBlock("maple_fence_gate", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, maple_planks.getMaterialColor()).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
            palm_fence_gate = registerBlockWithItem(e, new PoortBlock("palm_fence_gate", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, palm_planks.getMaterialColor()).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
            rosewood_fence_gate = registerBlockWithItem(e, new PoortBlock("rosewood_fence_gate", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, rosewood_planks.getMaterialColor()).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
            aspen_trapdoor = registerBlockWithItem(e, new ValluikBlock("aspen_trapdoor", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            baobab_trapdoor = registerBlockWithItem(e, new ValluikBlock("baobab_trapdoor", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            blossom_trapdoor = registerBlockWithItem(e, new ValluikBlock("blossom_trapdoor", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            maple_trapdoor = registerBlockWithItem(e, new ValluikBlock("maple_trapdoor", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            palm_trapdoor = registerBlockWithItem(e, new ValluikBlock("palm_trapdoor", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            rosewood_trapdoor = registerBlockWithItem(e, new ValluikBlock("rosewood_trapdoor", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
            aspen_sign_standing = registerBlock(e, new StaandBordBlock("aspen_sign_standing", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), () -> aspen_sign_tile_entity, "aspen_sign"));
            aspen_sign = registerBlock(e, new BordBlock("aspen_sign", AdditionalBlocksConfig.enableAspen, AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), () -> aspen_sign_tile_entity, "aspen_sign"));
            baobab_sign_standing = registerBlock(e, new StaandBordBlock("baobab_sign_standing", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), () -> baobab_sign_tile_entity, "baobab_sign"));
            baobab_sign = registerBlock(e, new BordBlock("baobab_sign", AdditionalBlocksConfig.enableBaobab, AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), () -> baobab_sign_tile_entity, "baobab_sign"));
            blossom_sign_standing = registerBlock(e, new StaandBordBlock("blossom_sign_standing", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), () -> blossom_sign_tile_entity, "blossom_sign"));
            blossom_sign = registerBlock(e, new BordBlock("blossom_sign", AdditionalBlocksConfig.enableBlossom, AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), () -> blossom_sign_tile_entity, "blossom_sign"));
            maple_sign_standing = registerBlock(e, new StaandBordBlock("maple_sign_standing", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), () -> maple_sign_tile_entity, "maple_sign"));
            maple_sign = registerBlock(e, new BordBlock("maple_sign", AdditionalBlocksConfig.enableMaple, AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), () -> maple_sign_tile_entity, "maple_sign"));
            palm_sign_standing = registerBlock(e, new StaandBordBlock("palm_sign_standing", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), () -> palm_sign_tile_entity, "palm_sign"));
            palm_sign = registerBlock(e, new BordBlock("palm_sign", AdditionalBlocksConfig.enablePalm, AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), () -> palm_sign_tile_entity, "palm_sign"));
            rosewood_sign_standing = registerBlock(e, new StaandBordBlock("rosewood_sign_standing", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), () -> rosewood_sign_tile_entity, "rosewood_sign"));
            rosewood_sign = registerBlock(e, new BordBlock("rosewood_sign", AdditionalBlocksConfig.enableRosewood, AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), () -> rosewood_sign_tile_entity, "rosewood_sign"));

        }

        @SubscribeEvent
        public static void onTileRegistry(final RegistryEvent.Register<TileEntityType<?>> e) {
            e.getRegistry().register(TileEntityType.Builder.create(() -> new BordTileEntity(()-> aspen_sign_tile_entity), aspen_sign, aspen_sign_standing).build(null).setRegistryName("aspen_sign_tile_entity"));
            e.getRegistry().register(TileEntityType.Builder.create(() -> new BordTileEntity(()-> baobab_sign_tile_entity), baobab_sign, baobab_sign_standing).build(null).setRegistryName("baobab_sign_tile_entity"));
            e.getRegistry().register(TileEntityType.Builder.create(() -> new BordTileEntity(()-> blossom_sign_tile_entity), blossom_sign, blossom_sign_standing).build(null).setRegistryName("blossom_sign_tile_entity"));
            e.getRegistry().register(TileEntityType.Builder.create(() -> new BordTileEntity(()-> maple_sign_tile_entity), maple_sign, maple_sign_standing).build(null).setRegistryName("maple_sign_tile_entity"));
            e.getRegistry().register(TileEntityType.Builder.create(() -> new BordTileEntity(()-> palm_sign_tile_entity), palm_sign, palm_sign_standing).build(null).setRegistryName("palm_sign_tile_entity"));
            e.getRegistry().register(TileEntityType.Builder.create(() -> new BordTileEntity(()-> rosewood_sign_tile_entity), rosewood_sign, rosewood_sign_standing).build(null).setRegistryName("rosewood_sign_tile_entity"));
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> e) {
            for (Block block : blocksWithItems)
                registerItem(e, new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));

            registerItem(e, new BordItem("aspen_sign", AdditionalBlocksConfig.enableAspen, new Item.Properties().group(ItemGroup.DECORATIONS).maxStackSize(16), aspen_sign_standing, aspen_sign));
            registerItem(e, new BordItem("baobab_sign", AdditionalBlocksConfig.enableBaobab, new Item.Properties().group(ItemGroup.DECORATIONS).maxStackSize(16), baobab_sign_standing, baobab_sign));
            registerItem(e, new BordItem("blossom_sign", AdditionalBlocksConfig.enableBlossom, new Item.Properties().group(ItemGroup.DECORATIONS).maxStackSize(16), blossom_sign_standing, blossom_sign));
            registerItem(e, new BordItem("maple_sign", AdditionalBlocksConfig.enableMaple, new Item.Properties().group(ItemGroup.DECORATIONS).maxStackSize(16), maple_sign_standing, maple_sign));
            registerItem(e, new BordItem("palm_sign", AdditionalBlocksConfig.enablePalm, new Item.Properties().group(ItemGroup.DECORATIONS).maxStackSize(16), palm_sign_standing, palm_sign));
            registerItem(e, new BordItem("rosewood_sign", AdditionalBlocksConfig.enableRosewood, new Item.Properties().group(ItemGroup.DECORATIONS).maxStackSize(16), rosewood_sign_standing, rosewood_sign));
        }

        @SubscribeEvent
        public static void onFeatureRegistry(final RegistryEvent.Register<Feature<?>> e) {
//            WorldGeneration.onFeatureRegistry(e);
        }

        @SubscribeEvent
        public static void onRecipeRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> e) {
            e.getRegistry().register(SHAPED_RECIPE_SERIALIZER.setRegistryName(new ResourceLocation("abvegedition", "shaped")));
            e.getRegistry().register(SHAPELESS_RECIPE_SERIALIZER.setRegistryName(new ResourceLocation("abvegedition", "shapeless")));
            e.getRegistry().register(FURNACE_RECIPE_SERIALIZER.setRegistryName(new ResourceLocation("abvegedition", "furnace")));
        }
    }

    public static <T extends Block> T registerBlockWithItem(RegistryEvent.Register<Block> e, T block) {
        T result = registerBlock(e, block);
        blocksWithItems.add(result);
        return result;
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
