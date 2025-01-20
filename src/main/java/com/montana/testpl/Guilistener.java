package com.montana.testpl;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Guilistener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player p = (Player) event.getWhoClicked();
        Economy econ = Main.getEconomy();
        double balance = econ.getBalance(p);
        if (inventory.getHolder() instanceof Guitest) {
            event.setCancelled(true);
            ItemStack i = event.getCurrentItem();
            if (i == null) return;
            if (!i.getType().equals(Material.PUMPKIN_PIE)) {
                if (balance >= 15){
                    econ.withdrawPlayer(p, 25);
                    Guitest gui = (Guitest) inventory.getHolder();
                    p.sendMessage(Color.AQUA+"Vous achetez une tarte à 25$, cher en vrai un peu");
                } else {
                    p.sendMessage("§cVous n'avez pas assez d'argent pour acheter cette tarte !");
                }
            }
            if (!i.getType().equals(Material.APPLE)) {
                if (balance >= 5) {
                    econ.withdrawPlayer(p, 5);
                    Guitest gui = (Guitest) inventory.getHolder();
                    p.sendMessage(Color.FUCHSIA+"Vous achetez la pomme");
                    
                }
            } return;
    }
    }

}
