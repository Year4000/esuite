package net.year4000.echat;

import org.bukkit.Bukkit;

import com.sk89q.commandbook.CommandBook;

import net.year4000.echat.Sender;

public class Message {
    // The vars of the environment.
    private String playerName;
    private String playerDisplayName;
    private String playerWorldName;
    private String playerServer;
    private String playerMessage;
    private String playerGroup;
    private String playerFormat;
    private String playerColor;
    private String playerFaction;
    private String playerTitle;

    /**
     * Send the current message to the sender thread.
     *
     * @param message This class
     */
    public void sendMessage(Message message) {
        Bukkit.getScheduler().runTaskAsynchronously(CommandBook.inst(),
                new Sender(message));
    }

    /**
     * Gets the player's name.
     *
     * @return player's name.
     */
    public String getPlayerName() {
        if (this.playerName == null) {
            return "";
        }
        return this.playerName;
    }

    /**
     * Gets the player's display name on the server the player is log in to.
     *
     * @return player's display name.
     */
    public String getPlayerDisplayName() {
        if (this.playerDisplayName == null) {
            return "";
        }
        return this.playerDisplayName;
    }

    /**
     * Gets the world that the player is in on the server.
     *
     * @return player's current world.
     */
    public String getPlayerWorldName() {
        if (this.playerWorldName == null) {
            return "";
        }
        return this.playerWorldName;
    }

    /**
     * Gets the name of the server that the player is log in to.
     *
     * @return player's current server.
     */
    public String getPlayerServer() {
        if (this.playerServer == null) {
            return "";
        }
        return this.playerServer;
    }

    /**
     * Gets the player's chat message from the server that the player is log
     * in to.
     *
     * @return player's chat message.
     */
    public String getPlayerMessage() {
        if (this.playerMessage == null) {
            return "";
        }
        return this.playerMessage;
    }

    /**
     * Gets the default group from the server that the player is log in to.
     *
     * @return player's default group name.
     */
    public String getPlayerGroup() {
        if (this.playerGroup == null) {
            return "";
        }
        return this.playerGroup;
    }

    /**
     * Gets the message format from the server that the player is log in to.
     *
     * @return message format from the server.
     */
    public String getPlayerFormat() {
        if (this.playerFormat == null) {
            return "";
        }
        return this.playerFormat;
    }

    /**
     * Get if the player can use colors in the chat.
     *
     * @return true if the player can use the colors.
     */
    public String getPlayerColor() {
        if (this.playerColor == null || this.playerColor.equals("false")) {
            return "false";
        }
        return "true";
    }

    /**
     * Get the player's faction.
     *
     * @return the name of the player's faction
     */
    public String getPlayerFaction() {
        if (this.playerFaction == null) {
            return "";
        }
        return this.playerFaction;
    }

    /**
     * Get the player's faction title.
     *
     * @return the player's title
     */
    public String getPlayerTitle() {
        if (this.playerTitle == null) {
            return "";
        }
        return this.playerTitle;
    }

    /**
     * Set the players faction title.
     *
     * @param the player's title
     */
    public void setPlayerTitle(String title) {
        this.playerTitle = title;
    }

    /**
     * Set the players faction.
     *
     * @param the name of the player's faction
     */
    public void setPlayerFaction(String faction) {
        this.playerFaction = faction;
    }

    /**
     * Set if the player can use colors in the chat.
     *
     * @param option Allow the player to use colors.
     */
    public void setPlayerColor(String option) {
        if (option.equals("true")) {
            this.playerColor = "true";
        }
        else {
            this.playerColor = "false";
        }
    }

    /**
     * Sets the player's name.
     *
     * @param playerName The name of the player.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Sets the player's display name.
     *
     * @param playerDisplayName The display name of the player.
     */
    public void setPlayerDisplayName(String playerDisplayName) {
        this.playerDisplayName = playerDisplayName;
    }

    /**
     * Sets the player's world.
     *
     * @param playerWorldName The player's current world name.
     */
    public void setPlayerWorldName(String playerWorldName) {
        this.playerWorldName = playerWorldName;
    }

    /**
     * Sets the player's server.
     *
     * @param playerServer The player's server name.
     */
    public void setPlayerServer(String playerServer) {
        this.playerServer = playerServer;
    }

    /**
     * Sets the player's message.
     *
     * @param playerMessage The player's message.
     */
    public void setPlayerMessage(String playerMessage) {
        this.playerMessage = playerMessage;
    }

    /**
     * Sets the player's single group.
     *
     * @param group The group the players in
     */
    public void setPlayerGroup(String group) {
        this.playerGroup = group;
    }

    /**
     * Sets the player's format.
     *
     * @param format The chats format.
     */
    public void setPlayerFormat(String format) {
        this.playerFormat = format;
    }
}
