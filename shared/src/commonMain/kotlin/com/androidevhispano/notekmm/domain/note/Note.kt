package com.androidevhispano.notekmm.domain.note

import com.androidevhispano.notekmm.domain.BabyBlueHex
import com.androidevhispano.notekmm.domain.LightGreenHex
import com.androidevhispano.notekmm.domain.RedOrangeHex
import com.androidevhispano.notekmm.domain.RedPinkHex
import com.androidevhispano.notekmm.domain.VioletHex
import kotlinx.datetime.LocalDateTime

data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime
) {

    companion object {
        private val colors = listOf(RedOrangeHex, RedPinkHex, LightGreenHex, BabyBlueHex, VioletHex)
        fun generateRandomColor() = colors.random()
    }

}


