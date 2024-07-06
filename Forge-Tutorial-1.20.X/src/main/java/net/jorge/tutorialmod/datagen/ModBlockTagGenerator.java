package net.jorge.tutorialmod.datagen;

import net.jorge.tutorialmod.TutorialMod;
import net.jorge.tutorialmod.block.ModBlock;
import net.jorge.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlock.BLOQUE_ZAFIRO.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlock.BLOQUE_ZAFIRO.get(),
                        ModBlock.BLOQUE_ZAFIRO_CRUDO.get(),
                        ModBlock.ORE_ZAFIRO.get(),
                        ModBlock.NETHER_ORE_ZAFIRO.get(),
                        ModBlock.END_STONE_ORE_ZAFIRO.get(),
                        ModBlock.DEEPSLATE_ORE_ZAFIRO.get(),
                        ModBlock.SOUND_BLOCK.get()

                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlock.BLOQUE_ZAFIRO.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlock.BLOQUE_ZAFIRO_CRUDO.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlock.END_STONE_ORE_ZAFIRO.get());
    }
}
