package us.plpl.uhc.utils;

import java.io.File;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.scheduler.BukkitTask;

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
	public static int chunksDone = 0;
	public static double calculatedTotal = 0;
	
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
	
	/*public static void preGenerateChunks() {
		
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
					lastChunk = 0;
					Bukkit.getScheduler().cancelTask(preGenTaskNumber);
				}
				
				for (int i = 0; i < References.chunksPerSecond; i++) {
					Chunk current = chunksToGen[lastChunk + 1];
					working.loadChunk(current);
					working.unloadChunk(current);
					lastChunk = lastChunk + 1;
				}	
				
				Debug.send("Generated chunks. Last: " + lastChunk);
			}
		}, 0, 10*20);
	}*/
	
	public static void preGenerateChunks() {
		calculatedTotal = (((References.max_x -References.min_x) * (References.max_z - References.min_z)) / 256);
		BukkitTask t = Bukkit.getScheduler().runTaskAsynchronously(PlusUHC.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				int chunksDone = 0;
				
				for (int x = References.min_x; x <= References.max_x; x = x + 16) {
				       
		            for (int z = References.min_z; z <= References.max_z; z = z + 16) {
		            	if (chunksDone < References.chunksPerTry) {
		            		final int fx = x;
		            		final int fz = z;
		            		
		            		Bukkit.getScheduler().runTask(PlusUHC.getInstance(), new Runnable() {
								public void run() {
									loadChunkAt(fx, fz);
								}
							});
		            		chunksDone = chunksDone + 1;
		            	} else {
		            		try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								Debug.send("Interrupted");
								e.printStackTrace();
							}
		            		chunksDone = 0;
		            		final int fx = x;
		            		final int fz = z;
		            		
		            		Bukkit.getScheduler().runTask(PlusUHC.getInstance(), new Runnable() {
								public void run() {
									loadChunkAt(fx, fz);
									double percent = (((double) WorldManager.chunksDone / calculatedTotal)) * (int) 100;
									int secondsLeft = (int) ((calculatedTotal - WorldManager.chunksDone) * References.chunksPerTry);
									
									Bukkit.broadcastMessage(ColorManager.color("&cPregen " + percent + " finished. Approx. " + secondsLeft + " seconds left."));
								}
							});
		            		chunksDone = chunksDone + 1;
		            	}		            	
		            }
		           
		        }
				
				Bukkit.getScheduler().runTaskLater(PlusUHC.getInstance(), new Runnable() {
					
					@Override
					public void run() {
						Bukkit.broadcastMessage(ColorManager.color("Finished " + WorldManager.chunksDone + " chunks."));						
					}
				}, 5*20);
				
			}
		
		});
		
		preGenTaskNumber = t.getTaskId();
	}
	
	public static void loadChunkAt(int x, int z) {
		Chunk c = Bukkit.getWorld(WORLD_NAME).getChunkAt(x, z);
    	c.load(true);
    	c.unload();
    	chunksDone = chunksDone + 1;    	
    	//Debug.send("Done chunk at: X:" +c.getX() + " Z:" + c.getZ());
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
