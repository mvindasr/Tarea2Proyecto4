package com.cenfotec.notes.data.datasources

import com.cenfotec.notes.data.models.LocalNote
import com.cenfotec.notes.data.models.LocalTag

object LocalNoteDataSource {

    private val notes = mutableListOf(
        LocalNote(
            id = 1,
            title = "Android Architecture",
            description = "Enseñar la estructura de una arquitectura para una aplicación",
            tag = LocalTag(
                id = 1,
                title = "Cenfotec",

            ),
            date = 1685668673
        ),
        LocalNote(
            id = 2,
            title = "Android Database",
            description = "Enseñar como montar una base de datos en Android",
            tag = LocalTag(
                id = 1,
                title = "Cenfotec",

                ),
            date = 1685668673
        ),
        LocalNote(
            id = 3,
            title = "Ordenar Cuarto",
            description = null,
            tag = LocalTag(
                id = 2,
                title = "Hogar",

                ),
            date = 1685668673
        ),
        LocalNote(
            id = 4,
            title = "Retrofit",
            description = "Enseñar como consumir servicios",
            tag = LocalTag(
                id = 1,
                title = "Cenfotec",

                ),
            date = 1685668673
        ),

    )

    fun getAllNotes(): List<LocalNote> = notes

    fun addNote(LocalNote: LocalNote) {
        notes.add(LocalNote)
    }

    fun deleteNote(id: Int) {
        val index = notes.removeIf { note -> note.id == id }
    }

    fun updateNote(note: LocalNote) {
        val index = notes.indexOfFirst { item -> item.id == note.id }
        notes[index] = note
    }
}