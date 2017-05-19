package us.plpl.uhc.utils;

import org.bukkit.Bukkit;

import us.plpl.uhc.References;

public class Debug {

	public static void send(String msg) {
		if (References.debug) {
		Bukkit.broadcastMessage(ColorManager.color(References.prefix + " &8<&cDebug&8> &c" + msg));
		}
	}
	
}
