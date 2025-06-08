package me.kafae.vitals.ui

import me.kafae.vitals.Main
import me.kafae.vitals.bin.Gui
import me.kafae.vitals.bin.correspondingBrew
import me.kafae.vitals.icons.BackgroundIcon
import me.kafae.vitals.icons.BrewLibraryIcon
import me.kafae.vitals.icons.PrimaryBrewIcon
import me.kafae.vitals.icons.PassiveBrewIcon
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

class BrewUI(val p: Player?): Gui(), Listener {

    override val owner: InventoryHolder? = p
    override val slots: Int? = p?.let { 36 }
    override val title: String = "§5§kE §dBrews §5§kE"

    override val items: HashMap<Int, ItemStack> = hashMapOf<Int, ItemStack>().apply {
        p?.let {
            for (i in 0..35) {
                if (i !in arrayOf<Int>(12, 14, 21, 23, 35)) {
                    this[i] = BackgroundIcon().get()
                }
            }

            this[35] = BrewLibraryIcon().get()
            this[21] = PrimaryBrewIcon().get()
            this[23] = PassiveBrewIcon().get()
            if (Main.dataMap[p.uniqueId.toString()]!!.primary != "none") {
                this[12] = correspondingBrew[Main.dataMap[p.uniqueId.toString()]!!.primary]!!.get(1)
            }
            if (Main.dataMap[p.uniqueId.toString()]!!.passive != "none") {
                this[14] = correspondingBrew[Main.dataMap[p.uniqueId.toString()]!!.passive]!!.get(1)
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    private fun onInventoryClick(e: InventoryClickEvent) {
        if (e.view.title == title) {
            when (e.slot) {
                35 -> {
                    BrewLibraryUI(e.whoClicked as Player).open(e.whoClicked as Player)
                }
            }
            e.isCancelled = true
        }
    }
}