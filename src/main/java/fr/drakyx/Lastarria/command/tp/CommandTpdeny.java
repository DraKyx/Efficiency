package fr.drakyx.Lastarria.command.tp;

import fr.drakyx.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTpdeny implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        /*Player player = (Player) sender;
        if(sender instanceof Player){
            Player target = Bukkit.getPlayer(args[0]);
            String playerString = player.getName();
            String targetString = args[0];

            if(target != null && target.isOnline() && player.hasPermission("lastarria.tpdeny") && target.hasPermission("lastarria.tpa")){
                if (Main.INSTANCE.tpa.containsKey(target) && Main.INSTANCE.tpa.get(target) == player){

                	Main.INSTANCE.tpa.remove(target);
                    player.sendMessage("§3Tu as refusé la demande de §2" + targetString);
                    target.sendMessage("§2" + playerString + " §3a refusé votre demande");

                }
            }else{
                player.sendMessage(Main.INSTANCE.getConfig().getString("PasDePerms").replace("&", "§"));
            }
        }*/
        return false;
    }
}
