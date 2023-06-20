package com.cenfotec.notes.data.mappers

import com.cenfotec.notes.data.models.LocalTag
import com.cenfotec.notes.domain.models.TagModel

object TagMapper {

    fun LocalTag.toTag():TagModel = TagModel(
        id = this.id,
        title = this.title
    )

    fun TagModel.toTag():LocalTag = LocalTag(
        id = this.id,
        title = this.title
    )
}