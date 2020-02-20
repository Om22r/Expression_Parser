package org.emgen

import java.math.BigDecimal
import java.util.*
import kotlin.collections.ArrayList
import org.emgen.extensions.StringExtensions.charIn
import org.emgen.extensions.StringExtensions.remove
import org.emgen.extensions.CharExtensions.operator
import org.emgen.extensions.CharExtensions.toOperator

class ExpressionParser {

    companion object {
        fun parseExpression(expression: String): Expression {
            val output = ArrayList<Token>()
            val stack = Stack<Operator>()

            for (token in createTokens(expression.remove(" "))) {
                if (token is Operator) {
                    if (token == Operator.LEFT_PARENTHESIS) {
                        stack.push(token)
                    } else if (token == Operator.RIGHT_PARENTHESIS) {
                        for (index in stack.indices) {
                            if (stack.empty() || stack.peek() == Operator.LEFT_PARENTHESIS) {
                                break
                            }
                            output.add(stack.pop())
                        }
                        stack.pop()
                    } else {
                        for (index in stack.indices) {
                            if (
                                stack.empty() ||
                                stack.peek() == Operator.LEFT_PARENTHESIS ||
                                stack.peek() == Operator.RIGHT_PARENTHESIS
                            ) {
                                break
                            }
                            val precedence = token.precedence - stack.peek().precedence
                            if (
                                (Associativity.LEFT.isAssociative(token) && precedence < 1) ||
                                (Associativity.RIGHT.isAssociative(token) && precedence < 0)
                            ) {
                                output.add(stack.pop())
                            }
                        }
                        stack.push(token)
                    }
                } else {
                    output.add(token)
                }
            }
            repeat(stack.size) { output.add(stack.pop()) }
            return Expression(output)
        }

        private fun createTokens(expression: String): List<Token> = expression
            .toCharArray()
            .mapIndexed { index, char ->
                if (char.operator() && !isUnarySign(index, expression)) {
                    " $char "
                } else {
                    char.toString()
                }
            }
            .joinToString("")
            .replace(Regex("\\s+"), " ")
            .trim()
            .split(" ")
            .map {
                if (it.length == 1 && it[0].operator()) {
                    it[0].toOperator()
                } else {
                    Operand(BigDecimal(it))
                }
            }

        private fun isUnarySign(index: Int, expression: String): Boolean =
            expression.charIn(index) == '-' && !numeric(expression.charIn(index - 1)) && numeric(expression.charIn(index + 1))

        private fun numeric(char: Char?): Boolean = char != null && char in '0'..'9'
    }
}
