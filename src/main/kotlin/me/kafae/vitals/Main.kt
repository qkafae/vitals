package me.kafae.vitals

import me.kafae.vitals.datastore.DataStore
import me.kafae.vitals.datastore.DataStore.PlayerData
import me.kafae.vitals.events.PlayerJoin
import me.kafae.vitals.events.PlayerLeave
import org.bukkit.plugin.java.JavaPlugin
import java.nio.file.Files
import java.util.logging.Logger

class Main : JavaPlugin() {

    private val ds: DataStore = DataStore()

    companion object {
        val dataMap: MutableMap<String, PlayerData> = mutableMapOf()
        lateinit var log: Logger
    }

    override fun onEnable() {
        log = this.logger

        // creating necessary dirs
        Files.createDirectories(ds.dir)

        // listener events
        server.pluginManager.registerEvents(PlayerJoin(), this)
        server.pluginManager.registerEvents(PlayerLeave(), this)

        logger.info("wsg chat")
    }

    override fun onDisable() {
        ds.saveAll()
    }
}
