package com.sammekleijn.serializabletohashmap.extension

import com.google.gson.Gson

fun Any.toJson() : String {
    return Gson().toJson(this)
}