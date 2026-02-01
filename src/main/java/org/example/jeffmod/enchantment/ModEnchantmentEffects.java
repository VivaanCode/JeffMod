package org.example.jeffmod.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.example.jeffmod.Main;
import org.example.jeffmod.enchantment.custom.PacifistEnchantmentEffect;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends  EnchantmentEntityEffect> PACIFIST =
            registerEntityEffect("pacifist", PacifistEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Main.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        Main.LOGGER.info("Registering Mod Enchant Effects for " + Main.MOD_ID);
    }
}
