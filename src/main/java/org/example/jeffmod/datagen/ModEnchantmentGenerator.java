package org.example.jeffmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.example.jeffmod.Main;

import java.util.concurrent.CompletableFuture;

public class ModEnchantmentGenerator extends FabricDynamicRegistryProvider {

    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    }

    public ModEnchantmentGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        RegistryKey<Enchantment> pacifistEnchant = RegistryKey.of(
                RegistryKeys.ENCHANTMENT,
                Identifier.of(Main.MOD_ID, "pacifist")
        );

        entries.addAll(registries.getOrThrow(RegistryKeys.ENCHANTMENT));
    }

    @Override
    public String getName() {
        return "";
    }
}