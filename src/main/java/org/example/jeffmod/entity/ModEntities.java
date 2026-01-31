package org.example.jeffmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.example.jeffmod.Main;

public class ModEntities {

    public static final EntityType<HealingBubbleEntity> HEALING_BUBBLE_ENTITY = registerEntityType(
            "healing_bubble",
            EntityType.Builder.<HealingBubbleEntity>create(HealingBubbleEntity::new, SpawnGroup.MISC)
                    .dimensions(0.25f, 0.25f)
    );

    private static <T extends Entity> EntityType<T> registerEntityType(String name, EntityType.Builder<T> builder) {
        Identifier id = Identifier.of(Main.MOD_ID, name);

        // 1. Create the Registry Key
        RegistryKey<EntityType<?>> key = RegistryKey.of(Registries.ENTITY_TYPE.getKey(), id);

        // 2. Register the entity, passing the key into the build() method
        return Registry.register(
                Registries.ENTITY_TYPE,
                id,
                builder.build(key)
        );
    }
}