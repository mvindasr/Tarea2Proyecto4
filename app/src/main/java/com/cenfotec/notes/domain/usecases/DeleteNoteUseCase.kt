package com.cenfotec.notes.domain.usecases

import com.cenfotec.notes.domain.repositories.NoteRepository

class DeleteNoteUseCase (
    private val noteRepository: NoteRepository
    ) {
        fun execute(id: Int) = noteRepository.deleteNote(id)
}