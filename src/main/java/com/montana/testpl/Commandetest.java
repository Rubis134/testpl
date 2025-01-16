package com.montana.testpl;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Commandetest implements CommandExecutor {

    private Economy economy;
    public Commandetest(){
        RegisteredServiceProvider<Economy> registeredServiceProvider = Main.getInstance().getServer().getServicesManager().getRegistration(Economy.class);
        if (registeredServiceProvider != null) {
            economy = registeredServiceProvider.getProvider();
        }
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings){
        Player p= (Player) commandSender;
        if (p.isOp()){
            p.sendMessage("test");
            Location l= new Location(p.getWorld(), 0,100,0);
            p.teleport(l);
            Guitest itst = new Guitest(p, Main.getInstance());
            p.openInventory(itst.getInventory());
            if (economy.getBalance(p) > 150) {
                economy.withdrawPlayer(p, 150);
            }
            else {
                p.sendMessage("Tu as pas bcp d'argent");
            }
        } else{
            p.sendMessage("cheh");
        }
        return false;
    }
}
