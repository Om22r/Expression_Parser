package org.emgen

import java.math.MathContext
import org.emgen.extensions.LongExtensions.factorial

enum class Operator(
    val value: Char,
    val precedence: Int,
    val associativity: Associativity = Associativity.LEFT,
    val unary: Boolean = false
) : Token {
    SUM('+', 0),
    SUBTRACTION('-', 0),
    MULTIPLICATION('*', 3),
    DIVISION('/', 3),
    EXPONENTIATION('^', 6, Associativity.RIGHT),
    FACTORIAL('!', 9, unary = true),
    LEFT_PARENTHESIS('(', 15),
    RIGHT_PARENTHESIS(')', 15);

    override fun toString(): String = value.toString()

    fun evaluate(vararg operands: Operand): Operand {
        val operandsCount = operands.size

        if (operandsCount == 1 && unary) {
            val input = operands[0].value

            if (this == FACTORIAL) {
                return Operand(input.toLong().factorial().toBigDecimal())
            }
        }

        if (operandsCount > 1 && !unary) {
            val inputX = operands[0].value
            val inputY = operands[1].value

            if (this == SUM) {
                return Operand(inputX + inputY)
            }
            if (this == SUBTRACTION) {
                return Operand(inputX - inputY)
            }
            if (this == MULTIPLICATION) {
                return Operand(inputX * inputY)
            }
            if (this == DIVISION) {
                if (inputX.signum() == 0) {
                    throw RuntimeException("")
                }
                if (inputY.signum() == 0) {
                    throw RuntimeException("")
                }
                return Operand(inputX / inputY)
            }
            if (this == EXPONENTIATION) {
                return Operand(inputX.pow(inputY.toInt(), MathContext.DECIMAL128))
            }
        }

        throw RuntimeException("")
    }
}
