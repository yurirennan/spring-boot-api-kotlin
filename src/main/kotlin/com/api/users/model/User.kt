package com.api.users.model

import jakarta.persistence.*

@Entity
@Table(name = "t_users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    @Column(name = "name") var name: String,
    @Column(name = "last_name") var lastName: String
)