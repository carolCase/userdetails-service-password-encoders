package com.carolCase.userdetails_service_password_encoders.controller

import com.carolCase.userdetails_service_password_encoders.model.CustomUser
import com.carolCase.userdetails_service_password_encoders.repository.CustomUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    @Autowired private val customUserRepository: CustomUserRepository,
    @Autowired private val passwordEncoder: PasswordEncoder
) {

    @PostMapping
    fun saveUser(@RequestBody customUser: CustomUser): String {
        // Encode the user's password before saving
        customUser.password = passwordEncoder.encode(customUser.password)
        customUserRepository.save(customUser)
        return "User saved successfully!"
    }
}
