package com.montana.testpl;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {
    private static Economy econ = null;

    public static Main getInstance() { return getPlugin(Main.class); }

        @Override
        public void onEnable() {
            Bukkit.broadcastMessage("TestPluginv2");
            getServer().getPluginManager().registerEvents(new Testevent(), this);
            getCommand("mt").setExecutor(new Commandetest());
            getCommand("addit").setExecutor(new AdditionChiffre());
            new InventoryManager(this);
            getServer().getPluginManager().registerEvents(new Guilistener(), this);
            new TimePlugin().ajusterTempsJourNuit();



            // Plugin startup logic

        }

        @Override
        public void onDisable() {
            // Plugin shutdown logic
        }


        private boolean setupEconomy() {
            if (getServer().getPluginManager().getPlugin("Vault") == null) {
                return false;
            }
            RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
            if (rsp == null) {
                return  false;
            }
            econ = rsp.getProvider();
            return econ != null;
        }

        public static Economy getEconomy() {
        return econ;
        }



}

