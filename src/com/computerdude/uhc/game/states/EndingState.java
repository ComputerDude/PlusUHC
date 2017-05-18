package com.computerdude.uhc.game.states;

import com.computerdude.uhc.game.GameState;

public class EndingState extends BasicState {

	public EndingState() {
		super(GameState.ENDING, 20);
	}
	
	@Override
	public void codeOnStart() {
		
		/*
		 * Announce winner.
		 */

	}

	@Override
	public void codeOnFinish() {
		
		// GOTO ResetState
		
	}

}
