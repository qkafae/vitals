package me.kafae.vitals.brews.passive

import me.kafae.vitals.bin.PassiveBrew
import org.bukkit.NamespacedKey

class RavenousBrew(isFirst: Boolean = false): PassiveBrew(isFirst) {

    override val id: String = "ravenous_brew"
    override var name: String = "§4ʀᴀᴠᴇɴᴏᴜs ʙʀᴇᴡ"
    override val customModel: NamespacedKey = NamespacedKey("vitals", "ravenous_brew")
    override val lore: List<String> = listOf(
        "§6ᴘᴀssɪᴠᴇ: §4ᴄᴏɴsᴜᴍᴇ",
        "Upon killing another",
        "player, the user will be",
        "granted a temporary +4HP",
        "and +0.1x bonus multiplier",
        "for 10 seconds"
    )

}