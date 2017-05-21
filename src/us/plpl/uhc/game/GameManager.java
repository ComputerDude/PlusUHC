package us.plpl.uhc.game;

import java.util.HashMap;

import us.plpl.uhc.PlusUHC;
import us.plpl.uhc.game.states.BasicState;
import us.plpl.uhc.game.states.DeathmatchState;
import us.plpl.uhc.game.states.EndingState;
import us.plpl.uhc.game.states.InstructionsState;
import us.plpl.uhc.game.states.ResetState;
import us.plpl.uhc.game.states.StageOneState;
import us.plpl.uhc.game.states.StageTwoState;
import us.plpl.uhc.game.states.StartupState;
import us.plpl.uhc.game.states.WaitState;


/**
 * Still working on this
 * @author Justin Brubaker
 *
 */
public class GameManager {

	private static BasicState currentState;
	private static int min_players;
	private static int max_players;
	private static int timer = 0;
	private static HashMap<GameState, BasicState> states = new HashMap<GameState, BasicState>();
	
	
	public static GameState getCurrentState() {
		return currentState.getState();
	}
	
	/**
	 * Use for setting the current state. Time and starting code is run automaticly.
	 * @param g The game state you want to set to.
	 */
	public static void setCurrentState(GameState g) {		
		currentState = states.get(g);		
		currentState.codeOnStart();		
		timer = currentState.getTimeForState();
	}
	
	public static void everySecond() {		
		if (timer != 0) {
			timer--;
		} else {
			currentState.codeOnFinish();
		}
		updateDisplays();		
	}
	
	public static void updateDisplays() {
		
		if (!getCurrentState().equals(GameState.WAIT)) { // Anything but lobby/wait
			PlusUHC.sendActionBarToAll(getTimeLeftFormated() + " &8&l| &6Current Stage: " + getCurrentState().toString().toLowerCase());
		}
		
	}
	
	public static String getTimeLeftFormated() {
		if (timer == 0) {
			return "&6Forever";
		}

		// int hours;
		int mins;
		int seconds;
		// hours = (counter % 86400 ) / 3600 ;
		mins = ((timer % 86400) % 3600) / 60;
		seconds = ((timer % 86400) % 3600) % 60;

		if (seconds <= 9) {
			return "&6Time Left: " + mins + ":0" + seconds;
		} else {		
			return "&6Time Left: " + mins + ":" + seconds;
		}
	}
	
	public static void setTimer(int seconds) {
		timer = seconds;
	}
	
	public static int getMinPlayers() {
		return min_players;
	}
	
	public static int getMaxPlayers() {
		return max_players;
	}
	
	public static void initStates() {
		states.put(GameState.WAIT, new WaitState());
		states.put(GameState.INSTRUCTIONS, new InstructionsState());
		states.put(GameState.STARTUP, new StartupState());
		states.put(GameState.STAGEONE, new StageOneState());
		states.put(GameState.STAGETWO, new StageTwoState());
		states.put(GameState.DEATHMATCH, new DeathmatchState());
		states.put(GameState.ENDING, new EndingState());
		states.put(GameState.RESET, new ResetState());
		GameManager.setCurrentState(GameState.WAIT);	
		min_players = PlusUHC.getInstance().getConfig().getInt("game.min_players");
		max_players = PlusUHC.getInstance().getConfig().getInt("game.max_players");
	}
	
}
