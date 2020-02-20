package org.emgen

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AssociativitySpec {

    @Test
    fun `returns true in case operator contains LEFT associativity`() {
        assertTrue { Associativity.LEFT.isAssociative(Operator.SUM) }
        assertTrue { Associativity.LEFT.isAssociative(Operator.SUBTRACTION) }
        assertTrue { Associativity.LEFT.isAssociative(Operator.DIVISION) }
        assertTrue { Associativity.LEFT.isAssociative(Operator.MULTIPLICATION) }
        assertTrue { Associativity.LEFT.isAssociative(Operator.FACTORIAL) }
        assertTrue { Associativity.LEFT.isAssociative(Operator.LEFT_PARENTHESIS) }
        assertTrue { Associativity.LEFT.isAssociative(Operator.RIGHT_PARENTHESIS) }
    }

    @Test
    fun `returns false in case operator does not contain LEFT associativity`() {
        assertFalse { Associativity.LEFT.isAssociative(Operator.EXPONENTIATION) }
    }

    @Test
    fun `returns true in case operator contains RIGHT associativity`() {
        assertTrue { Associativity.RIGHT.isAssociative(Operator.EXPONENTIATION) }
    }

    @Test
    fun `returns false in case operator does not contain RIGHT associativity`() {
        assertFalse { Associativity.LEFT.isAssociative(Operator.SUM) }
        assertFalse { Associativity.LEFT.isAssociative(Operator.SUBTRACTION) }
        assertFalse { Associativity.LEFT.isAssociative(Operator.DIVISION) }
        assertFalse { Associativity.LEFT.isAssociative(Operator.MULTIPLICATION) }
        assertFalse { Associativity.LEFT.isAssociative(Operator.FACTORIAL) }
        assertFalse { Associativity.LEFT.isAssociative(Operator.LEFT_PARENTHESIS) }
        assertFalse { Associativity.LEFT.isAssociative(Operator.RIGHT_PARENTHESIS) }
    }
}