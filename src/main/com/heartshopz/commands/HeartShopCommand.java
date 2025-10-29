package com.heartshopz.commands;

import com.heartshopz.menu.HeartShopMenu;
import com.heartshopz.HeartShopZ;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HeartShopCommand implements CommandExecutor {

    private final String prefix = "§x§F§F§0§0§0§0§lHEART SHOP §7» ";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(prefix + "§cOnly players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("heartshopz.use")) {
            player.sendMessage(prefix + "§cYou are not authorized to use this command!");
            return true;
        }

        new HeartShopMenu().open(player);
        return true;
    }
}
