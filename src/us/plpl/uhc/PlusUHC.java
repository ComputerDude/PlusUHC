package us.plpl.uhc;

import static us.plpl.uhc.References.console;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import us.plpl.uhc.commands.CmdOption;
import us.plpl.uhc.commands.CmdStart;
import us.plpl.uhc.commands.CmdTestPregen;
import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.listeners.PlayerJoinListener;
import us.plpl.uhc.utils.WorldManager;

public class PlusUHC extends JavaPlugin {
	
	private static PlusUHC plugin = null;

	@Override
	public void onEnable() {		
		plugin = this; // Allow getting the plugin instance from other classes.
		
		saveDefaultConfig(); // Better method for saving config.
		
		GameManager.initStates();
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoinListener(), plugin);
		
		getCommand("start").setExecutor(new CmdStart());
		getCommand("option").setExecutor(new CmdOption());
		getCommand("testpregen").setExecutor(new CmdTestPregen());
		
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
		Bukkit.getScheduler().cancelTask(WorldManager.getPreGenTaskNumber());
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
