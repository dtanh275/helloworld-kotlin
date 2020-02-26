package com.donkey.training.kotlin.realworld.api.services

import com.donkey.training.kotlin.realworld.api.data.ArticleData
import com.donkey.training.kotlin.realworld.api.exceptions.InvalidRequestException
import com.donkey.training.kotlin.realworld.repositories.ArticleRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ArticleService(private val articleRepository: ArticleRepository) {

    fun listArticleByUserId(userId: Long) =
            articleRepository.findAllByUserId(userId)
                    .stream()
                    .map { a ->
                        ArticleData(a.id!!,
                                a.slug,
                                a.title,
                                a.body,
                                a.createdAt,
                                a.updatedAt)
                    }
                    .collect(Collectors.toList())

    fun detail(slug: String): ArticleData {
        var a = articleRepository.findBySlug(slug) ?: throw InvalidRequestException("slug[$slug] not found")

        return ArticleData(a.id!!,
                a.slug,
                a.title,
                a.body,
                a.createdAt,
                a.updatedAt)
    }

}