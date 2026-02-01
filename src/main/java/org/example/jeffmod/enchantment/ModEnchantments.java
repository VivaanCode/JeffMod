package org.example.jeffmod.enchantment;

import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.floatprovider.ConstantFloatProvider;
import org.example.jeffmod.Main;
import org.example.jeffmod.enchantment.custom.PacifistEnchantmentEffect;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> PACIFIST =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Main.MOD_ID, "pacifist"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        // We use registerable.register directly to avoid potential helper method issues
        registerable.register(PACIFIST, Enchantment.builder(
                        Enchantment.definition(
                                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                5, // weight
                                1, // max level
                                Enchantment.leveledCost(30, 1),
                                Enchantment.leveledCost(30, 1),
                                30,
                                AttributeModifierSlot.MAINHAND ))

                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM,
                        new PacifistEnchantmentEffect())
                .build(PACIFIST.getValue()));
    }

    public static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
