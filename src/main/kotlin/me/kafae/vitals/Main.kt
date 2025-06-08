package me.kafae.vitals

import me.kafae.vitals.commands.BrewUIExecutor
import me.kafae.vitals.commands.ItemExecutor
import me.kafae.vitals.datastore.DataStore
import me.kafae.vitals.datastore.DataStore.PlayerData
import me.kafae.vitals.events.EntityDamage
import me.kafae.vitals.events.EntityRegainHealth
import me.kafae.vitals.events.ItemDespawn
import me.kafae.vitals.events.ItemSpawn
import me.kafae.vitals.events.PlayerConsume
import me.kafae.vitals.events.PlayerDeath
import me.kafae.vitals.events.PlayerJoin
import me.kafae.vitals.events.PlayerLeave
import me.kafae.vitals.items.LifeElixir
import me.kafae.vitals.threads.actionBar
import me.kafae.vitals.ui.BrewUI
import me.kafae.vitals.ui.BrewLibraryUI
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.nio.file.Files
import java.util.logging.Logger

class Main : JavaPlugin() {

    private val ds: DataStore = DataStore()

    companion object {
        lateinit var plugin: JavaPlugin
        val dataMap: MutableMap<String, PlayerData> = mutableMapOf()
        val inCombat: MutableList<Player> = mutableListOf<Player>()
        lateinit var log: Logger
    }

    override fun onEnable() {
        log = this.logger
        plugin = this

        // creating necessary dirs
        Files.createDirectories(ds.dir)

        // listener events
        server.pluginManager.registerEvents(PlayerJoin(), this)
        server.pluginManager.registerEvents(PlayerLeave(), this)
        server.pluginManager.registerEvents(PlayerConsume(), this)
        server.pluginManager.registerEvents(PlayerDeath(), this)
        server.pluginManager.registerEvents(EntityRegainHealth(), this)
        server.pluginManager.registerEvents(EntityDamage(), this)
        server.pluginManager.registerEvents(BrewUI(null), this)
        server.pluginManager.registerEvents(BrewLibraryUI(null), this)
        server.pluginManager.registerEvents(LifeElixir(), this)
        server.pluginManager.registerEvents(ItemSpawn(), this)
        server.pluginManager.registerEvents(ItemDespawn(), this)

        // commands
        this.getCommand("brew")?.setExecutor(BrewUIExecutor())
        this.getCommand("item")?.apply {
            setExecutor(ItemExecutor())
            tabCompleter = ItemExecutor()
        }

        // run task threads
        actionBar(this)

        logger.info("wsg chat")
    }

    override fun onDisable() {
        ds.saveAll() // failsafe
    }
}
