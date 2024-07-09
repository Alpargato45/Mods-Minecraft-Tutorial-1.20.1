package net.jorge.tutorialmod.datagen;

import net.jorge.tutorialmod.TutorialMod;
import net.jorge.tutorialmod.block.ModBlock;
import net.jorge.tutorialmod.block.custom.StrawberryCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

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

        stairsBlock(((StairBlock) ModBlock.ESCALERAS_DE_ZAFIRO.get()),blockTexture(ModBlock.BLOQUE_ZAFIRO.get()));
        slabBlock(((SlabBlock) ModBlock.SLAB_DE_ZAFIRO.get()),blockTexture(ModBlock.BLOQUE_ZAFIRO.get()),blockTexture(ModBlock.BLOQUE_ZAFIRO.get()));

        buttonBlock(((ButtonBlock) ModBlock.BOTON_DE_ZAFIRO.get()),blockTexture(ModBlock.BLOQUE_ZAFIRO.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlock.PLACA_DE_PRESION_DE_ZAFIRO.get()),blockTexture(ModBlock.BLOQUE_ZAFIRO.get()));

        fenceBlock(((FenceBlock) ModBlock.VALLA_DE_ZAFIRO.get()),blockTexture(ModBlock.BLOQUE_ZAFIRO.get()));
        fenceGateBlock(((FenceGateBlock) ModBlock.VALLA_PUERTA_DE_ZAFIRO.get()),blockTexture(ModBlock.BLOQUE_ZAFIRO.get()));
        wallBlock(((WallBlock) ModBlock.MURO_DE_ZAFIRO.get()),blockTexture(ModBlock.BLOQUE_ZAFIRO.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlock.PUERTA_DE_ZAFIRO.get()),modLoc("block/puerta_de_zafiro_bottom"),modLoc("block/puerta_de_zafiro_top"),"cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlock.TRAMPILLA_DE_ZAFIRO.get()),modLoc("block/trampilla_de_zafiro"),true,"cutout");

        makeStrawberryCrop((CropBlock) ModBlock.STRAWBERRY_CROP.get(),"strawberry_stage","strawberry_stage");

    }

    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(TutorialMod.MOD_ID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
