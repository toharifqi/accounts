package com.exercise.accounts.service

import com.exercise.accounts.constant.AccountConstant
import com.exercise.accounts.dto.Customer
import com.exercise.accounts.entity.AccountEntity
import com.exercise.accounts.entity.CustomerEntity
import com.exercise.accounts.exception.CustomerAlreadyExistException
import com.exercise.accounts.repository.AccountRepository
import com.exercise.accounts.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.random.Random

interface AccountService {
    fun createAccount(customer: Customer)
}

@Service
class AccountServiceImpl(
    val accountRepository: AccountRepository,
    val customerRepository: CustomerRepository,
) : AccountService {
    override fun createAccount(customer: Customer) {
        val customerEntity = CustomerEntity(
            customer = customer,
            createdAt = LocalDateTime.now(),
            createdBy = "Anonymous",
        )
        val optionalCustomer = customerRepository.findByMobileNumber(customerEntity.mobileNumber)

        if (optionalCustomer.isPresent) {
            throw CustomerAlreadyExistException("Customer already registered with given number: ${customerEntity.mobileNumber}")
        }

        val savedCustomer = customerRepository.save(customerEntity)

        accountRepository.save(createNewAccount(savedCustomer))
    }

    private fun createNewAccount(customerEntity: CustomerEntity): AccountEntity {
        val randomAccountNumber = 1000000000L + Random.nextInt(900000000)

        val accountEntity = AccountEntity(
            customerId = customerEntity.customerId,
            accountNumber = randomAccountNumber,
            accountType = AccountConstant.SAVINGS,
            branchAddress = AccountConstant.ADDRESS,
            createdAt = LocalDateTime.now(),
            createdBy = "Anonymous",
            updatedAt = null,
            updatedBy = null,
        )

        return accountEntity
    }

}
