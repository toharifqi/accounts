package com.exercise.accounts.dto

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ErrorResponse(
    val apiPath: String,
    val errorCode: HttpStatus,
    val errorMessage: String,
    val errorTime: LocalDateTime, 
)
