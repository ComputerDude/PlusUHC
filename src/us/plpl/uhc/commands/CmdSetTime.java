package us.plpl.uhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.utils.ColorManager;

public class CmdSetTime implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (command.getName().equalsIgnoreCase("settime")) {
			if (sender.hasPermission("uhc.settime")) {
				if (args.length == 1) {
					int time = 0;
					try {
						time = Integer.parseInt(args[0]);
					} catch (Exception e) {
						sender.sendMessage(ColorManager.color("&c/settime only excepts a number in seconds."));
						return true;
					}
					GameManager.setTimer(time);
					sender.sendMessage(ColorManager.color("&aSet time to " + time + " seconds."));
					return true;
				} else {
					sender.sendMessage(ColorManager.color("&cType only one number after /settime."));
					return true;
				}
			} else {
				sender.sendMessage(ColorManager.color("&cSorry you don't have permission."));
				return true;
			}
		}
		
		return false;
	}

}
