package com.exercise.accounts.entity

import com.exercise.accounts.dto.Customer
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity(name = "customer")
data class CustomerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    val customerId: Long = 0,
    
    val name: String,
    
    val email: String,
    
    val mobileNumber: String,
    
    override val createdAt: LocalDateTime,
    
    override val createdBy: String,
    
    override val updatedAt: LocalDateTime?,
    
    override val updatedBy: String?,
    
) : BaseEntity {
    constructor(
        customer: Customer,
        createdAt: LocalDateTime,
        createdBy: String,
    ) : this(
        name = customer.name,
        email = customer.email,
        mobileNumber = customer.mobileNumber,
        createdAt = createdAt,
        createdBy = createdBy,
        updatedAt = null,
        updatedBy = null,
    )
}
