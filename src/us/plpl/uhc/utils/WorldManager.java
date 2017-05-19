package us.plpl.uhc.utils;

import java.io.File;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import us.plpl.uhc.PlusUHC;
import us.plpl.uhc.References;

import static us.plpl.uhc.References.WORLD_NAME;
/**
 * 
 * @author Justin Brubaker
 *
 */
public class WorldManager {
	
	private static boolean currentlyPreGenerating = false;
	private static int preGenTaskNumber = -1;
	private static Chunk[] chunksToGen;
	private static int lastChunk = 0;
	
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
	
	public static void preGenerateChunks() {
		
		HashSet<Chunk> chunks = new HashSet<Chunk>();
		for (int x = References.min_x; x <= References.max_x; x = x + 16) {
		       
            for (int z = References.min_z; z <= References.max_z; z = z + 16) {
                chunks.add(Bukkit.getWorld(WORLD_NAME).getChunkAt(x, z));
            }
           
        }
		
		chunksToGen = chunks.toArray(new Chunk[chunks.size()]);
		
		preGenTaskNumber = Bukkit.getScheduler().scheduleSyncRepeatingTask(PlusUHC.getInstance(), new Runnable() {
			
			@Override
			public void run() {   
				World working = Bukkit.getWorld(WORLD_NAME);
		        
				if (lastChunk + 1 == chunksToGen.length) {
					Debug.send("Done pre generating.");
				}
				
				for (int i = 0; i < References.chunksPerSecond; i++) {
					Chunk current = chunksToGen[lastChunk + 1];
					working.loadChunk(current);
					working.unloadChunk(current);
					lastChunk = lastChunk + 1;
				}	
				
				Debug.send("Generated chunks. Last: " + lastChunk);
			}
		}, 0, 20);
	}
	
	public static int getPreGenTaskNumber() {
		return preGenTaskNumber;
	}
	
	public static void setPreGenerating(boolean b) {
		currentlyPreGenerating = b;
	}
	
	public static boolean isPreGenerating() {
		return currentlyPreGenerating;
	}
	
}
