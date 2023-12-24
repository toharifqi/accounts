package com.exercise.accounts.dto

import com.exercise.accounts.entity.AccountEntity

data class Account(
    val accountNumber: Long,
    val accountType: String,
    val branchAddress: String,
) {
    constructor(accountEntity: AccountEntity): this (
        accountNumber = accountEntity.accountNumber,
        accountType = accountEntity.accountType,
        branchAddress = accountEntity.branchAddress,
    )
}
