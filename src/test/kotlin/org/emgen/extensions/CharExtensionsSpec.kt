package org.emgen.extensions

import org.emgen.Operator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.emgen.extensions.CharExtensions.operator
import org.emgen.extensions.CharExtensions.toOperator

class CharExtensionsSpec {

    @Test
    fun `returns true in case character represents an operator`() {
        assertTrue { '+'.operator() }
        assertTrue { '-'.operator() }
        assertTrue { '*'.operator() }
        assertTrue { '/'.operator() }
        assertTrue { '^'.operator() }
        assertTrue { '!'.operator() }
        assertTrue { '('.operator() }
        assertTrue { ')'.operator() }
    }

    @Test
    fun `returns false in case character does not represent an operator`() {
        assertFalse { '5'.operator() }
    }

    @Test
    fun `creates an operator in case character represents an operator`() {
        assertEquals(Operator.SUM, '+'.toOperator())
        assertEquals(Operator.SUBTRACTION, '-'.toOperator())
        assertEquals(Operator.MULTIPLICATION, '*'.toOperator())
        assertEquals(Operator.DIVISION, '/'.toOperator())
        assertEquals(Operator.EXPONENTIATION, '^'.toOperator())
        assertEquals(Operator.FACTORIAL, '!'.toOperator())
        assertEquals(Operator.LEFT_PARENTHESIS, '('.toOperator())
        assertEquals(Operator.RIGHT_PARENTHESIS, ')'.toOperator())
    }

    @Test
    fun `throws Exception in case character does not represent an operator`() {
        assertThrows(Exception::class.java) { '5'.toOperator() }
    }
}