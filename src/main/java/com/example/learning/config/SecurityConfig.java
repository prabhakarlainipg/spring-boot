package com.example.learning.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(
            PasswordEncoder passwordEncoder) {

        UserDetails reader =
                org.springframework.security.core.userdetails.User
                        .withUsername("reader")
                        .password(passwordEncoder.encode("Reader123!"))
                        .roles("USER")
                        .build();

        UserDetails admin =
                org.springframework.security.core.userdetails.User
                        .withUsername("admin")
                        .password(passwordEncoder.encode("Admin123!"))
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(reader, admin);
    }
}
