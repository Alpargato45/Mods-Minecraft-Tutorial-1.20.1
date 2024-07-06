package net.jorge.tutorialmod.datagen;

import net.jorge.tutorialmod.TutorialMod;
import net.jorge.tutorialmod.block.ModBlock;
import net.jorge.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ZAFIRO_SMELTABLES = List.of(ModItems.ZAFIRO_CRUDO.get(),
            ModBlock.NETHER_ORE_ZAFIRO.get(), ModBlock.DEEPSLATE_ORE_ZAFIRO.get(),ModBlock.END_STONE_ORE_ZAFIRO.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, ZAFIRO_SMELTABLES, RecipeCategory.MISC, ModItems.ZAFIRO.get(), 0.25f, 200, "zafiro");
        oreBlasting(pWriter, ZAFIRO_SMELTABLES, RecipeCategory.MISC, ModItems.ZAFIRO.get(), 0.25f, 100, "zafiro");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.BLOQUE_ZAFIRO.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.ZAFIRO.get())
                .unlockedBy(getHasName(ModItems.ZAFIRO.get()), has(ModItems.ZAFIRO.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ZAFIRO.get(), 9)
                .requires(ModBlock.BLOQUE_ZAFIRO.get())
                .unlockedBy(getHasName(ModBlock.BLOQUE_ZAFIRO.get()), has(ModBlock.BLOQUE_ZAFIRO.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
