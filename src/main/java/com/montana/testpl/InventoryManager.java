package com.montana.testpl;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


// Cette classse a été faite pour potentiellement être ré utilisé sur Montana, en gros je voulais
// "supprimer" des slots de l'inventaire
// Jme suis beaucoup utilisé de ChatGPT (pour sélect les slots (les numéros tout ça), ou faire une loop avec du temps comme ça

public class InventoryManager {

    // Indices des slots concernés : la rangée du bas
    private final int START_SLOT = 27;  // La rangée du bas commence à l'index 27
    private final int END_SLOT = 35;    // La rangée du bas finit à l'index 35

    private final JavaPlugin plugin;

    public InventoryManager(JavaPlugin plugin) {
        this.plugin = plugin;
        startInventoryCheckTask();
    }

    // Méthode pour démarrer le scheduler qui vérifie les slots toutes les 5 secondes
    private void startInventoryCheckTask() {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                // Vérifie si le joueur est OP, et s'il l'est, on ne fait rien
                if (player.isOp()) {
                    continue; // Ignore le joueur si c'est un OP
                }

                Inventory inventory = player.getInventory();

                // Vérifie les slots bloqués de la rangée du bas
                for (int i = START_SLOT; i <= END_SLOT; i++) {
                    ItemStack item = inventory.getItem(i);
                    if (item != null && item.getType() != Material.AIR) {
                        // Drop l'item au sol
                        player.getWorld().dropItemNaturally(player.getLocation(), item);
                        // Vide le slot
                        inventory.setItem(i, new ItemStack(Material.AIR));
                    }
                }
            }
        }, 0L, 100L); // 100 ticks = 5 secondes
    }
}
