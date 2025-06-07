package me.kafae.vitals.events

import me.kafae.vitals.Main
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityRegainHealthEvent

class EntityRegainHealth: Listener {

    @EventHandler(priority = EventPriority.HIGH)
    private fun onEntityRegainHealth(e: EntityRegainHealthEvent) {
        if (e.entity !is Player) {
            return
        }
        e.amount *= Main.dataMap[(e.entity as Player).uniqueId.toString()]!!.regen
    }

}