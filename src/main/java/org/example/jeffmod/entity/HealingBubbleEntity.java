package org.example.jeffmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack; // Added this import
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import org.example.jeffmod.item.ModItems;

public class HealingBubbleEntity extends ThrownItemEntity {
    public HealingBubbleEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public HealingBubbleEntity(World world, LivingEntity owner) {
        // 1.21 requires an ItemStack here to initialize the projectile's data
        super(ModEntities.HEALING_BUBBLE_ENTITY, owner, world, new ItemStack(ModItems.HEALING_BUBBLE));
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.HEALING_BUBBLE;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();

        if (entity instanceof LivingEntity thing) {
            thing.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0));
            thing.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1));
            thing.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 1));
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);

    }
}