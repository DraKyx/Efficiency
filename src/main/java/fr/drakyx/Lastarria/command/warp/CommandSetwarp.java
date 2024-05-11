package fr.drakyx.Lastarria.command.warp;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.drakyx.Main;

public class CommandSetwarp implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.INSTANCE.getConfig().getString("NotPlayer").replace("&", "§"));
            return false;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("lastarria.setwarp")) {
            p.sendMessage(Main.INSTANCE.getConfig().getString("PasDePerms").replace("&", "§"));
            return false;
        }
        if (args.length == 0) {
            p.sendMessage("§3Tu dois donner un nom à ton warp");
            return false;
        }
        String name = args[0].toLowerCase();
        if (Main.INSTANCE.getConfig().get(name) != null) {
            p.sendMessage("§3Il y a déjà un warp avec ce nom");
            return false;
        }
        Location loc = p.getLocation();
        Main.INSTANCE.getConfig().set(name + ".World", loc.getWorld().getName());
        Main.INSTANCE.getConfig().set(name + ".X", loc.getX());
        Main.INSTANCE.getConfig().set(name + ".Y", loc.getY());
        Main.INSTANCE.getConfig().set(name + ".Z", loc.getZ());
        Main.INSTANCE.getConfig().set(name + ".Pitch", loc.getPitch());
        Main.INSTANCE.getConfig().set(name + ".Yaw", loc.getYaw());
        Main.INSTANCE.saveConfig();
        p.sendMessage("§3Le warp §2" + name + " §3a bien été crée");
        return true;
    }

}
