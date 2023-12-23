package com.exercise.accounts.dto

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ErrorResponseDto(
    private val apiPath: String,
    private val errorCode: HttpStatus,
    private val errorMessage: String,
    private val errorTime: LocalDateTime, 
)
