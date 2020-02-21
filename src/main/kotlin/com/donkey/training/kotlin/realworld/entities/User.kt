package com.donkey.training.kotlin.realworld.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "user")
class User : BaseEntity() {

    @Column(name = "email", nullable = false)
    var email: String = ""

    @Column(name = "user_name")
    var userName: String? = null

    @Column
    var password: String = ""

    @Column
    var bio: String? = null

    @Column
    var avatar: String? = null

}