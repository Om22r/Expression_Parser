package org.emgen.extensions

object LongExtensions {

    fun Long.factorial(): Long {
        if (this < 0) {
            throw Exception("")
        }
        if (this == 0L) {
            return 1L
        }
        var res = 1L
        (1L..this).forEach { res *= it }
        return res
    }
}
