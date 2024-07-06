package net.jorge.tutorialmod.datagen.loot;

import net.jorge.tutorialmod.block.ModBlock;
import net.jorge.tutorialmod.item.ModItems;
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
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected Iterable<Block> getKnownBlocks() {
        return ModBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
