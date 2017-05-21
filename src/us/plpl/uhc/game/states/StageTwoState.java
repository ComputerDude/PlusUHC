package us.plpl.uhc.game.states;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;

import us.plpl.uhc.References;
import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.game.GameState;
import us.plpl.uhc.utils.ColorManager;

public class StageTwoState extends BasicState {

	public StageTwoState() {
		super(GameState.STAGETWO, 20*60); // 20 minutes
		
	}

	@Override
	public void codeOnStart() {
	
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendTitle(ColorManager.color("&c&lWORLDBORDERS"), ColorManager.color("&c&lHAVE STARTED SHRINKING"), 10, 60, 10);
		}
		
		World uhc = Bukkit.getWorld(References.WORLD_NAME);
		WorldBorder wb = uhc.getWorldBorder();
		wb.setSize(200, 20*60); // 100*100
		

	}

	@Override
	public void codeOnFinish() {
		
		GameManager.setCurrentState(GameState.DEATHMATCH);

	}

}
