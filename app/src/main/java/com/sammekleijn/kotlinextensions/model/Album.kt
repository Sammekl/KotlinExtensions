package com.sammekleijn.kotlinextensions.model

data class Album(val title: String, val songs: MutableList<Song> = mutableListOf())