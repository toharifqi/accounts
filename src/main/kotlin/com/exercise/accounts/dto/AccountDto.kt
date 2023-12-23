package com.exercise.accounts.dto

data class AccountDto(
    private val accountNumber: Long,
    private val accountType: String,
    private val branchAddress: String,
)
