package com.ddangme.eatstory.config;

import com.ddangme.eatstory.dto.UserDto;
import com.ddangme.eatstory.exception.EatStoryException;
import com.ddangme.eatstory.exception.ErrorCode;
import com.ddangme.eatstory.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .mvcMatchers("/login", "/join", "/api/login", "/api/join", "/css/**", "/js/**", "/img/**").permitAll()
                        .mvcMatchers(
                                HttpMethod.POST,
                                "/api/join",
                                "/api/login"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                .logout(logout -> logout.logoutSuccessUrl("/"))
                .csrf(csrf -> csrf.ignoringAntMatchers("/api/**"))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return userId -> userService
                .searchUser(userId)
                .orElseThrow(() -> new EatStoryException(ErrorCode.USER_NOT_FOUND));
    }

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }
}
