package me.kafae.vitals.bin

import me.kafae.vitals.Main
import me.kafae.vitals.datastore.DataStore
import org.bukkit.entity.Player

fun update(p: Player) {
    val d: DataStore.PlayerData = Main.dataMap[p.uniqueId.toString()]!!

    d.bonus.toFixed(1)
    d.regen.toFixed(1)
    d.hp.toFixed(1)

    p.maxHealth += d.hp
}