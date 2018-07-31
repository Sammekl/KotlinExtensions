package com.sammekleijn.model

data class Album(val title: String, val songs: MutableList<Song> = mutableListOf())