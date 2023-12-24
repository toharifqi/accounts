package com.exercise.accounts.controller

import com.exercise.accounts.constant.AccountConstant
import com.exercise.accounts.dto.Customer
import com.exercise.accounts.dto.Response
import com.exercise.accounts.service.AccountService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api"], produces = [MediaType.APPLICATION_JSON_VALUE])
@Validated
class AccountController(
    private val accountService: AccountService,
) {

    @PostMapping("/create")
    fun createAccount(
        @Valid@RequestBody customer: Customer,
    ): ResponseEntity<Response> {
        accountService.createAccount(customer)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(Response(
                statusCode = AccountConstant.STATUS_201,
                statusMessage = AccountConstant.MESSAGE_201
            ))
    }
}
