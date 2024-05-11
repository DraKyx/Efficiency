package fr.drakyx.Lastarria.command.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.drakyx.Main;
import fr.drakyx.Lastarria.tools.ItemBuilder;

public class CommandReport implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		
		if(args.length != 1) {
			p.sendMessage("§3Tu dois mettre le nom d'un joueur");
			return false;
		}
		
		String starget = args[0];
		
		if(Bukkit.getPlayer(starget) == null) {
			p.sendMessage(Main.INSTANCE.getConfig().getString("NotOnline").replace("&", "§"));
		}
		
		Player target = Bukkit.getPlayer(args[0]);
		
		Inventory report = Bukkit.createInventory(null, 3*9, "§4Report de §0" + starget);
		
		report.setItem(0, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).toItemStack());
		report.setItem(8, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).toItemStack());
		report.setItem(18, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).toItemStack());
		report.setItem(26, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).toItemStack());
		
		report.setItem(1, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).toItemStack());
		report.setItem(9, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).toItemStack());
		report.setItem(7, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).toItemStack());
		report.setItem(17, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).toItemStack());
		report.setItem(19, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).toItemStack());
		report.setItem(25, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).toItemStack());
		
		report.setItem(10, new ItemBuilder(Material.REDSTONE).setName("§4Arnaque").toItemStack());
		report.setItem(11, new ItemBuilder(Material.ANVIL).setName("§4AutoClick/Scaffold").toItemStack());
		report.setItem(12, new ItemBuilder(Material.BARRIER).setName("§4Grief").toItemStack());
		report.setItem(13, new ItemBuilder(Material.DIAMOND_ORE).setName("§4Xray").toItemStack());
		report.setItem(14, new ItemBuilder(Material.FEATHER).setName("§4Fly sans grade").toItemStack());
		report.setItem(15, new ItemBuilder(Material.BEDROCK).setName("§4Utilisation d'un bug").toItemStack());
		report.setItem(16, new ItemBuilder(Material.OAK_SIGN).setName("§4Language non approprié").toItemStack());
		
		p.openInventory(report);
		
		return false;
	}

}
