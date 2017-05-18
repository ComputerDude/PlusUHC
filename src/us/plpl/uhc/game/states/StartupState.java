package us.plpl.uhc.game.states;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import us.plpl.uhc.PlusUHC;
import us.plpl.uhc.References;
import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.game.GameState;
import us.plpl.uhc.utils.ColorManager;
import us.plpl.uhc.utils.PlayerSpreaderManager;
/**
 * 
 * @author Justin Brubaker
 *
 */
public class StartupState extends BasicState {

	public StartupState() {
		super(GameState.STARTUP, 0);
	}

	@Override
	public void codeOnStart() {
		
		/* Run all startup stuff here
		 *  Teleport players
		 * 
		 */
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (PlusUHC.getInstance().getConfig().getBoolean("DoubleHealth") == true) {
				p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40.0);
			}
			p.sendMessage(References.prefix + ColorManager.color("&6&lEnabled Options:"));
			/*if(!enabledOptions.isEmpty()) {
				for(String str : enabledOptions) {
					p.sendMessage("&6&l" + str);
				}
			} else {
				p.sendMessage("&c&lNone");
			}*/
			
			// TODO Options Enabled list
			PlayerSpreaderManager.spreadPlayer(p);
			p.sendTitle(ColorManager.color("&aMay the odds"), ColorManager.color("&2be ever in your favor"), 10, 60,
					10);
			
			// TODO Block disabled here
		}
				
	}

	@Override
	public void codeOnFinish() {
		// GOTO STAGEONE
		GameManager.setCurrentState(GameState.INSTRUCTIONS);
	}	
	
}
