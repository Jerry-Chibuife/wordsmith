package com.thejerryuc.wordsmith.services

import com.thejerryuc.wordsmith.dtos.requests.AccountCreationRequest
import com.thejerryuc.wordsmith.dtos.requests.RetrieveProfileRequest
import com.thejerryuc.wordsmith.dtos.responses.AccountCreationResponse
import com.thejerryuc.wordsmith.dtos.responses.UserProfile
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun registerUser(request: AccountCreationRequest): AccountCreationResponse
    fun retrieveUserProfile(retrievalRequest: RetrieveProfileRequest): UserProfile
}