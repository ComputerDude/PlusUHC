package us.plpl.uhc.game.states;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import us.plpl.uhc.References;
import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.game.GameState;
import us.plpl.uhc.listeners.BlockBreakListener;

public class StageOneState extends BasicState {

	public StageOneState() {
		super(GameState.STAGEONE, 30*60); // 30 minutes in seconds		
	}

	@Override
	public void codeOnStart() {
		
		// Disable freezing 
		//enable block breaking
		for (Player p : Bukkit.getOnlinePlayers()) {
			for (PotionEffect effect : p.getActivePotionEffects()) {
				p.removePotionEffect(effect.getType());
			}
			p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()); // Should work for double health and normal health
		}

		BlockBreakListener.setBlockActionsBlockedDisabled(false);
		
		World uhc = Bukkit.getWorld(References.WORLD_NAME);
		WorldBorder wb = uhc.getWorldBorder();
		wb.setSize(2000, 10); // 50*50
	}

	@Override
	public void codeOnFinish() {
		
		GameManager.setCurrentState(GameState.STAGETWO);

	}

}
