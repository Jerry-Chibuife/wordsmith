package com.thejerryuc.wordsmith.services

import com.thejerryuc.wordsmith.dtos.requests.AccountCreationRequest
import com.thejerryuc.wordsmith.dtos.requests.RetrieveProfileRequest
import com.thejerryuc.wordsmith.dtos.responses.AccountCreationResponse
import com.thejerryuc.wordsmith.dtos.responses.UserProfile
import com.thejerryuc.wordsmith.exceptions.WordsmithException
import com.thejerryuc.wordsmith.models.User
import com.thejerryuc.wordsmith.repositories.UserRepo
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component

@Component
@SpringBootTest
@ImportAutoConfiguration(exclude = [EmbeddedMongoAutoConfiguration::class])
internal class UserServiceImplTest{

    @Autowired
    private lateinit var userService : UserService

    @Autowired
    private lateinit var userRepo: UserRepo

    private lateinit var  request : AccountCreationRequest

    @BeforeEach
    fun beforeEachTest(){
        request = AccountCreationRequest("alex@mail.com", "The A-Team", "fighters123")
    }

    @AfterEach
    fun afterEachTest(){
        userRepo.deleteAll()
    }

    @Test
    fun userCanRegister() : Unit {
        val response: AccountCreationResponse = userService.registerUser(request)
        assertEquals(1, userRepo.count())
        assertEquals("alex@mail.com", response.email)
        assertEquals("The A-Team", response.userName)
    }

    @Test
    fun userAlreadyExists_ThrowException() {
        userService.registerUser(request)
        val exception = assertThrows(WordsmithException::class.java){
            userService.registerUser(request)
        }
        assertEquals("User already exists", exception.message)
    }

    @Test
    fun retrieveUserForProfileView(){
        val retrievalRequest: RetrieveProfileRequest = RetrieveProfileRequest(request.email)
        val userProfile: UserProfile = userService.retrieveUserProfile(retrievalRequest)
        assertEquals(request.userName, userProfile.username)
    }

}