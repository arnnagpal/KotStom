package net.bladehunt.kotstom.serialization.namespace

import net.kyori.adventure.key.Key
import net.minestom.server.item.Material
import net.minestom.server.registry.StaticProtocolObject

object MaterialSerializer : AbstractProtocolObjectSerializer<Material>(Material::class) {
    override fun fromKey(key: Key): StaticProtocolObject<Material>? = Material.fromKey(key)
}
