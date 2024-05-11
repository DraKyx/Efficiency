package fr.drakyx.Lastarria.command.mod;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.drakyx.Main;

public class CommandVanish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
                if (Main.INSTANCE.invisible.contains(player)) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.showPlayer(Main.INSTANCE, player);
                    }
                    Main.INSTANCE.invisible.remove(player);
                    player.sendMessage("§3Tu n'es plus invisible");
                }else
                    if (!Main.INSTANCE.invisible.contains(player)) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.hidePlayer(Main.INSTANCE, player);
                        }
                        Main.INSTANCE.invisible.add(player);
                        player.sendMessage("§3Tu es maintenant invisible");
                    }
        }
        return true;
    }
}
