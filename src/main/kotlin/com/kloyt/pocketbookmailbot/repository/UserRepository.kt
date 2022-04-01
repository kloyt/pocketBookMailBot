package com.kloyt.pocketbookmailbot.repository

import com.kloyt.pocketbookmailbot.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, Long> {
}