package com.donkey.training.kotlin.realworld.config

import com.donkey.training.kotlin.realworld.services.RealWorldUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Bean
    fun passWordEncoder(): PasswordEncoder = BCryptPasswordEncoder(8)

    override fun configure(http: HttpSecurity?) {
        http!!.csrf().disable()
                .authorizeRequests().antMatchers(("/api/user/authen")).permitAll()
                .anyRequest().authenticated()

    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

//    @Autowired
//    fun configureGlobal(auth: AuthenticationManagerBuilder, userDetailsService: RealWorldUserService) {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passWordEncoder())
//    }
}