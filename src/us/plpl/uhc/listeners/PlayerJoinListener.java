package us.plpl.uhc.listeners;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), 0, 230, 0));
	}
	
}
