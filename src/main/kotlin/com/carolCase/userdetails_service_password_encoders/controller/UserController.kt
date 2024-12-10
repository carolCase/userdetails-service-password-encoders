package com.carolCase.userdetails_service_password_encoders.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {

    @GetMapping("authenticated/admin")
    fun nonUserTest(): String {
        return "can admin access this endpoints?"
    }
    @GetMapping("/authenticated/manager")
    fun userTest(): String {
        return "can manager access this endpoints?"
    }

}