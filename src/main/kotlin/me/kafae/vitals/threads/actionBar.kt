package me.kafae.vitals.threads

import me.kafae.vitals.Main
import me.kafae.vitals.bin.toFixed
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
                if (Main.dataMap[p.uniqueId.toString()]!!.bonus > 0.0) {
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("§l§c${(Main.dataMap[p.uniqueId.toString()]!!.regen + Main.dataMap[p.uniqueId.toString()]!!.bonus).toFixed(1)}§c§4(+${(Main.dataMap[p.uniqueId.toString()]!!.bonus).toFixed(1)})§cx ❣"))
                } else {
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("§l§c${(Main.dataMap[p.uniqueId.toString()]!!.regen).toFixed(1)}x ❣"))
                }
            }
        }
    }.runTaskTimer(plugin, 0L, 20L)
}