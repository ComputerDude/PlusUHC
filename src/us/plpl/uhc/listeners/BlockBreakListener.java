package us.plpl.uhc.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockBreakListener implements Listener {
	
	private static boolean preventBlockActions = true;

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		if (preventBlockActions) {
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		if (preventBlockActions) {
			e.setCancelled(true);
		}
		
	}
	
	public static boolean isBlockActionsBlocked() {
		return preventBlockActions;
	}
	
	public static void setBlockActionsBlockedDisabled(boolean b) {
		preventBlockActions = b;
	}
	
}
