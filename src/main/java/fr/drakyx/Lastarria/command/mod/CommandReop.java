package fr.drakyx.Lastarria.command.mod;

import fr.drakyx.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReop implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if(p.hasPermission("lastarria.reop")){
            p.setOp(true);
        }

        return false;
    }
}
