package com.heartshopz.menu;

import com.heartshopz.HeartShopZ;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class HeartShopMenu implements Listener {

    private final String title = "§x§F§F§0§0§0§0§lHEART SHOP";
    private final FileConfiguration config = HeartShopZ.getInstance().getConfig();

    public void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9, title);

        ItemStack heartItem = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = heartItem.getItemMeta();
        meta.setDisplayName("§cBuy Heart");
        heartItem.setItemMeta(meta);

        inv.setItem(4, heartItem);
        player.openInventory(inv);

        Bukkit.getPluginManager().registerEvents(this, HeartShopZ.getInstance());
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(title)) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();

            if (e.getCurrentItem() == null) return;

            if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                if (!player.hasPermission("heartshopz.buy")) {
                    player.sendMessage("§cYou are not authorized to buy hearts!");
                    return;
                }

                // Integration point with LifestealCore
                // (Pseudo-code)
                // LifestealAPI.addHeart(player, 1);

                player.sendMessage("§aYou have successfully purchased a heart!");
                player.closeInventory();
            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        InventoryClickEvent.getHandlerList().unregister(this);
    }
}
