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

                world.setTime(currentTime+200);
            }
        } .runTaskTimer(Main.getInstance(), 0L, 1200L);
    }
}




