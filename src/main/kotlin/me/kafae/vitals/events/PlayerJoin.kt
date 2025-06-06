package me.kafae.vitals.events

import me.kafae.vitals.Main
import me.kafae.vitals.datastore.DataStore
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoin: Listener {

    private val ds: DataStore = DataStore()

    @EventHandler(priority = EventPriority.NORMAL)
    private fun onPlayerJoin(e: PlayerJoinEvent) {
        val p: Player = e.player
        val uid: String = p.uniqueId.toString()
        Main.dataMap[uid] = ds.load(uid)
        Main.log.info("Loaded data for ${p.name}")
    }

}