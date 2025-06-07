package me.kafae.vitals.icons

import me.kafae.vitals.bin.Icon
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class PassiveBrewIcon: Icon() {

    override val item: ItemStack = ItemStack(Material.COAL)
    override val displayName: String = "§7§kE §8⟳ §8Passive Brew §7§kE"
    override val customModel: NamespacedKey? = NamespacedKey("vitals", "passive_brew")

}