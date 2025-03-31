package net.gabs.testmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gabs.testmod.TestMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block GOLDEN_GOLD_BLOCK = registerBlock("golden_gold_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_GOLDEN_GOLD_BLOCK = registerBlock("raw_golden_gold_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds((BlockSoundGroup.AMETHYST_CLUSTER))));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TestMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering Mod Blocks for" + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.GOLDEN_GOLD_BLOCK);
            entries.add(ModBlocks.RAW_GOLDEN_GOLD_BLOCK);
        });
    }
}
