package com.thejerryuc.wordsmith.repositories

import com.thejerryuc.wordsmith.models.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepo : MongoRepository<User, String> {
}