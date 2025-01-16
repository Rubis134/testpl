package com.montana.testpl;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    public static Main getInstance() { return getPlugin(Main.class); }

        @Override
        public void onEnable() {
            Bukkit.broadcastMessage("TestPluginv2");
            getServer().getPluginManager().registerEvents(new Testevent(), this);
            getCommand("mt").setExecutor(new Commandetest());
            getCommand("addit").setExecutor(new AdditionChiffre());
            new InventoryManager(this);


            // Plugin startup logic

        }

        @Override
        public void onDisable() {
            // Plugin shutdown logic
        }

}
