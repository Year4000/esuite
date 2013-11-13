package net.year4000.echat;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sk89q.commandbook.CommandBook;
import com.zachsthings.libcomponents.ComponentInformation;
import com.zachsthings.libcomponents.bukkit.BukkitComponent;

import org.bukkit.Bukkit;
import org.bukkit.plugin.messaging.Messenger;

@ComponentInformation(friendlyName = "eChat",
        desc = "Chat formatting with features.")
public class EChat extends BukkitComponent{

	private String component = "[eChat]";
	private Logger logger = Logger.getLogger(component);
	private String version =
            this.getClass().getPackage().getImplementationVersion();
	private static EChat instance;
	private BungeeCord bungeeCord;
	private Config config;
	private Message message;
	private Sender sender;

    /**
     * Get the instance of EChat
     */
    public EChat() {
        super();
        instance = this;
    }

    /**
     * Returns the instance of EChat.
     *
     * @return EChat instance.
     */
    public static EChat inst() {
        return instance;
    }

    public void enable() {
        // Give the other classes an instance of EChat.
        config = configure(new Config());
        sender = new Sender();
        message = new Message();
        bungeeCord = new BungeeCord();
        CommandBook.registerEvents(message);

        // Send to other servers when you have BungeeCord enabled.
        if (config.bungeecord) {
            Messenger messenger = Bukkit.getServer().getMessenger();
            messenger.registerOutgoingPluginChannel(CommandBook.inst(),
                    "BungeeCord");
            messenger.registerIncomingPluginChannel(CommandBook.inst(),
                    "BungeeCord", bungeeCord);
        }
        logger.log(Level.INFO, component + " version " + version
                + " has been enabled.");
    }

    public void reload() {
        super.reload();
        configure(config);
        logger.log(Level.INFO, component + " has been reloaded.");
    }

    /**
     * Gets the instance of the Config class.
     *
     * @return Config instance
     */
    public Config getConfig() {
        return this.config;
    }

    /**
     * Gets the instance of the BungeeCord class.
     *
     * @return BungeeCord instance
     */
    public BungeeCord getBungeeCord() {
        return this.bungeeCord;
    }

    /**
     * Gets the instance of the Message class.
     *
     * @return Message instance.
     */
    public Message getMessage() {
        return this.message;
    }

    /**
     * Gets the instance of the Sender class.
     *
     * @return Sender instance.
     */
    public Sender getSender() {
        return this.sender;
    }
}
