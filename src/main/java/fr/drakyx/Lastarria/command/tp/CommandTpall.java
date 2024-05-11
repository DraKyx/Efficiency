package fr.drakyx.Lastarria.command.tp;

import fr.drakyx.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTpall implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (sender instanceof Player && player.hasPermission("lastarria.tpall")){
            if (Bukkit.getServer().getOnlinePlayers().size() == 1){
                player.sendMessage("§3Aucun joueur n'est présent à part toi");
            }else if(Bukkit.getServer().getOnlinePlayers().size() > 1){
                int numOfPlayers = 0;
                for(Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.teleport(player.getLocation());
                    numOfPlayers++;
                }
                player.sendMessage("§2" + (numOfPlayers - 1) + " §3joueurs ont été téléportés sur toi.");
            }
        }else{
            player.sendMessage(Main.INSTANCE.getConfig().getString("PasDePerms").replace("&", "§"));
        }
        return false;
    }
}
