package us.plpl.uhc.game.states;

import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.game.GameState;

public class StageTwoState extends BasicState {

	public StageTwoState() {
		super(GameState.STAGETWO, 20*60); // 20 minutes
		
	}

	@Override
	public void codeOnStart() {
	
		// Announce world border and start it shrinking

	}

	@Override
	public void codeOnFinish() {
		
		GameManager.setCurrentState(GameState.DEATHMATCH);

	}

}
