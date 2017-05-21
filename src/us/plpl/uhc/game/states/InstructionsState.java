package us.plpl.uhc.game.states;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import us.plpl.uhc.PlusUHC;
import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.game.GameState;
import us.plpl.uhc.utils.ColorManager;
/**
 * 
 * @author Justin Brubaker
 *
 */
public class InstructionsState extends BasicState {

	public InstructionsState() {
		super(GameState.INSTRUCTIONS, 60);		
	}

	@Override
	public void codeOnStart() {	
		
		BukkitScheduler sched = Bukkit.getScheduler();
		for (Player p : Bukkit.getOnlinePlayers()) { // Right away
			p.sendTitle(ColorManager.color("&aWelcome to UHC"), ColorManager.color("&7Created by JustBru00 and ComputerDude"), 20, 20*3, 20);
			
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, getTimeForState()*20, 49), true);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, getTimeForState()*20, 49), true);
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, getTimeForState()*20, 49), true);			
		}
		
		sched.runTaskLater(PlusUHC.getInstance(), new Runnable() {			
			@Override
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					p.sendTitle(ColorManager.color("&aMay the odds"), ColorManager.color("&2be ever in your favor"), 10, 60,
							10);	
				}				
			}
		}, 5*20);
		
	}

	@Override
	public void codeOnFinish() {
		
		GameManager.setCurrentState(GameState.STAGEONE);
		
	}

}
