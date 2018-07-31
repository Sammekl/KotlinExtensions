package com.sammekleijn.kotlinextensions.extension

import android.os.Bundle

fun Map<String, Any>.toStringBundle(): Bundle {
    val bundle = Bundle()
    for (entry in this.entries) {
        if (entry.value is String) {
            bundle.putString(entry.key, entry.value as? String)
        }
    }
    return bundle
}