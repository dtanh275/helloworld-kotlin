package com.donkey.training.kotlin.realworld.api.controllers

import com.donkey.training.kotlin.realworld.api.services.ArticleService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/api/article")
@Validated
class ArticleController(private val articleService: ArticleService) {

    @GetMapping("/user/{userId}")
    fun list(@PathVariable("userId") userId: Long) = articleService.listArticleByUserId(userId)

    @GetMapping("/{slug}")
    fun detail(@PathVariable("slug") @Valid @NotBlank slug: String) = articleService.detail(slug)

}
