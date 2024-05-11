package fr.drakyx.Lastarria.listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import fr.drakyx.Main;

public class ClickListener implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if (e.getCurrentItem() == null) return;
		
		if(e.getView().getTitle() == null) return;
		
		if(e.getView().getTitle().contains("§4> Armor")) {
			e.setCancelled(true);
		}
		
		if(e.getView().getTitle().contains("§4Report de")) {
			e.setCancelled(true);
		}
		
		switch (e.getCurrentItem().getType()) {
			
		case OAK_SIGN:
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Language non approprié")) {
				e.setCancelled(true);
				p.closeInventory();
				sendReports(e.getCurrentItem().getItemMeta().getDisplayName(), e.getView().getTitle().substring(14), p.getName());
				p.sendMessage("§3Tu as bien signalé ce joueur !");
			}
			break;
		
		case BEDROCK:
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Utilisation d'un bug")) {
				e.setCancelled(true);
				p.closeInventory();
				sendReports(e.getCurrentItem().getItemMeta().getDisplayName(), e.getView().getTitle().substring(14), p.getName());
				p.sendMessage("§3Tu as bien signalé ce joueur !");
			}
			break;
		
		case FEATHER:
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Fly sans grade")) {
				e.setCancelled(true);
				p.closeInventory();
				sendReports(e.getCurrentItem().getItemMeta().getDisplayName(), e.getView().getTitle().substring(14), p.getName());
				p.sendMessage("§3Tu as bien signalé ce joueur !");
			}
			break;
		
		case DIAMOND_ORE:
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Xray")) {
				e.setCancelled(true);
				p.closeInventory();
				sendReports(e.getCurrentItem().getItemMeta().getDisplayName(), e.getView().getTitle().substring(14), p.getName());
				p.sendMessage("§3Tu as bien signalé ce joueur !");
			}
			break;
			
		case ANVIL:
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4AutoClick/Scaffold")) {
				e.setCancelled(true);
				p.closeInventory();
				sendReports(e.getCurrentItem().getItemMeta().getDisplayName(), e.getView().getTitle().substring(14), p.getName());
				p.sendMessage("§3Tu as bien signalé ce joueur !");
			}
			break;
			
		case BARRIER:
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Grief")) {
				e.setCancelled(true);
				p.closeInventory();
				sendReports(e.getCurrentItem().getItemMeta().getDisplayName(), e.getView().getTitle().substring(14), p.getName());
				p.sendMessage("§3Tu as bien signalé ce joueur !");
			}
			break;
			
		case REDSTONE:
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Arnaque")) {
				e.setCancelled(true);
				p.closeInventory();
				sendReports(e.getCurrentItem().getItemMeta().getDisplayName(), e.getView().getTitle().substring(14), p.getName());
				p.sendMessage("§3Tu as bien signalé ce joueur !");
			}
			break;

		case RED_STAINED_GLASS_PANE:
			String starget = e.getView().getTitle().substring(12);
			Player target = Bukkit.getServer().getPlayer(starget);
			
			if (e.getClick().isLeftClick()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Clear")) {
					e.setCancelled(true);
					p.sendMessage("§3Tu as clear l'armure de §2" + starget);
					target.getInventory().setArmorContents(null);
				}
			}
			
			if (e.getClick().isRightClick()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Clear")) {
					e.setCancelled(true);
					p.sendMessage("§3Tu as clear l'inventaire §2" + starget);
					target.getInventory().clear();
				}
			}

			break;
		
		default:
			break;
		}
	}

	private void sendReports(String reason, String starget, String splayer) {
		for (Player players : Bukkit.getOnlinePlayers()) {
			if (players.hasPermission("lastarria.vanish")) {
				players.sendMessage("§3Le joueur §2" + starget + " §3a été signalé pour : " + reason + " §3par : §2" + splayer);
			}
		}
		Main.INSTANCE.getConfig().set(starget + "." + reason, "report par " + splayer);
		Main.INSTANCE.saveConfig();
	}
}
