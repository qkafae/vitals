package me.kafae.vitals.icons

import me.kafae.vitals.bin.Icon
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class SpecialBrewIcon: Icon() {

    override val item: ItemStack = ItemStack(Material.NETHER_STAR)
    override val displayName: String = "§c§kE §4✰ §4Special Brew §c§kE"
    override val customModel: NamespacedKey? = NamespacedKey("vitals", "special_brew")

}