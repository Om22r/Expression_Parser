package org.emgen.extensions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.emgen.extensions.LongExtensions.factorial

class LongExtensionsSpec {

    @Test
    fun `calculates factorial for non - negative integers`() {
        assertEquals(120, 5L.factorial())
        assertEquals(1, 0L.factorial())
    }

    @Test
    fun `throws Exception in case trying to calculate factorial for negative integers`() {
        assertThrows(Exception::class.java) { (-3L).factorial() }
    }
}