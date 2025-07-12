package net.bladehunt.kotstom.example.serialization

import kotlinx.serialization.Serializable
import net.bladehunt.kotstom.serialization.adventure.AdventureNbt
import net.kyori.adventure.nbt.CompoundBinaryTag
import net.kyori.adventure.nbt.TagStringIO

@Serializable
data class InnerExample(
    val name: String,
    val address: String,
    val age: Int,
)

@Serializable
data class Test(
    val string: String,
    val int: Int,
    val short: Short,
    val long: Long,
    val inner: InnerExample,
    val innertwo: InnerExample,
    val boolean: Boolean,
)

fun main() {
    val valueToSerialize =
        Test(
            "test",
            1,
            2,
            3,
            InnerExample("hello world", "the earth", 64),
            InnerExample("hello earth", "the world", 46),
            true,
        )

    val valueAsCompound: CompoundBinaryTag = AdventureNbt.encodeToCompound(valueToSerialize)

    println(TagStringIO.tagStringIO().asString(valueAsCompound))

    val decodedValue = AdventureNbt.decodeFromCompound<Test>(valueAsCompound)

    println("Is the value the same? ${valueToSerialize == decodedValue}")
}
