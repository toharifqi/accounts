package com.exercise.accounts.dto

data class AccountDetails(
    val name: String,
    val email: String,
    val mobileNumber: String,
    val account: Account,
)
