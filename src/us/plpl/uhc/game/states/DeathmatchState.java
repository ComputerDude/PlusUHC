package us.plpl.uhc.game.states;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import us.plpl.uhc.References;
import us.plpl.uhc.game.GameState;

public class DeathmatchState extends BasicState {

	public DeathmatchState() {
		super(GameState.DEATHMATCH, 0); 
	}

	@Override
	public void codeOnStart() {
		
		// Announce death match special rules etc
		// Shrink world border to 100*100 or 50*50
		// Teleport players outside of border first
		
		World uhc = Bukkit.getWorld(References.WORLD_NAME);
		WorldBorder wb = uhc.getWorldBorder();
		wb.setSize(100, 10); // 50*50
		
		

	}

	@Override
	public void codeOnFinish() {
		
		// Nothing logic is needed somewhere for checking if the last players died.
		// Only one can win.

	}

}
