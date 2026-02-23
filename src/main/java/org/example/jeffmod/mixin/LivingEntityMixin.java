package org.example.jeffmod.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import org.example.jeffmod.effect.ModEffects;
import org.example.jeffmod.enchantment.ModEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow
    public abstract boolean hasStatusEffect(RegistryEntry<StatusEffect> effect);

    @Inject(method = "canHaveStatusEffect", at = @At("HEAD"), cancellable = true)
    private void doPurified(StatusEffectInstance effect, CallbackInfoReturnable<Boolean> cir) {
        if (this.hasStatusEffect(ModEffects.PURIFIED_ENTRY)) {
            if (!effect.getEffectType().value().isBeneficial()) {
                cir.setReturnValue(false);
            }
        }
    }

    @Inject(method = "damage", at=@At("HEAD"), cancellable = true)
    private void doPacifist(ServerWorld world, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (source.getAttacker() instanceof LivingEntity attacker) {
            int level = EnchantmentHelper.getLevel(
                    world.getRegistryManager()
                            .getOrThrow(RegistryKeys.ENCHANTMENT)
                            .getOrThrow(ModEnchantments.PACIFIST),
                    attacker.getMainHandStack()
            );

            if (level > 0) {
                LivingEntity victim = (LivingEntity) (Object) this;

                victim.heal(amount);
                cir.setReturnValue(false);
            }
        }
    }

}