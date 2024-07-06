package net.jorge.tutorialmod.item;

import net.jorge.tutorialmod.TutorialMod;
import net.jorge.tutorialmod.item.custom.FuelItem;
import net.jorge.tutorialmod.item.custom.MetalDetectorItem;
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

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100))); //Al crear objeto personalizado, no es un item

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 400));


    public static void registrer(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
