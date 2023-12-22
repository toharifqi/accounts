package com.exercise.accounts.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController  {
    
    @GetMapping("sayHello")
    fun sayHello(): String {
        return "Hi world! "
    }
}
