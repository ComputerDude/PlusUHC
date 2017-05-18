package com.computerdude.uhc.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.computerdude.uhc.PlusUHC;
import com.computerdude.uhc.References;
import com.computerdude.uhc.utils.ColorManager;
import com.computerdude.uhc.utils.PlayerSpreaderManager;

public class CmdStart implements CommandExecutor {

	private static PlusUHC plugin;
	private static ArrayList<String> enabledOptions = new ArrayList<String>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("start")) {
			// TODO 20 second Timer System
			for (Player p : Bukkit.getOnlinePlayers()) {
				if (plugin.getConfig().getBoolean("DoubleHealth") == true) {
					p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40.0);
				}
				p.sendMessage(References.prefix + ColorManager.color("&6&lEnabled Options:"));
				if(!enabledOptions.isEmpty()) {
					for(String str : enabledOptions) {
						p.sendMessage("&6&l" + str);
					}
				} else {
					p.sendMessage("&c&lNone");
				}
				PlayerSpreaderManager.spreadPlayer(p);
				p.sendTitle(ColorManager.color("&aMay the odds"), ColorManager.color("&2be ever in your favor"), 10, 60,
						10);
			}

			return true;
		}

		return false;

	}

	public void getEnabledOptions() {
		if (plugin.getConfig().getBoolean("DoubleHealth") == true) {
			enabledOptions.add("DoubleHealth");
		}
	}

}
