package com.computerdude.uhc.utils;

import net.md_5.bungee.api.ChatColor;

public class ColorManager {

	public static String color(String str) {
		str = ChatColor.translateAlternateColorCodes('&', str);
		return str;
	}
	
}
