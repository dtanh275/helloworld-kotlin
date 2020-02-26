package com.donkey.training.kotlin.realworld.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "article")
class Article : BaseEntity() {

    @Column
    var slug: String = ""

    @Column
    var title: String? = null

    @Column
    var body: String? = null

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null
}