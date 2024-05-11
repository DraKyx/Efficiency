package fr.drakyx.Lastarria.listeners.player;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.drakyx.Main;

public class InteractListener implements Listener {
	
	@EventHandler
    public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
        if (event.getClickedBlock() != null) {
            Chunk chunk = event.getClickedBlock().getChunk();
            String chunkID = chunk.getX() + "." + chunk.getZ();

            if (Main.INSTANCE.isChunk(chunkID)) {
                if (!Main.INSTANCE.getOwner(chunkID).equals(player.getUniqueId()) && !player.isOp()) {
                    event.setCancelled(true);
                    player.sendMessage("§3Tu n'es pas autorisé à éditer ce chunk");
                }
            }
        }
    }
}
