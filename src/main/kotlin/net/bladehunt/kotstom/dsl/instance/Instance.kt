package net.bladehunt.kotstom.dsl.instance

import net.bladehunt.kotstom.DimensionTypeRegistry
import net.bladehunt.kotstom.InstanceManager
import net.kyori.adventure.key.Key
import net.minestom.server.instance.InstanceContainer
import net.minestom.server.instance.generator.GenerationUnit
import net.minestom.server.instance.generator.UnitModifier
import net.minestom.server.registry.DynamicRegistry
import net.minestom.server.registry.RegistryKey
import net.minestom.server.world.DimensionType
import java.util.*

@DslMarker
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.PROPERTY)
annotation class InstanceDsl

inline var InstanceContainer.chunkAutoLoad: Boolean
    get() = hasEnabledAutoChunkLoad()
    set(value) = enableAutoChunkLoad(value)

inline fun GenerationUnit.modify(block: UnitModifier.() -> Unit) {
    this.modifier().apply(block)
}

inline fun InstanceContainer.generator(crossinline block: GenerationUnit.() -> Unit) =
    setGenerator {
        block(it)
    }

@InstanceDsl
inline fun buildInstance(
    dimensionTypeRegistry: DynamicRegistry<DimensionType> = DimensionTypeRegistry,
    dimensionType: RegistryKey<DimensionType> = DimensionType.OVERWORLD,
    dimensionName: Key = dimensionType.key(),
    register: Boolean = true,
    block: InstanceContainer.() -> Unit,
): InstanceContainer =
    InstanceContainer(dimensionTypeRegistry, UUID.randomUUID(), dimensionType, null, dimensionName)
        .apply {
            block()
            if (register) InstanceManager.registerInstance(this)
        }
