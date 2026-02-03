package org.example.jeffmod.effect.custom;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class PurifiedEffect extends StatusEffect{
    public PurifiedEffect(StatusEffectCategory category, int color) {
        super(StatusEffectCategory.BENEFICIAL, 0xFFFFFF);
    }
}
