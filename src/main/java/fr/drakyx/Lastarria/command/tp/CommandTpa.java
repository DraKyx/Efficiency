package fr.drakyx.Lastarria.command.tp;

import fr.drakyx.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTpa implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        /*Player player = (Player) sender;
        if(sender instanceof Player){
            Player target = Bukkit.getPlayer(args[0]);
            String targetString = args[0];
            String playerString = player.getName();

            if(target != null && target.isOnline() && player.hasPermission("lastarria.tpa") && target.hasPermission("lastarria.tpaccept")){
            	Main.INSTANCE.tpa.put(player, target);
                player.sendMessage("§3Tu as demandé à §2" + targetString + " §3de se tp à lui");
                target.sendMessage("§2" + playerString + " §3veut se tp à vous");
                target.sendMessage("§3Fais /tpaccept §2" + playerString + " §3ou /tpdeny §2" + playerString);

            }else{
                player.sendMessage("§3Tu ne peux pas /tpa ou la personne ne peut pas /tpaccept");
            }

        }*/
        return false;
    }
}
