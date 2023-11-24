package com.androidevhispano.notekmm.data.note

import com.androidevhispano.notekmm.database.NoteDatabase
import com.androidevhispano.notekmm.domain.note.Note
import com.androidevhispano.notekmm.domain.note.NoteDataSource
import com.androidevhispano.notekmm.domain.time.DateTimeUtil

class SqlDelightNoteDataSource(database: NoteDatabase) : NoteDataSource {

    private val queries = database.noteQueries
    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            created = DateTimeUtil.toEpochMillis(note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries
            .getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries
            .getAllNotes()
            .executeAsList()
            .map { noteEntity ->
                noteEntity.toNote()
            }
    }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNoteById(id)
    }
}