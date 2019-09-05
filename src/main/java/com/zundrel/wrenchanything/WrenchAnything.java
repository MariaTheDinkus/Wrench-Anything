package com.zundrel.wrenchanything;

import com.zundrel.wrenchanything.config.WrenchAnythingConfig;
import com.zundrel.wrenchanything.items.WrenchItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WrenchAnything implements ModInitializer {
    public static String MODID = "wrenchanything";

    public static WrenchItem WRENCH;

	@Override
	public void onInitialize() {
	    WrenchAnythingConfig.init();

	    if (!WrenchAnythingConfig.hasDurability) {
            WRENCH = Registry.register(Registry.ITEM, new Identifier(MODID, "wrench"), new WrenchItem());
        } else {
            WRENCH = Registry.register(Registry.ITEM, new Identifier(MODID, "wrench"), new WrenchItem(WrenchAnythingConfig.maxDurability));
        }
	}
}
