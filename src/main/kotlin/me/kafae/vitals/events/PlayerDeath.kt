package me.kafae.vitals.events

import me.kafae.vitals.Main
import me.kafae.vitals.bin.correspondingBrew
import me.kafae.vitals.bin.toFixed
import me.kafae.vitals.items.LifeElixir
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class PlayerDeath: Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    private fun onPlayerDeath(e: PlayerDeathEvent) {
        val vic: Player = e.entity
        val atk: Player? = vic.killer
        var vamt: Double = 0.0
        var aamt: Double = 0.0

        if (Main.dataMap[vic.uniqueId.toString()]!!.primary != "none") {
            e.drops.add(correspondingBrew[Main.dataMap[vic.uniqueId.toString()]!!.primary]!!.get(1))
        }
        if (Main.dataMap[vic.uniqueId.toString()]!!.passive != "none") {
            e.drops.add(correspondingBrew[Main.dataMap[vic.uniqueId.toString()]!!.passive]!!.get(1))
        }

        if (Main.dataMap[vic.uniqueId.toString()]!!.regen > 0.5) {
            if (atk != null) {
                if (Main.dataMap[atk.uniqueId.toString()]!!.regen < 1.5) {
                    vamt = 0.1
                    aamt = 0.1
                    Main.dataMap[vic.uniqueId.toString()]!!.regen -= 0.1
                    Main.dataMap[atk.uniqueId.toString()]!!.regen += 0.1
                } else {
                    vamt = 0.1
                    Main.dataMap[vic.uniqueId.toString()]!!.regen -= 0.1
                    e.drops.add(LifeElixir().get(1))
                }
                Main.dataMap[atk?.uniqueId.toString()]!!.regen = Main.dataMap[atk?.uniqueId.toString()]!!.regen.toFixed(1)
            } else {
                vamt = 0.1
                Main.dataMap[vic.uniqueId.toString()]!!.regen -= 0.1
                e.drops.add(LifeElixir().get(1))
            }
        }

        vic.sendMessage("§l§4You died and lost ${vamt}x multiplier!")
        atk?.sendMessage("§l§4You killed ${vic.displayName} and gained ${aamt}x multiplier!")
        Main.dataMap[vic.uniqueId.toString()]!!.regen = Main.dataMap[vic.uniqueId.toString()]!!.regen.toFixed(1)
    }

}