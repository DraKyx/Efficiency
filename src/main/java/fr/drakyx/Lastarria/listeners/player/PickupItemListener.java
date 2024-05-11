package fr.drakyx.Lastarria.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import fr.drakyx.Main;

public class PickupItemListener implements Listener{
	
	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent event) {
		 
		Player player = event.getPlayer();
		String p = player.getName();
		
		if (Main.INSTANCE.invisible.contains(player)){
			if (p.equals("DraKyx_"))
				player.setCanPickupItems(false);
			
        }else if(!Main.INSTANCE.invisible.contains(player)) {
        	player.setCanPickupItems(true);
        }
	}
}
