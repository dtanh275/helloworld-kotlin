package com.donkey.training.kotlin.realworld.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "user")
class User: BaseEntity() {

    @Column
    var email: String? = null

    @Column(name = "user_name")
    var userName: String? = null

    @Column
    var password: String? = null

    @Column
    var bio: String? = null

    @Column
    var avatar: String? = null

}