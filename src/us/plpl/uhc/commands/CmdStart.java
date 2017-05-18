package us.plpl.uhc.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import us.plpl.uhc.PlusUHC;
import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.game.GameState;
/**
 * 
 * @author ComputerDude
 *
 */
public class CmdStart implements CommandExecutor {

	
	private static ArrayList<String> enabledOptions = new ArrayList<String>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("start")) {
			
			GameManager.setCurrentState(GameState.STARTUP);
			
			return true;
		}

		return false;

	}

	public void getEnabledOptions() {
		if (PlusUHC.getInstance().getConfig().getBoolean("DoubleHealth") == true) {
			enabledOptions.add("DoubleHealth");
		}
	}

}
