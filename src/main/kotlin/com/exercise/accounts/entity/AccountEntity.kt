package com.exercise.accounts.entity

import com.exercise.accounts.dto.Account
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity(name = "account")
data class AccountEntity(
    val customerId: Long = 0,
    
    @Id
    val accountNumber: Long,
    
    val accountType: String,
    
    val branchAddress: String,
    
    override val createdAt: LocalDateTime,
    
    override val createdBy: String,
    
    override val updatedAt: LocalDateTime?,
    
    override val updatedBy: String?,
    
): BaseEntity {
    constructor(
        account: Account,
        createdAt: LocalDateTime,
        createdBy: String,
    ): this(
        accountNumber = account.accountNumber,
        accountType = account.accountType,
        branchAddress = account.branchAddress,
        createdAt = createdAt,
        createdBy = createdBy,
        updatedAt = null,
        updatedBy = null,
    )
}
