package br.com.flp.dailyreward.service;

import br.com.flp.dailyreward.DailyRewardPlugin;
import br.com.flp.dailyreward.repository.PlayerDataRepository;
import org.bukkit.entity.Player;

import java.util.UUID;

public class RewardService {
	
	private final DailyRewardPlugin plugin;
	private final PlayerDataRepository repository;
	
	public RewardService(DailyRewardPlugin plugin, PlayerDataRepository repository) {
		this.plugin = plugin;
		this.repository = repository;
	}
	
	public boolean canClaim(UUID uuid) {
		long last = repository.getLastClaim(uuid);
		long cooldown = plugin.getConfig().getLong("cooldown");
		return System.currentTimeMillis() - last >= cooldown;
	}
	
	public long getRemaining(UUID uuid) {
		long last = repository.getLastClaim(uuid);
		long cooldown = plugin.getConfig().getLong("cooldown");
		
		long remaining = (last + cooldown) - System.currentTimeMillis();
		return Math.max(remaining, 0);
	}
	
	public void claim(Player player) {
		repository.setLastClaim(player.getUniqueId(), System.currentTimeMillis());
		
		int money = plugin.getConfig().getInt("reward");
		
		player.sendMessage("§aVocê recebeu $" + money);
		
		// SEM PL DE ECONOMIA POR ENQUANTO '-'
	}
	
}