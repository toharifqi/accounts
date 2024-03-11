package com.exercise.accounts.dto

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "accounts")
data class AccountsContactInfo(
    val message: String,
    val contactDetails: Map<String, String>,
    val onCallSupport: List<String>
)
