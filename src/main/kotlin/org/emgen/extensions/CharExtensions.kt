package org.emgen.extensions

import org.emgen.Operator

object CharExtensions {

    fun Char.operator(): Boolean = this in Operator.values().map { it.value }

    fun Char.toOperator(): Operator =
        if (this.operator()) {
            Operator.values().find { it.value == this }!!
        } else {
            throw RuntimeException("")
        }
}
