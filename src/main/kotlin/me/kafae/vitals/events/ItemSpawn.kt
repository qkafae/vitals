package me.kafae.vitals.events

import me.kafae.vitals.bin.isCustom
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.ItemSpawnEvent

class ItemSpawn: Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    private fun onItemSpawn(e: ItemSpawnEvent) {
        if (e.entity.itemStack.isCustom()) {
            e.entity.isGlowing = true
        }
    }

}