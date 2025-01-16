package com.montana.testpl;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdditionChiffre implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args){
        Player p= (Player) commandSender;
        if (args.length != 2){
            p.sendMessage("Vous additionnez:");
            p.sendMessage("Tu additionnes:" + (args[0]) + args[1] + args[2]);
            int nombre1 = Integer.parseInt(args[0]);
            int nombre2 = Integer.parseInt(args[1]);
            int nombre3 = Integer.parseInt(args[2]);

            int somme = nombre1 + nombre2 + nombre3;

            p.sendMessage("La somme est"+somme);
        } else {
            p.sendMessage("Il faut mettre des numéros à additionner");
        }
        return true;
    }
}
