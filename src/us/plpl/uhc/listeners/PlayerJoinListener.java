package us.plpl.uhc.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import us.plpl.uhc.References;

public class PlayerJoinListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.getPlayer().teleport(References.LOBBY);
	}
	
}
