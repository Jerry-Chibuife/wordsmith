package com.thejerryuc.wordsmith.dtos.responses

import com.thejerryuc.wordsmith.models.GameStats

class UserProfile(
    val username: String,
    val email: String,
    val stats: GameStats
) {

}
