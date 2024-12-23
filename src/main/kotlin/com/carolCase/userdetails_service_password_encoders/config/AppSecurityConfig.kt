package com.carolCase.userdetails_service_password_encoders.config

import com.carolCase.userdetails_service_password_encoders.model.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity    // Enable security override
class AppSecurityConfig(
    @Autowired val passwordEncoder: PasswordEncoder,
    @Autowired val customUserDetailsService: CustomUserDetailsService) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .authorizeHttpRequests { it          //samma sak som auth -> auth (lambda uttryck)
                .requestMatchers("/", "/login","/logout", "/user", "/user/password").permitAll()
                .requestMatchers("/user/authenticated/admin").hasRole("ADMIN")
                .requestMatchers("/user/authenticated/manager").hasRole("MANAGER")
                .anyRequest().authenticated()    // resten måste vara autentiserad

            }
            .formLogin {}

        return http.build()
    }

    // Spring use our custom implementation
    @Bean
    fun customDaoAuthenticationProvider(): DaoAuthenticationProvider{
        val dao = DaoAuthenticationProvider()
        dao.setPasswordEncoder(passwordEncoder)
        dao.setUserDetailsService(customUserDetailsService)


        return dao
    }

}