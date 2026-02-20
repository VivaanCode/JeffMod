package org.example.jeffmod.potion;

import net.minecraft.potion.Potion;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.example.jeffmod.Main;
import org.example.jeffmod.effect.ModEffects;

public class ModPotions {
    public static final RegistryEntry<Potion> PURIFIED_POTION_ENTRY = Registry.registerReference(
            Registries.POTION,
            Identifier.of(Main.MOD_ID, "purified"),
            new Potion("purified", new StatusEffectInstance(ModEffects.PURIFIED_ENTRY, 3600))
    );

    public static void registerPotions() {
        Main.LOGGER.info("Registering Mod Potions for {}", Main.MOD_ID);
    }
}
