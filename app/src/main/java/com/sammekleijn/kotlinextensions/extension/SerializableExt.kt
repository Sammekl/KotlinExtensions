package com.sammekleijn.kotlinextensions.extension


import java.io.Serializable

inline fun <reified K, reified V> Serializable.toHashMap(): HashMap<K, V>? {

    val hashMap = this as? HashMap<*, *> ?: return null

    return if (hashMap.all { it.key is K && it.value is V }) {
        @Suppress("UNCHECKED_CAST")
        this as HashMap<K, V>
    } else null
}