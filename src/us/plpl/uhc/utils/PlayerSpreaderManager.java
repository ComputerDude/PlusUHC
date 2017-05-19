package us.plpl.uhc.utils;

import static us.plpl.uhc.References.WORLD_NAME;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import us.plpl.uhc.References;

/**
 * 
 * Spreads players between X = 1000 Z= 1000 and X -1000 Z=-1000
 * 
 * @author Justin Brubaker
 *
 */
public class PlayerSpreaderManager {	

	/**
	 * Teleports one player to a random location in the world name in
	 * {@link worldName}
	 * 
	 * @param p
	 */
	public static void spreadPlayer(Player p) {
		Location loc;
		while (true) {
			loc = getRandomLocation();
			Block block = loc.getBlock();			
			Material type = block.getType();

			boolean noPlayers = true;
			
			for (Entity e : Bukkit.getWorld(WORLD_NAME).getNearbyEntities(loc, 50, 30, 50)) {
				if (e.getType().equals(EntityType.PLAYER)) {
					Debug.send("Found player: " + e.getName() + " nearby " + loc.toString());
					noPlayers = false;
					break;
				}
			}
			
			if (!noPlayers || type.equals(Material.LAVA) || type.equals(Material.STATIONARY_LAVA)) {
				// Just let it pick a new spot.
			} else {
				break;
			}
		}
		p.teleport(loc);
	}

	/**
	 * Random location finder.
	 * 
	 * @return
	 */
	private static Location getRandomLocation() {
		Location loc = null;

		int x = ThreadLocalRandom.current().nextInt(References.min_x, (References.max_x + 1));
		int z = ThreadLocalRandom.current().nextInt(References.min_z, (References.max_z + 1));

		loc = new Location(Bukkit.getWorld(WORLD_NAME), x, Bukkit.getWorld(WORLD_NAME).getHighestBlockYAt(x, z), z);

		return loc;
	}

}
