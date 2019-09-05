package com.zundrel.wrenchanything.config;

import com.zundrel.wrenchanything.WrenchAnything;
import io.github.indicode.fabric.tinyconfig.ModConfig;

public class WrenchAnythingConfig {
    public static ModConfig wrenchableConfig = new ModConfig(WrenchAnything.MODID);
    public static boolean hasDurability = false;
    public static int maxDurability = 100;

    public static void init() {
        wrenchableConfig.configure(config -> {
            hasDurability = config.getBool("hasDurability", hasDurability, null);
            maxDurability = config.getInt("maxDurability", 100, null);
        });
    }
}
