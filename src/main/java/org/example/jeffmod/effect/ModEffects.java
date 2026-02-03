package org.example.jeffmod.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.example.jeffmod.Main;
import org.example.jeffmod.effect.custom.PurifiedEffect;

public class ModEffects {
    public static final StatusEffect PURIFIED = new StatusEffect(StatusEffectCategory.BENEFICIAL, 0xFFFFFF) {};
    public static RegistryEntry<StatusEffect> PURIFIED_ENTRY;

    public static void registerEffects() {
        PURIFIED_ENTRY = Registry.registerReference(
                Registries.STATUS_EFFECT,
                Identifier.of(Main.MOD_ID, "purified"),
                PURIFIED
        );
    }
}
