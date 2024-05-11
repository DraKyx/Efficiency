package fr.drakyx.Lastarria.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.drakyx.Main;

public class JoinListener implements Listener {

	@EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
		
		event.setJoinMessage("§2" + player.getName() + " §3a rejoint le serveur");
        
        for (int i = 0; i < Main.INSTANCE.invisible.size(); i++){
            player.hidePlayer(Main.INSTANCE, Main.INSTANCE.invisible.get(i));
        }
    }
}
