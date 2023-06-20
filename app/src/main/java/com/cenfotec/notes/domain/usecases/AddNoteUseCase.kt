package com.cenfotec.notes.domain.usecases

import com.cenfotec.notes.domain.models.NoteModel
import com.cenfotec.notes.domain.repositories.NoteRepository

class AddNoteUseCase (
    private val noteRepository: NoteRepository
    ) {

        fun execute(note:NoteModel) = noteRepository.addNote(note)
        fun getIndex():Int = noteRepository.getAllNotes().size + 1
}