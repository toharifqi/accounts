package com.exercise.accounts.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class AccountDetails(
    @field:NotEmpty(message = "Name can not be null or empty")
    @field:Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    val name: String,

    @field:NotEmpty(message = "Email address can not be null or empty")
    @field:Email(message = "Email address should be valid value")
    val email: String,

    @field:Pattern(regexp = "(^$|[0-9]{12})", message = "Mobile number must be 12 digits of numbers")
    val mobileNumber: String,
    
    val account: Account,
)
