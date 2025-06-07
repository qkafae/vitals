package me.kafae.vitals.icons

import me.kafae.vitals.bin.Icon
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class BackgroundIcon: Icon() {

    override val item: ItemStack = ItemStack(Material.GRAY_STAINED_GLASS_PANE)
    override val displayName: String = " "
    override val customModel: NamespacedKey? = null

}