package org.example.jeffmod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record PacifistEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<PacifistEnchantmentEffect> CODEC = MapCodec.unit(PacifistEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (user instanceof LivingEntity victim && context.owner() instanceof LivingEntity attacker) {
            double damageAmount = attacker.getAttributeValue(EntityAttributes.ATTACK_DAMAGE);
            victim.heal((float) damageAmount);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
