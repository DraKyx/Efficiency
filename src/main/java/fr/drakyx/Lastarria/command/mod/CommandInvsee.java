package fr.drakyx.Lastarria.command.mod;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.drakyx.Main;

public class CommandInvsee implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length == 0) {
			sender.sendMessage("§3/invsee + §2<player>");
		}
		
		if (cmd.getName().equalsIgnoreCase("invsee"))  {
			if(!(sender instanceof Player)) {
				sender.sendMessage(Main.INSTANCE.getConfig().getString("NotPlayer").replace("&", "§"));
        	}
        	Player player = (Player) sender;
	    	if (cmd.getName().equalsIgnoreCase("invsee"))  {
	    	    	if (args.length == 1) {
	    	        Player target = Bukkit.getPlayer(args[0]);
	    	        String starget = target.getDisplayName();
	    		
	    	        if (target == null || !target.isOnline()) {
	    			player.sendMessage(Main.INSTANCE.getConfig().getString("NotOnline").replace("&", "§"));		
	    		}else {
		    		player.openInventory(target.getInventory());		    		
		    		player.sendMessage("§3Tu as ouvert l'inventaire de §2" + starget);
	    		}
	    	  }
	    	}
	    	return true;
		}
		return false;
	}		
}
