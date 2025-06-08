package me.kafae.vitals.bin

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

abstract class SpecialBrew : ItemIndentifier, Brew {

    abstract override val id: String
    abstract override var name: String
    abstract override val customModel: NamespacedKey
    abstract val cost: Double
    override val lore: List<String> = listOf()

    override fun get(n: Int): ItemStack {
        val i: ItemStack = ItemStack(Material.POTION)
        val im: ItemMeta = Bukkit.getItemFactory().getItemMeta(i.type)!!

        var lr: MutableList<String> = mutableListOf("--------------------", "", "", "id: $id")
        lr.addAll(2, lore)
        lr = lr.map { "§7$it" } as MutableList<String>

        im.apply {
            setDisplayName("§4✰ $name")
            itemModel = customModel
            lore = lr
            isUnbreakable = true
            addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
        }

        i.itemMeta = im
        return i
    }

    override fun give(p: Player, n: Int) {
        p.inventory.addItem(get(n))
    }

    open fun activate(p: Player) {
        return
    }

    open fun run(p: Player) {
        return
    }

}