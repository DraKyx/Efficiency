package fr.drakyx.Lastarria.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.drakyx.Main;

public class MoveListener implements Listener {
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		
		Player player = event.getPlayer();
		if(Main.freeze.containsKey(player)) {
			event.setCancelled(true);
			player.sendMessage("§3Tu es freeze");
		}
	}
}
