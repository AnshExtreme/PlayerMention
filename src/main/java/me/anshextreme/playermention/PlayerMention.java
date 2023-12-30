package me.anshextreme.playermention;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerMention extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();
        for (Player onlinePlayer : getServer().getOnlinePlayers()) {
            String playerName = onlinePlayer.getName();
            if (message.toLowerCase().contains(playerName.toLowerCase())) {
                String highlightedName = ChatColor.GREEN + playerName + ChatColor.RESET;
                message = message.replaceAll("(?i)" + playerName, highlightedName);
            }
        }
        event.setMessage(message);
    }
}