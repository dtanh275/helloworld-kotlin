package com.donkey.training.kotlin.realworld.repositories

import com.donkey.training.kotlin.realworld.entities.Article
import org.springframework.data.repository.Repository

interface ArticleRepository : Repository<Article, Long> {

    fun findAllByUserId(userId: Long): Collection<Article>

    fun findBySlug(slug: String): Article?
}