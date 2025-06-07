package me.kafae.vitals.thread

import me.kafae.vitals.Main
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

fun actionBar(plugin: JavaPlugin) {
    object : BukkitRunnable() {
        override fun run() {
            Bukkit.getOnlinePlayers().forEach { p: Player ->
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("§c${Main.dataMap[p.uniqueId.toString()]!!.regen}x ❣"))
            }
        }
    }.runTaskTimer(plugin, 0L, 20L)
}