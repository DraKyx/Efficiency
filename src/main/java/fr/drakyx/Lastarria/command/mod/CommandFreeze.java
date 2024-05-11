package fr.drakyx.Lastarria.command.mod;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.drakyx.Main;

public class CommandFreeze implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length == 0) {
			sender.sendMessage("§3/freeze + &2<player>");
		}
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase("freeze")) {
				if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					
					if (target != null || !target.isOnline()) {
						String starget = target.getDisplayName();
						
						if(Main.freeze.containsKey(target)) {
							
							player.sendMessage("§3Tu as unfreeze §2" + starget);
							target.getInventory().setHelmet(Main.freeze.get(target));
							Main.freeze.remove(target);
							
						} else {
							
							player.sendMessage("§3Tu as freeze §2" + starget);
							Main.freeze.put(target, target.getInventory().getHelmet());
							target.getInventory().setHelmet(new ItemStack(Material.PACKED_ICE));
							
						}
					}else {
						player.sendMessage(Main.INSTANCE.getConfig().getString("NotOnline").replace("&", "§"));
					}
					return true;
				}
			}
		}
		return false;
	}

}
