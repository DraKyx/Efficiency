package fr.drakyx.Lastarria.command.mod;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.drakyx.Main;

public class CommandFly implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(Main.INSTANCE.flying.contains(player)) {
				player.setAllowFlight(false);
				player.sendMessage("§3Tu ne peux plus fly maintenant");
				Main.INSTANCE.flying.remove(player);
			}
			else if (!Main.INSTANCE.flying.contains(player)){
				player.setAllowFlight(true);
				player.setFlySpeed((float) 0.06);
				player.sendMessage("§3Tu peux maintenant fly");
				Main.INSTANCE.flying.add(player);
			}
			
		}else {
			sender.sendMessage(Main.INSTANCE.getConfig().getString("NotPlayer").replace("&", "§"));
		}
		return false;
	}
}
