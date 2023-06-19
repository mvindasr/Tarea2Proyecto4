package com.cenfotec.notes.data.repositories

import com.cenfotec.notes.data.datasources.LocalNoteDataSource
import com.cenfotec.notes.data.mappers.NoteMapper.toNote
import com.cenfotec.notes.domain.models.NoteModel
import com.cenfotec.notes.domain.repositories.NoteRepository

class NoteRepositoryImpl(
    private val localNoteDataSource: LocalNoteDataSource
):NoteRepository {
    override fun getAllNotes(): List<NoteModel> {
        return localNoteDataSource.getAllNotes()
            .map { item -> item.toNote() }
    }

}