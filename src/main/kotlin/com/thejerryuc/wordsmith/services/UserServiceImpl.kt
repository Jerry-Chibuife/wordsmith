package com.thejerryuc.wordsmith.services

import com.thejerryuc.wordsmith.dtos.requests.AccountCreationRequest
import com.thejerryuc.wordsmith.dtos.requests.RetrieveProfileRequest
import com.thejerryuc.wordsmith.dtos.responses.AccountCreationResponse
import com.thejerryuc.wordsmith.dtos.responses.UserProfile
import com.thejerryuc.wordsmith.exceptions.WordsmithException
import com.thejerryuc.wordsmith.models.GameStats
import com.thejerryuc.wordsmith.models.User
import com.thejerryuc.wordsmith.repositories.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var  userRepo : UserRepo

    override fun registerUser(request: AccountCreationRequest): AccountCreationResponse {
        val optionalUser: Optional<User> = userRepo.findById(request.email)
        if (optionalUser.isPresent) {
            throw WordsmithException("User already exists")
        }
        val user = User(request.email, request.userName, request.password)
        val savedUser: User = userRepo.save(user)
        return AccountCreationResponse(savedUser.getEmail(), savedUser.getUserName())
    }

    override fun retrieveUserProfile(retrievalRequest: RetrieveProfileRequest): UserProfile {

        return UserProfile("dave", "wolrde", stats = GameStats("300"))
    }


}