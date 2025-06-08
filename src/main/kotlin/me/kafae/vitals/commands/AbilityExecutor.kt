package me.kafae.vitals.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class AbilityExecutor: CommandExecutor {

    override fun onCommand(s: CommandSender, c: Command, l: String, args: Array<out String>): Boolean {
        if (s !is Player) {
            return true
        }
        return false
    }

}