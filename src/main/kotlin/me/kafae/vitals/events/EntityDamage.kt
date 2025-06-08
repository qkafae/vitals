package me.kafae.vitals.events

import me.kafae.vitals.bin.isCustom
import org.bukkit.entity.Item
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

class EntityDamage: Listener {

    @EventHandler(priority = EventPriority.LOW)
    private fun onEntityDamage(e: EntityDamageEvent) {
        if (e.entity is Item) {
            if ((e.entity as Item).itemStack.isCustom()) {
                e.isCancelled = true
            }
        }
    }

}