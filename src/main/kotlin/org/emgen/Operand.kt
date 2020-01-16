package org.emgen

import java.math.BigDecimal

data class Operand(val value: BigDecimal) : Token {

    override fun toString(): String = value.toString()
}
