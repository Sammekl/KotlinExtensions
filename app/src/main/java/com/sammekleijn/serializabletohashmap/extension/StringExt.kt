package com.sammekleijn.serializabletohashmap.extension

import com.google.gson.Gson
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

@Throws(NoSuchAlgorithmException::class)
fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun <T> String.fromJson(ofType: Class<T>): T {
    return Gson().fromJson(this, ofType)
}