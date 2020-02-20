package org.emgen.extensions

import org.junit.jupiter.api.Test
import org.emgen.extensions.StringExtensions.remove
import org.emgen.extensions.StringExtensions.charIn
import org.junit.jupiter.api.Assertions.assertEquals

class StringExtensionsSpec {

    @Test
    fun `removes provided character or character sequence that exists in string`() {
        assertEquals("3-57", "3-5/7".remove("/"))
    }

    @Test
    fun `in case provided character or character sequence does not exists in string, returns input string`() {
        assertEquals("5+8", "5+8".remove("-"))
    }

    @Test
    fun `returns character in a string at provided index`() {
        assertEquals('7', "55-73^3".charIn(3))
    }

    @Test
    fun `returns null in case index does not exists in string`() {
        assertEquals(null, "6/3-5*7-8".charIn(15))
    }
}