package com.computerdude.uhc.game.states;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.computerdude.uhc.game.GameManager;
import com.computerdude.uhc.game.GameState;

public class ResetState extends BasicState {

	public ResetState() {
		super(GameState.RESET, 0);		
	}

	@Override
	public void codeOnStart() {

		/*
		 * Reset stuffs 
		 * 
		 */
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.teleport(GameManager.LOBBY);
		}

	}

	@Override
	public void codeOnFinish() {
		
		GameManager.setCurrentState(GameState.WAIT);
		
	}

}
