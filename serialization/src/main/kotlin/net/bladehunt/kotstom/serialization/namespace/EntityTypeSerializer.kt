package net.bladehunt.kotstom.serialization.namespace

import net.kyori.adventure.key.Key
import net.minestom.server.entity.EntityType
import net.minestom.server.registry.StaticProtocolObject

object EntityTypeSerializer : AbstractProtocolObjectSerializer<EntityType>(EntityType::class) {
    override fun fromKey(key: Key): StaticProtocolObject<EntityType>? = EntityType.fromKey(key)
}
