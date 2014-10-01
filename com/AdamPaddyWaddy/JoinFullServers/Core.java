package com.AdamPaddyWaddy.JoinFullServers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		Bukkit.getServer().getLogger().info("JoinFullServers has been enabled successfully");
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(this, this);
	}
	@Override
	public void onDisable() {
		Bukkit.getServer().getLogger().info("JoinFullServers has been disabled successfully!");
		
	}
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		Player p = event.getPlayer();
		if(p.hasPermission("JoinFullServers.JoinFull")){
			event.allow();
		}else {
			String TAG = ChatColor.GRAY + "[" + ChatColor.GOLD + "JoinFullServers" + ChatColor.GRAY + "]";
					
			event.disallow(Result.KICK_FULL, TAG + ChatColor.RED + "This server is full!");
		}
		

	
	}

}
 