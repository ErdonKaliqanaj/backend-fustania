package com.fustania.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;  // Ky import është i saktë
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Për të mos bllokuar kërkesat POST në testim
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/dresses/**").permitAll() // ✅ Lejo vizitorët për këtë endpoint
                .anyRequest().authenticated() // Të tjerat duan login
            )
            .httpBasic(Customizer.withDefaults());  // Mënyra e re për httpBasic

        return http.build();
    }
}
