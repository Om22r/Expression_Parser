package org.emgen.extensions

object StringExtensions {

    fun String.remove(characterSequence: String): String = this.replace(characterSequence, "")

    fun String.charIn(index: Int): Char? =
        if (index in 0..this.lastIndex) {
            this[index]
        } else {
            null
        }
}
