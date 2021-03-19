package com.cifru.additionalblocks.vegetation;

import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

/**
 * Created 1/29/2021 by SuperMartijn642
 */
public class AdditionalBlocksRecipes {

    private static boolean checkIngredients(Iterable<Ingredient> ingredients){
        for(Ingredient ingredient : ingredients){
            ItemStack[] itemStacks = ingredient.getMatchingStacks();
            if(itemStacks.length == 1 && !checkItemStack(itemStacks[0]))
                return false;
        }
        return true;
    }

    private static boolean checkItemStack(ItemStack stack){
        Item item = stack.getItem();
        if(item instanceof IConfigObject){
            if(!((IConfigObject)item).isEnabled())
                return false;
        }else if(item instanceof BlockItem){
            Block block = ((BlockItem)item).getBlock();
            if(block instanceof IConfigObject && !((IConfigObject)block).isEnabled())
                return false;
        }
        return true;
    }

    public static class ShapedSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ShapedRecipe> {
        @Override
        public ShapedRecipe read(ResourceLocation recipeId, JsonObject json){
            ShapedRecipe recipe = IRecipeSerializer.CRAFTING_SHAPED.read(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getRecipeOutput()) ? recipe : null;
        }

        @Nullable
        @Override
        public ShapedRecipe read(ResourceLocation recipeId, PacketBuffer buffer){
            ShapedRecipe recipe = IRecipeSerializer.CRAFTING_SHAPED.read(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getRecipeOutput()) ? recipe : null;
        }

        @Override
        public void write(PacketBuffer buffer, ShapedRecipe recipe){
            IRecipeSerializer.CRAFTING_SHAPED.write(buffer, recipe);
        }
    }

    public static class ShapelessSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ShapelessRecipe> {
        @Override
        public ShapelessRecipe read(ResourceLocation recipeId, JsonObject json){
            ShapelessRecipe recipe = IRecipeSerializer.CRAFTING_SHAPELESS.read(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getRecipeOutput()) ? recipe : null;
        }

        @Nullable
        @Override
        public ShapelessRecipe read(ResourceLocation recipeId, PacketBuffer buffer){
            ShapelessRecipe recipe = IRecipeSerializer.CRAFTING_SHAPELESS.read(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getRecipeOutput()) ? recipe : null;
        }

        @Override
        public void write(PacketBuffer buffer, ShapelessRecipe recipe){
            IRecipeSerializer.CRAFTING_SHAPELESS.write(buffer, recipe);
        }
    }

    public static class FurnaceSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<FurnaceRecipe> {
        @Override
        public FurnaceRecipe read(ResourceLocation recipeId, JsonObject json){
            FurnaceRecipe recipe = IRecipeSerializer.SMELTING.read(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getRecipeOutput()) ? recipe : null;
        }

        @Nullable
        @Override
        public FurnaceRecipe read(ResourceLocation recipeId, PacketBuffer buffer){
            FurnaceRecipe recipe = IRecipeSerializer.SMELTING.read(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getRecipeOutput()) ? recipe : null;
        }

        @Override
        public void write(PacketBuffer buffer, FurnaceRecipe recipe){
            IRecipeSerializer.SMELTING.write(buffer, recipe);
        }
    }
}
