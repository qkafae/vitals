package me.kafae.vitals.bin

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

abstract class Gui() {

    open val owner: InventoryHolder? = null
    open val slots: Int? = owner?.let { 27 }
    open val title: String = ""

    abstract val items: HashMap<Int, ItemStack>

    val ui: Inventory? by lazy {
        owner?.let {
            Bukkit.createInventory(owner!!, slots!!, title!!). apply {
                for ((k, v) in items) {
                    setItem(k, v)
                }
            }
        }
    }

    open fun open(p: Player) {
        owner?.let {
            p.openInventory(ui!!)
        }
    }

}