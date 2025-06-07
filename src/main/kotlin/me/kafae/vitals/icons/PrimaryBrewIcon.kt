package me.kafae.vitals.icons

import me.kafae.vitals.bin.Icon
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class PrimaryBrewIcon: Icon() {

    override val item: ItemStack = ItemStack(Material.DIAMOND)
    override val displayName: String = "§2§kE §a✊ §aPrimary Brew §2§kE"
    override val customModel: NamespacedKey? = NamespacedKey("vitals", "primary_brew")

}