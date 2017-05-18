package com.computerdude.uhc.game;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import com.computerdude.uhc.PlusUHC;
import com.computerdude.uhc.game.states.BasicState;
import com.computerdude.uhc.game.states.EndingState;
import com.computerdude.uhc.game.states.InstructionsState;
import com.computerdude.uhc.game.states.ResetState;
import com.computerdude.uhc.game.states.StartupState;
import com.computerdude.uhc.game.states.WaitState;


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
	public static final Location LOBBY = new Location(Bukkit.getWorld("world"), 0, 4, 0);
	
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
		
		// TODO Action bar timer stuff
		
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
			
		// TODO Add missing states
		
		states.put(GameState.ENDING, new EndingState());
		states.put(GameState.RESET, new ResetState());
		GameManager.setCurrentState(GameState.WAIT);	
		min_players = PlusUHC.getInstance().getConfig().getInt("game.min_players");
		max_players = PlusUHC.getInstance().getConfig().getInt("game.max_players");
	}
	
}
