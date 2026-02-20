package org.example.jeffmod.loottables;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetPotionLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import org.example.jeffmod.potion.ModPotions;

public class ModLootTables {
    public static void register() {
        LootTableEvents.MODIFY.register((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (registryKey.equals(LootTables.FISHING_TREASURE_GAMEPLAY) || registryKey.equals(LootTables.BURIED_TREASURE_CHEST) || registryKey.equals(LootTables.SHIPWRECK_TREASURE_CHEST) || registryKey.equals(LootTables.WOODLAND_MANSION_CHEST)) {
                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(Items.POTION)
                                .apply(SetPotionLootFunction.builder(ModPotions.PURIFIED_POTION_ENTRY))
                                .weight(2));

                builder.pool(pool);
            }
        });
    }
}
