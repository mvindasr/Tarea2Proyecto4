package com.cenfotec.notes.ui.notes.viewmodels

import androidx.lifecycle.ViewModel
import com.cenfotec.notes.data.datasources.LocalNoteDataSource
import com.cenfotec.notes.data.repositories.NoteRepositoryImpl
import com.cenfotec.notes.domain.models.NoteModel
import com.cenfotec.notes.domain.models.TagModel
import com.cenfotec.notes.domain.repositories.NoteRepository
import com.cenfotec.notes.domain.usecases.AddNoteUseCase
import java.util.Calendar


class AddNoteViewModel : ViewModel() {

    private val dataSource = LocalNoteDataSource
    private val repository: NoteRepository = NoteRepositoryImpl(dataSource)
    private val addNoteUseCase = AddNoteUseCase(repository)

    fun addNote(title: String, description: String, tag: String) {

        val noteTag : TagModel = when (tag) {
            "Cenfotec" -> {
                TagModel(1, tag)
            }
            "Hogar", "Home" -> {
                TagModel(2, tag)
            }
            "Trabajo", "Work" -> {
                TagModel(3, tag)
            }
            else -> {
                TagModel(4, "General")
            }
        }

        val note = NoteModel(addNoteUseCase.getIndex(), title, description, noteTag, getCurrentDay())
        addNoteUseCase.execute(note)
    }

    private fun getCurrentDay(): Int {
        val calendar = Calendar.getInstance()
        val day = calendar.timeInMillis.toString().substring(0,10)
        return day.toInt()
    }



}