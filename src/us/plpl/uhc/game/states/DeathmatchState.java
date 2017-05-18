package us.plpl.uhc.game.states;

import us.plpl.uhc.game.GameState;

public class DeathmatchState extends BasicState {

	public DeathmatchState() {
		super(GameState.DEATHMATCH, 0); // Ten mins in seconds		
	}

	@Override
	public void codeOnStart() {
		
		// Announce death match special rules etc
		// Shrink world border to 100*100 or 50*50
		// Teleport players outside of border first

	}

	@Override
	public void codeOnFinish() {
		
		// Nothing logic is needed somewhere for checking if the last players died.
		// Only one can win.

	}

}
