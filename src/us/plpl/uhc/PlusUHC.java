package us.plpl.uhc;

import static us.plpl.uhc.References.console;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.listeners.PlayerJoinListener;

public class PlusUHC extends JavaPlugin {
	
	private static PlusUHC plugin = null;

	@Override
	public void onEnable() {		
		plugin = this; // Allow getting the plugin instance from other classes.
		
		/*if(this.getConfig().getBoolean("FirstStartup") == true) {
			this.getConfig().set("FirstStartup", false);
			this.saveConfig();
			this.reloadConfig();
		}*/ // Probably unneeded.
		
		saveDefaultConfig(); // Better method for saving config.
		GameManager.initStates();
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoinListener(), plugin);
		
		Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
			
			@Override
			public void run() {
				GameManager.everySecond();
			}
		}, 20, 20); // Every second
		
		console.sendMessage("Plus+ UHC enabled!");
	}
	
	@Override
	public void onDisable() {
		
		plugin = null; // Prevent a memory leak.
	}
	
	/**
	 * @author Justin Brubaker
	 * @return Returns the current instance of the {@link PlusUHC} class.
	 */
	public static PlusUHC getInstance() {
		return plugin;
	}
	
}
