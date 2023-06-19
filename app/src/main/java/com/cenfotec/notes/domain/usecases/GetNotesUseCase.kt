package com.cenfotec.notes.domain.usecases

import com.cenfotec.notes.domain.models.NoteModel
import com.cenfotec.notes.domain.repositories.NoteRepository

class GetNotesUseCase (
    private val noteRepository: NoteRepository
        ) {

    fun execute():List<NoteModel> = noteRepository.getAllNotes()
}