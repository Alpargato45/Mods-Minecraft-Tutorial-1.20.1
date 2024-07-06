package net.alpargato.examplemod.item;

import net.alpargato.examplemod.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);

    //public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("example_tab", //TODO: CAMBIAR NOMBRE POR EL QUE SE QUIERA
            //() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ZAFIRO.get()))
            //        .title(Component.translatable("creativetab.tutorial_tab"))//AQUI TAMBIEN
            //        .displayItems((pParameters, pOutput) -> {
            //            pOutput.accept(ModItems.ZAFIRO.get());
            //            pOutput.accept(ModBlock.BLOQUE_ZAFIRO.get());
            //        })
            //        .build());

    public static void registrer(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
