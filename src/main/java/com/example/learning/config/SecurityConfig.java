package com.example.learning.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //Request	Rule

    /// public/**	Anyone can access
    //DELETE /users/**	Requires the ADMIN role
    //Everything else	Requires authentication
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/public/**").permitAll()
                //hasRole("ADMIN") checks for the authority ROLE_ADMIN. You don’t include the ROLE_ prefix in hasRole().
                .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN").anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
