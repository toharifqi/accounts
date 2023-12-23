package com.exercise.accounts.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private val customerId: Long,
    
    private val name: String,
    
    private val email: String,
    
    private val mobileNumber: String,
    
    override val createdAt: LocalDateTime,
    
    override val createdBy: String,
    
    override val updatedAt: LocalDateTime,
    
    override val updatedBy: String,
    
): BaseEntity
