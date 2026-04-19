package br.com.flp.dailyreward;

import br.com.flp.dailyreward.commands.DailyCommand;
import br.com.flp.dailyreward.repository.PlayerDataRepository;
import br.com.flp.dailyreward.service.RewardService;
import org.bukkit.plugin.java.JavaPlugin;

public class DailyRewardPlugin extends JavaPlugin {
	
	private RewardService rewardService;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		PlayerDataRepository repository = new PlayerDataRepository(this);
		
		rewardService = new RewardService(this, repository);
		
		getCommand("daily").setExecutor(new DailyCommand(rewardService));
	}
	
}