package com.exercise.accounts.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
data class Account(
    private val customerId: Long,
    
    @Id
    private val accountNumber: Long,
    
    private val accountType: String,
    
    private val branchAddress: String,
    
    override val createdAt: LocalDateTime,
    
    override val createdBy: String,
    
    override val updatedAt: LocalDateTime,
    
    override val updatedBy: String,
    
): BaseEntity
