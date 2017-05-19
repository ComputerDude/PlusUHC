package us.plpl.uhc.options;

import java.util.ArrayList;

import us.plpl.uhc.PlusUHC;

/**
 * Really should be redone in a better way, but I it will take too long.
 * @author Justin Brubaker
 *
 */
public class OptionManager {

	private static ArrayList<String> options = new ArrayList<String>();
	
	public static ArrayList<String> getEnabledOptions() {
		ArrayList<String> enabled = new ArrayList<String>();
		
		if (PlusUHC.getInstance().getConfig().getBoolean("DoubleHealth")) { // Double health option
			enabled.add("Double Health");
		}
		
		return enabled;
	}
	
	public static void init() {
		options.add("Double Health");
	}
	
}
