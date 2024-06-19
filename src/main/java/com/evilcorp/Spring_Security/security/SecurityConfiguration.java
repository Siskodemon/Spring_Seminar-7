package com.evilcorp.Spring_Security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .authorizeHttpRequests( registry -> registry
                        .requestMatchers("/api/resource/**").hasAnyAuthority("admin")
                        .requestMatchers("/api/resource/**").hasAnyAuthority("user")
                        .requestMatchers("/api/resource/**").authenticated()
                        .requestMatchers("/api/resource").permitAll()
                        .anyRequest().denyAll()
                )
                .formLogin(Customizer.withDefaults())
                .build();

    }
}
