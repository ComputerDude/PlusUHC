package us.plpl.uhc.game.states;

import us.plpl.uhc.game.GameState;
/**
 * 
 * @author Justin Brubaker
 *
 */
public class WaitState extends BasicState {

	public WaitState() {
		super(GameState.WAIT, 0);		
	}

	@Override
	public void codeOnStart() {
		
		// Shouldn't need any code here. Reset _should_ be run before this. Reset should go straight to this.

	}

	@Override
	public void codeOnFinish() {
		// Do nothing.
		
	}

}
