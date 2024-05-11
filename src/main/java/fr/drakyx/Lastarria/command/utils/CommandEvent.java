package fr.drakyx.Lastarria.command.utils;

import fr.drakyx.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEvent implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0){
            sender.sendMessage("§3Tu dois mettre un argument (start, stop, join ou leave)");
            return false;
        }

        Player p = (Player) sender;

        String event = args[0].toLowerCase();
        String pstring = p.getName();
        String start = "start";

        Location l = p.getLocation();

        if(event.equals("join")) {
            if(Main.INSTANCE.event.contains(start)) {
                if (p.getInventory().isEmpty()) {
                    if (!p.hasPermission("lastarria.event.jl")) {
                        p.sendMessage("§3Tu n'as pas la permission de rejoindre l'event");

                    } else {
                        Location loc = new Location(Bukkit.getWorld("mapevent"), 0, -60, 0);

                        Main.INSTANCE.getConfig().set(pstring + ".World", l.getWorld().getName());
                        Main.INSTANCE.getConfig().set(pstring + ".X", l.getX());
                        Main.INSTANCE.getConfig().set(pstring + ".Y", l.getY());
                        Main.INSTANCE.getConfig().set(pstring + ".Z", l.getZ());
                        Main.INSTANCE.getConfig().set(pstring + ".Pitch", l.getPitch());
                        Main.INSTANCE.getConfig().set(pstring + ".Yaw", l.getYaw());
                        Main.INSTANCE.saveConfig();
                        p.teleport(loc);
                        p.sendMessage("§3Tu as bien rejoint l'event");
                    }
                } else {
                    p.sendMessage("§3Ton inventaire doit être vide, sous peine de clear");
                }
            }else {
                p.sendMessage("§3Il n'y a pas d'event en cours");
            }
        }

        if(event.equals("leave")) {
            if (p.getWorld().getName().equals("mapevent")) {
                if (p.getInventory().isEmpty()) {
                    if (!p.hasPermission("lastarria.event.jl")) {
                        p.sendMessage("Tu n'as pas la permission de quitter l'event");

                    }else {
                        String world = (String) Main.INSTANCE.getConfig().get(pstring + ".World", l.getWorld().getName());
                        double x = (double) Main.INSTANCE.getConfig().getDouble(pstring + ".X", l.getX());
                        double y = (double) Main.INSTANCE.getConfig().getDouble(pstring + ".Y", l.getY());
                        double z = (double) Main.INSTANCE.getConfig().getDouble(pstring + ".Z", l.getZ());
                        float pitch = (float) Main.INSTANCE.getConfig().getDouble(pstring + ".Pitch", l.getPitch());
                        float yaw = (float) Main.INSTANCE.getConfig().getDouble(pstring + ".Yaw", l.getYaw());

                        Location loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
                        p.teleport(loc);
                        p.sendMessage("§3Tu as quitté l'event, tu es revenu à ton emplacement avant de le rejoindre");
                        p.setGameMode(GameMode.SURVIVAL);
                    }
                }else {
                    p.sendMessage("§3Ton inventaire doit être vide, comme ça");
                    p.getInventory().clear();
                }
            }else {
                p.sendMessage("§3Tu dois être dans la map event");
            }
        }

        if (p.hasPermission("lastarria.event.jl")) {
            if (p.hasPermission("lastarria.event.ss")) {
                if (event.equals("start")) {
                    if (Main.INSTANCE.event.contains(start)) {
                        p.sendMessage("§3Il y a déjà un event en cours");
                    } else if (!Main.INSTANCE.event.contains(start)) {
                        p.sendMessage("§3Tu as fais commencer un event");
                        Bukkit.broadcastMessage("§3Un event a commencé, faites /event join");
                        Main.INSTANCE.event.add(start);
                    }
                }
            } else {
                p.sendMessage(Main.INSTANCE.getConfig().getString("PasDePerms").replace("&", "§"));
            }
        }

        if (p.hasPermission("lastarria.event.jl")) {
            if (p.hasPermission("lastarria.event.ss")) {
                if (event.equals("stop")) {
                    if (Main.INSTANCE.event.contains(start)) {
                        p.sendMessage("§3L'event est terminé");
                        Bukkit.broadcastMessage("§3L'event est terminé, faites /event leave");
                        Main.INSTANCE.event.remove(start);
                    } else if (!Main.INSTANCE.event.contains(start)) {
                        p.sendMessage("§3Il n'y a pas d'event en cours");
                    }
                }
            } else {
                p.sendMessage(Main.INSTANCE.getConfig().getString("PasDePerms").replace("&", "§"));
            }
        }
        return true;
    }
}
