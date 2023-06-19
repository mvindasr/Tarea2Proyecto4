package com.cenfotec.notes.data.models


data class LocalNote (
    val id: Int,
    val title: String,
    val description: String?,
    val tag: LocalTag,
    val date: Int
)
