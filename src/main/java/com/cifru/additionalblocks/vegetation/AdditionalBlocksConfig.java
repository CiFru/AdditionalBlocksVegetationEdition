package com.cifru.additionalblocks.vegetation;

import com.supermartijn642.configlib.ModConfigBuilder;

import java.util.function.Supplier;

/**
 * Created 11/30/2020 by SuperMartijn642
 */
public class AdditionalBlocksConfig {

    public static void create(){
    }

    public static final Supplier<Boolean> enableMarble;

    static {
        ModConfigBuilder config = new ModConfigBuilder("abvegedition");
        config.push("blocks");
        enableMarble = config.comment("if true, Marble Blocks are enabled").define("enableMarble", true);

        config.pop();

        config.build();
    }
}
