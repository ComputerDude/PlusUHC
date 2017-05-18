package us.plpl.uhc.game.states;

import us.plpl.uhc.game.GameState;
/**
 * 
 * @author Justin Brubaker
 *
 */
public abstract class BasicState {

	private GameState myState;
	private int timeForMyState;
	private static BasicState instance;
	
	public BasicState(GameState s, int timeITake) {
		instance = this;
		myState = s;
		timeForMyState = timeITake;
	}
	
	public static BasicState getInstance() {
		return instance;		
	}
	
	public GameState getState() {
		return myState;
	}
	
	public int getTimeForState() {
		return timeForMyState;
	}
	
	public abstract void codeOnStart();
	
	public abstract void codeOnFinish();
	
}
