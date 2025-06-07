package me.kafae.vitals.bin

import org.bukkit.Bukkit
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

abstract class Icon {

    abstract val item: ItemStack
    abstract val displayName: String
    abstract val customModel: NamespacedKey?

    open fun get(): ItemStack {
        val iconMeta: ItemMeta = Bukkit.getItemFactory().getItemMeta(item.type)!!
        iconMeta.setItemName(displayName)
        if (customModel != null) {
            iconMeta.itemModel = customModel
        }
        item.itemMeta = iconMeta
        return item
    }

}