package com.androidevhispano.notekmm.android.note_list

import com.androidevhispano.notekmm.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchBoxActive: Boolean = false
)

