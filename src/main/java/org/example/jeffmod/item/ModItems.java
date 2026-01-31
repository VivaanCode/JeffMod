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

    // Define the Item
    public static final Item HEALING_BUBBLE = registerItem("healing_bubble");

    // This helper method creates the item correctly for 1.21
    private static Item registerItem(String name) {
        Identifier id = Identifier.of(Main.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(Registries.ITEM.getKey(), id);

        // Create the settings with the key ALREADY attached
        Item.Settings settings = new Item.Settings().registryKey(key).maxCount(16);

        // Create your custom item class
        HealingBubbleItem item = new HealingBubbleItem(settings);

        return Registry.register(Registries.ITEM, id, item);
    }

    public static void registerModItems() {
        Main.LOGGER.info("Registering Mod Items for " + Main.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(entries -> entries.add(HEALING_BUBBLE));
    }
}