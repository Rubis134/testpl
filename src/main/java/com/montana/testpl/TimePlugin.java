package com.montana.testpl;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class TimePlugin {

    public void ajusterTempsJourNuit() {
        new BukkitRunnable() {
            @Override
            public void run() {
                World world = Bukkit.getWorlds().get(0);
                long currentTime = world.getTime();

                // Avancer l'heure toutes les 200 ticks (1min réelle)

                world.setTime(currentTime+25);
            }
        } .runTaskTimer(Main.getInstance(), 0L, 150L);
    }
}



// Choses à savoir pour le temps :
// 24h en jeu = 24 000 ticks
// une journée/une nuit = 12 000 ticks
// ici on change tout les 150L (7.5s)
// pour ajouter 25 au temps
// ça met donc 2h pour faire 24h en jeu



