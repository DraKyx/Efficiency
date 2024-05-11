package fr.drakyx.Lastarria.command.warp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.drakyx.Main;

public class CommandDelWarp implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.INSTANCE.getConfig().getString("NotPlayer").replace("&", "§"));
            return false;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("lastarria.delwarp")) {
            p.sendMessage(Main.INSTANCE.getConfig().getString("PasDePerms").replace("&", "§"));
            return false;
        }
        if (args.length == 0) {
            p.sendMessage("§3Tu dois donner un nom au warp que tu veux supprimer");
            return false;
        }
        String name = args[0].toLowerCase();
        if (Main.INSTANCE.getConfig().get(name) == null) {
            p.sendMessage("§3Il n'y a pas de warp avec ce nom");
            return false;
        }
        Main.INSTANCE.getConfig().set(name, null);
        Main.INSTANCE.saveConfig();
        p.sendMessage("§3Le warp §2" + name + " §3a été supprimé");
        return true;
    }
    
}
