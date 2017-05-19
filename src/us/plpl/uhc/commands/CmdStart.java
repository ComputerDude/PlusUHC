package us.plpl.uhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.game.GameState;
import us.plpl.uhc.utils.ColorManager;
/**
 * 
 * @author ComputerDude
 *
 */
public class CmdStart implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("start")) {
			
			GameManager.setCurrentState(GameState.STARTUP);
			sender.sendMessage(ColorManager.color("&aStarting game."));
			return true;
		}

		return false;

	}
}
