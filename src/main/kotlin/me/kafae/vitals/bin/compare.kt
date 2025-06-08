package me.kafae.vitals.bin

import org.bukkit.inventory.ItemStack

fun ItemStack.isSame(i: CustomItem): Boolean {
    if (this.hasItemMeta()) {
        if (this.itemMeta!!.hasItemModel()) {
            if (this.itemMeta!!.itemModel == i.customModel) {
                return true
            }
        }
    }
    return false
}

fun ItemStack.isCustom(): Boolean {
    if (this.hasItemMeta()) {
        if (this.itemMeta!!.hasItemModel()) {
            return true
        }
    }
    return false
}