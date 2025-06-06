package me.kafae.vitals.events

import me.kafae.vitals.Main
import me.kafae.vitals.datastore.DataStore
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.Listener

class PlayerLeave: Listener {

    private val ds: DataStore = DataStore()

    @EventHandler(priority = EventPriority.NORMAL)
    private fun onPlayerQuit(e: PlayerQuitEvent) {
        val p: Player = e.player
        val uid: String = p.uniqueId.toString()
        ds.save(uid)
        Main.log.info("Saved data for ${p.name}")
    }

}