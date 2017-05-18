package us.plpl.uhc;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;

import us.plpl.uhc.utils.ColorManager;

public class References {

	public static String prefix = ColorManager.color("&f&l< &6&lU&a&lH&c&lC &f&l> ");
	public static ConsoleCommandSender console = Bukkit.getConsoleSender();
	public static final String WORLD_NAME = "world";
	public static Location LOBBY = new Location(Bukkit.getWorld(WORLD_NAME), 0, Bukkit.getWorld(WORLD_NAME).getHighestBlockYAt(0, 0), 0);
	
}
