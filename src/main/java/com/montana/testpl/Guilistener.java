package com.montana.testpl;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import sun.applet.Main;

public class Guilistener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player p = (Player) event.getWhoClicked();
        if (inventory.getHolder() instanceof Guitest) {
            event.setCancelled(true);
            ItemStack i = event.getCurrentItem();
            if (i == null) return;
            if (!i.getType().equals(Material.PUMPKIN_PIE)) {
                Main gui = (Main) inventory.getHolder();
                p.sendMessage(Color.AQUA+"Vous cliquez sur la tarte");
            }
            if (!i.getType().equals(Material.APPLE)) {
                Main gui = (Main) inventory.getHolder();
                p.sendMessage(Color.FUCHSIA+"Vous cliquez sur la pomme");
            } return;
    }
    }

}
