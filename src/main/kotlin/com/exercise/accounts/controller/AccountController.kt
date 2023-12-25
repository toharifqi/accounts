package com.exercise.accounts.controller

import com.exercise.accounts.constant.AccountConstant
import com.exercise.accounts.dto.AccountDetails
import com.exercise.accounts.dto.Customer
import com.exercise.accounts.dto.Response
import com.exercise.accounts.service.AccountService
import jakarta.validation.Valid
import jakarta.validation.constraints.Pattern
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api"], produces = [MediaType.APPLICATION_JSON_VALUE])
@Validated
class AccountController(
    private val accountService: AccountService,
) {

    @PostMapping("/create")
    fun createAccount(
        @RequestBody @Valid customer: Customer,
    ): ResponseEntity<Response> {
        accountService.createAccount(customer)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(Response(
                statusCode = AccountConstant.STATUS_201,
                statusMessage = AccountConstant.MESSAGE_201
            ))
    }
    
    @GetMapping("/fetch")
    fun fetchAccountDetails(
        @RequestParam
        @Pattern(regexp = "(^$|[0-9]{12})", message = "Mobile number must be 12 digits")
        mobileNumber: String
    ): ResponseEntity<AccountDetails> {
        val accountDetails = accountService.fetchAccount(mobileNumber)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(accountDetails)
    }
    
    @PutMapping("/update")
    fun updateAccountDetails(
        @Valid @RequestBody accountDetails: AccountDetails
    ): ResponseEntity<Response> {
        val isUpdated = accountService.updateAccountDetails(accountDetails)
        return if (isUpdated) {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(Response(
                    statusCode = AccountConstant.STATUS_200,
                    statusMessage = AccountConstant.MESSAGE_200
                ))
        } else {
            ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Response(
                    statusCode = AccountConstant.STATUS_500,
                    statusMessage = AccountConstant.MESSAGE_500
                ))
        }
    }
    
    @DeleteMapping("/delete")
    fun deleteAccountDetails(
        @RequestParam
        @Pattern(regexp = "(^$|[0-9]{12})", message = "Mobile number must be 12 digits")
        mobileNumber: String
    ): ResponseEntity<Response> {
        val isDeleted = accountService.deleteAccount(mobileNumber)
        return if (isDeleted) {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(Response(
                    statusCode = AccountConstant.STATUS_200,
                    statusMessage = AccountConstant.MESSAGE_200
                ))
        } else {
            ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Response(
                    statusCode = AccountConstant.STATUS_500,
                    statusMessage = AccountConstant.MESSAGE_500
                ))
        }
    }
}
