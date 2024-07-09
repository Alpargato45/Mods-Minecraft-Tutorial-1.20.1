package net.jorge.tutorialmod.datagen.loot;

import net.jorge.tutorialmod.block.ModBlock;
import net.jorge.tutorialmod.block.custom.StrawberryCropBlock;
import net.jorge.tutorialmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlock.BLOQUE_ZAFIRO.get());
        this.dropSelf(ModBlock.BLOQUE_ZAFIRO_CRUDO.get());
        this.dropSelf(ModBlock.SOUND_BLOCK.get());

        this.add(ModBlock.ORE_ZAFIRO.get(), block -> createCopperLikeOreDrops(ModBlock.ORE_ZAFIRO.get(), ModItems.ZAFIRO.get()));
        this.add(ModBlock.DEEPSLATE_ORE_ZAFIRO.get(), block -> createCopperLikeOreDrops(ModBlock.DEEPSLATE_ORE_ZAFIRO.get(), ModItems.ZAFIRO.get()));
        this.add(ModBlock.NETHER_ORE_ZAFIRO.get(), block -> createCopperLikeOreDrops(ModBlock.NETHER_ORE_ZAFIRO.get(), ModItems.ZAFIRO.get()));
        this.add(ModBlock.END_STONE_ORE_ZAFIRO.get(), block -> createCopperLikeOreDrops(ModBlock.END_STONE_ORE_ZAFIRO.get(), ModItems.ZAFIRO.get()));

        this.dropSelf(ModBlock.ESCALERAS_DE_ZAFIRO.get());
        this.dropSelf(ModBlock.BOTON_DE_ZAFIRO.get());
        this.dropSelf(ModBlock.PLACA_DE_PRESION_DE_ZAFIRO.get());
        this.dropSelf(ModBlock.TRAMPILLA_DE_ZAFIRO.get());
        this.dropSelf(ModBlock.VALLA_DE_ZAFIRO.get());
        this.dropSelf(ModBlock.VALLA_PUERTA_DE_ZAFIRO.get());
        this.dropSelf(ModBlock.MURO_DE_ZAFIRO.get());

        this.add(ModBlock.SLAB_DE_ZAFIRO.get(),block -> createSlabItemTable(ModBlock.SLAB_DE_ZAFIRO.get()));
        this.add(ModBlock.PUERTA_DE_ZAFIRO.get(),block -> createDoorTable(ModBlock.PUERTA_DE_ZAFIRO.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlock.STRAWBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 5));

        this.add(ModBlock.STRAWBERRY_CROP.get(), createCropDrops(ModBlock.STRAWBERRY_CROP.get(), ModItems.STRAWBERRY.get(),
                ModItems.STRAWBERRY_SEEDS.get(), lootitemcondition$builder));

    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected Iterable<Block> getKnownBlocks() {
        return ModBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
