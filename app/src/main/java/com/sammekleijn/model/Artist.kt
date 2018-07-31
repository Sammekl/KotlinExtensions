package com.sammekleijn.model

data class Artist(val name: String, val albums: MutableList<Album> = mutableListOf())