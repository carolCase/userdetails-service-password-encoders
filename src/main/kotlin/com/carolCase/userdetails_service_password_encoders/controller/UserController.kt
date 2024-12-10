package com.carolCase.userdetails_service_password_encoders.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    @Autowired val passwordEncoder: PasswordEncoder
){

    @GetMapping("/password")    //Bcrypt password (because of @configuration and @Bean)
    fun passwordEncoderTest(@RequestParam(defaultValue = "123") password: String): String{
        return "password is: ${passwordEncoder.encode(password)}"
    }

    @GetMapping("authenticated/admin")
    fun nonUserTest(): String {
        return "can admin access this endpoints?"
    }
    @GetMapping("/authenticated/manager")
    fun userTest(): String {
        return "can manager access this endpoints?"
    }

}