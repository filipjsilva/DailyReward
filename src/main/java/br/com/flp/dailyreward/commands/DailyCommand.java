package br.com.flp.dailyreward.commands;

import br.com.flp.dailyreward.service.RewardService;
import br.com.flp.dailyreward.utils.Timer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DailyCommand implements CommandExecutor {
	
	private final RewardService service;
	
	public DailyCommand(RewardService service) {
		this.service = service;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player player)) {
			sender.sendMessage("§cComando apenas para jogadores.");
			return true;
		}
		
		if(!service.canClaim(player.getUniqueId())) {
			long remaining = service.getRemaining(player.getUniqueId());
			player.sendMessage("§cEspere §7" + Timer.format(remaining) + "§c para usar novamente.");
			return true;
		}
		service.claim(player);
		return true;
	}
	
}