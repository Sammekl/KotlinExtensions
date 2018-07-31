package com.sammekleijn.serializabletohashmap.extension


import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class SerializableExtKtTest {

    @Test
    fun serializableIsHashMap() {
        val expected = hashMapOf(
                "1" to 1,
                "2" to "2",
                "3" to true,
                "4" to 4.4)

        val actual = expected.toHashMap<String, Any>()

        assertEquals(expected, actual)
    }

    @Test
    fun serializableIsNotHashMap() {
        val notAHashMap = "I am definitely not a hashmap"

        val actual = notAHashMap.toHashMap<String, Any>()

        assertNull(actual)
    }

    @Test
    fun serializableIsOfDifferentType() {
        val intHashMap = hashMapOf(
                1 to 1,
                2 to "2",
                3 to true,
                4 to 4.4)

        val actual = intHashMap.toHashMap<String, Any>()

        assertNull(actual)
    }

    @Test
    fun serializableHasTypedValues() {
        val expected = hashMapOf(
                "1" to -1.29921,
                "2" to 2.28725781,
                "3" to 3.3,
                "4" to 4.4)

        val actual = expected.toHashMap<String, Double>()

        assertEquals(expected, actual)
    }

    @Test
    fun serializableHasTypedValuesExceptOne() {
        val almostDoubleHashMap = hashMapOf(
                "1" to -1.29921,
                "2" to 2.28725781,
                "3" to 3.3,
                "4" to "Oops I am not a double")

        val actual = almostDoubleHashMap.toHashMap<String, Double>()

        assertNull(actual)

        val anyActual = almostDoubleHashMap.toHashMap<String, Any>()

        assertEquals(almostDoubleHashMap, anyActual)
    }

}