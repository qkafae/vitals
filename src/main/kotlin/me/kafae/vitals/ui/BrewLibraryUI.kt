package me.kafae.vitals.ui

import me.kafae.vitals.bin.Gui
import me.kafae.vitals.brews.passive.RavenousBrew
import me.kafae.vitals.brews.primary.RageBrew
import me.kafae.vitals.icons.BackgroundIcon
import me.kafae.vitals.icons.BrewIcon
import me.kafae.vitals.icons.PrimaryBrewIcon
import me.kafae.vitals.icons.PassiveBrewIcon
import me.kafae.vitals.icons.SpecialBrewIcon
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack
import kotlin.collections.set

class BrewLibraryUI(val p: Player?): Gui(), Listener {

    override val owner: InventoryHolder? = p
    override val slots: Int? = p?.let { 45 }
    override val title: String = "§e§kE §6Brew Library §e§kE"

    override val items: HashMap<Int, ItemStack> = hashMapOf<Int, ItemStack>().apply {
        p?.let {
            for (i in 0..44) {
                if (i !in arrayOf<Int>(10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34)) {
                    this[i] = BackgroundIcon().get()
                }
            }

            this[36] = BrewIcon().get()
            this[10] = PrimaryBrewIcon().get()
            this[11] = RageBrew(false).get(1)
            this[19] = PassiveBrewIcon().get()
            this[20] = RavenousBrew(false).get(1)
            this[28] = SpecialBrewIcon().get()
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    private fun onInventoryClick(e: InventoryClickEvent) {
        if (e.view.title == title) {
            when (e.slot) {
                36 -> {
                    BrewUI(e.whoClicked as Player).open(e.whoClicked as Player)
                }
            }
            e.isCancelled = true
        }
    }
}