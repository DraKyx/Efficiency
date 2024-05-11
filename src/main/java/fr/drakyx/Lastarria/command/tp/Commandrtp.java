package fr.drakyx.Lastarria.command.tp;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.drakyx.Main;

public class Commandrtp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if (!p.getLocation().getWorld().getName().equals("spawn")) {
				int max = 10000;
				int min = 1000;
			
				int x = new Random().nextInt(max - min) + min;
				int z = new Random().nextInt(max - min) + min;
			
				Location loc = new Location(p.getWorld(), x, 0, z);
			
				int y = loc.getWorld().getHighestBlockYAt(loc) + 3;
			
				loc.setY(y);
			
				p.teleport(loc);
				p.sendMessage("§3Tu as bien été tp aléatoirement");
			
			}else {
				p.sendMessage("§3Tu ne peux pas /rtp dans le monde de §2spawn");
			}
		}else {
			sender.sendMessage(Main.INSTANCE.getConfig().getString("NotPlayer").replace("&", "§"));
		}
		return false;
	}
}	
