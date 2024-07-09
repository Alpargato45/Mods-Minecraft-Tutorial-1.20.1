package net.jorge.tutorialmod.item;

import net.jorge.tutorialmod.TutorialMod;
import net.jorge.tutorialmod.block.ModBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ZAFIRO.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ZAFIRO.get());
                        pOutput.accept(ModItems.ZAFIRO_CRUDO.get());
                        pOutput.accept(ModBlock.BLOQUE_ZAFIRO.get());

                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.PINE_CONE.get());

                        pOutput.accept(ModBlock.BLOQUE_ZAFIRO_CRUDO.get());
                        pOutput.accept(ModBlock.SOUND_BLOCK.get());

                        pOutput.accept(ModBlock.ORE_ZAFIRO.get());
                        pOutput.accept(ModBlock.DEEPSLATE_ORE_ZAFIRO.get());
                        pOutput.accept(ModBlock.NETHER_ORE_ZAFIRO.get());
                        pOutput.accept(ModBlock.END_STONE_ORE_ZAFIRO.get());


                        pOutput.accept(ModBlock.ESCALERAS_DE_ZAFIRO.get());
                        pOutput.accept(ModBlock.SLAB_DE_ZAFIRO.get());
                        pOutput.accept(ModBlock.BOTON_DE_ZAFIRO.get());
                        pOutput.accept(ModBlock.PLACA_DE_PRESION_DE_ZAFIRO.get());
                        pOutput.accept(ModBlock.VALLA_DE_ZAFIRO.get());
                        pOutput.accept(ModBlock.VALLA_PUERTA_DE_ZAFIRO.get());
                        pOutput.accept(ModBlock.MURO_DE_ZAFIRO.get());
                        pOutput.accept(ModBlock.PUERTA_DE_ZAFIRO.get());
                        pOutput.accept(ModBlock.TRAMPILLA_DE_ZAFIRO.get());


                        pOutput.accept(ModItems.SAPPHIRE_STAFF.get());


                        pOutput.accept(ModItems.SAPPHIRE_SWORD.get());
                        pOutput.accept(ModItems.SAPPHIRE_PICKAXE.get());
                        pOutput.accept(ModItems.SAPPHIRE_AXE.get());
                        pOutput.accept(ModItems.SAPPHIRE_SHOVEL.get());
                        pOutput.accept(ModItems.SAPPHIRE_HOE.get());


                        pOutput.accept(ModItems.SAPPHIRE_HELMET.get());
                        pOutput.accept(ModItems.SAPPHIRE_CHESTPLATE.get());
                        pOutput.accept(ModItems.SAPPHIRE_LEGGINGS.get());
                        pOutput.accept(ModItems.SAPPHIRE_BOOTS.get());

                        pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());
                    })
                    .build());

    public static void registrer(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
