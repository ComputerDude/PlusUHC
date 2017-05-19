package us.plpl.uhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import us.plpl.uhc.utils.WorldManager;

public class CmdTestPregen implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (command.getName().equalsIgnoreCase("testpregen")) {
			WorldManager.generateNewWorld();
			WorldManager.preGenerateChunks();
		}
		
		return false;
	}

}
