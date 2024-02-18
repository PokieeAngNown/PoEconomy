package cn.postudio.poeconomy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public final class PoEconomy extends JavaPlugin {

    public static Plugin getPlugin(){
        return Bukkit.getPluginManager().getPlugin("PoEconomy");
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Economy(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
