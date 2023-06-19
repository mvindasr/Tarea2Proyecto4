package com.cenfotec.notes.domain.repositories

import com.cenfotec.notes.domain.models.NoteModel

interface NoteRepository {
    fun getAllNotes(): List<NoteModel>
}