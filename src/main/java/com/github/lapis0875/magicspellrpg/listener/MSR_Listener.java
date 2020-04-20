package com.github.lapis0875.magicspellrpg.listener;

import com.github.lapis0875.magicspellrpg.console.FormattedConsole;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MSR_Listener implements Listener {

    // Colored, Formatted logger.
    FormattedConsole formattedConsole;

    public MSR_Listener(FormattedConsole formattedConsole){
        this.formattedConsole = formattedConsole;
    }

    /**
     * An event occured when player has joined to the server.
     * @params: PlayerJoinEvent e
     * */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

    }

    /**
     * An event occured when player has quit to the server.
     * @params: PlayerQuitEvent e
     * */
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

    }
}
