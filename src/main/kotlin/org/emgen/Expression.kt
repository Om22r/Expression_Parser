package org.emgen

import java.math.BigDecimal
import java.util.*

data class Expression(val tokens: List<Token>) {

    fun evaluate(): BigDecimal {
        val stack = Stack<Operand>()

        tokens.forEach {
            if (it !is Operator) {
                stack.push(it as Operand)
            } else {
                val inputY = stack.pop()

                if (it.unary) {
                    stack.push(it.evaluate(inputY))
                } else {
                    val inputX = stack.pop()
                    stack.push(it.evaluate(inputX, inputY))
                }
            }
        }

        return if (stack.empty()) BigDecimal.ZERO else stack.pop().value
    }
}