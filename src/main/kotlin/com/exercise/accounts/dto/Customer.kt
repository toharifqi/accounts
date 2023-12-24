package com.exercise.accounts.dto

import com.exercise.accounts.entity.CustomerEntity

data class Customer(
    val name: String,
    val email: String,
    val mobileNumber: String,
) {
    constructor(customerEntity: CustomerEntity): this(
        name = customerEntity.name,
        email = customerEntity.email,
        mobileNumber = customerEntity.mobileNumber,
    )
}
