package com.cenfotec.notes.data.mappers

import com.cenfotec.notes.data.mappers.TagMapper.toTag
import com.cenfotec.notes.data.models.LocalNote
import com.cenfotec.notes.domain.models.NoteModel

object NoteMapper {

    fun LocalNote.toNote():NoteModel {
        return NoteModel(
            id = this.id,
            title = this.title,
            description = this.description,
            tag = this.tag.toTag(),
            date = this.date
        )
    }
}