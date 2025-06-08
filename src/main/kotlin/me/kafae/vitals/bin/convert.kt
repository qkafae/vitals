package me.kafae.vitals.bin

import me.kafae.vitals.brews.passive.RavenousBrew
import me.kafae.vitals.brews.primary.RageBrew
import me.kafae.vitals.items.LifeElixir
import org.bukkit.NamespacedKey

// id to item/brew
val correspondingItem: HashMap<String, ItemIndentifier> = hashMapOf(
    LifeElixir().id to LifeElixir(),
    RageBrew().id to RageBrew(),
    "first_" + RageBrew().id to RageBrew(true),
    RavenousBrew().id to RavenousBrew(),
    "first_" + RavenousBrew().id to RavenousBrew(true),
)

// model to all brew
val correspondingModelToBrew: HashMap<NamespacedKey, Brew> = hashMapOf(
    RageBrew().customModel to RageBrew(),
    RavenousBrew().customModel to RavenousBrew()
)

// model to first brew
val correspondingFirstBrew: HashMap<NamespacedKey, Brew> = hashMapOf(
    RageBrew().customModel to RageBrew(true),
    RavenousBrew().customModel to RavenousBrew()
)

// id to all brew
val correspondingBrew: HashMap<String, Brew> = hashMapOf(
    RageBrew().id to RageBrew(),
    "first_" + RageBrew().id to RageBrew(true),
    RavenousBrew().id to RavenousBrew(),
    "first_" + RavenousBrew().id to RavenousBrew(true),
)