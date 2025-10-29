package com.heartshopz;

import org.bukkit.plugin.java.JavaPlugin;
import com.heartshopz.commands.HeartShopCommand;

public class HeartShopZ extends JavaPlugin {

    private static HeartShopZ instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getCommand("heartshop").setExecutor(new HeartShopCommand());
        getLogger().info("HeartShopZ v1.0.0 enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("HeartShopZ disabled!");
    }

    public static HeartShopZ getInstance() {
        return instance;
    }
}
