package me.kafae.vitals.events

import me.kafae.vitals.bin.isCustom
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

class PlayerConsume: Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    private fun onPlayerConsume(e: PlayerItemConsumeEvent) {
        val p: Player = e.player
        val i: ItemStack = e.item

        if (i.isCustom()) {

            e.isCancelled = true
        }
    }

}