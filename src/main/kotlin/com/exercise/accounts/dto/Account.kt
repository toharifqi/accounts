package com.exercise.accounts.dto

import com.exercise.accounts.entity.AccountEntity
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern

data class Account(
    @field:NotEmpty(message = "Account number can not be null or empty")
    @field:Pattern(regexp = "(^$|[0-9]{12})", message = "Account number must be 12 digits of numbers")
    val accountNumber: Long,

    @field:NotEmpty(message = "Account type can not be null or empty")
    val accountType: String,

    @field:NotEmpty(message = "Branch address can not be null or empty")
    val branchAddress: String,
) {
    constructor(accountEntity: AccountEntity): this (
        accountNumber = accountEntity.accountNumber,
        accountType = accountEntity.accountType,
        branchAddress = accountEntity.branchAddress,
    )
}
