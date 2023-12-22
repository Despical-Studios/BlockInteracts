package me.despical.blockinteracts;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * @author Despical
 * <p>
 * Created at 22.12.2023
 */
public class Main extends JavaPlugin {

    private List<Material> blockedMaterials;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        blockedMaterials = getConfig().getStringList("blocked-materials").stream().map(Material::getMaterial).toList();

        new Events(this);
    }

    public List<Material> getBlockedMaterials() {
        return blockedMaterials;
    }
}