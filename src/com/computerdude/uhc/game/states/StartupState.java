package com.computerdude.uhc.game.states;

import com.computerdude.uhc.game.GameManager;
import com.computerdude.uhc.game.GameState;

public class StartupState extends BasicState {

	public StartupState() {
		super(GameState.STARTUP, 0);
	}

	@Override
	public void codeOnStart() {
		
		/* Run all startup stuff here
		 *  Teleport players
		 * 
		 */
				
	}

	@Override
	public void codeOnFinish() {
		// GOTO STAGEONE
		GameManager.setCurrentState(GameState.STAGEONE);
	}	
	
}
