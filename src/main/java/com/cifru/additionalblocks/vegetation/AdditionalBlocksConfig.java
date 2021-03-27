package com.cifru.additionalblocks.vegetation;

import com.supermartijn642.configlib.ModConfigBuilder;

import java.util.function.Supplier;

/**
 * Created 11/30/2020 by SuperMartijn642
 */
public class AdditionalBlocksConfig {

    public static void create(){
    }

    public static final Supplier<Boolean> enableAspen;
    public static final Supplier<Boolean> enableBlossom;
    public static final Supplier<Boolean> enableBaobab;
    public static final Supplier<Boolean> enableMaple;
    public static final Supplier<Boolean> enablePalm;
    public static final Supplier<Boolean> enableRosewood;

    static {
        ModConfigBuilder config = new ModConfigBuilder("abvegedition");
        config.push("blocks");
        enableAspen = config.comment("if true, Aspen Wood Blocks are enabled").define("enableAspen", true);
        enableBlossom = config.comment("if true, Blossom Wood Blocks are enabled").define("enableBlossom", true);
        enableBaobab = config.comment("if true, Baobab Wood Blocks are enabled").define("enableBaobab", true);
        enableMaple = config.comment("if true, Maple Wood Blocks are enabled").define("enableMaple", true);
        enablePalm = config.comment("if true, Palm Wood Blocks are enabled").define("enablePalm", true);
        enableRosewood = config.comment("if true, Rosewood Wood Blocks are enabled").define("enableRosewood", true);

        config.pop();

        config.build();
    }
}
