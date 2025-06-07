package me.kafae.vitals.icons

import me.kafae.vitals.bin.Icon
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class BrewLibraryIcon: Icon() {

    override val item: ItemStack = ItemStack(Material.BOOKSHELF)
    override val displayName: String = "§e§kE §6Brew Library §e§kE"
    override val customModel: NamespacedKey? = null

}