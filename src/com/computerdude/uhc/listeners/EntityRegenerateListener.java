package com.computerdude.uhc.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

public class EntityRegenerateListener implements Listener {

	@EventHandler
	public void onEntityHealthGain(EntityRegainHealthEvent e) {
	
		if(e.getEntity().getType().equals(EntityType.PLAYER) && !e.getRegainReason().equals(RegainReason.EATING)) {
			e.setCancelled(true);
		}
		
	}
	
}
