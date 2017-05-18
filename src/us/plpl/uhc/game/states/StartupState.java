package us.plpl.uhc.game.states;

import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.game.GameState;
/**
 * 
 * @author Justin Brubaker
 *
 */
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
