package com.ddangme.eatstory.config;

import com.ddangme.eatstory.dto.UserPrincipal;
import com.ddangme.eatstory.exception.EatStoryException;
import com.ddangme.eatstory.exception.ErrorCode;
import com.ddangme.eatstory.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .mvcMatchers( "/sign-up", "/css/**", "/js/**", "/img/**", "/").permitAll()
                        .mvcMatchers(
                                HttpMethod.POST,
                                "/sign-up"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .logout(logout -> logout.logoutSuccessUrl("/"))
                .csrf(csrf -> csrf.ignoringAntMatchers("/sign-up"))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return userId -> userService
                .searchUser(userId)
                .map(UserPrincipal::fromDto)
                .orElseThrow(() -> new EatStoryException(ErrorCode.USER_NOT_FOUND));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
