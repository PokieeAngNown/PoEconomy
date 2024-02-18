package cn.postudio.poeconomy;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class Economy implements Listener {

    @EventHandler
    public void playerJoinServerEvent(@NotNull PlayerJoinEvent playerJoinEvent){
        Player player = playerJoinEvent.getPlayer();
        EconomyStuff.initializePlayerEconomy(player);
    }
}
