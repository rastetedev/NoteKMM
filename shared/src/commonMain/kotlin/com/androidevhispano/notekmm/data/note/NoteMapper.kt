package com.androidevhispano.notekmm.data.note

import com.androidevhispano.notekmm.database.NoteEntity
import com.androidevhispano.notekmm.domain.note.Note
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        content = content,
        colorHex = colorHex,
        created = Instant
            .fromEpochMilliseconds(created)
            .toLocalDateTime(
                TimeZone.currentSystemDefault()
            )
    )
}