package me.kafae.vitals.commands

import me.kafae.vitals.Main
import me.kafae.vitals.ui.BrewUI
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class BrewUIExecutor: CommandExecutor {

    override fun onCommand(s: CommandSender, c: Command, l: String, args: Array<out String>): Boolean {
        if (s !is Player) {
            return true
        }
        val p: Player = s
        if (p in Main.inCombat) {
            p.sendMessage("§4Interface disabled!")
            return true
        }
        BrewUI(p).open(p)
        return true
    }

}