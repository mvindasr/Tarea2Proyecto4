package com.cenfotec.notes.ui.notes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cenfotec.notes.data.datasources.LocalNoteDataSource
import com.cenfotec.notes.data.repositories.NoteRepositoryImpl
import com.cenfotec.notes.domain.models.NoteModel
import com.cenfotec.notes.domain.repositories.NoteRepository
import com.cenfotec.notes.domain.usecases.DeleteNoteUseCase
import com.cenfotec.notes.domain.usecases.GetNotesUseCase

class NoteListViewModel : ViewModel() {

    private val dataSource = LocalNoteDataSource
    private val repository:NoteRepository = NoteRepositoryImpl(dataSource)
    private val getNotesUseCase = GetNotesUseCase(repository)
    private val deleteNoteUseCase = DeleteNoteUseCase(repository)

    //propiedades mutables son privadas
    private val _noteListLiveData = MutableLiveData<List<NoteModel>>()
    //propiedades immutables son públicas
    val noteListLiveData: LiveData<List<NoteModel>>
        get() = _noteListLiveData

    fun onViewReady() {
        val list = getNotesUseCase.execute()
        _noteListLiveData.value = list
    }

    fun noteDeletion(id: Int) {
        deleteNoteUseCase.execute(id)
        val list = getNotesUseCase.execute()
        _noteListLiveData.value = list
    }
}