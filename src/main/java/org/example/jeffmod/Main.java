package org.example.jeffmod;

import net.fabricmc.api.ModInitializer;
import org.example.jeffmod.effect.ModEffects;
import org.example.jeffmod.enchantment.ModEnchantmentEffects;
import org.example.jeffmod.item.ModItems;
import org.example.jeffmod.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
    public static final String MOD_ID = "jeffmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        //LOGGER.info("Testing r3y18ruf80q3fu093qy0ahpgrahgarhiughiuhwUIPHUIRWIUGHARUIGHAUIRAEGHAAURIEGHAREIUGHAREIU");
        ModItems.registerModItems();
        ModEnchantmentEffects.registerEnchantmentEffects();
        ModEffects.registerEffects();
        ModPotions.registerPotions();
    }
}
