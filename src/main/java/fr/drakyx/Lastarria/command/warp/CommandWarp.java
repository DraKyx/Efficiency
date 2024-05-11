package fr.drakyx.Lastarria.command.warp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.drakyx.Main;

public class CommandWarp implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.INSTANCE.getConfig().getString("NotPlayer").replace("&", "§"));
            return false;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("lastarria.warp")){
            p.sendMessage(Main.INSTANCE.getConfig().getString("PasDePerms").replace("&", "§"));
            return false;
        }
        if (args.length == 0) {
            p.sendMessage("§3Tu dois donner un nom");
            return false;
        }
        String name = args[0].toLowerCase();
        if (Main.INSTANCE.getConfig().get(name) == null) {
            p.sendMessage("§3Il n'y a pas de warp avec ce nom");
            return false;
        }
        Location loc;
        double x = Main.INSTANCE.getConfig().getDouble(name + ".X");
        double y = Main.INSTANCE.getConfig().getDouble(name + ".Y");
        double z = Main.INSTANCE.getConfig().getDouble(name + ".Z");
        float yaw = (float) Main.INSTANCE.getConfig().getDouble(name + ".Yaw");
        float pitch = (float) Main.INSTANCE.getConfig().getDouble(name + ".Pitch");
        String world = Main.INSTANCE.getConfig().getString(name + ".World");
        loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
        p.teleport(loc);
        p.sendMessage("§3Tu as bien été tp au warp §2" + name);
        return true;
  }
}

