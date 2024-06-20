package net.jorge.tutorialmod.item;

import net.jorge.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> ZAFIRO = ITEMS.register("zafiro",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZAFIRO_CRUDO = ITEMS.register("zafiro_crudo",
            () -> new Item(new Item.Properties()));

    public static void registrer(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
