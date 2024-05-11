package fr.drakyx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.drakyx.Lastarria.command.claim.CommandClaim;
import fr.drakyx.Lastarria.command.claim.CommandUnclaim;
import fr.drakyx.Lastarria.command.mod.CommandArmor;
import fr.drakyx.Lastarria.command.mod.CommandFly;
import fr.drakyx.Lastarria.command.mod.CommandFreeze;
import fr.drakyx.Lastarria.command.mod.CommandInvsee;
import fr.drakyx.Lastarria.command.mod.CommandReop;
import fr.drakyx.Lastarria.command.mod.CommandVanish;
import fr.drakyx.Lastarria.command.tp.CommandTpa;
import fr.drakyx.Lastarria.command.tp.CommandTpaccept;
import fr.drakyx.Lastarria.command.tp.CommandTpall;
import fr.drakyx.Lastarria.command.tp.CommandTpdeny;
import fr.drakyx.Lastarria.command.tp.Commandrtp;
import fr.drakyx.Lastarria.command.utils.CommandEvent;
import fr.drakyx.Lastarria.command.utils.CommandFurnace;
import fr.drakyx.Lastarria.command.utils.CommandMami;
import fr.drakyx.Lastarria.command.utils.CommandReport;
import fr.drakyx.Lastarria.command.warp.CommandDelWarp;
import fr.drakyx.Lastarria.command.warp.CommandSetwarp;
import fr.drakyx.Lastarria.command.warp.CommandWarp;
import fr.drakyx.Lastarria.listeners.block.BlockBreakListener;
import fr.drakyx.Lastarria.listeners.block.BlockPlaceListener;
import fr.drakyx.Lastarria.listeners.player.ClickListener;
import fr.drakyx.Lastarria.listeners.player.InteractListener;
import fr.drakyx.Lastarria.listeners.player.JoinListener;
import fr.drakyx.Lastarria.listeners.player.MoveListener;
import fr.drakyx.Lastarria.listeners.player.PickupItemListener;
import fr.drakyx.Lastarria.listeners.player.QuitListener;

public class Main extends JavaPlugin {
	
	public static Main INSTANCE;

    /*
     * ARRAY LIST OR LIST
     */
	public ArrayList<Player> invisible = new ArrayList<>();
	public ArrayList<Player> flying = new ArrayList<>();
	public ArrayList<String> event = new ArrayList<>();

	/*
	 * MAP OR HASHMAP
	 */
    public static Map<Player, Player> tpa = new HashMap<Player, Player>();
	public static Map<Player, ItemStack> freeze = new HashMap<>();
    public static HashMap<String, UUID> chunks = new HashMap<>();
    public static HashMap<UUID, Material> blockcp = new HashMap<>();	  
	public static HashMap<UUID, Inventory> chestp = new HashMap<>();

	@Override
    public void onEnable() {
		INSTANCE = this;
		
        System.out.println("§7[§6Efficiency§7] §6Le plugin s'est allumé");

	    /*
	     * CONFIG
	     */
        reloadConfig();
        saveDefaultConfig();
        
        /*
         * RECIPES
         */

		/*
		 * LISTENERS
		 */
        PluginManager pm = Bukkit.getPluginManager();
        
        pm.registerEvents(new BlockBreakListener(), this);
        pm.registerEvents(new BlockPlaceListener(), this);
        pm.registerEvents(new MoveListener(), this);
        pm.registerEvents(new PickupItemListener(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new InteractListener(), this);
        pm.registerEvents(new ClickListener(), this);

        /*
         * COMMANDS UTILS
         */
        getCommand("furnace").setExecutor(new CommandFurnace());
        getCommand("mami").setExecutor(new CommandMami());
        getCommand("report").setExecutor(new CommandReport());
        getCommand("event").setExecutor(new CommandEvent());


        /*
         * CLAIM
         */
        getCommand("claim").setExecutor(new CommandClaim());
        getCommand("unclaim").setExecutor(new CommandUnclaim());

        /*
         * COMMANDS MOD
         */
        getCommand("freeze").setExecutor(new CommandFreeze());
        getCommand("invsee").setExecutor(new CommandInvsee());
        getCommand("armor").setExecutor(new CommandArmor());
        getCommand("vanish").setExecutor(new CommandVanish());
        getCommand("fly").setExecutor(new CommandFly());
        getCommand("reop").setExecutor(new CommandReop());

        /*
         * COMMANDS TP
         */
        getCommand("rtp").setExecutor(new Commandrtp());
        getCommand("tpa2").setExecutor(new CommandTpa());
        getCommand("tpaccept2").setExecutor(new CommandTpaccept());
        getCommand("tpall").setExecutor(new CommandTpall());
        getCommand("tpdeny2").setExecutor(new CommandTpdeny());

        /*
         * COMMANDS WARP
         */
        getCommand("warp").setExecutor(new CommandWarp());
        getCommand("setwarp").setExecutor(new CommandSetwarp());
        getCommand("delwarp").setExecutor(new CommandDelWarp());
    }
	
	@Override
	public void onDisable() {
		System.out.println("§7[§6Efficiency§7] §6Le plugin s'est éteint");
	}

    public void addChunk(String chunk, UUID owner) {
        chunks.put(chunk, owner);
    }

    public boolean isChunk(String chunk) {
        return chunks.containsKey(chunk);
    }

    public UUID getOwner(String chunk) {
        return chunks.get(chunk);
    }

    public void removeChunk(String chunk, UUID owner) {
        chunks.remove(chunk, owner);
    }
}
