package com.computerdude.uhc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.computerdude.uhc.utils.ColorManager;
import com.computerdude.uhc.utils.PlayerSpreaderManager;

public class CmdStart implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("start")) {
			//TODO 20 second Timer System
			for(Player p : Bukkit.getOnlinePlayers()) {
				PlayerSpreaderManager.spreadPlayer(p);
				p.sendTitle(ColorManager.color("&aMay the odds"), ColorManager.color("&2be ever in your favor"), 10, 60, 10);
			}
			
			
			return true;
		}

		return false;

	}

}
