package com.donkey.training.kotlin.realworld.repositories

import com.donkey.training.kotlin.realworld.entities.Article
import org.springframework.data.repository.Repository

interface ArticleRepository : Repository<Article, Long> {

}