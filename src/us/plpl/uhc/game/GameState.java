package us.plpl.uhc.game;

public enum GameState {

	/* WAIT = Lobby / waiting to start forever | INSTRUCTIONS = Game instructions, info about rules etc. 
	 * STARTUP = Teleports players, allows breaking etc. | STAGEONE = Normal play lasts for 30 mins 
	 * STAGETWO = World border starts shrinking slowly. Lasts 20 mins | ENDING = Congrats to winner, lasts like 20 seconds
	 * RESET | Everything to reset for a new game. Clear inventories, teleport back to lobby, generate new world? 
	 * DEATHMATCH = Deathmatch. Telport to deathmatch location? Adventure mode? etc
	*/
	WAIT, STARTUP, INSTRUCTIONS, STAGEONE, STAGETWO, DEATHMATCH, ENDING, RESET;
	
}
