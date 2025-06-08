package me.kafae.vitals.events

import me.kafae.vitals.bin.isCustom
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.ItemDespawnEvent

class ItemDespawn: Listener {

    @EventHandler(priority = EventPriority.LOW)
    private fun onItemDespawn(e: ItemDespawnEvent) {
        if (e.entity.itemStack.isCustom()) {
            e.isCancelled = true
        }
    }

}