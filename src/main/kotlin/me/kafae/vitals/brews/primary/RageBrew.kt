package me.kafae.vitals.brews.primary

import me.kafae.vitals.bin.PrimaryBrew
import org.bukkit.NamespacedKey

class RageBrew(isFirst: Boolean = false): PrimaryBrew(isFirst) {

    override val id: String = "rage_brew"
    override var name: String = "§cʀᴀɢᴇ ʙʀᴇᴡ"
    override val customModel: NamespacedKey = NamespacedKey("vitals", "rage_brew")
    override val cost: Double = 10.0
    override val lore: List<String> = listOf(
        "§6ᴀʙɪʟɪᴛʏ: §cʀᴀɢᴇ sʟᴀᴍ",
        "Slam the floor with a",
        "blood bullet. Damaing all",
        "entities in a 5 block",
        "radius for 8HP")

}