package com.exercise.accounts.repository

import com.exercise.accounts.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: JpaRepository<AccountEntity, Long> {
    
}
