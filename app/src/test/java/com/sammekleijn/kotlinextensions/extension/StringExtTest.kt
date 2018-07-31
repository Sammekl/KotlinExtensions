package com.sammekleijn.kotlinextensions.extension

import com.sammekleijn.kotlinextensions.model.Album
import com.sammekleijn.kotlinextensions.model.Artist
import com.sammekleijn.kotlinextensions.model.Song
import junit.framework.Assert.*
import org.junit.Test

class StringExtTest {

    @Test
    fun serializesFromJson() {
        val json = "{\"name\":\"Red Hot Chili Peppers\",\"albums\":[{\"title\":\"Blood Sugar Seks Magik\",\"songs\":[{\"title\":\"The Power of Equality\",\"duration\":4.04},{\"title\":\"If You Have To Ask\",\"duration\":3.37}]}]}"

        val result = json.fromJson(Artist::class.java)

        assertEquals("Red Hot Chili Peppers", result.name)
        assertEquals(1, result.albums.size)
        assertEquals(2, result.albums[0].songs.size)
        assertEquals(3.37, result.albums[0].songs[1].duration)
    }

    @Test
    fun serializesToJson() {
        val artist = Artist("Red Hot Chili Peppers",
                mutableListOf(Album("Mothers Milk",
                        mutableListOf(Song("Good Time Boys", 5.02), Song("Higher Ground", 3.22)))))

        val expected = "{\"name\":\"Red Hot Chili Peppers\",\"albums\":[{\"title\":\"Mothers Milk\",\"songs\":[{\"title\":\"Good Time Boys\",\"duration\":5.02},{\"title\":\"Higher Ground\",\"duration\":3.22}]}]}"

        val actual = artist.toJson()

        assertEquals(expected, actual)
    }

    @Test
    fun calculatesMd5Checksum() {
        val input = "I know that MD5 is not a secure hash..."

        val result = input.md5()

        assertEquals("edfef51c56e2a36d3d4c646f5bbc4b34", result)
    }
}