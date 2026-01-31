package org.example.jeffmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.example.jeffmod.Main;

public class ModItems {

    public static final Item HEALING_BUBBLE = registerItem(
            "healing_bubble",
            new Item.Settings()
    );

    private static Item registerItem(String name, Item.Settings settings) {
        Identifier id = Identifier.of(Main.MOD_ID, name);

        return Registry.register(
                Registries.ITEM,
                id,
                new Item(settings.registryKey(
                        RegistryKey.of(Registries.ITEM.getKey(), id)
                ))
        );
    }

    public static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(HEALING_BUBBLE);
    }

    public static void registerModItems() {
        Main.LOGGER.info("Registering Mod Items for " + Main.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(ModItems::addItemsToIngredientItemGroup);
    }
}
