package fr.drakyx.Lastarria.command.mod;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.drakyx.Main;
import fr.drakyx.Lastarria.tools.ItemBuilder;

public class CommandArmor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (args.length == 0) {
			sender.sendMessage("§3/armor + §2<player>");
		}

		if (command.getName().equalsIgnoreCase("armor")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(Main.INSTANCE.getConfig().getString("NotPlayer").replace("&", "§"));
			}
			Player player = (Player) sender;
			if (command.getName().equalsIgnoreCase("armor")) {
				if (args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					String starget = args[0];

					if (target == null || !target.isOnline()) {
						player.sendMessage(Main.INSTANCE.getConfig().getString("NotOnline").replace("&", "§"));
					} else {
						Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§4> Armor §0" + starget);
						
						ItemStack clear = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
					    ItemMeta meta = clear.getItemMeta();
					    meta.setDisplayName("§4Clear");
					    List<String> lore = new ArrayList<>();
					    lore.add("§7Click gauche pour clear l'armure du joueur.");
					    lore.add("§7Click droit pour clear l'inventaire du joueur.");
					    meta.setLore(lore);
					    meta.addEnchant(Enchantment.LUCK, 1, false);
					    meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
					    clear.setItemMeta(meta);
						
						inv.setItem(0, clear);
						inv.setItem(1, target.getInventory().getHelmet());
						inv.setItem(2, target.getInventory().getChestplate());
						inv.setItem(3, target.getInventory().getLeggings());
						inv.setItem(4, target.getInventory().getBoots());

						player.openInventory(inv);
						player.sendMessage("§3Tu connais l'armure de §2" + starget);
					}
				}
			}
			return true;
		}
		return false;
	}
}
