package fr.drakyx.Lastarria.listeners.block;

import org.bukkit.event.Listener;

import fr.drakyx.Main;

public class BlockBreakListener implements Listener{
	
	/* @EventHandler                                        SPAWNER SILKTOUCH
    public void onBlockBreak(BlockBreakEvent event)
    {
		Player player = event.getPlayer();
		String p = player.getName();
        Block brokenBlock = event.getBlock();

        if (brokenBlock.getType() == Material.SPAWNER)
        {
            ItemStack tool = event.getPlayer().getInventory().getItemInMainHand();
            if (tool.getType().toString().contains("PICKAXE") && tool.containsEnchantment(Enchantment.SILK_TOUCH))
            {
                ItemStack spawnerItem = new ItemStack(Material.SPAWNER);
                ItemMeta spawnerMeta = spawnerItem.getItemMeta();

                CreatureSpawner spawner = (CreatureSpawner) brokenBlock.getState();
                EntityType entityType = spawner.getSpawnedType();

                spawnerMeta.setDisplayName(ChatColor.YELLOW + entityType.toString() + ChatColor.RED + " Spawner");
                spawnerItem.setItemMeta(spawnerMeta);
                
                if (player.hasPermission("lastarria.spawner2")) {
                	event.setCancelled(true);
                	player.sendMessage("§3Tu ne peux plus ramasser de spawner");
                }
                else if (player.hasPermission("lastarria.spawner")) {
                	brokenBlock.getWorld().dropItemNaturally(brokenBlock.getLocation(), spawnerItem);
                	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p + " permission set lastarria.spawner1");
                	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p + " permission unset lastarria.spawner");
                	player.sendMessage("§3Tu as ramassé un spawner");
                }
                else if (player.hasPermission("lastarria.spawner1")) {
                	brokenBlock.getWorld().dropItemNaturally(brokenBlock.getLocation(), spawnerItem);
                	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p + " permission set lastarria.spawner2");
                	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p + " permission unset lastarria.spawner1");
                	player.sendMessage("§3Tu as ramassé un spawner, ton dernier");
                }
            }
        }
    } */
}