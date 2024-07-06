package net.jorge.tutorialmod.datagen;

import net.jorge.tutorialmod.TutorialMod;
import net.jorge.tutorialmod.block.ModBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlock.BLOQUE_ZAFIRO);
        blockWithItem(ModBlock.BLOQUE_ZAFIRO_CRUDO);

        blockWithItem(ModBlock.ORE_ZAFIRO);
        blockWithItem(ModBlock.DEEPSLATE_ORE_ZAFIRO);
        blockWithItem(ModBlock.END_STONE_ORE_ZAFIRO);
        blockWithItem(ModBlock.NETHER_ORE_ZAFIRO);

        blockWithItem(ModBlock.SOUND_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
