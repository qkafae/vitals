package me.kafae.vitals.items

import me.kafae.vitals.Main
import me.kafae.vitals.bin.CustomItem
import me.kafae.vitals.bin.isSame
import me.kafae.vitals.bin.toFixed
import me.kafae.vitals.bin.update
import org.bukkit.NamespacedKey
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

class LifeElixir: CustomItem(), Listener {

    override val id: String = "life_elixir"
    override val name: String = "§cʟɪғᴇ ᴇʟɪxɪʀ §4❤"
    override val customModel: NamespacedKey = NamespacedKey("vitals", "life_elixir")
    override val ench: Boolean = true
    override val lore: List<String> = listOf("§6ʀɪɢʜᴛ ᴄʟɪᴄᴋ", "Gain §c+0.1x ❣")

    @EventHandler(priority = EventPriority.NORMAL)
    private fun onPlayerInteract(e: PlayerInteractEvent) {
        val i: ItemStack = e.item ?: return
        if (e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK)
        if (i.isSame(this)) {
            if (Main.dataMap[e.player.uniqueId.toString()]!!.regen >= 1.5) {
                e.player.sendMessage("§4Unable to consume this, you have the max multiplier already!")
            } else {
                if (i.amount > 1) {
                    i.amount--
                } else {
                    e.player.inventory.remove(i)
                }
                Main.dataMap[e.player.uniqueId.toString()]!!.regen += 0.1
                Main.dataMap[e.player.uniqueId.toString()]!!.regen = Main.dataMap[e.player.uniqueId.toString()]!!.regen.toFixed(1)
                e.player.world.strikeLightningEffect(e.player.location)
                e.player.playSound(e.player.location, Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1f, 0.5f)
                e.player.playSound(e.player.location, Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 2f, 0.8f)
                e.player.sendMessage("§aConsumed a ${name}§a! You are now at §c${Main.dataMap[e.player.uniqueId.toString()]!!.regen}x ❣")
                update(e.player)
            }
        }
    }

}