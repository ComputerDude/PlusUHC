package us.plpl.uhc.utils;

import us.plpl.uhc.References;

public class Debug {

	public static void send(String msg) {
		if (References.debug) {
		References.console.sendMessage(ColorManager.color(References.prefix + " &8<&cDebug&8> &c" + msg));
		}
	}
	
}
