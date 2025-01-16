package com.montana.testpl;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class Testevent implements Listener {
    @EventHandler
    public void PlayerRejoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("tu as" + p.getFoodLevel());
    }

    @EventHandler
    public void QuandJoueurQuitte(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("" + p.getExp());
    }

    @EventHandler
    public void QuandBlockCasse(BlockBreakEvent e) {
        if (!e.getPlayer().isOp()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void NpcClic(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        Entity pnj = e.getRightClicked();
        if (pnj.getType() == EntityType.VILLAGER) {
            if (pnj.getCustomName().equalsIgnoreCase("Michel")){
                p.sendMessage("Salut moi c'est Michel");
            }
            if (p.isOp()) {
                ItemStack pomme = new ItemStack(Material.APPLE, 5);
                Location pnjloc = e.getRightClicked().getLocation();
                p.getInventory().addItem(pomme);
                p.sendMessage("Je te donne quelques pommes");
                p.spawnParticle(Particle.VILLAGER_ANGRY, pnjloc, 10, 0.5, 0.5, 0.5, 0.1);

            } else {
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
                p.sendMessage("Pas op donc pas de pommes");
            }
        }

    }
}
