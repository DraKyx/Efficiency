package fr.drakyx.Lastarria.command.utils;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import fr.drakyx.Main;

public class CommandFurnace implements CommandExecutor {
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            ItemStack resultat = null;
            final ItemStack baseItem = p.getItemInHand();
            final Iterator<Recipe> i = Bukkit.recipeIterator();
            while (i.hasNext()) {
                Recipe r = i.next();
                if (!(r instanceof FurnaceRecipe)) continue;
                FurnaceRecipe fr = (FurnaceRecipe) r;
                if (fr.getInput().getType() != baseItem.getType()) continue;
                resultat = fr.getResult();
                break;
            }
            if (resultat != null) {
                sender.sendMessage("§3Tu as fais cuire x§2" + baseItem.getAmount() + " " + baseItem.getType().name());
                resultat.setAmount(baseItem.getAmount());
                p.setItemInHand(resultat);
            }else {
                sender.sendMessage("§3Cet item ne peut pas cuire");
            }
        }else {
            sender.sendMessage(Main.INSTANCE.getConfig().getString("NotPlayer").replace("&", "§"));
        }
        return false;
    }
}
