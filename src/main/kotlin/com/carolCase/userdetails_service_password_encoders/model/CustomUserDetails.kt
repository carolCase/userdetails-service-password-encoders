package com.carolCase.userdetails_service_password_encoders.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(
    private var username: String = "",
    private var password: String = "",
    private var authorities: MutableCollection<GrantedAuthority> = mutableListOf()
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return authorities
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true // Change this logic if needed
    }

    override fun isAccountNonLocked(): Boolean {
        return true // Change this logic if needed
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true // Change this logic if needed
    }

    override fun isEnabled(): Boolean {
        return true // Change this logic if needed
    }
}
