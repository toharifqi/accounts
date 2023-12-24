package com.exercise.accounts.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
interface BaseEntity {
    @get:Column(updatable = false)
    val createdAt: LocalDateTime 

    @get:Column(updatable = false)
    val createdBy: String

    @get:Column(insertable = false)
    val updatedAt: LocalDateTime?

    @get:Column(insertable = false)
    val updatedBy: String?
}
