package net.gabs.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.gabs.testmod.TestMod;
import net.gabs.testmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup GOLDEN_GOLD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "golden_gold_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GOLDEN_GOLD))
                    .displayName(Text.translatable("itemgroup.testmod.golden_gold_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.GOLDEN_GOLD);
                        entries.add(ModItems.RAW_GOLDEN_GOLD);
                    }).build());
    public static final ItemGroup GOLDEN_GOLD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "golden_gold_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.GOLDEN_GOLD_BLOCK))
                    .displayName(Text.translatable("itemgroup.testmod.golden_gold_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.GOLDEN_GOLD_BLOCK);
                        entries.add(ModBlocks.RAW_GOLDEN_GOLD_BLOCK);
                    }).build());


    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for " + TestMod.MOD_ID);
    }
}
