package us.plpl.uhc.game.states;

import us.plpl.uhc.game.GameState;
/**
 * 
 * @author Justin Brubaker
 *
 */
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
