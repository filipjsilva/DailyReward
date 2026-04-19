package br.com.flp.dailyreward.repository;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class PlayerDataRepository {
	
	private final JavaPlugin plugin;
	private final FileConfiguration config;
	
	public PlayerDataRepository(JavaPlugin plugin) {
		this.plugin = plugin;
		this.config = plugin.getConfig();
	}
		
	public long getLastClaim(UUID uuid) {
		return config.getLong("players." + uuid + ".last", 0);
	}
	
	public void setLastClaim(UUID uuid, long time) {
		config.set("players." + uuid + ".last", time);
		plugin.saveConfig();
	}
	
}