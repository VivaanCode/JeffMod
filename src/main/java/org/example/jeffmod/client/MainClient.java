package org.example.jeffmod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import org.example.jeffmod.entity.ModEntities;

public class MainClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // This links the entity to a visual renderer
        EntityRendererRegistry.register(ModEntities.HEALING_BUBBLE_ENTITY, FlyingItemEntityRenderer::new);
    }
}