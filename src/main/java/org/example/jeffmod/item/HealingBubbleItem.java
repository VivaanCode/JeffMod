package org.example.jeffmod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.example.jeffmod.entity.HealingBubbleEntity;

public class HealingBubbleItem extends Item {
    public HealingBubbleItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        // Play the snowball throw sound
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));

        if (!world.isClient()) {
            HealingBubbleEntity bubble = new HealingBubbleEntity(world, user);
            bubble.setItem(itemStack);
            // 1.21 uses user.getPitch() and user.getYaw()
            bubble.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(bubble);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));

        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        // In 1.21, we just return ActionResult.SUCCESS (or SUCCESS_SERVER/CLIENT)
        return ActionResult.SUCCESS;
    }
}