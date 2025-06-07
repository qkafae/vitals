package me.kafae.vitals.bin

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

abstract class PrimaryBrew {

    abstract val id: String
    abstract val name: String
    abstract val customModel: NamespacedKey
    abstract val cost: Double
    open val lore: List<String> = listOf()

    open fun get(): ItemStack {
        val i: ItemStack = ItemStack(Material.POTION)
        val im: ItemMeta = Bukkit.getItemFactory().getItemMeta(i.type)!!

        var lr: MutableList<String> = mutableListOf("--------------------", "", "", "id: $id")
        lr.addAll(2, lore)
        lr.map { "§7$it" }

        im.apply {
            setItemName(name)
            itemModel = customModel
            lore = lr
        }

        i.itemMeta = im
        return i
    }

    open fun give(p: Player) {
        p.inventory.addItem(get())
    }

    open fun activate(p: Player) {
        return
    }

}