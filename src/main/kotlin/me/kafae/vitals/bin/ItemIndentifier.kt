package me.kafae.vitals.bin

import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

interface ItemIndentifier {

    val id: String
    val name: String
    val customModel: NamespacedKey
    val lore: List<String>
    fun get(n: Int): ItemStack
    fun give(p: Player, n: Int)

}