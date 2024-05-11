package fr.drakyx.Lastarria.listeners.block;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.drakyx.Main;

public class BlockPlaceListener implements Listener{

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event)
    {
		Player player = event.getPlayer();
        ItemStack spawnerItem = event.getItemInHand();
        
        if (spawnerItem.getType() == Material.SPAWNER && spawnerItem.hasItemMeta())
        {
        	
        	ItemMeta spawnerMeta = spawnerItem.getItemMeta();

            String name = ChatColor.stripColor(spawnerMeta.getDisplayName());
            int entityTypeLength = name.length() - 8;

            String entityTypeString = name.substring(0, entityTypeLength);
            EntityType entityType = EntityType.valueOf(entityTypeString);

            Block spawnerBlock = event.getBlock();

            CreatureSpawner spawner = (CreatureSpawner) spawnerBlock.getState();
            spawner.setSpawnedType(entityType);
            spawner.update();
        }
    }
}
