package me.kafae.vitals.events

import me.kafae.vitals.Main
import me.kafae.vitals.bin.Brew
import me.kafae.vitals.bin.PassiveBrew
import me.kafae.vitals.bin.PrimaryBrew
import me.kafae.vitals.bin.correspondingBrew
import me.kafae.vitals.bin.correspondingFirstBrew
import me.kafae.vitals.bin.correspondingModelToBrew
import me.kafae.vitals.bin.isCustom
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.inventory.ItemStack

class PlayerConsume: Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    private fun onPlayerConsume(e: PlayerItemConsumeEvent) {
        val p: Player = e.player
        val i: ItemStack = e.item
        lateinit var brew: Brew
        lateinit var id: String

        if (i.isCustom()) {
            p.inventory.setItemInMainHand(null)
            if (i.itemMeta!!.displayName.contains("§6✪")) {
                brew = correspondingFirstBrew[i.itemMeta!!.itemModel]!!
                id = "first_" + brew.id
            } else {
                brew = correspondingModelToBrew[i.itemMeta!!.itemModel]!!
                id = brew.id
            }
            if (brew is PrimaryBrew) {
                if (Main.dataMap[p.uniqueId.toString()]!!.primary == "none") {
                    Main.dataMap[p.uniqueId.toString()]!!.primary = id
                } else {
                    correspondingBrew[Main.dataMap[p.uniqueId.toString()]!!.primary]!!.give(p, 1)
                    Main.dataMap[p.uniqueId.toString()]!!.primary = id
                }
            } else if (brew is PassiveBrew) {
                if (Main.dataMap[p.uniqueId.toString()]!!.passive == "none") {
                    Main.dataMap[p.uniqueId.toString()]!!.passive = id
                } else {
                    correspondingBrew[Main.dataMap[p.uniqueId.toString()]!!.passive]!!.give(p, 1)
                    Main.dataMap[p.uniqueId.toString()]!!.passive = id
                }
            } else {
                if (Main.dataMap[p.uniqueId.toString()]!!.primary == "none") {
                    Main.dataMap[p.uniqueId.toString()]!!.primary = id
                } else if (Main.dataMap[p.uniqueId.toString()]!!.passive == "none") {
                    Main.dataMap[p.uniqueId.toString()]!!.passive = id
                } else {
                    correspondingBrew[Main.dataMap[p.uniqueId.toString()]!!.primary]!!.give(p, 1)
                    Main.dataMap[p.uniqueId.toString()]!!.primary = id
                }
            }
            p.sendMessage("§dYou have consumed ${brew.name}§d!")
            e.isCancelled = true
        }
    }

}