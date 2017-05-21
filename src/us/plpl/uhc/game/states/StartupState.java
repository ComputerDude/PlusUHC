package us.plpl.uhc.game.states;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import us.plpl.uhc.PlusUHC;
import us.plpl.uhc.References;
import us.plpl.uhc.game.GameManager;
import us.plpl.uhc.game.GameState;
import us.plpl.uhc.options.OptionManager;
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
			if (PlusUHC.getInstance().getConfig().getBoolean("DoubleHealth")) { // Double health option
				p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40.0);
			}
			
			p.sendMessage(References.prefix + ColorManager.color("&6&lEnabled Options:"));
			
			if(!OptionManager.getEnabledOptions().isEmpty()) {
				for(String str : OptionManager.getEnabledOptions()) {
					p.sendMessage("&6&l" + str);
				}
			} else {
				p.sendMessage("&c&lNone");
			}
			
			
			PlayerSpreaderManager.spreadPlayer(p); // May have to make spreading delayed in future with lots of players.
			
			p.sendTitle(ColorManager.color("&aMay the odds"), ColorManager.color("&2be ever in your favor"), 10, 60,
					10);				
		}
				
	}

	@Override
	public void codeOnFinish() {
		// GOTO STAGEONE
		GameManager.setCurrentState(GameState.INSTRUCTIONS);
	}	
	
}
