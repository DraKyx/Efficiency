package fr.drakyx.Lastarria.command.tp;

import fr.drakyx.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTpaccept implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        /*Player player = (Player) sender;

        if(sender instanceof Player){
            Player target = Bukkit.getPlayer(args[0]);
            String playerString = player.getName();
            String targetString = args[0];

            if(target != null && target.isOnline() && player.hasPermission("lastarria.tpaccept") && target.hasPermission("lastarria.tpa")){
                if(Main.INSTANCE.tpa.containsKey(target) && Main.INSTANCE.tpa.get(target) == player){

                    Location loc = player.getLocation();

                    target.teleport(loc);
                    target.sendMessage("Vous avez été tp à §2" + playerString);
                    player.sendMessage("§2" + targetString + " §3s'est bien tp à vous");

                    Main.INSTANCE.tpa.remove(target);
                }
            }else{
                player.sendMessage(Main.INSTANCE.getConfig().getString("PasDePerms").replace("&", "§"));
            }
        }*/

        return false;
    }
}
