package com.computerdude.uhc.game.states;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import com.computerdude.uhc.PlusUHC;
import com.computerdude.uhc.game.GameManager;
import com.computerdude.uhc.game.GameState;

public class InstructionsState extends BasicState {

	public InstructionsState() {
		super(GameState.INSTRUCTIONS, 10);		
	}

	@Override
	public void codeOnStart() {
		
		BukkitScheduler sched = Bukkit.getScheduler();
		for (Player p : Bukkit.getOnlinePlayers()) {
			// TODO TITLE HERE
		}
		
		sched.runTaskLater(PlusUHC.getInstance(), new Runnable() {			
			@Override
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					// TODO TITLE HERE
				}				
			}
		}, 5*20);
		
	}

	@Override
	public void codeOnFinish() {
		
		GameManager.setCurrentState(GameState.STARTUP);
		
	}

}
