package com.donkey.training.kotlin.realworld.config

import com.donkey.training.kotlin.realworld.services.JwtTokenFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class WebSecurityConfig(private val jwtTokenFilter: JwtTokenFilter)
    : WebSecurityConfigurerAdapter() {

    @Bean
    fun passWordEncoder(): PasswordEncoder = BCryptPasswordEncoder(8)

    override fun configure(http: HttpSecurity?) {
        http!!.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/user/authen").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)

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