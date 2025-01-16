package com.montana.testpl;

import com.sun.istack.internal.NotNull;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class Guitest implements InventoryHolder {

    private final Inventory inventory;

    public Guitest(Player p, Main instance) {

        this.inventory = instance.getServer().createInventory(this, 9, "Test");
        ItemStack tarte = new ItemStack(Material.PUMPKIN_PIE, 4);
        ItemStack pomme = new ItemStack(Material.APPLE, 2);
        this.getInventory().setItem(4, tarte);
        this.getInventory().setItem(6, pomme);
        }

    @Override
    public @NotNull Inventory getInventory() {
        return this.inventory;
    }
}
