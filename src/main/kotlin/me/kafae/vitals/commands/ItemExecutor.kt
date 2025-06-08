package me.kafae.vitals.commands

import me.kafae.vitals.bin.correspondingItem
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class ItemExecutor: CommandExecutor, TabCompleter {

    override fun onCommand(s: CommandSender, c: Command, l: String, args: Array<out String>): Boolean {
        if (s !is Player) {
            return true
        }

        if (args.size >= 2) {
            val amt: Int = args[1].toIntOrNull() ?: 1
            try {
                correspondingItem[args[0]]!!.give(s, amt)
                return true
            } catch (e: Exception) {
                s.sendMessage("§4Invalid item id -> ${args[0]}")
                return true
            }
        }
        return false
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<String>): List<String> {
        return when (args.size) {
            1 -> {
                val lst: MutableList<String> = mutableListOf()
                for (k in correspondingItem.keys) {
                    lst.addLast(k)
                }
                return lst.toList()
            } else -> {
                emptyList()
            }
        }
    }

}