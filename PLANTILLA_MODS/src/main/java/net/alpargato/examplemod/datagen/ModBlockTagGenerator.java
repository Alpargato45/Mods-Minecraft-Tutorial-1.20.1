package net.alpargato.examplemod.datagen;

import net.alpargato.examplemod.ExampleMod;
import net.alpargato.examplemod.block.ModBlocks;
import net.alpargato.examplemod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
        //        .add(ModBlocks.BLOQUE_ZAFIRO.get()).addTag(Tags.Blocks.ORES);

        //this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                //.add(ModBlocks.BLOQUE_ZAFIRO.get(),
                //        ModBlocks.BLOQUE_ZAFIRO_CRUDO.get()
        //        );

        //this.tag(BlockTags.NEEDS_IRON_TOOL)
        //        .add(ModBlocks.BLOQUE_ZAFIRO.get());

        //this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
        //        .add(ModBlocks.END_STONE_ORE_ZAFIRO.get());
    }
}