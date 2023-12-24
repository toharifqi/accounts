package com.exercise.accounts.exception

import com.exercise.accounts.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime

@ControllerAdvice
class GlobalExceptionHandler {
    
    @ExceptionHandler(CustomerAlreadyExistException::class)
    fun handleCustomerAlreadyExistException(
        exception: CustomerAlreadyExistException,
        webRequest: WebRequest,
    ): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            webRequest.getDescription(false),
            HttpStatus.BAD_REQUEST,
            exception.responseMessage,
            LocalDateTime.now()
        )
        
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
}
