package com.donkey.training.kotlin.realworld.api.data

import java.time.LocalDateTime

data class ArticleData(
        var id: Long,
        var slug: String,
        var title: String?,
        var body: String?,
        var createdAt: LocalDateTime,
        var updatedAt: LocalDateTime
)