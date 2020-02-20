package org.emgen

enum class Associativity {
    LEFT,
    RIGHT;

    fun isAssociative(operator: Operator): Boolean = operator.associativity == this
}
