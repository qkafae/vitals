package me.kafae.vitals.datastore

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import me.kafae.vitals.Main
import java.nio.file.Files
import java.nio.file.Path

class DataStore {

    private val gson: Gson = GsonBuilder().setPrettyPrinting().create()
    val dir: Path = Path.of("plugins/Vitals/data")

    data class PlayerData(
        var primary: String = "none",
        var passive: String = "none",
        var regen: Double = 1.0,
        var bonus: Double = 0.0,
        var hp: Double = 0.0,
        var cd: Int = 0
    )

    fun isThere(uid: String): Boolean {
        return dir.resolve("${uid}.json").toFile().exists()
    }

    fun new(uid: String) {
        Main.dataMap[uid] = PlayerData()
    }

    fun load(uid: String): PlayerData {
        val f = dir.resolve("${uid}.json").toFile()
        return if (f.exists()) {
            try {
                gson.fromJson(f.readText(), PlayerData::class.java)?: PlayerData()
            } catch (e: Exception) {
                PlayerData()
            }
        } else {
            PlayerData()
        }
    }

    fun loadAll(): Boolean {
        Files.list(dir).forEach { path ->
            if (path.toString().endsWith(".json")) {
                val uid = path.fileName.toString().removeSuffix(".json")
                val pd = load(uid)
                Main.dataMap[uid] = pd
            }
        }
        return true
    }

    fun save(uid: String): Boolean {
        val f = dir.resolve("${uid}.json").toFile()
        f.writeText(gson.toJson(Main.dataMap[uid]))
        Main.dataMap.remove(uid)
        return true
    }

    fun incrementalSave(uid: String): Boolean {
        val f = dir.resolve("${uid}.json").toFile()
        f.writeText(gson.toJson(Main.dataMap[uid]))
        return true
    }

    fun saveAll(): Boolean {
        Main.dataMap.forEach { (uid, pd) ->
            val f = dir.resolve("${uid}.json").toFile()
            f.writeText(gson.toJson(pd))
        }
        return true
    }
}