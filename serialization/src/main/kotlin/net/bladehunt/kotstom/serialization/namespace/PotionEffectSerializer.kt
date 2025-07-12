package net.bladehunt.kotstom.serialization.namespace

import net.kyori.adventure.key.Key
import net.minestom.server.potion.PotionEffect
import net.minestom.server.registry.StaticProtocolObject

object PotionEffectSerializer :
    AbstractProtocolObjectSerializer<PotionEffect>(PotionEffect::class) {
    override fun fromKey(key: Key): StaticProtocolObject<PotionEffect>? = PotionEffect.fromKey(key)
}
