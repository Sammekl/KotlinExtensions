package com.sammekleijn.serializabletohashmap.extension

import org.junit.Assert.assertEquals
import org.junit.Test

class MapExtTest {

    @Test
    fun toStringBundle() {
        val map = mapOf(
                "1" to 1,
                "2" to "2",
                "3" to true,
                "4" to "hallo")

        val bundle = map.toStringBundle()

        assertEquals(null, bundle["1"])
        assertEquals("2", bundle["2"])
        assertEquals(null, bundle["3"])
        assertEquals("hallo", bundle["4"])
    }
}