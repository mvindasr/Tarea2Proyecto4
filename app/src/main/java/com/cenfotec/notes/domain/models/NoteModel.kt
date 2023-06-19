package com.cenfotec.notes.domain.models

data class NoteModel (
    val id: Int,
    val title: String,
    val description: String?,
    val tag: TagModel,
    val date: Int
)