package net.year4000.ejoinmessage;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sk89q.commandbook.CommandBook;
import com.zachsthings.libcomponents.ComponentInformation;
import com.zachsthings.libcomponents.bukkit.BukkitComponent;
import com.zachsthings.libcomponents.config.ConfigurationBase;
import com.zachsthings.libcomponents.config.Setting;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@ComponentInformation(friendlyName = "eJoinMessage", desc = "Login messages that depends on last join.")
public class EJoinMessage extends BukkitComponent implements Listener {
	
	private LocalConfiguration config;
	private String component = "[eJoinMessage]";
	private String version = this.getClass().getPackage().getImplementationVersion();
	private String playerName;
	
    
    public void enable() {
    	config = configure(new LocalConfiguration());
        CommandBook.registerEvents(this);
        Logger.getLogger(component).log(Level.INFO, component+" version "+version+" has been enabled.");
    }

    public void reload() {
        super.reload();
        configure(config);
        Logger.getLogger(component).log(Level.INFO, component+" has been reloaded.");
    }
    
    public static class LocalConfiguration extends ConfigurationBase {
    	@Setting("first-join") public String firstJoin = "&a%player% has joined the game for the first time.";
    	@Setting("normal-join") public String normalJoin = "&a%player% has joined the game.";
    	@Setting("break-join") public String breakJoin = "&a%player% is back from a break.";
    	@Setting("break-time") public Long breakTime = (long) 1209600000;
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event){
    	Player player = event.getPlayer();
    	playerName = player.getName();
    	String message = config.normalJoin;
    	
    	if(player.getLastPlayed() == 0){
    		message = config.firstJoin;
    	} else if((player.getLastPlayed()+config.breakTime) < System.currentTimeMillis()){
    		message = config.breakJoin;
    	} else{
    		message = config.normalJoin;
    	}
    	event.setJoinMessage(replaceVars(message));
    }
    
    public String replaceVars(String msgformat){
    	msgformat = msgformat.replace("%player%",playerName);

    	for(ChatColor c : ChatColor.values()){
    		msgformat = msgformat.replaceAll("&"+c.getChar(),c.toString()); 
    	}

    	return msgformat;
    }
}