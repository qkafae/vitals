package me.kafae.vitals.bin

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

abstract class CustomItem: ItemIndentifier {

    abstract override val id: String
    abstract override val name: String
    abstract override val customModel: NamespacedKey
    open val ench: Boolean = false
    override val lore: List<String> = listOf()

    override fun get(n: Int): ItemStack {
        val i: ItemStack = ItemStack(Material.PAPER, n)
        val im: ItemMeta = Bukkit.getItemFactory().getItemMeta(i.type)!!

        var lr: MutableList<String> = mutableListOf("--------------------", "", "", "id: $id")
        lr.addAll(2, lore)
        lr = lr.map { "§7$it" } as MutableList<String>

        im.apply {
            if (ench) {
                addEnchant(Enchantment.MENDING, 1, true)
            }
            setItemName(name)
            itemModel = customModel
            lore = lr
            isUnbreakable = true
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
        }

        i.itemMeta = im
        return i
    }

    override fun give(p: Player, n: Int) {
        p.inventory.addItem(get(n))
    }

}