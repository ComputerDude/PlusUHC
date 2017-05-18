package com.computerdude.uhc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.computerdude.uhc.References;
import com.computerdude.uhc.utils.ColorManager;

public class CmdOption implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("option") && sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 0) {
				player.sendMessage(References.prefix
						+ ColorManager.color("&cIncorrect Usage. Proper Usage: /option (option) (true/false)"
								+ "\n"
								+ "\nOptions:"
								+ "\ndoubleHealth"));
				
			} else if(args.length == 1) {
				if(args[2].equalsIgnoreCase("doubleHealth")) {
					player.sendMessage(References.prefix + ColorManager.color("&fdoubleHealth = "));
					//TODO get config
				} else {
					player.sendMessage(References.prefix + ColorManager.color("&cUnknown Option. Type /option for a list."));
				}
			} else if(args.length == 2) {
				if(args[3].equalsIgnoreCase("true")) {
					if(args[2].equalsIgnoreCase("doubleHealth")) {
						//TODO Change in config.yml
						Bukkit.broadcastMessage(References.prefix + "&f" + player.getName() + " enabled DoubleHealth");
					}
				} else if(args[3].equalsIgnoreCase("false")) {
					if(args[2].equalsIgnoreCase("doubleHealth")) {
						//TODO Change in config.yml
						Bukkit.broadcastMessage(References.prefix + "&f" + player.getName() + " disabled DoubleHealth");
					}
				} else {
					player.sendMessage(References.prefix + ColorManager.color("&cIncorrect Usage. type /option for help."));
				}
			}

			return true;
		}

		return false;

	}

}