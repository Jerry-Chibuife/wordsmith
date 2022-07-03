package com.thejerryuc.wordsmith.models



import org.springframework.data.annotation.Id
import org.springframework.lang.NonNull


data class User(
    @Id
    @NonNull
    private var email: String,
    private var userName: String,
    @NonNull
    private var password: String,
    private var highScore : String = "0"
){
    private var userEmail: String = email
    fun getEmail() : String{
        return userEmail
    }

    private var username: String = userName
    fun getUserName():String{
        return this.username
    }

    private var userPassword: String = password
    fun getPassword() : String{
        return this.userPassword
    }

    private var userHighScore: String = highScore
    fun getHighScore():String{
        return this.userHighScore
    }

}
