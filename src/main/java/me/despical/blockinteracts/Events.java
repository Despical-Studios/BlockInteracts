package me.despical.blockinteracts;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * @author Despical
 * <p>
 * Created at 22.12.2023
 */
public class Events implements Listener {

    private final Main plugin;

    public Events(Main plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (!event.getAction().isRightClick()) return;
        if (event.getClickedBlock() == null) return;

        if (plugin.getBlockedMaterials().contains(event.getClickedBlock().getType())) {
            event.setCancelled(true);
        }
    }
}