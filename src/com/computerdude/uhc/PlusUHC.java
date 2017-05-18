package com.computerdude.uhc;

import org.bukkit.plugin.java.JavaPlugin;

public class PlusUHC extends JavaPlugin {

	@Override
	public void onEnable() {
		if(this.getConfig().getBoolean("FirstStartup") == true) {
			this.getConfig().set("FirstStartup", false);
			this.saveConfig();
			this.reloadConfig();
		}
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
