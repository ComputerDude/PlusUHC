package com.computerdude.uhc.utils;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * 
 * Spreads players between X = 1000 Z= 1000 and X -1000 Z=1000
 * 
 * @author Justin Brubaker
 *
 */
public class PlayerSpreaderManager {
	
	private static String worldName = "world";

	/**
	 * Teleports one player to a random location in the world name in {@link worldName}
	 * @param p
	 */
	public static void spreadPlayer(Player p) {
		p.teleport(getRandomLocation());
	}
	
	/**
	 * Random location finder.
	 * @return
	 */
	private static Location getRandomLocation() {
		Location loc = null;
		
		int x = ThreadLocalRandom.current().nextInt(-1000, 1001);
		int z = ThreadLocalRandom.current().nextInt(-1000, 1001);
		
		loc = new Location(Bukkit.getWorld(worldName), x, Bukkit.getWorld(worldName).getHighestBlockYAt(x, z), z);
		
		return loc;
	}
	
}
