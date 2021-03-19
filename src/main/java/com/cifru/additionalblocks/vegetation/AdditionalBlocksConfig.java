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

    static {
        ModConfigBuilder config = new ModConfigBuilder("abvegedition");
        config.push("blocks");
        enableAspen = config.comment("if true, Aspen Wood Blocks are enabled").define("enableAspen", true);

        config.pop();

        config.build();
    }
}
