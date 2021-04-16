package com.cifru.additionalblocks.vegetation.boat;

import com.cifru.additionalblocks.vegetation.AdditionalBlocks;
import com.cifru.additionalblocks.vegetation.AdditionalBlocksConfig;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

import java.util.function.Supplier;

/**
 * Created 4/16/2021 by SuperMartijn642
 */
public enum VBoatType {

    ASPEN(0, "aspen_boat", () -> AdditionalBlocks.aspen_planks, AdditionalBlocksConfig.enableAspen);

    private final int index;
    private final String registryName;
    private final Supplier<Block> plank;
    private Item item;
    private final ResourceLocation texture;
    private final Supplier<Boolean> enabled;

    VBoatType(int index, String registryName, Supplier<Block> plank, Supplier<Boolean> isEnabled){
        this.index = index;
        this.registryName = registryName;
        this.plank = plank;
        this.enabled = isEnabled;
        this.texture = new ResourceLocation("abvegedition:textures/" + registryName + ".png");
    }

    public String getRegistryName(){
        return this.registryName;
    }

    public Block getPlank(){
        return this.plank.get();
    }

    public Item getItem(){
        return this.item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public ResourceLocation getTexture(){
        return this.texture;
    }

    public int getIndex(){
        return this.index;
    }

    public Item.Properties getItemProperties(){
        return new Item.Properties().group(ItemGroup.TRANSPORTATION).maxStackSize(1);
    }

    public boolean isEnabled(){
        return this.enabled.get();
    }

    public static VBoatType fromIndex(int index){
        for(VBoatType type : values())
            if(type.index == index)
                return type;
        return null;
    }
}
