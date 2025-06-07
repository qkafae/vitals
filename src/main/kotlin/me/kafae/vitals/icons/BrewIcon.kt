package me.kafae.vitals.icons

import me.kafae.vitals.bin.Icon
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class BrewIcon: Icon() {

    override val item: ItemStack = ItemStack(Material.BREWING_STAND)
    override val displayName: String = "§5§kE §dBrews §5§kE"
    override val customModel: NamespacedKey? = null

}