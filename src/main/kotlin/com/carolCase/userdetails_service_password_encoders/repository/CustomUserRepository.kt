package com.carolCase.userdetails_service_password_encoders.repository

import com.carolCase.userdetails_service_password_encoders.model.CustomUser
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CustomUserRepository: JpaRepository<CustomUser, Long> {
// custom query = automatically gain a query (find by username in user table)
    //automatically converts this function to query
    fun findByUsername(username: String): Optional<CustomUser>
}