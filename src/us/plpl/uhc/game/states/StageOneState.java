package us.plpl.uhc.game.states;

import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.game.GameState;

public class StageOneState extends BasicState {

	public StageOneState() {
		super(GameState.STAGEONE, 30*60); // 30 minutes in seconds		
	}

	@Override
	public void codeOnStart() {
		
		// Probably nothing here

	}

	@Override
	public void codeOnFinish() {
		
		GameManager.setCurrentState(GameState.STAGETWO);

	}

}
