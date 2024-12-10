package com.carolCase.userdetails_service_password_encoders.model

import com.carolCase.userdetails_service_password_encoders.repository.CustomUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.Optional


// override - springs way of authenticating user
@Service
class CustomUserDetailsService(
    @Autowired val customUserRepository:CustomUserRepository
): UserDetailsService {

   override fun loadUserByUsername(username: String?): UserDetails {
       if (username == null ){
           throw NullPointerException("username is null")
       }
       val optionalUser: Optional<CustomUser> = customUserRepository.findByUsername(username)
           if (optionalUser.isPresent){
               println("username was found!")
               val user = optionalUser.get()    // customUser entity not optional anymore
               return CustomUserDetails(user.username,user.password)
           } else {
               throw UsernameNotFoundException("username was not found")
           }
}

}