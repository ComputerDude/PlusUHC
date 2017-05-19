package us.plpl.uhc.utils;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import static us.plpl.uhc.References.WORLD_NAME;
/**
 * 
 * @author Justin Brubaker
 *
 */
public class WorldManager {
	
	/**
	 * Generates a new world for UHC.
	 * Will delete old world if it exists.
	 * May cause lag. Not sure.
	 */
	public static void generateNewWorld() {
		
		if (Bukkit.getWorld(WORLD_NAME) != null) { // Delete old world if it exists.
			Debug.send("Deleting old world.");
			World deleteUHC = Bukkit.getWorld(WORLD_NAME);
			File worldFolder = deleteUHC.getWorldFolder();
			Bukkit.unloadWorld(deleteUHC, false);
			worldFolder.delete();
			Debug.send("Finished deleting.");
		} 
		
		Debug.send("Creating new world.");
		WorldCreator creator = new WorldCreator(WORLD_NAME);
		final World uhcWorld = creator.createWorld();
		uhcWorld.setDifficulty(Difficulty.HARD);
		uhcWorld.setPVP(true);
		uhcWorld.setGameRuleValue("naturalRegeneration", "false");
		Debug.send("Finished new world generation.");
	}
	
}
